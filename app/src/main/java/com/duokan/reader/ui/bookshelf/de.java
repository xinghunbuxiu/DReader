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
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.OvershootInterpolator;
import android.view.animation.Transformation;
import android.widget.TextView;
import com.duokan.core.app.AppContext;
import com.duokan.core.sys.ah;
import com.duokan.core.ui.AnimUtils;
import com.duokan.p024c.C0253e;
import com.duokan.p024c.C0254f;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.BookshelfItemStyle;
import com.duokan.reader.domain.bookshelf.BookState;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.aa;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.an;
import com.duokan.reader.domain.bookshelf.ee;
import com.duokan.reader.domain.bookshelf.it;
import com.duokan.reader.domain.bookshelf.ke;
import com.duokan.reader.domain.micloud.C1068i;
import com.duokan.reader.ui.general.C1283z;
import com.duokan.reader.ui.general.C1332f;
import com.duokan.reader.ui.general.cn;
import com.duokan.reader.ui.general.er;
import com.duokan.reader.ui.general.p052a.C1317a;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import java.util.LinkedList;

public class de extends ViewGroup {
    /* renamed from: a */
    private static final int f6046a = Color.argb(Math.round(178.5f), 0, 0, 0);
    /* renamed from: c */
    private static final int f6047c = Color.argb(Math.round(76.5f), 0, 0, 0);
    /* renamed from: d */
    private static final LinkedList<WeakReference<de>> f6048d = new LinkedList();
    /* renamed from: e */
    private static Rect f6049e = null;
    /* renamed from: f */
    private static Rect f6050f = null;
    /* renamed from: g */
    private static dk f6051g = null;
    /* renamed from: h */
    private static dm f6052h = null;
    /* renamed from: A */
    private er f6053A;
    /* renamed from: B */
    private final Transformation f6054B;
    /* renamed from: C */
    private AlphaAnimation f6055C;
    /* renamed from: D */
    private an f6056D;
    /* renamed from: E */
    private C1332f f6057E;
    /* renamed from: F */
    private aj f6058F;
    /* renamed from: b */
    protected final Callback f6059b;
    /* renamed from: i */
    private final cw f6060i;
    /* renamed from: j */
    private final TextView f6061j;
    /* renamed from: k */
    private final TextView f6062k;
    /* renamed from: l */
    private int f6063l;
    /* renamed from: m */
    private RectF f6064m;
    /* renamed from: n */
    private RectF f6065n;
    /* renamed from: o */
    private PointF f6066o;
    /* renamed from: p */
    private am f6067p;
    /* renamed from: q */
    private ValueAnimator f6068q;
    /* renamed from: r */
    private float f6069r;
    /* renamed from: s */
    private bf f6070s;
    /* renamed from: t */
    private boolean f6071t;
    /* renamed from: u */
    private DragItemStatus f6072u;
    /* renamed from: v */
    private int f6073v;
    /* renamed from: w */
    private boolean f6074w;
    /* renamed from: x */
    private int f6075x;
    /* renamed from: y */
    private final Drawable f6076y;
    /* renamed from: z */
    private final Drawable f6077z;

    /* renamed from: b */
    public void m9114b() {
        this.f6061j.setText("");
        this.f6062k.setText("");
    }

    public void setSelectedCountInEditMode(int i) {
        if (this.f6075x != i) {
            this.f6075x = i;
            if (m9108p()) {
                invalidate();
            } else {
                m9106n();
            }
        }
    }

    public void setInSelectMode(boolean z) {
        this.f6074w = z;
    }

    public int getSelectedCountInEditMode() {
        return this.f6075x;
    }

    private void setLatestChapterCount(int i) {
        if (this.f6073v != i) {
            this.f6073v = i;
            invalidate();
        }
    }

