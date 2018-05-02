package com.duokan.reader.domain.micloud;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import cn.kuaipan.android.kss.KssMaster;
import cn.kuaipan.android.kss.upload.UploadFileInfo;
import com.duokan.reader.common.async.work.C0525e;
import com.duokan.reader.common.async.work.C0526f;
import com.duokan.reader.common.async.work.C0529q;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.common.webservices.C0660l;
import com.duokan.reader.domain.micloud.p046a.C1044a;
import com.duokan.reader.domain.micloud.p046a.C1052i;
import com.duokan.reader.domain.micloud.p046a.C1053j;
import com.duokan.reader.domain.micloud.p046a.C1054k;
import com.duokan.reader.domain.micloud.p046a.C1056m;
import com.xiaomi.accountsdk.account.data.ExtendedAuthToken;
import java.io.File;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.micloud.d */
public class C1063d extends be<C1068i> {
    /* renamed from: a */
    private int f5260a;
    /* renamed from: b */
    private int f5261b;
    /* renamed from: c */
    private int f5262c;
    /* renamed from: d */
    private int f5263d;
    /* renamed from: e */
    private int f5264e;
    /* renamed from: f */
    private int f5265f;
    /* renamed from: g */
    private int f5266g;
    /* renamed from: h */
    private long f5267h = 0;

    public C1063d(Context context, C1068i c1068i, C0529q<C1068i> c0529q) {
        super(context, c1068i, c0529q);
    }

    /* renamed from: b */
    protected int mo1492b(C0525e c0525e) {
        if (C0559f.m2476b().m2486e()) {
            return 6;
        }
        return 3;
    }

    /* renamed from: a */
    protected C0525e mo1491a(ExtendedAuthToken extendedAuthToken) {
        this.f5260a = 0;
        this.f5262c = 0;
        this.f5263d = 0;
        this.f5264e = 0;
        this.f5261b = 0;
        this.f5265f = 0;
        this.f5266g = 0;
        ((C1068i) mo734b()).m8216L();
        System.currentTimeMillis();
        C0525e a = m8179a(extendedAuthToken, new File(((C1068i) mo734b()).m8228w()));
        ((C1068i) mo734b()).m8216L();
        return a;
    }

    /* renamed from: k */
    private void m8189k() {
        ((C1068i) mo734b()).m8225b(0, 0);
        m8190l();
    }

    /* renamed from: l */
    private void m8190l() {
        ((C1068i) mo734b()).m8219a(0, 0, null, null);
        m8191m();
    }

    /* renamed from: m */
    private void m8191m() {
        ((C1068i) mo734b()).m8226b(null);
        m8192n();
    }

    /* renamed from: n */
    private void m8192n() {
        this.f5264e = 0;
        ((C1068i) mo734b()).m8221a(null);
        m8193o();
    }

    /* renamed from: o */
    private void m8193o() {
        this.f5265f = 0;
        ((C1068i) mo734b()).m8220a(null);
        m8194p();
    }

    /* renamed from: p */
    private void m8194p() {
        this.f5266g = 0;
        ((C1068i) mo734b()).m8222a(null);
    }

    /* renamed from: a */
    private C0525e m8179a(ExtendedAuthToken extendedAuthToken, File file) {
        while (((C1068i) mo734b()).m8212H() == null) {
            if (!((C1068i) mo734b()).m2300o()) {
                return C0525e.m2310b(-2, true, true);
            }
            if (((C1068i) mo734b()).m8212H() == null && ((C1068i) mo734b()).m8211G() == null) {
                if (!file.exists()) {
                    m8189k();
                    m8183b(true);
                    m2277j();
                    return C0525e.m2311c(-10001, true, false);
                } else if (!(((C1068i) mo734b()).m8205A() == null || ac.m8049a(file, ((C1068i) mo734b()).m8206B(), ((C1068i) mo734b()).m8207C()))) {
                    m8189k();
                    m8183b(true);
                    m2277j();
                    if (this.f5260a >= 3) {
                        return C0525e.m2311c(-10002, true, false);
                    }
                    this.f5260a++;
                    if (!((C1068i) mo734b()).m2300o()) {
                        return C0525e.m2310b(-2, true, true);
                    }
                    try {
                        Thread.sleep((long) ((this.f5260a * 6) * 1000));
                    } catch (InterruptedException e) {
                    }
                    if (!((C1068i) mo734b()).m2300o()) {
                        return C0525e.m2310b(-2, true, true);
                    }
                }
            }
            C0525e b = m8182b(extendedAuthToken, file);
            if (!b.m2313b()) {
                return b;
            }
        }
        return C0525e.m2309a(0, false, false);
    }

