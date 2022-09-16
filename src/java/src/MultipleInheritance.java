//: src/java/src/MultipleInheritance.java
import java.util.List;

interface Base {
  void eat();
}

class Person2 extends Person implements Base {
  @Override public void eat() { consume(); }
}

class Robot2 extends Robot implements Base {
  @Override public void eat() { charge(); }
}

public class MultipleInheritance {
  static void nourish(Base subject) { subject.eat();  }
  public static void main(String... args) {
    List.of(new Person2(), new Robot2())
        .forEach(MultipleInheritance::nourish);
  }
}