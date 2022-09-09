from pathlib import Path
import re
from pprint import pprint
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

complete_listing = re.compile("```(.*?)\n//:(.*?)\n(.*?)\n```\n------", re.DOTALL)

if __name__ == '__main__':
  slides = Path("slides.md")
  markdown = slides.read_text()
  # for group in re.findall("```(.*?)\n(.*?)\n```", markdown, re.DOTALL):
  #   print(group)
  for group in complete_listing.findall(markdown):
    print(group[0])
    print(group[1])
    pprint(group[2])
    print('-' * 80)
