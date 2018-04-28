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
import java.io.File;

public class bd extends Drawable {
    /* renamed from: a */
    private static final DktRenderer f6967a = new DktRenderer();
    /* renamed from: b */
    private static String f6968b = null;
    /* renamed from: c */
    private static String f6969c = null;
    /* renamed from: d */
    private static Typeface f6970d = null;
    /* renamed from: e */
    private static Typeface f6971e = null;
    /* renamed from: A */
    private boolean f6972A = false;
    /* renamed from: f */
    private final DktLayoutOption f6973f = new DktLayoutOption();
    /* renamed from: g */
    private final char[] f6974g = new char[1];
    /* renamed from: h */
    private final RectF f6975h = new RectF();
    /* renamed from: i */
    private final Rect f6976i = new Rect();
    /* renamed from: j */
    private final Point f6977j = new Point();
    /* renamed from: k */
    private final Paint f6978k = new Paint();
    /* renamed from: l */
    private final Rect f6979l = new Rect();
    /* renamed from: m */
    private final Rect f6980m = new Rect();
    /* renamed from: n */
    private int f6981n = 19;
    /* renamed from: o */
    private double f6982o = 0.0d;
    /* renamed from: p */
    private boolean f6983p = false;
    /* renamed from: q */
    private int f6984q = 0;
    /* renamed from: r */
    private int f6985r = 0;
    /* renamed from: s */
    private Typeface f6986s = null;
    /* renamed from: t */
    private Typeface f6987t = null;
    /* renamed from: u */
    private DktRenderTextInfo f6988u = null;
    /* renamed from: v */
    private String f6989v = "";
    /* renamed from: w */
    private String f6990w = null;
    /* renamed from: x */
    private int f6991x = -16777216;
    /* renamed from: y */
    private int f6992y = Integer.MAX_VALUE;
    /* renamed from: z */
    private TruncateAt f6993z = TruncateAt.END;

    public bd() {
        if (f6968b == null) {
            f6968b = ReaderEnv.get().getSystemFontFileZh().getAbsolutePath();
            f6969c = ReaderEnv.get().getSystemFontFileEn().getAbsolutePath();
            try {
                Typeface createFromFile = Typeface.createFromFile(f6968b);
                f6971e = createFromFile;
                f6970d = createFromFile;
            } catch (Throwable th) {
            }
        }
        this.f6973f.mFontSize = 16.0d;
        this.f6973f.mLineGap = 1.2d;
        this.f6973f.mParaSpacing = this.f6973f.mLineGap - 1.0d;
        this.f6973f.mTabStop = 4.0d;
        this.f6973f.mIndent = 0.0d;
        this.f6973f.mZhFontPath = f6968b;
        this.f6973f.mEnFontPath = f6969c;
        this.f6973f.mAlignType = m10257e(this.f6981n);
        this.f6978k.setAntiAlias(true);
        this.f6978k.setSubpixelText(true);
        this.f6978k.setTextAlign(Align.CENTER);
        this.f6978k.setTextSize((float) this.f6973f.mFontSize);
        this.f6978k.setColor(this.f6991x);
    }

    /* renamed from: a */
    public String m10265a() {
        return this.f6989v;
    }

    /* renamed from: a */
    public void m10270a(String str) {
        CharSequence charSequence = this.f6989v;
        this.f6989v = str;
        if (!TextUtils.equals(charSequence, str)) {
            this.f6990w = null;
            m10261m();
        }
    }

    /* renamed from: a */
    public void m10267a(int i) {
        if (this.f6991x != i) {
            this.f6991x = i;
            this.f6978k.setColor(this.f6991x);
            invalidateSelf();
        }
    }

    /* renamed from: b */
    public float m10272b() {
        return (float) this.f6973f.mFontSize;
    }

    /* renamed from: b */
    public void m10274b(int i) {
        if (this.f6973f.mFontSize != ((double) i)) {
            this.f6973f.mFontSize = (double) i;
            this.f6988u = null;
            this.f6978k.setTextSize((float) i);
            m10261m();
        }
    }

    /* renamed from: c */
    public boolean m10277c() {
        return this.f6972A;
    }

    /* renamed from: a */
    public void m10271a(boolean z) {
        if (this.f6972A != z) {
            this.f6972A = z;
            m10261m();
        }
    }

    /* renamed from: a */
    public void m10269a(File file) {
        this.f6973f.mEnFontPath = file.getAbsolutePath();
        this.f6987t = Typeface.createFromFile(this.f6973f.mEnFontPath);
        m10261m();
    }

    /* renamed from: a */
    public void m10268a(TruncateAt truncateAt) {
        TruncateAt truncateAt2 = this.f6993z;
        this.f6993z = truncateAt == TruncateAt.MIDDLE ? TruncateAt.MIDDLE : TruncateAt.END;
        if (this.f6993z != truncateAt2) {
            this.f6988u = null;
            m10261m();
        }
    }

