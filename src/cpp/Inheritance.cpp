//: src/cpp/Inheritance.cpp
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
//---
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
//---
void nourish(Base* base) {
    base->eat();
    base->speak();
}

int main() {
    Base* subjects[] = { new Dog(), new Person(), new Robot(), new Slug() };
    for(Base* subject: subjects)
      nourish(subject);
}
