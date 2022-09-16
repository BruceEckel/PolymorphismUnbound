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
