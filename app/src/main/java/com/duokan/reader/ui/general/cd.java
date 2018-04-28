package com.duokan.reader.ui.general;

import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;

public abstract class cd extends bo {
    /* renamed from: a */
    private cf f7023a = null;
    /* renamed from: c */
    private boolean f7024c = true;
    /* renamed from: d */
    private int f7025d = -1;
    /* renamed from: e */
    private HashMap<Integer, Boolean> f7026e = new HashMap();

    /* renamed from: a */
    public abstract int mo486a();

    /* renamed from: a */
    public abstract View mo2454a(int i, int i2, View view, ViewGroup viewGroup);

    /* renamed from: a */
    public abstract View mo2455a(int i, boolean z, View view, ViewGroup viewGroup);

    /* renamed from: b */
    public abstract Object mo2456b(int i, int i2);

    /* renamed from: h */
    public abstract int mo2457h(int i);

    /* renamed from: i */
    public abstract Object mo2458i(int i);

    /* renamed from: j */
    public abstract void mo2459j(int i);

    /* renamed from: b */
    public void mo1755b(boolean z) {
        this.f7024c = !z;
    }

    /* renamed from: a */
    public void m10346a(cf cfVar) {
        this.f7023a = cfVar;
    }

    /* renamed from: f */
    public int m10355f() {
        if (this.f7024c) {
            return this.f7025d;
        }
        return -1;
    }

    /* renamed from: c */
    public boolean mo1556c(int i) {
        if (this.f7024c) {
            return this.f7025d == i;
        } else {
            Boolean bool = (Boolean) this.f7026e.get(Integer.valueOf(i));
            if (bool == null || !bool.booleanValue()) {
                return false;
            }
            return true;
        }
    }

    /* renamed from: f */
    public void m10356f(int i) {
        mo2460k(i);
        m8785a(false);
    }

    /* renamed from: g */
    public void m10358g(int i) {
        m10340l(i);
    }

    /* renamed from: g */
    public void mo1715g() {
        m8785a(false);
    }

    /* renamed from: c */
    public int mo506c() {
        int i = 0;
        int i2 = 0;
        while (i < mo486a()) {
            if (mo1556c(i)) {
                i2 += mo487a(i);
            }
            i++;
        }
        return i2;
    }

    /* renamed from: d */
    public View mo508d(int i, View view, ViewGroup viewGroup) {
        int[] b = m1404b(i);
        return mo2454a(b[0], b[1], view, viewGroup);
    }

    /* renamed from: b */
    protected void mo1555b() {
    }

    /* renamed from: e */
    protected void mo1557e(int i) {
    }

    /* renamed from: a */
    public int mo487a(int i) {
        return mo1556c(i) ? mo2457h(i) : 0;
    }

    /* renamed from: a */
    public View mo488a(int i, View view, ViewGroup viewGroup) {
        View a = mo2455a(i, mo1556c(i), view, viewGroup);
        a.setOnClickListener(new ce(this, a, i));
        return a;
    }

    /* renamed from: d */
    public Object mo509d(int i) {
        return null;
    }

    /* renamed from: k */
    private void mo2460k(int i) {
        if (this.f7024c) {
            this.f7025d = i;
        } else {
            this.f7026e.put(Integer.valueOf(i), Boolean.valueOf(true));
        }
    }

    /* renamed from: l */
    private void m10340l(int i) {
        if (this.f7024c) {
            mo2460k(m10355f() == i ? -1 : i);
        } else {
            this.f7026e.put(Integer.valueOf(i), Boolean.valueOf(!mo1556c(i)));
        }
        mo1715g();
        mo2459j(i);
    }
}
