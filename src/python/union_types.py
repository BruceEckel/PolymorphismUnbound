#: src/python/union_types.py
from disjoint_types import Person, Robot

def nourish(combined: Person | Robot):
    match combined:  # No exhaustiveness checking
        case Person(): combined.consume()
        case Robot(): combined.charge()

if __name__ == '__main__':
    for subject in [Person(), Robot()]:
        nourish(subject)
    # nourish("")  # Type-check error
