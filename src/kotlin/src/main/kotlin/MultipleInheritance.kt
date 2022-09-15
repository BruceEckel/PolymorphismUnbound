import java.util.stream.Stream

interface Base {
    fun eat()
    fun speak() {}
}

internal class Dog2 : Dog(), Base {
    override fun eat() {
        super.eat()
    }

    override fun speak() {
        super.bark()
    }
} //---

internal class Person2 : Person(), Base {
    override fun eat() {
        super.scarf()
    }

    override fun speak() {
        super.greet()
    }
}

internal class Robot2 : Robot(), Base {
    override fun eat() {
        super.charge()
    }

    override fun speak() {
        super.initiate()
    }
} //---

internal class Slug2 : Slug(), Base {
    override fun eat() {
        super.absorb()
    }
}

object MultipleInheritance {
    fun nourish(subject: Base) {
        subject.eat()
        subject.speak()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        listOf(
            Dog2(), Person2(), Robot2(), Slug2()
        ).forEach { nourish(it) }
    }
}