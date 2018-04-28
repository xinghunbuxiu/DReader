package com.duokan.reader.domain.cloud;

public class bb {
    /* renamed from: a */
    public long f3740a = 0;
    /* renamed from: b */
    public long f3741b = 0;
    /* renamed from: c */
    public long f3742c = 0;

    public boolean equals(Object obj) {
        if (!(obj instanceof bb)) {
            return false;
        }
        bb bbVar = (bb) obj;
        if (this.f3740a == bbVar.f3740a && this.f3741b == bbVar.f3741b && this.f3742c == bbVar.f3742c) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public int m5342a(long j) {
        int i = 0;
        if (this.f3740a > j) {
            i = 1;
        }
        if (this.f3741b > j) {
            i++;
        }
        if (this.f3742c > j) {
            return i + 1;
        }
        return i;
    }
}
