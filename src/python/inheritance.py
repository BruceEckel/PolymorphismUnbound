#: src/python/inheritance.py
from base import Base

class Person(Base):
    def eat(self): print("eating pizza")

class Robot(Base):
    def eat(self): print("charging")

def nourish(subject: Base):
    subject.eat()

if __name__ == '__main__':
    for subject in [Person(), Robot()]:
        nourish(subject)
