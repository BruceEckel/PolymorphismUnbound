---
marp: true
theme:
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

```C++
// src/cpp/AdHoc.cpp
// Tested with https://cpp.sh
#include <string>
#include <iostream>
using namespace std;

void f(string s) {
    cout << "f(string s): " << s << endl;
}

void f(float f) {
    cout << "f(float f): " << f << endl;
}

int main() {
    f("x");
    f(1.0);
}
```
---
```C++
// src/cpp/Inheritance.cpp
// Tested with https://cpp.sh
#include <iostream>
using namespace std;

class Base {
    public:
    virtual void eat() = 0;  // Pure virtual function
    virtual void speak() = 0;
};

class Dog: public Base {
    public:
    void eat() override { cout << "eating dog food" << endl; }
    void speak() override { cout << "woof"  << endl; }
};
```
---
```C++
class Person: public Base {
    public:
    void eat() override { cout << "eating pizza" << endl; }
    void speak() override { cout << "hello"  << endl; }
};

class Robot: public Base {
    public:
    void eat() override { cout << "charging" << endl; }
    void speak() override { cout << "operational" << endl; }
};

class Slug: public Base {
    public:
    void eat() override { cout << "eating grass"  << endl; }
    void speak() override {}
};
```
---
```C++
void nourish(Base* base) {
    base->eat();
    base->speak();
}

int main() {
    Base* subjects[] = { new Dog(), new Person(), new Robot(), new Slug() };
    for(Base* subject: subjects)
      nourish(subject);
}

/*
eating dog food
woof
eating pizza
hello
charging
operational
eating grass
*/
```
