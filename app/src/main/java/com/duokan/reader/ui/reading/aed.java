package com.duokan.reader.ui.reading;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

import com.duokan.core.ui.UTools;
import com.duokan.core.ui.dt;
import com.duokan.core.ui.er;
import com.duokan.core.ui.OnTouchChangeListener;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.d;

class aed extends er {
    final /* synthetic */ adm a;
    private final dt c = new dt();

    public aed(adm com_duokan_reader_ui_reading_adm) {
        this.a = com_duokan_reader_ui_reading_adm;
        this.c.a(UTools.getScaledTouchSlop(com_duokan_reader_ui_reading_adm.getContext()));
        this.c.b(45.0f);
        this.c.c(135.0f);
    }

    protected void a(View view, boolean z) {
        this.c.b(view, z);
    }

    protected void a(View view, MotionEvent motionEvent, boolean z, OnTouchChangeListener esVar) {
        if (this.a.m == null && !this.a.e()) {
            b(false);
        } else if (this.a.m != null && motionEvent.getActionMasked() == 1) {
            this.a.b(this.a.m.b);
            this.a.m = null;
            this.a.c.invalidate();
        } else if (this.a.a.U() == PageAnimationMode.VSCROLL) {
            e(view, motionEvent, z, esVar);
        } else {
            d(view, motionEvent, z, esVar);
        }
    }

    private void d(View view, MotionEvent motionEvent, boolean z, OnTouchChangeListener esVar) {
        as aa = this.a.a.aa();
        if (aa != null && aa.G()) {
            if (this.a.m != null && this.a.m.a == null) {
                this.a.m.a = this.a.a(aa);
                ael c;
                Rect d;
                if (this.a.m.b.a(this.a.m.c().b)) {
                    c = this.a.m.c();
                    d = aa.d(c.b);
                    this.a.m.b = (d) c.b.g();
                    this.a.m.c.x = d.centerX();
                    this.a.m.c.y = d.top;
                } else if (this.a.m.b.c(this.a.m.d().b)) {
                    c = this.a.m.d();
                    d = aa.d(c.b);
                    this.a.m.b = (d) c.b.g();
                    this.a.m.c.x = d.centerX();
                    this.a.m.c.y = d.bottom;
                } else {
                    Rect d2 = aa.d(this.a.m.b().b);
                    this.a.m.c.x = d2.centerX();
                    this.a.m.c.y = d2.top;
                }
                this.a.m.d.set(this.a.m.c.x, this.a.m.c.y);
            }
            this.c.b(view, motionEvent, z, new aee(this, aa));
        }
    }

    private void e(View view, MotionEvent motionEvent, boolean z, OnTouchChangeListener esVar) {
        int i;
        int i2 = 0;
        gs[] ay = this.a.a.ay();
        for (gs i3 : ay) {
            if (!i3.i()) {
                i = 0;
                break;
            }
        }
        i = 1;
        if (i != 0 && ay.length >= 1) {
            this.a.a.a(ay);
            as[] asVarArr = new as[ay.length];
            while (i2 < asVarArr.length) {
                asVarArr[i2] = ay[i2].getPageDrawable();
                i2++;
            }
            if (this.a.m != null && this.a.m.a == null) {
                this.a.m.a = this.a.a(asVarArr);
                if (this.a.m.b.a(this.a.m.c().b)) {
                    this.a.m.b = (d) this.a.m.c().b.g();
                } else if (this.a.m.b.c(this.a.m.d().b)) {
                    this.a.m.b = (d) this.a.m.d().b.g();
                }
            }
            this.c.b(view, motionEvent, z, new aef(this, asVarArr));
        }
    }
}
