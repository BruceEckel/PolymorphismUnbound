//: src/cpp/MultipleInheritance.cpp
// Combining disjoint types using MI
#include <iostream>
using namespace std;

class Dog {
    public:
    void gulp() { cout << "eating dog food" << endl; }
    void bark() { cout << "woof"  << endl; }
};

class Person {
    public:
    void scarf() { cout << "eating pizza" << endl; }
    void greet() { cout << "hello"  << endl; }
};
//---
class Robot {
    public:
    void charge() { cout << "charging" << endl; }
    void initiate() { cout << "operational" << endl; }
};

class Slug {
    public:
    void absorb() { cout << "eating grass"  << endl; }
};
//---
class Base {
    public:
    virtual void eat() = 0;  // Pure virtual function
    virtual void speak() = 0;
};

class Dog2: public Base, private Dog {
    public:
    void eat() override { gulp(); }
    void speak() override { bark(); }
};
//---
class Person2: public Base, private Person {
    public:
    void eat() override { scarf(); }
    void speak() override { greet(); }
};

class Robot2: public Base, private Robot {
    public:
    void eat() override { charge(); }
    void speak() override { initiate(); }
};

class Slug2: public Base, private Slug {
    public:
    void eat() override { absorb(); }
    void speak() override {}
};
//---
void nourish(Base* base) {
    base->eat();
    base->speak();
}

int main() {
    Base* subjects[] = { new Dog2(), new Person2(), new Robot2(), new Slug2() };
    for(Base* subject: subjects)
      nourish(subject);
}
