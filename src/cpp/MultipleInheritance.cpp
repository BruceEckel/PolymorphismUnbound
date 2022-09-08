// src/cpp/MultipleInheritance.cpp
// Combining disjoint types using MI
#include <iostream>
using namespace std;

class Dog {
    public:
    void eat() { cout << "eating dog food" << endl; }
    void bark() { cout << "woof"  << endl; }
};

class Person {
    public:
    void eat() { cout << "eating pizza" << endl; }
    void greet() { cout << "hello"  << endl; }
};
//---
class Robot {
    public:
    void eat() { cout << "charging" << endl; }
    void initiate() { cout << "operational" << endl; }
};

class Slug {
    public:
    void eat() { cout << "eating grass"  << endl; }
};
//---
class Base {
    public:
    virtual void eat() = 0;  // Pure virtual function
    virtual void speak() = 0;
};

class Dog2: public Dog, public Base {
    public:
    void eat() override { Dog::eat(); }
    void speak() override { bark(); }
};
//---
class Person2: public Person, public Base {
    public:
    void eat() override { Person::eat(); }
    void speak() override { greet(); }
};

class Robot2: public Robot, public Base {
    public:
    void eat() override { Robot::eat(); }
    void speak() override { initiate(); }
};

class Slug2: public Slug, public Base {
    public:
    void eat() override { Slug::eat(); }
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
