package com.duokan.core.sys;

import java.util.ArrayList;
import java.util.ListIterator;

/* renamed from: com.duokan.core.sys.d */
class C0356d implements ListIterator<C0359g> {
    /* renamed from: a */
    static final /* synthetic */ boolean f710a = (!AsyncCache.class.desiredAssertionStatus());
    /* renamed from: b */
    final /* synthetic */ int f711b;
    /* renamed from: c */
    final /* synthetic */ boolean f712c;
    /* renamed from: d */
    final /* synthetic */ ArrayList f713d;
    /* renamed from: e */
    final /* synthetic */ AsyncCache f714e;
    /* renamed from: f */
    private int f715f = this.f711b;
    /* renamed from: g */
    private int f716g;
    /* renamed from: h */
    private int f717h;

    C0356d(AsyncCache asyncCache, int i, boolean z, ArrayList arrayList) {
        this.f714e = asyncCache;
        this.f711b = i;
        this.f712c = z;
        this.f713d = arrayList;
        this.f716g = this.f712c ? this.f711b : -1;
        this.f717h = this.f712c ? this.f713d.size() - 1 : 0;
    }

    public /* synthetic */ void add(Object obj) {
        m990a((C0359g) obj);
    }

    public /* synthetic */ Object next() {
        return m989a();
    }

    public /* synthetic */ Object previous() {
        return m991b();
    }

    public /* synthetic */ void set(Object obj) {
        m992b((C0359g) obj);
    }

    /* renamed from: a */
    public void m990a(C0359g c0359g) {
        ((ListIterator) this.f713d.get(this.f717h)).add(c0359g);
        this.f715f++;
        this.f716g++;
    }

    public boolean hasNext() {
        return this.f716g + 1 < this.f711b;
    }

    public boolean hasPrevious() {
        return this.f716g + -1 >= 0;
    }

    /* renamed from: a */
    public C0359g m989a() {
        if (f710a || hasNext()) {
            this.f716g++;
            while (!((ListIterator) this.f713d.get(this.f717h)).hasNext()) {
                this.f717h++;
            }
            return (C0359g) ((ListIterator) this.f713d.get(this.f717h)).next();
        }
        throw new AssertionError();
    }

    public int nextIndex() {
        return this.f716g + 1;
    }

    /* renamed from: b */
    public C0359g m991b() {
        if (f710a || hasPrevious()) {
            this.f716g--;
            while (!((ListIterator) this.f713d.get(this.f717h)).hasPrevious()) {
                this.f717h--;
            }
            return (C0359g) ((ListIterator) this.f713d.get(this.f717h)).previous();
        }
        throw new AssertionError();
    }

    public int previousIndex() {
        return this.f716g - 1;
    }

    public void remove() {
        if (this.f716g >= 0 && this.f716g < this.f715f) {
            ((ListIterator) this.f713d.get(this.f717h)).remove();
            this.f715f--;
            this.f716g--;
        }
    }

    /* renamed from: b */
    public void m992b(C0359g c0359g) {
        ((ListIterator) this.f713d.get(this.f717h)).set(c0359g);
    }
}
