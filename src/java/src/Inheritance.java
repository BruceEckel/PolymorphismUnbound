//: src/java/src/Inheritance.java
package inheritance;
import java.util.List;

interface Base {
  void eat();
}

class Person implements Base {
  @Override
  public void eat() { System.out.println("eating pizza"); }
}

class Robot implements Base {
  @Override
  public void eat() { System.out.println("charging"); }
}

public class Inheritance {
  static void nourish(Base subject) {
    subject.eat();
  }
  public static void main(String... args) {
    List.of(new Person(), new Robot()).forEach(Inheritance::nourish);
  }
}