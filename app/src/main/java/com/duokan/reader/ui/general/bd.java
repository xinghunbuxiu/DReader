package com.duokan.reader.ui.general;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;

import com.duokan.kernel.DkBox;
import com.duokan.kernel.DkUtils;
import com.duokan.kernel.txtlib.DktLayoutOption;
import com.duokan.kernel.txtlib.DktRenderTextInfo;
import com.duokan.kernel.txtlib.DktRenderer;
import com.duokan.reader.ReaderEnv;

public class bd extends Drawable {
    private static final DktRenderer a = new DktRenderer();
    private static String b = null;
    private static String c = null;
    private static Typeface d = null;
    private static Typeface e = null;
    private boolean A = false;
    private final DktLayoutOption f = new DktLayoutOption();
    private final char[] g = new char[1];
    private final RectF h = new RectF();
    private final Rect i = new Rect();
    private final Point j = new Point();
    private final Paint k = new Paint();
    private final Rect l = new Rect();
    private final Rect m = new Rect();
    private int n = 19;
    private double o = 0.0d;
    private boolean p = false;
    private int q = 0;
    private int r = 0;
    private Typeface s = null;
    private Typeface t = null;
    private DktRenderTextInfo u = null;
    private String v = "";
    private String w = null;
    private int x = -16777216;
    private int y = Integer.MAX_VALUE;
    private TruncateAt z = TruncateAt.END;

    public bd() {
        if (b == null) {
            b = ReaderEnv.get().getSystemFontFileZh().getAbsolutePath();
            c = ReaderEnv.get().getSystemFontFileEn().getAbsolutePath();
            try {
                Typeface createFromFile = Typeface.createFromFile(b);
                e = createFromFile;
                d = createFromFile;
            } catch (Throwable th) {
            }
        }
        this.f.mFontSize = 16.0d;
        this.f.mLineGap = 1.2d;
        this.f.mParaSpacing = this.f.mLineGap - 1.0d;
        this.f.mTabStop = 4.0d;
        this.f.mIndent = 0.0d;
        this.f.mZhFontPath = b;
        this.f.mEnFontPath = c;
        this.f.mAlignType = e(this.n);
        this.k.setAntiAlias(true);
        this.k.setSubpixelText(true);
        this.k.setTextAlign(Align.CENTER);
        this.k.setTextSize((float) this.f.mFontSize);
        this.k.setColor(this.x);
    }

    public String a() {
        return this.v;
    }

    public void a(String str) {
        CharSequence charSequence = this.v;
        this.v = str;
        if (!TextUtils.equals(charSequence, str)) {
            this.w = null;
            m();
        }
    }

    public void a(int i) {
        if (this.x != i) {
            this.x = i;
            this.k.setColor(this.x);
            invalidateSelf();
        }
    }

    public float b() {
        return (float) this.f.mFontSize;
    }

    public void b(int i) {
        if (this.f.mFontSize != ((double) i)) {
            this.f.mFontSize = (double) i;
            this.u = null;
            this.k.setTextSize((float) i);
            m();
        }
    }

    public boolean c() {
        return this.A;
    }

    public void a(boolean z) {
        if (this.A != z) {
            this.A = z;
            m();
        }
    }

    public void a(TruncateAt truncateAt) {
        TruncateAt truncateAt2 = this.z;
        this.z = truncateAt == TruncateAt.MIDDLE ? TruncateAt.MIDDLE : TruncateAt.END;
        if (this.z != truncateAt2) {
            this.u = null;
            m();
        }
    }

    public void c(int i) {
        if (this.n != i) {
            this.n = i;
            this.f.mAlignType = e(i);
            this.u = null;
            m();
        }
    }

    public void d(int i) {
        int max = Math.max(1, i);
        if (this.y != max) {
            this.y = max;
            m();
        }
    }

    public double d() {
        return this.f.mIndent;
    }

    public void a(double d) {
        double max = Math.max(0.0d, d);
        if (Double.compare(this.o, max) != 0) {
            this.o = max;
            m();
        }
    }

    public double e() {
        return this.f.mLineGap;
    }

    public void b(double d) {
        double max = Math.max(1.0d, d);
        if (Double.compare(this.f.mLineGap, max) != 0) {
            this.f.mLineGap = max;
            m();
        }
    }

    public double f() {
        return this.f.mParaSpacing;
    }

    public void c(double d) {
        double max = Math.max(0.0d, d);
        if (Double.compare(this.f.mParaSpacing, max) != 0) {
            this.f.mParaSpacing = max;
            m();
        }
    }

    public double g() {
        return this.f.mTabStop;
    }

    public void d(double d) {
        if (Double.compare(this.f.mTabStop, d) != 0) {
            this.f.mTabStop = d;
            m();
        }
    }

    public Rect h() {
        o();
        return this.m;
    }

    public boolean i() {
        return this.p;
    }

    public int getIntrinsicHeight() {
        p();
        return this.r;
    }

    public int getIntrinsicWidth() {
        p();
        return this.q;
    }

    public void draw(Canvas canvas) {
        o();
        if (this.u.mCharTopLefts.length >= 2 && this.u.mCharBottomRights.length >= 2) {
            this.i.set(getBounds());
            int i = -1;
            int i2 = 0;
            while (i2 < this.u.mChars.length()) {
                int a;
                this.g[0] = this.u.mChars.charAt(i2);
                if (i != a(i2, this.u)) {
                    a = a(i2, this.u);
                    this.k.setTypeface(a == 0 ? l() : k());
                } else {
                    a = i;
                }
                if (a(this.h, i2, this.u)) {
                    this.h.offset((float) this.j.x, (float) this.j.y);
                    if (this.h.intersects((float) this.i.left, (float) this.i.top, (float) this.i.right, (float) this.i.bottom)) {
                        canvas.drawText(this.g, 0, 1, this.h.centerX(), ((float) this.j.y) + this.u.mCharXYs[(i2 * 2) + 1], this.k);
                    }
                }
                i2++;
                i = a;
            }
        }
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i) {
        this.k.setAlpha(i);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.k.setColorFilter(colorFilter);
        invalidateSelf();
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (!rect.equals(this.l)) {
            n();
            if (!(rect.width() == this.l.width() && rect.height() == this.l.height())) {
                m();
            }
            this.l.set(rect);
        }
    }

