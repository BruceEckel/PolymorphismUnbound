//: src/java/src/AdHoc.java
class Person {
  void consume() { System.out.println("eating pizza"); }
}

class Robot {
  void charge() { System.out.println("charging"); }
}

public class AdHoc { // Overloading:
  static void nourish(Person subject) {
    subject.consume();
  }
  static void nourish(Robot subject) {
    subject.charge();
  }
  public static void main(String... args) {
    nourish(new Person());  // Determined at compile time
    nourish(new Robot());
  }
}