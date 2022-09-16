#: src/python/protocols.py
from typing import Protocol

class Person:
    def eat(self): print("eating pizza")
    def speak(self): print("hello")

class Robot:
    def eat(self): print("charging")
    def speak(self): print("operational")

class Base(Protocol):
    def eat(self): ...
    def speak(self): ...

def nourish(subject: Base):
    subject.eat()
    subject.speak()

if __name__ == '__main__':
    for subject in [Person(), Robot()]:
        nourish(subject)
