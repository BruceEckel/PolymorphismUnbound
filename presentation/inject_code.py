from pathlib import Path
from reporting import Error, Debug
import sys

error = Error()
debug = Debug()
debug2 = Debug()

def expand(path: Path, file_ext: str, comment_chars: str) -> str:
    if not path.exists():
        error(f"Cannot locate {path.resolve()}")
        return f"Cannot locate {path.resolve()}"
    code = path.read_text().replace('\t', '    ')
    code2 = code.replace(comment_chars + "---", f"```\n---\n```{file_ext}")
    code3 = f"```{file_ext}\n{code2.strip()}\n```\n------\n"
    return code3

def main(source_file: str):
    result = []
    for line in Path("source.md").read_text().splitlines():
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
    Path("slides.md").write_text(new_markdown)

if __name__ == '__main__':
    try:
        arg = sys.argv[1]
    except IndexError:
        raise SystemExit(f"Usage: {sys.argv[0]} <source_file.md>")
    main(sys.argv[1])
    error.report()


# For expanded listings:
# import re
# complete_listing = re.compile("```(.*?)\n(//:|#:)(.*?)\n(.*?)\n```\n------", re.DOTALL)
#
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
