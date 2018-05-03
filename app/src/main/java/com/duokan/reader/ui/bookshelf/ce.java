package com.duokan.reader.ui.bookshelf;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import com.duokan.core.ui.as;
import com.duokan.core.ui.bu;
import com.duokan.core.ui.dt;
import com.duokan.core.ui.AnimUtils;
import com.duokan.core.ui.er;
import com.duokan.core.ui.es;
import com.duokan.reader.domain.bookshelf.an;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.HttpStatus;

class ce extends er {
    /* renamed from: a */
    final /* synthetic */ bp f6250a;
    /* renamed from: c */
    private final bu f6251c;
    /* renamed from: d */
    private final dt f6252d;
    /* renamed from: e */
    private final dt f6253e;
    /* renamed from: f */
    private final as f6254f;
    /* renamed from: g */
    private boolean f6255g;
    /* renamed from: h */
    private cs f6256h;
    /* renamed from: i */
    private de f6257i;
    /* renamed from: j */
    private dn f6258j;
    /* renamed from: k */
    private an f6259k;
    /* renamed from: l */
    private boolean f6260l;
    /* renamed from: m */
    private int f6261m;
    /* renamed from: n */
    private int f6262n;
    /* renamed from: o */
    private cr f6263o;
    /* renamed from: p */
    private boolean f6264p;
    /* renamed from: q */
    private boolean f6265q;
    /* renamed from: r */
    private boolean f6266r;
    /* renamed from: s */
    private boolean f6267s;

    private ce(bp bpVar) {
        this.f6250a = bpVar;
        this.f6251c = new bu();
        this.f6252d = new dt();
        this.f6253e = new dt();
        this.f6254f = new as();
        this.f6255g = false;
        this.f6256h = null;
        this.f6257i = null;
        this.f6258j = null;
        this.f6259k = null;
        this.f6260l = true;
        this.f6261m = 0;
        this.f6262n = -1;
        this.f6263o = null;
        this.f6264p = false;
        this.f6265q = false;
        this.f6266r = false;
        this.f6267s = false;
    }

    /* renamed from: a */
    protected void mo511a(View view, boolean z) {
        this.f6251c.m1612b(view, z);
        this.f6252d.m1612b(view, z);
        this.f6253e.m1612b(view, z);
        this.f6254f.m1612b(view, z);
        this.f6254f.m1632a((int) HttpStatus.SC_MULTIPLE_CHOICES);
        this.f6254f.m1635b((int) HttpStatus.SC_MULTIPLE_CHOICES);
        this.f6253e.m1882a(AnimUtils.getScaledPagingTouchSlop(this.f6250a.getContext()));
        this.f6255g = false;
        this.f6259k = null;
        this.f6261m = 0;
        this.f6262n = -1;
        this.f6263o = null;
        this.f6265q = false;
        this.f6266r = false;
        this.f6267s = false;
    }

    /* renamed from: c */
    protected void mo526c(View view, MotionEvent motionEvent, boolean z, es esVar) {
        this.f6251c.m1611b(view, motionEvent, z, new cf(this));
    }

