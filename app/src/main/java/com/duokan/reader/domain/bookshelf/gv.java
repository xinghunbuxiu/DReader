package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.C0352r;
import com.duokan.core.sys.C0353p;
import com.duokan.reader.domain.document.epub.ax;
import java.nio.ByteBuffer;

class gv implements ax {
    /* renamed from: a */
    final /* synthetic */ fp f3265a;
    /* renamed from: b */
    private final C0353p f3266b;
    /* renamed from: c */
    private final boolean f3267c;

    public /* synthetic */ Object clone() {
        return mo1079a();
    }

    public gv(fp fpVar, C0352r c0352r, String str, boolean z) {
        this.f3265a = fpVar;
        this.f3266b = c0352r.mo422c(str);
        this.f3267c = z;
    }

    public gv(fp fpVar, gv gvVar) {
        this.f3265a = fpVar;
        this.f3266b = gvVar.f3266b.mo425a();
        this.f3267c = gvVar.f3267c;
    }

    /* renamed from: a */
    public ax mo1079a() {
        return new gv(this.f3265a, this);
    }

    /* renamed from: a */
    public int mo1078a(ByteBuffer byteBuffer, long j) {
        byte[] bArr = new byte[8192];
        long remaining = j + ((long) byteBuffer.remaining());
        long j2 = j;
        while (j2 < remaining) {
            try {
                int min = (int) Math.min(remaining - j2, (long) bArr.length);
                this.f3266b.mo426a(j2);
                j2 += (long) this.f3266b.read(bArr, 0, min);
                byteBuffer.put(bArr, 0, min);
            } catch (Throwable th) {
            }
        }
        return (int) (j2 - j);
    }

    /* renamed from: b */
    public boolean mo1080b() {
        return this.f3266b.mo427b();
    }

    /* renamed from: c */
    public boolean mo1081c() {
        return this.f3267c;
    }

    /* renamed from: d */
    public long mo1082d() {
        return this.f3266b.mo428c();
    }

    /* renamed from: e */
    public void mo1083e() {
        try {
            this.f3266b.close();
        } catch (Throwable th) {
        }
    }
}
