package com.duokan.reader.ui.reading;

import android.graphics.Rect;
import android.view.View;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.ui.general.df;
import com.duokan.reader.ui.general.gb;

public class fy extends df implements gs {
    /* renamed from: b */
    final /* synthetic */ fs f10193b;
    /* renamed from: c */
    private final fx f10194c;
    /* renamed from: d */
    private final gx f10195d;
    /* renamed from: e */
    private final as f10196e;

    public fy(fs fsVar, fx fxVar, as asVar, gx gxVar) {
        this.f10193b = fsVar;
        super(fsVar);
        this.f10194c = fxVar;
        this.f10196e = asVar;
        this.f10195d = gxVar;
    }

    /* renamed from: c */
    public gb mo2327c() {
        return this.f10194c;
    }

    /* renamed from: d */
    public View mo2328d() {
        return this.f10195d;
    }

    /* renamed from: e */
    public boolean mo2329e() {
        return this.f10195d.m14303i();
    }

    /* renamed from: f */
    public boolean mo2330f() {
        return this.f10196e.mo1283F();
    }

    /* renamed from: b */
    public Rect mo2325b(Rect rect) {
        return this.f10196e.mo1307c(rect);
    }

    /* renamed from: c */
    public Rect mo2326c(Rect rect) {
        return this.f10196e.mo1301b(rect);
    }

    /* renamed from: g */
    public ak mo2331g() {
        return this.f10196e.mo1332l();
    }

    /* renamed from: h */
    public as mo2332h() {
        return this.f10196e;
    }
}
