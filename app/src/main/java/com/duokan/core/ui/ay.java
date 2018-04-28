package com.duokan.core.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import com.duokan.core.sys.UThread;
import com.umeng.analytics.pro.C2295j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public abstract class ay extends ViewGroup implements OnPreDrawListener, Scrollable, ax {
    /* renamed from: c */
    static final /* synthetic */ boolean f758c = (!ay.class.desiredAssertionStatus());
    /* renamed from: A */
    private int f759A = -1;
    /* renamed from: B */
    private int f760B = -1;
    /* renamed from: C */
    private Runnable f761C = null;
    /* renamed from: D */
    private Runnable f762D = null;
    /* renamed from: E */
    private bf f763E = null;
    /* renamed from: F */
    private bg f764F = null;
    /* renamed from: a */
    private final bh f765a = mo489b();
    /* renamed from: b */
    private final ArrayList<bc> f766b = new ArrayList();
    /* renamed from: d */
    private final LinkedList<bc> f767d = new LinkedList();
    /* renamed from: e */
    private final HashSet<Integer> f768e = new HashSet();
    /* renamed from: f */
    private final Rect f769f = new Rect();
    /* renamed from: g */
    private final Rect f770g = new Rect();
    /* renamed from: h */
    private final Rect f771h = new Rect();
    /* renamed from: i */
    private Drawable f772i = null;
    /* renamed from: j */
    private int f773j = 0;
    /* renamed from: k */
    private boolean f774k = true;
    /* renamed from: l */
    private boolean f775l = true;
    /* renamed from: m */
    private boolean f776m = true;
    /* renamed from: n */
    private boolean f777n = false;
    /* renamed from: o */
    private int f778o = MeasureSpec.makeMeasureSpec(0, 0);
    /* renamed from: p */
    private int f779p = MeasureSpec.makeMeasureSpec(0, 0);
    /* renamed from: q */
    private View f780q = null;
    /* renamed from: r */
    private boolean f781r = false;
    /* renamed from: s */
    private int f782s = 0;
    /* renamed from: t */
    private int f783t = 0;
    /* renamed from: u */
    private int f784u = -1;
    /* renamed from: v */
    private int f785v = -1;
    /* renamed from: w */
    private int[] f786w = new int[0];
    /* renamed from: x */
    private int[] f787x = new int[0];
    /* renamed from: y */
    private ScrollState f788y = ScrollState.IDLE;
    /* renamed from: z */
    private av f789z = null;

    /* renamed from: a */
    protected abstract int mo446a(int i, int i2);

    /* renamed from: a */
    protected abstract int mo447a(Point point);

    /* renamed from: a */
    protected abstract void mo448a();

    /* renamed from: a */
    protected abstract int[] mo450a(Rect rect);

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m1142g();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m1106a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return m1107a(layoutParams);
    }

    public ay(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f765a.m1496a(new AccelerateDecelerateInterpolator());
        setWillNotDraw(false);
        setClipChildren(false);
        setStaticTransformationsEnabled(true);
    }

    public final void setOnItemClickListener(bf bfVar) {
        this.f763E = bfVar;
    }

    public final void setOnItemLongPressListener(bg bgVar) {
        this.f764F = bgVar;
    }

    public final av getAdapter() {
        return this.f789z;
    }

    public final void setAdapter(av avVar) {
        if (this.f789z != null) {
            this.f789z.mo484b(this);
        }
        this.f789z = avVar;
        if (this.f789z != null) {
            this.f789z.mo483a(this);
        }
        m1147i();
    }

    public final Drawable getItemsBackground() {
        return this.f772i;
    }

    public final void setItemsBackground(int i) {
        setItemsBackground(getResources().getDrawable(i));
    }

    public final void setItemsBackground(Drawable drawable) {
        if (this.f772i != drawable) {
            this.f772i = drawable;
            int i = this.f769f.left;
            int i2 = this.f769f.top;
            int i3 = this.f769f.right;
            int i4 = this.f769f.bottom;
            if (this.f772i == null) {
                this.f769f.setEmpty();
            } else {
                this.f772i.getPadding(this.f769f);
            }
            if (this.f769f.left != i || this.f769f.top != i2 || this.f769f.right != i3 || this.f769f.bottom != i4) {
                m1147i();
            }
        }
    }

    public final int getItemCount() {
        return this.f773j;
    }

    /* renamed from: g */
    public final View m1141g(int i) {
        m1155l();
        return m1163r(i).f995c;
    }

    public final View[] getItemViews() {
        m1155l();
        View[] viewArr = new View[this.f767d.size()];
        for (int i = 0; i < viewArr.length; i++) {
            viewArr[i] = ((bc) this.f767d.get(i)).f995c;
        }
        return viewArr;
    }

    public final View[] getOrderedItemViews() {
        ArrayList arrayList = new ArrayList(this.f767d.size());
        Iterator it = this.f767d.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((bc) it.next()).f993a));
        }
        Collections.sort(arrayList, new az(this));
        m1155l();
        View[] viewArr = new View[arrayList.size()];
        for (int i = 0; i < viewArr.length; i++) {
            viewArr[i] = ((bc) this.f766b.get(((Integer) arrayList.get(i)).intValue())).f995c;
        }
        return viewArr;
    }

    public final View[] getVisibleItemViews() {
        int[] visibleItemIndices = getVisibleItemIndices();
        View[] viewArr = new View[visibleItemIndices.length];
        for (int i = 0; i < visibleItemIndices.length; i++) {
            viewArr[i] = m1141g(visibleItemIndices[i]);
        }
        return viewArr;
    }

    public final int[] getVisibleItemIndices() {
        m1155l();
        return this.f786w;
    }

    public final int getFirstVisibleItemIndex() {
        m1155l();
        return this.f786w.length > 0 ? this.f786w[0] : -1;
    }

    public final int getLastVisibleItemIndex() {
        m1155l();
        return this.f786w.length > 0 ? this.f786w[this.f786w.length - 1] : -1;
    }

    public final int getVisibleItemCount() {
        m1155l();
        return this.f786w.length;
    }

    public final Rect getPreviewExtents() {
        return this.f770g;
    }

    public final Rect getPreviewBounds() {
        this.f771h.set(getViewportBounds());
        Rect rect = this.f771h;
        rect.left -= this.f770g.left;
        rect = this.f771h;
        rect.top -= this.f770g.top;
        rect = this.f771h;
        rect.right += this.f770g.right;
        rect = this.f771h;
        rect.bottom += this.f770g.bottom;
        return this.f771h;
    }

    /* renamed from: a */
    public final void m1111a(int i, int i2, int i3, int i4) {
        this.f770g.set(i, i2, i3, i4);
        m1152k();
    }

    /* renamed from: h */
    public final Rect m1144h(int i) {
        boolean a = m1119a(i, true);
        m1155l();
        bc r = m1163r(i);
        View a2 = r.f995c;
        Rect rect = new Rect();
        if (a2 != null) {
            rect.set(a2.getLeft(), a2.getTop(), a2.getRight(), a2.getBottom());
            rect.offset(r.f1000h, r.f1001i);
            rect.offset(-r.f994b.getScrollX(), -r.f994b.getScrollY());
            m1119a(i, a);
        }
        return rect;
    }

    /* renamed from: e */
    public final int m1137e(int i, int i2) {
        m1155l();
        Point point = new Point(i, i2);
        m1129c(point);
        return mo447a(point);
    }

    /* renamed from: b */
    public final int[] m1128b(Rect rect) {
        m1155l();
        Rect rect2 = new Rect(rect);
        m1130c(rect2);
        return mo450a(rect2);
    }

    /* renamed from: a */
    public final boolean m1119a(int i, boolean z) {
        bc r = m1163r(i);
        boolean c = r.m1668c();
        if (r.m1668c() != z) {
            r.m1667c(z);
            if (z) {
                m1078b(i, true);
            } else if (r.f1008p == null) {
                m1078b(i, false);
            }
        }
        return c;
    }

    /* renamed from: b */
    public final void m1123b(int i, int i2, int i3) {
        bc r = m1163r(i);
        r.m1662a(i2, i3);
        if (r.f1008p != null) {
            m1078b(i, true);
        } else if (!r.m1668c()) {
            m1078b(i, false);
        }
        m1155l();
    }

    /* renamed from: a */
    public final void m1109a(int i, float f) {
        bc r = m1163r(i);
        r.m1661a(f);
        if (r.f1008p != null) {
            m1078b(i, true);
        } else if (!r.m1668c()) {
            m1078b(i, false);
        }
        m1155l();
    }

    /* renamed from: i */
    public final void m1148i(int i) {
        m1155l();
        if (m1164s(i) && !getViewportBounds().isEmpty() && getContentWidth() != 0 && getContentHeight() != 0 && !m1151j(i)) {
            Rect h = m1144h(i);
            if (!h.isEmpty()) {
                scrollTo(h.left, h.top);
                m1138e();
            }
        }
    }

    /* renamed from: b */
    public final void m1126b(int i, Rect rect, int i2) {
        m1155l();
        if (m1164s(i) && !rect.isEmpty() && rect.width() != 0 && rect.height() != 0) {
            Rect h = m1144h(i);
            if (!h.isEmpty()) {
                Rect rect2 = (Rect) dv.f1198g.addAnimation();
                Gravity.apply(i2, h.width(), h.height(), m1130c(rect), rect2);
                scrollBy(h.left - rect2.left, h.top - rect2.top);
                dv.f1198g.clearAnimation(rect2);
                m1138e();
            }
        }
    }

    /* renamed from: j */
    public final boolean m1151j(int i) {
        m1155l();
        if (m1164s(i)) {
            return m1163r(i).m1670d();
        }
        return false;
    }

    public final int getContentWidth() {
        return this.f765a.m1561s();
    }

    public final int getContentHeight() {
        return this.f765a.m1562t();
    }

    public final boolean getThumbEnabled() {
        return this.f765a.m1563u();
    }

    public final void setThumbEnabled(boolean z) {
        this.f765a.m1530c(z);
    }

    public boolean getSeekEnabled() {
        return this.f765a.m1564v();
    }

    public void setSeekEnabled(boolean z) {
        this.f765a.m1538d(z);
    }

    /* renamed from: a */
    public void m1117a(boolean z) {
        this.f765a.m1543e(z);
    }

    public int getHorizontalThumbMarginLeft() {
        return this.f765a.m1565w();
    }

    public int getHorizontalThumbMarginTop() {
        return this.f765a.m1566x();
    }

    public int getHorizontalThumbMarginRight() {
        return this.f765a.m1567y();
    }

    public int getHorizontalThumbMarginBottom() {
        return this.f765a.m1568z();
    }

    public int getVerticalThumbMarginLeft() {
        return this.f765a.m1449A();
    }

    public int getVerticalThumbMarginTop() {
        return this.f765a.m1450B();
    }

    public int getVerticalThumbMarginRight() {
        return this.f765a.m1451C();
    }

    public int getVerticalThumbMarginBottom() {
        return this.f765a.m1452D();
    }

    /* renamed from: b */
    public void m1124b(int i, int i2, int i3, int i4) {
        this.f765a.m1513b(i, i2, i3, i4);
    }

    public Drawable getHorizontalThumbDrawable() {
        return this.f765a.m1453E();
    }

    public void setHorizontalThumbDrawable(Drawable drawable) {
        this.f765a.m1493a(drawable);
    }

    public Drawable getVerticalThumbDrawable() {
        return this.f765a.m1454F();
    }

    public void setVerticalThumbDrawable(Drawable drawable) {
        this.f765a.m1517b(drawable);
    }

    public Drawable getHorizontalSeekDrawable() {
        return this.f765a.m1455G();
    }

    public void setHorizontalSeekDrawable(Drawable drawable) {
        this.f765a.m1529c(drawable);
    }

    public Drawable getVerticalSeekDrawable() {
        return this.f765a.m1456H();
    }

    public void setVerticalSeekDrawable(Drawable drawable) {
        this.f765a.m1537d(drawable);
    }

    public et getScrollDetector() {
        return this.f765a.m1457I();
    }

    public final ScrollState getScrollState() {
        return this.f765a.getScrollState();
    }

    public final int getIdleTime() {
        return this.f765a.getIdleTime();
    }

    public final int getScrollTime() {
        return this.f765a.m1458J();
    }

    public int getScrollFinalX() {
        return this.f765a.m1459K();
    }

    public int getScrollFinalY() {
        return this.f765a.m1460L();
    }

    public final void setScrollInterpolator(Interpolator interpolator) {
        this.f765a.m1496a(interpolator);
    }

    /* renamed from: a */
    public final void mo435a(View view, boolean z) {
        this.f765a.mo435a(view, z);
    }

    public OverScrollMode getHorizontalOverScrollMode() {
        return this.f765a.m1461M();
    }

    public void setHorizontalOverScrollMode(OverScrollMode overScrollMode) {
        this.f765a.m1497a(overScrollMode);
    }

    public OverScrollMode getVerticalOverScrollMode() {
        return this.f765a.m1462N();
    }

    public void setVerticalOverScrollMode(OverScrollMode overScrollMode) {
        this.f765a.m1518b(overScrollMode);
    }

    public final int getMaxOverScrollWidth() {
        return this.f765a.m1463O();
    }

    public final void setMaxOverScrollWidth(int i) {
        this.f765a.m1525c(i);
    }

    public final int getMaxOverScrollHeight() {
        return this.f765a.getMaxOverScrollHeight();
    }

    public final void setMaxOverScrollHeight(int i) {
        this.f765a.m1534d(i);
    }

    public final Rect getViewportBounds() {
        return this.f765a.getViewportBounds();
    }

    public void setOnContentBoundsChangedListener(cf cfVar) {
        this.f765a.m1501a(cfVar);
    }

    public final void setOnScrollListener(cg cgVar) {
        this.f765a.m1502a(cgVar);
    }

    /* renamed from: c */
    public final boolean m1132c() {
        return this.f765a.m1471W();
    }

    /* renamed from: d */
    public final boolean m1135d() {
        return this.f765a.m1472X();
    }

    /* renamed from: a */
    public final void mo434a(int i, int i2, int i3, Runnable runnable, Runnable runnable2) {
        this.f765a.mo434a(i, i2, i3, runnable, runnable2);
    }

    /* renamed from: b */
    public final void m1125b(int i, int i2, int i3, Runnable runnable, Runnable runnable2) {
        this.f765a.m1514b(i, i2, i3, runnable, runnable2);
    }

    /* renamed from: f */
    public final void m1140f(int i, int i2) {
        this.f765a.m1541e(i, i2);
    }

    /* renamed from: e */
    public final void m1138e() {
        this.f765a.m1473Y();
    }

    /* renamed from: f */
    public final void m1139f() {
        this.f765a.m1474Z();
    }

    /* renamed from: a */
    public void m1115a(Rect rect, Rect rect2, int i, Runnable runnable, Runnable runnable2) {
        this.f765a.m1492a(rect, rect2, i, runnable, runnable2);
    }

    /* renamed from: b */
    public final Point m1121b(Point point) {
        return this.f765a.m1477a(point);
    }

    /* renamed from: c */
    public final Point m1129c(Point point) {
        return this.f765a.m1508b(point);
    }

    /* renamed from: c */
    public final Rect m1130c(Rect rect) {
        return this.f765a.m1509b(rect);
    }

    public void a_(int i, int i2) {
        m1093j(i, i2);
        m1155l();
        m1138e();
    }

    public void b_(int i, int i2) {
        m1094k(i, i2);
        m1155l();
        m1138e();
    }

    /* renamed from: a */
    public void mo440a(int i, int i2, int i3) {
        m1080c(i, i2, i3);
        m1155l();
        m1138e();
    }

    /* renamed from: d */
    public void mo444d(int i, int i2) {
        m1095l(i, i2);
        m1155l();
        m1138e();
    }

    public void a_(int i) {
        mo451b(i);
        m1155l();
        m1138e();
    }

    public boolean onPreDraw() {
        m1155l();
        int i = this.f784u >= 0 ? this.f784u : this.f782s;
        int i2 = this.f785v >= 0 ? this.f785v : this.f783t;
        this.f784u = this.f782s;
        this.f785v = this.f783t;
        LayoutParams layoutParams = getLayoutParams();
        if ((layoutParams.width != -2 || this.f782s == i) && (layoutParams.height != -2 || this.f783t == i2)) {
            return true;
        }
        m1145h();
        return false;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnPreDrawListener(this);
        this.f765a.m1523c();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnPreDrawListener(this);
        this.f765a.m1532d();
        this.f761C = null;
        this.f762D = null;
        this.f759A = -1;
        this.f760B = -1;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f765a.mo2419b(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f765a.mo2420c(motionEvent);
    }

    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
        this.f765a.mo529b(canvas);
        mo490d(canvas);
    }

    protected void onMeasure(int i, int i2) {
        if (!(this.f778o == i && this.f779p == i2)) {
            this.f778o = i;
            this.f779p = i2;
            m1147i();
        }
        int i3 = this.f782s;
        i3 = this.f783t;
        m1155l();
        int mode = MeasureSpec.getMode(this.f778o);
        int size = MeasureSpec.getSize(this.f778o);
        int mode2 = MeasureSpec.getMode(this.f779p);
        i3 = MeasureSpec.getSize(this.f779p);
        if (mode != 1073741824) {
            if (mode == Integer.MIN_VALUE) {
                size = Math.min(this.f782s, size);
            } else {
                size = this.f782s;
            }
        }
        if (mode2 != 1073741824) {
            if (mode2 == Integer.MIN_VALUE) {
                i3 = Math.min(this.f783t, i3);
            } else {
                i3 = this.f783t;
            }
        }
        setMeasuredDimension(size, i3);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f765a.m1504a(z, i, i2, i3, i4);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        if (i != getPaddingLeft() || i2 != getPaddingTop() || i3 != getPaddingRight() || i4 != getPaddingBottom()) {
            super.setPadding(i, i2, i3, i4);
            m1147i();
        }
    }

    protected boolean getChildStaticTransformation(View view, Transformation transformation) {
        if (!(view instanceof bd)) {
            return false;
        }
        Transformation f = ((bd) view).f1010b.f1008p;
        if (f == null || (f.getTransformationType() & 1) != 1) {
            return false;
        }
        transformation.clear();
        transformation.setAlpha(f.getAlpha());
        transformation.setTransformationType(1);
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.f765a.m1520b(z);
    }

    public boolean isHorizontalFadingEdgeEnabled() {
        return this.f765a.m1548g();
    }

    public boolean isHorizontalScrollBarEnabled() {
        return this.f765a.m1550h();
    }

    public boolean isVerticalFadingEdgeEnabled() {
        return this.f765a.m1551i();
    }

    public boolean isVerticalScrollBarEnabled() {
        return this.f765a.m1552j();
    }

    public void scrollBy(int i, int i2) {
        this.f765a.m1526c(i, i2);
    }

    public void scrollTo(int i, int i2) {
        this.f765a.m1535d(i, i2);
    }

    public boolean shouldDelayChildPressedState() {
        return this.f765a.m1554l();
    }

    protected int computeHorizontalScrollExtent() {
        return this.f765a.m1555m();
    }

    protected int computeHorizontalScrollOffset() {
        return this.f765a.m1556n();
    }

    protected int computeHorizontalScrollRange() {
        return this.f765a.m1557o();
    }

    protected int computeVerticalScrollExtent() {
        return this.f765a.m1558p();
    }

    protected int computeVerticalScrollOffset() {
        return this.f765a.m1559q();
    }

    protected int computeVerticalScrollRange() {
        return this.f765a.m1560r();
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        if (!(view instanceof bd)) {
            return super.drawChild(canvas, view, j);
        }
        Transformation f = ((bd) view).f1010b.f1008p;
        if (f == null || (f.getTransformationType() & 2) != 2) {
            return super.drawChild(canvas, view, j);
        }
        canvas.save();
        canvas.concat(f.getMatrix());
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restore();
        return drawChild;
    }

    public void forceLayout() {
        super.forceLayout();
        m1147i();
    }

    public void requestLayout() {
        super.requestLayout();
        m1147i();
    }

    /* renamed from: a */
    public be m1106a(AttributeSet attributeSet) {
        return new be(getContext(), attributeSet);
    }

    /* renamed from: g */
    protected be m1142g() {
        return new be(-1, -2);
    }

    /* renamed from: a */
    protected be m1107a(LayoutParams layoutParams) {
        return layoutParams instanceof MarginLayoutParams ? new be((MarginLayoutParams) layoutParams) : new be(layoutParams);
    }

    /* renamed from: a */
    protected void mo449a(Canvas canvas) {
        if (this.f773j > 0 && this.f772i != null) {
            Rect k = this.f765a.m1553k();
            this.f772i.setBounds(k.left + getPaddingLeft(), k.top + getPaddingTop(), k.right - getPaddingRight(), k.bottom - getPaddingBottom());
            this.f772i.draw(canvas);
        }
    }

    /* renamed from: b */
    protected void mo452b(Canvas canvas) {
    }

    /* renamed from: d */
    protected boolean mo490d(Canvas canvas) {
        boolean f = this.f765a.m1546f();
        this.f765a.m1527c(canvas);
        return f;
    }

    /* renamed from: b */
    protected bh mo489b() {
        return new bh(this);
    }

    /* renamed from: o */
    private final void mo1756o() {
        this.f761C = null;
        this.f762D = null;
        if (this.f760B >= 0) {
            bc r = m1163r(this.f760B);
            if (r.f994b != null) {
                r.f994b.setPressed(false);
            }
            this.f760B = -1;
        }
    }

    /* renamed from: p */
    private final boolean mo1757p() {
        return this.f761C != null || this.f760B >= 0;
    }

    /* renamed from: a */
    private final void mo445a(int i) {
        if (f758c || this.f761C == null) {
            this.f761C = new ba(this, i);
            UThread.postDelayed(this.f761C, (long) dv.getTapTimeout());
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    private final void m1073a(Runnable runnable) {
        if (f758c || this.f762D == null) {
            if (this.f761C != null) {
                this.f761C.run();
                this.f761C = null;
            }
            if (!f758c && this.f760B < 0) {
                throw new AssertionError();
            } else if (this.f760B >= 0) {
                this.f762D = new bb(this, runnable);
                UThread.postDelayed(this.f762D, (long) dv.getPressedStateDuration());
                return;
            } else {
                return;
            }
        }
        throw new AssertionError();
    }

    /* renamed from: j */
    private final void m1093j(int i, int i2) {
        if (i2 > 0) {
            mo1756o();
            this.f759A = -1;
            this.f773j += i2;
            bc[] bcVarArr = new bc[i2];
            for (int i3 = 0; i3 < bcVarArr.length; i3++) {
                bcVarArr[i3] = new bc(i + i3);
            }
            this.f766b.addAll(i, Arrays.asList(bcVarArr));
            m1147i();
        }
    }

    /* renamed from: k */
    private final void m1094k(int i, int i2) {
        if (i2 > 0) {
            mo1756o();
            this.f759A = -1;
            m1085d(i, i2, this.f766b.size() - i2);
            m1150j();
        }
    }

    /* renamed from: c */
    private final void m1080c(int i, int i2, int i3) {
        if (i2 > 0 && i != i3) {
            mo1756o();
            this.f759A = -1;
            m1085d(i, i2, i3);
            m1147i();
        }
    }

    /* renamed from: l */
    private final void m1095l(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            bc r = m1163r(i3);
            r.m1663a(true);
            r.f998f = -1;
            r.f999g = -1;
        }
        m1147i();
    }

    /* renamed from: b */
    private final void mo451b(int i) {
        mo1756o();
        this.f759A = -1;
        this.f773j = i;
        this.f766b.ensureCapacity(this.f773j);
        for (int i2 = 0; i2 < this.f773j; i2++) {
            if (i2 < this.f766b.size()) {
                bc r = m1163r(i2);
                r.m1663a(true);
                r.f998f = -1;
                r.f999g = -1;
            } else {
                this.f766b.add(new bc(i2));
            }
        }
        m1147i();
    }

    /* renamed from: d */
    private final void m1085d(int i, int i2, int i3) {
        int i4 = 0;
        if (i != i3) {
            bc[] bcVarArr = (bc[]) this.f766b.subList(i, i + i2).toArray(new bc[0]);
            int i5;
            int min;
            if (i < i3) {
                i5 = i + i2;
                min = Math.min(i3 + i2, this.f766b.size());
                while (i5 < min) {
                    this.f766b.set(i, this.f766b.get(i5));
                    i5++;
                    i++;
                }
                i5 = min - i2;
                while (i4 < bcVarArr.length) {
                    this.f766b.set(i5, bcVarArr[i4]);
                    i4++;
                    i5++;
                }
            } else {
                min = i - 1;
                i5 = (i + i2) - 1;
                while (min >= i3) {
                    this.f766b.set(i5, this.f766b.get(min));
                    min--;
                    i5--;
                }
                while (i4 < bcVarArr.length) {
                    this.f766b.set(i3, bcVarArr[i4]);
                    i4++;
                    i3++;
                }
            }
            mo1758q();
        }
    }

    /* renamed from: q */
    private final void mo1758q() {
        int size = this.f766b.size();
        for (int i = 0; i < size; i++) {
            ((bc) this.f766b.get(i)).f993a = i;
        }
    }

    /* renamed from: h */
    protected final void m1145h() {
        super.requestLayout();
    }

    /* renamed from: i */
    protected final void m1147i() {
        if (this.f776m) {
            this.f776m = false;
            m1150j();
        }
    }

    /* renamed from: j */
    protected final void m1150j() {
        if (this.f775l) {
            this.f775l = false;
            m1152k();
        }
    }

    /* renamed from: k */
    protected final void m1152k() {
        if (this.f774k) {
            this.f774k = false;
            invalidate();
        }
    }

    /* renamed from: l */
    protected final void m1155l() {
        if (!this.f777n && !this.f774k) {
            Iterator it;
            this.f777n = true;
            while (true) {
                int intValue;
                m1100s();
                m1099r();
                it = this.f768e.iterator();
                while (it.hasNext()) {
                    intValue = ((Integer) it.next()).intValue();
                    if (intValue >= 0 && intValue < this.f773j) {
                        mo453d(intValue);
                    }
                }
                for (int i : this.f786w) {
                    if (!this.f768e.contains(Integer.valueOf(i))) {
                        mo453d(i);
                    }
                }
                for (int i2 : this.f787x) {
                    if (!this.f768e.contains(Integer.valueOf(i2))) {
                        mo453d(i2);
                    }
                }
                this.f774k = true;
                if (this.f776m && this.f775l && this.f774k) {
                    break;
                }
            }
            it = this.f767d.iterator();
            while (it.hasNext()) {
                bc bcVar = (bc) it.next();
                if (!f758c && bcVar.f994b == null) {
                    throw new AssertionError();
                } else if (!(bcVar.m1670d() || bcVar.m1672e() || bcVar.f994b.getVisibility() != 0)) {
                    bcVar.f994b.setVisibility(4);
                }
            }
            this.f777n = false;
        }
    }

    /* renamed from: m */
    protected final int[] m1157m() {
        return this.f786w;
    }

    /* renamed from: r */
    private final void m1099r() {
        int i = 0;
        Rect viewportBounds = getViewportBounds();
        for (int i2 = 0; i2 < this.f766b.size(); i2++) {
            bc r = m1163r(i2);
            r.m1669d(false);
            r.m1673f(false);
        }
        if (viewportBounds.equals(getPreviewBounds())) {
            this.f786w = mo450a(viewportBounds);
            for (int r2 : this.f786w) {
                int r22;
                m1163r(r22).m1669d(true);
            }
            if (this.f787x.length > 0) {
                this.f787x = new int[0];
                return;
            }
            return;
        }
        int[] a = mo450a(getPreviewBounds());
        ArrayList arrayList = new ArrayList(a.length);
        ArrayList arrayList2 = new ArrayList(a.length);
        for (int i3 : a) {
            bc r3 = m1163r(i3);
            if (viewportBounds.intersects(r3.f1000h, r3.f1001i, r3.f1003k, r3.f1002j)) {
                arrayList.add(Integer.valueOf(i3));
                r3.m1669d(true);
            } else {
                arrayList2.add(Integer.valueOf(i3));
                r3.m1673f(true);
            }
        }
        this.f786w = new int[arrayList.size()];
        for (r22 = 0; r22 < this.f786w.length; r22++) {
            this.f786w[r22] = ((Integer) arrayList.get(r22)).intValue();
        }
        this.f787x = new int[arrayList2.size()];
        while (i < this.f787x.length) {
            this.f787x[i] = ((Integer) arrayList2.get(i)).intValue();
            i++;
        }
    }

    /* renamed from: d */
    private final void mo453d(int i) {
        if (!f758c && !this.f776m) {
            throw new AssertionError();
        } else if (!f758c && !this.f775l) {
            throw new AssertionError();
        } else if (f758c || this.f789z != null) {
            bc r = m1163r(i);
            int g = r.f1003k - r.f1000h;
            int h = r.f1002j - r.f1001i;
            boolean e = mo454e(i);
            if (r.f994b.getVisibility() != 0) {
                r.f994b.setVisibility(0);
            }
            if (e) {
                if (f758c || !r.m1666b()) {
                    m1153k(i);
                    if (r.f998f != g) {
                        m1150j();
                    }
                    if (r.f999g != h) {
                        m1150j();
                    }
                } else {
                    throw new AssertionError();
                }
            }
            if (r.f998f != g || r.f999g != h) {
                return;
            }
            if (r.m1666b()) {
                r.f994b.offsetLeftAndRight(r.f1000h - r.f994b.getLeft());
                r.f994b.offsetTopAndBottom(r.f1001i - r.f994b.getTop());
                return;
            }
            r.f994b.layout(r.f1000h, r.f1001i, r.f1003k, r.f1002j);
            r.m1665b(true);
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: k */
    protected final void m1153k(int i) {
        bc r = m1163r(i);
        mo454e(i);
        r.f994b.m1677a();
        r.f994b.measure(r.f996d, r.f997e);
        r.f998f = r.f994b.getMeasuredWidth();
        r.f999g = r.f994b.getMeasuredHeight();
    }

    /* renamed from: e */
    private final boolean mo454e(int i) {
        boolean z = true;
        if (f758c || this.f776m) {
            boolean z2;
            boolean z3;
            bc r = m1163r(i);
            int g = r.f1003k - r.f1000h;
            int h = r.f1002j - r.f1001i;
            boolean z4 = r.f994b == null;
            if (r.m1664a() || z4) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 && r.f998f == g && r.f999g == h) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (r.f994b == null) {
                if (f758c || !r.m1666b()) {
                    ListIterator listIterator = this.f767d.listIterator();
                    while (listIterator.hasNext()) {
                        bc bcVar = (bc) listIterator.next();
                        if (f758c || bcVar.f995c != null) {
                            if (bcVar.f995c.getAnimation() == null && !bcVar.m1670d() && !bcVar.m1674f() && !bcVar.m1672e()) {
                                r.f994b = bcVar.f994b;
                                r.f994b.f1010b = r;
                                r.f995c = bcVar.f995c;
                                bcVar.f994b = null;
                                bcVar.f995c = null;
                                bcVar.m1665b(false);
                                listIterator.remove();
                                break;
                            }
                        } else {
                            throw new AssertionError();
                        }
                    }
                }
                throw new AssertionError();
            }
            if (r.f994b == null) {
                if (f758c || !r.m1666b()) {
                    bd n = mo1766n();
                    r.f994b = n;
                    r.f994b.f1010b = r;
                    addViewInLayout(n, -1, new LayoutParams(-2, -2), true);
                } else {
                    throw new AssertionError();
                }
            }
            if (f758c || r.f994b != null) {
                if (z2) {
                    if (f758c || !r.m1666b()) {
                        View d = this.f789z.mo508d(i, r.f995c, r.f994b);
                        if (!f758c && d == null) {
                            throw new AssertionError();
                        } else if (r.f995c == null) {
                            r.f994b.addView(d);
                            r.f995c = d;
                        } else if (r.f995c != d) {
                            if (r.f995c.getAnimation() == null) {
                                r.f994b.removeView(r.f995c);
                            }
                            r.f994b.addView(d);
                            r.f995c = d;
                        }
                    } else {
                        throw new AssertionError();
                    }
                }
                r.m1663a(false);
                if (!r.m1666b() || z3) {
                    z = false;
                }
                r.m1665b(z);
                if (z4) {
                    this.f767d.add(r);
                }
                return z3;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    /* renamed from: b */
    private final void m1078b(int i, boolean z) {
        bc r = m1163r(i);
        if (r.m1672e() != z) {
            r.m1671e(z);
            if (z) {
                this.f768e.add(Integer.valueOf(i));
            } else {
                this.f768e.remove(Integer.valueOf(i));
            }
            m1152k();
        }
    }

    /* renamed from: s */
    private final void m1100s() {
        if (!this.f775l) {
            m1102u();
            if (this.f781r) {
                m1101t();
            } else {
                mo448a();
            }
            this.f775l = true;
        }
    }

    /* renamed from: t */
    private final void m1101t() {
        if (this.f780q != null) {
            Rect rect = (Rect) dv.f1198g.addAnimation();
            Rect rect2 = (Rect) dv.f1198g.addAnimation();
            rect.set(this.f765a.m1553k());
            rect.left += getPaddingLeft();
            rect.top += getPaddingTop();
            rect.right -= getPaddingRight();
            rect.bottom -= getPaddingBottom();
            be beVar = (be) this.f780q.getLayoutParams();
            Gravity.apply(beVar.f1011a, this.f780q.getMeasuredWidth(), this.f780q.getMeasuredHeight(), rect, rect2);
            switch (beVar.f1011a & 7) {
                case 3:
                    rect2.offset(beVar.leftMargin, 0);
                    break;
                case 5:
                    rect2.offset(-beVar.rightMargin, 0);
                    break;
                default:
                    rect2.offset(beVar.leftMargin - beVar.rightMargin, 0);
                    break;
            }
            switch (beVar.f1011a & 112) {
                case C2295j.f14321a /*48*/:
                    rect2.offset(0, beVar.topMargin);
                    break;
                case 80:
                    rect2.offset(0, -beVar.bottomMargin);
                    break;
                default:
                    rect2.offset(0, beVar.topMargin - beVar.bottomMargin);
                    break;
            }
            this.f780q.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
            dv.f1198g.clearAnimation(rect2);
            dv.f1198g.clearAnimation(rect);
        }
    }

    /* renamed from: u */
    private final void m1102u() {
        boolean z = false;
        if (!this.f776m) {
            int a = mo446a(this.f778o, this.f779p);
            if (a != 0) {
                for (int i = 0; i < this.f773j; i++) {
                    bc r = m1163r(i);
                    r.f998f = -1;
                    r.f999g = -1;
                    r.m1665b(false);
                }
            }
            if ((a & -1) == -1) {
                z = true;
            }
            this.f781r = z;
            if (this.f780q != null) {
                removeViewInLayout(this.f780q);
            }
            if (this.f781r) {
                this.f780q = this.f789z != null ? this.f789z.mo482a(this.f780q, this) : null;
                if (this.f780q != null) {
                    LayoutParams g;
                    if (this.f780q.getLayoutParams() == null) {
                        g = m1142g();
                    } else if (this.f780q.getLayoutParams() instanceof be) {
                        be g2 = (be) this.f780q.getLayoutParams();
                    } else if (this.f780q.getLayoutParams() instanceof MarginLayoutParams) {
                        g2 = new be((MarginLayoutParams) this.f780q.getLayoutParams());
                    } else {
                        g2 = new be(this.f780q.getLayoutParams());
                    }
                    addViewInLayout(this.f780q, -1, g2, true);
                }
                m1103v();
            } else {
                this.f780q = null;
            }
            this.f776m = true;
        }
    }

    /* renamed from: v */
    private final void m1103v() {
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.f780q == null) {
            m1143g(resolveSize(paddingLeft, this.f778o), resolveSize(paddingTop, this.f779p));
            return;
        }
        be beVar = (be) this.f780q.getLayoutParams();
        if (f758c || beVar != null) {
            int i = beVar.leftMargin + beVar.rightMargin;
            int i2 = beVar.topMargin + beVar.bottomMargin;
            int childMeasureSpec = getChildMeasureSpec(MeasureSpec.makeMeasureSpec(0, 0), 0, beVar.width);
            int childMeasureSpec2 = getChildMeasureSpec(MeasureSpec.makeMeasureSpec(0, 0), 0, beVar.height);
            this.f780q.measure(childMeasureSpec, childMeasureSpec2);
            int max = Math.max((paddingLeft + i) + this.f780q.getMeasuredWidth(), getSuggestedMinimumWidth());
            int max2 = Math.max((paddingTop + i2) + this.f780q.getMeasuredHeight(), getSuggestedMinimumHeight());
            max = resolveSize(max, this.f778o);
            max2 = resolveSize(max2, this.f779p);
            if (beVar.width == -1 || beVar.height == -1) {
                if (beVar.width == -1) {
                    childMeasureSpec = MeasureSpec.makeMeasureSpec((max - paddingLeft) - i, 1073741824);
                }
                this.f780q.measure(childMeasureSpec, beVar.height == -1 ? MeasureSpec.makeMeasureSpec((max2 - paddingTop) - i2, 1073741824) : childMeasureSpec2);
            }
            m1143g(Math.max(max, (paddingLeft + i) + this.f780q.getMeasuredWidth()), Math.max(max2, (paddingTop + i2) + this.f780q.getMeasuredHeight()));
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: n */
    protected bd mo1766n() {
        return new bd(this, getContext());
    }

    /* renamed from: a */
    protected final void m1112a(int i, int i2, int i3, int i4, int i5) {
        if (f758c || this.f789z != null) {
            bc r = m1163r(i);
            r.f1000h = i2;
            r.f1001i = i3;
            r.f1003k = i4;
            r.f1002j = i5;
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: c */
    protected final void m1131c(int i, int i2, int i3, int i4) {
        this.f782s = i3 - i;
        this.f783t = i4 - i2;
        this.f765a.m1487a(i, i2, i3, i4);
    }

    /* renamed from: g */
    protected final void m1143g(int i, int i2) {
        this.f782s = i;
        this.f783t = i2;
        this.f765a.m1485a(this.f782s);
        this.f765a.m1511b(this.f783t);
    }

    /* renamed from: a */
    protected final boolean m1118a(int i, Point point) {
        bc r = m1163r(i);
        return point.x >= r.f1000h && point.y >= r.f1001i && point.x < r.f1003k && point.y < r.f1002j;
    }

    /* renamed from: c */
    protected final boolean m1133c(int i, Rect rect) {
        bc r = m1163r(i);
        return rect.intersects(r.f1000h, r.f1001i, r.f1003k, r.f1002j);
    }

    /* renamed from: l */
    protected final int m1154l(int i) {
        return m1163r(i).f1000h;
    }

    /* renamed from: m */
    protected final int m1156m(int i) {
        return m1163r(i).f1001i;
    }

    /* renamed from: n */
    protected final int m1158n(int i) {
        return m1163r(i).f1003k;
    }

    /* renamed from: o */
    protected final int m1160o(int i) {
        return m1163r(i).f1002j;
    }

    /* renamed from: h */
    protected final void m1146h(int i, int i2) {
        m1163r(i).f996d = i2;
    }

    /* renamed from: i */
    protected final void m1149i(int i, int i2) {
        m1163r(i).f997e = i2;
    }

    /* renamed from: p */
    protected final int m1161p(int i) {
        return m1163r(i).f998f;
    }

    /* renamed from: q */
    protected final int m1162q(int i) {
        return m1163r(i).f999g;
    }

    /* renamed from: r */
    protected final bc m1163r(int i) {
        if (!m1164s(i)) {
            return null;
        }
        bc bcVar = (bc) this.f766b.get(i);
        if (f758c || bcVar != null) {
            return bcVar;
        }
        throw new AssertionError();
    }

    /* renamed from: s */
    protected final boolean m1164s(int i) {
        return i >= 0 && i < this.f766b.size();
    }

    protected final int getCellsMarginHorizontal() {
        return getCellsMarginLeft() + getCellsMarginRight();
    }

    protected final int getCellsMarginVertical() {
        return getCellsMarginTop() + getCellsMarginBottom();
    }

    protected final int getCellsMarginLeft() {
        return getPaddingLeft() + this.f769f.left;
    }

    protected final int getCellsMarginTop() {
        return getPaddingTop() + this.f769f.top;
    }

    protected final int getCellsMarginRight() {
        return getPaddingRight() + this.f769f.right;
    }

    protected final int getCellsMarginBottom() {
        return getPaddingBottom() + this.f769f.bottom;
    }
}
