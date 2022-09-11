//: src/scala/IntersectionTypes.scala
package intersectiontypes

trait Eater:
    def eat(): Unit

trait Talker:
    def talk(): Unit

class Dog extends Eater, Talker:
    def eat() = println("eating dog food")
    def talk() = println("woof")

class Person extends Eater, Talker:
    def eat() = println("eating pizza")
    def talk() = println("hello")
//---
class Robot extends Eater, Talker:
    def eat() = println("charging")
    def talk() = println("operational")

class Slug extends Eater, Talker:
    def eat() = println("eating grass")
    def talk() = {}

// 'x' is an intersection type:
def nourish(x: Eater & Talker) =
    x.eat()
    x.talk()

@main def main() =
    List(Dog(), Person(), Robot(), Slug()).foreach(nourish(_))
