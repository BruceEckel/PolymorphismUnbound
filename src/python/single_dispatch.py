#: src/python/single_dispatch.py
from functools import singledispatch
from disjoint_types import Dog, Person, Robot, Slug

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
    for subject in [Dog(), Person(), Robot(), Slug(), ""]:
        nourish(subject)
