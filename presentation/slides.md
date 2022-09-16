---
marp: true
theme: gaia
class: invert
footer: 'MindviewLLC.com'
---

<style scoped>
h1, h2, h3, h4, h5, h6 {
  color: black;
}
a {
  color: black;
  text-decoration: none;
}
</style>
![bg](TitleImage.jpg)

# Polymorphism<br/>Unbound

## Bruce Eckel

###### Github:<br/> BruceEckel/PolymorphismUnbound

---

## `cfront`, `virtual`, and dynamic binding

![bg right](tape.jpg)

---

# How did we get here?

## Simula

- A simulation needs a common interface for all simulation elements.
- So you can tell them all to update themselves.

---

# Smalltalk

- Takes Simula concept and applies it to all elements
- Code Reuse via Inheritance
* BUT Smalltalk is inherently dynamic
* _Message-Oriented Programming_ (like Actors)

---

# C++

  - Encapsulation for data control
  - Inheritance and dynamic binding
  - Objects are completely optional
  - Everything statically typed for safety

---

# Java

  - Not optional: Everything is an Object, like Smalltalk
  - BUT static typing makes it quite different
  - The concept of dynamic messages is lost, not really like Smalltalk
  - Reusing code through inheritance didn't really work out
  - Post-Java languages have learned from its mistakes

---
<style scoped>
h2 {
  color: orange;
}
</style>
# Polymorphism
<br/><br/>
## _A type represents multiple types_
<br/><br/>
Usually appears in the form of a function parameter

---

# Examples

- Different forms of polymorphism
- Implemented in different languages:

---

# Java

(_without reflection_)
www.OnJava8.com
![bg fit left](TIJava4cover.jpg)
![bg fit left](OnJava8Cover.jpg)

---

# C++

![bg fit right](eckel-c-front-cover-only.jpg)

---

# Kotlin

www.AtomicKotlin.com
![bg fit right](AtomicKotlinCover.png)

---

<style scoped>
h1, h2, h3, h4, h5, h6 {
  color: black;
}
</style>
### www.AtomicScala.com
![bg](Scala.jpg)
![bg fit](AtomicScala.jpg)

---

# Python, Rust, Go

---

# Ad-Hoc Polymorphism (Overloading)

---

```
//: src/kotlin/src/main/kotlin/AdHoc.kt
import disjoint.*

fun nourish(p: Person) = p.consume()

fun nourish(r: Robot) = r.charge()

fun main() {
    nourish(Person())
    nourish(Robot())
}
```
------

```
//: src/cpp/AdHoc.cpp
// All C++ examples tested with https://cpp.sh
#include <string>
#include <iostream>
using namespace std;

class Person {
    public:
    void eat() { cout << "eating pizza" << endl; }
};

class Robot {
    public:
    void charge() { cout << "charging" << endl; }
};

void nourish(Person p) { p.eat(); }

void nourish(Robot r) { r.charge(); }

int main() {
    nourish(Person());
    nourish(Robot());
}
```
------

Cannot locate C:\Git\PolymorphismUnbound\src\java\src\DisjointTypes.java

- Python overloading: `src/python/single_dispatch.py`

---

# Classic Inheritance following Liskov Substitution

---

```
//: src/kotlin/src/main/kotlin/Inheritance.kt
package inheritance

interface Base {
    fun eat()
}

class Person: Base {
    override fun eat() = println("eating pizza")
}

class Robot: Base {
    override fun eat() = println("charging")
}

fun nourish(subject: Base) = subject.eat()

fun main() = listOf(Person(), Robot()).forEach { nourish(it) }
```
------

```
//: src/scala/Inheritance.scala
package inheritance

trait Base:
    def eat(): Unit
    def speak(): Unit

class Dog extends Base:
    def eat() = println("eating dog food")
    def speak() = println("woof")

class Person extends Base:
    def eat() = println("eating pizza")
    def speak() = println("hello")
```
---
```
class Robot extends Base:
    def eat() = println("charging")
    def speak() = println("operational")

class Slug extends Base:
    def eat() = println("eating grass")
    def speak() = {}

def nourish(x: Base): Unit =
    x.eat()
    x.speak()

@main def main() =
    List(Dog(), Person(), Robot(), Slug()).foreach(nourish(_))
```
------

