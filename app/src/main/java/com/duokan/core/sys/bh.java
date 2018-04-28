package com.duokan.core.sys;

public class bh extends C0354q {
    /* renamed from: a */
    final /* synthetic */ bd f704a;
    /* renamed from: b */
    private final av f705b;
    /* renamed from: c */
    private final at f706c;
    /* renamed from: d */
    private long f707d = 0;

    /* renamed from: a */
    public /* synthetic */ C0354q mo430a() {
        return m988c();
    }

    public /* synthetic */ Object clone() {
        return m988c();
    }

    public bh(bd bdVar, av avVar, at atVar) {
        this.f704a = bdVar;
        this.f705b = avVar;
        this.f706c = atVar;
    }

    public void close() {
        this.f705b.m926c(this.f706c);
    }

    public void flush() {
        this.f705b.m923b(this.f706c);
    }

    public void write(int i) {
        long j = this.f707d;
        byte[] bArr = new byte[]{(byte) i};
        this.f707d = ((long) this.f705b.m920b(this.f706c, j, bArr, 0, bArr.length)) + j;
    }

    public void write(byte[] bArr) {
        long j = this.f707d;
        this.f707d = ((long) this.f705b.m920b(this.f706c, j, bArr, 0, bArr.length)) + j;
    }

    public void write(byte[] bArr, int i, int i2) {
        long j = this.f707d;
        this.f707d = ((long) this.f705b.m920b(this.f706c, j, bArr, i, i2)) + j;
    }

    protected void finalize() {
        super.finalize();
        if (this.f706c.mo412a()) {
            close();
        }
    }

    /* renamed from: c */
    public bh m988c() {
        bh bhVar = new bh(this.f704a, this.f705b, this.f705b.m915a(this.f706c));
        bhVar.f707d = this.f707d;
        return bhVar;
    }

    /* renamed from: b */
    public long mo431b() {
        return this.f706c.mo413b();
    }
}
