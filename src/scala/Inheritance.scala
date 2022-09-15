//: src/scala/Inheritance.scala
package inheritance

trait Base:
    def eat(): Unit
    def speak(): Unit

class Dog extends Base:
    def eat() = println("eating dog food")
    def speak() = println("woof")

class Person extends Base:
    def eat() = println("eating pizza")
    def speak() = println("hello")
//---
class Robot extends Base:
    def eat() = println("charging")
    def speak() = println("operational")

class Slug extends Base:
    def eat() = println("eating grass")
    def speak() = {}

def nourish(x: Base): Unit =
    x.eat()
    x.speak()

@main def main() =
    List(Dog(), Person(), Robot(), Slug()).foreach(nourish(_))
