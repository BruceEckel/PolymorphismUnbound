//: src/scala/AlgebraicDataTypes.scala
package adts
import ADT.*

enum ADT:
    case Person(val eats: String)
    case Robot(val chargesWith: String)

def nourish(x: ADT) = x match   // Exhaustive
    case p: Person => println(s"eating ${p.eats}")
    case r: Robot  => println(s"charging with ${r.chargesWith}")

@main def main() =
    List(Person("pizza"), Robot("electricity")).foreach(nourish)
