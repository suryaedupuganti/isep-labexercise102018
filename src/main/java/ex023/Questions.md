## Questions

### Q1. What is the difference between this stream Reader/Writer et InputStream/OutputStream?

OutputStream classes writes to the target byte by byte where as Writer classes writes to the target character by character
Writers provide more flexibility in that they can write characters and even strings while taking a special encoding into account. 

### Which text network protocols do you know?



### How can the objects discovered here be relevant in the analysis of such protocols?

Whenever you want to handle the binary data then you need to use the InputStream/OutputStream classes (generally, everything that contains Stream in its name).

That's why there's a FileInputStream and a FileOutputStream: those read from and write to files and they handle binary data.

Whenever you want to handle text data, then you need to use the Reader/Writer classes.