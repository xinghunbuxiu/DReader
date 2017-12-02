package com.duokan.reader.domain.cloud;

public class bk {
    public long a = 0;
    public long b = 0;
    public long c = 0;

    public boolean equals(Object obj) {
        if (!(obj instanceof bk)) {
            return false;
        }
        bk bkVar = (bk) obj;
        if (this.a == bkVar.a && this.b == bkVar.b && this.c == bkVar.c) {
            return true;
        }
        return false;
    }

    public int a(long j) {
        int i = 0;
        if (this.a > j) {
            i = 1;
        }
        if (this.b > j) {
            i++;
        }
        if (this.c > j) {
            return i + 1;
        }
        return i;
    }
}
