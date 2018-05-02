package com.duokan.reader.ui.general;

import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;

public abstract class cd extends bo {
    private cf a = null;
    private boolean c = true;
    private int d = -1;
    private HashMap e = new HashMap();

    public abstract int a();

    public abstract View a(int i, int i2, View view, ViewGroup viewGroup);

    public abstract View a(int i, boolean z, View view, ViewGroup viewGroup);

    public abstract Object b(int i, int i2);

    public abstract int h(int i);

    public abstract Object i(int i);

    public abstract void j(int i);

    public void b(boolean z) {
        this.c = !z;
    }

    public void a(cf cfVar) {
        this.a = cfVar;
    }

    public int f() {
        if (this.c) {
            return this.d;
        }
        return -1;
    }

    public boolean c(int i) {
        if (this.c) {
            return this.d == i;
        } else {
            Boolean bool = (Boolean) this.e.get(Integer.valueOf(i));
            if (bool == null || !bool.booleanValue()) {
                return false;
            }
            return true;
        }
    }

    public void f(int i) {
        k(i);
        a(false);
    }

    public void g(int i) {
        l(i);
    }

    public void g() {
        a(false);
    }

    public int c() {
        int i = 0;
        int i2 = 0;
        while (i < a()) {
            if (c(i)) {
                i2 += a(i);
            }
            i++;
        }
        return i2;
    }

    public View d(int i, View view, ViewGroup viewGroup) {
        int[] b = b(i);
        return a(b[0], b[1], view, viewGroup);
    }

    protected void b() {
    }

    protected void e(int i) {
    }

    public int a(int i) {
        return c(i) ? h(i) : 0;
    }

    public View a(int i, View view, ViewGroup viewGroup) {
        View a = a(i, c(i), view, viewGroup);
        a.setOnClickListener(new ce(this, a, i));
        return a;
    }

    public Object d(int i) {
        return null;
    }

    private void k(int i) {
        if (this.c) {
            this.d = i;
        } else {
            this.e.put(Integer.valueOf(i), Boolean.valueOf(true));
        }
    }

    private void l(int i) {
        if (this.c) {
            k(f() == i ? -1 : i);
        } else {
            this.e.put(Integer.valueOf(i), Boolean.valueOf(!c(i)));
        }
        g();
        j(i);
    }
}
