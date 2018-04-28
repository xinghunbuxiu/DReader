package com.duokan.core.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;

import com.duokan.p023b.C0243e;

public class HatGridView extends ViewGroup implements Scrollable {
    /* renamed from: A */
    private Runnable f807A;
    /* renamed from: B */
    private cg f808B;
    /* renamed from: C */
    private am f809C;
    /* renamed from: D */
    private int f810D;
    /* renamed from: a */
    private final ak f811a;
    /* renamed from: b */
    private final FrameLayout f812b;
    /* renamed from: c */
    private final FrameLayout f813c;
    /* renamed from: d */
    private final FrameLayout f814d;
    /* renamed from: e */
    private final LinearLayout f815e;
    /* renamed from: f */
    private final FrameLayout f816f;
    /* renamed from: g */
    private final FrameLayout f817g;
    /* renamed from: h */
    private final FrameLayout f818h;
    /* renamed from: i */
    private final FrameLayout f819i;
    /* renamed from: j */
    private final FrameLayout f820j;
    /* renamed from: k */
    private final ImageView f821k;
    /* renamed from: l */
    private final Rect f822l;
    /* renamed from: m */
    private final ap f823m;
    /* renamed from: n */
    private OverScrollMode f824n;
    /* renamed from: o */
    private int f825o;
    /* renamed from: p */
    private int f826p;
    /* renamed from: q */
    private boolean f827q;
    /* renamed from: r */
    private boolean f828r;
    /* renamed from: s */
    private int f829s;
    /* renamed from: t */
    private int f830t;
    /* renamed from: u */
    private int f831u;
    /* renamed from: v */
    private boolean f832v;
    /* renamed from: w */
    private int f833w;
    /* renamed from: x */
    private HatTipState f834x;
    /* renamed from: y */
    private int f835y;
    /* renamed from: z */
    private ai f836z;

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
        this.f822l = new Rect();
        this.f824n = OverScrollMode.ALWAYS;
        this.f825o = 0;
        this.f826p = 0;
        this.f827q = true;
        this.f828r = true;
        this.f829s = 1;
        this.f830t = 0;
        this.f831u = 0;
        this.f832v = false;
        this.f833w = -1;
        this.f834x = HatTipState.UNDOCKED;
        this.f835y = 0;
        this.f836z = null;
        this.f807A = null;
        this.f808B = null;
        this.f809C = null;
        setWillNotDraw(false);
        this.f820j = new FrameLayout(context);
        this.f814d = new C0397y(this, context);
        this.f816f = new aa(this, context);
        this.f814d.addView(this.f816f, new LayoutParams(-1, -1));
        this.f815e = new ab(this, context);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.f815e.setOrientation(1);
        this.f815e.setClipChildren(false);
        this.f815e.setClipToPadding(false);
        this.f814d.addView(this.f815e, layoutParams);
        this.f817g = new FrameLayout(context);
        this.f817g.setClipChildren(false);
        this.f817g.setClipToPadding(false);
        this.f817g.setMinimumHeight(dv.m1962g(getContext()));
        this.f815e.addView(this.f817g, new LinearLayout.LayoutParams(-1, -2));
        this.f818h = new FrameLayout(context);
        this.f818h.setClipChildren(false);
        this.f818h.setClipToPadding(false);
        this.f815e.addView(this.f818h, new LinearLayout.LayoutParams(-1, -1));
        this.f819i = new FrameLayout(context);
        this.f815e.addView(this.f819i, new LinearLayout.LayoutParams(-1, -2));
        this.f813c = new ac(this, context);
        this.f812b = new ad(this, context);
        this.f811a = new ak(this, context);
        this.f824n = this.f811a.getVerticalOverScrollMode();
        this.f811a.setThumbEnabled(true);
        this.f811a.setRowSpacing(this.f830t);
        this.f811a.setNumColumns(this.f829s);
        this.f811a.setOnScrollListener(new ae(this));
        addView(this.f811a, new ViewGroup.LayoutParams(-1, -1));
        addView(this.f813c, new ViewGroup.LayoutParams(-1, -2));
        addView(this.f812b, new ViewGroup.LayoutParams(-1, -2));
        addView(this.f814d, new ViewGroup.LayoutParams(-1, -2));
        addView(this.f820j, new ViewGroup.LayoutParams(-1, -2));
        this.f823m = new ap();
        this.f811a.setAdapter(this.f823m);
        this.f821k = new ImageView(context);
        this.f821k.setScaleType(ScaleType.CENTER);
        this.f821k.setImageResource(C0243e.general__hat_grid_view__back_to_top);
        this.f821k.setBackgroundResource(C0243e.general__shared__button_circular_48dip);
        addView(this.f821k, new ViewGroup.LayoutParams(-2, -2));
        this.f821k.setOnClickListener(new af(this));
        this.f821k.setEnabled(false);
        this.f821k.setVisibility(4);
    }

    public final av getAdapter() {
        return this.f823m.m1593b();
    }

    public final void setAdapter(aj ajVar) {
        this.f823m.m1591a(ajVar);
    }

    public final int getStretchMode() {
        return this.f811a.getStretchMode();
    }

    public final void setStretchMode(int i) {
        this.f811a.setStretchMode(i);
    }

    public final Drawable getItemsBackground() {
        return this.f811a.getItemsBackground();
    }

    public final void setItemsBackground(int i) {
        this.f811a.setItemsBackground(i);
    }

    public final void setItemsBackground(Drawable drawable) {
        this.f811a.setItemsBackground(drawable);
    }

    /* renamed from: a */
    public final View m1241a(int i) {
        return this.f811a.m1141g(i);
    }

    public final int getNumColumns() {
        return this.f811a.getNumColumns();
    }

    public final void setNumColumns(int i) {
        this.f811a.setNumColumns(i);
    }

    public final int getColumnCount() {
        return this.f811a.getColumnCount();
    }

    public final Drawable getColumnDivider() {
        return this.f811a.getColumnDivider();
    }

    public final void setColumnDivider(Drawable drawable) {
        this.f811a.setColumnDivider(drawable);
    }

    public final int getColumnSpacing() {
        return this.f811a.getDesiredColumnSpacing();
    }

    public final void setColumnSpacing(int i) {
        this.f811a.setDesiredColumnSpacing(i);
    }

    public final int getRowCount() {
        return this.f811a.getRowCount();
    }

    public final Drawable getRowBackground() {
        return this.f811a.getRowBackground();
    }

    public final void setRowBackground(int i) {
        this.f811a.setRowBackground(getResources().getDrawable(i));
    }

    public final void setRowBackground(Drawable drawable) {
        this.f811a.setRowBackground(drawable);
    }

    public final Drawable getRowDivider() {
        return this.f811a.getRowDivider();
    }

    public final void setRowDivider(int i) {
        this.f811a.setRowDivider(i);
    }

    public final void setRowDivider(Drawable drawable) {
        this.f811a.setRowDivider(drawable);
    }

    public final int getRowSpacing() {
        return this.f811a.getRowSpacing();
    }

    public final void setRowSpacing(int i) {
        this.f811a.setRowSpacing(i);
    }

    public final ScrollState getGridScrollState() {
        return this.f811a.getScrollState();
    }

    public final int getGridScrollX() {
        return this.f811a.getScrollX();
    }

    public final int getGridScrollY() {
        return this.f811a.getScrollY();
    }

    public final void setOnItemClickListener(an anVar) {
        this.f811a.setOnItemClickListener(new ag(this, anVar));
    }

    public final void setOnItemLongPressListener(ao aoVar) {
        this.f811a.setOnItemLongPressListener(new ah(this, aoVar));
    }

    public final am getOnHatTipStateChange() {
        return this.f809C;
    }

    public final void setOnHatTipStateChange(am amVar) {
        this.f809C = amVar;
    }

    public final int getHeaderSink() {
        return this.f825o;
    }

    public final void setHeaderSink(int i) {
        this.f825o = i;
        requestLayout();
    }

    public final int getFooterRise() {
        return this.f826p;
    }

    public final void setFooterRise(int i) {
        this.f826p = i;
        requestLayout();
    }

    public final View getTitleView() {
        if (this.f820j.getChildCount() > 0) {
            return this.f820j.getChildAt(0);
        }
        return null;
    }

    public final void setTitleView(View view) {
        this.f820j.removeAllViews();
        this.f820j.setClickable(false);
        if (view != null) {
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new LayoutParams(-1, -2, 17));
            }
            this.f820j.addView(view);
            this.f820j.setClickable(true);
        }
    }

    public final void setHatBackgroundView(View view) {
        this.f816f.removeAllViews();
        if (view != null) {
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new LayoutParams(-1, -1));
            }
            this.f816f.addView(view);
        }
    }

    public final View getHatTipView() {
        if (this.f817g.getChildCount() > 0) {
            return this.f817g.getChildAt(0);
        }
        return null;
    }

    /* renamed from: b */
    public final View m1249b(int i) {
        this.f817g.removeAllViews();
        if (i == 0) {
            return null;
        }
        View inflate = LayoutInflater.from(getContext()).inflate(i, this.f817g, false);
        this.f817g.addView(inflate);
        return inflate;
    }

    public final void setHatTipView(View view) {
        this.f817g.removeAllViews();
        if (view != null) {
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new LayoutParams(-1, -2));
            }
            this.f817g.addView(view);
        }
    }

    public final HatTipState getHatTipState() {
        return this.f834x;
    }

    public final boolean getHatTipDockable() {
        return this.f832v;
    }

    public final void setHatTipDockable(boolean z) {
        if (this.f832v != z) {
            this.f832v = z;
            if (!this.f832v) {
                setHatTipDockable(false);
                if (getScrollState() != ScrollState.DRAG) {
                    m1266g();
                }
            }
        }
    }

    public final void setHatTipDockableHeight(int i) {
        this.f833w = i;
    }

    /* renamed from: a */
    public final void m1242a(int i, int i2, int i3, int i4) {
        this.f817g.setPadding(i, i2, i3, i4);
    }

    /* renamed from: c */
    public final View m1253c(int i) {
        this.f818h.removeAllViews();
        if (i == 0) {
            return null;
        }
        View inflate = LayoutInflater.from(getContext()).inflate(i, this.f818h, false);
        this.f818h.addView(inflate);
        return inflate;
    }

    public final void setHatBodyView(View view) {
        this.f818h.removeAllViews();
        if (view != null) {
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new LayoutParams(-1, -2));
            }
            this.f818h.addView(view);
        }
    }

    public final View getHatBodyView() {
        if (this.f818h.getChildCount() >= 1) {
            return this.f818h.getChildAt(0);
        }
        return null;
    }

    public final int getHatBodyVisibleHeight() {
        return (this.f814d.getHeight() - m1231u()) - this.f819i.getHeight();
    }

    public final View getBrimView() {
        if (this.f819i.getChildCount() > 0) {
            return this.f819i.getChildAt(0);
        }
        return null;
    }

    public final void setBrimView(View view) {
        this.f819i.removeAllViews();
        if (view != null) {
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new LayoutParams(-1, -2));
            }
            this.f819i.addView(view);
        }
    }

    public final View getHatView() {
        return this.f815e;
    }

    public final int getHatVisibleHeight() {
        return this.f814d.getHeight() - m1231u();
    }

    public final View getHatBackgroundView() {
        return this.f816f.getChildAt(0);
    }

    public final void setFastToTopEnabled(boolean z) {
        this.f821k.setEnabled(z);
    }

    public final int getGridPaddingLeft() {
        return this.f822l.left;
    }

    public final int getGridPaddingRight() {
        return this.f822l.right;
    }

    public final int getGridPaddingTop() {
        return this.f822l.top;
    }

    public final int getGridPaddingBottom() {
        return this.f822l.bottom;
    }

    /* renamed from: b */
    public final void m1250b(int i, int i2, int i3, int i4) {
        this.f822l.set(i, i2, i3, i4);
        this.f813c.setPadding(i, 0, i3, 0);
        this.f812b.setPadding(i, 0, i3, 0);
        requestLayout();
        invalidate();
    }

    /* renamed from: c */
    public final void m1255c(int i, int i2, int i3, int i4) {
        this.f813c.setPadding(i, i2, i3, i4);
    }

    /* renamed from: d */
    public final void m1257d(int i, int i2, int i3, int i4) {
        this.f812b.setPadding(i, i2, i3, i4);
    }

    public final int getItemCount() {
        return this.f811a.getItemCount();
    }

    public final View[] getItemViews() {
        return this.f811a.getItemViews();
    }

    public final int[] getVisibleItemIndices() {
        return this.f811a.getVisibleItemIndices();
    }

    public final int getFirstVisibleItemIndex() {
        return this.f811a.getFirstVisibleItemIndex();
    }

    public final int getLastVisibleItemIndex() {
        return this.f811a.getLastVisibleItemIndex();
    }

    public final int getVisibleItemCount() {
        return this.f811a.getVisibleItemCount();
    }

    public final Rect getPreviewExtents() {
        return this.f811a.getPreviewExtents();
    }

    /* renamed from: e */
    public final void m1260e(int i, int i2, int i3, int i4) {
        this.f811a.m1111a(i, i2, i3, i4);
    }

    /* renamed from: d */
    public void m1256d(int i) {
        if (i >= 0 && i < this.f811a.getGroupCount()) {
            this.f811a.mo451b(i);
            Rect c = this.f811a.m1179c(i);
            int height = this.f820j.getHeight() + this.f819i.getHeight();
            if (c.top < this.f811a.getViewportBounds().top + height) {
                this.f811a.scrollBy(0, c.top - (height + this.f811a.getViewportBounds().top));
            }
            this.f811a.m1138e();
        }
    }

    /* renamed from: e */
    public final void m1259e(int i) {
        if (i >= 0 && i < this.f811a.getItemCount()) {
            this.f811a.m1148i(i);
            Rect h = this.f811a.m1144h(i);
            int height = this.f820j.getHeight() + this.f819i.getHeight();
            if (h.top < this.f811a.getViewportBounds().top + height) {
                this.f811a.scrollBy(0, h.top - (height + this.f811a.getViewportBounds().top));
            }
            this.f811a.m1138e();
        }
    }

    public final int getGroupCount() {
        return this.f811a.getGroupCount();
    }

    /* renamed from: f */
    public final int m1262f(int i) {
        return this.f811a.mo445a(i);
    }

    /* renamed from: a */
    public final boolean m1248a() {
        return this.f811a.getScrollY() <= (m1217n() - m1225r()) - this.f820j.getHeight();
    }

    /* renamed from: b */
    public final boolean m1252b() {
        return m1223q() > 0 && this.f811a.getScrollY() <= (m1217n() - m1223q()) - this.f820j.getHeight();
    }

    /* renamed from: g */
    public final Rect m1265g(int i) {
        return this.f811a.m1144h(i);
    }

    public final void setClipGridToBrim(boolean z) {
        this.f827q = z;
        invalidate();
    }

    public final void setHatPushable(boolean z) {
        this.f828r = z;
        scrollBy(0, 0);
    }

    /* renamed from: c */
    public final void m1254c() {
        m1191a(HatTipState.UNDOCKING);
        if (getScrollState() != ScrollState.DRAG) {
            m1266g();
        }
    }

    public final void setMinScrollY(int i) {
        this.f810D = i;
        if (this.f811a.getViewportBounds().top < i) {
            this.f811a.scrollTo(0, i);
        }
    }

    public int getContentWidth() {
        return this.f811a.getContentWidth();
    }

    public int getContentHeight() {
        return this.f811a.getContentHeight();
    }

    public boolean getThumbEnabled() {
        return this.f811a.getThumbEnabled();
    }

    public void setThumbEnabled(boolean z) {
        this.f811a.setThumbEnabled(z);
    }

    public boolean getSeekEnabled() {
        return this.f811a.getSeekEnabled();
    }

    public void setSeekEnabled(boolean z) {
        this.f811a.setSeekEnabled(z);
    }

    public int getHorizontalThumbMarginLeft() {
        return this.f811a.getHorizontalThumbMarginLeft();
    }

    public int getHorizontalThumbMarginTop() {
        return this.f811a.getHorizontalThumbMarginTop();
    }

    public int getHorizontalThumbMarginRight() {
        return this.f811a.getHorizontalThumbMarginRight();
    }

    public int getHorizontalThumbMarginBottom() {
        return this.f811a.getHorizontalThumbMarginBottom();
    }

    public int getVerticalThumbMarginLeft() {
        return this.f811a.getVerticalThumbMarginLeft();
    }

    public int getVerticalThumbMarginTop() {
        return this.f811a.getVerticalThumbMarginTop();
    }

    public int getVerticalThumbMarginRight() {
        return this.f811a.getVerticalThumbMarginRight();
    }

    public int getVerticalThumbMarginBottom() {
        return this.f811a.getVerticalThumbMarginBottom();
    }

    /* renamed from: f */
    public void m1264f(int i, int i2, int i3, int i4) {
        this.f811a.m1124b(i, i2, i3, i4);
    }

    public Drawable getHorizontalThumbDrawable() {
        return this.f811a.getHorizontalThumbDrawable();
    }

    public void setHorizontalThumbDrawable(Drawable drawable) {
        this.f811a.setHorizontalThumbDrawable(drawable);
    }

    public Drawable getVerticalThumbDrawable() {
        return this.f811a.getVerticalThumbDrawable();
    }

    public void setVerticalThumbDrawable(Drawable drawable) {
        this.f811a.setVerticalThumbDrawable(drawable);
    }

    public Drawable getHorizontalSeekDrawable() {
        return this.f811a.getHorizontalSeekDrawable();
    }

    public void setHorizontalSeekDrawable(Drawable drawable) {
        this.f811a.setHorizontalSeekDrawable(drawable);
    }

    public Drawable getVerticalSeekDrawable() {
        return this.f811a.getVerticalSeekDrawable();
    }

    public void setVerticalSeekDrawable(Drawable drawable) {
        this.f811a.setVerticalSeekDrawable(drawable);
    }

    public et getScrollDetector() {
        return this.f811a.getScrollDetector();
    }

    public final ScrollState getScrollState() {
        return this.f811a.getScrollState();
    }

    public final int getIdleTime() {
        return this.f811a.getIdleTime();
    }

    public final int getScrollTime() {
        return this.f811a.getScrollTime();
    }

    public int getScrollFinalX() {
        return this.f811a.getScrollFinalX();
    }

    public int getScrollFinalY() {
        return this.f811a.getScrollFinalY();
    }

    public final void setScrollInterpolator(Interpolator interpolator) {
        this.f811a.setScrollInterpolator(interpolator);
    }

    /* renamed from: a */
    public void mo435a(View view, boolean z) {
        this.f811a.mo435a(view, z);
    }

    public OverScrollMode getHorizontalOverScrollMode() {
        return this.f811a.getHorizontalOverScrollMode();
    }

    public void setHorizontalOverScrollMode(OverScrollMode overScrollMode) {
        this.f811a.setHorizontalOverScrollMode(overScrollMode);
    }

    public OverScrollMode getVerticalOverScrollMode() {
        return this.f824n;
    }

    public void setVerticalOverScrollMode(OverScrollMode overScrollMode) {
        OverScrollMode overScrollMode2 = this.f824n;
        this.f824n = overScrollMode;
        if (this.f811a.getVerticalOverScrollMode() == overScrollMode2) {
            this.f811a.setVerticalOverScrollMode(this.f824n);
        }
    }

    public final int getMaxOverScrollWidth() {
        return this.f811a.getMaxOverScrollWidth();
    }

    public final void setMaxOverScrollWidth(int i) {
        this.f811a.setMaxOverScrollWidth(i);
    }

    public final int getMaxOverScrollHeight() {
        return this.f811a.getMaxOverScrollHeight();
    }

    public final void setMaxOverScrollHeight(int i) {
        this.f811a.setMaxOverScrollHeight(i);
    }

    public final Rect getViewportBounds() {
        return this.f811a.getViewportBounds();
    }

    public void setOnContentBoundsChangedListener(cf cfVar) {
        this.f811a.setOnContentBoundsChangedListener(cfVar);
    }

    public final void setOnScrollListener(cg cgVar) {
        this.f808B = cgVar;
    }

    /* renamed from: d */
    public final boolean m1258d() {
        return this.f811a.m1132c();
    }

    /* renamed from: e */
    public final boolean m1261e() {
        return this.f811a.m1135d();
    }

    /* renamed from: a */
    public final void mo434a(int i, int i2, int i3, Runnable runnable, Runnable runnable2) {
        this.f811a.mo434a(i, i2, i3, runnable, runnable2);
    }

    /* renamed from: b */
    public final void m1251b(int i, int i2, int i3, Runnable runnable, Runnable runnable2) {
        this.f811a.m1125b(i, i2, i3, runnable, runnable2);
    }

    /* renamed from: f */
    public void m1263f() {
        this.f811a.m1138e();
    }

    /* renamed from: g */
    public void m1266g() {
        this.f811a.m1139f();
    }

    public void scrollBy(int i, int i2) {
        this.f811a.scrollBy(i, i2);
    }

    public void scrollTo(int i, int i2) {
        this.f811a.scrollTo(i, i2);
    }

    public void setEnabled(boolean z) {
        this.f811a.setEnabled(z);
        super.setEnabled(z);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.translate((float) (-this.f811a.getScrollX()), (float) (-this.f811a.getScrollY()));
        if (this.f811a.m1411c(canvas)) {
            invalidate();
        }
        canvas.translate((float) this.f811a.getScrollX(), (float) this.f811a.getScrollY());
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 0;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        measureChild(this.f820j, i, i2);
        if (this.f815e.getPaddingTop() != this.f820j.getMeasuredHeight()) {
            this.f815e.setPadding(0, this.f820j.getMeasuredHeight(), 0, 0);
        }
        measureChild(this.f814d, i, MeasureSpec.makeMeasureSpec(0, 0));
        measureChild(this.f811a, i, i2);
        measureChild(this.f821k, i, i2);
        int max = Math.max(this.f820j.getMeasuredWidth(), Math.max(this.f814d.getMeasuredWidth(), this.f811a.getMeasuredWidth()));
        int max2 = Math.max(this.f820j.getMeasuredHeight(), Math.max(this.f814d.getMeasuredHeight() - this.f817g.getMeasuredHeight(), this.f811a.getMeasuredHeight()));
        int resolveSize = resolveSize(Math.max(getSuggestedMinimumWidth(), paddingLeft + max), i);
        max2 = resolveSize(Math.max(getSuggestedMinimumHeight(), max2 + paddingTop), i2);
        this.f820j.measure(MeasureSpec.makeMeasureSpec(max, 1073741824), MeasureSpec.makeMeasureSpec(this.f820j.getMeasuredHeight(), 1073741824));
        this.f814d.measure(MeasureSpec.makeMeasureSpec(max, 1073741824), MeasureSpec.makeMeasureSpec(this.f814d.getMeasuredHeight(), 1073741824));
        this.f813c.measure(MeasureSpec.makeMeasureSpec(max, 1073741824), MeasureSpec.makeMeasureSpec(0, 0));
        this.f812b.measure(MeasureSpec.makeMeasureSpec(max, 1073741824), MeasureSpec.makeMeasureSpec(0, 0));
        int measuredHeight = this.f820j.getMeasuredHeight();
        int measuredHeight2 = this.f818h.getMeasuredHeight();
        int measuredHeight3 = this.f819i.getMeasuredHeight();
        paddingLeft = m1214l() == null ? 0 : m1214l().getMeasuredHeight();
        if (m1216m() != null) {
            i3 = m1216m().getMeasuredHeight();
        }
        int i4 = this.f822l.left;
        paddingLeft = (paddingLeft + (((measuredHeight + measuredHeight2) + measuredHeight3) + this.f822l.top)) - m1205h();
        int i5 = this.f822l.right;
        i3 = (i3 + this.f822l.bottom) - m1207i();
        if (!(this.f811a.getPaddingLeft() == i4 && this.f811a.getPaddingTop() == paddingLeft && this.f811a.getPaddingRight() == i5 && this.f811a.getPaddingBottom() == i3)) {
            this.f811a.setPadding(i4, paddingLeft, i5, i3);
        }
        this.f811a.measure(MeasureSpec.makeMeasureSpec(max, 1073741824), MeasureSpec.makeMeasureSpec(max2 - paddingTop, 1073741824));
        this.f811a.setMaxOverScrollHeight(((this.f815e.getMeasuredHeight() - measuredHeight) - measuredHeight2) - measuredHeight3);
        setMeasuredDimension(resolveSize, max2);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        int i5 = (z || this.f831u != this.f814d.getMeasuredHeight()) ? 1 : 0;
        this.f831u = this.f814d.getMeasuredHeight();
        this.f820j.layout(paddingLeft, paddingTop, this.f820j.getMeasuredWidth() + paddingLeft, this.f820j.getMeasuredHeight() + paddingTop);
        this.f814d.layout(paddingLeft, paddingTop, this.f814d.getMeasuredWidth() + paddingLeft, this.f814d.getMeasuredHeight() + paddingTop);
        this.f813c.layout(paddingLeft, paddingTop, this.f813c.getMeasuredWidth() + paddingLeft, this.f813c.getMeasuredHeight() + paddingTop);
        this.f812b.layout(paddingLeft, paddingTop, this.f812b.getMeasuredWidth() + paddingLeft, this.f812b.getMeasuredHeight() + paddingTop);
        this.f811a.layout(paddingLeft, paddingTop, this.f811a.getMeasuredWidth() + paddingLeft, this.f811a.getMeasuredHeight() + paddingTop);
        this.f821k.layout(width - this.f821k.getMeasuredWidth(), height - this.f821k.getMeasuredHeight(), width, height);
        if (i5 != 0) {
            this.f811a.m1138e();
        } else if (getScrollState() == ScrollState.IDLE) {
            this.f811a.scrollBy(0, 0);
        }
        this.f811a.m1124b(0, this.f820j.getHeight() + dv.m1932b(getContext(), 2.0f), dv.m1932b(getContext(), 2.0f), dv.m1932b(getContext(), 6.0f));
    }

    /* renamed from: a */
    protected void mo1621a(PointF pointF) {
    }

    /* renamed from: a */
    protected void mo1750a(ScrollState scrollState, RectF rectF) {
    }

    /* renamed from: a */
    private void m1191a(HatTipState hatTipState) {
        if (this.f834x != hatTipState) {
            HatTipState hatTipState2 = this.f834x;
            if (hatTipState2 != HatTipState.DOCKING || hatTipState != HatTipState.UNDOCKED) {
                if (hatTipState2 != HatTipState.DOCKED || hatTipState != HatTipState.UNDOCKED) {
                    if (hatTipState2 != HatTipState.UNDOCKING || hatTipState != HatTipState.DOCKED) {
                        if (hatTipState2 != HatTipState.UNDOCKED || hatTipState != HatTipState.DOCKED) {
                            this.f834x = hatTipState;
                            if (this.f809C != null) {
                                this.f809C.m1583a(hatTipState2, this.f834x);
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: h */
    private int m1205h() {
        return m1214l() == null ? 0 : this.f825o;
    }

    /* renamed from: i */
    private int m1207i() {
        return m1216m() == null ? 0 : this.f826p;
    }

    /* renamed from: j */
    private final int m1209j() {
        return m1214l() == null ? 0 : m1214l().getHeight();
    }

    /* renamed from: k */
    private final int m1211k() {
        return m1216m() == null ? 0 : m1216m().getHeight();
    }

    /* renamed from: l */
    private final View m1214l() {
        if (this.f813c.getChildCount() > 0) {
            return this.f813c.getChildAt(0);
        }
        return null;
    }

    /* renamed from: a */
    private final void m1190a(View view) {
        this.f813c.removeAllViews();
        if (view != null) {
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new LayoutParams(-1, -2));
            }
            this.f813c.addView(view);
        }
    }

    /* renamed from: m */
    private final View m1216m() {
        if (this.f812b.getChildCount() > 0) {
            return this.f812b.getChildAt(0);
        }
        return null;
    }

    /* renamed from: b */
    private final void m1198b(View view) {
        this.f812b.removeAllViews();
        if (view != null) {
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new LayoutParams(-1, -2));
            }
            this.f812b.addView(view);
        }
    }

    /* renamed from: n */
    private final int m1217n() {
        return m1219o() + m1225r();
    }

    /* renamed from: o */
    private final int m1219o() {
        return m1221p() + m1229t();
    }

    /* renamed from: p */
    private final int m1221p() {
        return (getHatTipView() == null ? 0 : getHatTipView().getTop()) + (this.f817g.getTop() + this.f815e.getTop());
    }

    /* renamed from: q */
    private final int m1223q() {
        if (!this.f832v) {
            return 0;
        }
        if (this.f833w < 0) {
            return m1225r();
        }
        return Math.min(this.f833w, m1225r());
    }

    /* renamed from: r */
    private final int m1225r() {
        return getHatTipView() == null ? 0 : getHatTipView().getHeight();
    }

    /* renamed from: s */
    private final int m1227s() {
        return this.f818h.getHeight();
    }

    /* renamed from: t */
    private final int m1229t() {
        return (-m1233v()) + this.f820j.getHeight();
    }

    /* renamed from: u */
    private final int m1231u() {
        return this.f814d.getScrollY() + this.f820j.getBottom();
    }

    /* renamed from: v */
    private final int m1233v() {
        return this.f815e.getTop() + this.f818h.getTop();
    }

    /* renamed from: w */
    private void m1236w() {
        if (this.f821k.isEnabled() && this.f821k.getVisibility() != 0) {
            this.f821k.clearAnimation();
            this.f821k.setVisibility(0);
            dv.showAnimation(this.f821k, null);
        }
    }

    /* renamed from: x */
    private void m1237x() {
        if (this.f821k.isEnabled() && this.f821k.getVisibility() != 4) {
            this.f821k.clearAnimation();
            this.f821k.setVisibility(4);
            dv.hideAnimation(this.f821k, null);
        }
    }

    /* renamed from: a */
    private void m1195a(ScrollState scrollState, ScrollState scrollState2) {
        if (this.f821k.isEnabled()) {
            if (this.f807A != null) {
                removeCallbacks(this.f807A);
                this.f807A = null;
            }
            if (scrollState2 != ScrollState.IDLE) {
                return;
            }
            if (getHatBodyVisibleHeight() > 0) {
                m1237x();
            } else if (this.f807A == null) {
                this.f807A = new C0398z(this);
                postDelayed(this.f807A, 2000);
            }
        }
    }

    /* renamed from: a */
    protected void mo1622a(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            if (this.f832v) {
                this.f811a.setVerticalOverScrollMode(OverScrollMode.ALWAYS);
            } else {
                this.f811a.setVerticalOverScrollMode(this.f824n);
            }
        } else if (motionEvent.getActionMasked() != 1 && motionEvent.getActionMasked() == 3) {
        }
    }
}
