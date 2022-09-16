//: src/kotlin/src/main/kotlin/Generics2.java
// {NewFeature} Preview in JDK 17
// Compile with javac flags:
//   --enable-preview --source 17
import java.util.List;

public class Generics2 {
  static <T> T nourish(T subject) {
    switch(subject) {
      case Dog d -> {
        d.gulp();
        d.bark();
      }
      case Person p ->{
        p.scarf();
        p.greet();
      }
      case Robot r ->{
        r.charge();
        r.initiate();
      }
      case Slug s ->{
        s.absorb();
      }
      default -> throw new IllegalStateException("Unexpected value: " + subject);
    }
    return subject;
  }
  //---
  public static void main(String... args) {
    List.of(
        new Dog(), new Person(), new Robot(), new Slug()
    ).forEach(Generics2::nourish);
    Dog d = nourish(new Dog());
  }
}