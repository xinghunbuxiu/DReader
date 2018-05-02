package com.duokan.reader.domain.micloud;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;

import com.duokan.reader.common.async.work.e;
import com.duokan.reader.common.async.work.q;
import com.duokan.reader.common.classc;
import com.duokan.reader.common.webservices.j;
import com.duokan.reader.domain.micloud.a.a;
import com.duokan.reader.domain.micloud.a.i;
import com.duokan.reader.domain.micloud.a.k;
import com.duokan.reader.domain.micloud.a.m;
import com.xiaomi.accountsdk.account.data.ExtendedAuthToken;

import org.json.JSONObject;

import java.io.File;

import cn.kuaipan.android.kss.KssMaster;
import cn.kuaipan.android.kss.upload.UploadFileInfo;
import miuipub.date.Calendar;

public class d extends be {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private long h = 0;

    public d(Context context, i iVar, q qVar) {
        super(context, iVar, qVar);
    }

    protected int b(e eVar) {
        if (f.b().e()) {
            return 6;
        }
        return 3;
    }

    protected e a(ExtendedAuthToken extendedAuthToken) {
        this.a = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.b = 0;
        this.f = 0;
        this.g = 0;
        ((i) b()).L();
        System.currentTimeMillis();
        e a = a(extendedAuthToken, new File(((i) b()).w()));
        ((i) b()).L();
        return a;
    }

    private void k() {
        ((i) b()).b(0, 0);
        l();
    }

    private void l() {
        ((i) b()).a(0, 0, null, null);
        m();
    }

    private void m() {
        ((i) b()).b(null);
        n();
    }

    private void n() {
        this.e = 0;
        ((i) b()).a(null);
        o();
    }

    private void o() {
        this.f = 0;
        ((i) b()).a(null);
        p();
    }

    private void p() {
        this.g = 0;
        ((i) b()).a(null);
    }

    private e a(ExtendedAuthToken extendedAuthToken, File file) {
        while (((i) b()).H() == null) {
            if (!((i) b()).o()) {
                return e.b(-2, true, true);
            }
            if (((i) b()).H() == null && ((i) b()).G() == null) {
                if (!file.exists()) {
                    k();
                    b(true);
                    j();
                    return e.c(-10001, true, false);
                } else if (!(((i) b()).A() == null || ac.a(file, ((i) b()).B(), ((i) b()).C()))) {
                    k();
                    b(true);
                    j();
                    if (this.a >= 3) {
                        return e.c(-10002, true, false);
                    }
                    this.a++;
                    if (!((i) b()).o()) {
                        return e.b(-2, true, true);
                    }
                    try {
                        Thread.sleep((long) ((this.a * 6) * Calendar.MILLISECOND_OF_SECOND));
                    } catch (InterruptedException e) {
                    }
                    if (!((i) b()).o()) {
                        return e.b(-2, true, true);
                    }
                }
            }
            e b = b(extendedAuthToken, file);
            if (!b.b()) {
                return b;
            }
        }
        return e.a(0, false, false);
    }

    private e b(ExtendedAuthToken extendedAuthToken, File file) {
        b(true);
        if (((i) b()).A() == null) {
            return c(extendedAuthToken, file);
        }
        if (TextUtils.isEmpty(((i) b()).z())) {
            return d(extendedAuthToken, file);
        }
        if (((i) b()).E() == null) {
            return e(extendedAuthToken, file);
        }
        if (((i) b()).G() == null) {
            return f(extendedAuthToken, file);
        }
        return g(extendedAuthToken, file);
    }

