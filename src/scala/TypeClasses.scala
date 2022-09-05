package typeclass

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

trait Nourish[T]:
    extension (t:T)
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

given Nourish[Robot] with
    extension (t: Robot)
        def consume(): Unit = t.eat()
        def communicate(): Unit = t.initiate()

given Nourish[Slug] with
    extension (t: Slug)
        def consume(): Unit = t.eat()
        def communicate() = {}

def poly[T](x: T)(using Nourish[T]): Unit =
    x.consume()
    x.communicate()

@main def main() =
    poly(Dog())
    poly(Person())
    poly(Robot())
    poly(Slug())

    val list = List(Dog(), Person(), Robot(), Slug())
//    list.map(poly(_))
// Produces:
// no given instance of type typeclass.Speak[Object] was found for parameter x$2 of method poly in package typeclass

//    val list2 = List[Nourish](Dog(), Person(), Robot(), Slug())
// This produces:
//-- [E007] Type Mismatch Error: C:\Git\PolymorphismUnbound\src\scala\.\TypeClasses.scala:54:33
//    54 |    val list2 = List[Nourish](Dog(), Person(), Robot(), Slug())
//      |                              ^^^^^
//    |Found:    typeclass.Dog
//    |Required: typeclass.Nourish
