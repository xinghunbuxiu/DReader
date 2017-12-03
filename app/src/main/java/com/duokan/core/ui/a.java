package com.duokan.core.ui;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

public class a extends ExtendView {
    private int a;
    private Drawable b;
    private Drawable c;
    private int d;
    private int e;
    private int f;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 80;
        this.b = null;
        this.c = null;
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
            a();
        }
    }

    public final Drawable getIndicator() {
        return this.c;
    }

    public final void setIndicator(int i) {
        setIndicator(getResources().getDrawable(i));
    }

    public final void setIndicator(Drawable drawable) {
        if (this.c != drawable) {
            this.c = drawable;
            a();
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
            case j.a /*48*/:
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
            a();
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
        return this.b;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (this.b != drawable) {
            this.b = drawable;
            a();
        }
    }

    private final void a() {
        if (this.b == null) {
            super.setBackgroundDrawable(null);
            return;
        }
        Rect rect = (Rect) UTools.g.getRect();
        switch (this.a) {
            case 3:
                rect.left = Math.max(d() - this.d, 0);
                break;
            case 5:
                rect.right = Math.max(d() - this.d, 0);
                break;
            case j.a /*48*/:
                rect.top = Math.max(h() - this.d, 0);
                break;
            case 80:
                rect.bottom = Math.max(h() - this.d, 0);
                break;
        }
        super.setBackgroundDrawable(new b(this, this.b, rect.left, rect.top, rect.right, rect.bottom));
        UTools.g.getRect(rect);
    }

    private final void a(Rect rect) {
        rect.setEmpty();
        if (this.c != null) {
            switch (this.a) {
                case 3:
                    rect.set(0, 0, d(), e());
                    rect.offset(-this.d, c());
                    return;
                case 5:
                    rect.set(0, 0, d(), e());
                    rect.offset((getWidth() - rect.width()) - this.d, c());
                    return;
                case j.a /*48*/:
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
            case j.a /*48*/:
                return 180;
            default:
                return 0;
        }
    }

    private final int c() {
        return Math.min(this.f + this.e, (getHeight() - e()) - this.f);
    }

    private final int d() {
        return this.c == null ? 0 : this.c.getIntrinsicHeight();
    }

    private final int e() {
        return this.c == null ? 0 : this.c.getIntrinsicWidth();
    }

    private final int f() {
        return Math.min(this.f + this.e, (getWidth() - g()) - this.f);
    }

    private final int g() {
        return this.c == null ? 0 : this.c.getIntrinsicWidth();
    }

    private final int h() {
        return this.c == null ? 0 : this.c.getIntrinsicHeight();
    }
}
