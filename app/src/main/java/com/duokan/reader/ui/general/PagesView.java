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

import com.duokan.core.sys.TaskHandler;
import com.duokan.core.ui.Scrollable;
import com.duokan.core.ui.cf;
import com.duokan.core.ui.OnScrollListener;
import com.duokan.core.ui.et;
import com.duokan.reader.ui.reading.gs;

import java.util.LinkedList;

public abstract class PagesView extends FrameLayout implements Scrollable {
    private final gj a = e();
    private final gg b = d();
    private final Point c = new Point();
    private final Point d = new Point();
    private final gk e = new gk(this);
    private float f = 1.0f;
    private final LinkedList g = new LinkedList();
    private PageLayout h = PageLayout.LEFT_TO_RIGHT;
    private gi i = null;
    private gh j = null;
    private OnScrollListener k = null;
    private gc l = null;
    private gd m = null;
    private gf n = null;
    private Runnable o = null;

    public enum PageLayout {
        LEFT_TO_RIGHT,
        RIGHT_TO_LEFT,
        TOP_TO_BOTTOM
    }

    protected abstract void a();

    protected abstract void a(gh ghVar);

    protected abstract void a(boolean z, Runnable runnable, Runnable runnable2);

    protected abstract void b(boolean z);

    protected abstract void b(boolean z, Runnable runnable, Runnable runnable2);

    protected abstract gg d();

    protected abstract gj e();

