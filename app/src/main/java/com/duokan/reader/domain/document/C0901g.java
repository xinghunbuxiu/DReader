package com.duokan.reader.domain.document;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

/* renamed from: com.duokan.reader.domain.document.g */
public abstract class C0901g {
    /* renamed from: a */
    private C0901g[] f4261a = null;

    /* renamed from: c */
    public abstract int mo1200c();

    /* renamed from: d */
    public abstract int mo1201d();

    /* renamed from: e */
    public abstract String mo1202e();

    /* renamed from: f */
    public abstract av mo1203f();

    /* renamed from: g */
    public abstract ak mo1204g();

    /* renamed from: h */
    public abstract int mo1205h();

    /* renamed from: i */
    public abstract int mo1206i();

    /* renamed from: j */
    public abstract C0901g[] mo1207j();

    /* renamed from: k */
    public abstract boolean mo1208k();

    /* renamed from: a */
    public int m5865a() {
        mo1432l();
        return this.f4261a.length;
    }

    /* renamed from: b */
    public C0901g[] m5867b() {
        mo1432l();
        return this.f4261a;
    }

    /* renamed from: a */
    public boolean m5866a(C0901g c0901g) {
        if (c0901g == this) {
            return true;
        }
        for (C0901g a : mo1207j()) {
            if (a.m5866a(c0901g)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: l */
    private void mo1432l() {
        if (this.f4261a == null) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(Arrays.asList(mo1207j()));
            ListIterator listIterator = linkedList.listIterator();
            while (listIterator.hasNext()) {
                C0901g[] j = ((C0901g) listIterator.next()).mo1207j();
                for (int length = j.length - 1; length >= 0; length--) {
                    listIterator.add(j[length]);
                    listIterator.previous();
                }
            }
            this.f4261a = (C0901g[]) linkedList.toArray(new C0901g[0]);
        }
    }
}
