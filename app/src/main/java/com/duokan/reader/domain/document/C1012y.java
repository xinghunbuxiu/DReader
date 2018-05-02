package com.duokan.reader.domain.document;

import com.duokan.kernel.DkStream;
import java.io.InputStream;

/* renamed from: com.duokan.reader.domain.document.y */
public class C1012y extends InputStream {
    /* renamed from: a */
    private final C0899j f5022a;
    /* renamed from: b */
    private final DkStream f5023b;

    public C1012y(C0899j c0899j, DkStream dkStream) {
        this.f5022a = c0899j;
        this.f5023b = dkStream;
        this.f5022a.mo1260f();
    }

    /* renamed from: a */
    public long m7783a() {
        return this.f5023b.length();
    }

    public int available() {
        return this.f5023b.available();
    }

    public void close() {
        this.f5023b.close();
        this.f5022a.mo1261g();
    }

    public void mark(int i) {
        this.f5023b.mark(i);
    }

    public boolean markSupported() {
        return this.f5023b.markSupported();
    }

    public int read() {
        return this.f5023b.read();
    }

    public int read(byte[] bArr, int i, int i2) {
        return this.f5023b.read(bArr, i, i2);
    }

    public int read(byte[] bArr) {
        return this.f5023b.read(bArr);
    }

    public void reset() {
        this.f5023b.reset();
    }

    public long skip(long j) {
        return this.f5023b.skip(j);
    }

    public Object clone() {
        return new C1012y(this.f5022a, (DkStream) this.f5023b.clone());
    }
}
