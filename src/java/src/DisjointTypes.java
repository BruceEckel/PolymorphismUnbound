//: src/java/src/DisjointTypes.java

class Dog {
  void gulp() {
    System.out.println("eating dog food");
  }
  void bark() {
    System.out.println("woof");
  }
}

class Person {
  void scarf() {
    System.out.println("eating pizza");
  }
  void greet() {
    System.out.println("hello");
  }
}
//---
class Robot {
  void charge() {
    System.out.println("charging");
  }
  void initiate() {
    System.out.println("operational");
  }
}

class Slug {
  void absorb() {
    System.out.println("eating grass");
  }
}
//---
public class DisjointTypes {
  static void nourish(Dog subject) {
    subject.gulp();
    subject.bark();
  }
  static void nourish(Person subject) {
    subject.scarf();
    subject.greet();
  }
  static void nourish(Robot subject) {
    subject.charge();
    subject.initiate();
  }
//---
  static void nourish(Slug subject) {
    subject.absorb();
  }
  public static void main(String... args) {
    // Ad-hoc polymorphism (overloading):
    nourish(new Dog());
    nourish(new Person());
    nourish(new Robot());
    nourish(new Slug());
    // (Statically determined at compile time)
  }
}