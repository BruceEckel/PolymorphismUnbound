# Reporting tools for Error, Debug, Logging, etc.
"""
# Use like this:
error = Error()
trace = Debug()
log = Debug(False)  # Turn off logging output
...
trace("something maybe interesting")
log("something notable")
error("yikes")
...
trace.report() # Don't do this if you don't want debug info
log.report()
error.report()
"""
# Output to file?
import colorama

colorama.init(autoreset=True)

class Reporter:
    def __init__(self, output: bool = True):
        self.output = output
        self.messages: str = ""
    def __call__(self, msg: object):
        self.messages += str(msg) + "\n"
    def report(self):
        if self.output:
            print(self.messages)

class Error(Reporter):
    highlight = colorama.Style.BRIGHT + colorama.Fore.RED
    def report(self):
        if self.messages:
            raise SystemExit(f"{Error.highlight}Error:\n\t" +
                             "\n\t".join(self.messages.splitlines()))

class Debug(Reporter):
    pass
