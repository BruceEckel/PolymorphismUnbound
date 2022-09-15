//: src/scala/TypeClasses.scala
// "Automating the adapter pattern"
package typeclasses
import disjointtypes.*

trait EaterSpeaker[T]:
    extension (t: T)
        def eat(): Unit
        def speak(): Unit

given EaterSpeaker[Dog] with
    extension (t: Dog)
        def eat(): Unit = t.eat()
        def speak(): Unit = t.bark()
//---
given EaterSpeaker[Person] with
    extension (t: Person)
        def eat(): Unit = t.scarf()
        def speak(): Unit = t.talk()

given EaterSpeaker[Robot] with
    extension (t: Robot)
        def eat(): Unit = t.charge()
        def speak(): Unit = t.communicate()

given EaterSpeaker[Slug] with
    extension (t: Slug)
        def eat(): Unit = t.absorb()
        def speak() = {}
//---
def nourish[T](x: T)(using EaterSpeaker[T]): Unit =
    x.eat()
    x.speak()

@main def main() =
    nourish(Dog())
    nourish(Person())
    nourish(Robot())
    nourish(Slug())