    /* renamed from: b */
    private C0525e m8182b(ExtendedAuthToken extendedAuthToken, File file) {
        m8183b(true);
        if (((C1068i) mo734b()).m8205A() == null) {
            return m8184c(extendedAuthToken, file);
        }
        if (TextUtils.isEmpty(((C1068i) mo734b()).m8231z())) {
            return m8185d(extendedAuthToken, file);
        }
        if (((C1068i) mo734b()).m8209E() == null) {
            return m8186e(extendedAuthToken, file);
        }
        if (((C1068i) mo734b()).m8211G() == null) {
            return m8187f(extendedAuthToken, file);
        }
        return m8188g(extendedAuthToken, file);
    }

    /* renamed from: c */
    private C0525e m8184c(ExtendedAuthToken extendedAuthToken, File file) {
        try {
            Pair a = m8178a(file);
            if (a == null) {
                return C0525e.m2310b(-2, true, true);
            }
            ((C1068i) mo734b()).m8219a(file.lastModified(), file.length(), (ah) a.second, (String) a.first);
            m8183b(true);
            m2277j();
            return C0525e.m2309a(0, true, true);
        } catch (Throwable e) {
            C0526f.m2316a("micloud", "", e);
            return C0525e.m2311c(-39999, false, false);
        } catch (Throwable e2) {
            C0526f.m2316a("micloud", "", e2);
            if (((C1068i) mo734b()).m2300o()) {
                return C0525e.m2309a(0, true, true);
            }
            return C0525e.m2310b(-2, true, true);
        } catch (Throwable e22) {
            C0526f.m2316a("micloud", "", e22);
            int a2 = ay.m8100a(m2258a(), file, e22);
            if (a2 == -30002) {
                return C0525e.m2311c(a2, false, false);
            }
            if (a2 == -30008) {
                return C0525e.m2311c(a2, false, false);
            }
            return C0525e.m2311c(a2, true, true);
        } catch (Throwable e222) {
            C0526f.m2316a("micloud", "", e222);
            return C0525e.m2311c(ay.m8101a(e222), true, true);
        }
    }

    /* renamed from: a */
    private Pair<String, ah> m8178a(File file) {
        UploadFileInfo fileInfo = UploadFileInfo.getFileInfo(file);
        return new Pair(fileInfo.getSha1(), new ah(fileInfo));
    }

    /* renamed from: d */
    private C0525e m8185d(ExtendedAuthToken extendedAuthToken, File file) {
        try {
            C1044a c1044a = new C1044a(((C1068i) mo734b()).m8140N(), extendedAuthToken, ((C1068i) mo734b()).m8141O());
            C0660l a = c1044a.m8016a(((C1068i) mo734b()).m8229x());
            C1056m c1056m = (C1056m) a.f2216c;
            if (a.m3100a()) {
                ((C1068i) mo734b()).m8226b(c1056m.f5178a.m8154d());
                m8183b(true);
                m2277j();
                return C0525e.m2309a(0, true, true);
            } else if (a.f2214a != 50202) {
                return C0525e.m2308a(a.f2214a, a.f2215b, true, true);
            } else {
                C0660l b = c1044a.m8022b(((C1068i) mo734b()).m8229x());
                C1052i c1052i = (C1052i) b.f2216c;
                if (!b.m3100a()) {
                    return C0525e.m2308a(b.f2214a, b.f2215b, true, true);
                }
                ((C1068i) mo734b()).m8226b(c1052i.f5169a.m8154d());
                m8183b(true);
                m2277j();
                return C0525e.m2309a(0, true, true);
            }
        } catch (Throwable e) {
            C0526f.m2316a("micloud", "", e);
            return C0525e.m2311c(-39999, false, false);
        } catch (Throwable e2) {
            C0526f.m2316a("micloud", "", e2);
            return C0525e.m2311c(-10008, false, false);
        } catch (Throwable e22) {
            C0526f.m2316a("micloud", "", e22);
            return C0525e.m2311c(-40001, true, false);
        } catch (Throwable e222) {
            C0526f.m2316a("micloud", "", e222);
            return C0525e.m2311c(-40003, true, false);
        } catch (Throwable e2222) {
            C0526f.m2316a("micloud", "", e2222);
            return C0525e.m2311c(-40002, true, true);
        } catch (Throwable e22222) {
            C0526f.m2316a("micloud", "", e22222);
            return C0525e.m2311c(ay.m8102b(e22222), true, true);
        }
    }

