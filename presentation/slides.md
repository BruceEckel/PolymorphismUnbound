---
marp: true
theme: default
footer: 'Footer content'
---
<!-- backgroundImage: "linear-gradient(to bottom, #67b8e3, #0288d1)" -->
# How we got here
## Simula
- A simulation needs a common interface for all simulation elements.
  - So you can tell them all to update themselves.

## Smalltalk
- Takes Simula concept and applies it to all elements
  * BUT Smalltalk is inherently dynamic
  * It's really about "message-oriented programming"
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
