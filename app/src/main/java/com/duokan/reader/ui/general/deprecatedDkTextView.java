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
import com.duokan.core.sys.UThread;
import com.duokan.core.ui.Scrollable;
import com.duokan.kernel.DkBox;
import com.duokan.kernel.DkUtils;
import com.duokan.kernel.txtlib.DktLayoutOption;
import com.duokan.kernel.txtlib.DktRenderTextInfo;
import com.duokan.kernel.txtlib.DktRenderer;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.bitmap.BitmapsRecycler;
import com.duokan.reader.common.bitmap.C0544a;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

@Deprecated
public class deprecatedDkTextView extends View {
    /* renamed from: H */
    private static final int[] f7058H = new int[2];
    /* renamed from: a */
    static final /* synthetic */ boolean f7059a = (!deprecatedDkTextView.class.desiredAssertionStatus());
    /* renamed from: b */
    private static final ArrayList<WeakReference<Scrollable>> f7060b = new ArrayList();
    /* renamed from: c */
    private static final HashMap<WeakReference<Scrollable>, ArrayList<WeakReference<deprecatedDkTextView>>> f7061c = new HashMap();
    /* renamed from: d */
    private static final ArrayList<WeakReference<deprecatedDkTextView>> f7062d = new ArrayList();
    /* renamed from: e */
    private static BitmapsRecycler f7063e;
    /* renamed from: f */
    private static deprecatedDkTextView f7064f = null;
    /* renamed from: g */
    private static final DktRenderer f7065g = new DktRenderer();
    /* renamed from: h */
    private static final Paint f7066h = new Paint();
    /* renamed from: i */
    private static final Paint f7067i = new Paint();
    /* renamed from: j */
    private static String f7068j = null;
    /* renamed from: k */
    private static String f7069k = null;
    /* renamed from: l */
    private static Typeface f7070l = null;
    /* renamed from: m */
    private static Typeface f7071m = null;
    /* renamed from: A */
    private Rect f7072A;
    /* renamed from: B */
    private boolean f7073B;
    /* renamed from: C */
    private boolean f7074C;
    /* renamed from: D */
    private boolean f7075D;
    /* renamed from: E */
    private ke f7076E;
    /* renamed from: F */
    private WeakReference<Scrollable> f7077F;
    /* renamed from: G */
    private WeakReference<View> f7078G;
    /* renamed from: I */
    private final Rect f7079I;
    /* renamed from: J */
    private final int[] f7080J;
    /* renamed from: n */
    private final DktLayoutOption f7081n;
    /* renamed from: o */
    private final Rect f7082o;
    /* renamed from: p */
    private Typeface f7083p;
    /* renamed from: q */
    private DktRenderTextInfo f7084q;
    /* renamed from: r */
    private String f7085r;
    /* renamed from: s */
    private String f7086s;
    /* renamed from: t */
    private int f7087t;
    /* renamed from: u */
    private int f7088u;
    /* renamed from: v */
    private TruncateAt f7089v;
    /* renamed from: w */
    private int f7090w;
    /* renamed from: x */
    private boolean f7091x;
    /* renamed from: y */
    private TruncateMode f7092y;
    /* renamed from: z */
    private boolean f7093z;

    public enum TruncateMode {
        NORMAL,
        END_WITH_SPACING
    }

    /* renamed from: i */
    private static void m10457i() {
        UThread.runOnThread(new jt());
    }

