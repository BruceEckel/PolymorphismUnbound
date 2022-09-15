//: src/scala/EnumeratedDataTypes.scala
// Enumerated Data Types
package enumtypes
import EnumType.*

enum EnumType:
    case Dog, Person, Robot, Slug
    def eat() = this match
        case Dog => println("eating dog food")
        case Person => println("eating pizza")
        case Robot => println("charging")
        case Slug => println("eating grass")
    def speak() = this match
        case Dog => println("woof")
        case Person => println("hello")
        case Robot => println("operational")
        case Slug => ()
//---
def nourish(x: EnumType): Unit =
    x.eat()
    x.speak()

@main def main() =
    List(Dog, Person, Robot, Slug).foreach(nourish(_))
