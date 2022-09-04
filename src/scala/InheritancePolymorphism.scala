package typeclass

trait Base:
    def consume(): Unit
    def communicate(): Unit

class Dog extends Base:
    def consume() = println("eating dog food")
    def communicate() = println("woof")

class Person extends Base:
    def consume() = println("eating pizza")
    def communicate() = println("hello")

class Robot extends Base:
    def consume() = println("recharging")
    def communicate() = println("operational")

class Slug extends Base:
    def consume() = println("eating grass")
    def communicate() = {}

def demo(instance: Base): Unit =
    instance.consume()
    instance.communicate()

@main def main() =
    List(Dog(), Person(), Robot(), Slug()).foreach(demo(_))
