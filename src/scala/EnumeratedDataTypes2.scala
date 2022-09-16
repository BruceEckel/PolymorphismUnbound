//: src/scala/EnumeratedDataTypes2.scala
package enumtypes2
import EnumType.*

enum EnumType(food: String, talk: String):
    case Dog extends EnumType("eating dog food", "woof")
    case Person extends EnumType("eating pizza", "hello")
    case Robot extends EnumType("charging", "operational")
    case Slug extends EnumType("eating grass", "")
    def eat() = println(food)
    def speak() = println(talk)

def nourish(x: EnumType): Unit =
    x.eat()
    x.speak()

@main def main() =
    List(Dog, Person, Robot, Slug).foreach(nourish(_))
