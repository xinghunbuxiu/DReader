package com.duokan.reader.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;

import com.duokan.core.ui.dv;
import java.util.HashMap;

/* renamed from: com.duokan.reader.ui.f */
public class C1315f extends ViewGroup {
    /* renamed from: a */
    private final HashMap<View, C1383h> f6754a;
    /* renamed from: b */
    private int f6755b;
    /* renamed from: c */
    private Paint f6756c;

    public C1315f(Context context) {
        this(context, null);
    }

    public C1315f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6754a = new HashMap();
        this.f6755b = Color.argb(255, 255, 255, 255);
        this.f6756c = new Paint();
        View surfaceView = new SurfaceView(getContext());
        surfaceView.setVisibility(8);
        addView(surfaceView, new LayoutParams(0, 0));
        this.f6756c.setXfermode(new PorterDuffXfermode(Mode.MULTIPLY));
        setWillNotDraw(false);
        setDrawingCacheEnabled(false);
    }

    /* renamed from: a */
    public void m9916a(View view, boolean z) {
        if (z) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            C1383h c1383h = new C1383h();
            c1383h.f8188a.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            dv.m1936b(c1383h.f8188a, (View) this);
            c1383h.f8188a.right = displayMetrics.widthPixels - c1383h.f8188a.right;
            c1383h.f8188a.bottom = displayMetrics.heightPixels - c1383h.f8188a.bottom;
            this.f6754a.put(view, c1383h);
        } else if (this.f6754a.remove(view) != null) {
            view.requestLayout();
        }
    }

    /* renamed from: a */
    public void m9915a(float f, float f2, float f3) {
        this.f6755b = Color.argb(255, Math.round(255.0f * f), Math.round(255.0f * f2), Math.round(255.0f * f3));
        invalidate();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f6755b != Color.argb(255, 255, 255, 255)) {
            this.f6756c.setColor(this.f6755b);
            canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), this.f6756c);
        }
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < getChildCount()) {
            int i6;
            View childAt = getChildAt(i3);
            C1383h c1383h = (C1383h) this.f6754a.get(childAt);
            if (c1383h != null) {
                DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
                Rect rect = (Rect) dv.f1198g.addAnimation();
                rect.set(c1383h.f8188a.left, c1383h.f8188a.top, displayMetrics.widthPixels - c1383h.f8188a.right, displayMetrics.heightPixels - c1383h.f8188a.bottom);
                dv.m1903a(rect, (View) this);
                childAt.measure(MeasureSpec.makeMeasureSpec(rect.width(), 1073741824), MeasureSpec.makeMeasureSpec(rect.height(), 1073741824));
                dv.f1198g.clearAnimation(rect);
            } else if (childAt.getVisibility() != 8) {
                childAt.measure(i, i2);
            } else {
                i6 = i4;
                i4 = i5;
                i3++;
                i5 = i4;
                i4 = i6;
            }
            i5 = Math.max(i5, childAt.getMeasuredWidth());
            i6 = Math.max(i4, childAt.getMeasuredHeight());
            i4 = i5;
            i3++;
            i5 = i4;
            i4 = i6;
        }
        setMeasuredDimension(C1315f.resolveSize(i5, i), C1315f.resolveSize(i4, i2));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            C1383h c1383h = (C1383h) this.f6754a.get(childAt);
            if (c1383h != null) {
                DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
                Rect rect = (Rect) dv.f1198g.addAnimation();
                rect.set(c1383h.f8188a.left, c1383h.f8188a.top, displayMetrics.widthPixels - c1383h.f8188a.right, displayMetrics.heightPixels - c1383h.f8188a.bottom);
                dv.m1903a(rect, (View) this);
                childAt.layout(rect.left, rect.top, rect.right, rect.bottom);
                dv.f1198g.clearAnimation(rect);
            } else if (childAt.getVisibility() != 8) {
                childAt.layout(0, 0, childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
            }
        }
    }
}
