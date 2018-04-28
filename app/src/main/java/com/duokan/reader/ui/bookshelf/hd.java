package com.duokan.reader.ui.bookshelf;

import com.duokan.reader.ui.general.bo;
import com.duokan.reader.ui.general.expandable.C1293a;
import com.duokan.reader.ui.general.expandable.SelectionMode;
import com.duokan.reader.ui.general.expandable.ViewMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class hd extends bo implements C1293a {
    /* renamed from: a */
    private ViewMode f6542a = ViewMode.Normal;
    /* renamed from: c */
    private SelectionMode f6543c = SelectionMode.Multiple;
    /* renamed from: d */
    private Map<Integer, Map<Integer, Boolean>> f6544d;

    /* renamed from: a */
    public void m9779a(ViewMode viewMode) {
        this.f6542a = viewMode;
        if (this.f6542a == ViewMode.Normal && this.f6544d != null) {
            this.f6544d.clear();
        }
        mo1691d();
    }

    /* renamed from: f */
    public ViewMode mo1714f() {
        return this.f6542a;
    }

    /* renamed from: c */
    public boolean mo1556c(int i) {
        return true;
    }

    /* renamed from: g */
    public int mo1715g() {
        if (this.f6544d == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < mo1867k(); i2++) {
            if (mo1946g(i2)) {
                int i3 = i;
                for (i = 0; i < mo1866f(i2); i++) {
                    if (mo1713b(i2, i)) {
                        i3++;
                    }
                }
                i = i3;
            }
        }
        return i;
    }

    /* renamed from: b */
    public boolean mo1713b(int i, int i2) {
        if (mo1946g(i)) {
            return (this.f6544d != null && this.f6544d.containsKey(Integer.valueOf(i)) && ((Map) this.f6544d.get(Integer.valueOf(i))).containsKey(Integer.valueOf(i2))) ? ((Boolean) ((Map) this.f6544d.get(Integer.valueOf(i))).get(Integer.valueOf(i2))).booleanValue() : false;
        } else {
            return false;
        }
    }

    /* renamed from: h */
    public void mo1949h() {
        if (this.f6543c != SelectionMode.Radio) {
            int k = mo1867k();
            for (int i = 0; i < k; i++) {
                if (mo1946g(i)) {
                    boolean z;
                    if (i == k - 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    m9778a(i, true, z);
                }
            }
        }
    }

    /* renamed from: i */
    public void m9787i() {
        if (this.f6543c != SelectionMode.Radio) {
            int k = mo1867k();
            for (int i = 0; i < k; i++) {
                if (mo1946g(i)) {
                    boolean z;
                    if (i == k - 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    m9778a(i, false, z);
                }
            }
        }
    }

    /* renamed from: a */
    public void m9777a(int i, int i2, boolean z) {
        if (mo1946g(i)) {
            m9776a(i, i2, z, true);
        }
    }

    /* renamed from: j */
    public List<Object> m9788j() {
        List<Object> arrayList = new ArrayList();
        if (this.f6544d != null) {
            for (int i = 0; i < mo1867k(); i++) {
                if (mo1946g(i)) {
                    for (int i2 = 0; i2 < mo1866f(i); i2++) {
                        if (mo1713b(i, i2)) {
                            arrayList.add(mo509d(m1403a(i, i2)));
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: k */
    protected int mo1867k() {
        return mo486a();
    }

    /* renamed from: f */
    protected int mo1866f(int i) {
        return mo487a(i);
    }

    /* renamed from: g */
    protected boolean mo1946g(int i) {
        return true;
    }

    /* renamed from: a */
    protected void m9778a(int i, boolean z, boolean z2) {
        if (mo1556c(i)) {
            if (this.f6544d == null) {
                this.f6544d = new HashMap();
            }
            if (this.f6543c == SelectionMode.Radio) {
                this.f6544d.clear();
            }
            int f = mo1866f(i);
            for (int i2 = 0; i2 < f; i2++) {
                boolean z3;
                if (i2 == f - 1 && z2) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                m9776a(i, i2, z, z3);
            }
        }
    }

    /* renamed from: a */
    private void m9776a(int i, int i2, boolean z, boolean z2) {
        HashMap hashMap;
        if (this.f6544d == null) {
            this.f6544d = new HashMap();
        }
        if (this.f6543c == SelectionMode.Radio) {
            this.f6544d.clear();
        }
        if (this.f6544d.containsKey(Integer.valueOf(i))) {
            hashMap = (HashMap) this.f6544d.get(Integer.valueOf(i));
        } else {
            hashMap = new HashMap();
        }
        hashMap.put(Integer.valueOf(i2), Boolean.valueOf(z));
        this.f6544d.put(Integer.valueOf(i), hashMap);
        if (z2) {
            mo1691d();
        }
    }
}
