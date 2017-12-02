package com.duokan.reader.ui.bookshelf;

import com.duokan.reader.ui.general.bo;
import com.duokan.reader.ui.general.expandable.SelectionMode;
import com.duokan.reader.ui.general.expandable.ViewMode;
import com.duokan.reader.ui.general.expandable.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class gw extends bo implements a {
    private ViewMode a = ViewMode.Normal;
    private SelectionMode c = SelectionMode.Multiple;
    private Map d;

    public void a(ViewMode viewMode) {
        this.a = viewMode;
        if (this.a == ViewMode.Normal && this.d != null) {
            this.d.clear();
        }
        d();
    }

    public ViewMode f() {
        return this.a;
    }

    public boolean c(int i) {
        return true;
    }

    public int g() {
        if (this.d == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < k(); i2++) {
            if (g(i2)) {
                int i3 = i;
                for (i = 0; i < f(i2); i++) {
                    if (b(i2, i)) {
                        i3++;
                    }
                }
                i = i3;
            }
        }
        return i;
    }

    public boolean b(int i, int i2) {
        if (g(i)) {
            return (this.d != null && this.d.containsKey(Integer.valueOf(i)) && ((Map) this.d.get(Integer.valueOf(i))).containsKey(Integer.valueOf(i2))) ? ((Boolean) ((Map) this.d.get(Integer.valueOf(i))).get(Integer.valueOf(i2))).booleanValue() : false;
        } else {
            return false;
        }
    }

    public void h() {
        if (this.c != SelectionMode.Radio) {
            int k = k();
            for (int i = 0; i < k; i++) {
                if (g(i)) {
                    boolean z;
                    if (i == k - 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    a(i, true, z);
                }
            }
        }
    }

    public void i() {
        if (this.c != SelectionMode.Radio) {
            int k = k();
            for (int i = 0; i < k; i++) {
                if (g(i)) {
                    boolean z;
                    if (i == k - 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    a(i, false, z);
                }
            }
        }
    }

    public void a(int i, int i2, boolean z) {
        if (g(i)) {
            a(i, i2, z, true);
        }
    }

    public List j() {
        List arrayList = new ArrayList();
        if (this.d != null) {
            for (int i = 0; i < k(); i++) {
                if (g(i)) {
                    for (int i2 = 0; i2 < f(i); i2++) {
                        if (b(i, i2)) {
                            arrayList.add(d(a(i, i2)));
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    protected int k() {
        return a();
    }

    protected int f(int i) {
        return a(i);
    }

    protected boolean g(int i) {
        return true;
    }

    protected void a(int i, boolean z, boolean z2) {
        if (c(i)) {
            if (this.d == null) {
                this.d = new HashMap();
            }
            if (this.c == SelectionMode.Radio) {
                this.d.clear();
            }
            int f = f(i);
            for (int i2 = 0; i2 < f; i2++) {
                boolean z3;
                if (i2 == f - 1 && z2) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                a(i, i2, z, z3);
            }
        }
    }

    private void a(int i, int i2, boolean z, boolean z2) {
        HashMap hashMap;
        if (this.d == null) {
            this.d = new HashMap();
        }
        if (this.c == SelectionMode.Radio) {
            this.d.clear();
        }
        if (this.d.containsKey(Integer.valueOf(i))) {
            hashMap = (HashMap) this.d.get(Integer.valueOf(i));
        } else {
            hashMap = new HashMap();
        }
        hashMap.put(Integer.valueOf(i2), Boolean.valueOf(z));
        this.d.put(Integer.valueOf(i), hashMap);
        if (z2) {
            d();
        }
    }
}