    private e c(ExtendedAuthToken extendedAuthToken, File file) {
        try {
            Pair a = a(file);
            if (a == null) {
                return e.b(-2, true, true);
            }
            ((i) b()).a(file.lastModified(), file.length(), (ah) a.second, (String) a.first);
            b(true);
            j();
            return e.a(0, true, true);
        } catch (Throwable e) {
            com.duokan.reader.common.async.work.f.a("micloud", "", e);
            return e.c(-39999, false, false);
        } catch (Throwable e2) {
            com.duokan.reader.common.async.work.f.a("micloud", "", e2);
            if (((i) b()).o()) {
                return e.a(0, true, true);
            }
            return e.b(-2, true, true);
        } catch (Throwable e22) {
            com.duokan.reader.common.async.work.f.a("micloud", "", e22);
            int a2 = ay.a(a(), file, e22);
            if (a2 == -30002) {
                return e.c(a2, false, false);
            }
            if (a2 == -30008) {
                return e.c(a2, false, false);
            }
            return e.c(a2, true, true);
        } catch (Throwable e222) {
            com.duokan.reader.common.async.work.f.a("micloud", "", e222);
            return e.c(ay.a(e222), true, true);
        }
    }

    private Pair a(File file) {
        UploadFileInfo fileInfo = UploadFileInfo.getFileInfo(file);
        return new Pair(fileInfo.getSha1(), new ah(fileInfo));
    }

    private e d(ExtendedAuthToken extendedAuthToken, File file) {
        try {
            a aVar = new a(((i) b()).N(), extendedAuthToken, ((i) b()).O());
            j a = aVar.a(((i) b()).x());
            m mVar = (m) a.c;
            if (a.a()) {
                ((i) b()).b(mVar.a.d());
                b(true);
                j();
                return e.a(0, true, true);
            } else if (a.a != 50202) {
                return e.a(a.a, a.b, true, true);
            } else {
                j b = aVar.b(((i) b()).x());
                i iVar = (i) b.c;
                if (!b.a()) {
                    return e.a(b.a, b.b, true, true);
                }
                ((i) b()).b(iVar.a.d());
                b(true);
                j();
                return e.a(0, true, true);
            }
        } catch (Throwable e) {
            com.duokan.reader.common.async.work.f.a("micloud", "", e);
            return e.c(-39999, false, false);
        } catch (Throwable e2) {
            com.duokan.reader.common.async.work.f.a("micloud", "", e2);
            return e.c(-10008, false, false);
        } catch (Throwable e22) {
            com.duokan.reader.common.async.work.f.a("micloud", "", e22);
            return e.c(-40001, true, false);
        } catch (Throwable e222) {
            com.duokan.reader.common.async.work.f.a("micloud", "", e222);
            return e.c(-40003, true, false);
        } catch (Throwable e2222) {
            com.duokan.reader.common.async.work.f.a("micloud", "", e2222);
            return e.c(-40002, true, true);
        } catch (Throwable e22222) {
            com.duokan.reader.common.async.work.f.a("micloud", "", e22222);
            return e.c(ay.b(e22222), true, true);
        }
    }

    private e e(ExtendedAuthToken extendedAuthToken, File file) {
        try {
            j a = new a(((i) b()).N(), extendedAuthToken, ((i) b()).O()).a(((i) b()).z(), ((i) b()).x(), ((i) b()).y(), ((i) b()).D(), this.e, ((i) b()).A());
            k kVar = (k) a.c;
            if (a.a()) {
                if (kVar.a) {
                    ((i) b()).a(kVar.d);
                    b(true);
                    j();
                    return e.a(0, false, false);
                }
                ((i) b()).a(kVar.b);
                a(((i) b()).E().a());
                b(true);
                j();
                return e.a(0, true, true);
            } else if (a.a == 50010) {
                if (kVar.c == null || this.e >= 3) {
                    return e.c(50010, true, true);
                }
                this.e++;
                if (!((i) b()).o()) {
                    return e.b(-2, true, true);
                }
                try {
                    Thread.sleep(kVar.c.a() * 1000);
                } catch (InterruptedException e) {
                }
                if (((i) b()).o()) {
                    return e(extendedAuthToken, file);
                }
                return e.b(-2, true, true);
            } else if (a.a == 50202) {
                m();
                b(true);
                j();
                if (this.b >= 6) {
                    return e.a(50202, a.b, true, false);
                }
                this.b++;
                if (!((i) b()).o()) {
                    return e.b(-2, true, true);
                }
                try {
                    Thread.sleep((long) ((this.b * 6) * Calendar.MILLISECOND_OF_SECOND));
                } catch (InterruptedException e2) {
                }
                if (((i) b()).o()) {
                    return e.a(0, true, true);
                }
                return e.b(-2, true, true);
            } else if (a.a == 10017) {
                return e.a(10017, a.b, true, false);
            } else {
                if (a.a == 50006) {
                    return e.a(50006, a.b, true, false);
                }
                if (a.a == 50203) {
                    return e.a(50203, a.b, false, false);
                }
                if (a.a == 23000) {
                    return e.a(23000, a.b, false, false);
                }
                return e.a(a.a, a.b, true, true);
            }
        } catch (Throwable e3) {
            com.duokan.reader.common.async.work.f.a("micloud", "", e3);
            return e.c(-39999, false, false);
        } catch (Throwable e32) {
            com.duokan.reader.common.async.work.f.a("micloud", "", e32);
            return e.c(-10008, false, false);
        } catch (Throwable e322) {
            com.duokan.reader.common.async.work.f.a("micloud", "", e322);
            return e.c(-40001, true, false);
        } catch (Throwable e3222) {
            com.duokan.reader.common.async.work.f.a("micloud", "", e3222);
            return e.c(-40003, true, false);
        } catch (Throwable e32222) {
            com.duokan.reader.common.async.work.f.a("micloud", "", e32222);
            return e.c(-40002, true, true);
        } catch (Throwable e322222) {
            com.duokan.reader.common.async.work.f.a("micloud", "", e322222);
            return e.c(ay.b(e322222), true, true);
        }
    }

