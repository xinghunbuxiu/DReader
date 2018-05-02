package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;

import com.duokan.kernel.txtlib.DktRenderTextInfo;
import com.duokan.reader.ui.general.deprecatedDkTextView.TruncateMode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class km extends ku {
    final /* synthetic */ deprecatedDkTextView a;
    private int c;
    private int d;
    private kn[][] e;
    private int f;
    private int g;
    private final ArrayList h;
    private final ArrayList i;
    private final Rect j;
    private int k;
    private int l;
    private final Rect m;
    private final RectF n;
    private final PointF o;
    private final ArrayList p;
    private final PointF q;
    private final RectF r;
    private final char[] s;
    private final Rect t;
    private final Rect u;

    private km(deprecatedDkTextView com_duokan_reader_ui_general_deprecatedDkTextView) {
        this.a = com_duokan_reader_ui_general_deprecatedDkTextView;
        super(com_duokan_reader_ui_general_deprecatedDkTextView);
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.j = new Rect();
        this.k = -1;
        this.l = -1;
        this.m = new Rect();
        this.n = new RectF();
        this.o = new PointF();
        this.p = new ArrayList();
        this.q = new PointF();
        this.r = new RectF();
        this.s = new char[1];
        this.t = new Rect();
        this.u = new Rect();
    }

    public void a() {
        int i;
        int i2;
        int i3;
        Rect a = this.a.o;
        Rect b = this.a.A;
        DktRenderTextInfo c = this.a.q;
        RectF rectF = this.n;
        Rect rect = this.m;
        PointF pointF = this.o;
        this.c = kq.g().b();
        if (a.height() > this.c * 6) {
            this.c += this.c;
        }
        this.d = kq.g().a();
        this.f = a.height() / this.c;
        if (this.f * this.c != a.height()) {
            this.f++;
        }
        this.g = a.width() / this.d;
        if (this.g * this.d != a.width()) {
            this.g++;
        }
        this.e = (kn[][]) Array.newInstance(kn.class, new int[]{this.f, this.g});
        kn[][] knVarArr = this.e;
        int i4 = a.top;
        for (i = 0; i < this.f; i++) {
            i2 = a.left;
            for (i3 = 0; i3 < this.g; i3++) {
                km kmVar = this;
                kn knVar = new kn();
                knVar.a.top = i4;
                knVar.a.left = i2;
                knVar.a.bottom = this.c + i4;
                knVar.a.right = this.d + i2;
                knVarArr[i][i3] = knVar;
                i2 += this.d;
            }
            i4 += this.c;
        }
        i3 = this.a.getPaddingLeft();
        i2 = this.a.getPaddingTop();
        if (this.a.z && this.a.y == TruncateMode.END_WITH_SPACING) {
            int length = c.mChars.length();
            i = 0;
            for (i4 = 0; i4 < length; i4++) {
                int i5 = i4 << 1;
                rect.left = (int) Math.floor((double) c.mCharTopLefts[i5]);
                rect.top = (int) Math.floor((double) c.mCharTopLefts[i5 + 1]);
                rect.right = (int) Math.ceil((double) c.mCharBottomRights[i5]);
                rect.bottom = (int) Math.ceil((double) c.mCharBottomRights[i5 + 1]);
                rect.offset(i3, i2);
                if (!rect.intersects(a.left, a.top, a.right, a.bottom)) {
                    i++;
                } else if (rect.intersect(b)) {
                    break;
                } else {
                    a(a, rect, i4);
                    i++;
                }
            }
            if (i < c.mChars.length()) {
                i <<= 1;
                pointF.x = c.mCharXYs[i];
                pointF.y = c.mCharXYs[i + 1];
                pointF.offset((float) i3, (float) i2);
                rectF.left = c.mCharTopLefts[i];
                rectF.top = c.mCharTopLefts[i + 1];
                rectF.right = c.mCharBottomRights[i];
                rectF.bottom = c.mCharBottomRights[i + 1];
                rectF.offset((float) i3, (float) i2);
                rect.top = (int) Math.floor((double) rectF.top);
                rect.left = (int) Math.floor((double) rectF.left);
                rect.bottom = (int) Math.ceil((double) rectF.bottom);
                rect.right = (int) Math.ceil((double) rectF.right);
                a(a, rect, new kp(this, "...".toCharArray(), 0, 3, 0, pointF, rectF, rect));
                return;
            }
            return;
        }
        i4 = c.mChars.length();
        for (i = 0; i < i4; i++) {
            int i6 = i << 1;
            rect.left = (int) Math.floor((double) c.mCharTopLefts[i6]);
            rect.top = (int) Math.floor((double) c.mCharTopLefts[i6 + 1]);
            rect.right = (int) Math.ceil((double) c.mCharBottomRights[i6]);
            rect.bottom = (int) Math.ceil((double) c.mCharBottomRights[i6 + 1]);
            rect.offset(i3, i2);
            if (rect.intersects(a.left, a.top, a.right, a.bottom)) {
                a(a, rect, i);
            }
        }
    }

    private void a(Rect rect, Rect rect2, int i) {
        int i2 = this.d;
        int i3 = this.c;
        kn[][] knVarArr = this.e;
        int i4 = (rect2.top - rect.top) / i3;
        int i5 = (rect2.left - rect.left) / i2;
        int i6 = (i3 * i4) + rect.top;
        int i7 = rect.left + (i2 * i5);
        while (i4 < this.f) {
            int i8 = i7;
            int i9 = i5;
            while (i9 < this.g && i6 < rect2.bottom && i8 < rect2.right) {
                kn knVar = knVarArr[i4][i9];
                if (knVar.b == null) {
                    knVar.b = new int[30];
                    knVar.c = 0;
                } else if (knVar.c == knVar.b.length) {
                    Object obj = new int[(knVar.c + (knVar.c >> 1))];
                    System.arraycopy(knVar.b, 0, obj, 0, knVar.c);
                    knVar.b = obj;
                }
                knVar.b[knVar.c] = i;
                knVar.c++;
                i9++;
                i8 += i2;
            }
            i4++;
            i6 += i3;
        }
    }

    private void a(Rect rect, Rect rect2, kp kpVar) {
        int i = this.d;
        int i2 = this.c;
        kn[][] knVarArr = this.e;
        int i3 = (rect2.top - rect.top) / i2;
        int i4 = (rect2.left - rect.left) / i;
        int i5 = (i2 * i3) + rect.top;
        int i6 = rect.left + (i * i4);
        while (i3 < this.f) {
            int i7 = i6;
            int i8 = i4;
            while (i8 < this.g && i5 < rect2.bottom && i7 < rect2.right) {
                knVarArr[i3][i8].d.add(kpVar);
                i8++;
                i7 += i;
            }
            i3++;
            i5 += i2;
        }
    }

    public void b() {
        this.e = (kn[][]) null;
    }

    public void a(Context context, Canvas canvas, Rect rect) {
        int paddingLeft = this.a.getPaddingLeft();
        int paddingTop = this.a.getPaddingTop();
        this.k = -1;
        this.l = -1;
        a(context, rect);
        if (!this.j.isEmpty()) {
            int i;
            int a = kq.g().a();
            int i2 = (this.j.top - this.a.o.top) / this.c;
            int i3 = (this.j.left - this.a.o.left) / a;
            int height = this.j.height() / this.c;
            if (this.c * height != this.j.height()) {
                i = height + 1;
            } else {
                i = height;
            }
            height = this.j.width() / a;
            if (a * height != this.j.width()) {
                a = height + 1;
            } else {
                a = height;
            }
            int i4 = 0;
            int i5 = 0;
            ko koVar = (ko) this.h.get(0);
            while (i5 < i && i2 + i5 < this.f) {
                int i6 = 0;
                ko koVar2 = koVar;
                int i7 = i4;
                while (i6 < a && i3 + i6 < this.g) {
                    kn knVar = this.e[i2 + i5][i3 + i6];
                    if (i6 != 0 || Rect.intersects(koVar2.a, knVar.a)) {
                        i4 = i7;
                        koVar = koVar2;
                    } else {
                        i7++;
                        i4 = i7;
                        koVar = (ko) this.h.get(i7);
                    }
                    if (!koVar.c) {
                        kr krVar;
                        for (int i8 = 0; i8 < koVar.b.size(); i8++) {
                            if (Rect.intersects(((kr) koVar.b.get(i8)).k, knVar.a)) {
                                krVar = (kr) koVar.b.get(i8);
                                break;
                            }
                        }
                        krVar = null;
                        if (krVar != null) {
                            a(knVar, krVar, paddingLeft, paddingTop);
                        }
                    }
                    i6++;
                    koVar2 = koVar;
                    i7 = i4;
                }
                i5++;
                i4 = i7;
                koVar = koVar2;
            }
        }
        this.k = -1;
        this.l = -1;
    }

    private void a(Context context, Rect rect) {
        Iterator it;
        kq.g().d();
        if (rect.top == 0 && rect.bottom == 0) {
            this.j.top = 0;
            this.j.left = 0;
            this.j.bottom = 0;
            this.j.right = 0;
            it = this.h.iterator();
            while (it.hasNext()) {
                kq.g().a(((ko) it.next()).b);
            }
            this.h.clear();
        } else {
            int i = this.a.o.bottom - this.a.o.top;
            int i2 = this.a.getUserVisibleAreaHeight();
            if (i < i2 / 2 || i <= kq.g().b() * 2) {
                this.l = (i / kq.g().b()) * kq.g().b();
                if (this.l < i) {
                    this.l += kq.g().b();
                }
            } else {
                this.l = ((i2 / 2) * kq.g().b()) / kq.g().b();
                if (this.l > kq.g().c()) {
                    this.l = kq.g().c();
                }
            }
            i = (this.l / this.c) * this.c;
            if (this.l != i) {
                this.l = i + this.c;
            }
            this.j.left = rect.left;
            this.j.right = rect.right;
            int i3 = (rect.top - this.a.o.top) / this.l;
            int i4 = ((rect.bottom - 1) - this.a.o.top) / this.l;
            this.j.top = this.a.o.top + (this.l * i3);
            this.j.bottom = this.a.o.top + (this.l * (i4 + 1));
            this.p.clear();
            for (i2 = 0; i2 < this.h.size(); i2++) {
                i = (((ko) this.h.get(i2)).a.top - this.a.o.top) / this.l;
                if (i < i3 || i > i4) {
                    this.p.add(this.h.get(i2));
                }
            }
            it = this.p.iterator();
            while (it.hasNext()) {
                ko koVar = (ko) it.next();
                this.h.remove(koVar);
                kq.g().a(koVar.b);
                koVar.b.clear();
            }
            deprecatedDkTextView.m(this.a);
            if (this.h.size() > 0) {
                i = (((ko) this.h.get(0)).a.top - this.a.o.top) / this.l;
            } else {
                i = -1;
            }
            if (i < 0) {
                i = i3;
            }
            for (i2 = i3; i2 < i; i2++) {
                this.h.add(i2 - i3, a(context, i2));
            }
            if (this.h.size() > 0) {
                i = (((ko) this.h.get(this.h.size() - 1)).a.top - this.a.o.top) / this.l;
            } else {
                i = -1;
            }
            if (i >= 0) {
                i3 = i + 1;
            }
            while (i3 <= i4) {
                this.h.add(a(context, i3));
                i3++;
            }
        }
        kq.g().e();
        this.i.clear();
        it = this.h.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ko) it.next()).b.iterator();
            while (it2.hasNext()) {
                kr krVar = (kr) it2.next();
                if (!this.i.contains(krVar.a)) {
                    this.i.add(krVar.a);
                }
            }
        }
    }

    private ko a(Context context, int i) {
        ko koVar;
        int i2 = this.l;
        int i3 = this.a.o.bottom - this.a.o.top;
        if ((i + 1) * this.l > i3) {
            i3 -= this.l * i;
        } else {
            i3 = i2;
        }
        kq g = kq.g();
        if (this.p.size() != 0) {
            koVar = (ko) this.p.get(0);
            this.p.remove(0);
        } else {
            koVar = new ko();
        }
        koVar.a.top = this.a.o.top + (this.l * i);
        koVar.a.bottom = i3 + koVar.a.top;
        koVar.a.left = this.j.left;
        koVar.a.right = this.j.right;
        g.a(context, koVar.a, this.c, koVar.b);
        koVar.c = false;
        return koVar;
    }

    private void a(kn knVar, kr krVar, int i, int i2) {
        PointF pointF = this.o;
        RectF rectF = this.n;
        Rect rect = this.m;
        DktRenderTextInfo c = this.a.q;
        char[] cArr = this.s;
        PointF pointF2 = this.q;
        RectF rectF2 = this.r;
        Rect rect2 = krVar.k;
        Rect rect3 = krVar.f;
        Rect rect4 = this.t;
        Paint b = deprecatedDkTextView.h;
        Canvas canvas = krVar.g;
        Rect rect5 = krVar.l;
        canvas.save();
        rect4.top = (rect3.top + knVar.a.top) - rect2.top;
        rect4.left = (rect3.left + knVar.a.left) - rect2.left;
        rect4.bottom = rect4.top + knVar.a.height();
        rect4.right = rect4.left + knVar.a.width();
        canvas.clipRect(rect4);
        float f = 2.14748365E9f;
        try {
            int i3;
            int i4;
            int i5 = knVar.c;
            for (int i6 = 0; i6 < i5; i6++) {
                i3 = knVar.b[i6];
                i4 = i3 << 1;
                pointF.x = c.mCharXYs[i4];
                pointF.y = c.mCharXYs[i4 + 1];
                pointF.offset((float) i, (float) i2);
                rectF.left = c.mCharTopLefts[i4];
                rectF.top = c.mCharTopLefts[i4 + 1];
                rectF.right = c.mCharBottomRights[i4];
                rectF.bottom = c.mCharBottomRights[i4 + 1];
                rectF.offset((float) i, (float) i2);
                rect.top = (int) Math.floor((double) rectF.top);
                rect.left = (int) Math.floor((double) rectF.left);
                rect.bottom = (int) Math.ceil((double) rectF.bottom);
                rect.right = (int) Math.ceil((double) rectF.right);
                pointF2.x = pointF.x - ((float) rect2.left);
                pointF2.y = ((float) (krVar.c - rect2.top)) + pointF.y;
                rectF2.left = rectF.left - ((float) rect2.left);
                rectF2.top = ((float) (krVar.c - rect2.top)) + rectF.top;
                rectF2.right = rectF.right - ((float) rect2.left);
                rectF2.bottom = ((float) (krVar.c - rect2.top)) + rectF.bottom;
                if (this.k != c.mCharCharsets[i3]) {
                    this.k = c.mCharCharsets[i3];
                    b.setTypeface(this.k == 0 ? this.a.getEnTypeface() : deprecatedDkTextView.l);
                }
                cArr[0] = c.mChars.charAt(i3);
                canvas.drawText(this.s, 0, 1, pointF2.x, pointF2.y, b);
                if (f != pointF2.y && this.a.B) {
                    f = pointF2.y;
                    canvas.drawLine(rectF2.left, rectF2.bottom - 1.0f, ((float) rect2.width()) + rectF2.left, rectF2.bottom - 1.0f, b);
                }
                i3 = rect.right - rect2.left;
                i4 = (krVar.c + rect.bottom) - rect2.top;
                if (i3 > rect3.right) {
                    i3 = rect3.right;
                }
                if (i4 > rect3.bottom) {
                    i4 = rect3.bottom;
                }
                if (rect5.right < i3) {
                    rect5.right = i3;
                }
                if (rect5.bottom < i4) {
                    rect5.bottom = i4;
                }
            }
            Iterator it = knVar.d.iterator();
            while (it.hasNext()) {
                kp kpVar = (kp) it.next();
                pointF.x = kpVar.e.x;
                pointF.y = kpVar.e.y;
                RectF rectF3 = kpVar.f;
                Rect rect6 = kpVar.g;
                pointF2.x = pointF.x - ((float) rect2.left);
                pointF2.y = ((float) (krVar.c - rect2.top)) + pointF.y;
                rectF2.left = rectF3.left - ((float) rect2.left);
                rectF2.top = ((float) (krVar.c - rect2.top)) + rectF3.top;
                rectF2.right = rectF3.right - ((float) rect2.left);
                rectF2.bottom = rectF3.bottom + ((float) (krVar.c - rect2.top));
                if (this.k != kpVar.d) {
                    this.k = kpVar.d;
                    b.setTypeface(this.k == 0 ? this.a.getEnTypeface() : deprecatedDkTextView.l);
                }
                canvas.drawText(kpVar.a, kpVar.b, kpVar.c, pointF2.x, pointF2.y, b);
                if (f != pointF2.y && this.a.B) {
                    f = pointF2.y;
                    canvas.drawLine(rectF2.left, rectF2.bottom - 1.0f, ((float) rect2.width()) + rectF2.left, rectF2.bottom - 1.0f, b);
                }
                float f2 = f;
                i3 = rect6.right - rect2.left;
                i4 = (krVar.c + rect6.bottom) - rect2.top;
                if (i3 > rect3.right) {
                    i3 = rect3.right;
                }
                if (i4 > rect3.bottom) {
                    i4 = rect3.bottom;
                }
                if (rect5.right < i3) {
                    rect5.right = i3;
                }
                if (rect5.bottom < i4) {
                    rect5.bottom = i4;
                }
                f = f2;
            }
        } finally {
            canvas.restore();
        }
    }

    public void a(Canvas canvas) {
        deprecatedDkTextView.i.setAntiAlias(true);
        deprecatedDkTextView.i.setSubpixelText(true);
        deprecatedDkTextView.i.setTextAlign(Align.LEFT);
        deprecatedDkTextView.i.setTextSize((float) this.a.n.mFontSize);
        deprecatedDkTextView.i.setColor(Color.rgb(Color.red(this.a.t), Color.green(this.a.t), Color.blue(this.a.t)));
        Iterator it = this.h.iterator();
        while (it.hasNext()) {
            ko koVar = (ko) it.next();
            koVar.c = true;
            for (int i = 0; i < koVar.b.size(); i++) {
                kr krVar = (kr) koVar.b.get(i);
                this.u.left = krVar.k.left + krVar.l.left;
                this.u.top = (krVar.k.top + krVar.l.top) - krVar.c;
                this.u.right = krVar.k.left + krVar.l.right;
                this.u.bottom = this.u.top + krVar.l.height();
                canvas.drawBitmap(krVar.a, krVar.l, this.u, deprecatedDkTextView.i);
            }
        }
    }

    public void c() {
        this.j.top = 0;
        this.j.left = 0;
        this.j.bottom = 0;
        this.j.right = 0;
        kq.g().d();
        Iterator it = this.h.iterator();
        while (it.hasNext()) {
            kq.g().a(((ko) it.next()).b);
        }
        kq.g().e();
        this.h.clear();
        this.i.clear();
    }

    public boolean a(Rect rect) {
        return this.j.contains(rect);
    }

    public boolean d() {
        return !this.j.isEmpty();
    }

    public List e() {
        return this.i;
    }

    public void f() {
        if (deprecatedDkTextView.f != this.a) {
            List list;
            if (deprecatedDkTextView.f == null || !(deprecatedDkTextView.f.E instanceof km)) {
                list = null;
            } else {
                list = ((km) deprecatedDkTextView.f.E).e();
            }
            this.j.top = 0;
            this.j.left = 0;
            this.j.bottom = 0;
            this.j.right = 0;
            Iterator it = this.h.iterator();
            while (it.hasNext()) {
                Iterator it2 = ((ko) it.next()).b.iterator();
                while (it2.hasNext()) {
                    kr krVar = (kr) it2.next();
                    if (list == null || !list.contains(krVar.a)) {
                        krVar.a.recycle();
                    }
                }
            }
            this.h.clear();
            this.i.clear();
            this.a.invalidate();
        }
    }
}