```
//: src/java/src/Inheritance.java
package inheritance;
import java.util.List;

interface Base {
  void eat();
}

class Person implements Base {
  @Override
  public void eat() { System.out.println("eating pizza"); }
}

class Robot implements Base {
  @Override
  public void eat() { System.out.println("charging"); }
}

public class Inheritance {
  static void nourish(Base subject) {
    subject.eat();
  }
  public static void main(String... args) {
    List.of(new Person(), new Robot()).forEach(Inheritance::nourish);
  }
}
```
------

```
//: src/cpp/Inheritance.cpp
#include <iostream>
using namespace std;

class Base {
    public:
    virtual void eat() = 0;  // Pure virtual == abstract
};

class Person: public Base {
    public:
    void eat() override { cout << "eating pizza" << endl; }
};

class Robot: public Base {
    public:
    void eat() override { cout << "charging" << endl; }
};

void nourish(Base* base) {
    base->eat();
}

int main() {
    Base* subjects[] = { new Person(), new Robot() };
    for(Base* subject: subjects)
      nourish(subject);
}
```
------

```
#: src/python/base.py
from abc import ABC, abstractmethod

class Base(ABC):
    @abstractmethod
    def eat(self) -> None: ...
```
------

```
#: src/python/inheritance.py
from base import Base

class Person(Base):
    def eat(self): print("eating pizza")

class Robot(Base):
    def eat(self): print("charging")

def nourish(subject: Base):
    subject.eat()

if __name__ == '__main__':
    for subject in [Person(), Robot()]:
        nourish(subject)
```
------

```
//: src/rust/inheritance/src/main.rs
struct Person;
struct Robot;

trait Base {
  fn eat(&self);
}

impl Base for Person {
  fn eat(&self) { println!("eating pizza"); }
}

impl Base for Robot {
  fn eat(&self) { println!("charging"); }
}

fn main() {
  let v: Vec<&dyn Base> = vec![&Person{}, &Robot{}];
  for d in v.iter() {
    d.eat();
  }
}
```
------


# Multiple Inheritance

---

Cannot locate C:\Git\PolymorphismUnbound\src\kotlin\src\main\kotlin\DisjointTypes.kt
```
//: src/kotlin/src/main/kotlin/MultipleInheritance.kt
// Can also do this in Java
import disjoint.*

interface Base {
    fun eat()
}

class Person2 : Base, Person() {
    override fun eat() = consume()
}

class Robot2 : Base, Robot() {
    override fun eat() = charge()
}

fun nourish(subject: Base) = subject.eat()

fun main() = listOf(Person2(), Robot2()).forEach { nourish(it) }
```
------

```
//: src/kotlin/src/main/kotlin/Composition.kt
// Can use this approach in most languages
import disjoint.*

class Person3 : Base {
    private val person = Person()
    override fun eat() = person.consume()
}

class Robot3 : Base {
    private val robot = Robot()
    override fun eat() = robot.charge()
}

fun main() = listOf(Person3(), Robot3()).forEach { nourish(it) }
```
------

```
//: src/kotlin/src/main/kotlin/Delegation.kt
package delegation
import inheritance.*

class Delegate(b: Base) : Base by b {
    fun consume() = eat()
}

fun nourish(d: Delegate) = d.consume()

fun main() = listOf(Delegate(Person()), Delegate(Robot()))
    .forEach { nourish(it) }
```
------

```
//: src/cpp/MultipleInheritance.cpp
// Combining disjoint types using MI
#include <iostream>
using namespace std;

class Person {
    public:
    void scarf() { cout << "eating pizza" << endl; }
};

class Robot {
    public:
    void charge() { cout << "charging" << endl; }
};

class Base {
    public:
    virtual void eat() = 0;  // Pure virtual function
};

class Person2: public Base, private Person {
    public:
    void eat() override { scarf(); }
};

class Robot2: public Base, private Robot {
    public:
    void eat() override { charge(); }
};

void nourish(Base* base) {
    base->eat();
}

int main() {
    Base* subjects[] = { new Person2(), new Robot2() };
    for(Base* subject: subjects)
      nourish(subject);
}
```
------

```
#: src/python/disjoint_types.py

class Person:
    def consume(self): print("eating pizza")

class Robot:
    def charge(self): print("charging")
```
------