    /* renamed from: a */
    protected void mo510a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        boolean z2 = true;
        this.f6252d.m1611b(view, motionEvent, z, new cg(this));
        if ((m9407m() || m9405l() || m9401j()) && !m9403k()) {
            this.f6253e.m1611b(view, motionEvent, z, new ch(this));
        }
        this.f6254f.m1611b(view, motionEvent, z, new ci(this));
        if (motionEvent.getActionMasked() == 1 && this.f6255g && this.f6264p) {
            an anVar;
            int a = m9353a(this.f6256h.m9430c(), true);
            if (a >= 0 && !m9400i()) {
                de c = m9381c(a);
                if (c.getItemStatus() == DragItemStatus.Actived) {
                    m9373a(c, this.f6259k, m9375b(a), a);
                    if (!z2) {
                        this.f6258j.mo1663a(0, this.f6261m, HttpStatus.SC_MULTIPLE_CHOICES, null, null);
                        m9365a();
                        anVar = this.f6259k;
                        this.f6256h.m9425a((long) 300, new cj(this, this.f6266r, anVar));
                    }
                }
            }
            z2 = false;
            if (!z2) {
                this.f6258j.mo1663a(0, this.f6261m, HttpStatus.SC_MULTIPLE_CHOICES, null, null);
                m9365a();
                anVar = this.f6259k;
                this.f6256h.m9425a((long) 300, new cj(this, this.f6266r, anVar));
            }
        }
    }

    /* renamed from: f */
    private void m9391f(boolean z) {
        Iterator it = this.f6250a.f6195f.iterator();
        while (it.hasNext()) {
            ((da) it.next()).mo1631d();
        }
        if (this.f6258j != null) {
            this.f6258j.mo1668a(null, !z);
        }
        if (this.f6257i != null) {
            this.f6257i.m9124l();
            this.f6257i = null;
        }
        if (this.f6264p) {
            this.f6250a.f6196g.mo2553c(this.f6256h);
            this.f6264p = false;
            this.f6259k = null;
        }
    }

    /* renamed from: g */
    private boolean m9395g(boolean z) {
        PointF c = this.f6256h.m9430c();
        int a = m9353a(c, true);
        if (a < 0 || m9400i() || m9401j() || m9405l()) {
            m9365a();
        } else {
            an b = m9375b(a);
            de c2 = m9381c(a);
            if (AnimUtils.m1949d(c2.getViewCenter(), c) >= ((double) AnimUtils.m1932b(this.f6250a.getContext(), 25.0f)) || this.f6259k == b || !c2.m9122j() || !this.f6260l) {
                m9365a();
                if (this.f6258j != null) {
                    de draggingItemView = this.f6258j.getDraggingItemView();
                    if (draggingItemView != null) {
                        draggingItemView.m9116d();
                    }
                }
            } else if (z || c2.getItemStatus() != DragItemStatus.Normal) {
                return true;
            } else {
                c2.m9123k();
                this.f6256h.m9429b();
                if (this.f6258j != null) {
                    de draggingItemView2 = this.f6258j.getDraggingItemView();
                    if (draggingItemView2 != null) {
                        draggingItemView2.m9115c();
                    }
                }
                this.f6257i = c2;
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private void m9365a() {
        if (this.f6257i != null) {
            this.f6257i.m9124l();
            this.f6257i = null;
            this.f6256h.m9423a();
        }
    }

    /* renamed from: a */
    private void m9366a(int i) {
        this.f6266r = true;
        m9367a(300, new ck(this, i));
    }

    /* renamed from: a */
    private void m9367a(long j, Runnable runnable) {
        int i;
        int[] visibleItemIndices = this.f6258j.getVisibleItemIndices();
        ArrayList arrayList = new ArrayList(visibleItemIndices.length + 1);
        ArrayList arrayList2 = new ArrayList(visibleItemIndices.length + 1);
        for (int b : visibleItemIndices) {
            View b2 = this.f6258j.mo1670b(b);
            Rect rect = new Rect();
            AnimUtils.m1904a(rect, b2, null);
            arrayList.add(b2);
            arrayList2.add(rect);
        }
        if (visibleItemIndices.length > 0) {
            i = visibleItemIndices[visibleItemIndices.length - 1] + 1;
            if (i < this.f6258j.getItemCount()) {
                Rect a = this.f6258j.mo1661a(i);
                View b3 = this.f6258j.mo1670b(i);
                AnimUtils.m1904a(a, b3, null);
                arrayList.add(b3);
                arrayList2.add(a);
            }
        }
        runnable.run();
        AnimationListener clVar = new cl(this, arrayList);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            b3 = (View) arrayList.get(i2);
            Rect rect2 = (Rect) arrayList2.get(i2);
            if (b3.getVisibility() == 0) {
                Animation a2 = m9356a(rect2, b3, j);
                a2.setAnimationListener(clVar);
                b3.startAnimation(a2);
            }
        }
    }

    /* renamed from: a */
    private Animation m9356a(Rect rect, View view, long j) {
        AnimUtils.m1903a(rect, view);
        Animation translateAnimation = new TranslateAnimation((float) rect.left, 0.0f, (float) rect.top, 0.0f);
        translateAnimation.setDuration(j);
        return translateAnimation;
    }

    /* renamed from: a */
    private void m9373a(de deVar, an anVar, an anVar2, int i) {
        this.f6266r = true;
        m9365a();
        Rect rect = (Rect) AnimUtils.f1198g.addAnimation();
        deVar.m9113a(rect, 300);
        this.f6256h.m9427a(rect, 300, new cm(this, anVar, anVar2, i));
        AnimUtils.f1198g.clearAnimation(rect);
    }

    /* renamed from: a */
    private void m9369a(an anVar) {
        this.f6266r = true;
        this.f6250a.mo1647a(new co(this, this.f6250a.f6197h.m9517c(), anVar));
    }

    /* renamed from: h */
    private void m9396h() {
        this.f6267s = false;
        this.f6263o = null;
    }

    /* renamed from: i */
    private boolean m9400i() {
        return this.f6258j == this.f6250a.f6197h;
    }

    /* renamed from: b */
    private an m9375b(int i) {
        if (this.f6258j == null) {
            return null;
        }
        return this.f6258j.mo1671c(i);
    }

    /* renamed from: c */
    private de m9381c(int i) {
        if (this.f6258j == null) {
            return null;
        }
        return this.f6258j.mo1670b(i);
    }

    /* renamed from: a */
    private de m9361a(RectF rectF, int i) {
        View c = m9381c(i);
        if (c == null) {
            rectF.setEmpty();
        } else {
            rectF.set(0.0f, 0.0f, (float) c.getWidth(), (float) c.getHeight());
            AnimUtils.m1947c(rectF, c);
        }
        return c;
    }

    /* renamed from: a */
    private int m9352a(PointF pointF) {
        if (this.f6258j == null) {
            return -1;
        }
        int[] visibleItemIndices = this.f6258j.getVisibleItemIndices();
        float f = Float.MAX_VALUE;
        int i = -1;
        for (int i2 : visibleItemIndices) {
            de c = m9381c(i2);
            RectF viewBounds = c.getViewBounds();
            PointF viewCenter = c.getViewCenter();
            if (c.m9121i() && this.f6259k != c.getItem() && m9374a(c, 0.5f) && pointF.y >= viewBounds.top && pointF.y <= viewBounds.bottom) {
                float f2 = viewCenter.x - pointF.x;
                float abs = Math.abs(f2);
                if ((f2 <= 0.0f || (f2 > 0.0f && this.f6262n != i2 - 1)) && abs < viewBounds.width() && abs < f) {
                    f = abs;
                    i = i2;
                }
            }
        }
        if (i >= 0) {
            if (this.f6262n < i) {
                return i;
            }
            de c2 = m9381c(i);
            PointF viewCenter2 = c2.getViewCenter();
            if (pointF.x <= viewCenter2.x) {
                return i;
            }
            if (pointF.x > viewCenter2.x && !this.f6258j.mo1669a(i, c2)) {
                return i + 1;
            }
        }
        if (visibleItemIndices.length <= 0) {
            return -1;
        }
        i = visibleItemIndices[visibleItemIndices.length - 1];
        RectF dragBounds = m9381c(i).getDragBounds();
        if (pointF.y > dragBounds.bottom || (pointF.y > dragBounds.top && pointF.y < dragBounds.bottom && pointF.x > dragBounds.centerX())) {
            return i;
        }
        return -1;
    }

    /* renamed from: a */
    private int m9353a(PointF pointF, boolean z) {
        if (this.f6258j == null) {
            return -1;
        }
        int i;
        int[] visibleItemIndices = this.f6258j.getVisibleItemIndices();
        for (i = 0; i < visibleItemIndices.length; i++) {
            de b = this.f6258j.mo1670b(visibleItemIndices[i]);
            RectF dragBounds = b.getDragBounds();
            if ((!z || m9374a(b, 0.5f)) && dragBounds.contains(pointF.x, pointF.y)) {
                i = visibleItemIndices[i];
                break;
            }
        }
        i = -1;
        return i;
    }

    /* renamed from: j */
    private boolean m9401j() {
        return this.f6263o != null;
    }

    /* renamed from: k */
    private boolean m9403k() {
        return this.f6265q;
    }

    /* renamed from: l */
    private boolean m9405l() {
        return this.f6267s;
    }

    /* renamed from: m */
    private boolean m9407m() {
        return false;
    }

    /* renamed from: a */
    private void m9368a(Rect rect) {
        this.f6258j.mo1664a(rect);
    }

    /* renamed from: a */
    private boolean m9374a(de deVar, float f) {
        boolean z = false;
        Rect rect = (Rect) AnimUtils.f1198g.addAnimation();
        RectF rectF = (RectF) AnimUtils.f1199h.addAnimation();
        m9368a(rect);
        rectF.set(rect);
        RectF dragBounds = deVar.getDragBounds();
        if (RectF.intersects(rectF, dragBounds)) {
            if (Float.compare((dragBounds.height() * dragBounds.width()) * f, (Math.min(rectF.right, dragBounds.right) - Math.max(rectF.left, dragBounds.right)) * (Math.min(rectF.bottom, dragBounds.bottom) - Math.max(rectF.top, dragBounds.top))) > 0) {
                z = true;
            }
        }
        AnimUtils.f1199h.clearAnimation(rectF);
        AnimUtils.f1198g.clearAnimation(rect);
        return z;
    }
}
