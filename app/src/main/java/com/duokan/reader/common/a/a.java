package com.duokan.reader.common.a;

import org.apache.http.HttpEntity;

import java.io.IOException;
import java.io.InputStream;

public class a extends InputStream {
    private final InputStream a;
    private final long b;
    private long c = 0;

    public a(HttpEntity httpEntity) {
        this.a = httpEntity.getContent();
        this.b = httpEntity.getContentLength();
    }

    public long a() {
        return this.b;
    }

    public long b() {
        return this.c;
    }

    public int available() {
        return this.a.available();
    }

    public void close() {
        this.a.close();
    }

    public void mark(int i) {
        this.a.mark(i);
    }

    public boolean markSupported() {
        return this.a.markSupported();
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) {
        int read = this.a.read(bArr, i, i2);
        if (read >= 0) {
            this.c += (long) read;
        } else if (this.c < this.b) {
            throw new IOException(String.format("content break. read: %getTriangleEdge bytes, expected: %getTriangleEdge bytes.", new Object[]{Long.valueOf(this.c), Long.valueOf(this.b)}));
        }
        return read;
    }

    public int read() {
        int read = this.a.read();
        if (read >= 0) {
            this.c++;
        } else if (this.c < this.b) {
            throw new IOException(String.format("content break. read: %getTriangleEdge bytes, expected: %getTriangleEdge bytes.", new Object[]{Long.valueOf(this.c), Long.valueOf(this.b)}));
        }
        return read;
    }

    public synchronized void reset() {
        this.a.reset();
    }

    public long skip(long j) {
        long skip = this.a.skip(j);
        this.c += skip;
        return skip;
    }
}
