package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

import com.duokan.core.ui.dv;
import com.duokan.reader.ui.general.el;
import com.duokan.reader.ui.reading.FixedPageClipView.ClipIndicator;

class iy extends FrameLayout {
    final /* synthetic */ FixedPageClipView a;
    private boolean b = false;
    private final Paint c;
    private final el d;
    private final RectF e = new RectF();
    private final jb f;
    private final int g = dv.b(getContext(), 150.0f);
    private final int h = dv.b(getContext(), 180.0f);

    public iy(FixedPageClipView fixedPageClipView, Context context, sh shVar) {
        this.a = fixedPageClipView;
        super(context);
        setWillNotDraw(false);
        setBackgroundColor(getResources().getColor(c.general__shared__f8f8f8));
        this.f = new jb(fixedPageClipView, context);
        addView(this.f, new LayoutParams(-1, -1));
        this.c = new Paint();
        this.c.setColor(-16777216);
        this.c.setAlpha(70);
        this.d = new el();
        this.d.a(2.0f);
        this.d.a(-65536);
        getViewTreeObserver().addOnPreDrawListener(new iz(this, fixedPageClipView));
    }

    public RectF a() {
        float width = (float) ((getWidth() - getPaddingLeft()) - getPaddingRight());
        float height = (float) ((getHeight() - getPaddingTop()) - getPaddingBottom());
        return new RectF(this.e.left / width, this.e.top / height, this.e.right / width, this.e.bottom / height);
    }

    public ClipIndicator a(PointF pointF) {
        RectF c = c();
        int b = dv.b(getContext(), 20.0f);
        if (new RectF(c.left - ((float) b), c.top - ((float) b), c.left + ((float) b), c.top + ((float) b)).contains(pointF.x, pointF.y)) {
            return ClipIndicator.LEFT_TOP;
        }
        if (new RectF(c.left - ((float) b), (c.top + (c.height() / 2.0f)) - ((float) b), c.left + ((float) b), (c.top + (c.height() / 2.0f)) + ((float) b)).contains(pointF.x, pointF.y)) {
            return ClipIndicator.LEFT_CENTER;
        }
        if (new RectF(c.left - ((float) b), (c.top + c.height()) - ((float) b), c.left + ((float) b), (c.top + c.height()) + ((float) b)).contains(pointF.x, pointF.y)) {
            return ClipIndicator.LEFT_BOTTOM;
        }
        if (new RectF(c.right - ((float) b), c.top - ((float) b), c.right + ((float) b), c.top + ((float) b)).contains(pointF.x, pointF.y)) {
            return ClipIndicator.RIGHT_TOP;
        }
        if (new RectF(c.right - ((float) b), (c.top + (c.height() / 2.0f)) - ((float) b), c.right + ((float) b), (c.top + (c.height() / 2.0f)) + ((float) b)).contains(pointF.x, pointF.y)) {
            return ClipIndicator.RIGHT_CENTER;
        }
        if (new RectF(c.right - ((float) b), (c.top + c.height()) - ((float) b), c.right + ((float) b), (c.top + c.height()) + ((float) b)).contains(pointF.x, pointF.y)) {
            return ClipIndicator.RIGHT_BOTTOM;
        }
        if (new RectF((c.left + (c.width() / 2.0f)) - ((float) b), c.top - ((float) b), (c.left + (c.width() / 2.0f)) + ((float) b), c.top + ((float) b)).contains(pointF.x, pointF.y)) {
            return ClipIndicator.CENTER_TOP;
        }
        if (new RectF((c.left + (c.width() / 2.0f)) - ((float) b), (c.top + c.height()) - ((float) b), (c.left + (c.width() / 2.0f)) + ((float) b), ((float) b) + (c.top + c.height())).contains(pointF.x, pointF.y)) {
            return ClipIndicator.CENTER_BOTTOM;
        }
        if (new RectF((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom())).contains(c)) {
            return ClipIndicator.CENTER_CENTER;
        }
        return ClipIndicator.UNKNOW;
    }