    private e f(ExtendedAuthToken extendedAuthToken, File file) {
        boolean z = false;
        try {
            ((i) b()).I();
            KssMaster kssMaster = new KssMaster(a(), new h(), null);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sha1", ((i) b()).D());
            jSONObject.put("block_infos", ((i) b()).A().a().getJSONObject("kss").getJSONArray("block_infos"));
            kssMaster.upload(file, new g(), new UploadFileInfo(jSONObject.toString()), new classc.ConnectivityReceiver());
            b(true);
            j();
            return e.a(0, true, true);
        } catch (Throwable e) {
            com.duokan.reader.common.async.work.f.a("micloud", "", e);
            return e.c(-39999, false, false);
        } catch (Throwable e2) {
            com.duokan.reader.common.async.work.f.a("micloud", "", e2);
            if (((i) b()).o()) {
                return e.a(0, true, true);
            }
            return e.b(-2, true, true);
        } catch (Throwable e22) {
            com.duokan.reader.common.async.work.f.a("micloud", "", e22);
            int a = ay.a(a(), file, e22);
            if (a == -30010) {
                return e.c(a, true, !s());
            } else if (a == -30002) {
                return e.c(a, false, false);
            } else {
                if (a == -30003) {
                    if (s() || this.f >= 10) {
                        if (!s()) {
                            z = true;
                        }
                        return e.c(a, true, z);
                    }
                    this.f++;
                    if (!((i) b()).o()) {
                        return e.b(-2, true, true);
                    }
                    try {
                        int i = this.f * 20;
                        if (i > 60) {
                            i = 60;
                        }
                        Thread.sleep((long) (i * Calendar.MILLISECOND_OF_SECOND));
                    } catch (InterruptedException e3) {
                    }
                    if (!((i) b()).o()) {
                        return e.b(-2, true, true);
                    }
                    if (s()) {
                        return e.c(a, true, false);
                    }
                    return f(extendedAuthToken, file);
                } else if (a == -30004) {
                    k();
                    b(true);
                    j();
                    if (s() || this.d >= 6) {
                        if (!s()) {
                            z = true;
                        }
                        return e.c(a, true, z);
                    }
                    this.d++;
                    return e.a(0, true, true);
                } else if (a == -30006) {
                    return e.c(a, true, false);
                } else {
                    if (a == -30007) {
                        return e.c(a, true, false);
                    }
                    if (a == -30008) {
                        return e.c(a, false, false);
                    }
                    if (a == -30009) {
                        return e.c(a, false, false);
                    }
                    if (!((i) b()).o()) {
                        return e.b(-2, true, true);
                    }
                    if (!s()) {
                        z = true;
                    }
                    return e.c(-30001, true, z);
                }
            }
        } catch (Throwable e222) {
            com.duokan.reader.common.async.work.f.a("micloud", "", e222);
            if (!s()) {
                z = true;
            }
            return e.c(-30001, true, z);
        }
    }

