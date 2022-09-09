from pathlib import Path
import re
DEBUG = True
if DEBUG:
  def debug(msg: str):
    print(msg)
else:
  def debug(msg: str):
    pass
"""
A listing begins with:
```languageID
//: ...
or
#: ...
And ends with:
```
------
(6-character line instead of required 3 to indicate this is the end of a listing and not an internal page break)
"""

complete_listing = re.compile("```(.*?)\n(//:|#:)(.*?)\n(.*?)\n```\n------", re.DOTALL)

if __name__ == '__main__':
  slides = Path("slides.md")
  markdown = slides.read_text()
  for n, group in enumerate(complete_listing.findall(markdown)):
    language_tag = group[0]
    start_tag = group[1].strip()
    file_path = group[2].strip()
    body = group[3]
    debug(f"{n = }")
    debug(f"{language_tag = }")
    debug(f"{start_tag = }")
    debug(f"{file_path = }")
    debug(body)
    debug('-' * 40)
  slash_starts = markdown.count("//:")
  pound_starts = markdown.count("#:")
  debug(f"{slash_starts = }")
  debug(f"{pound_starts = }")
