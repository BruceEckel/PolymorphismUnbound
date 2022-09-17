//: src/kotlin/src/main/kotlin/Holder.kt

class Holder<T>(private val value: T) {
    fun get(): T = value
}

fun main() {
    class Car; class Robot

    val car = Car()
    val garage = Holder<Car>(car)
    val c: Car = garage.get()

    val robot = Robot()
    val chargingStation = Holder<Robot>(robot)
    val r: Robot = chargingStation.get()

    val carList = Holder<List<Car>>(listOf(car))
}