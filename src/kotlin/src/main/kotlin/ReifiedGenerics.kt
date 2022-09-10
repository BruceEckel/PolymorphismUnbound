//: src/kotlin/src/main/kotlin/ReifiedGenerics.kt
package reifiedgenerics

class Dog {
    fun eat() = println("eating dog food")
    fun bark() = println("woof")
}

class Person {
    fun scarf() = println("eating pizza")
    fun greet() = println("hello")
}

class Robot {
    fun charge() = println("charging")
    fun initiate() = println("operational")
}

class Slug {
    fun absorb() = println("eating grass")
}
//---
inline fun <reified T> nourish(subject: T) {
    when (subject) {
        is Dog -> {
            subject.eat()
            subject.bark()
        }
        is Person -> {
            subject.scarf()
            subject.greet()
        }
        is Robot -> {
            subject.charge()
            subject.initiate()
        }
        is Slug -> {
            subject.absorb()
        }
    }
}

fun main() {
    // Plays well with disjoint types:
    listOf(
        Dog(), Person(), Robot(), Slug()
    ).forEach { nourish(it) }
}
