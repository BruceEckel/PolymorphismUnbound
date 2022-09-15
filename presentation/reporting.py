# Error and Debug reporting tools
import colorama

colorama.init(autoreset=True)
highlight_text = colorama.Style.BRIGHT + colorama.Fore.RED

class Reporter:
    def __init__(self):
        self.messages: str = ""
    def __call__(self, msg: object):
        self.messages += str(msg) + "\n"
    def report(self):
        print(self.messages)

class Error(Reporter):
    def report(self):
        if self.messages:
            raise SystemExit(f"{highlight_text}Error:\n\t" + "\n\t".join(self.messages.splitlines()))

class Debug(Reporter):
    pass
