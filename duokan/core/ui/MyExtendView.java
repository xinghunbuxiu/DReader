package com.duokan.core.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.util.AttributeSet;

public class MyExtendView extends ExtendView {
    private int a;
    private Drawable drawable1;
    private Drawable drawable;
    private int d;
    private int e;
    private int f;

    public MyExtendView(Context context) {
        this(context, null);
    }

    public MyExtendView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 80;
        this.drawable1 = null;
        this.drawable = null;
        this.d = 0;
        this.e = 0;
        this.f = 0;
    }

    public final int getGravity() {
        return this.a;
    }

    public final void setGravity(int i) {
        if (this.a != i) {
            this.a = i;
            setBackground();
        }
    }

    public final Drawable getIndicator() {
        return this.drawable;
    }

    public final void setIndicator(int i) {
        setIndicator(getResources().getDrawable(i));
    }

    public final void setIndicator(Drawable drawable) {
        if (this.drawable != drawable) {
            this.drawable = drawable;
            setBackground();
        }
    }

    public final Point getIndicatorPosition() {
        Point point = new Point();
        Rect rect = (Rect) UTools.g.getRect();
        a(rect);
        switch (this.a) {
            case 3:
                point.x = rect.left;
                point.y = rect.centerY();
                break;
            case 5:
                point.x = rect.right;
                point.y = rect.centerY();
                break;
            case 48:
                point.x = rect.centerX();
                point.y = rect.top;
                break;
            case 80:
                point.x = rect.centerX();
                point.y = rect.bottom;
                break;
        }
        UTools.g.getRect(rect);
        return point;
    }

    public final int getIndicatorInset() {
        return this.d;
    }

    public final void setIndicatorInset(int i) {
        if (this.d != i) {
            this.d = i;
            setBackground();
        }
    }

    public final int getIndicatorMargin() {
        return this.f;
    }

    public final void setIndicatorMargin(int i) {
        if (this.f != i) {
            this.f = i;
            invalidate();
        }
    }

    public final void a(int i) {
        this.e += i;
    }

    public Drawable getBackground() {
        return this.drawable1;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (this.drawable1 != drawable) {
            this.drawable1 = drawable;
            setBackground();
        }
    }

    private final void setBackground() {
        if (this.drawable1 == null) {
            super.setBackgroundDrawable(null);
            return;
        }
        Rect rect = (Rect) UTools.g.getRect();
        switch (this.a) {
            case 3:
                rect.left = Math.max(getDrawableHeight() - this.d, 0);
                break;
            case 5:
                rect.right = Math.max(getDrawableHeight() - this.d, 0);
                break;
            case 48:
                rect.top = Math.max(h() - this.d, 0);
                break;
            case 80:
                rect.bottom = Math.max(h() - this.d, 0);
                break;
        }
        super.setBackgroundDrawable(new b(this, this.drawable1, rect.left, rect.top, rect.right, rect.bottom));
        UTools.g.getRect(rect);
    }

    class b extends InsetDrawable {
        final MyExtendView a;

        public b(MyExtendView aVar, Drawable drawable, int i, int i2, int i3, int i4) {
            super(drawable, i, i2, i3, i4);
            this.a = aVar;

        }

        public void draw(Canvas canvas) {
            super.draw(canvas);
            if (drawable!= null) {
                Rect rect = (Rect) UTools.g.getRect();
                this.a.a(rect);
                if (!rect.isEmpty()) {
                    canvas.save();
                    canvas.translate(rect.exactCenterX(), rect.exactCenterY());
                    canvas.rotate((float) this.a.b());
                    canvas.translate(-rect.exactCenterX(), -rect.exactCenterY());
                    drawable.setFilterBitmap(true);
                    drawable.setBounds(rect);
                    drawable.draw(canvas);
                    canvas.restore();
                }
                UTools.g.getRect(rect);
            }
        }
    }

    private final void a(Rect rect) {
        rect.setEmpty();
        if (this.drawable != null) {
            switch (this.a) {
                case 3:
                    rect.set(0, 0, getDrawableHeight(), getDrawableWidth());
                    rect.offset(-this.d, c());
                    return;
                case 5:
                    rect.set(0, 0, getDrawableHeight(), getDrawableWidth());
                    rect.offset((getWidth() - rect.width()) - this.d, c());
                    return;
                case 48:
                    rect.set(0, 0, g(), h());
                    rect.offset(f(), -this.d);
                    return;
                case 80:
                    rect.set(0, 0, g(), h());
                    rect.offset(f(), (getHeight() - rect.height()) - this.d);
                    return;
                default:
                    return;
            }
        }
    }

    private final int b() {
        switch (this.a) {
            case 3:
                return 90;
            case 5:
                return -90;
            case 48:
                return 180;
            default:
                return 0;
        }
    }

    private final int c() {
        return Math.min(this.f + this.e, (getHeight() - getDrawableWidth()) - this.f);
    }

    private final int getDrawableHeight() {
        return this.drawable == null ? 0 : this.drawable.getIntrinsicHeight();
    }

    private final int getDrawableWidth() {
        return this.drawable == null ? 0 : this.drawable.getIntrinsicWidth();
    }

    private final int f() {
        return Math.min(this.f + this.e, (getWidth() - g()) - this.f);
    }

    private final int g() {
        return this.drawable == null ? 0 : this.drawable.getIntrinsicWidth();
    }

    private final int h() {
        return this.drawable == null ? 0 : this.drawable.getIntrinsicHeight();
    }
}
