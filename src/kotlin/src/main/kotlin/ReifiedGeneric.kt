package reifiedgenerics

class Dog {
    fun eat() = println("eating dog food")
    fun bark() = println("woof")
}

class Person {
    fun eat() = println("eating pizza")
    fun greet() = println("hello")
}

class Robot {
    fun eat() = println("recharging")
    fun initiate() = println("operational")
}

class Slug {
    fun eat() = println("eating grass")
}

inline fun <reified T> nourish(subject: T) {
    when (subject) {
        is Dog -> {
            subject.eat()
            subject.bark()
        }
        is Person -> {
            subject.eat()
            subject.greet()
        }
        is Robot -> {
            subject.eat()
            subject.initiate()
        }
        is Slug -> {
            subject.eat()
        }
    }
    if(subject is Dog || subject is Person ||
        subject is Robot || subject is Slug) {
        // subject.eat() // Nope
    }
}

fun main() {
    listOf(
        Dog(), Person(), Robot(), Slug()
    ).forEach { nourish(it) }
}
