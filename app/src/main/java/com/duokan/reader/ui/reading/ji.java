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
import com.duokan.p023b.C0241c;
import com.duokan.reader.ui.general.ej;
import com.duokan.reader.ui.reading.FixedPageClipView.ClipIndicator;

class ji extends FrameLayout {
    /* renamed from: a */
    final /* synthetic */ FixedPageClipView f10429a;
    /* renamed from: b */
    private boolean f10430b = false;
    /* renamed from: c */
    private final Paint f10431c;
    /* renamed from: d */
    private final ej f10432d;
    /* renamed from: e */
    private final RectF f10433e = new RectF();
    /* renamed from: f */
    private final jl f10434f;
    /* renamed from: g */
    private final int f10435g = dv.m1932b(getContext(), 150.0f);
    /* renamed from: h */
    private final int f10436h = dv.m1932b(getContext(), 180.0f);

    public ji(FixedPageClipView fixedPageClipView, Context context, su suVar) {
        this.f10429a = fixedPageClipView;
        super(context);
        setWillNotDraw(false);
        setBackgroundColor(getResources().getColor(C0241c.general__shared__f8f8f8));
        this.f10434f = new jl(fixedPageClipView, context);
        addView(this.f10434f, new LayoutParams(-1, -1));
        this.f10431c = new Paint();
        this.f10431c.setColor(-16777216);
        this.f10431c.setAlpha(70);
        this.f10432d = new ej();
        this.f10432d.m10559a(2.0f);
        this.f10432d.m10560a(-65536);
        getViewTreeObserver().addOnPreDrawListener(new jj(this, fixedPageClipView));
    }

    /* renamed from: a */
    public RectF m14476a() {
        float width = (float) ((getWidth() - getPaddingLeft()) - getPaddingRight());
        float height = (float) ((getHeight() - getPaddingTop()) - getPaddingBottom());
        return new RectF(this.f10433e.left / width, this.f10433e.top / height, this.f10433e.right / width, this.f10433e.bottom / height);
    }

