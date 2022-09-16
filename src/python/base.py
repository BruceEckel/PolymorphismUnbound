#: src/python/base.py
from abc import ABC, abstractmethod

class Base(ABC):
    @abstractmethod
    def eat(self) -> None: ...
