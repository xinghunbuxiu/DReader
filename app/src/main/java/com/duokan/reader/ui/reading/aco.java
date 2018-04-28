package com.duokan.reader.ui.reading;

import android.content.Context;
import android.text.TextUtils;
import com.duokan.core.sys.C0366o;
import com.duokan.reader.domain.document.ah;
import java.io.File;

public class aco {
    /* renamed from: b */
    static final /* synthetic */ boolean f9469b = (!aco.class.desiredAssertionStatus());
    /* renamed from: c */
    private static aco f9470c;
    /* renamed from: a */
    long f9471a;
    /* renamed from: d */
    private final int f9472d = 3;
    /* renamed from: e */
    private acr f9473e;
    /* renamed from: f */
    private ah f9474f;
    /* renamed from: g */
    private File f9475g;
    /* renamed from: h */
    private String f9476h;
    /* renamed from: i */
    private acq f9477i;

    /* renamed from: a */
    public static aco m13312a() {
        if (f9470c == null) {
            f9470c = new aco();
        }
        return f9470c;
    }

    /* renamed from: a */
    public void m13321a(long j, ah ahVar, Context context, acr acr) {
        this.f9474f = ahVar;
        this.f9471a = j;
        this.f9473e = acr;
        m13314a(context);
    }

    /* renamed from: b */
    public String m13322b() {
        return this.f9475g.getAbsolutePath();
    }

    /* renamed from: c */
    public void m13323c() {
        if (this.f9477i != null) {
            this.f9477i.cancel(true);
        }
    }

    /* renamed from: a */
    private void m13314a(Context context) {
        if (!f9469b && this.f9474f == null) {
            throw new AssertionError();
        } else if (f9469b || this.f9473e != null) {
            this.f9476h = context.getCacheDir().getAbsolutePath();
            this.f9475g = new File(context.getCacheDir(), C0366o.m1034b(this.f9471a + this.f9474f.mo1411b()[0].f4402c, "md5"));
            if (this.f9475g.exists()) {
                this.f9473e.mo2264l();
                return;
            }
            this.f9477i = new acq();
            this.f9477i.execute(new Void[0]);
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: d */
    private void m13317d() {
        synchronized (this.f9475g) {
            if (this.f9475g.exists()) {
                this.f9475g.delete();
            }
        }
    }

    /* renamed from: e */
    private void m13320e() {
        if (!TextUtils.isEmpty(this.f9476h)) {
            File[] listFiles = new File(this.f9476h).listFiles(new acp(this));
            if (listFiles.length >= 3) {
                File file = listFiles[0];
                for (int i = 1; i < listFiles.length; i++) {
                    if (file.lastModified() > listFiles[i].lastModified()) {
                        file = listFiles[i];
                    }
                }
                file.delete();
            }
        }
    }
}