    /* renamed from: e */
    private C0525e m8186e(ExtendedAuthToken extendedAuthToken, File file) {
        try {
            C0660l a = new C1044a(((C1068i) mo734b()).m8140N(), extendedAuthToken, ((C1068i) mo734b()).m8141O()).m8020a(((C1068i) mo734b()).m8231z(), ((C1068i) mo734b()).m8229x(), ((C1068i) mo734b()).m8230y(), ((C1068i) mo734b()).m8208D(), this.f5264e, ((C1068i) mo734b()).m8205A());
            C1054k c1054k = (C1054k) a.f2216c;
            if (a.m3100a()) {
                if (c1054k.f5172a) {
                    ((C1068i) mo734b()).m8222a(c1054k.f5175d);
                    m8183b(true);
                    m2277j();
                    return C0525e.m2309a(0, false, false);
                }
                ((C1068i) mo734b()).m8221a(c1054k.f5173b);
                m2263a(((C1068i) mo734b()).m8209E().m8144a());
                m8183b(true);
                m2277j();
                return C0525e.m2309a(0, true, true);
            } else if (a.f2214a == 50010) {
                if (c1054k.f5174c == null || this.f5264e >= 3) {
                    return C0525e.m2311c(50010, true, true);
                }
                this.f5264e++;
                if (!((C1068i) mo734b()).m2300o()) {
                    return C0525e.m2310b(-2, true, true);
                }
                try {
                    Thread.sleep(c1054k.f5174c.m8037a() * 1000);
                } catch (InterruptedException e) {
                }
                if (((C1068i) mo734b()).m2300o()) {
                    return m8186e(extendedAuthToken, file);
                }
                return C0525e.m2310b(-2, true, true);
            } else if (a.f2214a == 50202) {
                m8191m();
                m8183b(true);
                m2277j();
                if (this.f5261b >= 6) {
                    return C0525e.m2308a(50202, a.f2215b, true, false);
                }
                this.f5261b++;
                if (!((C1068i) mo734b()).m2300o()) {
                    return C0525e.m2310b(-2, true, true);
                }
                try {
                    Thread.sleep((long) ((this.f5261b * 6) * 1000));
                } catch (InterruptedException e2) {
                }
                if (((C1068i) mo734b()).m2300o()) {
                    return C0525e.m2309a(0, true, true);
                }
                return C0525e.m2310b(-2, true, true);
            } else if (a.f2214a == 10017) {
                return C0525e.m2308a(10017, a.f2215b, true, false);
            } else {
                if (a.f2214a == 50006) {
                    return C0525e.m2308a(50006, a.f2215b, true, false);
                }
                if (a.f2214a == 50203) {
                    return C0525e.m2308a(50203, a.f2215b, false, false);
                }
                if (a.f2214a == 23000) {
                    return C0525e.m2308a(23000, a.f2215b, false, false);
                }
                return C0525e.m2308a(a.f2214a, a.f2215b, true, true);
            }
        } catch (Throwable e3) {
            C0526f.m2316a("micloud", "", e3);
            return C0525e.m2311c(-39999, false, false);
        } catch (Throwable e32) {
            C0526f.m2316a("micloud", "", e32);
            return C0525e.m2311c(-10008, false, false);
        } catch (Throwable e322) {
            C0526f.m2316a("micloud", "", e322);
            return C0525e.m2311c(-40001, true, false);
        } catch (Throwable e3222) {
            C0526f.m2316a("micloud", "", e3222);
            return C0525e.m2311c(-40003, true, false);
        } catch (Throwable e32222) {
            C0526f.m2316a("micloud", "", e32222);
            return C0525e.m2311c(-40002, true, true);
        } catch (Throwable e322222) {
            C0526f.m2316a("micloud", "", e322222);
            return C0525e.m2311c(ay.m8102b(e322222), true, true);
        }
    }

