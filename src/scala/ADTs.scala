// src/scala/ADTs.scala
// Algebraic Data Types
package adts
import ADT._

enum ADT:
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

def poly(x: ADT): Unit =
    x.consume()
    x.communicate()

@main def main() =
    List(Dog, Person, Robot, Slug).foreach(poly(_))
