package com.duokan.reader.domain.document;

/* renamed from: com.duokan.reader.domain.document.h */
public abstract class C0911h {
    /* renamed from: a */
    static final /* synthetic */ boolean f4309a = (!C0911h.class.desiredAssertionStatus());

    /* renamed from: a */
    public abstract String mo1264a();

    /* renamed from: a */
    public abstract void mo1265a(String str);

    /* renamed from: a */
    protected abstract boolean mo1266a(C0901g c0901g, C0897d c0897d);

    /* renamed from: b */
    public abstract C0901g mo1267b(C0896a c0896a);

    /* renamed from: b */
    public abstract C0901g[] mo1268b();

    /* renamed from: c */
    public abstract int mo1269c();

    protected C0911h() {
    }

    /* renamed from: a */
    public C0901g m6046a(C0896a c0896a) {
        C0901g b = mo1267b(c0896a);
        if (b == null) {
            return null;
        }
        return mo1268b()[b.mo1201d()];
    }

    /* renamed from: a */
    public C0901g m6047a(C0901g c0901g) {
        if (c0901g == null) {
            return null;
        }
        return m6055b(mo1268b(), c0901g);
    }

    /* renamed from: b */
    public C0901g m6054b(C0901g c0901g) {
        if (c0901g == null) {
            return null;
        }
        return m6049a(mo1268b(), c0901g);
    }

    /* renamed from: a */
    protected C0901g m6049a(C0901g[] c0901gArr, C0901g c0901g) {
        if (!f4309a && c0901gArr == null) {
            throw new AssertionError();
        } else if (f4309a || c0901gArr.length > 0) {
            C0901g c0901g2 = null;
            for (int length = c0901gArr.length - 1; length >= 0; length--) {
                if (c0901gArr[length].mo1208k()) {
                    if (c0901gArr[length].mo1206i() > 0) {
                        c0901g2 = m6049a(c0901gArr[length].mo1207j(), c0901g);
                    }
                    if (c0901g2 != null) {
                        return c0901g2;
                    }
                    if (c0901gArr[length].mo1200c() < c0901g.mo1200c()) {
                        c0901g2 = c0901gArr[length];
                    }
                    if (c0901g2 != null) {
                        return c0901g2;
                    }
                }
            }
            return null;
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: b */
    protected C0901g m6055b(C0901g[] c0901gArr, C0901g c0901g) {
        if (!f4309a && c0901gArr == null) {
            throw new AssertionError();
        } else if (f4309a || c0901gArr.length > 0) {
            C0901g c0901g2 = null;
            for (int i = 0; i < c0901gArr.length; i++) {
                if (c0901gArr[i].mo1208k()) {
                    if (c0901gArr[i].mo1200c() > c0901g.mo1200c()) {
                        c0901g2 = c0901gArr[i];
                    }
                    if (c0901g2 != null) {
                        return c0901g2;
                    }
                    if (c0901gArr[i].mo1206i() > 0) {
                        c0901g2 = m6055b(c0901gArr[i].mo1207j(), c0901g);
                    }
                    if (c0901g2 != null) {
                        return c0901g2;
                    }
                }
            }
            return null;
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    protected C0901g m6048a(C0901g[] c0901gArr, C0897d c0897d) {
        if (!f4309a && c0901gArr == null) {
            throw new AssertionError();
        } else if (!f4309a && c0897d == null) {
            throw new AssertionError();
        } else if (f4309a || c0901gArr.length > 0) {
            C0901g c0901g = null;
            for (int i = 0; i < c0901gArr.length; i++) {
                if (c0901gArr[i].mo1208k()) {
                    if (mo1266a(c0901gArr[i], c0897d)) {
                        break;
                    }
                    c0901g = c0901gArr[i];
                }
            }
            if (c0901g == null || c0901g.mo1207j().length <= 0) {
                return c0901g;
            }
            C0901g a = m6048a(c0901g.mo1207j(), c0897d);
            if (a != null) {
                return a;
            }
            return c0901g;
        } else {
            throw new AssertionError();
        }
    }
}
