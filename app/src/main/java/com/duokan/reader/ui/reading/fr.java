package com.duokan.reader.ui.reading;

import android.graphics.Rect;
import android.view.View;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.ui.general.cu;
import com.duokan.reader.ui.general.gb;

public class fr extends cu implements gs {
    /* renamed from: b */
    final /* synthetic */ fm f10169b;
    /* renamed from: c */
    private final fq f10170c;
    /* renamed from: d */
    private final gx f10171d;
    /* renamed from: e */
    private final as f10172e;

    public fr(fm fmVar, fq fqVar, as asVar, gx gxVar) {
        this.f10169b = fmVar;
        super(fmVar);
        this.f10170c = fqVar;
        this.f10172e = asVar;
        this.f10171d = gxVar;
    }

    /* renamed from: c */
    public gb mo2327c() {
        return this.f10170c;
    }

    /* renamed from: d */
    public View mo2328d() {
        return this.f10171d;
    }

    /* renamed from: e */
    public boolean mo2329e() {
        return this.f10171d.m14303i();
    }

    /* renamed from: f */
    public boolean mo2330f() {
        return this.f10171d.m14304j();
    }

    /* renamed from: b */
    public Rect mo2325b(Rect rect) {
        return this.f10172e.mo1307c(rect);
    }

    /* renamed from: c */
    public Rect mo2326c(Rect rect) {
        return this.f10172e.mo1301b(rect);
    }

    /* renamed from: g */
    public ak mo2331g() {
        return this.f10172e.mo1332l();
    }

    /* renamed from: h */
    public as mo2332h() {
        return this.f10172e;
    }
}
