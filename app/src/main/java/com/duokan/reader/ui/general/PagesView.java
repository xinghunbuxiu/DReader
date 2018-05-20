package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import android.widget.FrameLayout;

import com.duokan.core.sys.UThread;
import com.duokan.core.ui.Scrollable;
import com.duokan.core.ui.OnContentBoundsChangedListener;
import com.duokan.core.ui.OnScrollListener;
import com.duokan.core.ui.et;
import com.duokan.reader.ui.reading.gx;
import java.util.LinkedList;

public abstract class PagesView extends FrameLayout implements Scrollable {
    /* renamed from: a */
    private final gd f6821a = mo1741e();
    /* renamed from: b */
    private final ga f6822b = mo1740d();
    /* renamed from: c */
    private final Point f6823c = new Point();
    /* renamed from: d */
    private final Point f6824d = new Point();
    /* renamed from: e */
    private final ge f6825e = new ge(this);
    /* renamed from: f */
    private float f6826f = 1.0f;
    /* renamed from: g */
    private final LinkedList<Runnable> f6827g = new LinkedList();
    /* renamed from: h */
    private PageLayout f6828h = PageLayout.LEFT_TO_RIGHT;
    /* renamed from: i */
    private gc f6829i = null;
    /* renamed from: j */
    private gb f6830j = null;
    /* renamed from: k */
    private OnScrollListener f6831k = null;
    /* renamed from: l */
    private fw f6832l = null;
    /* renamed from: m */
    private fx f6833m = null;
    /* renamed from: n */
    private fz f6834n = null;
    /* renamed from: o */
    private Runnable f6835o = null;

    public enum PageLayout {
        LEFT_TO_RIGHT,
        RIGHT_TO_LEFT,
        TOP_TO_BOTTOM
    }

    /* renamed from: a */
    protected abstract void mo1734a();

    /* renamed from: a */
    protected abstract void mo1735a(gb gbVar);

    /* renamed from: a */
    protected abstract void mo1737a(boolean z, Runnable runnable, Runnable runnable2);

    /* renamed from: b */
    protected abstract void mo1738b(boolean z);

    /* renamed from: b */
    protected abstract void mo1739b(boolean z, Runnable runnable, Runnable runnable2);

    /* renamed from: d */
    protected abstract ga mo1740d();

    /* renamed from: e */
    protected abstract gd mo1741e();

