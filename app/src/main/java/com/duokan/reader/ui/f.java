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

import com.duokan.core.ui.UTools;

import java.util.HashMap;

public class f extends ViewGroup {
    private final HashMap a;
    private int b;
    private Paint c;

    public f(Context context) {
        this(context, null);
    }

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new HashMap();
        this.b = Color.argb(255, 255, 255, 255);
        this.c = new Paint();
        View surfaceView = new SurfaceView(getContext());
        surfaceView.setVisibility(8);
        addView(surfaceView, new LayoutParams(0, 0));
        this.c.setXfermode(new PorterDuffXfermode(Mode.MULTIPLY));
        setWillNotDraw(false);
        setDrawingCacheEnabled(false);
    }

    public void a(View view, boolean z) {
        if (z) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            h hVar = new h();
            hVar.a.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            UTools.closeAnimation(hVar.a, (View) this);
            hVar.a.right = displayMetrics.widthPixels - hVar.a.right;
            hVar.a.bottom = displayMetrics.heightPixels - hVar.a.bottom;
            this.a.put(view, hVar);
        } else if (this.a.remove(view) != null) {
            view.requestLayout();
        }
    }

    public void a(float f, float f2, float f3) {
        this.b = Color.argb(255, Math.round(255.0f * f), Math.round(255.0f * f2), Math.round(255.0f * f3));
        invalidate();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.b != Color.argb(255, 255, 255, 255)) {
            this.c.setColor(this.b);
            canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), this.c);
        }
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < getChildCount()) {
            int i6;
            View childAt = getChildAt(i3);
            h hVar = (h) this.a.get(childAt);
            if (hVar != null) {
                DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
                Rect rect = (Rect) UTools.g.getRect();
                rect.set(hVar.a.left, hVar.a.top, displayMetrics.widthPixels - hVar.a.right, displayMetrics.heightPixels - hVar.a.bottom);
                UTools.addAnimation(rect, (View) this);
                childAt.measure(MeasureSpec.makeMeasureSpec(rect.width(), 1073741824), MeasureSpec.makeMeasureSpec(rect.height(), 1073741824));
                UTools.g.getRect(rect);
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
        setMeasuredDimension(resolveSize(i5, i), resolveSize(i4, i2));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            h hVar = (h) this.a.get(childAt);
            if (hVar != null) {
                DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
                Rect rect = (Rect) UTools.g.getRect();
                rect.set(hVar.a.left, hVar.a.top, displayMetrics.widthPixels - hVar.a.right, displayMetrics.heightPixels - hVar.a.bottom);
                UTools.addAnimation(rect, (View) this);
                childAt.layout(rect.left, rect.top, rect.right, rect.bottom);
                UTools.g.getRect(rect);
            } else if (childAt.getVisibility() != 8) {
                childAt.layout(0, 0, childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
            }
        }
    }
}
