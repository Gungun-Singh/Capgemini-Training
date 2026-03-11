
public class encapsulation {
    			//ENCAPSULATION      ->       sensitive data is hidden from users.

private String name;             // restricted access

 Getter
public String getName(){
    return name;
}

// Setter
public void setName(String newName){
    this.name=newName;
}
}
}


private int age;

  public int getAge(){
  return age;                       //lets other class read age...can be accessed from anywhere
}
  public void setAge(int age){
  if(age >0){
      this.age= age;
  }else{
      System.out.println("Age must be positive");      //prevents invalid data from being set
  }
}
  
  
  public static void main(String[] args) {
      encapsulation obj = new encapsulation();
      obj.setAge(-10);   
  }
}



