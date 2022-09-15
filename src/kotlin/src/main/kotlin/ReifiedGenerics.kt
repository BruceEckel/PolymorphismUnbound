//: src/kotlin/src/main/kotlin/ReifiedGenerics.kt

inline fun <reified T> nourish(subject: T) {
    when (subject) {
        is Dog -> {
            subject.gulp()
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

fun main() =
    listOf(
        Dog(), Person(), Robot(), Slug()
    ).forEach { nourish(it) }
