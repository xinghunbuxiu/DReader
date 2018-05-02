package com.duokan.reader.ui.reading;

import android.graphics.Rect;
import android.view.View;

import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.ui.general.df;
import com.duokan.reader.ui.general.gh;

public class ft extends df implements gn {
    final /* synthetic */ fo b;
    private final fs c;
    private final gs d;
    private final as e;

    public ft(fo foVar, fs fsVar, as asVar, gs gsVar) {
        this.b = foVar;
        super(foVar);
        this.c = fsVar;
        this.e = asVar;
        this.d = gsVar;
    }

    public gh c() {
        return this.c;
    }

    public View d() {
        return this.d;
    }

    public boolean e() {
        return this.d.i();
    }

    public boolean f() {
        return this.e.F();
    }

    public Rect b(Rect rect) {
        return this.e.c(rect);
    }

    public Rect c(Rect rect) {
        return this.e.b(rect);
    }

    public ak g() {
        return this.e.l();
    }

    public as h() {
        return this.e;
    }
}
