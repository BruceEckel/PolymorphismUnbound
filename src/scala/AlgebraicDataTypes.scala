//: src/scala/AlgebraicDataTypes.scala
package adts
import ADT.*

enum ADT(food: String):
    case Person(cuisine: String) extends ADT(s"eating $cuisine")
    case Robot extends ADT("charging")
    def eat() = println(food)

def nourish(x: ADT): Unit =
    x.eat()

@main def main() =
    List(Person("pizza"), Robot).foreach(nourish)