    /* renamed from: f */
    private C0525e m8187f(ExtendedAuthToken extendedAuthToken, File file) {
        boolean z = false;
        try {
            ((C1068i) mo734b()).m8213I();
            KssMaster kssMaster = new KssMaster(m2258a(), new C1067h(), null);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sha1", ((C1068i) mo734b()).m8208D());
            jSONObject.put("block_infos", ((C1068i) mo734b()).m8205A().m8059a().getJSONObject("kss").getJSONArray("block_infos"));
            kssMaster.upload(file, new C1066g(), new UploadFileInfo(jSONObject.toString()), new C1065f());
            m8183b(true);
            m2277j();
            return C0525e.m2309a(0, true, true);
        } catch (Throwable e) {
            C0526f.m2316a("micloud", "", e);
            return C0525e.m2311c(-39999, false, false);
        } catch (Throwable e2) {
            C0526f.m2316a("micloud", "", e2);
            if (((C1068i) mo734b()).m2300o()) {
                return C0525e.m2309a(0, true, true);
            }
            return C0525e.m2310b(-2, true, true);
        } catch (Throwable e22) {
            C0526f.m2316a("micloud", "", e22);
            int a = ay.m8100a(m2258a(), file, e22);
            if (a == -30010) {
                return C0525e.m2311c(a, true, !m8197s());
            } else if (a == -30002) {
                return C0525e.m2311c(a, false, false);
            } else {
                if (a == -30003) {
                    if (m8197s() || this.f5265f >= 10) {
                        if (!m8197s()) {
                            z = true;
                        }
                        return C0525e.m2311c(a, true, z);
                    }
                    this.f5265f++;
                    if (!((C1068i) mo734b()).m2300o()) {
                        return C0525e.m2310b(-2, true, true);
                    }
                    try {
                        int i = this.f5265f * 20;
                        if (i > 60) {
                            i = 60;
                        }
                        Thread.sleep((long) (i * 1000));
                    } catch (InterruptedException e3) {
                    }
                    if (!((C1068i) mo734b()).m2300o()) {
                        return C0525e.m2310b(-2, true, true);
                    }
                    if (m8197s()) {
                        return C0525e.m2311c(a, true, false);
                    }
                    return m8187f(extendedAuthToken, file);
                } else if (a == -30004) {
                    m8189k();
                    m8183b(true);
                    m2277j();
                    if (m8197s() || this.f5263d >= 6) {
                        if (!m8197s()) {
                            z = true;
                        }
                        return C0525e.m2311c(a, true, z);
                    }
                    this.f5263d++;
                    return C0525e.m2309a(0, true, true);
                } else if (a == -30006) {
                    return C0525e.m2311c(a, true, false);
                } else {
                    if (a == -30007) {
                        return C0525e.m2311c(a, true, false);
                    }
                    if (a == -30008) {
                        return C0525e.m2311c(a, false, false);
                    }
                    if (a == -30009) {
                        return C0525e.m2311c(a, false, false);
                    }
                    if (!((C1068i) mo734b()).m2300o()) {
                        return C0525e.m2310b(-2, true, true);
                    }
                    if (!m8197s()) {
                        z = true;
                    }
                    return C0525e.m2311c(-30001, true, z);
                }
            }
        } catch (Throwable e222) {
            C0526f.m2316a("micloud", "", e222);
            if (!m8197s()) {
                z = true;
            }
            return C0525e.m2311c(-30001, true, z);
        }
    }

    /* renamed from: f */
    protected void mo1493f() {
        Thread.currentThread().interrupt();
        super.mo1493f();
    }

    /* renamed from: h */
    protected void mo1494h() {
        Thread.currentThread().interrupt();
        super.mo1494h();
    }

