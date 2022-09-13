// src/java/src/PatternMatching.java
// {NewFeature} Preview in JDK 17
// Compile with javac flags:
//   --enable-preview --source 17
import java.util.List;

class Hedgehog {
  void groom() {}
  void walk() {}
}

class Fish {
  void feed() {}
  void changeWater() {}
}

public class PatternMatching {
  static void careFor(Object p) {
    switch(p) { // Exhaustive except for Null
      case Hedgehog d -> {
        d.groom();
        d.walk();
      }
      case Fish f -> {
        f.feed();
        f.changeWater();
      }
      // case null -> {} // Not required
      case default -> {}
    };
  }
  public static void main(String... args) {
    List.of(new Hedgehog(), new Fish())
        .forEach(PatternMatching::careFor);
  }
}
