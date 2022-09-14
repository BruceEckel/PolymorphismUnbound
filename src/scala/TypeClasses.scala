//: src/scala/TypeClasses.scala
// "Automating the adapter pattern"
package typeclasses
import disjointtypes.*

trait Update[T]:
    extension (t: T)
        def consume(): Unit
        def communicate(): Unit

given Update[Dog] with
    extension (t: Dog)
        def consume(): Unit = t.eat()
        def communicate(): Unit = t.bark()

given Update[Person] with
    extension (t: Person)
        def consume(): Unit = t.scarf()
        def communicate(): Unit = t.talk()
//---
given Update[Robot] with
    extension (t: Robot)
        def consume(): Unit = t.charge()
        def communicate(): Unit = t.communicate()

given Update[Slug] with
    extension (t: Slug)
        def consume(): Unit = t.absorb()
        def communicate() = {}
//---
// The typeclass to handle List[T] where T has an Update typeclass
given [T : Update]: Update[List[T]] with
    extension (l: List[T])
        def consume(): Unit = l.foreach(_.consume())
        def communicate(): Unit = l.foreach(_.communicate())

def nourish[T](x: T)(using Update[T]): Unit =
    x.consume()
    x.communicate()

@main def main() =
    nourish(Dog())
    nourish(Person())
    nourish(Robot())
    nourish(Slug())

