from pathlib import Path

slides_html = Path("slides.html")

old = "#fff8e1"
new = "white"

whitened = slides_html.read_text().replace(old, new)
# Path("whitened.html").write_text(whitened)
slides_html.write_text(whitened)

