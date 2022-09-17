//: src/scala/Inheritance.scala
package inheritance

trait Base:
    def eat(): Unit

class Person extends Base:
    def eat() = println("eating pizza")

class Robot extends Base:
    def eat() = println("charging")

def nourish(x: Base): Unit =
    x.eat()

@main def main() =
    List(Person(), Robot()).foreach(nourish)
