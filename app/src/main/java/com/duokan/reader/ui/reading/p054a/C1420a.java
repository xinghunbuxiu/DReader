package com.duokan.reader.ui.reading.p054a;

import android.graphics.PointF;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import com.duokan.core.ui.ct;
import com.duokan.core.ui.er;
import com.duokan.core.ui.es;
import com.duokan.reader.domain.document.C0930b;
import com.duokan.reader.domain.document.bb;
import com.duokan.reader.domain.document.epub.C0936c;
import com.duokan.reader.domain.document.epub.C0952s;
import com.duokan.reader.ui.reading.gx;
import com.duokan.reader.ui.reading.su;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.duokan.reader.ui.reading.a.a */
public class C1420a extends er {
    /* renamed from: a */
    private final su f9179a;
    /* renamed from: c */
    private final ct f9180c = new ct();

    public C1420a(su suVar) {
        this.f9179a = suVar;
    }

    /* renamed from: a */
    protected void mo511a(View view, boolean z) {
        this.f9180c.m1612b(view, z);
    }

    /* renamed from: a */
    protected void mo510a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        if (this.f9179a.mo2007X().mo2329e()) {
            this.f9180c.m1611b(view, motionEvent, z, new C1421b(this, esVar));
        }
    }

    /* renamed from: a */
    private boolean m12617a(View view, es esVar, PointF pointF) {
        gx e = this.f9179a.mo2137e((int) pointF.x, (int) pointF.y);
        if (e == null || !e.m14303i()) {
            return false;
        }
        List<C0930b> linkedList = new LinkedList();
        C0952s c0952s = (C0952s) this.f9179a.getDocument();
        bb m = e.getPageDrawable().mo1334m();
        C0936c c0936c = (C0936c) m.mo1198g();
        for (C0930b c0930b : c0952s.m7060c(c0936c.m6780g())) {
            if (m.m5814b(c0930b.mo1443a())) {
                linkedList.add(c0930b);
            }
        }
        C0936c c0936c2 = (C0936c) m.mo1199h();
        if (c0936c2.m6780g() != c0936c.m6780g()) {
            for (C0930b c0930b2 : c0952s.m7060c(c0936c2.m6780g())) {
                if (m.m5814b(c0930b2.mo1443a())) {
                    linkedList.add(c0930b2);
                }
            }
        }
        for (C0930b c0930b3 : linkedList) {
            Rect[] b = this.f9179a.mo2107b(c0930b3.mo1443a());
            if (b != null && b.length > 0) {
                for (Rect contains : b) {
                    if (contains.contains((int) pointF.x, (int) pointF.y)) {
                        this.f9179a.mo2025a(c0930b3.mo1443a(), true);
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }
}
