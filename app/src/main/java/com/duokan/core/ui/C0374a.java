package com.duokan.core.ui;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.umeng.analytics.pro.C2295j;

/* renamed from: com.duokan.core.ui.a */
public class C0374a extends ExtendView {
    /* renamed from: a */
    private int f886a;
    /* renamed from: b */
    private Drawable f887b;
    /* renamed from: c */
    private Drawable f888c;
    /* renamed from: d */
    private int f889d;
    /* renamed from: e */
    private int f890e;
    /* renamed from: f */
    private int f891f;

    public C0374a(Context context) {
        this(context, null);
    }

    public C0374a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f886a = 80;
        this.f887b = null;
        this.f888c = null;
        this.f889d = 0;
        this.f890e = 0;
        this.f891f = 0;
    }

    public final int getGravity() {
        return this.f886a;
    }

    public final void setGravity(int i) {
        if (this.f886a != i) {
            this.f886a = i;
            m1364a();
        }
    }

    public final Drawable getIndicator() {
        return this.f888c;
    }

    public final void setIndicator(int i) {
        setIndicator(getResources().getDrawable(i));
    }

    public final void setIndicator(Drawable drawable) {
        if (this.f888c != drawable) {
            this.f888c = drawable;
            m1364a();
        }
    }

    public final Point getIndicatorPosition() {
        Point point = new Point();
        Rect rect = (Rect) dv.f1198g.addAnimation();
        m1365a(rect);
        switch (this.f886a) {
            case 3:
                point.x = rect.left;
                point.y = rect.centerY();
                break;
            case 5:
                point.x = rect.right;
                point.y = rect.centerY();
                break;
            case C2295j.f14321a /*48*/:
                point.x = rect.centerX();
                point.y = rect.top;
                break;
            case 80:
                point.x = rect.centerX();
                point.y = rect.bottom;
                break;
        }
        dv.f1198g.clearAnimation(rect);
        return point;
    }

    public final int getIndicatorInset() {
        return this.f889d;
    }

    public final void setIndicatorInset(int i) {
        if (this.f889d != i) {
            this.f889d = i;
            m1364a();
        }
    }

    public final int getIndicatorMargin() {
        return this.f891f;
    }

    public final void setIndicatorMargin(int i) {
        if (this.f891f != i) {
            this.f891f = i;
            invalidate();
        }
    }

    /* renamed from: a */
    public final void m1375a(int i) {
        this.f890e += i;
    }

    public Drawable getBackground() {
        return this.f887b;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (this.f887b != drawable) {
            this.f887b = drawable;
            m1364a();
        }
    }

    /* renamed from: a */
    private final void m1364a() {
        if (this.f887b == null) {
            super.setBackgroundDrawable(null);
            return;
        }
        Rect rect = (Rect) dv.f1198g.addAnimation();
        switch (this.f886a) {
            case 3:
                rect.left = Math.max(m1370d() - this.f889d, 0);
                break;
            case 5:
                rect.right = Math.max(m1370d() - this.f889d, 0);
                break;
            case C2295j.f14321a /*48*/:
                rect.top = Math.max(m1374h() - this.f889d, 0);
                break;
            case 80:
                rect.bottom = Math.max(m1374h() - this.f889d, 0);
                break;
        }
        super.setBackgroundDrawable(new C0378b(this, this.f887b, rect.left, rect.top, rect.right, rect.bottom));
        dv.f1198g.clearAnimation(rect);
    }

    /* renamed from: a */
    private final void m1365a(Rect rect) {
        rect.setEmpty();
        if (this.f888c != null) {
            switch (this.f886a) {
                case 3:
                    rect.set(0, 0, m1370d(), m1371e());
                    rect.offset(-this.f889d, m1369c());
                    return;
                case 5:
                    rect.set(0, 0, m1370d(), m1371e());
                    rect.offset((getWidth() - rect.width()) - this.f889d, m1369c());
                    return;
                case C2295j.f14321a /*48*/:
                    rect.set(0, 0, m1373g(), m1374h());
                    rect.offset(m1372f(), -this.f889d);
                    return;
                case 80:
                    rect.set(0, 0, m1373g(), m1374h());
                    rect.offset(m1372f(), (getHeight() - rect.height()) - this.f889d);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: b */
    private final int m1367b() {
        switch (this.f886a) {
            case 3:
                return 90;
            case 5:
                return -90;
            case C2295j.f14321a /*48*/:
                return 180;
            default:
                return 0;
        }
    }

    /* renamed from: c */
    private final int m1369c() {
        return Math.min(this.f891f + this.f890e, (getHeight() - m1371e()) - this.f891f);
    }

    /* renamed from: d */
    private final int m1370d() {
        return this.f888c == null ? 0 : this.f888c.getIntrinsicHeight();
    }

    /* renamed from: e */
    private final int m1371e() {
        return this.f888c == null ? 0 : this.f888c.getIntrinsicWidth();
    }

    /* renamed from: f */
    private final int m1372f() {
        return Math.min(this.f891f + this.f890e, (getWidth() - m1373g()) - this.f891f);
    }

    /* renamed from: g */
    private final int m1373g() {
        return this.f888c == null ? 0 : this.f888c.getIntrinsicWidth();
    }

    /* renamed from: h */
    private final int m1374h() {
        return this.f888c == null ? 0 : this.f888c.getIntrinsicHeight();
    }
}
