package com.duokan.reader.ui.general;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;

import com.duokan.core.ui.Scrollable;
import com.duokan.kernel.DkBox;
import com.duokan.kernel.DkUtils;
import com.duokan.kernel.txtlib.DktLayoutOption;
import com.duokan.kernel.txtlib.DktRenderTextInfo;
import com.duokan.kernel.txtlib.DktRenderer;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.bitmap.BitmapsRecycler;

import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

@Deprecated
public class deprecatedDkTextView extends View {
    private static final int[] H = new int[2];
    static final /* synthetic */ boolean a = (!deprecatedDkTextView.class.desiredAssertionStatus());
    private static final ArrayList b = new ArrayList();
    private static final HashMap c = new HashMap();
    private static final ArrayList d = new ArrayList();
    private static BitmapsRecycler e;
    private static deprecatedDkTextView f = null;
    private static final DktRenderer g = new DktRenderer();
    private static final Paint h = new Paint();
    private static final Paint i = new Paint();
    private static String j = null;
    private static String k = null;
    private static Typeface l = null;
    private static Typeface m = null;
    private Rect A;
    private boolean B;
    private boolean C;
    private boolean D;
    private ku E;
    private WeakReference F;
    private WeakReference G;
    private final Rect I;
    private final int[] J;
    private final DktLayoutOption n;
    private final Rect o;
    private Typeface p;
    private DktRenderTextInfo q;
    private String r;
    private String s;
    private int t;
    private int u;
    private TruncateAt v;
    private int w;
    private boolean x;
    private TruncateMode y;
    private boolean z;

    public enum TruncateMode {
        NORMAL,
        END_WITH_SPACING
    }

    private static void i() {
        t.a(new kj());
    }

