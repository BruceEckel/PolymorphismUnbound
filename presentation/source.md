---
marp: true
theme: gaia
class: invert
footer: '**Bruce Eckel** &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; MindviewLLC.com'
---

# How we got here
## Simula
- A simulation needs a common interface for all simulation elements.
  - So you can tell them all to update themselves.

## Smalltalk
- Takes Simula concept and applies it to all elements
  * BUT Smalltalk is inherently dynamic
  * _Message-Oriented Programming_
---
# C++
  - Object-Based Encapsulation for data control
  - BUT Objects are completely optional
  - Might as well add inheritance and dynamic binding
  - Everything statically typed for safety, very different from Smalltalk

# Java
  - Everything is an Object, like Smalltalk
  - BUT static typing makes it quite different
  - The concept of dynamic messages is lost, not really like Smalltalk
  - Making new types by inheritance didn't really work out

---
# Polymorphism
_A type represents multiple types_
---

|==> //: src/cpp/AdHoc.cpp
|==> //: src/cpp/Inheritance.cpp
|==> //: src/cpp/MultipleInheritance.cpp
|==> //: src/cpp/CompileTimePolymorphism.cpp

# Java (_without reflection_)
---

|==> //: src/java/src/Inheritance.java
|==> //: src/java/src/DisjointTypes.java
|==> //: src/java/src/Generics.java

# Python
---

|==> #: src/python/base.py
|==> #: src/python/inheritance.py
|==> #: src/python/disjoint_types.py
|==> #: src/python/multiple_inheritance.py
|==> #: src/python/protocols.py
|==> #: src/python/single_dispatch.py

# Kotlin
---

|==> //: src/kotlin/src/main/kotlin/AdHoc.kt
|==> //: src/kotlin/src/main/kotlin/Inheritance.kt
|==> //: src/kotlin/src/main/kotlin/ReifiedGenerics.kt
|==> //: src/kotlin/src/main/kotlin/AlgebraicDataTypes.kt

# Scala
---

|==> //: src/scala/Inheritance.scala
|==> //: src/scala/EnumTypes.scala
|==> //: src/scala/EnumTypes2.scala
|==> //: src/scala/UnionTypes.scala
|==> //: src/scala/IntersectionTypes.scala
|==> //: src/scala/TypeClasses.scala

# Rust
---

|==> //: src/rust/inheritance/src/main.rs
|==> //: src/rust/typeclasses/src/main.rs

# Go
---

|==> //: src/golang/structural/structural.go
|==> //: src/golang/generic/generics.go

# To Ponder

* Why do you want to treat multiple types as the same type?
  * Separate things that change from things that stay the same
  * Reduce code duplication
  * Better code understanding & maintenance
  * Don't do it without question

---

# What can you do with this aggregate type?

  * If there's no intersection of either syntax or semantics, does it make sense?
  * Erasure in Java allows no behavior, only preserves exact return type

---
# Code Reuse with Inheritance

* Maybe conflating these should have been left to Smalltalk
  * Some newer languages (Rust, Go) explicitly disallow it
  * Code reuse means embedding an object rather than inheriting
  * Luciano Ramalho: use interface/implementation only for "frameworks"

---
# Was OO a Mistake?
* No: Sometimes it's quite useful
* Just not everywhere all the time
* Polymorphism is heavily used in FP: map, fold, etc.
* Forcing inheritance into every design seems like a bad idea
---
# I'll Get By With a Little Help...
- James Ward
- Luciano Ramalho
- Bill Frasure
- Jack Leow
- Marshall Pierce
- Bill Venners
