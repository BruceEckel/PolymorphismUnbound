//: src/cpp/UnionTypes.cpp
#include <variant>  // C++ 17
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
// sumTypeObj is a 'union type':
void nourish(variant<Dog, Person, Robot, Slug> sumTypeObj) {
    if(auto dogPtr(get_if<Dog>(&sumTypeObj)); dogPtr) {
        dogPtr->gulp();
        dogPtr->bark();
    }
    else if(auto personPtr(get_if<Person>(&sumTypeObj)); personPtr) {
        personPtr->scarf();
        personPtr->greet();
    }
    else if(auto robotPtr(get_if<Robot>(&sumTypeObj)); robotPtr) {
        robotPtr->charge();
        robotPtr->initiate();
    }
    // No exhaustiveness checking
}

int main() {
    typedef variant<Dog, Person, Robot, Slug> Disjoint;
    Disjoint subjects[] = { Dog(), Person(), Robot(), Slug() };
    for(Disjoint subject: subjects)
      nourish(subject);
}
