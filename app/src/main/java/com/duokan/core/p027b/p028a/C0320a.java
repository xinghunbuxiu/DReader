package com.duokan.core.p027b.p028a;

import android.util.Pair;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.duokan.core.b.a.a */
public class C0320a {
    /* renamed from: a */
    public int f545a = 5000;
    /* renamed from: b */
    public int f546b = 10000;
    /* renamed from: c */
    public int f547c = 0;
    /* renamed from: d */
    public int f548d = 8192;
    /* renamed from: e */
    public List<Pair<String, String>> f549e = null;

    /* renamed from: a */
    public C0320a m721a(int i) {
        this.f547c = i;
        return this;
    }

    /* renamed from: b */
    public C0320a m724b(int i) {
        this.f548d = i;
        return this;
    }

    /* renamed from: a */
    public C0320a m723a(List<Pair<String, String>> list) {
        this.f549e = list;
        return this;
    }

    /* renamed from: a */
    public C0320a m722a(String str, String str2) {
        if (this.f549e == null) {
            this.f549e = new LinkedList();
        }
        this.f549e.add(new Pair(str, str2));
        return this;
    }
}