    protected void f() {
        Thread.currentThread().interrupt();
        super.f();
    }

    protected void h() {
        Thread.currentThread().interrupt();
        super.h();
    }

    private e g(ExtendedAuthToken extendedAuthToken, File file) {
        try {
            j a = new a(((i) b()).N(), extendedAuthToken, ((i) b()).O()).a(((i) b()).E().a(), ((i) b()).x(), this.g, ((i) b()).G());
            com.duokan.reader.domain.micloud.a.j jVar = (com.duokan.reader.domain.micloud.a.j) a.c;
            if (a.a()) {
                ((i) b()).a(jVar.b);
                b(true);
                j();
                return e.a(0, true, true);
            } else if (a.a == 50010) {
                if (jVar.a == null || this.g >= 3) {
                    return e.c(50010, true, true);
                }
                this.g++;
                if (!((i) b()).o()) {
                    return e.b(-2, true, true);
                }
                try {
                    Thread.sleep(jVar.a.a() * 1000);
                } catch (InterruptedException e) {
                }
                if (((i) b()).o()) {
                    return g(extendedAuthToken, file);
                }
                return e.b(-2, true, true);
            } else if (a.a == 10017) {
                n();
                b(true);
                j();
                if (this.c >= 3) {
                    return e.c(10017, true, false);
                }
                this.c++;
                return e.a(0, true, true);
            } else if (a.a == 50202) {
                m();
                b(true);
                j();
                if (this.b >= 6) {
                    return e.a(50202, a.b, true, false);
                }
                this.b++;
                if (!((i) b()).o()) {
                    return e.b(-2, true, true);
                }
                try {
                    Thread.sleep((long) ((this.b * 6) * Calendar.MILLISECOND_OF_SECOND));
                } catch (InterruptedException e2) {
                }
                if (((i) b()).o()) {
                    return e.a(0, true, true);
                }
                return e.b(-2, true, true);
            } else if (a.a == 50006) {
                return e.a(50006, a.b, true, false);
            } else {
                if (a.a == 50203) {
                    return e.a(50203, a.b, false, false);
                }
                if (a.a == 23000) {
                    return e.a(23000, a.b, false, false);
                }
                return e.a(a.a, a.b, true, true);
            }
        } catch (Throwable e3) {
            com.duokan.reader.common.async.work.f.a("micloud", "", e3);
            return e.c(-39999, false, false);
        } catch (Throwable e32) {
            com.duokan.reader.common.async.work.f.a("micloud", "", e32);
            return e.c(-10008, false, false);
        } catch (Throwable e322) {
            com.duokan.reader.common.async.work.f.a("micloud", "", e322);
            return e.c(-40001, true, false);
        } catch (Throwable e3222) {
            com.duokan.reader.common.async.work.f.a("micloud", "", e3222);
            return e.c(-40003, true, false);
        } catch (Throwable e32222) {
            com.duokan.reader.common.async.work.f.a("micloud", "", e32222);
            return e.c(-40002, true, true);
        } catch (Throwable e322222) {
            com.duokan.reader.common.async.work.f.a("micloud", "", e322222);
            return e.c(ay.b(e322222), true, true);
        }
    }

    private void b(boolean z) {
        if (z || System.currentTimeMillis() - this.h > 1000) {
            a(q(), r());
            this.h = System.currentTimeMillis();
        }
    }

    private long q() {
        if (((i) b()).H() != null) {
            return r();
        }
        if (((i) b()).E() == null) {
            return 0;
        }
        return ((i) b()).F() < ((i) b()).C() ? ((i) b()).F() : ((i) b()).C();
    }

    private long r() {
        if (((i) b()).C() == 0) {
            return 0;
        }
        return ((i) b()).C();
    }

    private boolean s() {
        return f.b().c();
    }
}