    public PagesView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6822b.setAdapter(this.f6821a);
        this.f6822b.setOnScrollListener(new ft(this));
        addView(this.f6822b, new LayoutParams(-1, -1));
        setDrawingCacheEnabled(false);
        setAnimationCacheEnabled(false);
        setWillNotDraw(false);
        setWillNotCacheDrawing(false);
        this.f6825e.m1607a(false);
        getCellsView().getScrollDetector().m2041a(this.f6825e);
    }

    public final fy getAdapter() {
        return this.f6821a.mo1765b();
    }

    public final void setAdapter(fy fyVar) {
        this.f6821a.m10412a(fyVar);
    }

    public final gc getCurrentPagePresenter() {
        return this.f6829i;
    }

    public final float getZoomFactor() {
        return this.f6826f;
    }

    public final void setOnCurrentPageChangeListener(fw fwVar) {
        this.f6832l = fwVar;
    }

    public final void setOnPageBroadcastListener(fx fxVar) {
        this.f6833m = fxVar;
    }

    public final void setPageCallback(fz fzVar) {
        this.f6834n = fzVar;
    }

    public PageLayout getPageLayout() {
        return this.f6828h;
    }

    public void setPageLayout(PageLayout pageLayout) {
        if (this.f6828h != pageLayout) {
            this.f6828h = pageLayout;
            this.f6822b.mo1757p();
            if (this.f6830j != null) {
                m10006b(this.f6830j);
            }
        }
    }

    public final View[] getPageViews() {
        return this.f6822b.getItemViews();
    }

    public final View[] getOrderedPageViews() {
        return this.f6822b.getOrderedItemViews();
    }

    public final View[] getVisiblePageViews() {
        return this.f6822b.getVisibleItemViews();
    }

    /* renamed from: a */
    public final View m9987a(int i, int i2) {
        int e = this.f6822b.m1137e(i, i2);
        if (e < 0) {
            return null;
        }
        return this.f6822b.m1141g(e);
    }

    /* renamed from: a */
    public final View[] m10002a(int i, int i2, int i3, int i4) {
        int[] b = this.f6822b.m1128b(new Rect(i, i2, i3, i4));
        View[] viewArr = new View[b.length];
        for (int i5 = 0; i5 < viewArr.length; i5++) {
            viewArr[i5] = this.f6822b.m1141g(b[i5]);
        }
        return viewArr;
    }

    /* renamed from: f */
    public final void m10018f() {
        int childCount = this.f6822b.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.f6822b.getChildAt(i).setVisibility(4);
        }
    }

    /* renamed from: g */
    public final void m10019g() {
        int childCount = this.f6822b.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.f6822b.getChildAt(i).setVisibility(0);
        }
    }

    /* renamed from: b */
    public final void m10006b(gb gbVar) {
        mo1735a(gbVar);
    }

    /* renamed from: h */
    public final void m10020h() {
        if (this.f6822b.getScrollState() == ScrollState.IDLE) {
            mo1739b(false, null, null);
        }
    }

    /* renamed from: a */
    public final void m9999a(Runnable runnable, Runnable runnable2) {
        m9991a(null, runnable, runnable2);
    }

    /* renamed from: a */
    public final void m9991a(PointF pointF, Runnable runnable, Runnable runnable2) {
        if (this.f6822b.getScrollState() == ScrollState.IDLE) {
            mo1739b(true, runnable, runnable2);
        }
    }

    /* renamed from: i */
    public final void m10021i() {
        if (this.f6822b.getScrollState() == ScrollState.IDLE) {
            mo1737a(false, null, null);
        }
    }

    /* renamed from: b */
    public final void m10008b(Runnable runnable, Runnable runnable2) {
        m10005b(null, runnable, runnable2);
    }

    /* renamed from: b */
    public final void m10005b(PointF pointF, Runnable runnable, Runnable runnable2) {
        if (this.f6822b.getScrollState() == ScrollState.IDLE) {
            mo1737a(true, runnable, runnable2);
        }
    }

    /* renamed from: a */
    public final void m9989a(int i, int i2, float f) {
        m10011c(i, i2, f);
        this.f6835o = null;
    }

    /* renamed from: b */
    public final void m10004b(int i, int i2, float f) {
        float zoomFactor = getZoomFactor();
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        Transformation transformation = new Transformation();
        alphaAnimation.initialize(0, 0, 0, 0);
        this.f6835o = new fu(this, f, alphaAnimation, transformation, zoomFactor, i, i2);
        post(this.f6835o);
    }

    /* renamed from: c */
    public void m10013c(boolean z) {
        mo1738b(z);
    }

    /* renamed from: j */
    public void m10022j() {
        mo1734a();
    }

    public void setPagesExtraColor(int i) {
    }

    /* renamed from: a */
    public void m9998a(Runnable runnable) {
        if (runnable != null) {
            UThread.post(new fv(this, runnable));
        }
    }

    public int getContentWidth() {
        return this.f6822b.getContentWidth();
    }

    public int getContentHeight() {
        return this.f6822b.getContentHeight();
    }

    public boolean getThumbEnabled() {
        return this.f6822b.getThumbEnabled();
    }

    public void setThumbEnabled(boolean z) {
        this.f6822b.setThumbEnabled(z);
    }

    public boolean getSeekEnabled() {
        return this.f6822b.getSeekEnabled();
    }

    public void setSeekEnabled(boolean z) {
        this.f6822b.setSeekEnabled(z);
    }

    /* renamed from: d */
    public void m10016d(boolean z) {
        this.f6822b.m1117a(z);
    }

    public int getHorizontalThumbMarginLeft() {
        return this.f6822b.getHorizontalThumbMarginLeft();
    }

    public int getHorizontalThumbMarginTop() {
        return this.f6822b.getHorizontalThumbMarginTop();
    }

    public int getHorizontalThumbMarginRight() {
        return this.f6822b.getHorizontalThumbMarginRight();
    }

    public int getHorizontalThumbMarginBottom() {
        return this.f6822b.getHorizontalThumbMarginBottom();
    }

    public int getVerticalThumbMarginLeft() {
        return this.f6822b.getVerticalThumbMarginLeft();
    }

    public int getVerticalThumbMarginTop() {
        return this.f6822b.getVerticalThumbMarginTop();
    }

    public int getVerticalThumbMarginRight() {
        return this.f6822b.getVerticalThumbMarginRight();
    }

    public int getVerticalThumbMarginBottom() {
        return this.f6822b.getVerticalThumbMarginBottom();
    }

    public Drawable getHorizontalThumbDrawable() {
        return this.f6822b.getHorizontalThumbDrawable();
    }

    public void setHorizontalThumbDrawable(Drawable drawable) {
        this.f6822b.setHorizontalThumbDrawable(drawable);
    }

    public Drawable getVerticalThumbDrawable() {
        return this.f6822b.getVerticalThumbDrawable();
    }

    public void setVerticalThumbDrawable(Drawable drawable) {
        this.f6822b.setVerticalThumbDrawable(drawable);
    }

    public Drawable getHorizontalSeekDrawable() {
        return this.f6822b.getHorizontalSeekDrawable();
    }

    public void setHorizontalSeekDrawable(Drawable drawable) {
        this.f6822b.setHorizontalSeekDrawable(drawable);
    }

    public Drawable getVerticalSeekDrawable() {
        return this.f6822b.getVerticalSeekDrawable();
    }

    public void setVerticalSeekDrawable(Drawable drawable) {
        this.f6822b.setVerticalSeekDrawable(drawable);
    }

    public et getScrollDetector() {
        return this.f6822b.getScrollDetector();
    }

    public final ScrollState getScrollState() {
        return this.f6822b.getScrollState();
    }

    public final int getIdleTime() {
        return this.f6822b.getIdleTime();
    }

    public final int getScrollTime() {
        return this.f6822b.getScrollTime();
    }

    public int getScrollFinalX() {
        return this.f6822b.getScrollFinalX();
    }

    public int getScrollFinalY() {
        return this.f6822b.getScrollFinalY();
    }

    public final void setScrollInterpolator(Interpolator interpolator) {
        this.f6822b.setScrollInterpolator(interpolator);
    }

    /* renamed from: a */
    public void mo435a(View view, boolean z) {
        this.f6822b.mo435a(view, z);
    }

    public OverScrollMode getHorizontalOverScrollMode() {
        return this.f6822b.getHorizontalOverScrollMode();
    }

    public void setHorizontalOverScrollMode(OverScrollMode overScrollMode) {
        this.f6822b.setHorizontalOverScrollMode(overScrollMode);
    }

    public OverScrollMode getVerticalOverScrollMode() {
        return this.f6822b.getVerticalOverScrollMode();
    }

    public void setVerticalOverScrollMode(OverScrollMode overScrollMode) {
        this.f6822b.setVerticalOverScrollMode(overScrollMode);
    }

    public final int getMaxOverScrollWidth() {
        return this.f6822b.getMaxOverScrollWidth();
    }

    public final void setMaxOverScrollWidth(int i) {
        this.f6822b.setMaxOverScrollWidth(i);
    }

    public final int getMaxOverScrollHeight() {
        return this.f6822b.getMaxOverScrollHeight();
    }

    public final void setMaxOverScrollHeight(int i) {
        this.f6822b.setMaxOverScrollHeight(i);
    }

    public final Rect getViewportBounds() {
        return this.f6822b.getViewportBounds();
    }

    public void setOnContentBoundsChangedListener(OnContentBoundsChangedListener contentBoundsChangedListener) {
        this.f6822b.setOnContentBoundsChangedListener(contentBoundsChangedListener);
    }

    public final void setOnScrollListener(OnScrollListener onScrollListener) {
        this.f6831k = onScrollListener;
    }

    /* renamed from: a */
    public final void mo434a(int i, int i2, int i3, Runnable runnable, Runnable runnable2) {
        this.f6822b.mo434a(i, i2, i3, runnable, runnable2);
    }

    /* renamed from: a */
    public void m9992a(Rect rect, Rect rect2, int i, Runnable runnable, Runnable runnable2) {
        this.f6822b.m1115a(rect, rect2, i, runnable, runnable2);
    }

    /* renamed from: a */
    public Point m9985a(Point point) {
        return this.f6822b.m1129c(point);
    }

    /* renamed from: a */
    public Rect m9986a(Rect rect) {
        return this.f6822b.m1130c(rect);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f6822b.setEnabled(z);
    }

    public void scrollBy(int i, int i2) {
        this.f6822b.scrollBy(i, i2);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f6823c.x = (int) ((((float) getWidth()) / 300.0f) * 1000.0f);
        this.f6823c.y = (int) ((((float) getHeight()) / 300.0f) * 1000.0f);
        this.f6824d.x = (int) ((((float) getWidth()) / 200.0f) * 1000.0f);
        this.f6824d.y = (int) ((((float) getHeight()) / 200.0f) * 1000.0f);
        this.f6822b.layout(0, 0, i3 - i, i4 - i2);
    }

    /* renamed from: c */
    protected void m10011c(int i, int i2, float f) {
        int i3;
        int firstVisibleItemIndex;
        int i4 = 0;
        getCellsView().mo1758q();
        int[] visibleItemIndices = getCellsView().getVisibleItemIndices();
        boolean[] zArr = new boolean[visibleItemIndices.length];
        for (i3 = 0; i3 < visibleItemIndices.length; i3++) {
            zArr[i3] = getCellsView().m1119a(visibleItemIndices[i3], true);
        }
        Point point = new Point(i, i2);
        m9985a(point);
        i3 = getCellsView().m1137e(i, i2);
        if (i3 < 0) {
            firstVisibleItemIndex = getCellsView().getFirstVisibleItemIndex();
        } else {
            firstVisibleItemIndex = i3;
        }
        int i5 = firstVisibleItemIndex >= 0 ? point.x - getCellsView().m1144h(firstVisibleItemIndex).left : point.x;
        i3 = firstVisibleItemIndex >= 0 ? point.y - getCellsView().m1144h(firstVisibleItemIndex).top : point.y;
        float zoomFactor = getZoomFactor();
        setZoomFactor(f);
        getCellsView().mo1757p();
        getCellsView().mo1758q();
        i5 = (int) (((float) i5) * (f / zoomFactor));
        i3 = (int) (((float) i3) * (f / zoomFactor));
        if (firstVisibleItemIndex >= 0) {
            i5 += getCellsView().m1144h(firstVisibleItemIndex).left;
        }
        if (firstVisibleItemIndex >= 0) {
            i3 += getCellsView().m1144h(firstVisibleItemIndex).top;
        }
        point = new Point(i5, i3);
        getCellsView().scrollTo(point.x - i, point.y - i2);
        while (i4 < visibleItemIndices.length) {
            getCellsView().m1119a(visibleItemIndices[i4], zArr[i4]);
            i4++;
        }
    }

    /* renamed from: a */
    protected void m9997a(gc gcVar) {
        while (m10025m() && !this.f6827g.isEmpty()) {
            ((Runnable) this.f6827g.pollFirst()).run();
        }
        m10015d(gcVar);
    }

    /* renamed from: b */
    protected void m10007b(gc gcVar) {
    }

    /* renamed from: a */
    protected void m9995a(fy fyVar) {
    }

    /* renamed from: a */
    protected void m9994a(ScrollState scrollState, ScrollState scrollState2) {
    }

    /* renamed from: a */
    protected void mo1736a(boolean z) {
    }

    protected void setZoomEnabled(boolean z) {
        this.f6825e.m1607a(z);
    }

    protected void setZoomFactor(float f) {
        this.f6826f = f;
    }

    /* renamed from: a */
    protected float m9983a(float f) {
        float max = Math.max(0.0f, Math.min(Math.abs(f), (float) this.f6824d.x));
        return Float.compare(f, 0.0f) >= 0 ? max : -max;
    }

    /* renamed from: b */
    protected float m10003b(float f) {
        float max = Math.max(0.0f, Math.min(Math.abs(f), (float) this.f6824d.y));
        return Float.compare(f, 0.0f) >= 0 ? max : -max;
    }

    /* renamed from: a */
    protected float m9984a(float f, int i) {
        int i2 = getViewportBounds().left;
        float max = Math.max((float) this.f6823c.x, Math.min(Math.abs(f), (float) this.f6824d.x));
        if (i2 > i) {
            return -max;
        }
        return i2 >= i ? 0.0f : max;
    }

    protected void setCurrentPagePresenter(gc gcVar) {
        if (this.f6829i != gcVar) {
            gc gcVar2 = this.f6829i;
            this.f6829i = gcVar;
            if (this.f6832l != null) {
                this.f6832l.mo2482a(this, gcVar2, this.f6829i);
            }
        }
    }

    protected gb getCurrentPageIndicator() {
        return this.f6830j;
    }

    protected void setCurrentPageIndicator(gb gbVar) {
        this.f6830j = gbVar;
    }

    /* renamed from: k */
    protected void m10023k() {
        if (this.f6833m != null) {
            this.f6833m.mo2478a(this);
        }
    }

    /* renamed from: l */
    protected void m10024l() {
        if (this.f6833m != null) {
            this.f6833m.mo2480b(this);
        }
    }

    /* renamed from: c */
    protected void m10012c(gc gcVar) {
        if (this.f6833m != null) {
            this.f6833m.mo2479a(this, gcVar);
        }
    }

    /* renamed from: d */
    protected void m10015d(gc gcVar) {
        if (this.f6833m != null) {
            this.f6833m.mo2481b(this, gcVar);
        }
    }

    /* renamed from: m */
    protected boolean m10025m() {
        View[] pageViews = getPageViews();
        for (View view : pageViews) {
            if (!((gx) view).m14303i()) {
                return false;
            }
        }
        return true;
    }

    protected ga getCellsView() {
        return this.f6822b;
    }

    protected gd getProxyAdapter() {
        return this.f6821a;
    }

    /* renamed from: n */
    protected boolean m10026n() {
        return getPageLayout() == PageLayout.RIGHT_TO_LEFT;
    }

    /* renamed from: o */
    protected boolean m10027o() {
        return !m10028p();
    }

    /* renamed from: p */
    protected boolean m10028p() {
        return getPageLayout() == PageLayout.TOP_TO_BOTTOM;
    }
}