```
#: src/python/multiple_inheritance.py
from base import Base
from disjoint_types import Person, Robot

class Person2(Person, Base):
    def eat(self): super().consume()

class Robot2(Robot, Base):
    def eat(self): super().charge()

def nourish(base: Base):
    base.eat()

if __name__ == '__main__':
    for subject in [Person2(), Robot2()]:
        nourish(subject)
```
------


# Parametric Polymorphism

---

```
//: src/kotlin/src/main/kotlin/Generics.java
// {NewFeature} Preview in JDK 17
// Compile with javac flags:
//   --enable-preview --source 17
import java.util.List;

public class Generics {
  static <T> T nourish(T x) {
    // x.consume(); // Nope
    switch(x) {
      case Person p -> p.consume();
      case Robot r -> r.charge();
      default -> throw new IllegalStateException("Unexpected: " + x);
    }
    return x;
  }
  static Object nourish2(Object x) {
    switch(x) {
      case Person p -> p.consume();
      case Robot r -> r.charge();
      default -> throw new IllegalStateException("Unexpected: " + x);
    }
    return x;
  }
  ```
---
```
  public static void main(String... args) {
    List.of(new Person(), new Robot()).forEach(Generics::nourish);
    Person p = nourish(new Person());
    Object p2 = nourish2(new Person());
  }
}
```
------

```
//: src/kotlin/src/main/kotlin/Generics.kt
package generics
import disjoint.*

fun <T> nourish(subject: T) : T {
    when (subject) {
        is Person -> subject.consume()
        is Robot -> subject.charge()
    }
    return subject
}

fun nourish2(subject: Any) : Any {
    when (subject) {
        is Person -> subject.consume()
        is Robot -> subject.charge()
    }
    return subject
}

fun main() {
    listOf(Person(), Robot())
        .map { nourish(it) }.forEach{ println(it) }
    val r: Robot = nourish(Robot())
    println(r)
    // val p: Person = nourish2(Person()) // Nope
    val o: Any = nourish2(Person())
}
```
------

```
//: src/golang/generic/generics.go
package main

type Dog struct{}

func (dog Dog) Eat()  { println("eating dog food") }
func (dog Dog) Bark() { println("woof") }

type Person struct{}

func (person Person) Eat()   { println("eating pizza") }
func (person Person) Greet() { println("hello") }
```
---
```
type Robot struct{}

func (robot Robot) Eat()      { println("charging") }
func (robot Robot) Initiate() { println("operational") }

type Slug struct{}

func (slug Slug) Eat() { println("eating grass") }
```
---
```
type Eater interface {
    Eat()
}
// T is a Union type:
func Poly[T Dog | Person | Robot | Slug](subject T) {
    switch subjectTyped := any(subject).(type) {
    case Eater:
        subjectTyped.Eat()
    }
    switch subjectTyped := any(subject).(type) {
    case Dog:
        subjectTyped.Bark()
    case Person:
        subjectTyped.Greet()
    case Robot:
        subjectTyped.Initiate()
    }  // Not exhaustive
}
```
---
```
func main() {
    Poly(Dog{})
    Poly(Person{})
    Poly(Robot{})
    Poly(Slug{})
}
```
------


Scala & Rust?

---

# Structural Typing aka Duck Typing

---

```
#: src/python/duck_typing.py
from inheritance import Person, Robot

def nourish(subject: object):
    subject.eat()  # Duck typing

if __name__ == '__main__':
    for subject in [Person(), Robot()]:
        nourish(subject)
        # nourish("")  # Runtime error
```
------

```
//: src/cpp/StructuralTyping.cpp
#include <variant>  // C++ 17
#include <iostream>
using namespace std;

class Person {
    public:
    void eat() { cout << "eating pizza" << endl; }
};

class Robot {
    public:
    void eat() { cout << "charging" << endl; }
};

// 'Structural typing' aka 'duck typing'
template <class T>
void nourish(T subject) {
    subject.eat();
}

int main() {
    nourish(Person());
    nourish(Robot());
}
```
------


# Union Types aka Sum Types

---

```
#: src/python/union_types.py
from disjoint_types import Person, Robot

def nourish(combined: Person | Robot):
    match combined:  # No exhaustiveness checking
        case Person(): combined.consume()
        case Robot(): combined.charge()

if __name__ == '__main__':
    for subject in [Person(), Robot()]:
        nourish(subject)
    # nourish("")  # Type-check error
```
------

