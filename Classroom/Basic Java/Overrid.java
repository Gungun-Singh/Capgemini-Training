class Apple{
	public void M1() {
		System.out.println("1");
	}
	public void M2() {
		System.out.println("2");
	}
}

	class Bat extends Apple{
		public void M1() {
			System.out.println("Good morning");
		}
		
	}

public class overrid {
	public static void main(String[] args) {
		Apple obj = new Bat();
		obj.M1();
		obj.M2();
	}
}


						//NON-PRIMITIVE TYPE CASTING
class Animal {
    void eat() {
        System.out.println("Animal eats");
    }
}
class Dog extends Animal {
    void bark() {
        System.out.println("Dog barks");
    }
}

public class overrid{
    public static void main(String[] args) {
        Animal a = new Dog();
        a.eat();              

//        Dog d = (Dog) a;      
//        d.bark();           
      
        
        if (a instanceof Dog) {
            Dog d = (Dog) a;  
            d.bark();          
        } else {
            System.out.println("The object is not a Dog");
        }
        }
}



