package com.duokan.reader.ui.bookshelf;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;

import com.duokan.core.ui.UTools;
import com.duokan.core.ui.as;
import com.duokan.core.ui.bu;
import com.duokan.core.ui.dt;
import com.duokan.core.ui.er;
import com.duokan.core.ui.es;
import com.duokan.reader.domain.bookshelf.an;

import org.apache.http.HttpStatus;

import java.util.ArrayList;
import java.util.Iterator;

class bz extends er {
    final /* synthetic */ bk a;
    private final bu c;
    private final dt d;
    private final dt e;
    private final as f;
    private boolean g;
    private cn h;
    private cz i;
    private dg j;
    private an k;
    private boolean l;
    private int m;
    private int n;
    private cm o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;

    private bz(bk bkVar) {
        this.a = bkVar;
        this.c = new bu();
        this.d = new dt();
        this.e = new dt();
        this.f = new as();
        this.g = false;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = true;
        this.m = 0;
        this.n = -1;
        this.o = null;
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = false;
    }

    protected void a(View view, boolean z) {
        this.c.b(view, z);
        this.d.b(view, z);
        this.e.b(view, z);
        this.f.b(view, z);
        this.f.a((int) HttpStatus.SC_MULTIPLE_CHOICES);
        this.f.b((int) HttpStatus.SC_MULTIPLE_CHOICES);
        this.e.a(UTools.getScaledPagingTouchSlop(this.a.getContext()));
        this.g = false;
        this.k = null;
        this.m = 0;
        this.n = -1;
        this.o = null;
        this.q = false;
        this.r = false;
        this.s = false;
    }

    protected void c(View view, MotionEvent motionEvent, boolean z, es esVar) {
        this.c.b(view, motionEvent, z, new ca(this));
    }

