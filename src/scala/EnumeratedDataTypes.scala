//: src/scala/EnumeratedDataTypes.scala
// Enumerated Data Types
package enumtypes
import EnumType.*

enum EnumType:
    case Person, Robot
    def eat() = this match
        case Person => println("eating pizza")
        case Robot => println("charging")

def nourish(x: EnumType): Unit =
    x.eat()

@main def main() = List(Person, Robot).foreach(nourish)
