## Questions

### Q1. Why is it interesting to use buffered streams?

The BufferedStreams class provides buffering to your streams. Buffering can speed up IO quite a bit. Rather than read/write one byte at a time from the network or disk, the BufferedStream reads/writes a larger block at a time into an internal buffer. When you read a byte from the BufferedInputStream you are therefore reading it from its internal buffer. When the buffer is fully read, the BufferedInputStream reads another larger block of data into the buffer. This is typically much faster than reading a single byte at a time from an InputStream, especially for disk access and larger data amounts. 