```
//: src/scala/DisjointTypes.scala
// Nothing in common
package disjointtypes

class Dog:
    def eat() = println("eating dog food")
    def bark() = println("woof")

class Person:
    def scarf() = println("eating pizza")
    def talk() = println("hello")

class Robot:
    def charge() = println("charging")
    def communicate() = println("operational")

class Slug:
    def absorb() = println("eating grass")
```
------

```
//: src/scala/UnionTypes.scala
// Union types aka sum types
package uniontypes
import disjointtypes.*

// 'x' is a union type:
def nourish(x: Dog | Person | Robot | Slug) = x match
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
```
---
```
@main def main() =
    val list: List[Dog | Person | Robot | Slug] =
        List(Dog(), Person(), Robot(), Slug())
    list.foreach(nourish(_))
```
------

Cannot locate C:\Git\PolymorphismUnbound\src\java\src\PatternMatching.java
```
//: src/cpp/UnionTypes.cpp
#include <variant>  // C++ 17
#include <iostream>
using namespace std;

class Person {
    public:
    void eat() { cout << "eating pizza" << endl; }
};

class Robot {
    public:
    void charge() { cout << "charging" << endl; }
};

typedef variant<Person, Robot> unionType;

void nourish(unionType combined) {
    if(auto personPtr(get_if<Person>(&combined)); personPtr) {
        personPtr->eat();
    }
    else if(auto robotPtr(get_if<Robot>(&combined)); robotPtr) {
        robotPtr->charge();
    }
    // No exhaustiveness checking (comment out the 'else if' clause)
}

int main() {
    unionType subjects[] = { Person(), Robot() };
    for(unionType subject: subjects)
      nourish(subject);
}
```
------


# Protocols

---

```
#: src/python/protocols.py
from typing import Protocol
from inheritance import Person, Robot

class Base(Protocol):
    def eat(self): ...

def nourish(subject: Base):
    subject.eat()

if __name__ == '__main__':
    for subject in [Person(), Robot()]:
        nourish(subject)
```
------

```
//: src/golang/structural/structural.go
package main

type Dog struct{}

func (dog Dog) Eat()     { println("eating dog food") }
func (dog Dog) Speak() { println("woof") }

type Person struct{}

func (person Person) Eat()     { println("eating pizza") }
func (person Person) Speak() { println("hello") }
```
---
```
type Robot struct{}

func (robot Robot) Eat()     { println("charging") }
func (robot Robot) Speak() { println("operational") }

type Slug struct{}

func (slug Slug) Eat()     { println("eating grass") }
func (slug Slug) Speak() {}
```
---
```
type EaterSpeaker interface {
    Eat()
    Speak()
}

func Nourish(x EaterSpeaker) {
    x.Eat()
    x.Speak()
}

func main() {
    subjects := []EaterSpeaker{
        Dog{}, Person{}, Robot{}, Slug{},
    }
    for _, subject := range subjects {
        Nourish(subject)
    }
}
```
------


# Algebraic Data Types (ADTs)

---

```
//: src/scala/EnumeratedDataTypes.scala
// Enumerated Data Types
package enumtypes
import EnumType.*

enum EnumType:
    case Dog, Person, Robot, Slug
    def eat() = this match
        case Dog => println("eating dog food")
        case Person => println("eating pizza")
        case Robot => println("charging")
        case Slug => println("eating grass")
    def speak() = this match
        case Dog => println("woof")
        case Person => println("hello")
        case Robot => println("operational")
        case Slug => ()
```
---
```
def nourish(x: EnumType): Unit =
    x.eat()
    x.speak()

@main def main() =
    List(Dog, Person, Robot, Slug).foreach(nourish(_))
```
------

```
//: src/scala/EnumeratedDataTypes2.scala
package enumtypes2
import EnumType.*

enum EnumType(food: String, talk: String):
    case Dog extends EnumType("eating dog food", "woof")
    case Person extends EnumType("eating pizza", "hello")
    case Robot extends EnumType("charging", "operational")
    case Slug extends EnumType("eating grass", "")
    def eat() = println(food)
    def speak() = println(talk)

def nourish(x: EnumType): Unit =
    x.eat()
    x.speak()

@main def main() =
    List(Dog, Person, Robot, Slug).foreach(nourish(_))
```
------