    /* renamed from: m */
    private static void m10465m(deprecatedDkTextView deprecateddktextview) {
        if (deprecateddktextview.f7077F != null) {
            m10458j();
            int[] iArr = f7058H;
            ArrayList arrayList = (ArrayList) f7061c.get(deprecateddktextview.f7077F);
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    deprecatedDkTextView deprecateddktextview2 = (deprecatedDkTextView) ((WeakReference) it.next()).get();
                    if (!(deprecateddktextview2 == null || f7064f == deprecateddktextview2 || deprecateddktextview2 == deprecateddktextview || !deprecateddktextview2.f7076E.mo1809d())) {
                        int i;
                        int i2 = (deprecateddktextview2.getParent() == null || deprecateddktextview2.getVisibility() != 0) ? 0 : 1;
                        if (!(i2 == 0 || deprecateddktextview2.f7078G == null)) {
                            View view = (View) deprecateddktextview2.f7078G.get();
                            if (view != null) {
                                if (view.getParent() == null || view.getVisibility() != 0) {
                                    i = 0;
                                } else {
                                    i = 1;
                                }
                                if (i != 0) {
                                    ((jw) deprecateddktextview2.f7076E).mo1808c();
                                    deprecateddktextview2.invalidate();
                                } else {
                                    i = deprecateddktextview2.getUserVisibleAreaHeight();
                                    deprecateddktextview2.m10441a(iArr);
                                    i2 = iArr[1] + deprecateddktextview2.getMeasuredHeight();
                                    if (iArr[1] < i || i2 <= 0) {
                                        ((jw) deprecateddktextview2.f7076E).mo1808c();
                                        deprecateddktextview2.invalidate();
                                    }
                                }
                            }
                        }
                        i = i2;
                        if (i != 0) {
                            i = deprecateddktextview2.getUserVisibleAreaHeight();
                            deprecateddktextview2.m10441a(iArr);
                            i2 = iArr[1] + deprecateddktextview2.getMeasuredHeight();
                            if (iArr[1] < i) {
                            }
                            ((jw) deprecateddktextview2.f7076E).mo1808c();
                            deprecateddktextview2.invalidate();
                        } else {
                            ((jw) deprecateddktextview2.f7076E).mo1808c();
                            deprecateddktextview2.invalidate();
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static WeakReference<Scrollable> m10437a(Scrollable scrollable) {
        Iterator it = f7060b.iterator();
        while (it.hasNext()) {
            WeakReference<Scrollable> weakReference = (WeakReference) it.next();
            if (weakReference.get() == scrollable) {
                return weakReference;
            }
        }
        return null;
    }

    /* renamed from: a */
    private static WeakReference<deprecatedDkTextView> m10438a(deprecatedDkTextView deprecateddktextview, ArrayList<WeakReference<deprecatedDkTextView>> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            WeakReference<deprecatedDkTextView> weakReference = (WeakReference) it.next();
            if (weakReference.get() == deprecateddktextview) {
                return weakReference;
            }
        }
        return null;
    }

    /* renamed from: j */
    private static void m10458j() {
        Iterator it = f7060b.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (((Scrollable) weakReference.get()) == null) {
                it.remove();
                ArrayList arrayList = (ArrayList) f7061c.remove(weakReference);
                if (arrayList != null) {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        deprecatedDkTextView deprecateddktextview = (deprecatedDkTextView) ((WeakReference) it2.next()).get();
                        if (deprecateddktextview != null) {
                            deprecateddktextview.f7076E.mo1808c();
                        }
                    }
                    arrayList.clear();
                }
            }
        }
        Iterator it3 = f7062d.iterator();
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
        this.f7081n = new DktLayoutOption();
        this.f7082o = new Rect();
        this.f7083p = null;
        this.f7084q = null;
        this.f7085r = "";
        this.f7086s = null;
        this.f7087t = -16777216;
        this.f7088u = Integer.MAX_VALUE;
        this.f7089v = TruncateAt.END;
        this.f7090w = -1;
        this.f7091x = false;
        this.f7093z = false;
        this.f7072A = new Rect();
        this.f7073B = false;
        this.f7074C = false;
        this.f7075D = false;
        this.f7076E = new kd();
        this.f7077F = null;
        this.f7078G = null;
        this.f7079I = new Rect();
        this.f7080J = new int[2];
        if (f7068j == null) {
            f7068j = ReaderEnv.get().getSystemFontFileZh().getAbsolutePath();
            f7069k = ReaderEnv.get().getSystemFontFileEn().getAbsolutePath();
            try {
                f7070l = Typeface.createFromFile(f7068j);
            } catch (Throwable th) {
            }
            try {
                f7071m = Typeface.createFromFile(f7069k);
            } catch (Exception e) {
                f7071m = f7070l;
                f7069k = f7068j;
            }
        }
        ka.m10902a(context);
        if (f7063e == null) {
            f7063e = new jv();
            C0544a.m2441a(f7063e);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842901, 16842904, 16842923, 16842927, 16843087, 16843091});
        this.f7085r = obtainStyledAttributes.hasValue(4) ? obtainStyledAttributes.getString(4) : "";
        this.f7087t = obtainStyledAttributes.getColor(1, -16777216);
        switch (obtainStyledAttributes.getInt(2, 0)) {
            case 1:
            case 4:
                if (!f7059a) {
                    throw new AssertionError();
                }
                break;
            case 2:
                this.f7089v = TruncateAt.MIDDLE;
                break;
            default:
                this.f7089v = TruncateAt.END;
                break;
        }
        this.f7088u = obtainStyledAttributes.getInteger(5, Integer.MAX_VALUE);
        if (this.f7089v == TruncateAt.MIDDLE) {
            this.f7092y = TruncateMode.END_WITH_SPACING;
        } else {
            this.f7092y = TruncateMode.NORMAL;
        }
        int integer = obtainStyledAttributes.getInteger(3, 3);
        this.f7081n.mFontSize = (double) obtainStyledAttributes.getDimension(0, 16.0f);
        this.f7081n.mLineGap = 1.2d;
        this.f7081n.mParaSpacing = this.f7081n.mLineGap - 1.0d;
        this.f7081n.mTabStop = 4.0d;
        this.f7081n.mIndent = 0.0d;
        this.f7081n.mZhFontPath = f7068j;
        this.f7081n.mEnFontPath = f7069k;
        this.f7081n.mAlignType = m10435a(integer);
        obtainStyledAttributes.recycle();
        setDrawingCacheEnabled(true);
        setWillNotDraw(false);
        setWillNotCacheDrawing(true);
    }

