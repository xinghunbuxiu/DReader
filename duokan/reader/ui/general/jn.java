package com.duokan.reader.ui.general;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;

import com.duokan.core.ui.UTools;

import java.util.LinkedList;

public class jn {
    private View a = null;
    private int b = 0;
    private final LinkedList c = new LinkedList();

    public jn(View view, MotionEvent motionEvent) {
        int i = 0;
        this.a = view;
        this.b = motionEvent.getActionMasked();
        while (i < motionEvent.getPointerCount()) {
            jp jpVar = new jp();
            jpVar.a = motionEvent.getPointerId(i);
            jpVar.b.x = motionEvent.getX(i) + ((float) this.a.getScrollX());
            jpVar.b.y = motionEvent.getY(i) + ((float) this.a.getScrollY());
            UTools.getScaledTouchSlop(jpVar.b, this.a);
            this.c.add(jpVar);
            i++;
        }
    }

    public void a() {
        this.a = null;
        this.b = 0;
        this.c.clear();
    }

    public void a(jn jnVar) {
        a();
        if (jnVar != null) {
            this.a = jnVar.a;
            this.b = jnVar.b;
            this.c.addAll(jnVar.c);
        }
    }

    public boolean b() {
        return this.a == null;
    }

    public View c() {
        return this.a;
    }

    public int d() {
        return this.b;
    }

    public int e() {
        return this.c.size();
    }

    public int a(int i) {
        return ((jp) this.c.get(i)).a;
    }

    public int b(int i) {
        for (int i2 = 0; i2 < this.c.size(); i2++) {
            if (((jp) this.c.get(i2)).a == i) {
                return i2;
            }
        }
        return -1;
    }

    public float c(int i) {
        return ((jp) this.c.get(i)).b.x;
    }

    public float d(int i) {
        return ((jp) this.c.get(i)).b.y;
    }

    public PointF a(int i, PointF pointF) {
        jp jpVar = (jp) this.c.get(i);
        pointF.set(jpVar.b.x, jpVar.b.y);
        return pointF;
    }

    public PointF a(PointF pointF) {
        UTools.closeAnimation(pointF, this.a);
        pointF.offset((float) (-this.a.getScrollX()), (float) (-this.a.getScrollY()));
        return pointF;
    }

    public PointF b(PointF pointF) {
        UTools.addAnimation(pointF, this.a);
        return pointF;
    }
}
