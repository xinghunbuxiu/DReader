package com.duokan.reader.common.async.p035a;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.duokan.reader.common.async.a.b */
public class C0518b<TResult> implements C0517a<TResult> {
    /* renamed from: a */
    private final CopyOnWriteArrayList<C0517a<TResult>> f1751a = new CopyOnWriteArrayList();

    /* renamed from: a */
    public boolean m2233a() {
        return this.f1751a.isEmpty();
    }

    /* renamed from: a */
    public void m2231a(C0517a<TResult> c0517a) {
        this.f1751a.add(c0517a);
    }

    /* renamed from: b */
    public void m2234b() {
        this.f1751a.clear();
    }

    /* renamed from: a */
    public void mo730a(TResult tResult) {
        Iterator it = this.f1751a.iterator();
        while (it.hasNext()) {
            ((C0517a) it.next()).mo730a(tResult);
        }
    }

    /* renamed from: a */
    public void mo729a(int i, String str) {
        Iterator it = this.f1751a.iterator();
        while (it.hasNext()) {
            ((C0517a) it.next()).mo729a(i, str);
        }
    }
}
