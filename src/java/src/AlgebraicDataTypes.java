
import java.util.List;

// Java 19 preview features: sealed classes, records, pattern matching
//
// javac --release 19 --enable-preview AlgebraicDataTypes.java
// java --enable-preview AlgebraicDataTypes
//
// see Brian Goetz - https://www.infoq.com/articles/data-oriented-programming-java/

sealed interface ADT {
    record Person(String eats) implements ADT {}
    record Robot(String chargesWith) implements ADT {}
}

public class AlgebraicDataTypes  {
    void nourishes(ADT x) {
        switch (x) {
            // exhaustive
            case ADT.Person(String eats) -> System.out.println("TRACER person eats: " + eats);
            case ADT.Robot(String chargesWith) -> System.out.println("TRACER robot charging: " + chargesWith);
        }
    }

    public static void main(String [] args) {
        var adts = new AlgebraicDataTypes();
        List.of(new ADT.Person("2 apples"), new ADT.Robot("5 volts")).stream().forEach(adts::nourishes);
    }
}
