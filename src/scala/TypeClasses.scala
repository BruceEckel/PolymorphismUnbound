//: src/scala/TypeClasses.scala
package typeclasses

class Dog:
    def eat() = println("eating dog food")
    def bark() = println("woof")

class Person:
    def eat() = println("eating pizza")
    def greet() = println("hello")

class Robot:
    def eat() = println("charging")
    def initiate() = println("operational")

class Slug:
    def eat() = println("eating grass")
//---
trait Nourish[T]:
    extension (t: T)
        def consume(): Unit
        def communicate(): Unit

given Nourish[Person] with
    extension (t: Person)
        def consume(): Unit = t.eat()
        def communicate(): Unit = t.greet()

given Nourish[Dog] with
    extension (t: Dog)
        def consume(): Unit = t.eat()
        def communicate(): Unit = t.bark()
//---
given Nourish[Robot] with
    extension (t: Robot)
        def consume(): Unit = t.eat()
        def communicate(): Unit = t.initiate()

given Nourish[Slug] with
    extension (t: Slug)
        def consume(): Unit = t.eat()
        def communicate() = {}
//---
// The typeclass to handle List[T] where T has a Nourish typeclass
given [T : Nourish]: Nourish[List[T]] with
    extension (l: List[T])
        def consume(): Unit = l.foreach(_.consume())
        def communicate(): Unit = l.foreach(_.communicate())

def poly[T](x: T)(using Nourish[T]): Unit =
    x.consume()
    x.communicate()

// Alternate syntax
def poly2[T: Nourish](x: T): Unit =
    x.consume()
    x.communicate()

@main def main() =
    poly(Dog())
    poly(Person())
    poly(Robot())
    poly(Slug())

