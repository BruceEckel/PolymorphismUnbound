package inheritance

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
    def consume() = println("charging")
    def communicate() = println("operational")

class Slug extends Base:
    def consume() = println("eating grass")
    def communicate() = {}

def demo(x: Base): Unit =
    x.consume()
    x.communicate()

@main def main() =
    List(Dog(), Person(), Robot(), Slug()).foreach(demo(_))
