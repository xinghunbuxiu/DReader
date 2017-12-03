package com.duokan.reader.ui.bookshelf;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.OvershootInterpolator;
import android.view.animation.Transformation;
import android.widget.TextView;

import com.duokan.core.ui.UTools;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.BookshelfItemStyle;
import com.duokan.reader.domain.bookshelf.BookState;
import com.duokan.reader.domain.bookshelf.aa;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.an;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.ej;
import com.duokan.reader.domain.bookshelf.iz;
import com.duokan.reader.domain.bookshelf.js;
import com.duokan.reader.domain.micloud.i;
import com.duokan.reader.ui.general.cn;
import com.duokan.reader.ui.general.et;
import com.duokan.reader.ui.general.f;
import com.duokan.reader.ui.general.z;

import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import java.util.LinkedList;

public class cz extends ViewGroup {
    private static final int a = Color.argb(Math.round(178.5f), 0, 0, 0);
    private static final int c = Color.argb(Math.round(76.5f), 0, 0, 0);
    private static final LinkedList d = new LinkedList();
    private static Rect e = null;
    private static Rect f = null;
    private static dd g = null;
    private static df h = null;
    private et A;
    private final Transformation B;
    private AlphaAnimation C;
    private an D;
    private f E;
    private ad F;
    protected final Callback b;
    private final cr i;
    private final TextView j;
    private final TextView k;
    private int l;
    private RectF m;
    private RectF n;
    private PointF o;
    private ag p;
    private ValueAnimator q;
    private float r;
    private az s;
    private boolean t;
    private DragItemStatus u;
    private int v;
    private boolean w;
    private int x;
    private final Drawable y;
    private final Drawable z;

    public void b() {
        this.j.setText("");
        this.k.setText("");
    }

    public void setSelectedCountInEditMode(int i) {
        if (this.x != i) {
            this.x = i;
            if (p()) {
                invalidate();
            } else {
                n();
            }
        }
    }

    public void setInSelectMode(boolean z) {
        this.w = z;
    }

    public int getSelectedCountInEditMode() {
        return this.x;
    }

    private void setLatestChapterCount(int i) {
        if (this.v != i) {
            this.v = i;
            invalidate();
        }
    }