    public void setUseBitmapCache(boolean z) {
        if (this.f7074C != z) {
            this.f7074C = z;
            this.f7076E.mo1808c();
            if (this.f7074C) {
                this.f7076E = new jw();
                if (getWindowToken() != null) {
                    m10461k();
                }
            } else {
                this.f7076E = new kd();
                if (getWindowToken() != null) {
                    m10463l();
                }
            }
            Scrollable scrollable;
            if (!this.f7074C) {
                setUsePartialDraw(false);
                if (this.f7077F != null) {
                    scrollable = (Scrollable) this.f7077F.get();
                    if (scrollable != null) {
                        scrollable.mo435a(this, false);
                    }
                }
            } else if (this.f7077F != null) {
                scrollable = (Scrollable) this.f7077F.get();
                if (scrollable != null) {
                    scrollable.mo435a(this, true);
                }
            }
            invalidate();
        }
    }

    public void setUsePartialDraw(boolean z) {
        if (this.f7075D != z) {
            if (z) {
                setUseBitmapCache(true);
            }
            this.f7075D = z;
            invalidate();
        }
    }

    public void setEnTypefaceFile(File file) {
        if (file != null && !TextUtils.equals(file.getAbsolutePath(), this.f7081n.mEnFontPath)) {
            try {
                this.f7083p = Typeface.createFromFile(file.getAbsolutePath());
                this.f7081n.mEnFontPath = file.getAbsolutePath();
                m10466n();
                m10464m();
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
        this.f7085r = str;
        this.f7086s = null;
        m10466n();
        m10464m();
        requestLayout();
        invalidate();
    }

    public void setTextColor(int i) {
        this.f7087t = i;
        m10464m();
        invalidate();
    }

    public float getTextSize() {
        return (float) this.f7081n.mFontSize;
    }

    public void setTextSize(int i) {
        this.f7081n.mFontSize = (double) i;
        m10466n();
        m10464m();
        requestLayout();
        invalidate();
    }

    public void setEllipsize(TruncateAt truncateAt) {
        this.f7089v = truncateAt == TruncateAt.MIDDLE ? TruncateAt.MIDDLE : TruncateAt.END;
        if (this.f7089v == TruncateAt.MIDDLE) {
            this.f7092y = TruncateMode.END_WITH_SPACING;
        } else {
            this.f7092y = TruncateMode.NORMAL;
        }
        m10466n();
        m10464m();
        requestLayout();
        invalidate();
    }

    public void setDrawUnderLine(boolean z) {
        this.f7073B = z;
    }

    public void setGravity(int i) {
        this.f7081n.mAlignType = m10435a(i);
        m10466n();
        m10464m();
        requestLayout();
        invalidate();
    }

    public double getFirstLineIndent() {
        return this.f7081n.mIndent;
    }

    public void setFirstLineIndent(double d) {
        this.f7081n.mIndent = d;
        m10466n();
        m10464m();
        requestLayout();
        invalidate();
    }

    public double getLineGap() {
        return this.f7081n.mLineGap;
    }

    public void setLineGap(double d) {
        this.f7081n.mLineGap = d;
        m10466n();
        m10464m();
        requestLayout();
        invalidate();
    }

    public double getParaSpacing() {
        return this.f7081n.mParaSpacing;
    }

    public void setParaSpacing(double d) {
        this.f7081n.mParaSpacing = d;
        m10466n();
        m10464m();
        requestLayout();
        invalidate();
    }

    public double getTabStop() {
        return this.f7081n.mTabStop;
    }

    public void setTabStop(double d) {
        this.f7081n.mTabStop = d;
        m10466n();
        m10464m();
        requestLayout();
        invalidate();
    }

    public void setMaxWidth(int i) {
        this.f7090w = i;
        m10466n();
        m10464m();
        requestLayout();
        invalidate();
    }

    public boolean getChsToChtChars() {
        return this.f7091x;
    }

    public void setChsToChtChars(boolean z) {
        this.f7091x = z;
        this.f7086s = null;
        m10466n();
        m10464m();
        requestLayout();
        invalidate();
    }

    public void setMaxLines(int i) {
        this.f7088u = i;
        m10466n();
        m10464m();
        requestLayout();
        invalidate();
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
        m10466n();
        m10464m();
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
        if (this.f7090w <= 0 || size2 <= this.f7090w) {
            i3 = size2;
        } else {
            i3 = this.f7090w;
        }
        if (MeasureSpec.getMode(i2) != 0) {
            size = MeasureSpec.getSize(i2) - paddingTop;
        } else {
            size = Integer.MAX_VALUE;
        }
        if (this.f7088u < Integer.MAX_VALUE) {
            renderBoxByLineCount = f7065g.getRenderBoxByLineCount(getRenderText(), this.f7081n, (float) i3, this.f7088u, false);
        } else {
            renderBoxByLineCount = f7065g.getRenderBoxByHeight(getRenderText(), this.f7081n, (float) i3, (float) size, false);
        }
        setMeasuredDimension(resolveSize((int) Math.ceil((double) Math.max((float) getSuggestedMinimumWidth(), (renderBoxByLineCount.mX1 - renderBoxByLineCount.mX0) + ((float) paddingLeft))), i), resolveSize((int) Math.ceil((double) Math.max((float) getSuggestedMinimumHeight(), (renderBoxByLineCount.mY1 - renderBoxByLineCount.mY0) + ((float) paddingTop))), i2));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z || this.f7084q == null) {
            int paddingLeft = ((i3 - i) - getPaddingLeft()) - getPaddingRight();
            int paddingTop = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
            if (this.f7088u < Integer.MAX_VALUE) {
                this.f7084q = f7065g.getRenderInfoByLineCount(getRenderText(), this.f7081n, (float) paddingLeft, this.f7088u, this.f7089v == TruncateAt.END);
            } else {
                this.f7084q = f7065g.getRenderInfoByHeight(getRenderText(), this.f7081n, (float) paddingLeft, (float) paddingTop, this.f7089v == TruncateAt.END);
            }
            this.f7082o.left = 0;
            this.f7082o.right = i3 - i;
            this.f7082o.top = 0;
            this.f7082o.bottom = i4 - i2;
            this.f7072A.left = this.f7082o.right - 200;
            this.f7072A.right = this.f7082o.right;
            this.f7072A.top = this.f7082o.bottom - 10;
            this.f7072A.bottom = this.f7082o.bottom;
            if (this.f7084q.mFollowAfter) {
                this.f7093z = true;
            } else {
                this.f7093z = false;
            }
            this.f7076E.mo1807b();
            this.f7076E.mo1803a();
            this.f7076E.mo1808c();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    protected void onDraw(Canvas canvas) {
        if (this.f7084q != null) {
            try {
                f7064f = this;
                f7066h.setAntiAlias(true);
                f7066h.setSubpixelText(true);
                f7066h.setTextAlign(Align.LEFT);
                f7066h.setTextSize((float) this.f7081n.mFontSize);
                f7066h.setColor(this.f7087t);
                int[] iArr = new int[2];
                m10441a(iArr);
                m10440a(this.f7079I, iArr, getUserVisibleAreaHeight());
                if ((this.f7079I.isEmpty() && this.f7076E.mo1809d()) || !(this.f7079I.isEmpty() || this.f7076E.mo1806a(this.f7079I))) {
                    this.f7076E.mo1804a(getContext(), canvas, this.f7079I);
                }
                this.f7076E.mo1805a(canvas);
            } finally {
                f7064f = null;
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
                this.f7077F = m10437a((Scrollable) parent);
                if (this.f7077F == null) {
                    this.f7077F = new WeakReference((Scrollable) parent);
                }
                if (viewParent instanceof View) {
                    this.f7078G = new WeakReference((View) viewParent);
                }
                if (this.f7074C) {
                    ((Scrollable) this.f7077F.get()).mo435a(this, true);
                }
            }
        }
        if (this.f7074C) {
            m10461k();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f7076E.mo1808c();
        if (this.f7074C) {
            m10463l();
        }
        invalidate();
        if (this.f7077F != null) {
            if (this.f7074C) {
                Scrollable scrollable = (Scrollable) this.f7077F.get();
                if (scrollable != null) {
                    scrollable.mo435a(this, false);
                }
            }
            this.f7077F = null;
            this.f7078G = null;
        }
    }

    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0 && this.f7076E != null) {
            this.f7076E.mo1808c();
            invalidate();
        }
    }

    protected void finalize() {
        super.finalize();
        UThread.runOnThread(new ju(this));
    }

    /* renamed from: k */
    private void m10461k() {
        if (this.f7077F != null) {
            ArrayList arrayList = (ArrayList) f7061c.get(this.f7077F);
            if (arrayList == null) {
                f7060b.add(this.f7077F);
                arrayList = new ArrayList();
                f7061c.put(this.f7077F, arrayList);
            }
            arrayList.add(new WeakReference(this));
            return;
        }
        f7062d.add(new WeakReference(this));
    }

    /* renamed from: l */
    private void m10463l() {
        if (this.f7077F != null) {
            m10458j();
            ArrayList arrayList = (ArrayList) f7061c.get(this.f7077F);
            if (arrayList != null) {
                WeakReference a = m10438a(this, arrayList);
                if (a != null) {
                    arrayList.remove(a);
                }
                if (arrayList.isEmpty()) {
                    f7061c.remove(this.f7077F);
                    f7060b.remove(this.f7077F);
                    return;
                }
                return;
            }
            return;
        }
        WeakReference a2 = m10438a(this, f7062d);
        if (a2 != null) {
            f7062d.remove(a2);
        }
    }

    /* renamed from: m */
    private void m10464m() {
        if (this.f7076E != null) {
            this.f7076E.mo1808c();
        }
    }

    /* renamed from: n */
    private void m10466n() {
        this.f7084q = null;
        if (this.f7076E != null) {
            this.f7076E.mo1807b();
        }
    }

    private String getRenderText() {
        String str = TextUtils.isEmpty(this.f7085r) ? "" : this.f7085r;
        if (!this.f7091x) {
            return str;
        }
        if (this.f7086s == null) {
            this.f7086s = DkUtils.chs2chtText(str);
        }
        return this.f7086s;
    }

    /* renamed from: a */
    private int m10435a(int i) {
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
        return this.f7083p != null ? this.f7083p : f7071m;
    }

    /* renamed from: a */
    private void m10440a(Rect rect, int[] iArr, int i) {
        rect.top = this.f7082o.top;
        rect.left = this.f7082o.left;
        rect.bottom = this.f7082o.bottom;
        rect.right = this.f7082o.right;
        if (this.f7074C && this.f7077F != null && this.f7077F.get() != null) {
            int i2 = iArr[1] + this.f7082o.top;
            int i3 = iArr[1] + this.f7082o.bottom;
            if (i2 >= i) {
                rect.top = 0;
                rect.bottom = 0;
            } else if (i3 <= 0) {
                rect.top = 0;
                rect.bottom = 0;
            } else if (this.f7075D && this.f7082o.height() > ka.m10910g().m10915b() * 2 && this.f7082o.height() > i / 2) {
                if (i2 < 0) {
                    rect.top = iArr[1] * -1;
                    if (rect.top + i < this.f7082o.bottom) {
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

    /* renamed from: a */
    private void m10441a(int[] iArr) {
        getLocationOnScreen(iArr);
        if (this.f7077F != null) {
            Scrollable scrollable = (Scrollable) this.f7077F.get();
            if (scrollable != null) {
                ((View) scrollable).getLocationOnScreen(this.f7080J);
                iArr[0] = iArr[0] - this.f7080J[0];
                iArr[1] = iArr[1] - this.f7080J[1];
            }
        }
    }

    private int getUserVisibleAreaHeight() {
        int i = getResources().getDisplayMetrics().heightPixels;
        if (this.f7077F != null) {
            View view = (View) this.f7077F.get();
            if (view != null && view.getMeasuredHeight() < i) {
                return view.getMeasuredHeight();
            }
        }
        return i;
    }
}