    /* renamed from: c */
    public void m10276c(int i) {
        if (this.f6981n != i) {
            this.f6981n = i;
            this.f6973f.mAlignType = m10257e(i);
            this.f6988u = null;
            m10261m();
        }
    }

    /* renamed from: d */
    public void m10280d(int i) {
        int max = Math.max(1, i);
        if (this.f6992y != max) {
            this.f6992y = max;
            m10261m();
        }
    }

    /* renamed from: d */
    public double m10278d() {
        return this.f6973f.mIndent;
    }

    /* renamed from: a */
    public void m10266a(double d) {
        double max = Math.max(0.0d, d);
        if (Double.compare(this.f6982o, max) != 0) {
            this.f6982o = max;
            m10261m();
        }
    }

    /* renamed from: e */
    public double m10281e() {
        return this.f6973f.mLineGap;
    }

    /* renamed from: b */
    public void m10273b(double d) {
        double max = Math.max(1.0d, d);
        if (Double.compare(this.f6973f.mLineGap, max) != 0) {
            this.f6973f.mLineGap = max;
            m10261m();
        }
    }

    /* renamed from: f */
    public double m10282f() {
        return this.f6973f.mParaSpacing;
    }

    /* renamed from: c */
    public void m10275c(double d) {
        double max = Math.max(0.0d, d);
        if (Double.compare(this.f6973f.mParaSpacing, max) != 0) {
            this.f6973f.mParaSpacing = max;
            m10261m();
        }
    }

    /* renamed from: g */
    public double m10283g() {
        return this.f6973f.mTabStop;
    }

    /* renamed from: d */
    public void m10279d(double d) {
        if (Double.compare(this.f6973f.mTabStop, d) != 0) {
            this.f6973f.mTabStop = d;
            m10261m();
        }
    }

    /* renamed from: h */
    public Rect m10284h() {
        m10263o();
        return this.f6980m;
    }

    /* renamed from: i */
    public boolean m10285i() {
        return this.f6983p;
    }

    public int getIntrinsicHeight() {
        m10264p();
        return this.f6985r;
    }

    public int getIntrinsicWidth() {
        m10264p();
        return this.f6984q;
    }

