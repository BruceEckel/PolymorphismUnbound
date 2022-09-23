//: src/scala/TypeClasses.scala
// "Automating the adapter pattern"
package typeclasses
import disjointtypes.*

trait Eater[T]:
    extension (t: T)
        def eat(): Unit

given Eater[Person] with
    extension (t: Person)
        def eat(): Unit = t.consume()
//---
given Eater[Robot] with
    extension (t: Robot)
        def eat(): Unit = t.charge()

def nourish[T](x: T)(using Eater[T]): Unit =
    x.eat()

@main def main() =
    nourish(Person())
    nourish(Robot())
