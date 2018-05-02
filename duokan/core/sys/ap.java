package com.duokan.core.sys;

import java.util.ArrayList;

public abstract class ap {
    static final  boolean a = (!ap.class.desiredAssertionStatus());
    private final ArrayList list = new ArrayList(10);
    private int c = 0;
    private int d = 0;

    protected abstract Object b();

    protected abstract void b(Object obj);

    public Object getRect() {
        if (this.c >= this.d - 1) {
            this.list.add(b());
            this.d++;
        }
        ArrayList arrayList = this.list;
        int i = this.c;
        this.c = i + 1;
        return arrayList.get(i);
    }

    public void getRect(Object obj) {
        int i = this.d - 1;
        while (i >= 0 && this.list.get(i) != obj) {
            i--;
        }
        if (!a && i < 0) {
            throw new AssertionError();
        } else if (i >= 0) {
            b(obj);
            if (i != this.c - 1) {
                Object obj2 = this.list.get(i);
                this.list.set(i, this.list.get(this.c - 1));
                this.list.set(this.c - 1, obj2);
            }
            this.c--;
        }
    }
}
