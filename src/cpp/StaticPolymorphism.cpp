// src/cpp/StaticPolymorphism.cpp
// Tested with https://cpp.sh
#include <variant>  // C++ 17
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

class Robot {
    public:
    void eat() { cout << "charging" << endl; }
    void initiate() { cout << "operational" << endl; }
};

class Slug {
    public:
    void eat() { cout << "eating grass"  << endl; }
};

template <class T>
void nourish(T subject) {
    subject.eat();
}

void speak(variant<Dog, Person, Robot, Slug> sumTypeObj) {
    if(auto dogPtr(get_if<Dog>(&sumTypeObj)); dogPtr)
        dogPtr->bark();
    else if(auto personPtr(get_if<Person>(&sumTypeObj)); personPtr)
        personPtr->greet();
    else if(auto robotPtr(get_if<Robot>(&sumTypeObj)); robotPtr)
        robotPtr->initiate();
}

int main() {
    nourish(Dog());
    nourish(Person());
    nourish(Robot());
    nourish(Slug());
    // nourish(""); // template specialization 'nourish<const char *>' requested
    speak(Dog());
    speak(Person());
    speak(Robot());
    speak(Slug());
    // speak(""); // no known conversion to 'variant<Dog, Person, Robot, Slug>'
}

/*
eating dog food
eating pizza
charging
eating grass
woof
hello
operational
*/
