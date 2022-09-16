#: src/python/multiple_inheritance.py
from base import Base
from disjoint_types import Person, Robot

class Person2(Person, Base):
    def eat(self): super().consume()

class Robot2(Robot, Base):
    def eat(self): super().charge()

def nourish(base: Base):
    base.eat()

if __name__ == '__main__':
    for subject in [Person2(), Robot2()]:
        nourish(subject)
