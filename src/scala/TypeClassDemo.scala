package typeclass

class Dog():
    def eat() = println("eating dog food")
    def bark() = println("woof")

class Person():
    def eat() = println("eating pizza")
    def greet() = println("hello")

class Robot():
    def eat() = println("recharging")
    def initiate() = println("operational")

class Slug():
    def eat() = println("eating grass")

trait Speak[T]:
    extension (t:T) def eat(): Unit = t.eat()
    extension (t:T) def communicate(): Unit

given Speak[Person] with extension (t: Person)
    override def communicate(): Unit = t.greet()

given Speak[Dog] with extension (t: Dog)
    override def communicate(): Unit = t.bark()

given Speak[Robot] with extension (t: Robot)
    override def communicate(): Unit = t.initiate()

given Speak[Slug] with extension (t: Slug)
    override def communicate() {}

def demo[T](instance: T)(using Speak[T]):
    instance.eat()
    instance.communicate()

@main def typeClassDemo() =
    List(Dog(), Person(), Robot(), Slug()).map(demo(_))
