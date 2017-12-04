package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.duokan.core.ui.HatGridView;
import com.duokan.core.ui.PullDownRefreshBaseView;
import com.duokan.core.ui.PullDownRefreshBaseView.RefreshState;
import com.duokan.core.ui.PullDownRefreshView;
import com.duokan.core.ui.Scrollable;
import com.duokan.core.ui.UTools;
import com.duokan.core.ui.an;
import com.duokan.core.ui.ao;
import com.duokan.core.ui.cf;
import com.duokan.core.ui.cg;
import com.duokan.core.ui.et;

public class DkWebListView extends FrameLayout implements Scrollable {
    private final HatGridView a;
    private final LinearLayout b;
    private final PullDownRefreshBaseView c;
    private final bp d;
    private View e;
    private boolean f;
    private cg g;
    private an h;
    private ao i;

    public enum ListState {
        UNKNOWN,
        EMPTY,
        ERROR,
        MORE_TO_LOAD,
        FIRST_LOADING,
        LOADING_MORE,
        LOADING_UPDATES,
        LOADING_COMPLETE
    }

    public DkWebListView(Context context) {
        this(context, null);
    }

    public DkWebListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = null;
        this.f = false;
        this.g = null;
        this.h = null;
        this.i = null;
        this.a = a(context);
        this.b = new LinearLayout(getContext());
        this.b.setOrientation(1);
        this.c = new PullDownRefreshView(getContext());
        this.b.addView(this.c, new LayoutParams(-1, -2));
        this.a.setHatTipView(this.b);
        this.a.a(0, UTools.closeAnimation(getContext(), 60.0f), 0, 0);
        this.a.setOnScrollListener(new bg(this));
        addView(this.a, new FrameLayout.LayoutParams(-1, -1));
        setBackgroundColor(getResources().getColor(c.general__shared__eeeeee));
        this.d = new bp();
        this.a.setAdapter(this.d);
    }

    protected HatGridView a(Context context) {
        return new bj(this, context);
    }

    public final bo getAdapter() {
        return this.d.b();
    }

    public final void setAdapter(bo boVar) {
        this.d.a(boVar);
        this.c.setRefreshState(RefreshState.NO_REFRESH);
    }

    public final int getStretchMode() {
        return this.a.getStretchMode();
    }

    public final void setStretchMode(int i) {
        this.a.setStretchMode(i);
    }

    public final Drawable getItemsBackground() {
        return this.a.getItemsBackground();
    }

    public final void setItemsBackground(int i) {
        this.a.setItemsBackground(i);
    }

    public final void setItemsBackground(Drawable drawable) {
        this.a.setItemsBackground(drawable);
    }

    public final View a(int i) {
        return this.a.a(i);
    }

    public final int getNumColumns() {
        return this.a.getNumColumns();
    }

    public final void setNumColumns(int i) {
        this.a.setNumColumns(i);
    }

    public final int getColumnCount() {
        return this.a.getColumnCount();
    }

    public final Drawable getColumnDivider() {
        return this.a.getColumnDivider();
    }

    public final void setColumnDivider(Drawable drawable) {
        this.a.setColumnDivider(drawable);
    }

    public final int getColumnSpacing() {
        return this.a.getColumnSpacing();
    }

    public final void setColumnSpacing(int i) {
        this.a.setColumnSpacing(i);
    }

    public final int getRowCount() {
        return this.a.getRowCount();
    }

    public final Drawable getRowBackground() {
        return this.a.getRowBackground();
    }

    public final void setRowBackground(int i) {
        this.a.setRowBackground(getResources().getDrawable(i));
    }

    public final void setRowBackground(Drawable drawable) {
        this.a.setRowBackground(drawable);
    }

    public final Drawable getRowDivider() {
        return this.a.getRowDivider();
    }

    public final void setRowDivider(int i) {
        this.a.setRowDivider(i);
    }

    public final void setRowDivider(Drawable drawable) {
        this.a.setRowDivider(drawable);
    }

    public final int getRowSpacing() {
        return this.a.getRowSpacing();
    }

    public final void setRowSpacing(int i) {
        this.a.setRowSpacing(i);
    }

    public final ListState getListState() {
        return this.d.h();
    }

    public final void setPullDownRefreshEnabled(boolean z) {
        this.c.setVisibility(z ? 0 : 4);
    }

    public final int getHeaderSink() {
        return this.a.getHeaderSink();
    }

    public final void setHeaderSink(int i) {
        this.a.setHeaderSink(i);
    }

    public final int getFooterRise() {
        return this.a.getFooterRise();
    }

    public final void setFooterRise(int i) {
        this.a.setFooterRise(i);
    }

    public final void setTitleView(View view) {
        this.a.setTitleView(view);
    }

    public final void setHatBackgroundView(View view) {
        this.a.setHatBackgroundView(view);
    }

    public final View getHatBackgroundView() {
        return this.a.getHatBackgroundView();
    }

    public final void setHatTipView(View view) {
        if (this.e != view) {
            if (this.e != null) {
                this.b.removeView(this.e);
            }
            this.e = view;
            if (this.e != null) {
                if (this.e.getLayoutParams() == null) {
                    this.e.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
                }
                this.b.addView(this.e);
            }
        }
    }

    public final boolean getHatTipDockable() {
        return this.f;
    }

    public final void setHatTipDockable(boolean z) {
        if (this.f != z) {
            this.f = z;
            if (!this.f && this.a.getScrollState() != ScrollState.DRAG) {
                c();
            }
        }
    }

    public final View b(int i) {
        return this.a.c(i);
    }

    public final void setHatBodyView(View view) {
        this.a.setHatBodyView(view);
    }

    public final View getHatBodyView() {
        return this.a.getHatBodyView();
    }

    public final int getHatBodyVisibleHeight() {
        return this.a.getHatBodyVisibleHeight();
    }

    public final View getBrimView() {
        return this.a.getBrimView();
    }

    public final void setBrimView(View view) {
        this.a.setBrimView(view);
    }

    public final void setClipGridToBrim(boolean z) {
        this.a.setClipGridToBrim(z);
    }

    public final int getHatVisibleHeight() {
        return this.a.getHatVisibleHeight();
    }

    public final void setFastToTopEnable(boolean z) {
        this.a.setFastToTopEnabled(z);
    }

    public final int getListPaddingLeft() {
        return this.a.getGridPaddingLeft();
    }

    public final int getListPaddingRight() {
        return this.a.getGridPaddingRight();
    }

    public final int getListPaddingTop() {
        return this.a.getGridPaddingTop();
    }

    public final int getListPaddingBottom() {
        return this.a.getGridPaddingBottom();
    }

    public final void a(int i, int i2, int i3, int i4) {
        this.a.b(i, i2, i3, i4);
    }

    public final void b(int i, int i2, int i3, int i4) {
        this.a.d(i, i2, i3, i4);
    }

    public final int getItemCount() {
        return this.a.getItemCount();
    }

    public final void a() {
        a(false);
    }

    public final void a(boolean z) {
        if (this.c.getRefreshState() != RefreshState.REFRESHING) {
            b(z);
        }
    }

    public final RefreshState getPullRefreshState() {
        return this.c.getRefreshState();
    }

    public final boolean b() {
        return this.d.e();
    }

    public final int getListScrollX() {
        return this.a.getGridScrollX();
    }

    public final int getListScrollY() {
        return this.a.getGridScrollY();
    }

    public final void setOnItemClickListener(an anVar) {
        this.h = anVar;
        this.a.setOnItemClickListener(new bk(this));
    }

    public final void setOnItemLongPressListener(ao aoVar) {
        this.i = aoVar;
        this.a.setOnItemLongPressListener(new bl(this));
    }

    public final int getGroupCount() {
        return this.a.getGroupCount();
    }

    public final View getTitleView() {
        return this.a.getTitleView();
    }

    public int getContentWidth() {
        return this.a.getContentWidth();
    }

    public int getContentHeight() {
        return this.a.getContentHeight();
    }

    public boolean getThumbEnabled() {
        return this.a.getThumbEnabled();
    }

    public void setThumbEnabled(boolean z) {
        this.a.setThumbEnabled(z);
    }

    public boolean getSeekEnabled() {
        return this.a.getSeekEnabled();
    }

    public void setSeekEnabled(boolean z) {
        this.a.setSeekEnabled(z);
    }

    public int getHorizontalThumbMarginLeft() {
        return this.a.getHorizontalThumbMarginLeft();
    }

    public int getHorizontalThumbMarginTop() {
        return this.a.getHorizontalThumbMarginTop();
    }

    public int getHorizontalThumbMarginRight() {
        return this.a.getHorizontalThumbMarginRight();
    }

    public int getHorizontalThumbMarginBottom() {
        return this.a.getHorizontalThumbMarginBottom();
    }

    public int getVerticalThumbMarginLeft() {
        return this.a.getVerticalThumbMarginLeft();
    }

    public int getVerticalThumbMarginTop() {
        return this.a.getVerticalThumbMarginTop();
    }

    public int getVerticalThumbMarginRight() {
        return this.a.getVerticalThumbMarginRight();
    }

    public int getVerticalThumbMarginBottom() {
        return this.a.getVerticalThumbMarginBottom();
    }

    public Drawable getHorizontalThumbDrawable() {
        return this.a.getHorizontalThumbDrawable();
    }

    public void setHorizontalThumbDrawable(Drawable drawable) {
        this.a.setHorizontalThumbDrawable(drawable);
    }

    public Drawable getVerticalThumbDrawable() {
        return this.a.getVerticalThumbDrawable();
    }

    public void setVerticalThumbDrawable(Drawable drawable) {
        this.a.setVerticalThumbDrawable(drawable);
    }

    public Drawable getHorizontalSeekDrawable() {
        return this.a.getHorizontalSeekDrawable();
    }

    public void setHorizontalSeekDrawable(Drawable drawable) {
        this.a.setHorizontalSeekDrawable(drawable);
    }

    public Drawable getVerticalSeekDrawable() {
        return this.a.getVerticalSeekDrawable();
    }

    public void setVerticalSeekDrawable(Drawable drawable) {
        this.a.setVerticalSeekDrawable(drawable);
    }

    public et getScrollDetector() {
        return this.a.getScrollDetector();
    }

    public final ScrollState getScrollState() {
        return this.a.getScrollState();
    }

    public final int getIdleTime() {
        return this.a.getIdleTime();
    }

    public final int getScrollTime() {
        return this.a.getScrollTime();
    }

    public int getScrollFinalX() {
        return this.a.getScrollFinalX();
    }

    public int getScrollFinalY() {
        return this.a.getScrollFinalY();
    }

    public final void setScrollInterpolator(Interpolator interpolator) {
        this.a.setScrollInterpolator(interpolator);
    }

    public void a(View view, boolean z) {
        this.a.a(view, z);
    }

    public OverScrollMode getHorizontalOverScrollMode() {
        return this.a.getHorizontalOverScrollMode();
    }

    public void setHorizontalOverScrollMode(OverScrollMode overScrollMode) {
        this.a.setHorizontalOverScrollMode(overScrollMode);
    }

    public OverScrollMode getVerticalOverScrollMode() {
        return this.a.getVerticalOverScrollMode();
    }

    public void setVerticalOverScrollMode(OverScrollMode overScrollMode) {
        this.a.setVerticalOverScrollMode(overScrollMode);
    }

    public final int getMaxOverScrollWidth() {
        return this.a.getMaxOverScrollWidth();
    }

    public final void setMaxOverScrollWidth(int i) {
        this.a.setMaxOverScrollWidth(i);
    }

    public int getMaxOverScrollHeight() {
        return this.a.getMaxOverScrollHeight();
    }

    public final void setMaxOverScrollHeight(int i) {
        this.a.setMaxOverScrollHeight(i);
    }

    public final Rect getViewportBounds() {
        return this.a.getViewportBounds();
    }

    public void setOnContentBoundsChangedListener(cf cfVar) {
        this.a.setOnContentBoundsChangedListener(cfVar);
    }

    public final void setOnScrollListener(cg cgVar) {
        this.g = cgVar;
    }

    public void c() {
        this.a.g();
    }

    public void scrollBy(int i, int i2) {
        this.a.scrollBy(i, i2);
    }

    public void scrollTo(int i, int i2) {
        this.a.scrollTo(i, i2);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            if (!f() || getScrollState() != ScrollState.IDLE) {
                this.c.setRefreshState(RefreshState.NO_REFRESH);
            } else if (this.c.getRefreshState() != RefreshState.REFRESHING) {
                if (this.d.e()) {
                    this.c.setRefreshState(RefreshState.NO_REFRESH);
                } else {
                    this.c.setRefreshState(RefreshState.DOWN_TO_REFRESH);
                }
            }
            if (this.e != null && this.f) {
                this.a.setHatTipDockable(true);
                this.a.setHatTipDockableHeight(this.b.getHeight() - this.c.getHeight());
            } else if (this.c.getRefreshState() != RefreshState.NO_REFRESH) {
                this.a.setHatTipDockable(true);
                this.a.setHatTipDockableHeight(-1);
            } else {
                this.a.setHatTipDockable(false);
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        e();
    }

    protected void a(PointF pointF) {
    }

    protected void a(ScrollState scrollState, RectF rectF) {
    }

    protected boolean d() {
        return false;
    }

    private final void c(int i) {
        e();
        if (this.c.getRefreshState() == RefreshState.REFRESHING && getListState() != ListState.LOADING_UPDATES) {
            this.c.setOnRefreshDone(new bm(this));
            this.c.setRefreshState(RefreshState.REFRESH_DONE);
        }
    }

    private final void b(boolean z) {
        bp bpVar = this.d;
        boolean z2 = z || ((getListState() == ListState.UNKNOWN || getListState() == ListState.EMPTY) && this.c.getRefreshState() != RefreshState.REFRESHING);
        bpVar.a(z2);
    }

    private final void e() {
        if (getListState() == ListState.MORE_TO_LOAD) {
            int lastVisibleItemIndex = this.a.getLastVisibleItemIndex() + 1;
            if (d() || this.a.getItemCount() - lastVisibleItemIndex <= (this.a.getVisibleItemCount() + 1) * 3) {
                this.d.i();
            }
        }
    }

    private final boolean f() {
        return this.c.getVisibility() == 0;
    }
}
