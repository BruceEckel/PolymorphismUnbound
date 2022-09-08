// src/java/src/DisjointTypes.java
import java.util.stream.*;

class Dog {
  void eat() {
    System.out.println("eating dog food");
  }
  void bark() {
    System.out.println("woof");
  }
}

class Person {
  void eat() {
    System.out.println("eating pizza");
  }
  void greet() {
    System.out.println("hello");
  }
}

class Robot {
  void eat() {
    System.out.println("charging");
  }
  void initiate() {
    System.out.println("operational");
  }
}

class Slug {
  void eat() {
    System.out.println("eating grass");
  }
}

public class DisjointTypes {
  static void nourish(Dog subject) {
    subject.eat();
    subject.bark();
  }
  static void nourish(Person subject) {
    subject.eat();
    subject.greet();
  }
  static void nourish(Robot subject) {
    subject.eat();
    subject.initiate();
  }
  static void nourish(Slug subject) {
    subject.eat();
  }
  public static void main(String... args) {
    // Ad-hoc polymorphism (overloading):
    nourish(new Dog());
    nourish(new Person());
    nourish(new Robot());
    nourish(new Slug());
    // But you cannot do this:
//    Stream.of(
//      new Dog(), new Person(), new Robot(), new Slug()
//    ).forEach(DisjointTypes::nourish);
    // It would have to figure out what overloaded version
    // to call at runtime, a.k.a. dynamic binding
  }
}