    public void setShowOption(int i) {
        if (this.l != i) {
            this.l = i;
            switch (this.l) {
                case 1:
                    this.j.setVisibility(0);
                    this.k.setVisibility(8);
                    return;
                case 2:
                    this.j.setVisibility(8);
                    this.k.setVisibility(8);
                    return;
                default:
                    this.j.setVisibility(0);
                    this.k.setVisibility(0);
                    if (e()) {
                        this.k.setText(a(getBook().D()));
                        return;
                    }
                    return;
            }
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    public void draw(Canvas canvas) {
        if (!this.t) {
            super.draw(canvas);
            Rect rect = (Rect) UTools.g.getRect();
            a(rect);
            if (this.u != DragItemStatus.Draged) {
                a(canvas, rect);
                if (getAlpha() != 1.0f) {
                    setAlpha(1.0f);
                }
            } else if (getAlpha() != 0.3f) {
                setAlpha(0.3f);
            }
            UTools.g.getRect(rect);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect rect = (Rect) UTools.g.getRect();
        a(rect);
        getCoverDrawable().draw(canvas);
        if (e()) {
            c(canvas, rect);
        }
        if (isPressed()) {
            b(canvas, rect);
        }
        UTools.g.getRect(rect);
    }

    protected void onMeasure(int i, int i2) {
        int i3 = e.left + e.right;
        int i4 = e.top + e.bottom;
        int dimensionPixelSize = MeasureSpec.getMode(i) == 0 ? getResources().getDimensionPixelSize(e.general__shared__cover_grid_width) : MeasureSpec.getSize(i) - i3;
        getCoverDrawable().setBounds(0, 0, dimensionPixelSize + i3, Math.round(((float) dimensionPixelSize) * 1.390625f) + i4);
        dimensionPixelSize = getCoverDrawable().getBounds().width();
        int height = getCoverDrawable().getBounds().height() + o();
        measureChildren(MeasureSpec.makeMeasureSpec(dimensionPixelSize - i3, 1073741824), MeasureSpec.makeMeasureSpec(height - i4, 1073741824));
        setMeasuredDimension(dimensionPixelSize, height);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.l != 2) {
            this.j.layout(e.left, (i4 - i2) - o(), (i3 - i) - e.right, ((i4 - i2) - o()) + this.j.getMeasuredHeight());
            if (this.l != 1) {
                this.k.layout(e.left, this.j.getBottom(), (i3 - i) - e.right, this.j.getBottom() + this.k.getMeasuredHeight());
            }
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        d.add(new WeakReference(this));
        if (g == null) {
            g = new dd();
            iz.a().c(g);
            ai.a().a(g);
            ai.a().a(g);
        }
        if (h == null) {
            h = new df();
            ReaderEnv.get().setOnBookshelfItemStyleChangedListener(h);
        }
    }

    public z getItemDrawable() {
        return (z) getCoverDrawable();
    }

    public RectF getDragBounds() {
        if (this.n == null) {
            this.n = new RectF();
        }
        this.n.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
        UTools.showAnimation(this.n, (View) this);
        return this.n;
    }

    public RectF getViewBounds() {
        if (this.m == null) {
            this.m = new RectF();
        }
        Rect rect = (Rect) UTools.g.getRect();
        getCategoryCoverDrawable().getPadding(rect);
        this.m.set((float) rect.left, (float) rect.top, (float) (getWidth() - rect.right), (float) ((getHeight() - rect.bottom) - o()));
        UTools.showAnimation(this.m, (View) this);
        UTools.g.getRect(rect);
        return this.m;
    }

    public PointF getViewCenter() {
        if (this.o == null) {
            this.o = new PointF();
        }
        this.o.set(((float) getWidth()) / 2.0f, ((float) (getHeight() - o())) / 2.0f);
        UTools.getScaledTouchSlop(this.o, (View) this);
        return this.o;
    }

    public DragItemStatus getItemStatus() {
        return this.u;
    }

    public void setItemStatus(DragItemStatus dragItemStatus) {
        if (this.u != dragItemStatus) {
            this.u = dragItemStatus;
            invalidate();
        }
        if (this.u == DragItemStatus.Normal) {
            this.t = false;
        }
    }

    public void c() {
        if (!this.t) {
            a.a(this, 1.0f, 0.0f, 200, Boolean.valueOf(false), new db(this));
        }
    }

    public void d() {
        if (this.t) {
            this.t = false;
            invalidate();
            a.a(this, 0.0f, 1.0f, 200, Boolean.valueOf(false), null);
        }
    }

    protected void a() {
        setShowOption(ReaderEnv.get().getBookshelfItemStyle() == BookshelfItemStyle.SIMPLE ? 1 : 0);
    }

    protected void a(Rect rect) {
        rect.set(getCoverDrawable().getBounds());
        Rect rect2 = (Rect) UTools.g.getRect();
        if (!e()) {
            rect2.set(e);
        } else if (((f) getCoverDrawable()).c()) {
            if (f == null) {
                f = new Rect();
                getCoverDrawable().getPadding(f);
            }
            rect2.set(f);
        }
        rect.left += rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
        UTools.g.getRect(rect2);
    }

    protected void a(Canvas canvas, Rect rect) {
        if (!e() || !getBookCoverDrawable().d()) {
            if (this.w) {
                canvas.save();
                Drawable drawable = getSelectedCountInEditMode() > 0 ? this.y : this.z;
                canvas.translate((float) (rect.right - ((drawable.getIntrinsicWidth() / 3) * 2)), (float) (rect.top - (drawable.getIntrinsicHeight() / 3)));
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                float checkAnimateScale = getCheckAnimateScale();
                canvas.scale(checkAnimateScale, checkAnimateScale, (float) (drawable.getIntrinsicWidth() / 2), (float) (drawable.getIntrinsicHeight() / 2));
                drawable.draw(canvas);
                canvas.restore();
            } else if (this.v > 0) {
                canvas.save();
                canvas.translate((float) (rect.left + UTools.closeAnimation(getContext(), 2.0f)), (float) (rect.top + UTools.closeAnimation(getContext(), 3.0f)));
                this.A.a(String.format(getResources().getString(j.bookshelf__shared__d_new_chapters), new Object[]{Integer.valueOf(this.v)}));
                this.A.setBounds(0, 0, this.A.a(), this.A.getIntrinsicHeight());
                this.A.draw(canvas);
                canvas.restore();
            }
        }
    }

    private void b(Canvas canvas, Rect rect) {
        Paint paint = (Paint) UTools.b.getRect();
        paint.setColor(Color.argb(48, 0, 0, 0));
        canvas.drawRect(rect, paint);
        UTools.b.getRect(paint);
    }

    private void c(Canvas canvas, Rect rect) {
        float f = 0.0f;
        if (!e() || !getBookCoverDrawable().d()) {
            i b;
            c cVar = (c) this.D;
            int i = (cVar.S() || this.q != null) ? 1 : 0;
            if (i != 0) {
                float f2;
                float f3;
                if (cVar.i() == BookState.CLOUD_ONLY) {
                    f2 = 0.0f;
                } else if (cVar.Y()) {
                    f2 = 0.0f;
                } else {
                    f2 = cVar.m() / 100.0f;
                }
                if (this.q != null) {
                    if (cVar.X() || cVar.W() || cVar.Y()) {
                        this.q.cancel();
                        this.q = null;
                        this.r = 0.0f;
                    } else if (cVar.S()) {
                        if (!(this.q.isRunning() || Float.compare(this.r, f2) == 0)) {
                            this.q.setFloatValues(new float[]{((Float) this.q.getAnimatedValue()).floatValue(), f2});
                            this.q.start();
                            this.r = f2;
                        }
                    } else if (Float.compare(this.r, f2) != 0) {
                        this.q.setFloatValues(new float[]{((Float) this.q.getAnimatedValue()).floatValue(), f2});
                        this.q.setDuration(200);
                        this.q.start();
                        this.r = f2;
                    }
                } else if (cVar.V() && !cVar.X()) {
                    this.q = ValueAnimator.ofFloat(new float[]{f2, f2}).setDuration(800);
                    this.q.start();
                    this.r = f2;
                }
                if (this.q != null) {
                    f2 = ((Float) this.q.getAnimatedValue()).floatValue();
                    if (!this.q.isRunning()) {
                        this.q = null;
                        this.r = 0.0f;
                    }
                    invalidate();
                    f3 = f2;
                } else {
                    f3 = f2;
                }
                if (!cVar.j() && (this.q != null || cVar.V())) {
                    Rect rect2 = (Rect) UTools.g.getRect();
                    rect2.set(rect);
                    rect2.bottom -= Math.round(((float) rect2.height()) * f3);
                    Paint paint = (Paint) UTools.b.getRect();
                    paint.setColor(Color.argb(153, 0, 0, 0));
                    canvas.drawRect(rect2, paint);
                    UTools.b.getRect(paint);
                    UTools.g.getRect(rect2);
                }
                if (this.p == null) {
                    this.p = new ag(getContext());
                    this.p.setCallback(this.b);
                }
                if (this.q != null || cVar.U()) {
                    this.p.start();
                } else {
                    this.p.stop();
                }
                canvas.translate((float) UTools.closeAnimation(getContext(), 4.0f), (float) (-UTools.closeAnimation(getContext(), 5.0f)));
                this.p.setLevel(Math.round(10000.0f * f3));
                UTools.addAnimation(canvas, this.p, rect, 83);
                canvas.translate((float) (-UTools.closeAnimation(getContext(), 4.0f)), (float) UTools.closeAnimation(getContext(), 5.0f));
            } else if (this.p != null) {
                this.p.stop();
                this.p = null;
            }
            if (cVar.ai() || cVar.am()) {
                i = 0;
            } else {
                i = 1;
            }
            if (i != 0) {
                b = iz.a().b(cVar.e());
            } else {
                b = null;
            }
            if (i != 0) {
                if (b != null) {
                    f = ((float) b.F()) / ((float) b.C());
                }
                if (this.s == null) {
                    this.s = new az(getContext());
                    this.s.setCallback(this.b);
                }
                if (b == null || !b.h()) {
                    this.s.stop();
                } else {
                    this.s.start();
                }
                canvas.translate((float) UTools.closeAnimation(getContext(), 4.0f), (float) (-UTools.closeAnimation(getContext(), 5.0f)));
                this.s.setLevel(Math.round(10000.0f * f));
                UTools.addAnimation(canvas, this.s, rect, 83);
                canvas.translate((float) (-UTools.closeAnimation(getContext(), 4.0f)), (float) UTools.closeAnimation(getContext(), 5.0f));
            } else if (this.s != null) {
                this.s.stop();
                this.s = null;
            }
        }
    }

    private void n() {
        this.C = new AlphaAnimation(0.0f, 1.0f);
        this.C.setDuration(200);
        this.C.setInterpolator(new OvershootInterpolator());
        this.C.setAnimationListener(new dc(this));
        invalidate();
    }

    private float getCheckAnimateScale() {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (this.C == null || this.C.hasEnded()) {
            return 1.0f;
        }
        if (!this.C.hasStarted()) {
            this.C.setStartTime(currentAnimationTimeMillis);
        }
        this.C.getTransformation(currentAnimationTimeMillis, this.B);
        float alpha = this.B.getAlpha();
        invalidate();
        return alpha;
    }

    private int o() {
        switch (this.l) {
            case 1:
                return UTools.addAnimation(getContext(), 35.0f);
            case 2:
                return UTools.addAnimation(getContext(), 0.0f);
            default:
                return UTools.addAnimation(getContext(), 53.0f);
        }
    }

    public cz(Context context) {
        this(context, null);
    }

    public cz(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = 1;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = 0.0f;
        this.s = null;
        this.t = false;
        this.u = DragItemStatus.Normal;
        this.w = false;
        this.B = new Transformation();
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.b = new da(this);
        if (e == null) {
            e = new Rect();
            Drawable a = cn.a(context, com.duokan.c.f.general__shared__book_category_shadow);
            if (a != null) {
                a.getPadding(e);
            }
        }
        this.i = (cr) x.a(context).queryFeature(cr.class);
        this.j = new TextView(context);
        this.j.setMaxLines(2);
        this.j.setEllipsize(TruncateAt.END);
        this.j.setGravity(3);
        this.j.setTextColor(a);
        this.j.setIncludeFontPadding(false);
        this.j.setTextSize(0, getResources().getDimension(e.general__shared__cover_title_size));
        addView(this.j, new LayoutParams(-1, -2));
        this.k = new TextView(context);
        this.k.setSingleLine();
        this.k.setGravity(3);
        this.k.setTextColor(c);
        this.k.setTextSize(0, getResources().getDimension(e.general__shared__cover_progress_size));
        this.k.setVisibility(8);
        addView(this.k, new LayoutParams(-1, -2));
        this.A = new et(context);
        this.y = getResources().getDrawable(com.duokan.c.f.general__shared__multi_checkbox_checked);
        this.z = getResources().getDrawable(com.duokan.c.f.general__shared__multi_checkbox_normal);
        setWillNotDraw(false);
        setWillNotCacheDrawing(false);
        setDrawingCacheEnabled(false);
        setAnimationCacheEnabled(false);
        a();
    }

    public aa getBookCategory() {
        return (aa) this.D;
    }

    public void setItemData(an anVar) {
        if (this.D != anVar) {
            this.D = anVar;
            if (this.p != null) {
                this.p.stop();
            }
            if (this.q != null) {
                this.q.cancel();
                this.q = null;
            }
        }
        if (e()) {
            c book = getBook();
            this.j.setText(book.aw());
            if (this.l == 0) {
                this.k.setText(a(book.D()));
            }
            setLatestChapterCount(getLatestChapterCount());
            getBookCoverDrawable().a(book, false);
        } else if (f()) {
            aa bookCategory = getBookCategory();
            this.j.setText(bookCategory.h() ? getContext().getString(j.bookshelf__shared__main_category) : bookCategory.k());
            this.k.setText(a(this.i.a(bookCategory).size()));
            setLatestChapterCount(getLatestChapterCount());
            getCategoryCoverDrawable().a(bookCategory);
        }
        invalidate();
    }

    public boolean e() {
        return this.D instanceof c;
    }

    public boolean f() {
        return this.D instanceof aa;
    }

    public an getItem() {
        return this.D;
    }

    private boolean p() {
        return f();
    }

    private void a(i iVar) {
        invalidate();
    }

    private void q() {
        invalidate();
    }

    private String a(js jsVar) {
        if (jsVar.a()) {
            return getResources().getString(j.bookshelf__bookshelf_item_view__unread);
        }
        DecimalFormat decimalFormat = new DecimalFormat("0.#");
        return String.format(getResources().getString(j.bookshelf__bookshelf_item_view__read_s), new Object[]{decimalFormat.format((double) jsVar.e)});
    }

    private String a(int i) {
        return String.format(getResources().getString(j.bookshelf__bookshelf_item_view__total_d_books), new Object[]{Integer.valueOf(i)});
    }

    public boolean g() {
        return true;
    }

    public boolean h() {
        return e();
    }

    public boolean i() {
        return true;
    }

    public boolean j() {
        return true;
    }

    public void a(Rect rect, long j) {
        if (f()) {
            getCategoryCoverDrawable().a(rect, j);
        } else {
            Rect rect2 = (Rect) UTools.g.getRect();
            rect2.set(getCategoryCoverDrawable().getBounds().isEmpty() ? getBookCoverDrawable().getBounds() : getCategoryCoverDrawable().getBounds());
            getCategoryCoverDrawable().a(rect2, rect, 0);
            Rect rect3 = (Rect) UTools.g.getRect();
            getCategoryCoverDrawable().a(rect2, rect3, 1);
            getBookCoverDrawable().a(rect3, j);
            UTools.g.getRect(rect3);
            UTools.g.getRect(rect2);
        }
        UTools.closeAnimation(rect, (View) this);
    }

    public boolean k() {
        if (this.u == DragItemStatus.Actived || this.u == DragItemStatus.Draged || !j()) {
            return false;
        }
        setItemStatus(DragItemStatus.Actived);
        ((z) getCoverDrawable()).f();
        return true;
    }

    public boolean l() {
        if (this.u != DragItemStatus.Actived) {
            return false;
        }
        setItemStatus(DragItemStatus.Normal);
        ((z) getCoverDrawable()).g();
        return true;
    }

    private int getLatestChapterCount() {
        if (f()) {
            int i = 0;
            for (an anVar : this.i.a(getBookCategory())) {
                int ba;
                if (anVar instanceof ej) {
                    ej ejVar = (ej) anVar;
                    if (ejVar.k()) {
                        ba = i + ejVar.ba();
                        i = ba;
                    }
                }
                ba = i;
                i = ba;
            }
            return i;
        } else if (e() && getBook().k()) {
            return ((ej) getBook()).ba();
        } else {
            return 0;
        }
    }

    protected Drawable getCoverDrawable() {
        return e() ? getBookCoverDrawable() : getCategoryCoverDrawable();
    }

    protected f getBookCoverDrawable() {
        if (this.E == null) {
            this.E = new f(getContext(), com.duokan.c.f.general__shared__book_shadow);
            this.E.setCallback(this.b);
        }
        return this.E;
    }

    private ad getCategoryCoverDrawable() {
        if (this.F == null) {
            this.F = new ad(getContext());
            this.F.setCallback(this.b);
        }
        return this.F;
    }

    private c getBook() {
        return (c) this.D;
    }
}
