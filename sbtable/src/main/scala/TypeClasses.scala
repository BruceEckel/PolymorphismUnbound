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

given Nourish[Robot] with
    extension (t: Robot)
        def consume(): Unit = t.eat()
        def communicate(): Unit = t.initiate()

given Nourish[Slug] with
    extension (t: Slug)
        def consume(): Unit = t.eat()
        def communicate() = {}

// The typeclass to handle List[T] where T has a Nourish typeclass
given [T : Nourish]: Nourish[List[T]] with
    extension (l: List[T])
        def consume(): Unit = l.foreach(_.consume())
        def communicate(): Unit = l.foreach(_.communicate())

def poly[T](x: T)(using Nourish[T]): Unit =
    x.consume()
    x.communicate()

// alternate syntax
def poly2[T: Nourish](x: T): Unit =
    x.consume()
    x.communicate()

@main def main() =
    poly(Dog())
    poly(Person())
    poly(Robot())
    poly(Slug())

    // Sum Type for all the elements (otherwise it becomes List[Object]
    val hlist = List[Dog | Person | Robot | Slug](Dog(), Person(), Robot(), Slug())

    // hlist.map(poly)

    // Produces:
    // no given instance of type typeclass.Speak[Object] was found for parameter x$2 of method poly in package typeclass

    // poly(hlist)

    // Produces:
    // But no implicit values were found that match type typeclass.Nourish[typeclass.Dog | typeclass.Person | typeclass.Robot | typeclass.Slug

    // works but isn't interesting
    val list = List(Dog(), Dog())
    poly(list)

//    val list2 = List[Nourish](Dog(), Person(), Robot(), Slug())
// This produces:
//-- [E007] Type Mismatch Error: C:\Git\PolymorphismUnbound\src\scala\.\TypeClasses.scala:54:33
//    54 |    val list2 = List[Nourish](Dog(), Person(), Robot(), Slug())
//      |                              ^^^^^
//    |Found:    typeclass.Dog
//    |Required: typeclass.Nourish
