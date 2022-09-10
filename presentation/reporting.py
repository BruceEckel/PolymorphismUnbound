# Error and Debug reporting tools

class Error:
    def __init__(self):
        self.messages: str = ""
    def __call__(self, msg: str):
        self.messages += msg + "\n"
    def report(self):
        for msg in self.messages.splitlines():
            print(f"Error: {msg}")

class Debug:
    def __init__(self):
        self.messages: str = ""
    def __call__(self, msg: object):
        self.messages += str(msg) + "\n"
    def report(self):
        print(self.messages)
