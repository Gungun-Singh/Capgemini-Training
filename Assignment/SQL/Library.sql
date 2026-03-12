DROP TABLE IF EXISTS loans CASCADE;
DROP TABLE IF EXISTS books CASCADE;
DROP TABLE IF EXISTS authors CASCADE;
DROP TABLE IF EXISTS genres CASCADE;
DROP TABLE IF EXISTS users CASCADE;



-- ==========================================
-- AUTHORS TABLE
-- ==========================================
CREATE TABLE authors (
    author_id INT PRIMARY KEY,
    author_name VARCHAR(100) NOT NULL,
    state VARCHAR(50)
);

-- ==========================================
-- GENRES TABLE
-- ==========================================
CREATE TABLE genres (
    genre_id INT PRIMARY KEY,
    genre_name VARCHAR(100) NOT NULL
);

-- ==========================================
-- USERS TABLE
-- ==========================================
CREATE TABLE users (
    user_id INT PRIMARY KEY,
    user_name VARCHAR(100) NOT NULL,
    phno VARCHAR(15),
    email VARCHAR(100) UNIQUE
);

-- ==========================================
-- BOOKS TABLE
-- ==========================================
CREATE TABLE books (
    book_id INT PRIMARY KEY,
    title VARCHAR(150) NOT NULL,
    author_id INT REFERENCES authors(author_id),
    genre_id INT REFERENCES genres(genre_id)
);

-- ==========================================
-- LOANS TABLE
-- ==========================================
CREATE TABLE loans (
    loan_id INT PRIMARY KEY,
    user_id INT REFERENCES users(user_id),
    book_id INT REFERENCES books(book_id),
    borrowed_date DATE NOT NULL,
    return_date DATE
);

-- ==========================================
-- INSERT AUTHORS (10)
-- ==========================================
INSERT INTO authors VALUES
(1, 'Robert Martin', 'Texas'),
(2, 'J.K. Rowling', 'UK'),
(3, 'Chetan Bhagat', 'Delhi'),
(4, 'R.K. Narayan', 'Tamil Nadu'),
(5, 'George Orwell', 'UK'),
(6, 'Dan Brown', 'USA'),
(7, 'Paulo Coelho', 'Brazil'),
(8, 'Agatha Christie', 'UK'),
(9, 'Stephen King', 'USA'),
(10, 'New Author', 'Unknown');  -- No Books

-- ==========================================
-- INSERT GENRES (10)
-- ==========================================
INSERT INTO genres VALUES
(1, 'Programming'),
(2, 'Fantasy'),
(3, 'Fiction'),
(4, 'Classic'),
(5, 'Thriller'),
(6, 'Mystery'),
(7, 'Romance'),
(8, 'Horror'),
(9, 'Drama'),
(10, 'Biography');

-- ==========================================
-- INSERT USERS (10)
-- ==========================================
INSERT INTO users VALUES
(1, 'Aniket', '9876543210', 'aniket@gmail.com'),
(2, 'Rahul', '9876501234', 'rahul@gmail.com'),
(3, 'Priya', '9123456789', 'priya@gmail.com'),
(4, 'Amit', '9012345678', 'amit@gmail.com'),
(5, 'Neha', '9988776655', 'neha@gmail.com'),
(6, 'Rohit', '9090909090', 'rohit@gmail.com'),
(7, 'Kiran', '9871234567', 'kiran@gmail.com'),
(8, 'Meena', '9123987654', 'meena@gmail.com'),
(9, 'Vikas', '9898989898', 'vikas@gmail.com'),
(10, 'Unused User', '9000000000', 'unused@gmail.com'); -- No Loans

-- ==========================================
-- INSERT BOOKS (10)
-- ==========================================
INSERT INTO books VALUES
(1, 'SQL', 1, 1),
(2, 'Clean Code', 1, 1),           -- Robert Martin (Multiple Books)
(3, 'Harry Potter 1', 2, 2),
(4, 'Harry Potter 2', 2, 2),       -- Rowling (Multiple Books)
(5, '2 States', 3, 3),
(6, 'Malgudi Days', 4, 4),
(7, '1984', 5, 3),
(8, 'Da Vinci Code', 6, 5),
(9, 'The Alchemist', 7, 3),
(10, 'Murder on Orient Express', 8, 6);

-- Authors 9 and 10 have NO books

-- ==========================================
-- INSERT LOANS (10)
-- ==========================================
INSERT INTO loans VALUES
(1, 1, 1, '2025-01-10', '2025-01-20'),
(2, 1, 2, '2025-02-01', NULL),          -- Aniket (Multiple Loans)
(3, 2, 3, '2025-02-05', NULL),
(4, 3, 4, '2025-02-07', '2025-02-15'),
(5, 4, 5, '2025-02-10', NULL),
(6, 5, 6, '2025-02-11', NULL),
(7, 6, 7, '2025-02-12', NULL),
(8, 7, 8, '2025-02-13', NULL),
(9, 8, 9, '2025-02-14', NULL),
(10, 9, 10, '2025-02-15', NULL);

-- User 10 has NO loans
-- User 1 has multiple loans


select * from authors;

select * from genres;

select * from books;

select * from loans;

select * from users;


-- AUTHORS	(author_id,author_name,state)
-- BOOKS	(book_id, title,author_id,genre_id)
-- GENRES	(genre_id,genre_name)
-- LOANS	(loan_id,user_id,book_id,borrowed_date,return_date)
-- USERS	(user_id,user_name,phnno, email)

-- display no. of books borrowed by each user with username
select count(*) , user_name
from loans inner join users
on loans.user_id = users.user_id
group by users.user_name;

-- display title of book and author name 
select title, author_name
from books inner join authors
on books.author_id = authors.author_id;


-- title and genres filtering by genre Fiction
select title, genre_name
from books b inner join genres g
on b.genre_id = g.genre_id
where genre_name = 'Fiction';


-- display all users details who have borrw book with title 1984
-- join
select u.*
from users u inner join loans l
on u.user_id =l.user_id
inner join books b
on l.book_id =b.book_id
where b.title ='1984';



-- or
select * from users
where user_id in (select user_id
    from loans
    where book_id=(
        select book_id
        from books
        where title='1984')
);


-- users detail who borrowed the max no. of books
select u.* 
from users u inner join loans l
on u.user_id = l.user_id
group by u.user_id, u.user_name, u.phno, u.email
order by count(l.book_id) desc
limit 1;



select u.* 
from loans l , users u
where u.user_id = l.user_id
group by u.user_id, u.user_name
having count(*) in (select max(no_of_times)
					from(
					select count(*) no_of_times , user_name
					from loans inner join users
					on loans.user_ id = users.user_id
					group by users.user_name)t1);



-- display most borrowed book title
select b.title 
from books b inner join loans l
on b.book_id = l.book_id
group by b.title
order by count(l.book_id) desc
limit 1;

-- or

select b.title 
from books b inner join loans l
on b.book_id = l.book_id
group by b.title
having count(l.book_id)= (
		select max(cnt) from (
			select count(book_id) as cnt
			from loans
			group by book_id
		) temp
);


-- display authors whose book never been borrowed

select a.*
from authors a left join books b
on a.author_id = b.author_id
left join loans l
on b.book_id = l.book_id
where l.book_id is null;
