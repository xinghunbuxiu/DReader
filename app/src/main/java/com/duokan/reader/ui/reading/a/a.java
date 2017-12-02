package com.duokan.reader.ui.reading.a;

import android.graphics.PointF;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

import com.duokan.core.ui.ct;
import com.duokan.core.ui.er;
import com.duokan.core.ui.es;
import com.duokan.reader.domain.document.b;
import com.duokan.reader.domain.document.bb;
import com.duokan.reader.domain.document.epub.c;
import com.duokan.reader.domain.document.epub.s;
import com.duokan.reader.ui.reading.gs;
import com.duokan.reader.ui.reading.sh;

import java.util.LinkedList;
import java.util.List;

public class a extends er {
    private final sh a;
    private final ct c = new ct();

    public a(sh shVar) {
        this.a = shVar;
    }

    protected void a(View view, boolean z) {
        this.c.b(view, z);
    }

    protected void a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        if (this.a.X().e()) {
            this.c.b(view, motionEvent, z, new b(this, esVar));
        }
    }

    private boolean a(View view, es esVar, PointF pointF) {
        gs e = this.a.e((int) pointF.x, (int) pointF.y);
        if (e == null || !e.i()) {
            return false;
        }
        List<b> linkedList = new LinkedList();
        s sVar = (s) this.a.getDocument();
        bb m = e.getPageDrawable().m();
        c cVar = (c) m.g();
        for (b bVar : sVar.c(cVar.g())) {
            if (m.b(bVar.a())) {
                linkedList.add(bVar);
            }
        }
        c cVar2 = (c) m.h();
        if (cVar2.g() != cVar.g()) {
            for (b bVar2 : sVar.c(cVar2.g())) {
                if (m.b(bVar2.a())) {
                    linkedList.add(bVar2);
                }
            }
        }
        for (b bVar3 : linkedList) {
            Rect[] b = this.a.b(bVar3.a());
            if (b != null && b.length > 0) {
                for (Rect contains : b) {
                    if (contains.contains((int) pointF.x, (int) pointF.y)) {
                        this.a.a(bVar3.a(), true);
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }
}
