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
import android.widget.LinearLayout.LayoutParams;
import com.duokan.core.ui.HatGridView;
import com.duokan.core.ui.PullDownRefreshBaseView;
import com.duokan.core.ui.PullDownRefreshBaseView.RefreshState;
import com.duokan.core.ui.PullDownRefreshView;
import com.duokan.core.ui.Scrollable;
import com.duokan.core.ui.Scrollable.OverScrollMode;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.core.ui.an;
import com.duokan.core.ui.ao;
import com.duokan.core.ui.cf;
import com.duokan.core.ui.cg;
import com.duokan.core.ui.dv;
import com.duokan.core.ui.et;
import com.duokan.p023b.C0241c;

public class DkWebListView extends FrameLayout implements Scrollable {
    /* renamed from: a */
    private final HatGridView f6792a;
    /* renamed from: b */
    private final LinearLayout f6793b;
    /* renamed from: c */
    private final PullDownRefreshBaseView f6794c;
    /* renamed from: d */
    private final bp f6795d;
    /* renamed from: e */
    private View f6796e;
    /* renamed from: f */
    private boolean f6797f;
    /* renamed from: g */
    private cg f6798g;
    /* renamed from: h */
    private an f6799h;
    /* renamed from: i */
    private ao f6800i;

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
        this.f6796e = null;
        this.f6797f = false;
        this.f6798g = null;
        this.f6799h = null;
        this.f6800i = null;
        this.f6792a = m9953a(context);
        this.f6793b = new LinearLayout(getContext());
        this.f6793b.setOrientation(1);
        this.f6794c = new PullDownRefreshView(getContext());
        this.f6793b.addView(this.f6794c, new LayoutParams(-1, -2));
        this.f6792a.setHatTipView(this.f6793b);
        this.f6792a.m1242a(0, dv.m1932b(getContext(), 60.0f), 0, 0);
        this.f6792a.setOnScrollListener(new bg(this));
        addView(this.f6792a, new FrameLayout.LayoutParams(-1, -1));
        setBackgroundColor(getResources().getColor(C0241c.general__shared__eeeeee));
        this.f6795d = new bp();
        this.f6792a.setAdapter(this.f6795d);
    }

    /* renamed from: a */
    protected HatGridView m9953a(Context context) {
        return new bj(this, context);
    }

    public final bo getAdapter() {
        return this.f6795d.m10302b();
    }

    public final void setAdapter(bo boVar) {
        this.f6795d.m10299a(boVar);
        this.f6794c.setRefreshState(RefreshState.NO_REFRESH);
    }

    public final int getStretchMode() {
        return this.f6792a.getStretchMode();
    }

    public final void setStretchMode(int i) {
        this.f6792a.setStretchMode(i);
    }

    public final Drawable getItemsBackground() {
        return this.f6792a.getItemsBackground();
    }

    public final void setItemsBackground(int i) {
        this.f6792a.setItemsBackground(i);
    }

    public final void setItemsBackground(Drawable drawable) {
        this.f6792a.setItemsBackground(drawable);
    }

    /* renamed from: a */
    public final View m9952a(int i) {
        return this.f6792a.m1241a(i);
    }

    public final int getNumColumns() {
        return this.f6792a.getNumColumns();
    }

    public final void setNumColumns(int i) {
        this.f6792a.setNumColumns(i);
    }

    public final int getColumnCount() {
        return this.f6792a.getColumnCount();
    }

    public final Drawable getColumnDivider() {
        return this.f6792a.getColumnDivider();
    }

    public final void setColumnDivider(Drawable drawable) {
        this.f6792a.setColumnDivider(drawable);
    }

    public final int getColumnSpacing() {
        return this.f6792a.getColumnSpacing();
    }

    public final void setColumnSpacing(int i) {
        this.f6792a.setColumnSpacing(i);
    }

    public final int getRowCount() {
        return this.f6792a.getRowCount();
    }

    public final Drawable getRowBackground() {
        return this.f6792a.getRowBackground();
    }

    public final void setRowBackground(int i) {
        this.f6792a.setRowBackground(getResources().getDrawable(i));
    }

    public final void setRowBackground(Drawable drawable) {
        this.f6792a.setRowBackground(drawable);
    }

    public final Drawable getRowDivider() {
        return this.f6792a.getRowDivider();
    }

    public final void setRowDivider(int i) {
        this.f6792a.setRowDivider(i);
    }

    public final void setRowDivider(Drawable drawable) {
        this.f6792a.setRowDivider(drawable);
    }

    public final int getRowSpacing() {
        return this.f6792a.getRowSpacing();
    }

    public final void setRowSpacing(int i) {
        this.f6792a.setRowSpacing(i);
    }

    public final ListState getListState() {
        return this.f6795d.m10311h();
    }

    public final void setPullDownRefreshEnabled(boolean z) {
        this.f6794c.setVisibility(z ? 0 : 4);
    }

    public final int getHeaderSink() {
        return this.f6792a.getHeaderSink();
    }

    public final void setHeaderSink(int i) {
        this.f6792a.setHeaderSink(i);
    }

    public final int getFooterRise() {
        return this.f6792a.getFooterRise();
    }

    public final void setFooterRise(int i) {
        this.f6792a.setFooterRise(i);
    }

    public final void setTitleView(View view) {
        this.f6792a.setTitleView(view);
    }

    public final void setHatBackgroundView(View view) {
        this.f6792a.setHatBackgroundView(view);
    }

    public final View getHatBackgroundView() {
        return this.f6792a.getHatBackgroundView();
    }

    public final void setHatTipView(View view) {
        if (this.f6796e != view) {
            if (this.f6796e != null) {
                this.f6793b.removeView(this.f6796e);
            }
            this.f6796e = view;
            if (this.f6796e != null) {
                if (this.f6796e.getLayoutParams() == null) {
                    this.f6796e.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
                }
                this.f6793b.addView(this.f6796e);
            }
        }
    }

    public final boolean getHatTipDockable() {
        return this.f6797f;
    }

    public final void setHatTipDockable(boolean z) {
        if (this.f6797f != z) {
            this.f6797f = z;
            if (!this.f6797f && this.f6792a.getScrollState() != ScrollState.DRAG) {
                m9964c();
            }
        }
    }

    /* renamed from: b */
    public final View m9961b(int i) {
        return this.f6792a.m1253c(i);
    }

    public final void setHatBodyView(View view) {
        this.f6792a.setHatBodyView(view);
    }

    public final View getHatBodyView() {
        return this.f6792a.getHatBodyView();
    }

    public final int getHatBodyVisibleHeight() {
        return this.f6792a.getHatBodyVisibleHeight();
    }

    public final View getBrimView() {
        return this.f6792a.getBrimView();
    }

    public final void setBrimView(View view) {
        this.f6792a.setBrimView(view);
    }

    public final void setClipGridToBrim(boolean z) {
        this.f6792a.setClipGridToBrim(z);
    }

    public final int getHatVisibleHeight() {
        return this.f6792a.getHatVisibleHeight();
    }

    public final void setFastToTopEnable(boolean z) {
        this.f6792a.setFastToTopEnabled(z);
    }

    public final int getListPaddingLeft() {
        return this.f6792a.getGridPaddingLeft();
    }

    public final int getListPaddingRight() {
        return this.f6792a.getGridPaddingRight();
    }

    public final int getListPaddingTop() {
        return this.f6792a.getGridPaddingTop();
    }

    public final int getListPaddingBottom() {
        return this.f6792a.getGridPaddingBottom();
    }

    /* renamed from: a */
    public final void m9955a(int i, int i2, int i3, int i4) {
        this.f6792a.m1250b(i, i2, i3, i4);
    }

    /* renamed from: b */
    public final void m9962b(int i, int i2, int i3, int i4) {
        this.f6792a.m1257d(i, i2, i3, i4);
    }

    public final int getItemCount() {
        return this.f6792a.getItemCount();
    }

    /* renamed from: a */
    public final void m9954a() {
        m9960a(false);
    }

    /* renamed from: a */
    public final void m9960a(boolean z) {
        if (this.f6794c.getRefreshState() != RefreshState.REFRESHING) {
            m9942b(z);
        }
    }

    public final RefreshState getPullRefreshState() {
        return this.f6794c.getRefreshState();
    }

    /* renamed from: b */
    public final boolean m9963b() {
        return this.f6795d.m10308e();
    }

    public final int getListScrollX() {
        return this.f6792a.getGridScrollX();
    }

    public final int getListScrollY() {
        return this.f6792a.getGridScrollY();
    }

    public final void setOnItemClickListener(an anVar) {
        this.f6799h = anVar;
        this.f6792a.setOnItemClickListener(new bk(this));
    }

    public final void setOnItemLongPressListener(ao aoVar) {
        this.f6800i = aoVar;
        this.f6792a.setOnItemLongPressListener(new bl(this));
    }

    public final int getGroupCount() {
        return this.f6792a.getGroupCount();
    }

    public final View getTitleView() {
        return this.f6792a.getTitleView();
    }

    public int getContentWidth() {
        return this.f6792a.getContentWidth();
    }

    public int getContentHeight() {
        return this.f6792a.getContentHeight();
    }

    public boolean getThumbEnabled() {
        return this.f6792a.getThumbEnabled();
    }

    public void setThumbEnabled(boolean z) {
        this.f6792a.setThumbEnabled(z);
    }

    public boolean getSeekEnabled() {
        return this.f6792a.getSeekEnabled();
    }

    public void setSeekEnabled(boolean z) {
        this.f6792a.setSeekEnabled(z);
    }

    public int getHorizontalThumbMarginLeft() {
        return this.f6792a.getHorizontalThumbMarginLeft();
    }

    public int getHorizontalThumbMarginTop() {
        return this.f6792a.getHorizontalThumbMarginTop();
    }

    public int getHorizontalThumbMarginRight() {
        return this.f6792a.getHorizontalThumbMarginRight();
    }

    public int getHorizontalThumbMarginBottom() {
        return this.f6792a.getHorizontalThumbMarginBottom();
    }

    public int getVerticalThumbMarginLeft() {
        return this.f6792a.getVerticalThumbMarginLeft();
    }

    public int getVerticalThumbMarginTop() {
        return this.f6792a.getVerticalThumbMarginTop();
    }

    public int getVerticalThumbMarginRight() {
        return this.f6792a.getVerticalThumbMarginRight();
    }

    public int getVerticalThumbMarginBottom() {
        return this.f6792a.getVerticalThumbMarginBottom();
    }

    public Drawable getHorizontalThumbDrawable() {
        return this.f6792a.getHorizontalThumbDrawable();
    }

    public void setHorizontalThumbDrawable(Drawable drawable) {
        this.f6792a.setHorizontalThumbDrawable(drawable);
    }

    public Drawable getVerticalThumbDrawable() {
        return this.f6792a.getVerticalThumbDrawable();
    }

    public void setVerticalThumbDrawable(Drawable drawable) {
        this.f6792a.setVerticalThumbDrawable(drawable);
    }

    public Drawable getHorizontalSeekDrawable() {
        return this.f6792a.getHorizontalSeekDrawable();
    }

    public void setHorizontalSeekDrawable(Drawable drawable) {
        this.f6792a.setHorizontalSeekDrawable(drawable);
    }

    public Drawable getVerticalSeekDrawable() {
        return this.f6792a.getVerticalSeekDrawable();
    }

    public void setVerticalSeekDrawable(Drawable drawable) {
        this.f6792a.setVerticalSeekDrawable(drawable);
    }

    public et getScrollDetector() {
        return this.f6792a.getScrollDetector();
    }

    public final ScrollState getScrollState() {
        return this.f6792a.getScrollState();
    }

    public final int getIdleTime() {
        return this.f6792a.getIdleTime();
    }

    public final int getScrollTime() {
        return this.f6792a.getScrollTime();
    }

    public int getScrollFinalX() {
        return this.f6792a.getScrollFinalX();
    }

    public int getScrollFinalY() {
        return this.f6792a.getScrollFinalY();
    }

    public final void setScrollInterpolator(Interpolator interpolator) {
        this.f6792a.setScrollInterpolator(interpolator);
    }

    /* renamed from: a */
    public void mo435a(View view, boolean z) {
        this.f6792a.mo435a(view, z);
    }

    public OverScrollMode getHorizontalOverScrollMode() {
        return this.f6792a.getHorizontalOverScrollMode();
    }

    public void setHorizontalOverScrollMode(OverScrollMode overScrollMode) {
        this.f6792a.setHorizontalOverScrollMode(overScrollMode);
    }

    public OverScrollMode getVerticalOverScrollMode() {
        return this.f6792a.getVerticalOverScrollMode();
    }

    public void setVerticalOverScrollMode(OverScrollMode overScrollMode) {
        this.f6792a.setVerticalOverScrollMode(overScrollMode);
    }

    public final int getMaxOverScrollWidth() {
        return this.f6792a.getMaxOverScrollWidth();
    }

    public final void setMaxOverScrollWidth(int i) {
        this.f6792a.setMaxOverScrollWidth(i);
    }

    public int getMaxOverScrollHeight() {
        return this.f6792a.getMaxOverScrollHeight();
    }

    public final void setMaxOverScrollHeight(int i) {
        this.f6792a.setMaxOverScrollHeight(i);
    }

    public final Rect getViewportBounds() {
        return this.f6792a.getViewportBounds();
    }

    public void setOnContentBoundsChangedListener(cf cfVar) {
        this.f6792a.setOnContentBoundsChangedListener(cfVar);
    }

    public final void setOnScrollListener(cg cgVar) {
        this.f6798g = cgVar;
    }

    /* renamed from: a */
    public final void mo434a(int i, int i2, int i3, Runnable runnable, Runnable runnable2) {
        this.f6792a.mo434a(i, i2, i3, runnable, runnable2);
    }

    /* renamed from: c */
    public void m9964c() {
        this.f6792a.m1266g();
    }

    public void scrollBy(int i, int i2) {
        this.f6792a.scrollBy(i, i2);
    }

    public void scrollTo(int i, int i2) {
        this.f6792a.scrollTo(i, i2);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            if (!m9949f() || getScrollState() != ScrollState.IDLE) {
                this.f6794c.setRefreshState(RefreshState.NO_REFRESH);
            } else if (this.f6794c.getRefreshState() != RefreshState.REFRESHING) {
                if (this.f6795d.m10308e()) {
                    this.f6794c.setRefreshState(RefreshState.NO_REFRESH);
                } else {
                    this.f6794c.setRefreshState(RefreshState.DOWN_TO_REFRESH);
                }
            }
            if (this.f6796e != null && this.f6797f) {
                this.f6792a.setHatTipDockable(true);
                this.f6792a.setHatTipDockableHeight(this.f6793b.getHeight() - this.f6794c.getHeight());
            } else if (this.f6794c.getRefreshState() != RefreshState.NO_REFRESH) {
                this.f6792a.setHatTipDockable(true);
                this.f6792a.setHatTipDockableHeight(-1);
            } else {
                this.f6792a.setHatTipDockable(false);
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m9946e();
    }

    /* renamed from: a */
    protected void m9957a(PointF pointF) {
    }

    /* renamed from: a */
    protected void m9959a(ScrollState scrollState, RectF rectF) {
    }

    /* renamed from: d */
    protected boolean m9965d() {
        return false;
    }

    /* renamed from: c */
    private final void m9944c(int i) {
        m9946e();
        if (this.f6794c.getRefreshState() == RefreshState.REFRESHING && getListState() != ListState.LOADING_UPDATES) {
            this.f6794c.setOnRefreshDone(new bm(this));
            this.f6794c.setRefreshState(RefreshState.REFRESH_DONE);
        }
    }

    /* renamed from: b */
    private final void m9942b(boolean z) {
        bp bpVar = this.f6795d;
        boolean z2 = z || ((getListState() == ListState.UNKNOWN || getListState() == ListState.EMPTY) && this.f6794c.getRefreshState() != RefreshState.REFRESHING);
        bpVar.m10300a(z2);
    }

    /* renamed from: e */
    private final void m9946e() {
        if (getListState() == ListState.MORE_TO_LOAD) {
            int lastVisibleItemIndex = this.f6792a.getLastVisibleItemIndex() + 1;
            if (m9965d() || this.f6792a.getItemCount() - lastVisibleItemIndex <= (this.f6792a.getVisibleItemCount() + 1) * 3) {
                this.f6795d.m10312i();
            }
        }
    }

    /* renamed from: f */
    private final boolean m9949f() {
        return this.f6794c.getVisibility() == 0;
    }
}