    protected void a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        boolean z2 = true;
        this.d.b(view, motionEvent, z, new cb(this));
        if ((m() || l() || j()) && !k()) {
            this.e.b(view, motionEvent, z, new cc(this));
        }
        this.f.b(view, motionEvent, z, new cd(this));
        if (motionEvent.getActionMasked() == 1 && this.g && this.p) {
            an anVar;
            int a = a(this.h.c(), true);
            if (a >= 0 && !i()) {
                cz c = c(a);
                if (c.getItemStatus() == DragItemStatus.Actived) {
                    a(c, this.k, b(a), a);
                    if (!z2) {
                        this.j.a(0, this.m, HttpStatus.SC_MULTIPLE_CHOICES, null, null);
                        a();
                        anVar = this.k;
                        this.h.a((long) 300, new ce(this, this.r, anVar));
                    }
                }
            }
            z2 = false;
            if (!z2) {
                this.j.a(0, this.m, HttpStatus.SC_MULTIPLE_CHOICES, null, null);
                a();
                anVar = this.k;
                this.h.a((long) 300, new ce(this, this.r, anVar));
            }
        }
    }

    private void f(boolean z) {
        Iterator it = this.a.f.iterator();
        while (it.hasNext()) {
            ((cv) it.next()).d();
        }
        if (this.j != null) {
            this.j.a(null, !z);
        }
        if (this.i != null) {
            this.i.l();
            this.i = null;
        }
        if (this.p) {
            this.a.g.c(this.h);
            this.p = false;
            this.k = null;
        }
    }

    private boolean g(boolean z) {
        PointF c = this.h.c();
        int a = a(c, true);
        if (a < 0 || i() || j() || l()) {
            a();
        } else {
            an b = b(a);
            cz c2 = c(a);
            if (UTools.getTriangleEdge(c2.getViewCenter(), c) >= ((double) UTools.getMinimumHeight(this.a.getContext(), 25.0f)) || this.k == b || !c2.j() || !this.l) {
                a();
                if (this.j != null) {
                    cz draggingItemView = this.j.getDraggingItemView();
                    if (draggingItemView != null) {
                        draggingItemView.d();
                    }
                }
            } else if (z || c2.getItemStatus() != DragItemStatus.Normal) {
                return true;
            } else {
                c2.k();
                this.h.b();
                if (this.j != null) {
                    cz draggingItemView2 = this.j.getDraggingItemView();
                    if (draggingItemView2 != null) {
                        draggingItemView2.c();
                    }
                }
                this.i = c2;
                return true;
            }
        }
        return false;
    }

    private void a() {
        if (this.i != null) {
            this.i.l();
            this.i = null;
            this.h.a();
        }
    }

    private void a(int i) {
        this.r = true;
        a(300, new cf(this, i));
    }

    private void a(long j, Runnable runnable) {
        int i;
        int[] visibleItemIndices = this.j.getVisibleItemIndices();
        ArrayList arrayList = new ArrayList(visibleItemIndices.length + 1);
        ArrayList arrayList2 = new ArrayList(visibleItemIndices.length + 1);
        for (int b : visibleItemIndices) {
            View b2 = this.j.b(b);
            Rect rect = new Rect();
            UTools.getRect(rect, b2, null);
            arrayList.add(b2);
            arrayList2.add(rect);
        }
        if (visibleItemIndices.length > 0) {
            i = visibleItemIndices[visibleItemIndices.length - 1] + 1;
            if (i < this.j.getItemCount()) {
                Rect a = this.j.a(i);
                View b3 = this.j.b(i);
                UTools.getRect(a, b3, null);
                arrayList.add(b3);
                arrayList2.add(a);
            }
        }
        runnable.run();
        AnimationListener cgVar = new cg(this, arrayList);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            b3 = (View) arrayList.get(i2);
            Rect rect2 = (Rect) arrayList2.get(i2);
            if (b3.getVisibility() == 0) {
                Animation a2 = a(rect2, b3, j);
                a2.setAnimationListener(cgVar);
                b3.startAnimation(a2);
            }
        }
    }

    private Animation a(Rect rect, View view, long j) {
        UTools.addAnimation(rect, view);
        Animation translateAnimation = new TranslateAnimation((float) rect.left, 0.0f, (float) rect.top, 0.0f);
        translateAnimation.setDuration(j);
        return translateAnimation;
    }

    private void a(cz czVar, an anVar, an anVar2, int i) {
        this.r = true;
        a();
        Rect rect = (Rect) UTools.g.getRect();
        czVar.a(rect, 300);
        this.h.a(rect, 300, new ch(this, anVar, anVar2, i));
        UTools.g.getRect(rect);
    }

    private void a(an anVar) {
        this.r = true;
        this.a.a(new cj(this, this.a.h.c(), anVar));
    }

    private void h() {
        this.s = false;
        this.o = null;
    }

    private boolean i() {
        return this.j == this.a.h;
    }

    private an b(int i) {
        if (this.j == null) {
            return null;
        }
        return this.j.c(i);
    }

    private cz c(int i) {
        if (this.j == null) {
            return null;
        }
        return this.j.b(i);
    }

    private cz a(RectF rectF, int i) {
        View c = c(i);
        if (c == null) {
            rectF.setEmpty();
        } else {
            rectF.set(0.0f, 0.0f, (float) c.getWidth(), (float) c.getHeight());
            UTools.showAnimation(rectF, c);
        }
        return c;
    }

    private int a(PointF pointF) {
        if (this.j == null) {
            return -1;
        }
        int[] visibleItemIndices = this.j.getVisibleItemIndices();
        float f = Float.MAX_VALUE;
        int i = -1;
        for (int i2 : visibleItemIndices) {
            cz c = c(i2);
            RectF viewBounds = c.getViewBounds();
            PointF viewCenter = c.getViewCenter();
            if (c.i() && this.k != c.getItem() && a(c, 0.5f) && pointF.y >= viewBounds.top && pointF.y <= viewBounds.bottom) {
                float f2 = viewCenter.x - pointF.x;
                float abs = Math.abs(f2);
                if ((f2 <= 0.0f || (f2 > 0.0f && this.n != i2 - 1)) && abs < viewBounds.width() && abs < r1) {
                    f = abs;
                    i = i2;
                }
            }
        }
        if (i >= 0) {
            if (this.n < i) {
                return i;
            }
            cz c2 = c(i);
            PointF viewCenter2 = c2.getViewCenter();
            if (pointF.x <= viewCenter2.x) {
                return i;
            }
            if (pointF.x > viewCenter2.x && !this.j.a(i, c2)) {
                return i + 1;
            }
        }
        if (visibleItemIndices.length <= 0) {
            return -1;
        }
        i = visibleItemIndices[visibleItemIndices.length - 1];
        RectF dragBounds = c(i).getDragBounds();
        if (pointF.y > dragBounds.bottom || (pointF.y > dragBounds.top && pointF.y < dragBounds.bottom && pointF.x > dragBounds.centerX())) {
            return i;
        }
        return -1;
    }

    private int a(PointF pointF, boolean z) {
        if (this.j == null) {
            return -1;
        }
        int i;
        int[] visibleItemIndices = this.j.getVisibleItemIndices();
        for (i = 0; i < visibleItemIndices.length; i++) {
            cz b = this.j.b(visibleItemIndices[i]);
            RectF dragBounds = b.getDragBounds();
            if ((!z || a(b, 0.5f)) && dragBounds.contains(pointF.x, pointF.y)) {
                i = visibleItemIndices[i];
                break;
            }
        }
        i = -1;
        return i;
    }

    private boolean j() {
        return this.o != null;
    }

    private boolean k() {
        return this.q;
    }

    private boolean l() {
        return this.s;
    }

    private boolean m() {
        return false;
    }

    private void a(Rect rect) {
        this.j.a(rect);
    }

    private boolean a(cz czVar, float f) {
        boolean z = false;
        Rect rect = (Rect) UTools.g.getRect();
        RectF rectF = (RectF) UTools.h.getRect();
        a(rect);
        rectF.set(rect);
        RectF dragBounds = czVar.getDragBounds();
        if (RectF.intersects(rectF, dragBounds)) {
            if (Float.compare((dragBounds.height() * dragBounds.width()) * f, (Math.min(rectF.right, dragBounds.right) - Math.max(rectF.left, dragBounds.right)) * (Math.min(rectF.bottom, dragBounds.bottom) - Math.max(rectF.top, dragBounds.top))) > 0) {
                z = true;
            }
        }
        UTools.h.getRect(rectF);
        UTools.g.getRect(rect);
        return z;
    }
}
