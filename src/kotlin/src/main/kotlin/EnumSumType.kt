package enumsumtype
import enumsumtype.SumType.*

enum class SumType {
    Dog {
        override fun eat() {
            println("${this.name} eating dog food")
        }
        fun bark() {
            println("woof")
        }
    },
    Person {
        override fun eat() {
            println("${this.name} eating pizza")
        }
        fun greet() {
            println("hello")
        }
    },
    Robot {
        override fun eat() {
            println("${this.name} recharging")
        }
        fun initiate() {
            println("operational")
        }
    },
    Slug {
        override fun eat() {
            println("${this.name} eating grass")
        }
    };

    abstract fun eat(): Unit
    fun sleep() = println("${this.name} sleeping...")
}

fun nourish(subject: SumType) {
    subject.eat()
    subject.sleep()
//    when (subject) {
//        Dog -> subject.bark()
//        Person -> subject.greet()
//        Robot -> subject.initiate()
//        else -> {}
//    }
}

fun main() {
    listOf(
        Dog, Person, Robot, Slug,
    ).forEach { nourish(it) }
}