    public void a(ClipIndicator clipIndicator, PointF pointF, int i) {
        RectF c = c();
        Point point = new Point((int) pointF.x, (int) pointF.y);
        switch (ix.a[clipIndicator.ordinal()]) {
            case 1:
                c.left = Math.max((float) getPaddingLeft(), c.left + ((float) point.x));
                if (c.width() < ((float) this.g)) {
                    c.left = c.right - ((float) this.g);
                }
                c.top = Math.max((float) getPaddingTop(), ((float) point.y) + c.top);
                if (c.height() < ((float) this.h)) {
                    c.top = c.bottom - ((float) this.h);
                    break;
                }
                break;
            case 2:
                c.left = Math.max((float) getPaddingLeft(), ((float) point.x) + c.left);
                if (c.width() < ((float) this.g)) {
                    c.left = c.right - ((float) this.g);
                    break;
                }
                break;
            case 3:
                c.left = Math.max((float) getPaddingLeft(), c.left + ((float) point.x));
                if (c.width() < ((float) this.g)) {
                    c.left = c.right - ((float) this.g);
                }
                c.bottom = Math.min((float) (getHeight() - getPaddingBottom()), ((float) point.y) + c.bottom);
                if (c.height() < ((float) this.h)) {
                    c.bottom = c.top + ((float) this.h);
                    break;
                }
                break;
            case 4:
                c.right = Math.min((float) (getWidth() - getPaddingRight()), c.right + ((float) point.x));
                if (c.width() < ((float) this.g)) {
                    c.right = c.left + ((float) this.g);
                }
                c.top = Math.max((float) getPaddingTop(), ((float) point.y) + c.top);
                if (c.height() < ((float) this.h)) {
                    c.top = c.bottom - ((float) this.h);
                    break;
                }
                break;
            case 5:
                c.right = Math.min((float) (getWidth() - getPaddingRight()), ((float) point.x) + c.right);
                if (c.width() < ((float) this.g)) {
                    c.right = c.left + ((float) this.g);
                    break;
                }
                break;
            case 6:
                c.right = Math.min((float) (getWidth() - getPaddingRight()), c.right + ((float) point.x));
                if (c.width() < ((float) this.g)) {
                    c.right = c.left + ((float) this.g);
                }
                c.bottom = Math.min((float) (getHeight() - getPaddingBottom()), ((float) point.y) + c.bottom);
                if (c.height() < ((float) this.h)) {
                    c.bottom = c.top + ((float) this.h);
                    break;
                }
                break;
            case 7:
                c.top = Math.max((float) getPaddingTop(), ((float) point.y) + c.top);
                if (c.height() < ((float) this.h)) {
                    c.top = c.bottom - ((float) this.h);
                    break;
                }
                break;
            case 8:
                c.bottom = Math.min((float) (getHeight() - getPaddingBottom()), ((float) point.y) + c.bottom);
                if (c.height() < ((float) this.h)) {
                    c.bottom = c.top + ((float) this.h);
                    break;
                }
                break;
            case 9:
                float paddingLeft;
                float paddingTop;
                c.offset((float) point.x, (float) point.y);
                if (c.left < ((float) getPaddingLeft())) {
                    paddingLeft = ((float) getPaddingLeft()) - c.left;
                } else {
                    paddingLeft = 0.0f;
                }
                if (c.top < ((float) getPaddingTop())) {
                    paddingTop = ((float) getPaddingTop()) - c.top;
                } else {
                    paddingTop = 0.0f;
                }
                if (c.right > ((float) (getWidth() - getPaddingRight()))) {
                    paddingLeft = ((float) (getWidth() - getPaddingRight())) - c.right;
                }
                if (c.bottom > ((float) (getHeight() - getPaddingBottom()))) {
                    paddingTop = ((float) (getHeight() - getPaddingBottom())) - c.bottom;
                }
                if (!(paddingLeft == 0.0f && paddingTop == 0.0f)) {
                    c.offset(paddingLeft, paddingTop);
                    break;
                }
        }
        this.e.set(c.left - ((float) getPaddingLeft()), c.top - ((float) getPaddingTop()), ((float) (getWidth() - getPaddingRight())) - c.right, ((float) (getHeight() - getPaddingBottom())) - c.bottom);
        invalidate();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (!this.b) {
            b();
            this.b = true;
        }
        RectF c = c();
        Rect rect = new Rect((int) c.left, (int) c.top, (int) c.right, (int) c.bottom);
        this.d.a(canvas, new Rect(rect.left, 0, rect.right, getHeight()), 3);
        this.d.a(canvas, new Rect(0, rect.top, getWidth(), rect.bottom), 48);
        this.d.a(canvas, new Rect(rect.left, 0, rect.right, getHeight()), 5);
        this.d.a(canvas, new Rect(0, rect.top, getWidth(), rect.bottom), 80);
        canvas.drawRect(new Rect(0, 0, getWidth(), rect.top), this.c);
        canvas.drawRect(new Rect(0, rect.bottom, getWidth(), getHeight()), this.c);
        canvas.drawRect(new Rect(0, rect.top, rect.left, rect.bottom), this.c);
        canvas.drawRect(new Rect(rect.right, rect.top, getWidth(), rect.bottom), this.c);
        rect.left -= this.a.f.getIntrinsicWidth() / 2;
        rect.right += this.a.f.getIntrinsicWidth() / 2;
        rect.top -= this.a.f.getIntrinsicHeight() / 2;
        rect.bottom += this.a.f.getIntrinsicHeight() / 2;
        dv.a(canvas, this.a.f, rect, 51);
        dv.a(canvas, this.a.f, rect, 83);
        dv.a(canvas, this.a.f, rect, 19);
        dv.a(canvas, this.a.f, rect, 53);
        dv.a(canvas, this.a.f, rect, 85);
        dv.a(canvas, this.a.f, rect, 21);
        dv.a(canvas, this.a.f, rect, 49);
        dv.a(canvas, this.a.f, rect, 81);
    }

    private void b() {
        RectF a = this.f.b();
        this.e.set(a.left, a.top, a.right, a.bottom);
        this.a.b();
    }

    private RectF c() {
        return new RectF(((float) getPaddingLeft()) + this.e.left, ((float) getPaddingTop()) + this.e.top, ((float) (getWidth() - getPaddingRight())) - this.e.right, ((float) (getHeight() - getPaddingBottom())) - this.e.bottom);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    private void d() {
        int b = dv.b(getContext(), 20.0f);
        int width = getWidth();
        int height = getHeight();
        Drawable a = this.f.a();
        if (a == null || a.getIntrinsicWidth() == 0 || a.getIntrinsicHeight() == 0) {
            width = b;
        } else if (this.a.e.am()) {
            width = (width - Math.round(((((float) (height - (b * 2))) * 1.0f) * ((float) a.getIntrinsicWidth())) / ((float) a.getIntrinsicHeight()))) / 2;
        } else {
            int round = (height - Math.round(((((float) (width - (b * 2))) * 1.0f) * ((float) a.getIntrinsicHeight())) / ((float) a.getIntrinsicWidth()))) / 2;
            width = b;
            b = round;
        }
        setPadding(width, b, width, b);
    }
}