    private static void m(deprecatedDkTextView com_duokan_reader_ui_general_deprecatedDkTextView) {
        if (com_duokan_reader_ui_general_deprecatedDkTextView.F != null) {
            j();
            int[] iArr = H;
            ArrayList arrayList = (ArrayList) c.get(com_duokan_reader_ui_general_deprecatedDkTextView.F);
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    deprecatedDkTextView com_duokan_reader_ui_general_deprecatedDkTextView2 = (deprecatedDkTextView) ((WeakReference) it.next()).get();
                    if (!(com_duokan_reader_ui_general_deprecatedDkTextView2 == null || f == com_duokan_reader_ui_general_deprecatedDkTextView2 || com_duokan_reader_ui_general_deprecatedDkTextView2 == com_duokan_reader_ui_general_deprecatedDkTextView || !com_duokan_reader_ui_general_deprecatedDkTextView2.E.d())) {
                        int i;
                        int i2 = (com_duokan_reader_ui_general_deprecatedDkTextView2.getParent() == null || com_duokan_reader_ui_general_deprecatedDkTextView2.getVisibility() != 0) ? 0 : 1;
                        if (!(i2 == 0 || com_duokan_reader_ui_general_deprecatedDkTextView2.G == null)) {
                            View view = (View) com_duokan_reader_ui_general_deprecatedDkTextView2.G.get();
                            if (view != null) {
                                if (view.getParent() == null || view.getVisibility() != 0) {
                                    i = 0;
                                } else {
                                    i = 1;
                                }
                                if (i != 0) {
                                    ((km) com_duokan_reader_ui_general_deprecatedDkTextView2.E).c();
                                    com_duokan_reader_ui_general_deprecatedDkTextView2.invalidate();
                                } else {
                                    i = com_duokan_reader_ui_general_deprecatedDkTextView2.getUserVisibleAreaHeight();
                                    com_duokan_reader_ui_general_deprecatedDkTextView2.a(iArr);
                                    i2 = iArr[1] + com_duokan_reader_ui_general_deprecatedDkTextView2.getMeasuredHeight();
                                    if (iArr[1] < i || i2 <= 0) {
                                        ((km) com_duokan_reader_ui_general_deprecatedDkTextView2.E).c();
                                        com_duokan_reader_ui_general_deprecatedDkTextView2.invalidate();
                                    }
                                }
                            }
                        }
                        i = i2;
                        if (i != 0) {
                            i = com_duokan_reader_ui_general_deprecatedDkTextView2.getUserVisibleAreaHeight();
                            com_duokan_reader_ui_general_deprecatedDkTextView2.a(iArr);
                            i2 = iArr[1] + com_duokan_reader_ui_general_deprecatedDkTextView2.getMeasuredHeight();
                            if (iArr[1] < i) {
                            }
                            ((km) com_duokan_reader_ui_general_deprecatedDkTextView2.E).c();
                            com_duokan_reader_ui_general_deprecatedDkTextView2.invalidate();
                        } else {
                            ((km) com_duokan_reader_ui_general_deprecatedDkTextView2.E).c();
                            com_duokan_reader_ui_general_deprecatedDkTextView2.invalidate();
                        }
                    }
                }
            }
        }
    }

    private static WeakReference a(Scrollable scrollable) {
        Iterator it = b.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference.get() == scrollable) {
                return weakReference;
            }
        }
        return null;
    }

    private static WeakReference a(deprecatedDkTextView com_duokan_reader_ui_general_deprecatedDkTextView, ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference.get() == com_duokan_reader_ui_general_deprecatedDkTextView) {
                return weakReference;
            }
        }
        return null;
    }

    private static void j() {
        Iterator it = b.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (((Scrollable) weakReference.get()) == null) {
                it.remove();
                ArrayList arrayList = (ArrayList) c.remove(weakReference);
                if (arrayList != null) {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        deprecatedDkTextView com_duokan_reader_ui_general_deprecatedDkTextView = (deprecatedDkTextView) ((WeakReference) it2.next()).get();
                        if (com_duokan_reader_ui_general_deprecatedDkTextView != null) {
                            com_duokan_reader_ui_general_deprecatedDkTextView.E.c();
                        }
                    }
                    arrayList.clear();
                }
            }
        }
        Iterator it3 = d.iterator();
        while (it3.hasNext()) {
            if (((deprecatedDkTextView) ((WeakReference) it3.next()).get()) == null) {
                it3.remove();
            }
        }
    }

    public deprecatedDkTextView(Context context) {
        this(context, null);
    }

    public deprecatedDkTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.n = new DktLayoutOption();
        this.o = new Rect();
        this.p = null;
        this.q = null;
        this.r = "";
        this.s = null;
        this.t = -16777216;
        this.u = Integer.MAX_VALUE;
        this.v = TruncateAt.END;
        this.w = -1;
        this.x = false;
        this.z = false;
        this.A = new Rect();
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = new kt();
        this.F = null;
        this.G = null;
        this.I = new Rect();
        this.J = new int[2];
        if (j == null) {
            j = ReaderEnv.get().getSystemFontFileZh().getAbsolutePath();
            k = ReaderEnv.get().getSystemFontFileEn().getAbsolutePath();
            try {
                l = Typeface.createFromFile(j);
            } catch (Throwable th) {
            }
            try {
                m = Typeface.createFromFile(k);
            } catch (Exception e) {
                m = l;
                k = j;
            }
        }
        kq.a(context);
        if (e == null) {
            e = new kl();
            a.a(e);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842901, 16842904, 16842923, 16842927, 16843087, 16843091});
        this.r = obtainStyledAttributes.hasValue(4) ? obtainStyledAttributes.getString(4) : "";
        this.t = obtainStyledAttributes.getColor(1, -16777216);
        switch (obtainStyledAttributes.getInt(2, 0)) {
            case 1:
            case 4:
                if (!a) {
                    throw new AssertionError();
                }
                break;
            case 2:
                this.v = TruncateAt.MIDDLE;
                break;
            default:
                this.v = TruncateAt.END;
                break;
        }
        this.u = obtainStyledAttributes.getInteger(5, Integer.MAX_VALUE);
        if (this.v == TruncateAt.MIDDLE) {
            this.y = TruncateMode.END_WITH_SPACING;
        } else {
            this.y = TruncateMode.NORMAL;
        }
        int integer = obtainStyledAttributes.getInteger(3, 3);
        this.n.mFontSize = (double) obtainStyledAttributes.getDimension(0, 16.0f);
        this.n.mLineGap = 1.2d;
        this.n.mParaSpacing = this.n.mLineGap - 1.0d;
        this.n.mTabStop = 4.0d;
        this.n.mIndent = 0.0d;
        this.n.mZhFontPath = j;
        this.n.mEnFontPath = k;
        this.n.mAlignType = a(integer);
        obtainStyledAttributes.recycle();
        setDrawingCacheEnabled(true);
        setWillNotDraw(false);
        setWillNotCacheDrawing(true);
    }

    public void setUseBitmapCache(boolean z) {
        if (this.C != z) {
            this.C = z;
            this.E.c();
            if (this.C) {
                this.E = new km();
                if (getWindowToken() != null) {
                    k();
                }
            } else {
                this.E = new kt();
                if (getWindowToken() != null) {
                    l();
                }
            }
            Scrollable scrollable;
            if (!this.C) {
                setUsePartialDraw(false);
                if (this.F != null) {
                    scrollable = (Scrollable) this.F.get();
                    if (scrollable != null) {
                        scrollable.a(this, false);
                    }
                }
            } else if (this.F != null) {
                scrollable = (Scrollable) this.F.get();
                if (scrollable != null) {
                    scrollable.a(this, true);
                }
            }
            invalidate();
        }
    }

    public void setUsePartialDraw(boolean z) {
        if (this.D != z) {
            if (z) {
                setUseBitmapCache(true);
            }
            this.D = z;
            invalidate();
        }
    }

    public void setEnTypefaceFile(File file) {
        if (file != null && !TextUtils.equals(file.getAbsolutePath(), this.n.mEnFontPath)) {
            try {
                this.p = Typeface.createFromFile(file.getAbsolutePath());
                this.n.mEnFontPath = file.getAbsolutePath();
                n();
                m();
                requestLayout();
                invalidate();
            } catch (Exception e) {
            }
        }
    }

    public void setText(int i) {
        setText(getResources().getString(i));
    }

    public void setText(String str) {
        this.r = str;
        this.s = null;
        n();
        m();
        requestLayout();
        invalidate();
    }

    public void setTextColor(int i) {
        this.t = i;
        m();
        invalidate();
    }

    public float getTextSize() {
        return (float) this.n.mFontSize;
    }

    public void setTextSize(int i) {
        this.n.mFontSize = (double) i;
        n();
        m();
        requestLayout();
        invalidate();
    }

    public void setEllipsize(TruncateAt truncateAt) {
        this.v = truncateAt == TruncateAt.MIDDLE ? TruncateAt.MIDDLE : TruncateAt.END;
        if (this.v == TruncateAt.MIDDLE) {
            this.y = TruncateMode.END_WITH_SPACING;
        } else {
            this.y = TruncateMode.NORMAL;
        }
        n();
        m();
        requestLayout();
        invalidate();
    }

    public void setDrawUnderLine(boolean z) {
        this.B = z;
    }

    public void setGravity(int i) {
        this.n.mAlignType = a(i);
        n();
        m();
        requestLayout();
        invalidate();
    }

    public double getFirstLineIndent() {
        return this.n.mIndent;
    }

    public void setFirstLineIndent(double d) {
        this.n.mIndent = d;
        n();
        m();
        requestLayout();
        invalidate();
    }

    public double getLineGap() {
        return this.n.mLineGap;
    }

    public void setLineGap(double d) {
        this.n.mLineGap = d;
        n();
        m();
        requestLayout();
        invalidate();
    }

    public double getParaSpacing() {
        return this.n.mParaSpacing;
    }

    public void setParaSpacing(double d) {
        this.n.mParaSpacing = d;
        n();
        m();
        requestLayout();
        invalidate();
    }

    public double getTabStop() {
        return this.n.mTabStop;
    }

    public void setTabStop(double d) {
        this.n.mTabStop = d;
        n();
        m();
        requestLayout();
        invalidate();
    }

    public void setMaxWidth(int i) {
        this.w = i;
        n();
        m();
        requestLayout();
        invalidate();
    }

    public boolean getChsToChtChars() {
        return this.x;
    }

    public void setChsToChtChars(boolean z) {
        this.x = z;
        this.s = null;
        n();
        m();
        requestLayout();
        invalidate();
    }

    public void setMaxLines(int i) {
        this.u = i;
        n();
        m();
        requestLayout();
        invalidate();
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
        n();
        m();
        requestLayout();
        invalidate();
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int size;
        DkBox renderBoxByLineCount;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int size2 = MeasureSpec.getMode(i) != 0 ? MeasureSpec.getSize(i) - paddingLeft : Integer.MAX_VALUE;
        if (this.w <= 0 || size2 <= this.w) {
            i3 = size2;
        } else {
            i3 = this.w;
        }
        if (MeasureSpec.getMode(i2) != 0) {
            size = MeasureSpec.getSize(i2) - paddingTop;
        } else {
            size = Integer.MAX_VALUE;
        }
        if (this.u < Integer.MAX_VALUE) {
            renderBoxByLineCount = g.getRenderBoxByLineCount(getRenderText(), this.n, (float) i3, this.u, false);
        } else {
            renderBoxByLineCount = g.getRenderBoxByHeight(getRenderText(), this.n, (float) i3, (float) size, false);
        }
        setMeasuredDimension(resolveSize((int) Math.ceil((double) Math.max((float) getSuggestedMinimumWidth(), (renderBoxByLineCount.mX1 - renderBoxByLineCount.mX0) + ((float) paddingLeft))), i), resolveSize((int) Math.ceil((double) Math.max((float) getSuggestedMinimumHeight(), (renderBoxByLineCount.mY1 - renderBoxByLineCount.mY0) + ((float) paddingTop))), i2));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z || this.q == null) {
            int paddingLeft = ((i3 - i) - getPaddingLeft()) - getPaddingRight();
            int paddingTop = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
            if (this.u < Integer.MAX_VALUE) {
                this.q = g.getRenderInfoByLineCount(getRenderText(), this.n, (float) paddingLeft, this.u, this.v == TruncateAt.END);
            } else {
                this.q = g.getRenderInfoByHeight(getRenderText(), this.n, (float) paddingLeft, (float) paddingTop, this.v == TruncateAt.END);
            }
            this.o.left = 0;
            this.o.right = i3 - i;
            this.o.top = 0;
            this.o.bottom = i4 - i2;
            this.A.left = this.o.right - 200;
            this.A.right = this.o.right;
            this.A.top = this.o.bottom - 10;
            this.A.bottom = this.o.bottom;
            if (this.q.mFollowAfter) {
                this.z = true;
            } else {
                this.z = false;
            }
            this.E.b();
            this.E.a();
            this.E.c();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    protected void onDraw(Canvas canvas) {
        if (this.q != null) {
            try {
                f = this;
                h.setAntiAlias(true);
                h.setSubpixelText(true);
                h.setTextAlign(Align.LEFT);
                h.setTextSize((float) this.n.mFontSize);
                h.setColor(this.t);
                int[] iArr = new int[2];
                a(iArr);
                a(this.I, iArr, getUserVisibleAreaHeight());
                if ((this.I.isEmpty() && this.E.d()) || !(this.I.isEmpty() || this.E.a(this.I))) {
                    this.E.a(getContext(), canvas, this.I);
                }
                this.E.a(canvas);
            } finally {
                f = null;
            }
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        ViewParent viewParent = null;
        while (parent != null) {
            if (!(parent instanceof Scrollable)) {
                if (parent == parent.getParent()) {
                    break;
                }
                viewParent = parent;
                parent = parent.getParent();
            } else {
                this.F = a((Scrollable) parent);
                if (this.F == null) {
                    this.F = new WeakReference((Scrollable) parent);
                }
                if (viewParent instanceof View) {
                    this.G = new WeakReference((View) viewParent);
                }
                if (this.C) {
                    ((Scrollable) this.F.get()).a(this, true);
                }
            }
        }
        if (this.C) {
            k();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.E.c();
        if (this.C) {
            l();
        }
        invalidate();
        if (this.F != null) {
            if (this.C) {
                Scrollable scrollable = (Scrollable) this.F.get();
                if (scrollable != null) {
                    scrollable.a(this, false);
                }
            }
            this.F = null;
            this.G = null;
        }
    }

    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0 && this.E != null) {
            this.E.c();
            invalidate();
        }
    }

    protected void finalize() {
        super.finalize();
        t.a(new kk(this));
    }

    private void k() {
        if (this.F != null) {
            ArrayList arrayList = (ArrayList) c.get(this.F);
            if (arrayList == null) {
                b.add(this.F);
                arrayList = new ArrayList();
                c.put(this.F, arrayList);
            }
            arrayList.add(new WeakReference(this));
            return;
        }
        d.add(new WeakReference(this));
    }

    private void l() {
        if (this.F != null) {
            j();
            ArrayList arrayList = (ArrayList) c.get(this.F);
            if (arrayList != null) {
                WeakReference a = a(this, arrayList);
                if (a != null) {
                    arrayList.remove(a);
                }
                if (arrayList.isEmpty()) {
                    c.remove(this.F);
                    b.remove(this.F);
                    return;
                }
                return;
            }
            return;
        }
        WeakReference a2 = a(this, d);
        if (a2 != null) {
            d.remove(a2);
        }
    }

    private void m() {
        if (this.E != null) {
            this.E.c();
        }
    }

    private void n() {
        this.q = null;
        if (this.E != null) {
            this.E.b();
        }
    }

    private String getRenderText() {
        String str = TextUtils.isEmpty(this.r) ? "" : this.r;
        if (!this.x) {
            return str;
        }
        if (this.s == null) {
            this.s = DkUtils.chs2chtText(str);
        }
        return this.s;
    }

    private int a(int i) {
        switch (i) {
            case 3:
                return 0;
            case 5:
                return 1;
            case 17:
                return 2;
            default:
                return 3;
        }
    }

    private Typeface getEnTypeface() {
        return this.p != null ? this.p : m;
    }

    private void a(Rect rect, int[] iArr, int i) {
        rect.top = this.o.top;
        rect.left = this.o.left;
        rect.bottom = this.o.bottom;
        rect.right = this.o.right;
        if (this.C && this.F != null && this.F.get() != null) {
            int i2 = iArr[1] + this.o.top;
            int i3 = iArr[1] + this.o.bottom;
            if (i2 >= i) {
                rect.top = 0;
                rect.bottom = 0;
            } else if (i3 <= 0) {
                rect.top = 0;
                rect.bottom = 0;
            } else if (this.D && this.o.height() > kq.g().b() * 2 && this.o.height() > i / 2) {
                if (i2 < 0) {
                    rect.top = iArr[1] * -1;
                    if (rect.top + i < this.o.bottom) {
                        rect.bottom = rect.top + i;
                    }
                } else if (i2 >= i) {
                    rect.bottom = rect.top + (i / 2);
                } else if (i - i2 <= rect.bottom - rect.top) {
                    rect.bottom = (rect.top + i) - i2;
                }
            }
        }
    }

    private void a(int[] iArr) {
        getLocationOnScreen(iArr);
        if (this.F != null) {
            Scrollable scrollable = (Scrollable) this.F.get();
            if (scrollable != null) {
                ((View) scrollable).getLocationOnScreen(this.J);
                iArr[0] = iArr[0] - this.J[0];
                iArr[1] = iArr[1] - this.J[1];
            }
        }
    }

    private int getUserVisibleAreaHeight() {
        int i = getResources().getDisplayMetrics().heightPixels;
        if (this.F != null) {
            View view = (View) this.F.get();
            if (view != null && view.getMeasuredHeight() < i) {
                return view.getMeasuredHeight();
            }
        }
        return i;
    }
}
