//: src/scala/IntersectionTypes.scala
package intersectiontypes

trait Consumer:
    def eat(): Unit

trait Communicator:
    def talk(): Unit

class Dog extends Consumer, Communicator:
    def eat() = println("eating dog food")
    def talk() = println("woof")

class Person extends Consumer, Communicator:
    def eat() = println("eating pizza")
    def talk() = println("hello")
//---
class Robot extends Consumer, Communicator:
    def eat() = println("charging")
    def talk() = println("operational")

class Slug extends Consumer, Communicator:
    def eat() = println("eating grass")
    def talk() = {}

// 'x' is an intersection type:
def nourish(x: Consumer & Communicator) =
    x.eat()
    x.talk()

@main def main() =
    List(Dog(), Person(), Robot(), Slug()).foreach(nourish(_))