    public void setShowOption(int i) {
        if (this.f6063l != i) {
            this.f6063l = i;
            switch (this.f6063l) {
                case 1:
                    this.f6061j.setVisibility(0);
                    this.f6062k.setVisibility(8);
                    return;
                case 2:
                    this.f6061j.setVisibility(8);
                    this.f6062k.setVisibility(8);
                    return;
                default:
                    this.f6061j.setVisibility(0);
                    this.f6062k.setVisibility(0);
                    if (m9117e()) {
                        this.f6062k.setText(m9098a(getBook().m4152E()));
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
        if (!this.f6071t) {
            super.draw(canvas);
            Rect rect = (Rect) AnimUtils.f1198g.addAnimation();
            mo1636a(rect);
            if (this.f6072u != DragItemStatus.Draged) {
                m9111a(canvas, rect);
                if (getAlpha() != 1.0f) {
                    setAlpha(1.0f);
                }
            } else if (getAlpha() != 0.3f) {
                setAlpha(0.3f);
            }
            AnimUtils.f1198g.clearAnimation(rect);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect rect = (Rect) AnimUtils.f1198g.addAnimation();
        mo1636a(rect);
        getCoverDrawable().draw(canvas);
        if (m9117e()) {
            m9104c(canvas, rect);
        }
        if (isPressed()) {
            m9102b(canvas, rect);
        }
        AnimUtils.f1198g.clearAnimation(rect);
    }

    protected void onMeasure(int i, int i2) {
        int i3 = f6049e.left + f6049e.right;
        int i4 = f6049e.top + f6049e.bottom;
        int dimensionPixelSize = MeasureSpec.getMode(i) == 0 ? getResources().getDimensionPixelSize(C0253e.general__shared__cover_grid_width) : MeasureSpec.getSize(i) - i3;
        getCoverDrawable().setBounds(0, 0, dimensionPixelSize + i3, Math.round(((float) dimensionPixelSize) * 1.390625f) + i4);
        dimensionPixelSize = getCoverDrawable().getBounds().width();
        int height = getCoverDrawable().getBounds().height() + m9107o();
        measureChildren(MeasureSpec.makeMeasureSpec(dimensionPixelSize - i3, 1073741824), MeasureSpec.makeMeasureSpec(height - i4, 1073741824));
        setMeasuredDimension(dimensionPixelSize, height);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f6063l != 2) {
            this.f6061j.layout(f6049e.left, (i4 - i2) - m9107o(), (i3 - i) - f6049e.right, ((i4 - i2) - m9107o()) + this.f6061j.getMeasuredHeight());
            if (this.f6063l != 1) {
                this.f6062k.layout(f6049e.left, this.f6061j.getBottom(), (i3 - i) - f6049e.right, this.f6061j.getBottom() + this.f6062k.getMeasuredHeight());
            }
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        f6048d.add(new WeakReference(this));
        if (f6051g == null) {
            f6051g = new dk();
            it.m4692a().m4731c(f6051g);
            ai.m3980a().m3889a(f6051g);
            ai.m3980a().m3887a(f6051g);
        }
        if (f6052h == null) {
            f6052h = new dm();
            ReaderEnv.get().setOnBookshelfItemStyleChangedListener(f6052h);
        }
    }

    public C1283z getItemDrawable() {
        return (C1283z) getCoverDrawable();
    }

    public RectF getDragBounds() {
        if (this.f6065n == null) {
            this.f6065n = new RectF();
        }
        this.f6065n.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
        AnimUtils.m1947c(this.f6065n, (View) this);
        return this.f6065n;
    }

    public RectF getViewBounds() {
        if (this.f6064m == null) {
            this.f6064m = new RectF();
        }
        Rect rect = (Rect) AnimUtils.f1198g.addAnimation();
        getCategoryCoverDrawable().getPadding(rect);
        this.f6064m.set((float) rect.left, (float) rect.top, (float) (getWidth() - rect.right), (float) ((getHeight() - rect.bottom) - m9107o()));
        AnimUtils.m1947c(this.f6064m, (View) this);
        AnimUtils.f1198g.clearAnimation(rect);
        return this.f6064m;
    }

    public PointF getViewCenter() {
        if (this.f6066o == null) {
            this.f6066o = new PointF();
        }
        this.f6066o.set(((float) getWidth()) / 2.0f, ((float) (getHeight() - m9107o())) / 2.0f);
        AnimUtils.m1953d(this.f6066o, (View) this);
        return this.f6066o;
    }

    public DragItemStatus getItemStatus() {
        return this.f6072u;
    }

    public void setItemStatus(DragItemStatus dragItemStatus) {
        if (this.f6072u != dragItemStatus) {
            this.f6072u = dragItemStatus;
            invalidate();
        }
        if (this.f6072u == DragItemStatus.Normal) {
            this.f6071t = false;
        }
    }

    /* renamed from: c */
    public void m9115c() {
        if (!this.f6071t) {
            C1317a.m10193a(this, 1.0f, 0.0f, 200, Boolean.valueOf(false), new dg(this));
        }
    }

    /* renamed from: d */
    public void m9116d() {
        if (this.f6071t) {
            this.f6071t = false;
            invalidate();
            C1317a.m10193a(this, 0.0f, 1.0f, 200, Boolean.valueOf(false), null);
        }
    }

    /* renamed from: a */
    protected void mo1635a() {
        setShowOption(ReaderEnv.get().getBookshelfItemStyle() == BookshelfItemStyle.SIMPLE ? 1 : 0);
    }

    /* renamed from: a */
    protected void mo1636a(Rect rect) {
        rect.set(getCoverDrawable().getBounds());
        Rect rect2 = (Rect) AnimUtils.f1198g.addAnimation();
        if (!m9117e()) {
            rect2.set(f6049e);
        } else if (((C1332f) getCoverDrawable()).m10612c()) {
            if (f6050f == null) {
                f6050f = new Rect();
                getCoverDrawable().getPadding(f6050f);
            }
            rect2.set(f6050f);
        }
        rect.left += rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
        AnimUtils.f1198g.clearAnimation(rect2);
    }

    /* renamed from: a */
    protected void m9111a(Canvas canvas, Rect rect) {
        if (!m9117e() || !getBookCoverDrawable().m10613d()) {
            if (this.f6074w) {
                canvas.save();
                Drawable drawable = getSelectedCountInEditMode() > 0 ? this.f6076y : this.f6077z;
                canvas.translate((float) (rect.right - ((drawable.getIntrinsicWidth() / 3) * 2)), (float) (rect.top - (drawable.getIntrinsicHeight() / 3)));
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                float checkAnimateScale = getCheckAnimateScale();
                canvas.scale(checkAnimateScale, checkAnimateScale, (float) (drawable.getIntrinsicWidth() / 2), (float) (drawable.getIntrinsicHeight() / 2));
                drawable.draw(canvas);
                canvas.restore();
            } else if (this.f6073v > 0) {
                canvas.save();
                canvas.translate((float) (rect.left + AnimUtils.m1932b(getContext(), 2.0f)), (float) (rect.top + AnimUtils.m1932b(getContext(), 3.0f)));
                this.f6053A.m10570a(String.format(getResources().getString(C0258j.bookshelf__shared__d_new_chapters), new Object[]{Integer.valueOf(this.f6073v)}));
                this.f6053A.setBounds(0, 0, this.f6053A.m10569a(), this.f6053A.getIntrinsicHeight());
                this.f6053A.draw(canvas);
                canvas.restore();
            }
        }
    }

    /* renamed from: b */
    private void m9102b(Canvas canvas, Rect rect) {
        Paint paint = (Paint) AnimUtils.f1193b.addAnimation();
        paint.setColor(Color.argb(48, 0, 0, 0));
        canvas.drawRect(rect, paint);
        AnimUtils.f1193b.clearAnimation(paint);
    }

    /* renamed from: c */
    private void m9104c(Canvas canvas, Rect rect) {
        if (!m9117e() || !getBookCoverDrawable().m10613d()) {
            C0800c c0800c = (C0800c) this.f6056D;
            int i = (c0800c.m4168U() || this.f6068q != null) ? 1 : 0;
            if (i != 0) {
                float f;
                float f2;
                if (c0800c.m4233i() == BookState.CLOUD_ONLY) {
                    f = 0.0f;
                } else if (c0800c.aa()) {
                    f = 0.0f;
                } else {
                    f = c0800c.m4240m() / 100.0f;
                }
                if (this.f6068q != null) {
                    if (c0800c.m4173Z() || c0800c.m4172Y() || c0800c.aa()) {
                        this.f6068q.cancel();
                        this.f6068q = null;
                        this.f6069r = 0.0f;
                    } else if (c0800c.m4168U()) {
                        if (!(this.f6068q.isRunning() || Float.compare(this.f6069r, f) == 0)) {
                            this.f6068q.setFloatValues(new float[]{((Float) this.f6068q.getAnimatedValue()).floatValue(), f});
                            this.f6068q.start();
                            this.f6069r = f;
                        }
                    } else if (Float.compare(this.f6069r, f) != 0) {
                        this.f6068q.setFloatValues(new float[]{((Float) this.f6068q.getAnimatedValue()).floatValue(), f});
                        this.f6068q.setDuration(200);
                        this.f6068q.start();
                        this.f6069r = f;
                    }
                } else if (c0800c.m4171X() && !c0800c.m4173Z()) {
                    this.f6068q = ValueAnimator.ofFloat(new float[]{f, f}).setDuration(800);
                    this.f6068q.start();
                    this.f6069r = f;
                }
                if (this.f6068q != null) {
                    f = ((Float) this.f6068q.getAnimatedValue()).floatValue();
                    if (!this.f6068q.isRunning()) {
                        this.f6068q = null;
                        this.f6069r = 0.0f;
                    }
                    invalidate();
                    f2 = f;
                } else {
                    f2 = f;
                }
                if (!c0800c.mo1037j() && (this.f6068q != null || c0800c.m4171X())) {
                    Rect rect2 = (Rect) AnimUtils.f1198g.addAnimation();
                    rect2.set(rect);
                    rect2.bottom -= Math.round(((float) rect2.height()) * f2);
                    Paint paint = (Paint) AnimUtils.f1193b.addAnimation();
                    paint.setColor(Color.argb(153, 0, 0, 0));
                    canvas.drawRect(rect2, paint);
                    AnimUtils.f1193b.clearAnimation(paint);
                    AnimUtils.f1198g.clearAnimation(rect2);
                }
                if (this.f6067p == null) {
                    this.f6067p = new am(getContext());
                    this.f6067p.setCallback(this.f6059b);
                }
                if (this.f6068q != null || c0800c.m4170W()) {
                    this.f6067p.start();
                } else {
                    this.f6067p.stop();
                }
                canvas.translate((float) AnimUtils.m1932b(getContext(), 4.0f), (float) (-AnimUtils.m1932b(getContext(), 5.0f)));
                this.f6067p.setLevel(Math.round(10000.0f * f2));
                AnimUtils.m1911a(canvas, this.f6067p, rect, 83);
                canvas.translate((float) (-AnimUtils.m1932b(getContext(), 4.0f)), (float) AnimUtils.m1932b(getContext(), 5.0f));
            } else if (this.f6067p != null) {
                this.f6067p.stop();
                this.f6067p = null;
            }
            if (c0800c.ak() || c0800c.ao()) {
                i = 0;
            } else {
                i = 1;
            }
            if (i != 0) {
                if (this.f6070s == null) {
                    this.f6070s = new bf(getContext());
                    this.f6070s.setCallback(this.f6059b);
                }
                boolean isRunning = this.f6070s.isRunning();
                int level = this.f6070s.getLevel();
                canvas.translate((float) AnimUtils.m1932b(getContext(), 4.0f), (float) (-AnimUtils.m1932b(getContext(), 5.0f)));
                AnimUtils.m1911a(canvas, this.f6070s, rect, 83);
                canvas.translate((float) (-AnimUtils.m1932b(getContext(), 4.0f)), (float) AnimUtils.m1932b(getContext(), 5.0f));
                ah.m865a(new dh(this, c0800c, isRunning, level));
            } else if (this.f6070s != null) {
                this.f6070s.stop();
                this.f6070s = null;
            }
        }
    }

    /* renamed from: n */
    private void m9106n() {
        this.f6055C = new AlphaAnimation(0.0f, 1.0f);
        this.f6055C.setDuration(200);
        this.f6055C.setInterpolator(new OvershootInterpolator());
        this.f6055C.setAnimationListener(new dj(this));
        invalidate();
    }

    private float getCheckAnimateScale() {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (this.f6055C == null || this.f6055C.hasEnded()) {
            return 1.0f;
        }
        if (!this.f6055C.hasStarted()) {
            this.f6055C.setStartTime(currentAnimationTimeMillis);
        }
        this.f6055C.getTransformation(currentAnimationTimeMillis, this.f6054B);
        float alpha = this.f6054B.getAlpha();
        invalidate();
        return alpha;
    }

    /* renamed from: o */
    private int m9107o() {
        switch (this.f6063l) {
            case 1:
                return AnimUtils.getScaledDensity(getContext(), 35.0f);
            case 2:
                return AnimUtils.getScaledDensity(getContext(), 0.0f);
            default:
                return AnimUtils.getScaledDensity(getContext(), 53.0f);
        }
    }

    public de(Context context) {
        this(context, null);
    }

    public de(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6063l = 1;
        this.f6064m = null;
        this.f6065n = null;
        this.f6066o = null;
        this.f6067p = null;
        this.f6068q = null;
        this.f6069r = 0.0f;
        this.f6070s = null;
        this.f6071t = false;
        this.f6072u = DragItemStatus.Normal;
        this.f6074w = false;
        this.f6054B = new Transformation();
        this.f6055C = null;
        this.f6056D = null;
        this.f6057E = null;
        this.f6058F = null;
        this.f6059b = new df(this);
        if (f6049e == null) {
            f6049e = new Rect();
            Drawable a = cn.m10370a(context, C0254f.general__shared__book_category_shadow);
            if (a != null) {
                a.getPadding(f6049e);
            }
        }
        this.f6060i = (cw) AppContext.getAppContext(context).queryFeature(cw.class);
        this.f6061j = new TextView(context);
        this.f6061j.setMaxLines(2);
        this.f6061j.setEllipsize(TruncateAt.END);
        this.f6061j.setGravity(3);
        this.f6061j.setTextColor(f6046a);
        this.f6061j.setIncludeFontPadding(false);
        this.f6061j.setTextSize(0, getResources().getDimension(C0253e.general__shared__cover_title_size));
        addView(this.f6061j, new LayoutParams(-1, -2));
        this.f6062k = new TextView(context);
        this.f6062k.setSingleLine();
        this.f6062k.setGravity(3);
        this.f6062k.setTextColor(f6047c);
        this.f6062k.setTextSize(0, getResources().getDimension(C0253e.general__shared__cover_progress_size));
        this.f6062k.setVisibility(8);
        addView(this.f6062k, new LayoutParams(-1, -2));
        this.f6053A = new er(context);
        this.f6076y = getResources().getDrawable(C0254f.general__shared__multi_checkbox_checked);
        this.f6077z = getResources().getDrawable(C0254f.general__shared__multi_checkbox_normal);
        setWillNotDraw(false);
        setWillNotCacheDrawing(false);
        setDrawingCacheEnabled(false);
        setAnimationCacheEnabled(false);
        mo1635a();
    }

    public aa getBookCategory() {
        return (aa) this.f6056D;
    }

    public void setItemData(an anVar) {
        if (VERSION.SDK_INT >= 16) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
        if (this.f6056D != anVar) {
            this.f6056D = anVar;
            if (this.f6067p != null) {
                this.f6067p.stop();
            }
            if (this.f6068q != null) {
                this.f6068q.cancel();
                this.f6068q = null;
            }
        }
        if (m9117e()) {
            C0800c book = getBook();
            this.f6061j.setText(book.ay());
            if (this.f6063l == 0) {
                this.f6062k.setText(m9098a(book.m4152E()));
            }
            setLatestChapterCount(getLatestChapterCount());
            getBookCoverDrawable().m10608a(book, false);
            setContentDescription(book.ay());
        } else if (m9118f()) {
            CharSequence string;
            aa bookCategory = getBookCategory();
            this.f6061j.setText(bookCategory.m3767h() ? getContext().getString(C0258j.bookshelf__shared__main_category) : bookCategory.m3770k());
            this.f6062k.setText(m9097a(this.f6060i.m9434a(bookCategory).size()));
            setLatestChapterCount(getLatestChapterCount());
            getCategoryCoverDrawable().m9138a(bookCategory);
            if (bookCategory.m3767h()) {
                string = getContext().getString(C0258j.bookshelf__shared__main_category);
            } else {
                string = bookCategory.m3770k();
            }
            setContentDescription(string);
        }
        invalidate();
    }

    /* renamed from: e */
    public boolean m9117e() {
        return this.f6056D instanceof C0800c;
    }

    /* renamed from: f */
    public boolean m9118f() {
        return this.f6056D instanceof aa;
    }

    public an getItem() {
        return this.f6056D;
    }

    /* renamed from: p */
    private boolean m9108p() {
        return m9118f();
    }

    /* renamed from: a */
    private void m9099a(C1068i c1068i) {
        invalidate();
    }

    /* renamed from: q */
    private void m9109q() {
        invalidate();
    }

    /* renamed from: a */
    private String m9098a(ke keVar) {
        if (keVar.m4818a()) {
            return getResources().getString(C0258j.bookshelf__bookshelf_item_view__unread);
        }
        DecimalFormat decimalFormat = new DecimalFormat("0.#");
        return String.format(getResources().getString(C0258j.bookshelf__bookshelf_item_view__read_s), new Object[]{decimalFormat.format((double) keVar.f3449e)});
    }

    /* renamed from: a */
    private String m9097a(int i) {
        return String.format(getResources().getString(C0258j.bookshelf__bookshelf_item_view__total_d_books), new Object[]{Integer.valueOf(i)});
    }

    /* renamed from: g */
    public boolean m9119g() {
        return true;
    }

    /* renamed from: h */
    public boolean m9120h() {
        return m9117e();
    }

    /* renamed from: i */
    public boolean m9121i() {
        return true;
    }

    /* renamed from: j */
    public boolean m9122j() {
        return true;
    }

    /* renamed from: a */
    public void m9113a(Rect rect, long j) {
        if (m9118f()) {
            getCategoryCoverDrawable().m9136a(rect, j);
        } else {
            Rect rect2 = (Rect) AnimUtils.f1198g.addAnimation();
            rect2.set(getCategoryCoverDrawable().getBounds().isEmpty() ? getBookCoverDrawable().getBounds() : getCategoryCoverDrawable().getBounds());
            getCategoryCoverDrawable().m9137a(rect2, rect, 0);
            Rect rect3 = (Rect) AnimUtils.f1198g.addAnimation();
            getCategoryCoverDrawable().m9137a(rect2, rect3, 1);
            getBookCoverDrawable().m10607a(rect3, j);
            AnimUtils.f1198g.clearAnimation(rect3);
            AnimUtils.f1198g.clearAnimation(rect2);
        }
        AnimUtils.m1936b(rect, (View) this);
    }

    /* renamed from: k */
    public boolean m9123k() {
        if (this.f6072u == DragItemStatus.Actived || this.f6072u == DragItemStatus.Draged || !m9122j()) {
            return false;
        }
        setItemStatus(DragItemStatus.Actived);
        ((C1283z) getCoverDrawable()).m9130f();
        return true;
    }

    /* renamed from: l */
    public boolean m9124l() {
        if (this.f6072u != DragItemStatus.Actived) {
            return false;
        }
        setItemStatus(DragItemStatus.Normal);
        ((C1283z) getCoverDrawable()).reset();
        return true;
    }

    private int getLatestChapterCount() {
        if (m9118f()) {
            int i = 0;
            for (an anVar : this.f6060i.m9434a(getBookCategory())) {
                int bc;
                if (anVar instanceof ee) {
                    ee eeVar = (ee) anVar;
                    if (eeVar.mo1038k()) {
                        bc = i + eeVar.bc();
                        i = bc;
                    }
                }
                bc = i;
                i = bc;
            }
            return i;
        } else if (m9117e() && getBook().mo1038k()) {
            return ((ee) getBook()).bc();
        } else {
            return 0;
        }
    }

    protected Drawable getCoverDrawable() {
        return m9117e() ? getBookCoverDrawable() : getCategoryCoverDrawable();
    }

    protected C1332f getBookCoverDrawable() {
        if (this.f6057E == null) {
            this.f6057E = new C1332f(getContext(), C0254f.general__shared__book_shadow);
            this.f6057E.setCallback(this.f6059b);
        }
        return this.f6057E;
    }

    private aj getCategoryCoverDrawable() {
        if (this.f6058F == null) {
            this.f6058F = new aj(getContext());
            this.f6058F.setCallback(this.f6059b);
        }
        return this.f6058F;
    }

    private C0800c getBook() {
        return (C0800c) this.f6056D;
    }
}
