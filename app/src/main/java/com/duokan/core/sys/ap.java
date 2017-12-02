package com.duokan.core.sys;

import java.util.ArrayList;

public abstract class ap {
    static final /* synthetic */ boolean a = (!ap.class.desiredAssertionStatus());
    private final ArrayList b = new ArrayList(10);
    private int c = 0;
    private int d = 0;

    protected abstract Object b();

    protected abstract void b(Object obj);

    public Object a() {
        if (this.c >= this.d - 1) {
            this.b.add(b());
            this.d++;
        }
        ArrayList arrayList = this.b;
        int i = this.c;
        this.c = i + 1;
        return arrayList.get(i);
    }

    public void a(Object obj) {
        int i = this.d - 1;
        while (i >= 0 && this.b.get(i) != obj) {
            i--;
        }
        if (!a && i < 0) {
            throw new AssertionError();
        } else if (i >= 0) {
            b(obj);
            if (i != this.c - 1) {
                Object obj2 = this.b.get(i);
                this.b.set(i, this.b.get(this.c - 1));
                this.b.set(this.c - 1, obj2);
            }
            this.c--;
        }
    }
}