    /* renamed from: g */
    private C0525e m8188g(ExtendedAuthToken extendedAuthToken, File file) {
        try {
            C0660l a = new C1044a(((C1068i) mo734b()).m8140N(), extendedAuthToken, ((C1068i) mo734b()).m8141O()).m8019a(((C1068i) mo734b()).m8209E().m8144a(), ((C1068i) mo734b()).m8229x(), this.f5266g, ((C1068i) mo734b()).m8211G());
            C1053j c1053j = (C1053j) a.f2216c;
            if (a.m3100a()) {
                ((C1068i) mo734b()).m8222a(c1053j.f5171b);
                m8183b(true);
                m2277j();
                return C0525e.m2309a(0, true, true);
            } else if (a.f2214a == 50010) {
                if (c1053j.f5170a == null || this.f5266g >= 3) {
                    return C0525e.m2311c(50010, true, true);
                }
                this.f5266g++;
                if (!((C1068i) mo734b()).m2300o()) {
                    return C0525e.m2310b(-2, true, true);
                }
                try {
                    Thread.sleep(c1053j.f5170a.m8037a() * 1000);
                } catch (InterruptedException e) {
                }
                if (((C1068i) mo734b()).m2300o()) {
                    return m8188g(extendedAuthToken, file);
                }
                return C0525e.m2310b(-2, true, true);
            } else if (a.f2214a == 10017) {
                m8192n();
                m8183b(true);
                m2277j();
                if (this.f5262c >= 3) {
                    return C0525e.m2311c(10017, true, false);
                }
                this.f5262c++;
                return C0525e.m2309a(0, true, true);
            } else if (a.f2214a == 50202) {
                m8191m();
                m8183b(true);
                m2277j();
                if (this.f5261b >= 6) {
                    return C0525e.m2308a(50202, a.f2215b, true, false);
                }
                this.f5261b++;
                if (!((C1068i) mo734b()).m2300o()) {
                    return C0525e.m2310b(-2, true, true);
                }
                try {
                    Thread.sleep((long) ((this.f5261b * 6) * 1000));
                } catch (InterruptedException e2) {
                }
                if (((C1068i) mo734b()).m2300o()) {
                    return C0525e.m2309a(0, true, true);
                }
                return C0525e.m2310b(-2, true, true);
            } else if (a.f2214a == 50006) {
                return C0525e.m2308a(50006, a.f2215b, true, false);
            } else {
                if (a.f2214a == 50203) {
                    return C0525e.m2308a(50203, a.f2215b, false, false);
                }
                if (a.f2214a == 23000) {
                    return C0525e.m2308a(23000, a.f2215b, false, false);
                }
                return C0525e.m2308a(a.f2214a, a.f2215b, true, true);
            }
        } catch (Throwable e3) {
            C0526f.m2316a("micloud", "", e3);
            return C0525e.m2311c(-39999, false, false);
        } catch (Throwable e32) {
            C0526f.m2316a("micloud", "", e32);
            return C0525e.m2311c(-10008, false, false);
        } catch (Throwable e322) {
            C0526f.m2316a("micloud", "", e322);
            return C0525e.m2311c(-40001, true, false);
        } catch (Throwable e3222) {
            C0526f.m2316a("micloud", "", e3222);
            return C0525e.m2311c(-40003, true, false);
        } catch (Throwable e32222) {
            C0526f.m2316a("micloud", "", e32222);
            return C0525e.m2311c(-40002, true, true);
        } catch (Throwable e322222) {
            C0526f.m2316a("micloud", "", e322222);
            return C0525e.m2311c(ay.m8102b(e322222), true, true);
        }
    }

    /* renamed from: b */
    private void m8183b(boolean z) {
        if (z || System.currentTimeMillis() - this.f5267h > 1000) {
            m2261a(m8195q(), m8196r());
            this.f5267h = System.currentTimeMillis();
        }
    }

    /* renamed from: q */
    private long m8195q() {
        if (((C1068i) mo734b()).m8212H() != null) {
            return m8196r();
        }
        if (((C1068i) mo734b()).m8209E() == null) {
            return 0;
        }
        return ((C1068i) mo734b()).m8210F() < ((C1068i) mo734b()).m8207C() ? ((C1068i) mo734b()).m8210F() : ((C1068i) mo734b()).m8207C();
    }

    /* renamed from: r */
    private long m8196r() {
        if (((C1068i) mo734b()).m8207C() == 0) {
            return 0;
        }
        return ((C1068i) mo734b()).m8207C();
    }

    /* renamed from: s */
    private boolean m8197s() {
        return C0559f.m2476b().m2484c();
    }
}
