//: src/cpp/StructuralTyping.cpp
#include <variant>  // C++ 17
#include <iostream>
using namespace std;

class Dog {
    public:
    void eat() { cout << "eating dog food" << endl; }
};

class Person {
    public:
    void eat() { cout << "eating pizza" << endl; }
};
//---
class Robot {
    public:
    void eat() { cout << "charging" << endl; }
};

class Slug {
    public:
    void eat() { cout << "eating grass"  << endl; }
};
//---
// 'Structural typing' aka 'duck typing'
template <class T>
void nourish(T subject) {
    subject.eat();
}

int main() {
    nourish(Dog());
    nourish(Person());
    nourish(Robot());
    nourish(Slug());
}
