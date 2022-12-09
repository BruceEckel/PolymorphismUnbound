#: src/python/single_dispatch.py
from functools import singledispatch
from disjoint_types import Person, Robot

@singledispatch
def nourish(subject):
    print("default nourish")

@nourish.register
def _(subject: Person):
    print("Person")
    subject.consume()

@nourish.register
def _(subject: Robot):
    print("Robot")
    subject.charge()

if __name__ == '__main__':
    for subject in [Person(), Robot(), ""]:
        nourish(subject)
