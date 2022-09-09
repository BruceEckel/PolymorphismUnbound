#: src/python/disjoint_types.py
class Dog:
    def eat(self): print("eating dog food")
    def bark(self): print("woof")

class Person:
    def eat(self): print("eating pizza")
    def greet(self): print("hello")

class Robot:
    def eat(self): print("charging")
    def initiate(self): print("operational")

class Slug:
    def eat(self): print("eating grass")

def nourish(subject):
    subject.eat()  # Duck typing
    if type(subject) is Dog: subject.bark()
    if type(subject) is Person: subject.greet()
    if type(subject) is Robot: subject.initiate()

# Sumtype polymorphism:
def nourish2(subject: Dog | Person | Robot | Slug):
    subject.eat()
    match subject:
        case Dog(): subject.bark()
        case Person(): subject.greet()
        case Robot(): subject.initiate()

if __name__ == '__main__':
    for subject in [Dog(), Person(), Robot(), Slug()]:
        nourish(subject)
        nourish2(subject)
        # nourish2("")
