import sys
from pathlib import Path
from reporting import Error, Debug

WIDTH = 75  # For placing language name tags

error = Error()
trace = Debug(False)

language_names = {
    'kt': '[Kotlin]',
    'scala': '[Scala]',
    'cpp': "[C++]",
    'java': "[Java]",
    'rs': "[Rust]",
    'go': "[Go]",
    'py': "[Python]"
}

def add_language_name(code: str) -> str:
    lines = code.splitlines()
    slug_line = lines[0]
    if not (slug_line.startswith("//:") or slug_line.startswith("#:")):
        error(f"{slug_line = }")
        return code
    extension = slug_line.split(".")[-1].lower()
    name = language_names[extension]
    gap = WIDTH - (len(slug_line) + len(name))
    if gap <=0:
        error(f"Too long: {slug_line = }")
    new_slug = slug_line + ' ' * gap + name
    trace(new_slug)
    lines[0] = new_slug
    return "\n".join(lines)

def expand(path: Path, file_ext: str, comment_chars: str) -> str:
    listing_type = ""  # Or file_ext for syntax highlighting
    if not path.exists():
        error(f"Cannot locate {path.resolve()}")
        return f"Cannot locate {path.resolve()}"
    code = add_language_name(path.read_text().replace('\t', '    '))
    code2 = code.replace(comment_chars + "---", f"```\n---\n```{listing_type}")
    code3 = f"```{listing_type}\n{code2.strip()}\n```\n------\n"
    return code3

def expand_listing(line: str) -> str:
    header = line.split("|==>")[1].strip()
    # trace(header)
    start_tag, file_location = header.split()
    comment_chars = start_tag.split(':')[0]
    trace(comment_chars)
    file_path = Path("..") / file_location
    file_ext = file_path.suffix[1:]
    trace(file_path)
    trace(file_path.exists())
    trace(file_ext)
    return expand(file_path, file_ext, comment_chars)

def main(source_file: str):
    if source_file == "slides.md":
        raise SystemExit(f"Cannot use 'slides.md' as source file")
    result = []
    for line in Path(source_file).read_text().splitlines():
        if line.startswith("|==>"):
            result.append(expand_listing(line))
        else:
            result.append(line)
    new_markdown = "\n".join(result)
    trace(new_markdown)
    Path("slides.md").write_text(new_markdown)

if __name__ == '__main__':
    try:
        arg = sys.argv[1]
    except IndexError:
        raise SystemExit(f"Usage: {sys.argv[0]} <source_file.md>")
    main(sys.argv[1])
    error.report()
    trace.report()


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
#     trace(f"{n = }")
#     trace(f"{language_tag = }")
#     trace(f"{start_tag = }")
#     trace(f"{file_path = }")
#     trace(body)
#     trace('-' * 40)
#   slash_starts = markdown.count("//:")
#   pound_starts = markdown.count("#:")
#   trace(f"{slash_starts = }")
#   trace(f"{pound_starts = }")
