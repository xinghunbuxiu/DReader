package com.duokan.core.sys;

import java.nio.ByteBuffer;

class bg extends p {
    final /* synthetic */ bd a;
    private final av b;
    private final at c;
    private long d = 0;

    public /* synthetic */ p a() {
        return d();
    }

    public /* synthetic */ Object clone() {
        return d();
    }

    public bg(bd bdVar, av avVar, at atVar) {
        this.a = bdVar;
        this.b = avVar;
        this.c = atVar;
    }

    public int available() {
        return (int) (this.c.b() - this.d);
    }

    public void close() {
        this.b.c(this.c);
    }

    public void mark(int i) {
    }

    public boolean markSupported() {
        return false;
    }

    public int read() {
        long j = this.d;
        byte[] bArr = new byte[1];
        int a = this.b.a(this.c, j, bArr, 0, bArr.length);
        this.d = j + ((long) a);
        return a;
    }

    public int read(byte[] bArr) {
        long j = this.d;
        int a = this.b.a(this.c, j, bArr, 0, bArr.length);
        this.d = j + ((long) a);
        return a;
    }

    public int read(byte[] bArr, int i, int i2) {
        long j = this.d;
        ByteBuffer.wrap(bArr, i, i2);
        int a = this.b.a(this.c, j, bArr, i, i2);
        this.d = j + ((long) a);
        return a;
    }

    public void reset() {
    }

    public long skip(long j) {
        long j2 = this.d;
        long min = Math.min(j2 + j, this.c.b());
        this.d = min;
        return min - j2;
    }

    protected void finalize() {
        super.finalize();
        if (this.c.a()) {
            close();
        }
    }

    public bg d() {
        bg bgVar = new bg(this.a, this.b, this.b.a(this.c));
        bgVar.d = this.d;
        return bgVar;
    }

    public boolean b() {
        return this.c.a();
    }

    public long c() {
        return this.c.b();
    }

    public void a(long j) {
        this.d = Math.max(0, Math.min(j, this.c.b()));
    }
}
