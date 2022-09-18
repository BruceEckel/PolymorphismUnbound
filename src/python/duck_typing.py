#: src/python/duck_typing.py
class Person:
    def eat(self): print("eating pizza")

class Robot:
    def eat(self): print("charging")

def nourish(subject: object):
    subject.eat()  # Duck typing

if __name__ == '__main__':
    for subject in [Person(), Robot()]:
        nourish(subject)
    # nourish("")  # Runtime error
