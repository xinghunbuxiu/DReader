package com.duokan.reader.domain.ad;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.duokan.reader.domain.ad.a */
public class C0744a {
    /* renamed from: a */
    private final HashMap<String, C0748e> f2511a = new HashMap();
    /* renamed from: b */
    private final HashMap<String, List<C0745b>> f2512b = new HashMap();

    /* renamed from: a */
    public boolean m3532a(String str) {
        return this.f2511a.containsKey(str);
    }

    /* renamed from: a */
    public void m3528a(C0748e c0748e) {
        C0750g.m3561a().m3590c(c0748e);
        this.f2511a.put(c0748e.f2533r, c0748e);
    }

    /* renamed from: b */
    public void m3533b(String str) {
        try {
            C0748e c0748e = (C0748e) this.f2511a.get(str);
            if (c0748e != null) {
                C0750g.m3561a().m3596f(c0748e);
                this.f2511a.remove(str);
            }
            for (C0745b c : (List) this.f2512b.get(str)) {
                c.mo1852c();
            }
            this.f2512b.remove(str);
        } catch (Throwable th) {
        }
    }

    /* renamed from: c */
    public void m3535c(String str) {
        try {
            for (C0745b d : (List) this.f2512b.get(str)) {
                d.mo1853d();
            }
        } catch (Throwable th) {
        }
    }

    /* renamed from: d */
    public void m3536d(String str) {
        try {
            C0748e c0748e = (C0748e) this.f2511a.get(str);
            if (c0748e != null) {
                C0750g.m3561a().m3592d(c0748e);
            }
            for (C0745b b : (List) this.f2512b.get(str)) {
                b.mo1851b();
            }
        } catch (Throwable th) {
        }
    }

    /* renamed from: e */
    public void m3537e(String str) {
        try {
            C0748e c0748e = (C0748e) this.f2511a.get(str);
            if (c0748e != null) {
                C0750g.m3561a().m3594e(c0748e);
            }
            for (C0745b e : (List) this.f2512b.get(str)) {
                e.mo1854e();
            }
        } catch (Throwable th) {
        }
    }

    /* renamed from: a */
    public void m3529a(C0748e c0748e, C0745b c0745b) {
        if (c0748e != null && !TextUtils.isEmpty(c0748e.f2533r)) {
            m3531a(c0748e.f2533r, c0745b);
        }
    }

    /* renamed from: a */
    public void m3531a(String str, C0745b c0745b) {
        List list = (List) this.f2512b.get(str);
        if (list == null) {
            list = new ArrayList();
            this.f2512b.put(str, list);
        }
        list.add(c0745b);
    }

    /* renamed from: b */
    public void m3534b(String str, C0745b c0745b) {
        if (((List) this.f2512b.get(str)) != null) {
            this.f2512b.remove(str);
        }
        List arrayList = new ArrayList();
        this.f2512b.put(str, arrayList);
        arrayList.add(c0745b);
    }

    /* renamed from: f */
    public void m3538f(String str) {
        try {
            for (C0745b a : (List) this.f2512b.get(str)) {
                a.mo1849a();
            }
        } catch (Throwable th) {
        }
    }

    /* renamed from: g */
    public void m3539g(String str) {
        try {
            if (this.f2512b.containsKey(str)) {
                this.f2512b.remove(str);
            }
        } catch (Throwable th) {
        }
    }

    /* renamed from: a */
    public void m3530a(String str, int i) {
        try {
            for (C0745b a : (List) this.f2512b.get(str)) {
                a.mo1850a(i);
            }
        } catch (Throwable th) {
        }
    }
}
