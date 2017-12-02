package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.p;
import com.duokan.core.sys.r;
import com.duokan.reader.domain.document.epub.ax;

import java.nio.ByteBuffer;

class hb implements ax {
    final /* synthetic */ fv a;
    private final p b;
    private final boolean c;

    public /* synthetic */ Object clone() {
        return a();
    }

    public hb(fv fvVar, r rVar, String str, boolean z) {
        this.a = fvVar;
        this.b = rVar.c(str);
        this.c = z;
    }

    public hb(fv fvVar, hb hbVar) {
        this.a = fvVar;
        this.b = hbVar.b.a();
        this.c = hbVar.c;
    }

    public ax a() {
        return new hb(this.a, this);
    }

    public int a(ByteBuffer byteBuffer, long j) {
        byte[] bArr = new byte[8192];
        long remaining = j + ((long) byteBuffer.remaining());
        long j2 = j;
        while (j2 < remaining) {
            try {
                int min = (int) Math.min(remaining - j2, (long) bArr.length);
                this.b.a(j2);
                j2 += (long) this.b.read(bArr, 0, min);
                byteBuffer.put(bArr, 0, min);
            } catch (Throwable th) {
            }
        }
        return (int) (j2 - j);
    }

    public boolean b() {
        return this.b.b();
    }

    public boolean c() {
        return this.c;
    }

    public long d() {
        return this.b.c();
    }

    public void e() {
        try {
            this.b.close();
        } catch (Throwable th) {
        }
    }
}
