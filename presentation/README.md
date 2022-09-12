# Presentation Generation Tools

This presentation (`slides.html`) is generated by converting a Markdown file
(`source.md`) into [Marp](https://marp.app/)'s HTML slide presentation format.

The file `source.md` is the file to edit, as `slides.md` is generated from
`source.md` using `inject_code.py` (thus, do not edit `slides.md` as it will be
overwritten). `source.md` contains directives that look like this:

```
|==> //: relative/path/to/source-code-file
```

This inserts the contents of `source-code-file` along with markdown code-listing begin & end markers. In addition, when it sees:

```
//---
```

It will insert a break in the code listing so that the resulting slides are
properly paginated.

The following PowerShell command runs `inject_code.py` to produce `slides.md`,
then runs `marp` to produce `slides.html`. Finally it uses `start` to open
`slides.html` in a browser window:

```ps1
python .\inject_code.py; marp .\slides.md; start .\slides.html
```