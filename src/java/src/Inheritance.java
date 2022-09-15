//: src/java/src/Inheritance.java
package inheritance;
import java.util.List;

interface Base {
  void eat();
  void speak();
}

class Dog implements Base {
  @Override
  public void eat() { System.out.println("eating dog food"); }
  @Override
  public void speak() { System.out.println("woof"); }
}
//---
class Person implements Base {
  @Override
  public void eat() {
    System.out.println("eating pizza");
  }
  @Override
  public void speak() {
    System.out.println("hello");
  }
}

class Robot implements Base {
  @Override
  public void eat() {
    System.out.println("charging");
  }
  @Override
  public void speak() {
    System.out.println("operational");
  }
}
//---
class Slug implements Base {
  @Override
  public void eat() {
    System.out.println("eating grass");
  }
  @Override
  public void speak() {
  }
}

public class Inheritance {
  static void nourish(Base subject) {
    subject.eat();
    subject.speak();
  }
  public static void main(String... args) {
    List.of(
        new Dog(), new Person(), new Robot(), new Slug()
    ).forEach(Inheritance::nourish);
  }
}