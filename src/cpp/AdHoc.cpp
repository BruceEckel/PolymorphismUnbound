//: src/cpp/AdHoc.cpp
// All C++ examples tested with https://cpp.sh
#include <string>
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

void nourish(Person p) { p.eat(); }

void nourish(Robot r) { r.charge(); }

int main() {
    nourish(Person());
    nourish(Robot());
}
