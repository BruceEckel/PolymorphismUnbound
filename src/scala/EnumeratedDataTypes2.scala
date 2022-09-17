//: src/scala/EnumeratedDataTypes2.scala
package enumtypes2
import EnumType.*

enum EnumType(food: String):
    case Person extends EnumType("eating pizza")
    case Robot extends EnumType("charging")
    def eat() = println(food)

def nourish(x: EnumType): Unit =
    x.eat()

@main def main() = List(Person, Robot).foreach(nourish)
