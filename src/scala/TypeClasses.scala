//: src/scala/TypeClasses.scala
// "Automating the adapter pattern"
package typeclasses
import disjointtypes.*

trait EaterSpeaker[T]:
    extension (t: T)
        def eat(): Unit

given EaterSpeaker[Person] with
    extension (t: Person)
        def eat(): Unit = t.consume()
//---
given EaterSpeaker[Robot] with
    extension (t: Robot)
        def eat(): Unit = t.charge()

def nourish[T](x: T)(using EaterSpeaker[T]): Unit =
    x.eat()

@main def main() =
    nourish(Person())
    nourish(Robot())
