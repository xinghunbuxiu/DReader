package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Bitmap;
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

class jw extends ke {
    /* renamed from: a */
    final /* synthetic */ deprecatedDkTextView f7459a;
    /* renamed from: c */
    private int f7460c;
    /* renamed from: d */
    private int f7461d;
    /* renamed from: e */
    private jx[][] f7462e;
    /* renamed from: f */
    private int f7463f;
    /* renamed from: g */
    private int f7464g;
    /* renamed from: h */
    private final ArrayList<jy> f7465h;
    /* renamed from: i */
    private final ArrayList<Bitmap> f7466i;
    /* renamed from: j */
    private final Rect f7467j;
    /* renamed from: k */
    private int f7468k;
    /* renamed from: l */
    private int f7469l;
    /* renamed from: m */
    private final Rect f7470m;
    /* renamed from: n */
    private final RectF f7471n;
    /* renamed from: o */
    private final PointF f7472o;
    /* renamed from: p */
    private final ArrayList<jy> f7473p;
    /* renamed from: q */
    private final PointF f7474q;
    /* renamed from: r */
    private final RectF f7475r;
    /* renamed from: s */
    private final char[] f7476s;
    /* renamed from: t */
    private final Rect f7477t;
    /* renamed from: u */
    private final Rect f7478u;

    private jw(deprecatedDkTextView deprecateddktextview) {
        this.f7459a = deprecateddktextview;
        super(deprecateddktextview);
        this.f7465h = new ArrayList();
        this.f7466i = new ArrayList();
        this.f7467j = new Rect();
        this.f7468k = -1;
        this.f7469l = -1;
        this.f7470m = new Rect();
        this.f7471n = new RectF();
        this.f7472o = new PointF();
        this.f7473p = new ArrayList();
        this.f7474q = new PointF();
        this.f7475r = new RectF();
        this.f7476s = new char[1];
        this.f7477t = new Rect();
        this.f7478u = new Rect();
    }

