//: src/scala/IntersectionTypes.scala
package intersectiontypes

trait Eater:
    def eat(): Unit

trait Talker:
    def talk(): Unit

class Person extends Eater, Talker:
    def eat() = println("eating pizza")
    def talk() = println("hello")

class Robot extends Eater, Talker:
    def eat() = println("charging")
    def talk() = println("operational")

// 'x' is an intersection type:
def nourish(x: Eater & Talker) =
    x.eat()
    x.talk()

@main def main() =
    List(Person(), Robot()).foreach(nourish)
