//: src/cpp/AdHoc.cpp
// All C++ examples tested with https://cpp.sh
#include <string>
#include <iostream>
using namespace std;

void f(string s) {
    cout << "f(string): " << s << endl;
}

void f(float f) {
    cout << "f(float): " << f << endl;
}

int main() {
    f("hi");
    f(42.24);
}
