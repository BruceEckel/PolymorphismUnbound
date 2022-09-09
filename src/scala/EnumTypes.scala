//: src/scala/EnumTypes.scala
// Enumerated Data Types
package enumtypes
import EnumType.*

enum EnumType:
    case Dog, Person, Robot, Slug
    def consume() = this match
        case Dog => println("eating dog food")
        case Person => println("eating pizza")
        case Robot => println("charging")
        case Slug => println("eating grass")
    def communicate() = this match
        case Dog => println("woof")
        case Person => println("hello")
        case Robot => println("operational")
        case Slug => ()

def poly(x: EnumType): Unit =
    x.consume()
    x.communicate()

@main def main() =
    List(Dog, Person, Robot, Slug).foreach(poly(_))
