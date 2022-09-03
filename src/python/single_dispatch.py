from functools import singledispatch

class Dog:
    def eat(self): print("eating dog food")
    def bark(self): print("woof")

class Person:
    def eat(self): print("eating pizza")
    def greet(self): print("hello")

class Robot:
    def eat(self): print("recharging")
    def initiate(self): print("operational")

class Slug:
    def eat(self): print("eating grass")

@singledispatch
def nourish(subject):
    print("default nourish")

@nourish.register
def _(subject: Dog):
    subject.eat()
    subject.bark()

@nourish.register
def _(subject: Person):
    subject.eat()
    subject.greet()

@nourish.register
def _(subject: Robot):
    subject.eat()
    subject.initiate()

@nourish.register
def _(subject: Slug):
    subject.eat()

if __name__ == '__main__':
    for subj in [Dog(), Person(), Robot(), Slug(), ""]:
        nourish(subj)
        nourish("")