    /* renamed from: a */
    public ClipIndicator m14477a(PointF pointF) {
        RectF c = m14474c();
        int b = dv.m1932b(getContext(), 20.0f);
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

    /* renamed from: a */
    public void m14478a(ClipIndicator clipIndicator, PointF pointF, int i) {
        RectF c = m14474c();
        Point point = new Point((int) pointF.x, (int) pointF.y);
        switch (jh.f10428a[clipIndicator.ordinal()]) {
            case 1:
                c.left = Math.max((float) getPaddingLeft(), c.left + ((float) point.x));
                if (c.width() < ((float) this.f10435g)) {
                    c.left = c.right - ((float) this.f10435g);
                }
                c.top = Math.max((float) getPaddingTop(), ((float) point.y) + c.top);
                if (c.height() < ((float) this.f10436h)) {
                    c.top = c.bottom - ((float) this.f10436h);
                    break;
                }
                break;
            case 2:
                c.left = Math.max((float) getPaddingLeft(), ((float) point.x) + c.left);
                if (c.width() < ((float) this.f10435g)) {
                    c.left = c.right - ((float) this.f10435g);
                    break;
                }
                break;
            case 3:
                c.left = Math.max((float) getPaddingLeft(), c.left + ((float) point.x));
                if (c.width() < ((float) this.f10435g)) {
                    c.left = c.right - ((float) this.f10435g);
                }
                c.bottom = Math.min((float) (getHeight() - getPaddingBottom()), ((float) point.y) + c.bottom);
                if (c.height() < ((float) this.f10436h)) {
                    c.bottom = c.top + ((float) this.f10436h);
                    break;
                }
                break;
            case 4:
                c.right = Math.min((float) (getWidth() - getPaddingRight()), c.right + ((float) point.x));
                if (c.width() < ((float) this.f10435g)) {
                    c.right = c.left + ((float) this.f10435g);
                }
                c.top = Math.max((float) getPaddingTop(), ((float) point.y) + c.top);
                if (c.height() < ((float) this.f10436h)) {
                    c.top = c.bottom - ((float) this.f10436h);
                    break;
                }
                break;
            case 5:
                c.right = Math.min((float) (getWidth() - getPaddingRight()), ((float) point.x) + c.right);
                if (c.width() < ((float) this.f10435g)) {
                    c.right = c.left + ((float) this.f10435g);
                    break;
                }
                break;
            case 6:
                c.right = Math.min((float) (getWidth() - getPaddingRight()), c.right + ((float) point.x));
                if (c.width() < ((float) this.f10435g)) {
                    c.right = c.left + ((float) this.f10435g);
                }
                c.bottom = Math.min((float) (getHeight() - getPaddingBottom()), ((float) point.y) + c.bottom);
                if (c.height() < ((float) this.f10436h)) {
                    c.bottom = c.top + ((float) this.f10436h);
                    break;
                }
                break;
            case 7:
                c.top = Math.max((float) getPaddingTop(), ((float) point.y) + c.top);
                if (c.height() < ((float) this.f10436h)) {
                    c.top = c.bottom - ((float) this.f10436h);
                    break;
                }
                break;
            case 8:
                c.bottom = Math.min((float) (getHeight() - getPaddingBottom()), ((float) point.y) + c.bottom);
                if (c.height() < ((float) this.f10436h)) {
                    c.bottom = c.top + ((float) this.f10436h);
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
        this.f10433e.set(c.left - ((float) getPaddingLeft()), c.top - ((float) getPaddingTop()), ((float) (getWidth() - getPaddingRight())) - c.right, ((float) (getHeight() - getPaddingBottom())) - c.bottom);
        invalidate();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (!this.f10430b) {
            m14472b();
            this.f10430b = true;
        }
        RectF c = m14474c();
        Rect rect = new Rect((int) c.left, (int) c.top, (int) c.right, (int) c.bottom);
        this.f10432d.m10561a(canvas, new Rect(rect.left, 0, rect.right, getHeight()), 3);
        this.f10432d.m10561a(canvas, new Rect(0, rect.top, getWidth(), rect.bottom), 48);
        this.f10432d.m10561a(canvas, new Rect(rect.left, 0, rect.right, getHeight()), 5);
        this.f10432d.m10561a(canvas, new Rect(0, rect.top, getWidth(), rect.bottom), 80);
        canvas.drawRect(new Rect(0, 0, getWidth(), rect.top), this.f10431c);
        canvas.drawRect(new Rect(0, rect.bottom, getWidth(), getHeight()), this.f10431c);
        canvas.drawRect(new Rect(0, rect.top, rect.left, rect.bottom), this.f10431c);
        canvas.drawRect(new Rect(rect.right, rect.top, getWidth(), rect.bottom), this.f10431c);
        rect.left -= this.f10429a.f9093f.getIntrinsicWidth() / 2;
        rect.right += this.f10429a.f9093f.getIntrinsicWidth() / 2;
        rect.top -= this.f10429a.f9093f.getIntrinsicHeight() / 2;
        rect.bottom += this.f10429a.f9093f.getIntrinsicHeight() / 2;
        dv.m1911a(canvas, this.f10429a.f9093f, rect, 51);
        dv.m1911a(canvas, this.f10429a.f9093f, rect, 83);
        dv.m1911a(canvas, this.f10429a.f9093f, rect, 19);
        dv.m1911a(canvas, this.f10429a.f9093f, rect, 53);
        dv.m1911a(canvas, this.f10429a.f9093f, rect, 85);
        dv.m1911a(canvas, this.f10429a.f9093f, rect, 21);
        dv.m1911a(canvas, this.f10429a.f9093f, rect, 49);
        dv.m1911a(canvas, this.f10429a.f9093f, rect, 81);
    }

    /* renamed from: b */
    private void m14472b() {
        RectF a = this.f10434f.m14480b();
        this.f10433e.set(a.left, a.top, a.right, a.bottom);
        this.f10429a.m12411b();
    }

    /* renamed from: c */
    private RectF m14474c() {
        return new RectF(((float) getPaddingLeft()) + this.f10433e.left, ((float) getPaddingTop()) + this.f10433e.top, ((float) (getWidth() - getPaddingRight())) - this.f10433e.right, ((float) (getHeight() - getPaddingBottom())) - this.f10433e.bottom);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    /* renamed from: d */
    private void m14475d() {
        int b = dv.m1932b(getContext(), 20.0f);
        int width = getWidth();
        int height = getHeight();
        Drawable a = this.f10434f.m14481a();
        if (a == null || a.getIntrinsicWidth() == 0 || a.getIntrinsicHeight() == 0) {
            width = b;
        } else if (this.f10429a.f9092e.am()) {
            width = (width - Math.round(((((float) (height - (b * 2))) * 1.0f) * ((float) a.getIntrinsicWidth())) / ((float) a.getIntrinsicHeight()))) / 2;
        } else {
            int round = (height - Math.round(((((float) (width - (b * 2))) * 1.0f) * ((float) a.getIntrinsicHeight())) / ((float) a.getIntrinsicWidth()))) / 2;
            width = b;
            b = round;
        }
        setPadding(width, b, width, b);
    }
}
