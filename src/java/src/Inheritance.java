//: src/java/src/Inheritance.java
package inheritance;
import java.util.stream.*;

abstract class Base {
  abstract void eat();
  abstract void speak();
}

class Dog extends Base {
  @Override
  void eat() {
    System.out.println("eating dog food");
  }
  @Override
  void speak() {
    System.out.println("woof");
  }
}

class Person extends Base {
  @Override
  void eat() {
    System.out.println("eating pizza");
  }
  @Override
  void speak() {
    System.out.println("hello");
  }
}

class Robot extends Base {
  @Override
  void eat() {
    System.out.println("charging");
  }
  @Override
  void speak() {
    System.out.println("operational");
  }
}

class Slug extends Base {
  @Override
  void eat() {
    System.out.println("eating grass");
  }
  @Override
  void speak() {
  }
}

public class Inheritance {
  static void nourish(Base subject) {
    subject.eat();
    subject.speak();
  }
  public static void main(String... args) {
    Stream.of(
        new Dog(), new Person(), new Robot(), new Slug()
    ).forEach(Inheritance::nourish);
  }
}