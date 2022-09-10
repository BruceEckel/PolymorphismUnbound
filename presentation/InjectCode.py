import pprint
from pathlib import Path
import re
from typing import List
DEBUG = True
if DEBUG:
  def debug(msg: str):
    print(msg)
else:
  def debug(msg: str):
    pass

# For expanded listings:
complete_listing = re.compile("```(.*?)\n(//:|#:)(.*?)\n(.*?)\n```\n------", re.DOTALL)

def expand(path: Path, file_ext: str, comment_chars: str) -> List[str]:
  if not path.exists():
    print(f"Cannot locate {path.resolve()}")
    return f"Cannot locate {path.resolve()}"
  code = path.read_text().replace('\t', '    ')
  code2 = code.replace(comment_chars + "---", f"```\n---\n```{file_ext}\n")
  code3 = f"```{file_ext}\n{code2}\n```\n------\n"
  return code3


if __name__ == '__main__':
  source = Path("source.md")
  markdown = source.read_text().splitlines()
  result = []
  for line in markdown:
    if line.startswith("|==>"):
      header = line.split("|==>")[1].strip()
      # debug(header)
      start_tag, file_location = header.split()
      comment_chars = start_tag.split(':')[0]
      debug(comment_chars)
      file_path = Path("..") / file_location
      file_ext = file_path.suffix[1:]
      debug(file_path)
      debug(file_path.exists())
      debug(file_ext)
      result.append(expand(file_path, file_ext, comment_chars))
    else:
      result.append(line)
  new_markdown = "\n".join(result)
  debug(new_markdown)
  Path("generated.md").write_text(new_markdown)






# def old():
#   slides = Path("slides.md")
#   markdown = slides.read_text()
#   for n, group in enumerate(complete_listing.findall(markdown)):
#     language_tag = group[0]
#     start_tag = group[1].strip()
#     file_path = group[2].strip()
#     body = group[3]
#     debug(f"{n = }")
#     debug(f"{language_tag = }")
#     debug(f"{start_tag = }")
#     debug(f"{file_path = }")
#     debug(body)
#     debug('-' * 40)
#   slash_starts = markdown.count("//:")
#   pound_starts = markdown.count("#:")
#   debug(f"{slash_starts = }")
#   debug(f"{pound_starts = }")