    private String j() {
        String str = TextUtils.isEmpty(this.v) ? "" : this.v;
        if (!this.A) {
            return str;
        }
        if (this.w == null) {
            this.w = DkUtils.chs2chtText(str);
        }
        return this.w;
    }

    private int e(int i) {
        switch (i & 7) {
            case 1:
                return 2;
            case 3:
                return 0;
            case 5:
                return 1;
            default:
                return 3;
        }
    }

    private Typeface k() {
        return this.t != null ? this.s : d;
    }

    private Typeface l() {
        return this.t != null ? this.t : e;
    }

    private void m() {
        this.p = false;
        n();
    }

    private void n() {
        this.u = null;
        invalidateSelf();
    }

    private static int a(int i, DktRenderTextInfo dktRenderTextInfo) {
        if (i >= 0 && i < dktRenderTextInfo.mCharCharsets.length) {
            return dktRenderTextInfo.mCharCharsets[i];
        }
        return 0;
    }

    private static boolean a(RectF rectF, int i, DktRenderTextInfo dktRenderTextInfo) {
        if (i < 0 || (i * 2) + 1 >= dktRenderTextInfo.mCharTopLefts.length || (i * 2) + 1 >= dktRenderTextInfo.mCharBottomRights.length || (i * 2) + 1 >= dktRenderTextInfo.mCharXYs.length) {
            return false;
        }
        rectF.left = dktRenderTextInfo.mCharTopLefts[i * 2];
        rectF.top = dktRenderTextInfo.mCharTopLefts[(i * 2) + 1];
        rectF.right = dktRenderTextInfo.mCharBottomRights[i * 2];
        rectF.bottom = dktRenderTextInfo.mCharBottomRights[(i * 2) + 1];
        return true;
    }

    private void o() {
        p();
        if (this.u == null) {
            DktRenderTextInfo renderInfoByLineCount;
            Rect bounds = getBounds();
            DktLayoutOption dktLayoutOption = this.f;
            double d = (this.y <= 1 || this.f.mAlignType == 2) ? 0.0d : this.o;
            dktLayoutOption.mIndent = d;
            if (this.y < Integer.MAX_VALUE) {
                boolean z;
                DktRenderer dktRenderer = a;
                String j = j();
                dktLayoutOption = this.f;
                float width = (float) bounds.width();
                int i = this.y;
                if (this.z == TruncateAt.END) {
                    z = true;
                } else {
                    z = false;
                }
                renderInfoByLineCount = dktRenderer.getRenderInfoByLineCount(j, dktLayoutOption, width, i, z);
            } else {
                renderInfoByLineCount = a.getRenderInfoByHeight(j(), this.f, (float) bounds.width(), (float) bounds.height(), this.z == TruncateAt.END);
            }
            this.u = renderInfoByLineCount;
            if (this.u.mCharTopLefts.length < 2 || this.u.mCharBottomRights.length < 2) {
                this.m.setEmpty();
            } else {
                this.m.left = Math.round(this.u.mCharTopLefts[0]);
                this.m.top = Math.round(this.u.mCharTopLefts[1]);
                this.m.right = Math.round(this.u.mCharBottomRights[this.u.mCharBottomRights.length - 2]);
                this.m.bottom = Math.round(this.u.mCharBottomRights[this.u.mCharBottomRights.length - 1]);
            }
            this.j.x = bounds.left;
            switch (this.n & 112) {
                case 16:
                    this.j.y = bounds.top + ((bounds.height() - this.m.height()) / 2);
                    return;
                case 80:
                    this.j.y = bounds.bottom - this.m.height();
                    return;
                default:
                    this.j.y = bounds.top;
                    return;
            }
        }
    }

    private void p() {
        boolean z = false;
        if (!this.p) {
            DkBox renderBoxByLineCount;
            Rect bounds = getBounds();
            DktLayoutOption dktLayoutOption = this.f;
            double d = (this.y <= 1 || this.f.mAlignType == 2) ? 0.0d : this.o;
            dktLayoutOption.mIndent = d;
            DktRenderer dktRenderer;
            String j;
            float width;
            if (this.y < Integer.MAX_VALUE) {
                dktRenderer = a;
                j = j();
                dktLayoutOption = this.f;
                width = (float) bounds.width();
                int i = this.y;
                if (this.z == TruncateAt.END) {
                    z = true;
                }
                renderBoxByLineCount = dktRenderer.getRenderBoxByLineCount(j, dktLayoutOption, width, i, z);
            } else {
                dktRenderer = a;
                j = j();
                dktLayoutOption = this.f;
                width = (float) bounds.width();
                if (this.z == TruncateAt.END) {
                    z = true;
                }
                renderBoxByLineCount = dktRenderer.getRenderBoxByHeight(j, dktLayoutOption, width, 2.14748365E9f, z);
            }
            float f = renderBoxByLineCount.mX1 - renderBoxByLineCount.mX0;
            float f2 = renderBoxByLineCount.mY1 - renderBoxByLineCount.mY0;
            this.q = Math.round(f);
            this.r = Math.round(f2);
            this.p = true;
        }
    }
}
