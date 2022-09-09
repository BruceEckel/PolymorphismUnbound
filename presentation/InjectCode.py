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

complete_listing = re.compile("```(.*?)\n(//:|#:)(.*?)\n(.*?)\n```\n------", re.DOTALL)

if __name__ == '__main__':
  slides = Path("slides.md")
  markdown = slides.read_text()
  for n, group in enumerate(complete_listing.findall(markdown)):
    language_tag = group[0]
    start_tag = group[1].strip()
    file_path = group[2].strip()
    body = group[3]
    print(f"{n = }")
    print(f"{language_tag = }")
    print(f"{start_tag = }")
    print(f"{file_path = }")
    print(body)
    print('-' * 80)
  slash_starts = markdown.count("//:")
  pound_starts = markdown.count("#:")
  print(f"{slash_starts = }")
  print(f"{pound_starts = }")
