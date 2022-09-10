#: src/python/protocols.py
from typing import Protocol

class Dog:
    def eat(self): print("eating dog food")
    def speak(self): print("woof")

class Person:
    def eat(self): print("eating pizza")
    def speak(self): print("hello")

class Robot:
    def eat(self): print("charging")
    def speak(self): print("operational")
# ---
class Slug:
    def eat(self): print("eating grass")
    def speak(self): pass

class Base(Protocol):
    def eat(self): ...
    def speak(self): ...

def nourish(subject: Base):
    subject.eat()
    subject.speak()

if __name__ == '__main__':
    for subject in [Dog(), Person(), Robot(), Slug()]:
        nourish(subject)
