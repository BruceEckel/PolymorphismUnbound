//: src/java/src/Generics.java
// {NewFeature} Preview in JDK 17
// Compile with javac flags:
//   --enable-preview --source 17
import java.util.List;

public class Generics {
  static <T> T nourish(T x) {
    // x.consume(); // Nope
    switch(x) {
      case Person p -> p.consume();
      case Robot r -> r.charge();
      default -> throw new IllegalStateException("Unexpected: " + x);
    }
    return x;
  }
  static Object nourish2(Object x) {
    switch(x) {
      case Person p -> p.consume();
      case Robot r -> r.charge();
      default -> throw new IllegalStateException("Unexpected: " + x);
    }
    return x;
  }
  //---
  public static void main(String... args) {
    List.of(new Person(), new Robot()).forEach(Generics::nourish);
    Person p = nourish(new Person());
    Object p2 = nourish2(new Person());
  }
}