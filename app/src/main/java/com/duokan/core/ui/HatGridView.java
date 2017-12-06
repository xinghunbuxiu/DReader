package com.duokan.core.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;

public class HatGridView extends ViewGroup implements Scrollable {
    private Runnable A;
    private cg B;
    private am C;
    private final ak a;
    private final FrameLayout b;
    private final FrameLayout c;
    private final FrameLayout d;
    private final LinearLayout e;
    private final FrameLayout f;
    private final FrameLayout g;
    private final FrameLayout h;
    private final FrameLayout i;
    private final FrameLayout j;
    private final ImageView k;
    private final Rect l;
    private final ap m;
    private OverScrollMode n;
    private int o;
    private int p;
    private boolean q;
    private boolean r;
    private int s;
    private int t;
    private int u;
    private boolean v;
    private int w;
    private HatTipState x;
    private int y;
    private ai z;

    public enum HatTipState {
        UNDOCKED,
        UNDOCKING,
        DOCKING,
        DOCKED
    }

    public HatGridView(Context context) {
        this(context, null);
    }

    public HatGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = new Rect();
        this.n = OverScrollMode.ALWAYS;
        this.o = 0;
        this.p = 0;
        this.q = true;
        this.r = true;
        this.s = 1;
        this.t = 0;
        this.u = 0;
        this.v = false;
        this.w = -1;
        this.x = HatTipState.UNDOCKED;
        this.y = 0;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        setWillNotDraw(false);
        this.j = new FrameLayout(context);
        this.d = new y(this, context);
        this.f = new aa(this, context);
        this.d.addView(this.f, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        this.e = new ab(this, context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.BOTTOM;
        this.e.setOrientation(LinearLayout.VERTICAL);
        this.e.setClipChildren(false);
        this.e.setClipToPadding(false);
        this.d.addView(this.e, layoutParams);
        this.g = new FrameLayout(context);
        this.g.setClipChildren(false);
        this.g.setClipToPadding(false);
        this.g.setMinimumHeight(UTools.g(getContext()));
        this.e.addView(this.g, new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        this.h = new FrameLayout(context);
        this.h.setClipChildren(false);
        this.h.setClipToPadding(false);
        this.e.addView(this.h, new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        this.i = new FrameLayout(context);
        this.e.addView(this.i, new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        this.c = new ac(this, context);
        this.b = new ad(this, context);
        this.a = new ak(this, context);
        this.n = this.a.getVerticalOverScrollMode();
        this.a.setThumbEnabled(true);
        this.a.setRowSpacing(this.t);
        this.a.setNumColumns(this.s);
        this.a.setOnScrollListener(new ae(this));
        addView(this.a, new ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        addView(this.c, new ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        addView(this.b, new ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        addView(this.d, new ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        addView(this.j, new ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        this.m = new ap();
        this.a.setAdapter(this.m);
        this.k = new ImageView(context);
        this.k.setScaleType(ScaleType.CENTER);
        this.k.setImageResource(R.drawable.general__hat_grid_view__back_to_top);
        this.k.setBackgroundResource(R.drawable.general__shared__button_circular_48dip);
        addView(this.k, new ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        this.k.setOnClickListener(new af(this));
        this.k.setEnabled(false);
        this.k.setVisibility(INVISIBLE);
    }
    class aa extends FrameLayout {
        final HatGridView a;

        public aa(HatGridView hatGridView, Context context) {
            super(context);
            this.a = hatGridView;
        }

        protected void dispatchDraw(Canvas canvas) {
            canvas.clipRect(0, getScrollY(), getWidth(), (getScrollY() + getHeight()) - this.a.i.getHeight());
            super.dispatchDraw(canvas);
        }
    }
    public final av getAdapter() {
        return this.m.b();
    }

    public final void setAdapter(aj ajVar) {
        this.m.a(ajVar);
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
        return this.a.g(i);
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
        return this.a.getDesiredColumnSpacing();
    }

    public final void setColumnSpacing(int i) {
        this.a.setDesiredColumnSpacing(i);
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

    public final ScrollState getGridScrollState() {
        return this.a.getScrollState();
    }

    public final int getGridScrollX() {
        return this.a.getScrollX();
    }

    public final int getGridScrollY() {
        return this.a.getScrollY();
    }

    public final void setOnItemClickListener(an anVar) {
        this.a.setOnItemClickListener(new ag(this, anVar));
    }

    public final void setOnItemLongPressListener(ao aoVar) {
        this.a.setOnItemLongPressListener(new ah(this, aoVar));
    }

    public final am getOnHatTipStateChange() {
        return this.C;
    }

    public final void setOnHatTipStateChange(am amVar) {
        this.C = amVar;
    }

    public final int getHeaderSink() {
        return this.o;
    }

    public final void setHeaderSink(int i) {
        this.o = i;
        requestLayout();
    }

    public final int getFooterRise() {
        return this.p;
    }

    public final void setFooterRise(int i) {
        this.p = i;
        requestLayout();
    }

    public final View getTitleView() {
        if (this.j.getChildCount() > 0) {
            return this.j.getChildAt(0);
        }
        return null;
    }

    public final void setTitleView(View view) {
        this.j.removeAllViews();
        this.j.setClickable(false);
        if (view != null) {
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, 17));
            }
            this.j.addView(view);
            this.j.setClickable(true);
        }
    }

    public final void setHatBackgroundView(View view) {
        this.f.removeAllViews();
        if (view != null) {
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
            }
            this.f.addView(view);
        }
    }

    public final View getHatTipView() {
        if (this.g.getChildCount() > 0) {
            return this.g.getChildAt(0);
        }
        return null;
    }

    public final View b(int i) {
        this.g.removeAllViews();
        if (i == 0) {
            return null;
        }
        View inflate = LayoutInflater.from(getContext()).inflate(i, this.g, false);
        this.g.addView(inflate);
        return inflate;
    }

    public final void setHatTipView(View view) {
        this.g.removeAllViews();
        if (view != null) {
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
            }
            this.g.addView(view);
        }
    }

    public final HatTipState getHatTipState() {
        return this.x;
    }

    public final boolean getHatTipDockable() {
        return this.v;
    }

    public final void setHatTipDockable(boolean z) {
        if (this.v != z) {
            this.v = z;
            if (!this.v) {
                setHatTipDockable(false);
                if (getScrollState() != ScrollState.DRAG) {
                    g();
                }
            }
        }
    }

    public final void setHatTipDockableHeight(int i) {
        this.w = i;
    }

    public final void a(int i, int i2, int i3, int i4) {
        this.g.setPadding(i, i2, i3, i4);
    }

    public final View c(int i) {
        this.h.removeAllViews();
        if (i == 0) {
            return null;
        }
        View inflate = LayoutInflater.from(getContext()).inflate(i, this.h, false);
        this.h.addView(inflate);
        return inflate;
    }

    public final void setHatBodyView(View view) {
        this.h.removeAllViews();
        if (view != null) {
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
            }
            this.h.addView(view);
        }
    }

    public final View getHatBodyView() {
        if (this.h.getChildCount() >= 1) {
            return this.h.getChildAt(0);
        }
        return null;
    }

    public final int getHatBodyVisibleHeight() {
        return (this.d.getHeight() - u()) - this.i.getHeight();
    }

    public final View getBrimView() {
        if (this.i.getChildCount() > 0) {
            return this.i.getChildAt(0);
        }
        return null;
    }

    public final void setBrimView(View view) {
        this.i.removeAllViews();
        if (view != null) {
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
            }
            this.i.addView(view);
        }
    }

    public final View getHatView() {
        return this.e;
    }

    public final int getHatVisibleHeight() {
        return this.d.getHeight() - u();
    }

    public final View getHatBackgroundView() {
        return this.f.getChildAt(0);
    }

    public final void setFastToTopEnabled(boolean z) {
        this.k.setEnabled(z);
    }

    public final int getGridPaddingLeft() {
        return this.l.left;
    }

    public final int getGridPaddingRight() {
        return this.l.right;
    }

    public final int getGridPaddingTop() {
        return this.l.top;
    }

    public final int getGridPaddingBottom() {
        return this.l.bottom;
    }

    public final void b(int i, int i2, int i3, int i4) {
        this.l.set(i, i2, i3, i4);
        this.c.setPadding(i, 0, i3, 0);
        this.b.setPadding(i, 0, i3, 0);
        requestLayout();
        invalidate();
    }

    public final void c(int i, int i2, int i3, int i4) {
        this.c.setPadding(i, i2, i3, i4);
    }

    public final void d(int i, int i2, int i3, int i4) {
        this.b.setPadding(i, i2, i3, i4);
    }

    public final int getItemCount() {
        return this.a.getItemCount();
    }

    public final View[] getItemViews() {
        return this.a.getItemViews();
    }

    public final int[] getVisibleItemIndices() {
        return this.a.getVisibleItemIndices();
    }

    public final int getFirstVisibleItemIndex() {
        return this.a.getFirstVisibleItemIndex();
    }

    public final int getLastVisibleItemIndex() {
        return this.a.getLastVisibleItemIndex();
    }

    public final int getVisibleItemCount() {
        return this.a.getVisibleItemCount();
    }

    public final Rect getPreviewExtents() {
        return this.a.getPreviewExtents();
    }

    public final void e(int i, int i2, int i3, int i4) {
        this.a.a(i, i2, i3, i4);
    }

    public void d(int i) {
        if (i >= 0 && i < this.a.getGroupCount()) {
            this.a.b(i);
            Rect c = this.a.c(i);
            int height = this.j.getHeight() + this.i.getHeight();
            if (c.top < this.a.getViewportBounds().top + height) {
                this.a.scrollBy(0, c.top - (height + this.a.getViewportBounds().top));
            }
            this.a.e();
        }
    }

    public final void e(int i) {
        if (i >= 0 && i < this.a.getItemCount()) {
            this.a.i(i);
            Rect h = this.a.h(i);
            int height = this.j.getHeight() + this.i.getHeight();
            if (h.top < this.a.getViewportBounds().top + height) {
                this.a.scrollBy(0, h.top - (height + this.a.getViewportBounds().top));
            }
            this.a.e();
        }
    }

    public final int getGroupCount() {
        return this.a.getGroupCount();
    }

    public final int f(int i) {
        return this.a.a(i);
    }

    public final boolean a() {
        return this.a.getScrollY() <= (n() - r()) - this.j.getHeight();
    }

    public final boolean b() {
        return q() > 0 && this.a.getScrollY() <= (n() - q()) - this.j.getHeight();
    }

    public final Rect g(int i) {
        return this.a.h(i);
    }

    public final void setClipGridToBrim(boolean z) {
        this.q = z;
        invalidate();
    }

    public final void setHatPushable(boolean z) {
        this.r = z;
        scrollBy(0, 0);
    }

    public final void c() {
        a(HatTipState.UNDOCKING);
        if (getScrollState() != ScrollState.DRAG) {
            g();
        }
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

    public void f(int i, int i2, int i3, int i4) {
        this.a.b(i, i2, i3, i4);
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
        return this.n;
    }

    public void setVerticalOverScrollMode(OverScrollMode overScrollMode) {
        OverScrollMode overScrollMode2 = this.n;
        this.n = overScrollMode;
        if (this.a.getVerticalOverScrollMode() == overScrollMode2) {
            this.a.setVerticalOverScrollMode(this.n);
        }
    }

    public final int getMaxOverScrollWidth() {
        return this.a.getMaxOverScrollWidth();
    }

    public final void setMaxOverScrollWidth(int i) {
        this.a.setMaxOverScrollWidth(i);
    }

    public final int getMaxOverScrollHeight() {
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
        this.B = cgVar;
    }

    public final boolean d() {
        return this.a.c();
    }

    public final boolean e() {
        return this.a.d();
    }

    public final void a(int i, int i2, int i3, Runnable runnable, Runnable runnable2) {
        this.a.a(i, i2, i3, runnable, runnable2);
    }

    public void f() {
        this.a.e();
    }

    public void g() {
        this.a.f();
    }

    public void scrollBy(int i, int i2) {
        this.a.scrollBy(i, i2);
    }

    public void scrollTo(int i, int i2) {
        this.a.scrollTo(i, i2);
    }

    public void setEnabled(boolean z) {
        this.a.setEnabled(z);
        super.setEnabled(z);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.translate((float) (-this.a.getScrollX()), (float) (-this.a.getScrollY()));
        if (this.a.c(canvas)) {
            invalidate();
        }
        canvas.translate((float) this.a.getScrollX(), (float) this.a.getScrollY());
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 0;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        measureChild(this.j, i, i2);
        if (this.e.getPaddingTop() != this.j.getMeasuredHeight()) {
            this.e.setPadding(0, this.j.getMeasuredHeight(), 0, 0);
        }
        measureChild(this.d, i, MeasureSpec.makeMeasureSpec(0, 0));
        measureChild(this.a, i, i2);
        measureChild(this.k, i, i2);
        int max = Math.max(this.j.getMeasuredWidth(), Math.max(this.d.getMeasuredWidth(), this.a.getMeasuredWidth()));
        int max2 = Math.max(this.j.getMeasuredHeight(), Math.max(this.d.getMeasuredHeight() - this.g.getMeasuredHeight(), this.a.getMeasuredHeight()));
        int resolveSize = resolveSize(Math.max(getSuggestedMinimumWidth(), paddingLeft + max), i);
        max2 = resolveSize(Math.max(getSuggestedMinimumHeight(), max2 + paddingTop), i2);
        this.j.measure(MeasureSpec.makeMeasureSpec(max, 1073741824), MeasureSpec.makeMeasureSpec(this.j.getMeasuredHeight(), 1073741824));
        this.d.measure(MeasureSpec.makeMeasureSpec(max, 1073741824), MeasureSpec.makeMeasureSpec(this.d.getMeasuredHeight(), 1073741824));
        this.c.measure(MeasureSpec.makeMeasureSpec(max, 1073741824), MeasureSpec.makeMeasureSpec(0, 0));
        this.b.measure(MeasureSpec.makeMeasureSpec(max, 1073741824), MeasureSpec.makeMeasureSpec(0, 0));
        int measuredHeight = this.j.getMeasuredHeight();
        int measuredHeight2 = this.h.getMeasuredHeight();
        int measuredHeight3 = this.i.getMeasuredHeight();
        paddingLeft = getFirstChild() == null ? 0 : getFirstChild().getMeasuredHeight();
        if (m() != null) {
            i3 = m().getMeasuredHeight();
        }
        int i4 = this.l.left;
        paddingLeft = (paddingLeft + (((measuredHeight + measuredHeight2) + measuredHeight3) + this.l.top)) - h();
        int i5 = this.l.right;
        i3 = (i3 + this.l.bottom) - i();
        if (!(this.a.getPaddingLeft() == i4 && this.a.getPaddingTop() == paddingLeft && this.a.getPaddingRight() == i5 && this.a.getPaddingBottom() == i3)) {
            this.a.setPadding(i4, paddingLeft, i5, i3);
        }
        this.a.measure(MeasureSpec.makeMeasureSpec(max, 1073741824), MeasureSpec.makeMeasureSpec(max2 - paddingTop, 1073741824));
        this.a.setMaxOverScrollHeight(((this.e.getMeasuredHeight() - measuredHeight) - measuredHeight2) - measuredHeight3);
        setMeasuredDimension(resolveSize, max2);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        int i5 = (z || this.u != this.d.getMeasuredHeight()) ? 1 : 0;
        this.u = this.d.getMeasuredHeight();
        this.j.layout(paddingLeft, paddingTop, this.j.getMeasuredWidth() + paddingLeft, this.j.getMeasuredHeight() + paddingTop);
        this.d.layout(paddingLeft, paddingTop, this.d.getMeasuredWidth() + paddingLeft, this.d.getMeasuredHeight() + paddingTop);
        this.c.layout(paddingLeft, paddingTop, this.c.getMeasuredWidth() + paddingLeft, this.c.getMeasuredHeight() + paddingTop);
        this.b.layout(paddingLeft, paddingTop, this.b.getMeasuredWidth() + paddingLeft, this.b.getMeasuredHeight() + paddingTop);
        this.a.layout(paddingLeft, paddingTop, this.a.getMeasuredWidth() + paddingLeft, this.a.getMeasuredHeight() + paddingTop);
        this.k.layout(width - this.k.getMeasuredWidth(), height - this.k.getMeasuredHeight(), width, height);
        if (i5 != 0) {
            this.a.e();
        } else if (getScrollState() == ScrollState.IDLE) {
            this.a.scrollBy(0, 0);
        }
        this.a.b(0, this.j.getHeight() + UTools.closeAnimation(getContext(), 2.0f), UTools.closeAnimation(getContext(), 2.0f), UTools.closeAnimation(getContext(), 6.0f));
    }

    protected void a(PointF pointF) {
    }

    protected void a(ScrollState scrollState, RectF rectF) {
    }

    private void a(HatTipState hatTipState) {
        if (this.x != hatTipState) {
            HatTipState hatTipState2 = this.x;
            if (hatTipState2 != HatTipState.DOCKING || hatTipState != HatTipState.UNDOCKED) {
                if (hatTipState2 != HatTipState.DOCKED || hatTipState != HatTipState.UNDOCKED) {
                    if (hatTipState2 != HatTipState.UNDOCKING || hatTipState != HatTipState.DOCKED) {
                        if (hatTipState2 != HatTipState.UNDOCKED || hatTipState != HatTipState.DOCKED) {
                            this.x = hatTipState;
                            if (this.C != null) {
                                this.C.a(hatTipState2, this.x);
                            }
                        }
                    }
                }
            }
        }
    }

    private int h() {
        return getFirstChild() == null ? 0 : this.o;
    }

    private int i() {
        return m() == null ? 0 : this.p;
    }

    private final int getFirsChildHeight() {
        return getFirstChild() == null ? 0 : getFirstChild().getHeight();
    }

    private final int k() {
        return m() == null ? 0 : m().getHeight();
    }

    private final View getFirstChild() {
        if (this.c.getChildCount() > 0) {
            return this.c.getChildAt(0);
        }
        return null;
    }

    private final void a(View view) {
        this.c.removeAllViews();
        if (view != null) {
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
            }
            this.c.addView(view);
        }
    }

    private final View m() {
        if (this.b.getChildCount() > 0) {
            return this.b.getChildAt(0);
        }
        return null;
    }

    private final void b(View view) {
        this.b.removeAllViews();
        if (view != null) {
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
            }
            this.b.addView(view);
        }
    }

    private final int n() {
        return o() + r();
    }

    private final int o() {
        return p() + t();
    }

    private final int p() {
        return (getHatTipView() == null ? 0 : getHatTipView().getTop()) + (this.g.getTop() + this.e.getTop());
    }

    private final int q() {
        if (!this.v) {
            return 0;
        }
        if (this.w < 0) {
            return r();
        }
        return Math.min(this.w, r());
    }

    private final int r() {
        return getHatTipView() == null ? 0 : getHatTipView().getHeight();
    }

    private final int s() {
        return this.h.getHeight();
    }

    private final int t() {
        return (-v()) + this.j.getHeight();
    }

    private final int u() {
        return this.d.getScrollY() + this.j.getBottom();
    }

    private final int v() {
        return this.e.getTop() + this.h.getTop();
    }

    private void w() {
        if (this.k.isEnabled() && this.k.getVisibility() != 0) {
            this.k.clearAnimation();
            this.k.setVisibility(0);
            UTools.closeAnimation(this.k, null);
        }
    }

    private void x() {
        if (this.k.isEnabled() && this.k.getVisibility() != 4) {
            this.k.clearAnimation();
            this.k.setVisibility(4);
            UTools.showAnimation(this.k, null);
        }
    }

    private void a(ScrollState scrollState, ScrollState scrollState2) {
        if (this.k.isEnabled()) {
            if (this.A != null) {
                removeCallbacks(this.A);
                this.A = null;
            }
            if (scrollState2 != ScrollState.IDLE) {
                return;
            }
            if (getHatBodyVisibleHeight() > 0) {
                x();
            } else if (this.A == null) {
                this.A = new z(this);
                postDelayed(this.A, 2000);
            }
        }
    }
}
