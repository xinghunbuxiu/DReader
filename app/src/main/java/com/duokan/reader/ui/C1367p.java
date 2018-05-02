package com.duokan.reader.ui;

import android.view.View;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.sys.UThread;

/* renamed from: com.duokan.reader.ui.p */
public abstract class C1367p extends ActivatedController implements C0436e {
    /* renamed from: a */
    private final C1384i f8163a = new C1419q(this, getContext());

    public C1367p(IFeature mFeature) {
        super(mFeature);
        setContentView(this.f8163a.getContentView());
        addSubController(this.f8163a);
        activate(this.f8163a);
    }

    /* renamed from: a */
    public void m11280a(View view) {
        this.f8163a.m9216a(view);
    }

    /* renamed from: g */
    public int m11287g() {
        return this.f8163a.m9241h();
    }

    /* renamed from: a */
    public void m11279a(int i) {
        this.f8163a.m9227c(i);
    }

    /* renamed from: h */
    public void m11288h() {
        this.f8163a.dismissAllPopups();
    }

    /* renamed from: a */
    public boolean m11281a(ActivatedController c0303e) {
        activate(this.f8163a);
        return this.f8163a.m11324a(c0303e);
    }

    /* renamed from: a */
    public boolean m11282a(ActivatedController c0303e, Runnable runnable) {
        activate(this.f8163a);
        return this.f8163a.m11325a(c0303e, runnable);
    }

    /* renamed from: i */
    public boolean m11289i() {
        return this.f8163a.m9242i();
    }

    /* renamed from: j */
    public boolean m11290j() {
        return this.f8163a.m9243j();
    }

    /* renamed from: a */
    public boolean m11283a(Runnable runnable) {
        return this.f8163a.m9225b(runnable);
    }

    public void c_(int i) {
    }

    /* renamed from: c */
    public void mo2552c(int i) {
    }

    public boolean pushPage(ActivatedController c0303e) {
        activate(this.f8163a);
        return this.f8163a.mo1861c(c0303e);
    }

    public boolean pushPageSmoothly(ActivatedController c0303e, Runnable runnable) {
        activate(this.f8163a);
        return this.f8163a.mo1862c(c0303e, runnable);
    }

    /* renamed from: b */
    public boolean m11284b(ActivatedController c0303e) {
        activate(this.f8163a);
        return this.f8163a.m11327b(c0303e);
    }

    /* renamed from: b */
    public boolean m11285b(ActivatedController c0303e, Runnable runnable) {
        activate(this.f8163a);
        return this.f8163a.m11328b(c0303e, runnable);
    }

    public boolean showPopupSmoothly(ActivatedController c0303e, Runnable runnable) {
        if (!showPopup(c0303e)) {
            return false;
        }
        UThread.post(runnable);
        return true;
    }

    public boolean showPopup(ActivatedController c0303e) {
        activate(this.f8163a);
        if (this.f8163a.showPopup(c0303e)) {
            return true;
        }
        return false;
    }

    public boolean showPopup(ActivatedController c0303e, int i, int i2) {
        activate(this.f8163a);
        if (this.f8163a.showPopup(c0303e, i, i2)) {
            return true;
        }
        return false;
    }
}
