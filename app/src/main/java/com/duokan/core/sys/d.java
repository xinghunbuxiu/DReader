package com.duokan.core.sys;

import java.util.ArrayList;
import java.util.ListIterator;

class d implements ListIterator {
    static final /* synthetic */ boolean a = (!AsyncCache.class.desiredAssertionStatus());
    final /* synthetic */ int b;
    final /* synthetic */ boolean c;
    final /* synthetic */ ArrayList d;
    final /* synthetic */ AsyncCache e;
    private int f = this.b;
    private int g;
    private int h;

    d(AsyncCache asyncCache, int i, boolean z, ArrayList arrayList) {
        this.e = asyncCache;
        this.b = i;
        this.c = z;
        this.d = arrayList;
        this.g = this.c ? this.b : -1;
        this.h = this.c ? this.d.size() - 1 : 0;
    }

    public /* synthetic */ void add(Object obj) {
        a((g) obj);
    }

    public /* synthetic */ Object next() {
        return a();
    }

    public /* synthetic */ Object previous() {
        return b();
    }

    public /* synthetic */ void set(Object obj) {
        b((g) obj);
    }

    public void a(g gVar) {
        ((ListIterator) this.d.get(this.h)).add(gVar);
        this.f++;
        this.g++;
    }

    public boolean hasNext() {
        return this.g + 1 < this.b;
    }

    public boolean hasPrevious() {
        return this.g + -1 >= 0;
    }

    public g a() {
        if (a || hasNext()) {
            this.g++;
            while (!((ListIterator) this.d.get(this.h)).hasNext()) {
                this.h++;
            }
            return (g) ((ListIterator) this.d.get(this.h)).next();
        }
        throw new AssertionError();
    }

    public int nextIndex() {
        return this.g + 1;
    }

    public g b() {
        if (a || hasPrevious()) {
            this.g--;
            while (!((ListIterator) this.d.get(this.h)).hasPrevious()) {
                this.h--;
            }
            return (g) ((ListIterator) this.d.get(this.h)).previous();
        }
        throw new AssertionError();
    }

    public int previousIndex() {
        return this.g - 1;
    }

    public void remove() {
        if (this.g >= 0 && this.g < this.f) {
            ((ListIterator) this.d.get(this.h)).remove();
            this.f--;
            this.g--;
        }
    }

    public void b(g gVar) {
        ((ListIterator) this.d.get(this.h)).set(gVar);
    }
}