    public PagesView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b.setAdapter(this.a);
        this.b.setOnScrollListener(new fz(this));
        addView(this.b, new LayoutParams(-1, -1));
        setDrawingCacheEnabled(false);
        setAnimationCacheEnabled(false);
        setWillNotDraw(false);
        setWillNotCacheDrawing(false);
        this.e.a(false);
        getCellsView().getScrollDetector().a(this.e);
    }

    public final ge getAdapter() {
        return this.a.b();
    }

    public final void setAdapter(ge geVar) {
        this.a.a(geVar);
    }

    public final gi getCurrentPagePresenter() {
        return this.i;
    }

    public final float getZoomFactor() {
        return this.f;
    }

    public final void setOnCurrentPageChangeListener(gc gcVar) {
        this.l = gcVar;
    }

    public final void setOnPageBroadcastListener(gd gdVar) {
        this.m = gdVar;
    }

    public final void setPageCallback(gf gfVar) {
        this.n = gfVar;
    }

    public PageLayout getPageLayout() {
        return this.h;
    }

    public void setPageLayout(PageLayout pageLayout) {
        if (this.h != pageLayout) {
            this.h = pageLayout;
            this.b.p();
            if (this.j != null) {
                b(this.j);
            }
        }
    }

    public final View[] getPageViews() {
        return this.b.getItemViews();
    }

    public final View[] getOrderedPageViews() {
        return this.b.getOrderedItemViews();
    }

    public final View[] getVisiblePageViews() {
        return this.b.getVisibleItemViews();
    }

    public final View a(int i, int i2) {
        int e = this.b.e(i, i2);
        if (e < 0) {
            return null;
        }
        return this.b.g(e);
    }

    public final View[] a(int i, int i2, int i3, int i4) {
        int[] b = this.b.b(new Rect(i, i2, i3, i4));
        View[] viewArr = new View[b.length];
        for (int i5 = 0; i5 < viewArr.length; i5++) {
            viewArr[i5] = this.b.g(b[i5]);
        }
        return viewArr;
    }

    public final void f() {
        int childCount = this.b.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.b.getChildAt(i).setVisibility(4);
        }
    }

    public final void g() {
        int childCount = this.b.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.b.getChildAt(i).setVisibility(0);
        }
    }

    public final void b(gh ghVar) {
        a(ghVar);
    }

    public final void h() {
        if (this.b.getScrollState() == ScrollState.IDLE) {
            b(false, null, null);
        }
    }

    public final void a(Runnable runnable, Runnable runnable2) {
        a(null, runnable, runnable2);
    }

    public final void a(PointF pointF, Runnable runnable, Runnable runnable2) {
        if (this.b.getScrollState() == ScrollState.IDLE) {
            b(true, runnable, runnable2);
        }
    }

    public final void i() {
        if (this.b.getScrollState() == ScrollState.IDLE) {
            a(false, null, null);
        }
    }

    public final void b(Runnable runnable, Runnable runnable2) {
        b(null, runnable, runnable2);
    }

    public final void b(PointF pointF, Runnable runnable, Runnable runnable2) {
        if (this.b.getScrollState() == ScrollState.IDLE) {
            a(true, runnable, runnable2);
        }
    }

    public final void a(int i, int i2, float f) {
        c(i, i2, f);
        this.o = null;
    }

    public final void b(int i, int i2, float f) {
        float zoomFactor = getZoomFactor();
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        Transformation transformation = new Transformation();
        alphaAnimation.initialize(0, 0, 0, 0);
        this.o = new ga(this, f, alphaAnimation, transformation, zoomFactor, i, i2);
        post(this.o);
    }

    public void c(boolean z) {
        b(z);
    }

    public void j() {
        a();
    }

    public void setPagesExtraColor(int i) {
    }

    public void a(Runnable runnable) {
        if (runnable != null) {
            TaskHandler.PostTask(new gb(this, runnable));
        }
    }

    public int getContentWidth() {
        return this.b.getContentWidth();
    }

    public int getContentHeight() {
        return this.b.getContentHeight();
    }

    public boolean getThumbEnabled() {
        return this.b.getThumbEnabled();
    }

    public void setThumbEnabled(boolean z) {
        this.b.setThumbEnabled(z);
    }

    public boolean getSeekEnabled() {
        return this.b.getSeekEnabled();
    }

    public void setSeekEnabled(boolean z) {
        this.b.setSeekEnabled(z);
    }

    public void d(boolean z) {
        this.b.a(z);
    }

    public int getHorizontalThumbMarginLeft() {
        return this.b.getHorizontalThumbMarginLeft();
    }

    public int getHorizontalThumbMarginTop() {
        return this.b.getHorizontalThumbMarginTop();
    }

    public int getHorizontalThumbMarginRight() {
        return this.b.getHorizontalThumbMarginRight();
    }

    public int getHorizontalThumbMarginBottom() {
        return this.b.getHorizontalThumbMarginBottom();
    }

    public int getVerticalThumbMarginLeft() {
        return this.b.getVerticalThumbMarginLeft();
    }

    public int getVerticalThumbMarginTop() {
        return this.b.getVerticalThumbMarginTop();
    }

    public int getVerticalThumbMarginRight() {
        return this.b.getVerticalThumbMarginRight();
    }

    public int getVerticalThumbMarginBottom() {
        return this.b.getVerticalThumbMarginBottom();
    }

    public Drawable getHorizontalThumbDrawable() {
        return this.b.getHorizontalThumbDrawable();
    }

    public void setHorizontalThumbDrawable(Drawable drawable) {
        this.b.setHorizontalThumbDrawable(drawable);
    }

    public Drawable getVerticalThumbDrawable() {
        return this.b.getVerticalThumbDrawable();
    }

    public void setVerticalThumbDrawable(Drawable drawable) {
        this.b.setVerticalThumbDrawable(drawable);
    }

    public Drawable getHorizontalSeekDrawable() {
        return this.b.getHorizontalSeekDrawable();
    }

    public void setHorizontalSeekDrawable(Drawable drawable) {
        this.b.setHorizontalSeekDrawable(drawable);
    }

    public Drawable getVerticalSeekDrawable() {
        return this.b.getVerticalSeekDrawable();
    }

    public void setVerticalSeekDrawable(Drawable drawable) {
        this.b.setVerticalSeekDrawable(drawable);
    }

    public et getScrollDetector() {
        return this.b.getScrollDetector();
    }

    public final ScrollState getScrollState() {
        return this.b.getScrollState();
    }

    public final int getIdleTime() {
        return this.b.getIdleTime();
    }

    public final int getScrollTime() {
        return this.b.getScrollTime();
    }

    public int getScrollFinalX() {
        return this.b.getScrollFinalX();
    }

    public int getScrollFinalY() {
        return this.b.getScrollFinalY();
    }

    public final void setScrollInterpolator(Interpolator interpolator) {
        this.b.setScrollInterpolator(interpolator);
    }

    public void a(View view, boolean z) {
        this.b.a(view, z);
    }

    public OverScrollMode getHorizontalOverScrollMode() {
        return this.b.getHorizontalOverScrollMode();
    }

    public void setHorizontalOverScrollMode(OverScrollMode overScrollMode) {
        this.b.setHorizontalOverScrollMode(overScrollMode);
    }

    public OverScrollMode getVerticalOverScrollMode() {
        return this.b.getVerticalOverScrollMode();
    }

    public void setVerticalOverScrollMode(OverScrollMode overScrollMode) {
        this.b.setVerticalOverScrollMode(overScrollMode);
    }

    public final int getMaxOverScrollWidth() {
        return this.b.getMaxOverScrollWidth();
    }

    public final void setMaxOverScrollWidth(int i) {
        this.b.setMaxOverScrollWidth(i);
    }

    public final int getMaxOverScrollHeight() {
        return this.b.getMaxOverScrollHeight();
    }

    public final void setMaxOverScrollHeight(int i) {
        this.b.setMaxOverScrollHeight(i);
    }

    public final Rect getViewportBounds() {
        return this.b.getViewportBounds();
    }

    public void setOnContentBoundsChangedListener(cf cfVar) {
        this.b.setOnContentBoundsChangedListener(cfVar);
    }

    public final void setOnScrollListener(OnScrollListener cgVar) {
        this.k = cgVar;
    }

    public void a(Rect rect, Rect rect2, int i, Runnable runnable, Runnable runnable2) {
        this.b.a(rect, rect2, i, runnable, runnable2);
    }

    public Point a(Point point) {
        return this.b.c(point);
    }

    public Rect a(Rect rect) {
        return this.b.c(rect);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.b.setEnabled(z);
    }

    public void scrollBy(int i, int i2) {
        this.b.scrollBy(i, i2);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.c.x = (int) ((((float) getWidth()) / 300.0f) * 1000.0f);
        this.c.y = (int) ((((float) getHeight()) / 300.0f) * 1000.0f);
        this.d.x = (int) ((((float) getWidth()) / 200.0f) * 1000.0f);
        this.d.y = (int) ((((float) getHeight()) / 200.0f) * 1000.0f);
        this.b.layout(0, 0, i3 - i, i4 - i2);
    }

    protected void c(int i, int i2, float f) {
        int i3;
        int firstVisibleItemIndex;
        int i4 = 0;
        getCellsView().q();
        int[] visibleItemIndices = getCellsView().getVisibleItemIndices();
        boolean[] zArr = new boolean[visibleItemIndices.length];
        for (i3 = 0; i3 < visibleItemIndices.length; i3++) {
            zArr[i3] = getCellsView().a(visibleItemIndices[i3], true);
        }
        Point point = new Point(i, i2);
        a(point);
        i3 = getCellsView().e(i, i2);
        if (i3 < 0) {
            firstVisibleItemIndex = getCellsView().getFirstVisibleItemIndex();
        } else {
            firstVisibleItemIndex = i3;
        }
        int i5 = firstVisibleItemIndex >= 0 ? point.x - getCellsView().h(firstVisibleItemIndex).left : point.x;
        i3 = firstVisibleItemIndex >= 0 ? point.y - getCellsView().h(firstVisibleItemIndex).top : point.y;
        float zoomFactor = getZoomFactor();
        setZoomFactor(f);
        getCellsView().p();
        getCellsView().q();
        i5 = (int) (((float) i5) * (f / zoomFactor));
        i3 = (int) (((float) i3) * (f / zoomFactor));
        if (firstVisibleItemIndex >= 0) {
            i5 += getCellsView().h(firstVisibleItemIndex).left;
        }
        if (firstVisibleItemIndex >= 0) {
            i3 += getCellsView().h(firstVisibleItemIndex).top;
        }
        point = new Point(i5, i3);
        getCellsView().scrollTo(point.x - i, point.y - i2);
        while (i4 < visibleItemIndices.length) {
            getCellsView().a(visibleItemIndices[i4], zArr[i4]);
            i4++;
        }
    }

    protected void a(gi giVar) {
        while (m() && !this.g.isEmpty()) {
            ((Runnable) this.g.pollFirst()).run();
        }
        d(giVar);
    }

    protected void b(gi giVar) {
    }

    protected void a(ge geVar) {
    }

    protected void a(ScrollState scrollState, ScrollState scrollState2) {
    }

    protected void a(boolean z) {
    }

    protected void setZoomEnabled(boolean z) {
        this.e.a(z);
    }

    protected void setZoomFactor(float f) {
        this.f = f;
    }

    protected float a(float f) {
        float max = Math.max(0.0f, Math.min(Math.abs(f), (float) this.d.x));
        return Float.compare(f, 0.0f) >= 0 ? max : -max;
    }

    protected float b(float f) {
        float max = Math.max(0.0f, Math.min(Math.abs(f), (float) this.d.y));
        return Float.compare(f, 0.0f) >= 0 ? max : -max;
    }

    protected float a(float f, int i) {
        int i2 = getViewportBounds().left;
        float max = Math.max((float) this.c.x, Math.min(Math.abs(f), (float) this.d.x));
        if (i2 > i) {
            return -max;
        }
        return i2 >= i ? 0.0f : max;
    }

    protected void setCurrentPagePresenter(gi giVar) {
        if (this.i != giVar) {
            gi giVar2 = this.i;
            this.i = giVar;
            if (this.l != null) {
                this.l.a(this, giVar2, this.i);
            }
        }
    }

    protected gh getCurrentPageIndicator() {
        return this.j;
    }

    protected void setCurrentPageIndicator(gh ghVar) {
        this.j = ghVar;
    }

    protected void k() {
        if (this.m != null) {
            this.m.a(this);
        }
    }

    protected void l() {
        if (this.m != null) {
            this.m.b(this);
        }
    }

    protected void c(gi giVar) {
        if (this.m != null) {
            this.m.a(this, giVar);
        }
    }

    protected void d(gi giVar) {
        if (this.m != null) {
            this.m.b(this, giVar);
        }
    }

    protected boolean m() {
        View[] pageViews = getPageViews();
        for (View view : pageViews) {
            if (!((gs) view).i()) {
                return false;
            }
        }
        return true;
    }

    protected gg getCellsView() {
        return this.b;
    }

    protected gj getProxyAdapter() {
        return this.a;
    }

    protected boolean n() {
        return getPageLayout() == PageLayout.RIGHT_TO_LEFT;
    }

    protected boolean o() {
        return !p();
    }

    protected boolean p() {
        return getPageLayout() == PageLayout.TOP_TO_BOTTOM;
    }
}
