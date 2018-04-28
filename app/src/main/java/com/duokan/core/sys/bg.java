package com.duokan.core.sys;

import java.nio.ByteBuffer;

class bg extends C0353p {
    /* renamed from: a */
    final /* synthetic */ bd f700a;
    /* renamed from: b */
    private final av f701b;
    /* renamed from: c */
    private final at f702c;
    /* renamed from: d */
    private long f703d = 0;

    /* renamed from: a */
    public /* synthetic */ C0353p mo425a() {
        return m983d();
    }

    public /* synthetic */ Object clone() {
        return m983d();
    }

    public bg(bd bdVar, av avVar, at atVar) {
        this.f700a = bdVar;
        this.f701b = avVar;
        this.f702c = atVar;
    }

    public int available() {
        return (int) (this.f702c.mo413b() - this.f703d);
    }

    public void close() {
        this.f701b.m926c(this.f702c);
    }

    public void mark(int i) {
    }

    public boolean markSupported() {
        return false;
    }

    public int read() {
        long j = this.f703d;
        byte[] bArr = new byte[1];
        int a = this.f701b.m914a(this.f702c, j, bArr, 0, bArr.length);
        this.f703d = j + ((long) a);
        return a;
    }

    public int read(byte[] bArr) {
        long j = this.f703d;
        int a = this.f701b.m914a(this.f702c, j, bArr, 0, bArr.length);
        this.f703d = j + ((long) a);
        return a;
    }

    public int read(byte[] bArr, int i, int i2) {
        long j = this.f703d;
        ByteBuffer.wrap(bArr, i, i2);
        int a = this.f701b.m914a(this.f702c, j, bArr, i, i2);
        this.f703d = j + ((long) a);
        return a;
    }

    public void reset() {
    }

    public long skip(long j) {
        long j2 = this.f703d;
        long min = Math.min(j2 + j, this.f702c.mo413b());
        this.f703d = min;
        return min - j2;
    }

    protected void finalize() {
        super.finalize();
        if (this.f702c.mo412a()) {
            close();
        }
    }

    /* renamed from: d */
    public bg m983d() {
        bg bgVar = new bg(this.f700a, this.f701b, this.f701b.m915a(this.f702c));
        bgVar.f703d = this.f703d;
        return bgVar;
    }

    /* renamed from: b */
    public boolean mo427b() {
        return this.f702c.mo412a();
    }

    /* renamed from: c */
    public long mo428c() {
        return this.f702c.mo413b();
    }

    /* renamed from: a */
    public void mo426a(long j) {
        this.f703d = Math.max(0, Math.min(j, this.f702c.mo413b()));
    }
}