    public void draw(Canvas canvas) {
        m10263o();
        if (this.f6988u.mCharTopLefts.length >= 2 && this.f6988u.mCharBottomRights.length >= 2) {
            this.f6976i.set(getBounds());
            int i = -1;
            int i2 = 0;
            while (i2 < this.f6988u.mChars.length()) {
                int a;
                this.f6974g[0] = this.f6988u.mChars.charAt(i2);
                if (i != m10255a(i2, this.f6988u)) {
                    a = m10255a(i2, this.f6988u);
                    this.f6978k.setTypeface(a == 0 ? m10260l() : m10259k());
                } else {
                    a = i;
                }
                if (m10256a(this.f6975h, i2, this.f6988u)) {
                    this.f6975h.offset((float) this.f6977j.x, (float) this.f6977j.y);
                    if (this.f6975h.intersects((float) this.f6976i.left, (float) this.f6976i.top, (float) this.f6976i.right, (float) this.f6976i.bottom)) {
                        canvas.drawText(this.f6974g, 0, 1, this.f6975h.centerX(), ((float) this.f6977j.y) + this.f6988u.mCharXYs[(i2 * 2) + 1], this.f6978k);
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
        this.f6978k.setAlpha(i);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f6978k.setColorFilter(colorFilter);
        invalidateSelf();
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (!rect.equals(this.f6979l)) {
            m10262n();
            if (!(rect.width() == this.f6979l.width() && rect.height() == this.f6979l.height())) {
                m10261m();
            }
            this.f6979l.set(rect);
        }
    }

    /* renamed from: j */
    private String m10258j() {
        String str = TextUtils.isEmpty(this.f6989v) ? "" : this.f6989v;
        if (!this.f6972A) {
            return str;
        }
        if (this.f6990w == null) {
            this.f6990w = DkUtils.chs2chtText(str);
        }
        return this.f6990w;
    }

    /* renamed from: e */
    private int m10257e(int i) {
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

    /* renamed from: k */
    private Typeface m10259k() {
        return this.f6987t != null ? this.f6986s : f6970d;
    }

    /* renamed from: l */
    private Typeface m10260l() {
        return this.f6987t != null ? this.f6987t : f6971e;
    }

    /* renamed from: m */
    private void m10261m() {
        this.f6983p = false;
        m10262n();
    }

    /* renamed from: n */
    private void m10262n() {
        this.f6988u = null;
        invalidateSelf();
    }

    /* renamed from: a */
    private static int m10255a(int i, DktRenderTextInfo dktRenderTextInfo) {
        if (i >= 0 && i < dktRenderTextInfo.mCharCharsets.length) {
            return dktRenderTextInfo.mCharCharsets[i];
        }
        return 0;
    }

    /* renamed from: a */
    private static boolean m10256a(RectF rectF, int i, DktRenderTextInfo dktRenderTextInfo) {
        if (i < 0 || (i * 2) + 1 >= dktRenderTextInfo.mCharTopLefts.length || (i * 2) + 1 >= dktRenderTextInfo.mCharBottomRights.length || (i * 2) + 1 >= dktRenderTextInfo.mCharXYs.length) {
            return false;
        }
        rectF.left = dktRenderTextInfo.mCharTopLefts[i * 2];
        rectF.top = dktRenderTextInfo.mCharTopLefts[(i * 2) + 1];
        rectF.right = dktRenderTextInfo.mCharBottomRights[i * 2];
        rectF.bottom = dktRenderTextInfo.mCharBottomRights[(i * 2) + 1];
        return true;
    }

    /* renamed from: o */
    private void m10263o() {
        m10264p();
        if (this.f6988u == null) {
            DktRenderTextInfo renderInfoByLineCount;
            Rect bounds = getBounds();
            DktLayoutOption dktLayoutOption = this.f6973f;
            double d = (this.f6992y <= 1 || this.f6973f.mAlignType == 2) ? 0.0d : this.f6982o;
            dktLayoutOption.mIndent = d;
            if (this.f6992y < Integer.MAX_VALUE) {
                boolean z;
                DktRenderer dktRenderer = f6967a;
                String j = m10258j();
                dktLayoutOption = this.f6973f;
                float width = (float) bounds.width();
                int i = this.f6992y;
                if (this.f6993z == TruncateAt.END) {
                    z = true;
                } else {
                    z = false;
                }
                renderInfoByLineCount = dktRenderer.getRenderInfoByLineCount(j, dktLayoutOption, width, i, z);
            } else {
                renderInfoByLineCount = f6967a.getRenderInfoByHeight(m10258j(), this.f6973f, (float) bounds.width(), (float) bounds.height(), this.f6993z == TruncateAt.END);
            }
            this.f6988u = renderInfoByLineCount;
            if (this.f6988u.mCharTopLefts.length < 2 || this.f6988u.mCharBottomRights.length < 2) {
                this.f6980m.setEmpty();
            } else {
                this.f6980m.left = Math.round(this.f6988u.mCharTopLefts[0]);
                this.f6980m.top = Math.round(this.f6988u.mCharTopLefts[1]);
                this.f6980m.right = Math.round(this.f6988u.mCharBottomRights[this.f6988u.mCharBottomRights.length - 2]);
                this.f6980m.bottom = Math.round(this.f6988u.mCharBottomRights[this.f6988u.mCharBottomRights.length - 1]);
            }
            this.f6977j.x = bounds.left;
            switch (this.f6981n & 112) {
                case 16:
                    this.f6977j.y = bounds.top + ((bounds.height() - this.f6980m.height()) / 2);
                    return;
                case 80:
                    this.f6977j.y = bounds.bottom - this.f6980m.height();
                    return;
                default:
                    this.f6977j.y = bounds.top;
                    return;
            }
        }
    }

    /* renamed from: p */
    private void m10264p() {
        boolean z = false;
        if (!this.f6983p) {
            DkBox renderBoxByLineCount;
            Rect bounds = getBounds();
            DktLayoutOption dktLayoutOption = this.f6973f;
            double d = (this.f6992y <= 1 || this.f6973f.mAlignType == 2) ? 0.0d : this.f6982o;
            dktLayoutOption.mIndent = d;
            DktRenderer dktRenderer;
            String j;
            float width;
            if (this.f6992y < Integer.MAX_VALUE) {
                dktRenderer = f6967a;
                j = m10258j();
                dktLayoutOption = this.f6973f;
                width = (float) bounds.width();
                int i = this.f6992y;
                if (this.f6993z == TruncateAt.END) {
                    z = true;
                }
                renderBoxByLineCount = dktRenderer.getRenderBoxByLineCount(j, dktLayoutOption, width, i, z);
            } else {
                dktRenderer = f6967a;
                j = m10258j();
                dktLayoutOption = this.f6973f;
                width = (float) bounds.width();
                if (this.f6993z == TruncateAt.END) {
                    z = true;
                }
                renderBoxByLineCount = dktRenderer.getRenderBoxByHeight(j, dktLayoutOption, width, 2.14748365E9f, z);
            }
            float f = renderBoxByLineCount.mX1 - renderBoxByLineCount.mX0;
            float f2 = renderBoxByLineCount.mY1 - renderBoxByLineCount.mY0;
            this.f6984q = Math.round(f);
            this.f6985r = Math.round(f2);
            this.f6983p = true;
        }
    }
}