    /* renamed from: a */
    public void mo1803a() {
        int i;
        int i2;
        int i3;
        Rect a = this.f7459a.f7082o;
        Rect b = this.f7459a.f7072A;
        DktRenderTextInfo c = this.f7459a.f7084q;
        RectF rectF = this.f7471n;
        Rect rect = this.f7470m;
        PointF pointF = this.f7472o;
        this.f7460c = ka.m10910g().m10915b();
        if (a.height() > this.f7460c * 6) {
            this.f7460c += this.f7460c;
        }
        this.f7461d = ka.m10910g().m10912a();
        this.f7463f = a.height() / this.f7460c;
        if (this.f7463f * this.f7460c != a.height()) {
            this.f7463f++;
        }
        this.f7464g = a.width() / this.f7461d;
        if (this.f7464g * this.f7461d != a.width()) {
            this.f7464g++;
        }
        this.f7462e = (jx[][]) Array.newInstance(jx.class, new int[]{this.f7463f, this.f7464g});
        jx[][] jxVarArr = this.f7462e;
        int i4 = a.top;
        for (i = 0; i < this.f7463f; i++) {
            i2 = a.left;
            for (i3 = 0; i3 < this.f7464g; i3++) {
                jw jwVar = this;
                jx jxVar = new jx();
                jxVar.f7479a.top = i4;
                jxVar.f7479a.left = i2;
                jxVar.f7479a.bottom = this.f7460c + i4;
                jxVar.f7479a.right = this.f7461d + i2;
                jxVarArr[i][i3] = jxVar;
                i2 += this.f7461d;
            }
            i4 += this.f7460c;
        }
        i3 = this.f7459a.getPaddingLeft();
        i2 = this.f7459a.getPaddingTop();
        if (this.f7459a.f7093z && this.f7459a.f7092y == TruncateMode.END_WITH_SPACING) {
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
                    m10887a(a, rect, i4);
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
                m10888a(a, rect, new jz(this, "...".toCharArray(), 0, 3, 0, pointF, rectF, rect));
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
                m10887a(a, rect, i);
            }
        }
    }

    /* renamed from: a */
    private void m10887a(Rect rect, Rect rect2, int i) {
        int i2 = this.f7461d;
        int i3 = this.f7460c;
        jx[][] jxVarArr = this.f7462e;
        int i4 = (rect2.top - rect.top) / i3;
        int i5 = (rect2.left - rect.left) / i2;
        int i6 = (i3 * i4) + rect.top;
        int i7 = rect.left + (i2 * i5);
        while (i4 < this.f7463f) {
            int i8 = i7;
            int i9 = i5;
            while (i9 < this.f7464g && i6 < rect2.bottom && i8 < rect2.right) {
                jx jxVar = jxVarArr[i4][i9];
                if (jxVar.f7480b == null) {
                    jxVar.f7480b = new int[30];
                    jxVar.f7481c = 0;
                } else if (jxVar.f7481c == jxVar.f7480b.length) {
                    Object obj = new int[(jxVar.f7481c + (jxVar.f7481c >> 1))];
                    System.arraycopy(jxVar.f7480b, 0, obj, 0, jxVar.f7481c);
                    jxVar.f7480b = obj;
                }
                jxVar.f7480b[jxVar.f7481c] = i;
                jxVar.f7481c++;
                i9++;
                i8 += i2;
            }
            i4++;
            i6 += i3;
        }
    }

    /* renamed from: a */
    private void m10888a(Rect rect, Rect rect2, jz jzVar) {
        int i = this.f7461d;
        int i2 = this.f7460c;
        jx[][] jxVarArr = this.f7462e;
        int i3 = (rect2.top - rect.top) / i2;
        int i4 = (rect2.left - rect.left) / i;
        int i5 = (i2 * i3) + rect.top;
        int i6 = rect.left + (i * i4);
        while (i3 < this.f7463f) {
            int i7 = i6;
            int i8 = i4;
            while (i8 < this.f7464g && i5 < rect2.bottom && i7 < rect2.right) {
                jxVarArr[i3][i8].f7482d.add(jzVar);
                i8++;
                i7 += i;
            }
            i3++;
            i5 += i2;
        }
    }

    /* renamed from: b */
    public void mo1807b() {
        this.f7462e = (jx[][]) null;
    }

    /* renamed from: a */
    public void mo1804a(Context context, Canvas canvas, Rect rect) {
        int paddingLeft = this.f7459a.getPaddingLeft();
        int paddingTop = this.f7459a.getPaddingTop();
        this.f7468k = -1;
        this.f7469l = -1;
        m10886a(context, rect);
        if (!this.f7467j.isEmpty()) {
            int i;
            int a = ka.m10910g().m10912a();
            int i2 = (this.f7467j.top - this.f7459a.f7082o.top) / this.f7460c;
            int i3 = (this.f7467j.left - this.f7459a.f7082o.left) / a;
            int height = this.f7467j.height() / this.f7460c;
            if (this.f7460c * height != this.f7467j.height()) {
                i = height + 1;
            } else {
                i = height;
            }
            height = this.f7467j.width() / a;
            if (a * height != this.f7467j.width()) {
                a = height + 1;
            } else {
                a = height;
            }
            int i4 = 0;
            int i5 = 0;
            jy jyVar = (jy) this.f7465h.get(0);
            while (i5 < i && i2 + i5 < this.f7463f) {
                int i6 = 0;
                jy jyVar2 = jyVar;
                int i7 = i4;
                while (i6 < a && i3 + i6 < this.f7464g) {
                    jx jxVar = this.f7462e[i2 + i5][i3 + i6];
                    if (i6 != 0 || Rect.intersects(jyVar2.f7484a, jxVar.f7479a)) {
                        i4 = i7;
                        jyVar = jyVar2;
                    } else {
                        i7++;
                        i4 = i7;
                        jyVar = (jy) this.f7465h.get(i7);
                    }
                    if (!jyVar.f7486c) {
                        kb kbVar;
                        for (int i8 = 0; i8 < jyVar.f7485b.size(); i8++) {
                            if (Rect.intersects(((kb) jyVar.f7485b.get(i8)).f7519k, jxVar.f7479a)) {
                                kbVar = (kb) jyVar.f7485b.get(i8);
                                break;
                            }
                        }
                        kbVar = null;
                        if (kbVar != null) {
                            m10889a(jxVar, kbVar, paddingLeft, paddingTop);
                        }
                    }
                    i6++;
                    jyVar2 = jyVar;
                    i7 = i4;
                }
                i5++;
                i4 = i7;
                jyVar = jyVar2;
            }
        }
        this.f7468k = -1;
        this.f7469l = -1;
    }

    /* renamed from: a */
    private void m10886a(Context context, Rect rect) {
        Iterator it;
        ka.m10910g().m10917d();
        if (rect.top == 0 && rect.bottom == 0) {
            this.f7467j.top = 0;
            this.f7467j.left = 0;
            this.f7467j.bottom = 0;
            this.f7467j.right = 0;
            it = this.f7465h.iterator();
            while (it.hasNext()) {
                ka.m10910g().m10914a(((jy) it.next()).f7485b);
            }
            this.f7465h.clear();
        } else {
            int i = this.f7459a.f7082o.bottom - this.f7459a.f7082o.top;
            int i2 = this.f7459a.getUserVisibleAreaHeight();
            if (i < i2 / 2 || i <= ka.m10910g().m10915b() * 2) {
                this.f7469l = (i / ka.m10910g().m10915b()) * ka.m10910g().m10915b();
                if (this.f7469l < i) {
                    this.f7469l += ka.m10910g().m10915b();
                }
            } else {
                this.f7469l = ((i2 / 2) * ka.m10910g().m10915b()) / ka.m10910g().m10915b();
                if (this.f7469l > ka.m10910g().m10916c()) {
                    this.f7469l = ka.m10910g().m10916c();
                }
            }
            i = (this.f7469l / this.f7460c) * this.f7460c;
            if (this.f7469l != i) {
                this.f7469l = i + this.f7460c;
            }
            this.f7467j.left = rect.left;
            this.f7467j.right = rect.right;
            int i3 = (rect.top - this.f7459a.f7082o.top) / this.f7469l;
            int i4 = ((rect.bottom - 1) - this.f7459a.f7082o.top) / this.f7469l;
            this.f7467j.top = this.f7459a.f7082o.top + (this.f7469l * i3);
            this.f7467j.bottom = this.f7459a.f7082o.top + (this.f7469l * (i4 + 1));
            this.f7473p.clear();
            for (i2 = 0; i2 < this.f7465h.size(); i2++) {
                i = (((jy) this.f7465h.get(i2)).f7484a.top - this.f7459a.f7082o.top) / this.f7469l;
                if (i < i3 || i > i4) {
                    this.f7473p.add(this.f7465h.get(i2));
                }
            }
            it = this.f7473p.iterator();
            while (it.hasNext()) {
                jy jyVar = (jy) it.next();
                this.f7465h.remove(jyVar);
                ka.m10910g().m10914a(jyVar.f7485b);
                jyVar.f7485b.clear();
            }
            deprecatedDkTextView.m10465m(this.f7459a);
            if (this.f7465h.size() > 0) {
                i = (((jy) this.f7465h.get(0)).f7484a.top - this.f7459a.f7082o.top) / this.f7469l;
            } else {
                i = -1;
            }
            if (i < 0) {
                i = i3;
            }
            for (i2 = i3; i2 < i; i2++) {
                this.f7465h.add(i2 - i3, m10885a(context, i2));
            }
            if (this.f7465h.size() > 0) {
                i = (((jy) this.f7465h.get(this.f7465h.size() - 1)).f7484a.top - this.f7459a.f7082o.top) / this.f7469l;
            } else {
                i = -1;
            }
            if (i >= 0) {
                i3 = i + 1;
            }
            while (i3 <= i4) {
                this.f7465h.add(m10885a(context, i3));
                i3++;
            }
        }
        ka.m10910g().m10918e();
        this.f7466i.clear();
        it = this.f7465h.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((jy) it.next()).f7485b.iterator();
            while (it2.hasNext()) {
                kb kbVar = (kb) it2.next();
                if (!this.f7466i.contains(kbVar.f7509a)) {
                    this.f7466i.add(kbVar.f7509a);
                }
            }
        }
    }

    /* renamed from: a */
    private jy m10885a(Context context, int i) {
        jy jyVar;
        int i2 = this.f7469l;
        int i3 = this.f7459a.f7082o.bottom - this.f7459a.f7082o.top;
        if ((i + 1) * this.f7469l > i3) {
            i3 -= this.f7469l * i;
        } else {
            i3 = i2;
        }
        ka g = ka.m10910g();
        if (this.f7473p.size() != 0) {
            jyVar = (jy) this.f7473p.get(0);
            this.f7473p.remove(0);
        } else {
            jyVar = new jy();
        }
        jyVar.f7484a.top = this.f7459a.f7082o.top + (this.f7469l * i);
        jyVar.f7484a.bottom = i3 + jyVar.f7484a.top;
        jyVar.f7484a.left = this.f7467j.left;
        jyVar.f7484a.right = this.f7467j.right;
        g.m10913a(context, jyVar.f7484a, this.f7460c, jyVar.f7485b);
        jyVar.f7486c = false;
        return jyVar;
    }

    /* renamed from: a */
    private void m10889a(jx jxVar, kb kbVar, int i, int i2) {
        PointF pointF = this.f7472o;
        RectF rectF = this.f7471n;
        Rect rect = this.f7470m;
        DktRenderTextInfo c = this.f7459a.f7084q;
        char[] cArr = this.f7476s;
        PointF pointF2 = this.f7474q;
        RectF rectF2 = this.f7475r;
        Rect rect2 = kbVar.f7519k;
        Rect rect3 = kbVar.f7514f;
        Rect rect4 = this.f7477t;
        Paint b = deprecatedDkTextView.f7066h;
        Canvas canvas = kbVar.f7515g;
        Rect rect5 = kbVar.f7520l;
        canvas.save();
        rect4.top = (rect3.top + jxVar.f7479a.top) - rect2.top;
        rect4.left = (rect3.left + jxVar.f7479a.left) - rect2.left;
        rect4.bottom = rect4.top + jxVar.f7479a.height();
        rect4.right = rect4.left + jxVar.f7479a.width();
        canvas.clipRect(rect4);
        float f = 2.14748365E9f;
        try {
            int i3;
            int i4;
            int i5 = jxVar.f7481c;
            for (int i6 = 0; i6 < i5; i6++) {
                i3 = jxVar.f7480b[i6];
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
                pointF2.y = ((float) (kbVar.f7511c - rect2.top)) + pointF.y;
                rectF2.left = rectF.left - ((float) rect2.left);
                rectF2.top = ((float) (kbVar.f7511c - rect2.top)) + rectF.top;
                rectF2.right = rectF.right - ((float) rect2.left);
                rectF2.bottom = ((float) (kbVar.f7511c - rect2.top)) + rectF.bottom;
                if (this.f7468k != c.mCharCharsets[i3]) {
                    this.f7468k = c.mCharCharsets[i3];
                    b.setTypeface(this.f7468k == 0 ? this.f7459a.getEnTypeface() : deprecatedDkTextView.f7070l);
                }
                cArr[0] = c.mChars.charAt(i3);
                canvas.drawText(this.f7476s, 0, 1, pointF2.x, pointF2.y, b);
                if (f != pointF2.y && this.f7459a.f7073B) {
                    f = pointF2.y;
                    canvas.drawLine(rectF2.left, rectF2.bottom - 1.0f, ((float) rect2.width()) + rectF2.left, rectF2.bottom - 1.0f, b);
                }
                i3 = rect.right - rect2.left;
                i4 = (kbVar.f7511c + rect.bottom) - rect2.top;
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
            Iterator it = jxVar.f7482d.iterator();
            while (it.hasNext()) {
                jz jzVar = (jz) it.next();
                pointF.x = jzVar.f7492e.x;
                pointF.y = jzVar.f7492e.y;
                RectF rectF3 = jzVar.f7493f;
                Rect rect6 = jzVar.f7494g;
                pointF2.x = pointF.x - ((float) rect2.left);
                pointF2.y = ((float) (kbVar.f7511c - rect2.top)) + pointF.y;
                rectF2.left = rectF3.left - ((float) rect2.left);
                rectF2.top = ((float) (kbVar.f7511c - rect2.top)) + rectF3.top;
                rectF2.right = rectF3.right - ((float) rect2.left);
                rectF2.bottom = rectF3.bottom + ((float) (kbVar.f7511c - rect2.top));
                if (this.f7468k != jzVar.f7491d) {
                    this.f7468k = jzVar.f7491d;
                    b.setTypeface(this.f7468k == 0 ? this.f7459a.getEnTypeface() : deprecatedDkTextView.f7070l);
                }
                canvas.drawText(jzVar.f7488a, jzVar.f7489b, jzVar.f7490c, pointF2.x, pointF2.y, b);
                if (f != pointF2.y && this.f7459a.f7073B) {
                    f = pointF2.y;
                    canvas.drawLine(rectF2.left, rectF2.bottom - 1.0f, ((float) rect2.width()) + rectF2.left, rectF2.bottom - 1.0f, b);
                }
                float f2 = f;
                i3 = rect6.right - rect2.left;
                i4 = (kbVar.f7511c + rect6.bottom) - rect2.top;
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

    /* renamed from: a */
    public void mo1805a(Canvas canvas) {
        deprecatedDkTextView.f7067i.setAntiAlias(true);
        deprecatedDkTextView.f7067i.setSubpixelText(true);
        deprecatedDkTextView.f7067i.setTextAlign(Align.LEFT);
        deprecatedDkTextView.f7067i.setTextSize((float) this.f7459a.f7081n.mFontSize);
        deprecatedDkTextView.f7067i.setColor(Color.rgb(Color.red(this.f7459a.f7087t), Color.green(this.f7459a.f7087t), Color.blue(this.f7459a.f7087t)));
        Iterator it = this.f7465h.iterator();
        while (it.hasNext()) {
            jy jyVar = (jy) it.next();
            jyVar.f7486c = true;
            for (int i = 0; i < jyVar.f7485b.size(); i++) {
                kb kbVar = (kb) jyVar.f7485b.get(i);
                this.f7478u.left = kbVar.f7519k.left + kbVar.f7520l.left;
                this.f7478u.top = (kbVar.f7519k.top + kbVar.f7520l.top) - kbVar.f7511c;
                this.f7478u.right = kbVar.f7519k.left + kbVar.f7520l.right;
                this.f7478u.bottom = this.f7478u.top + kbVar.f7520l.height();
                canvas.drawBitmap(kbVar.f7509a, kbVar.f7520l, this.f7478u, deprecatedDkTextView.f7067i);
            }
        }
    }

    /* renamed from: c */
    public void mo1808c() {
        this.f7467j.top = 0;
        this.f7467j.left = 0;
        this.f7467j.bottom = 0;
        this.f7467j.right = 0;
        ka.m10910g().m10917d();
        Iterator it = this.f7465h.iterator();
        while (it.hasNext()) {
            ka.m10910g().m10914a(((jy) it.next()).f7485b);
        }
        ka.m10910g().m10918e();
        this.f7465h.clear();
        this.f7466i.clear();
    }

    /* renamed from: a */
    public boolean mo1806a(Rect rect) {
        return this.f7467j.contains(rect);
    }

    /* renamed from: d */
    public boolean mo1809d() {
        return !this.f7467j.isEmpty();
    }

    /* renamed from: e */
    public List<Bitmap> m10897e() {
        return this.f7466i;
    }

    /* renamed from: f */
    public void m10898f() {
        if (deprecatedDkTextView.f7064f != this.f7459a) {
            List list;
            if (deprecatedDkTextView.f7064f == null || !(deprecatedDkTextView.f7064f.f7076E instanceof jw)) {
                list = null;
            } else {
                list = ((jw) deprecatedDkTextView.f7064f.f7076E).m10897e();
            }
            this.f7467j.top = 0;
            this.f7467j.left = 0;
            this.f7467j.bottom = 0;
            this.f7467j.right = 0;
            Iterator it = this.f7465h.iterator();
            while (it.hasNext()) {
                Iterator it2 = ((jy) it.next()).f7485b.iterator();
                while (it2.hasNext()) {
                    kb kbVar = (kb) it2.next();
                    if (list == null || !list.contains(kbVar.f7509a)) {
                        kbVar.f7509a.recycle();
                    }
                }
            }
            this.f7465h.clear();
            this.f7466i.clear();
            this.f7459a.invalidate();
        }
    }
}