```
//: src/scala/AlgebraicDataTypes.scala
package adts
import ADT.*

enum ADT(food: String, talk: String):
    case Dog(says: String) extends ADT("eating dog food", says)
    case Person(says: String) extends ADT("eating pizza", says)
    case Robot extends ADT("charging", "operational")
    case Slug extends ADT("eating grass", "")
    def eat() = println(food)
    def speak() = println(talk)

def nourish(x: ADT): Unit =
    x.eat()
    x.speak()

@main def main() =
    List(Dog("woof"), Person("hi!"), Robot, Slug).foreach(nourish(_))
```
------

```
//: src/kotlin/src/main/kotlin/AlgebraicDataTypes.kt
package algebraic
import algebraic.ADT.*

sealed class ADT(val eats: String) {
    class Person(food: String) : ADT(food) {
        fun consume() = println("eating pizza")
    }
    class Robot : ADT("electricity") {
        fun charge() = println("charging")
    }
}

fun nourish(subject: ADT) {
    when (subject) {
        is Person -> subject.consume()
        is Robot -> subject.charge()
    }
}

fun main() = listOf(Person("pizza"), Robot()).forEach { nourish(it) }
```
------


# Type Classes

---

```
//: src/scala/TypeClasses.scala
// "Automating the adapter pattern"
package typeclasses
import disjointtypes.*

trait EaterSpeaker[T]:
    extension (t: T)
        def eat(): Unit
        def speak(): Unit

given EaterSpeaker[Dog] with
    extension (t: Dog)
        def eat(): Unit = t.eat()
        def speak(): Unit = t.bark()
```
---
```
given EaterSpeaker[Person] with
    extension (t: Person)
        def eat(): Unit = t.scarf()
        def speak(): Unit = t.talk()

given EaterSpeaker[Robot] with
    extension (t: Robot)
        def eat(): Unit = t.charge()
        def speak(): Unit = t.communicate()

given EaterSpeaker[Slug] with
    extension (t: Slug)
        def eat(): Unit = t.absorb()
        def speak() = {}
```
---
```
def nourish[T](x: T)(using EaterSpeaker[T]): Unit =
    x.eat()
    x.speak()

@main def main() =
    nourish(Dog())
    nourish(Person())
    nourish(Robot())
    nourish(Slug())
```
------

```
//: src/rust/typeclasses/src/main.rs
struct Person;
struct Robot;

impl Person {
  fn consume(&self) { println!("eating pizza"); }
}

impl Robot {
  fn charge(&self) { println!("charging"); }
}
```
---
```
pub trait Eater {
    fn eat(&self);
}

impl Eater for Person {
    fn eat(&self) {
        self.consume();
    }
}

impl Eater for Robot {
    fn eat(&self) {
        self.charge();
    }
}
```
---
```
pub fn nourish<T: Eater>(x: &T) {
    x.eat();
}

fn main() {
    nourish(&Person {});
    nourish(&Robot {});
}
```
------


# Takeaways

* Why do we want to treat multiple types as the same type?
  * Separate things that change from things that stay the same?
  * Reduce code duplication?
  * Code understanding & maintenance?
  * Don't do it without question

---

# What can we do with the aggregate?

* If there's no intersection of either syntax or semantics, does it make sense?
* Yes: erasure in Java allows no behavior, only preserves exact return type

---

# Code Reuse with Inheritance

* Maybe conflating these should have been left to Smalltalk
  * Some newer languages (Rust, Go) explicitly disallow it
  * Code reuse means embedding an object rather than inheriting
  * Luciano Ramalho: implement interfaces only for "frameworks"

---

# Was OO a Mistake?

* No: Sometimes it's quite useful
* Just not everywhere all the time
  * Forcing inheritance into every design seems like a bad idea
* Ad-hoc polymorphism is heavily used in FP: map, fold, etc.

---

# I'll Get By With a Little Help...

- Bill Frasure
- James Ward
- Luciano Ramalho
- Jack Leow
- Marshall Pierce
- Bill Venners

---

# Questions

... In the hall

![bg fit right](workwithcare.jpg)