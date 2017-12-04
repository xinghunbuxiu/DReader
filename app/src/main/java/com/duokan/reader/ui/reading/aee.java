package com.duokan.reader.ui.reading;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;

import com.duokan.core.ui.UTools;
import com.duokan.core.ui.du;
import com.duokan.core.ui.er;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.d;
import com.duokan.reader.domain.document.i;

class aee implements du {
    final /* synthetic */ as a;
    final /* synthetic */ aed b;

    aee(aed com_duokan_reader_ui_reading_aed, as asVar) {
        this.b = com_duokan_reader_ui_reading_aed;
        this.a = asVar;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void a(er erVar, View view, PointF pointF, PointF pointF2) {
        Rect d;
        if (this.b.a.m != null) {
            Point point = this.b.a.m.c;
            point.y += (int) pointF2.y;
            if (Math.abs(this.b.a.m.d.y - this.b.a.m.c.y) > UTools.getScaledTouchSlop(this.b.a.getContext())) {
                this.b.a.m.d.set(this.b.a.m.c.x, this.b.a.m.c.y);
                int a = this.b.a.m.a();
                d dVar;
                aeg com_duokan_reader_ui_reading_aeg;
                if (a == this.b.a.m.a.length - 1 && this.b.a.m.c.y >= this.a.d(this.b.a.m.d().b).bottom + UTools.getScaledPagingTouchSlop(this.b.a.getContext())) {
                    dVar = (d) this.b.a.m.d().b.g();
                    com_duokan_reader_ui_reading_aeg = new aeg();
                    com_duokan_reader_ui_reading_aeg.b = dVar;
                    this.b.a.m = com_duokan_reader_ui_reading_aeg;
                    this.b.a.a.u();
                    return;
                } else if (a != 0 || this.b.a.m.c.y >= this.a.d(this.b.a.m.c().b).top - UTools.getScaledPagingTouchSlop(this.b.a.getContext())) {
                    as asVar;
                    if (this.a instanceof i) {
                        as b;
                        i iVar = (i) this.a;
                        if (iVar.d().contains(this.b.a.m.c.x, this.b.a.m.c.y)) {
                            b = iVar.b();
                        } else {
                            b = iVar.c();
                        }
                        asVar = b;
                    } else {
                        asVar = this.a;
                    }
                    d = asVar.d(this.b.a.m.a[a].b);
                    ael com_duokan_reader_ui_reading_ael;
                    if (pointF2.y < 0.0f || a >= this.b.a.m.a.length - 1) {
                        if (pointF2.y < 0.0f && a > 0 && this.b.a.m.c.y < d.top) {
                            com_duokan_reader_ui_reading_ael = this.b.a.m.a[a - 1];
                            this.b.a.m.b = (d) com_duokan_reader_ui_reading_ael.b.g();
                            if (!asVar.l().b(com_duokan_reader_ui_reading_ael.b)) {
                                point = this.a.g(com_duokan_reader_ui_reading_ael.b);
                                this.b.a.m.c.x = point.x;
                                this.b.a.m.c.y = point.y;
                            }
                        }
                    } else if (this.b.a.m.c.y >= d.bottom) {
                        com_duokan_reader_ui_reading_ael = this.b.a.m.a[a + 1];
                        this.b.a.m.b = (d) com_duokan_reader_ui_reading_ael.b.g();
                        if (!asVar.l().b(com_duokan_reader_ui_reading_ael.b)) {
                            point = this.a.f(com_duokan_reader_ui_reading_ael.b);
                            this.b.a.m.c.x = point.x;
                            this.b.a.m.c.y = point.y;
                        }
                    }
                } else {
                    dVar = (d) this.b.a.m.c().b.g();
                    com_duokan_reader_ui_reading_aeg = new aeg();
                    com_duokan_reader_ui_reading_aeg.b = dVar;
                    this.b.a.m = com_duokan_reader_ui_reading_aeg;
                    this.b.a.a.t();
                    return;
                }
            }
        } else if (!this.b.a.j.b.isEmpty()) {
            this.b.a.d();
            this.b.a.m = new aeg();
            this.b.a.m.a = this.b.a.a(this.a);
            ael com_duokan_reader_ui_reading_ael2 = (ael) this.b.a.j.b.getFirst();
            if (this.a.l().b(com_duokan_reader_ui_reading_ael2.b)) {
                int i;
                this.b.a.m.b = (d) this.b.a.m.c().b.g();
                for (i = 0; i < this.b.a.m.a.length; i++) {
                    if (com_duokan_reader_ui_reading_ael2.b.a(this.b.a.m.a[i].b.g())) {
                        this.b.a.m.b = (d) this.b.a.m.a[i].b.g();
                        break;
                    }
                }
                i = this.b.a.b.k().f;
                d = this.a.d(com_duokan_reader_ui_reading_ael2.b);
                if (pointF2.y >= 0.0f) {
                    this.b.a.m.c.x = d.centerX();
                    this.b.a.m.c.y = d.bottom - i;
                } else {
                    this.b.a.m.c.x = d.centerX();
                    this.b.a.m.c.y = d.top + i;
                }
            } else if (pointF2.y >= 0.0f) {
                com_duokan_reader_ui_reading_ael2 = this.b.a.m.c();
                r1 = this.a.d(com_duokan_reader_ui_reading_ael2.b);
                this.b.a.m.b = (d) com_duokan_reader_ui_reading_ael2.b.g();
                this.b.a.m.c.x = r1.centerX();
                this.b.a.m.c.y = r1.top;
            } else {
                com_duokan_reader_ui_reading_ael2 = this.b.a.m.d();
                r1 = this.a.d(com_duokan_reader_ui_reading_ael2.b);
                this.b.a.m.b = (d) com_duokan_reader_ui_reading_ael2.b.g();
                this.b.a.m.c.x = r1.centerX();
                this.b.a.m.c.y = r1.bottom;
            }
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
