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
