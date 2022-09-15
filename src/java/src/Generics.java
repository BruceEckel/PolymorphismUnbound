//: src/java/src/Generics.java
package generics;

class Holder<T> {
  private T value = null;
  void set(T x) { value = x;}
  T get() { return value; }
}

interface Base {
  void speak();
}

class Dog implements Base {
  @Override
  public void speak() {
    System.out.println("woof");
  }
}
//---
class Person implements Base {
  @Override
  public void speak() {
    System.out.println("hello");
  }
}

public class Generics {
  public static void main(String... args) {
    var dogHolder = new Holder<Dog>();
    dogHolder.set(new Dog());
    Dog d = dogHolder.get();
    var baseHolder = new Holder<Base>();
    baseHolder.set(new Dog());
    baseHolder.set(new Person());
    // Person p = baseHolder.get();  // Nope
    Base b = baseHolder.get();
    // Need to add variance here...
  }
}
