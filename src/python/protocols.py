#: src/python/protocols.py
from typing import Protocol
from inheritance import Person, Robot

class Base(Protocol):
    def eat(self): ...

def nourish(subject: Base):
    subject.eat()

if __name__ == '__main__':
    for subject in [Person(), Robot()]:
        nourish(subject)
