package com.duokan.reader.domain.document;

import com.duokan.kernel.DkStream;

import java.io.InputStream;

public class y extends InputStream {
    private final j a;
    private final DkStream b;

    public y(j jVar, DkStream dkStream) {
        this.a = jVar;
        this.b = dkStream;
        this.a.f();
    }

    public long a() {
        return this.b.length();
    }

    public int available() {
        return this.b.available();
    }

    public void close() {
        this.b.close();
        this.a.g();
    }

    public void mark(int i) {
        this.b.mark(i);
    }

    public boolean markSupported() {
        return this.b.markSupported();
    }

    public int read() {
        return this.b.read();
    }

    public int read(byte[] bArr, int i, int i2) {
        return this.b.read(bArr, i, i2);
    }

    public int read(byte[] bArr) {
        return this.b.read(bArr);
    }

    public void reset() {
        this.b.reset();
    }

    public long skip(long j) {
        return this.b.skip(j);
    }

    public Object clone() {
        return new y(this.a, (DkStream) this.b.clone());
    }
}
