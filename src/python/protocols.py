#: src/python/protocols.py
from typing import Protocol
from abc import abstractmethod

class Handler(Protocol):
    def download(self, path: str) -> None:
        ...
    def upload(self, data: str, path: str) -> None:
        ...

class FileHandler(Handler):
    def download(self, path: str) -> None:
        print("FileHandler download")

    def upload(self, data, path: str) -> None:
        print("FileHandler upload")

class NewFileHandler(Handler):
    def download(self, path: str) -> None:
        print("NewFileHandler download")

    def upload(self, data, path:str) -> None:
        print("NewFileHandler upload")

# Tell the static analyzer that handler is a Handler protocol.
# Further assignments to it must match the Handler protocol:
# handler: Handler

def new_handler(version:str) -> Handler:
    match version:
        case "old": return FileHandler()
        case "new": return NewFileHandler()

if __name__ == '__main__':
    for handler in [new_handler("old"), new_handler("new")]:
        handler.upload("", "")
        handler.download("")
