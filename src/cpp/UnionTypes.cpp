//: src/cpp/UnionTypes.cpp
#include <variant>  // C++ 17
#include <iostream>
using namespace std;

class Person {
    public:
    void eat() { cout << "eating pizza" << endl; }
};

class Robot {
    public:
    void charge() { cout << "charging" << endl; }
};

typedef variant<Person, Robot> unionType;

void nourish(unionType combined) {
    if(auto personPtr(get_if<Person>(&combined)); personPtr) {
        personPtr->eat();
    }
    else if(auto robotPtr(get_if<Robot>(&combined)); robotPtr) {
        robotPtr->charge();
    }
    // No exhaustiveness checking (comment out the 'else if' clause)
}

int main() {
    unionType subjects[] = { Person(), Robot() };
    for(unionType subject: subjects)
      nourish(subject);
}
