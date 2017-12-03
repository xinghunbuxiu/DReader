package com.duokan.reader.ui.reading;

import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;

import com.duokan.core.ui.du;
import com.duokan.core.ui.UTools;
import com.duokan.core.ui.er;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.d;

class aef implements du {
    final /* synthetic */ as[] a;
    final /* synthetic */ aed b;

    aef(aed com_duokan_reader_ui_reading_aed, as[] asVarArr) {
        this.b = com_duokan_reader_ui_reading_aed;
        this.a = asVarArr;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void a(er erVar, View view, PointF pointF, PointF pointF2) {
        if (this.b.a.m != null) {
            this.b.a.a.scrollBy(0, (int) (-pointF2.y));
            int a = this.b.a.m.a();
            Rect c = this.b.a.a.c(this.b.a.m.b().b);
            aeg com_duokan_reader_ui_reading_aeg;
            if (this.b.a.m.c.y >= c.bottom + UTools.getScaledPagingTouchSlop(this.b.a.getContext())) {
                if (a < this.b.a.m.a.length - 1) {
                    this.b.a.m.b = (d) this.b.a.m.a[a + 1].b.g();
                } else {
                    com_duokan_reader_ui_reading_aeg = new aeg();
                    com_duokan_reader_ui_reading_aeg.b = (d) this.b.a.m.d().b.g();
                    com_duokan_reader_ui_reading_aeg.c.set(this.b.a.m.c.x, this.b.a.m.c.y);
                    com_duokan_reader_ui_reading_aeg.d.set(this.b.a.m.d.x, this.b.a.m.d.y);
                    this.b.a.m = com_duokan_reader_ui_reading_aeg;
                    return;
                }
            } else if (this.b.a.m.c.y < c.top - UTools.getScaledPagingTouchSlop(this.b.a.getContext())) {
                if (a > 0) {
                    this.b.a.m.b = (d) this.b.a.m.a[a - 1].b.g();
                } else {
                    com_duokan_reader_ui_reading_aeg = new aeg();
                    com_duokan_reader_ui_reading_aeg.b = (d) this.b.a.m.c().b.g();
                    com_duokan_reader_ui_reading_aeg.c.set(this.b.a.m.c.x, this.b.a.m.c.y);
                    com_duokan_reader_ui_reading_aeg.d.set(this.b.a.m.d.x, this.b.a.m.d.y);
                    this.b.a.m = com_duokan_reader_ui_reading_aeg;
                    return;
                }
            }
        } else if (!this.b.a.j.b.isEmpty()) {
            this.b.a.d();
            this.b.a.m = new aeg();
            this.b.a.m.a = this.b.a.a(this.a);
            ael com_duokan_reader_ui_reading_ael = (ael) this.b.a.j.b.getFirst();
            this.b.a.m.b = (d) this.b.a.m.c().b.g();
            for (int i = 0; i < this.b.a.m.a.length; i++) {
                if (com_duokan_reader_ui_reading_ael.b.a(this.b.a.m.a[i].b.g())) {
                    this.b.a.m.b = (d) this.b.a.m.a[i].b.g();
                    break;
                }
            }
            Rect c2 = this.b.a.a.c(com_duokan_reader_ui_reading_ael.b);
            this.b.a.m.c.x = c2.centerX();
            this.b.a.m.c.y = c2.centerY();
            this.b.a.m.d.set(this.b.a.m.c.x, this.b.a.m.c.y);
            this.b.c(true);
            this.b.d(true);
        } else {
            return;
        }
        this.b.a.a.setActiveColorText(this.b.a.m.b().b);
        this.b.a.c.invalidate();
    }
}
