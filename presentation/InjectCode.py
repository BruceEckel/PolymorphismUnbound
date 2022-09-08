from pathlib import Path
import re

slides = Path("slides.md")
markdown = slides.read_text()
# print(markdown)
for group in re.findall("```(.*?)\n(.*?)\n```", markdown, re.DOTALL):
  print(group)
