package com.duokan.reader.common.p034a;

import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpEntity;

/* renamed from: com.duokan.reader.common.a.a */
public class C0511a extends InputStream {
    /* renamed from: a */
    private final InputStream f1730a;
    /* renamed from: b */
    private final long f1731b;
    /* renamed from: c */
    private long f1732c = 0;

    public C0511a(HttpEntity httpEntity) {
        this.f1730a = httpEntity.getContent();
        this.f1731b = httpEntity.getContentLength();
    }

    /* renamed from: a */
    public long m2214a() {
        return this.f1731b;
    }

    /* renamed from: b */
    public long m2215b() {
        return this.f1732c;
    }

    public int available() {
        return this.f1730a.available();
    }

    public void close() {
        this.f1730a.close();
    }

    public void mark(int i) {
        this.f1730a.mark(i);
    }

    public boolean markSupported() {
        return this.f1730a.markSupported();
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) {
        int read = this.f1730a.read(bArr, i, i2);
        if (read >= 0) {
            this.f1732c += (long) read;
        } else if (this.f1732c < this.f1731b) {
            throw new IOException(String.format("content break. read: %d bytes, expected: %d bytes.", new Object[]{Long.valueOf(this.f1732c), Long.valueOf(this.f1731b)}));
        }
        return read;
    }

    public int read() {
        int read = this.f1730a.read();
        if (read >= 0) {
            this.f1732c++;
        } else if (this.f1732c < this.f1731b) {
            throw new IOException(String.format("content break. read: %d bytes, expected: %d bytes.", new Object[]{Long.valueOf(this.f1732c), Long.valueOf(this.f1731b)}));
        }
        return read;
    }

    public synchronized void reset() {
        this.f1730a.reset();
    }

    public long skip(long j) {
        long skip = this.f1730a.skip(j);
        this.f1732c += skip;
        return skip;
    }
}
