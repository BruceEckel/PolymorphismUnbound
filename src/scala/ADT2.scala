// src/scala/ADT2.scala
// Algebraic Data Types
package adt2
import ADT._

enum ADT(eat: String, talk: String):
    case Dog extends ADT("eating dog food", "woof")
    case Person extends ADT("eating pizza", "hello")
    case Robot extends ADT("charging", "operational")
    case Slug extends ADT("eating grass", "")
    def consume() = println(eat)
    def communicate() = println(talk)

def poly(x: ADT): Unit =
    x.consume()
    x.communicate()

@main def main() =
    List(Dog, Person, Robot, Slug).foreach(poly(_))
