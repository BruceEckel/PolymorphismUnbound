// src/scala/EnumTypes2.scala
// Enumerated Data Types
package enumtypes2
import EnumType._

enum EnumType(eat: String, talk: String):
    case Dog extends EnumType("eating dog food", "woof")
    case Person extends EnumType("eating pizza", "hello")
    case Robot extends EnumType("charging", "operational")
    case Slug extends EnumType("eating grass", "")
    def consume() = println(eat)
    def communicate() = println(talk)

def poly(x: EnumType): Unit =
    x.consume()
    x.communicate()

@main def main() =
    List(Dog, Person, Robot, Slug).foreach(poly(_))
