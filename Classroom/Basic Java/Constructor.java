
 class constructor {
	 constructor() {
	        this(10);
	        System.out.println("Default constructor");
	    }

	    constructor(int x) {
	        this(20, 30);
	        System.out.println("One-parameter constructor");
	    }

	    constructor(int x, int y) {
	        System.out.println("Two-parameter constructor");
	    }

	    public static void main(String[] args) {
	        constructor obj = new constructor();
	    }
}
