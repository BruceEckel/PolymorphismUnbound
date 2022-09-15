//: src/java/src/MultipleInheritance.java
import java.util.stream.Stream;

interface Base {
  void eat();
  default void speak() {};
}

class Dog2 extends Dog implements Base {
  @Override
  public void eat() { super.eat(); }
  @Override
  public void speak() { super.bark(); }
}
//---
class Person2 extends Person implements Base {
  @Override
  public void eat() {
    super.scarf();
  }
  @Override
  public void speak() {
    super.greet();
  }
}

class Robot2 extends Robot implements Base {
  @Override
  public void eat() {
    super.charge();
  }
  @Override
  public void speak() {
    super.initiate();
  }
}
//---
class Slug2 extends Slug implements Base {
  @Override
  public void eat() {
    super.absorb();
  }
}

public class MultipleInheritance {
  static void nourish(Base subject) {
    subject.eat();
    subject.speak();
  }
  public static void main(String... args) {
    Stream.of(
        new Dog2(), new Person2(), new Robot2(), new Slug2()
    ).forEach(MultipleInheritance::nourish);
  }
}