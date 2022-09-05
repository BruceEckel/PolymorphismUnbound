package sumtype

case class Dog():
    def eat() = println("eating dog food")
    def bark() = println("woof")

case class Person():
    def scarf() = println("eating pizza")
    def talk() = println("hello")

case class Robot():
    def charge() = println("recharging")
    def communicate() = println("operational")

case class Slug():
    def absorb() = println("eating grass")

def demo(o: Dog | Person | Robot | Slug) = o match
    case d: Dog =>
        d.eat()
        d.bark()
    case p: Person =>
        p.scarf()
        p.talk()
    case r: Robot =>
        r.charge()
        r.communicate()
    case s: Slug =>
        s.absorb()

@main def main() =
    val list: List[Dog | Person | Robot | Slug] =
        List(Dog(), Person(), Robot(), Slug())
    list.foreach(demo(_))
