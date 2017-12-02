package com.duokan.reader.ui.reading;

import android.graphics.Rect;
import android.view.View;

import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.ui.general.cu;
import com.duokan.reader.ui.general.gh;

public class fn extends cu implements gn {
    final /* synthetic */ fi b;
    private final fm c;
    private final gs d;
    private final as e;

    public fn(fi fiVar, fm fmVar, as asVar, gs gsVar) {
        this.b = fiVar;
        super(fiVar);
        this.c = fmVar;
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
        return this.d.j();
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
