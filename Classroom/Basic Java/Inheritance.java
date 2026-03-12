class A {
    static {
        System.out.println("A:static block");
    }
    
    {
        System.out.println("A:instance initializer");
    }
    int a=10;
    static int b=20;
    
   public A() {
        System.out.println("A:constructor");
    }

   public void show() {
       System.out.println("a=" + a + ", b = "+b);
   }

   public static void staticShow() { // static method
       System.out.println("A : staticShow() method, b = " + b);
   }

   public static void main(String[] args) {
       System.out.println("Creating B object...");

       B obj = new B(); // create B object

       System.out.println("\nAccessing inherited members:");
       obj.show();             // inherited non-static method
       System.out.println("Inherited instance variable a = " + obj.a);
       B.staticShow();         // inherited static method (accessible)
       System.out.println("Inherited static variable b = " + B.b);

       obj.display();          // B's own method
       System.out.println("B's instance variable x = " + obj.x);
       System.out.println("B's static variable y = " + B.y);
   }
}

class B extends A {

   static { // static initializer
       System.out.println("B : static block");
   }

   { // non-static (instance) initializer
       System.out.println("B : instance block");
   }

   int x = 30;          // instance variable
   static int y = 40;   // static variable

   public B() { // constructor
       System.out.println("B : constructor");
   }

   public void display() { // non-static method
       System.out.println("B : display() method, x = " + x + ", y = " + y);
   }

   public static void staticDisplay() { // static method
       System.out.println("B : staticDisplay() method, y = " + y);
   }
}
