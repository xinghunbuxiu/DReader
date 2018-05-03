package com.duokan.reader.ui.general;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import com.duokan.core.ui.AnimUtils;
import java.util.LinkedList;

public class ix {
    /* renamed from: a */
    private View f7416a = null;
    /* renamed from: b */
    private int f7417b = 0;
    /* renamed from: c */
    private final LinkedList<iz> f7418c = new LinkedList();

    public ix(View view, MotionEvent motionEvent) {
        int i = 0;
        this.f7416a = view;
        this.f7417b = motionEvent.getActionMasked();
        while (i < motionEvent.getPointerCount()) {
            iz izVar = new iz();
            izVar.f7419a = motionEvent.getPointerId(i);
            izVar.f7420b.x = motionEvent.getX(i) + ((float) this.f7416a.getScrollX());
            izVar.f7420b.y = motionEvent.getY(i) + ((float) this.f7416a.getScrollY());
            AnimUtils.m1953d(izVar.f7420b, this.f7416a);
            this.f7418c.add(izVar);
            i++;
        }
    }

    /* renamed from: a */
    public void m10819a() {
        this.f7416a = null;
        this.f7417b = 0;
        this.f7418c.clear();
    }

    /* renamed from: a */
    public void m10820a(ix ixVar) {
        m10819a();
        if (ixVar != null) {
            this.f7416a = ixVar.f7416a;
            this.f7417b = ixVar.f7417b;
            this.f7418c.addAll(ixVar.f7418c);
        }
    }

    /* renamed from: b */
    public boolean m10823b() {
        return this.f7416a == null;
    }

    /* renamed from: c */
    public View m10825c() {
        return this.f7416a;
    }

    /* renamed from: d */
    public int m10827d() {
        return this.f7417b;
    }

    /* renamed from: e */
    public int m10828e() {
        return this.f7418c.size();
    }

    /* renamed from: a */
    public int m10816a(int i) {
        return ((iz) this.f7418c.get(i)).f7419a;
    }

    /* renamed from: b */
    public int m10821b(int i) {
        for (int i2 = 0; i2 < this.f7418c.size(); i2++) {
            if (((iz) this.f7418c.get(i2)).f7419a == i) {
                return i2;
            }
        }
        return -1;
    }

    /* renamed from: c */
    public float m10824c(int i) {
        return ((iz) this.f7418c.get(i)).f7420b.x;
    }

    /* renamed from: d */
    public float m10826d(int i) {
        return ((iz) this.f7418c.get(i)).f7420b.y;
    }

    /* renamed from: a */
    public PointF m10817a(int i, PointF pointF) {
        iz izVar = (iz) this.f7418c.get(i);
        pointF.set(izVar.f7420b.x, izVar.f7420b.y);
        return pointF;
    }

    /* renamed from: a */
    public PointF m10818a(PointF pointF) {
        AnimUtils.m1935b(pointF, this.f7416a);
        pointF.offset((float) (-this.f7416a.getScrollX()), (float) (-this.f7416a.getScrollY()));
        return pointF;
    }

    /* renamed from: b */
    public PointF m10822b(PointF pointF) {
        AnimUtils.m1899a(pointF, this.f7416a);
        return pointF;
    }
}
