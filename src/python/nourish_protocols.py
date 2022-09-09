#: src/python/nourish_protocols.py
from typing import Protocol

class Dog:
    def eat(self) -> None: print("eating dog food")
    def speak(self) -> None: print("woof")

class Person:
    def eat(self) -> None: print("eating pizza")
    def speak(self) -> None: print("hello")

class Robot:
    def eat(self) -> None: print("charging")
    def speak(self) -> None: print("operational")

class Slug:
    def eat(self) -> None: print("eating grass")
    def speak(self) -> None: pass

class Base(Protocol):
    def eat(self) -> None: ...
    def speak(self) -> None: ...

def nourish_inheritance(subject: Base):
    subject.eat()
    subject.speak()

if __name__ == '__main__':
    for subj in [Dog(), Person(), Robot(), Slug()]:
        nourish_inheritance(subj)
