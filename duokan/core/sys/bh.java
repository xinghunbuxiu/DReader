package com.duokan.core.sys;

public class bh extends q {
    final /* synthetic */ bd a;
    private final av b;
    private final at c;
    private long d = 0;

    public /* synthetic */ q a() {
        return c();
    }

    public /* synthetic */ Object clone() {
        return c();
    }

    public bh(bd bdVar, av avVar, at atVar) {
        this.a = bdVar;
        this.b = avVar;
        this.c = atVar;
    }

    public void close() {
        this.b.c(this.c);
    }

    public void flush() {
        this.b.b(this.c);
    }

    public void write(int i) {
        long j = this.d;
        byte[] bArr = new byte[]{(byte) i};
        this.d = ((long) this.b.b(this.c, j, bArr, 0, bArr.length)) + j;
    }

    public void write(byte[] bArr) {
        long j = this.d;
        this.d = ((long) this.b.b(this.c, j, bArr, 0, bArr.length)) + j;
    }

    public void write(byte[] bArr, int i, int i2) {
        long j = this.d;
        this.d = ((long) this.b.b(this.c, j, bArr, i, i2)) + j;
    }

    protected void finalize() {
        super.finalize();
        if (this.c.a()) {
            close();
        }
    }

    public bh c() {
        bh bhVar = new bh(this.a, this.b, this.b.a(this.c));
        bhVar.d = this.d;
        return bhVar;
    }

    public long b() {
        return this.c.b();
    }
}
