//: src/scala/AlgebraicDataTypes.scala
package adts
import ADT.*

enum ADT(eat: String, talk: String):
    case Dog(says: String) extends ADT("eating dog food", says)
    case Person(says: String) extends ADT("eating pizza", says)
    case Robot extends ADT("charging", "operational")
    case Slug extends ADT("eating grass", "")
    def consume() = println(eat)
    def communicate() = println(talk)
//---
def nourish(x: ADT): Unit =
    x.consume()
    x.communicate()

@main def main() =
    List(Dog("woof"), Person("hi!"), Robot, Slug).foreach(nourish(_))
