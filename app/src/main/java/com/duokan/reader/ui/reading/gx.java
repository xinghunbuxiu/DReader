package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.duokan.core.app.AppContext;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.ui.C0379c;
import com.duokan.core.ui.Scrollable.OverScrollMode;
import com.duokan.core.ui.ZoomView;
import com.duokan.core.ui.AnimUtils;
import com.duokan.core.ui.et;
import com.duokan.p023b.C0243e;
import com.duokan.reader.domain.bookshelf.C0798a;
import com.duokan.reader.domain.bookshelf.ah;
import com.duokan.reader.domain.bookshelf.ea;
import com.duokan.reader.domain.bookshelf.eb;
import com.duokan.reader.domain.document.C0897d;
import com.duokan.reader.domain.document.C0903n;
import com.duokan.reader.domain.document.C0923m;
import com.duokan.reader.domain.document.C0941i;
import com.duokan.reader.domain.document.WritingDirection;
import com.duokan.reader.domain.document.ac;
import com.duokan.reader.domain.document.ad;
import com.duokan.reader.domain.document.aj;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.au;
import com.duokan.reader.domain.document.ay;
import com.duokan.reader.domain.document.ba;
import com.duokan.reader.domain.document.bb;
import com.duokan.reader.ui.general.ej;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class gx extends FrameLayout implements OnPreDrawListener {
    /* renamed from: A */
    private static Bitmap f10279A = null;
    /* renamed from: x */
    static final /* synthetic */ boolean f10280x;
    /* renamed from: B */
    private Bitmap f10281B = null;
    /* renamed from: a */
    protected final su f10282a = ((su) AppContext.getAppContext(getContext()).queryFeature(su.class));
    /* renamed from: b */
    protected final gt f10283b;
    /* renamed from: c */
    protected final gt f10284c;
    /* renamed from: d */
    protected final hb f10285d = new hb();
    /* renamed from: e */
    protected final gu f10286e;
    /* renamed from: f */
    protected final Point f10287f = new Point();
    /* renamed from: g */
    protected final Rect f10288g = new Rect();
    /* renamed from: h */
    protected final Rect f10289h = new Rect();
    /* renamed from: i */
    protected final Rect f10290i = new Rect();
    /* renamed from: j */
    protected gs f10291j = null;
    /* renamed from: k */
    protected as f10292k = null;
    /* renamed from: l */
    protected boolean f10293l = true;
    /* renamed from: m */
    protected ZoomView f10294m = null;
    /* renamed from: n */
    protected C0798a[] f10295n = null;
    /* renamed from: o */
    protected final LinkedList<ah> f10296o = new LinkedList();
    /* renamed from: p */
    protected final LinkedList<ea> f10297p = new LinkedList();
    /* renamed from: q */
    protected boolean f10298q = true;
    /* renamed from: r */
    protected int f10299r = -1;
    /* renamed from: s */
    protected Drawable[] f10300s = new Drawable[0];
    /* renamed from: t */
    protected pm f10301t = null;
    /* renamed from: u */
    protected final gp f10302u;
    /* renamed from: v */
    protected boolean f10303v = false;
    /* renamed from: w */
    protected as f10304w = null;
    /* renamed from: y */
    private int f10305y = -1;
    /* renamed from: z */
    private int f10306z = -1;

    static {
        boolean z;
        if (gx.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        f10280x = z;
    }

    public gx(Context context, hd hdVar) {
        super(context);
        this.f10283b = mo2387a(context);
        this.f10284c = mo2387a(context);
        this.f10286e = new gy(this, context, this.f10282a);
        this.f10302u = new gp(getContext());
        addView(this.f10283b, new LayoutParams(-1, -1));
        addView(this.f10284c, new LayoutParams(-1, -1));
        addView(this.f10286e, new LayoutParams(-1, -1));
        addView(this.f10302u, new LayoutParams(-1, -1));
        setWillNotDraw(false);
        setWillNotCacheDrawing(false);
        setDrawingCacheEnabled(false);
        setAnimationCacheEnabled(false);
        setAlwaysDrawnWithCacheEnabled(false);
    }

    public gs getPage() {
        return this.f10291j;
    }

    public void setPage(gs gsVar) {
        boolean z = true;
        this.f10291j = gsVar;
        this.f10303v = false;
        this.f10298q = true;
        this.f10299r = -1;
        this.f10300s = new Drawable[0];
        this.f10295n = null;
        this.f10296o.clear();
        this.f10297p.clear();
        as h = gsVar == null ? null : gsVar.mo2332h();
        if (this.f10292k != null) {
            this.f10292k.mo1285H();
            this.f10292k.setCallback(null);
        }
        if (this.f10304w != null) {
            this.f10304w.mo1285H();
            this.f10304w.setCallback(null);
            this.f10304w = null;
        }
        this.f10292k = h;
        if (this.f10292k != null) {
            this.f10292k.setCallback(this.f10285d);
            this.f10292k.setBounds(0, 0, getWidth(), getHeight());
            this.f10292k.m6115a(getResources().getDisplayMetrics().widthPixels);
            this.f10292k.m6129b(getResources().getDisplayMetrics().heightPixels);
            this.f10292k.setVisible(this.f10281B == null, false);
            if (this.f10292k.mo1340p().f4334e) {
                z = false;
            }
            setClipChildren(z);
        } else if (this.f10281B != null) {
            this.f10281B.recycle();
            this.f10281B = null;
        }
        if (this.f10294m != null) {
            this.f10294m.m1357b(0.0f, 0.0f, 1.0f);
            ((ImageView) this.f10294m.getChildAt(0)).setImageDrawable(new hc());
        }
        m14281l();
        if (this.f10301t != null) {
            this.f10286e.removeViewInLayout(this.f10301t);
            this.f10301t = null;
        }
        if (this.f10302u != null) {
            this.f10302u.m14263a();
        }
        invalidate();
    }

    public et getZoomDetector() {
        if (this.f10294m == null) {
            return null;
        }
        return this.f10294m.getScrollDetector();
    }

    public void setZoomEnabled(boolean z) {
        if (z && this.f10294m == null) {
            this.f10294m = new gz(this, getContext());
            this.f10294m.setRotateEnabled(false);
            this.f10294m.setHorizontalOverScrollMode(OverScrollMode.NEVER);
            this.f10294m.setVerticalOverScrollMode(OverScrollMode.NEVER);
            addView(this.f10294m, 0, new LayoutParams(-1, -1));
            View imageView = new ImageView(getContext());
            this.f10294m.addView(imageView);
            imageView.setImageDrawable(new hc());
            invalidate();
        } else if (!z && this.f10294m != null) {
            removeView(this.f10294m);
            this.f10294m = null;
            invalidate();
            if (this.f10292k != null) {
                this.f10292k.setCallback(this.f10285d);
            }
        }
    }

    public void setStatusColor(int i) {
        this.f10286e.setStatusColor(i);
    }

    public void setShowStatus(boolean z) {
        this.f10286e.setShowStatus(z);
    }

    public void setRenderParams(C0923m c0923m) {
        if (this.f10292k != null) {
            this.f10292k.mo1296a(c0923m);
            if (this.f10304w != null) {
                C0923m a = c0923m.mo1277a();
                a.f4360h = " ";
                a.f4355c = c0923m.f4359g;
                this.f10304w.mo1296a(a);
            }
            if (this.f10283b != null) {
                this.f10283b.m13809l();
            }
            if (this.f10284c != null) {
                this.f10284c.m13809l();
            }
        }
    }

    /* renamed from: a */
    public boolean mo2389a() {
        return false;
    }

    /* renamed from: b */
    public void mo2390b() {
    }

    /* renamed from: c */
    public void m14297c() {
        if (this.f10283b != null) {
            this.f10283b.mo2284d();
        }
        if (this.f10284c != null) {
            this.f10284c.mo2284d();
        }
    }

    /* renamed from: d */
    public void m14298d() {
        if (this.f10283b != null) {
            this.f10283b.mo2285e();
        }
        if (this.f10284c != null) {
            this.f10284c.mo2285e();
        }
    }

    /* renamed from: e */
    public final void m14299e() {
        if (this.f10281B == null && this.f10292k != null && !this.f10292k.mo1340p().mo1274c() && this.f10292k.mo1284G() && this.f10292k.m6151i() == 1) {
            if (this.f10292k instanceof C0941i) {
                ba baVar = (ba) ((C0941i) this.f10292k).mo1434c();
                if (((ba) ((C0941i) this.f10292k).mo1305b()).mo1299a() && baVar.mo1299a()) {
                    return;
                }
            } else if (((ba) this.f10292k).mo1299a()) {
                return;
            }
            if (getWidth() >= 1 && getHeight() >= 1 && getGlobalVisibleRect(this.f10288g, this.f10287f)) {
                if (f10279A == null) {
                    f10279A = C0379c.m1749a(1, 1, Config.ARGB_8888);
                }
                if (f10279A != null) {
                    this.f10281B = C0379c.m1749a(getWidth(), getHeight(), this.f10292k.mo1342q().f4368p ? Config.ARGB_8888 : Config.RGB_565);
                    if (this.f10281B != null) {
                        this.f10281B.eraseColor(0);
                        mo2515a(new Canvas(this.f10281B), false);
                    }
                }
            }
        }
    }

    public final as getPageDrawable() {
        return this.f10292k;
    }

    public Rect getSelectionStartIndicatorBounds() {
        if (!f10280x && !m14303i()) {
            throw new AssertionError();
        } else if (this.f10282a.getSelection() == null || this.f10282a.getSelection().m5817f()) {
            return new Rect();
        } else {
            if (!this.f10292k.mo1332l().m5812a(this.f10282a.getSelection().mo1198g())) {
                return new Rect();
            }
            Point f = this.f10292k.mo1318f(this.f10282a.getSelection());
            int intrinsicWidth = this.f10282a.mo2012a(DecorDrawableStyle.SELECTION_INDICATOR_START).getIntrinsicWidth() * 2;
            return new Rect(f.x - (intrinsicWidth / 2), f.y - this.f10282a.mo2012a(DecorDrawableStyle.SELECTION_INDICATOR_START).getIntrinsicHeight(), (intrinsicWidth / 2) + f.x, f.y);
        }
    }

    public Rect getSelectionEndIndicatorBounds() {
        if (!f10280x && !m14303i()) {
            throw new AssertionError();
        } else if (this.f10282a.getSelection() == null || this.f10282a.getSelection().m5817f()) {
            return new Rect();
        } else {
            if (!this.f10292k.mo1332l().m5812a(this.f10282a.getSelection().mo1199h()) && !this.f10292k.mo1332l().mo1199h().equals(this.f10282a.getSelection().mo1199h())) {
                return new Rect();
            }
            Point g = this.f10292k.mo1321g(this.f10282a.getSelection());
            int intrinsicWidth = this.f10282a.mo2012a(DecorDrawableStyle.SELECTION_INDICATOR_END).getIntrinsicWidth() * 2;
            return new Rect(g.x - (intrinsicWidth / 2), g.y, (intrinsicWidth / 2) + g.x, g.y + this.f10282a.mo2012a(DecorDrawableStyle.SELECTION_INDICATOR_END).getIntrinsicHeight());
        }
    }

    /* renamed from: a */
    public Rect m14287a(ea eaVar) {
        if (TextUtils.isEmpty(eaVar.m4384m())) {
            return new Rect();
        }
        if (!m14303i()) {
            return new Rect();
        }
        bb a = this.f10282a.getDocument().mo1216a((C0897d) eaVar.m3726d(), (C0897d) eaVar.m3728e());
        if (this.f10282a.getDocument().mo1245k().f4334e && !this.f10292k.mo1332l().m5812a(a.mo1199h())) {
            return new Rect();
        }
        Drawable drawable = getResources().getDrawable(C0243e.reading__shared__note_icon_orange);
        Rect[] e = this.f10292k.mo1316e(a);
        if (e.length < 1) {
            return new Rect();
        }
        Rect rect = new Rect();
        if (this.f10282a.getDocument().mo1228c() == WritingDirection.LEFT_TO_RIGHT) {
            rect.left = e[e.length - 1].right - (drawable.getIntrinsicWidth() / 2);
            rect.top = e[e.length - 1].bottom;
        } else if (this.f10282a.getDocument().mo1228c() == WritingDirection.RIGHT_TO_LEFT) {
            rect.left = e[e.length - 1].left - (drawable.getIntrinsicWidth() / 2);
            rect.top = e[e.length - 1].bottom;
        } else {
            rect.left = e[e.length - 1].right;
            rect.top = e[e.length - 1].bottom - (drawable.getIntrinsicHeight() / 2);
        }
        rect.right = rect.left + drawable.getIntrinsicWidth();
        rect.bottom = drawable.getIntrinsicHeight() + rect.top;
        return rect;
    }

    /* renamed from: f */
    protected void m14300f() {
        if (this.f10292k.mo1284G()) {
            this.f10300s = new Drawable[getPageDrawable().mo1349u()];
            for (int i = 0; i < this.f10300s.length; i++) {
                this.f10300s[i] = null;
                if (getPageDrawable().mo1319f(i).mo1414e()) {
                    this.f10300s[i] = this.f10282a.mo2012a(DecorDrawableStyle.MEDIA_PLAY);
                }
            }
            if (this.f10292k.mo1355y() > 0) {
                this.f10301t = new pm(getContext(), this);
                this.f10286e.addView(this.f10301t, new LayoutParams(-1, -1));
            }
            m14283n();
            m14284o();
            m14282m();
            m14285p();
            m14286q();
            bringChildToFront(this.f10302u);
        }
        this.f10303v = true;
        mo2388a(this.f10291j);
        this.f10286e.invalidate();
        invalidate();
    }

    /* renamed from: a */
    public Drawable m14288a(int i) {
        if (!f10280x && i >= this.f10300s.length) {
            throw new AssertionError();
        } else if (i >= this.f10300s.length) {
            return null;
        } else {
            return this.f10300s[i];
        }
    }

    /* renamed from: a */
    public void m14290a(int i, Drawable drawable) {
        if (!f10280x && i >= this.f10300s.length) {
            throw new AssertionError();
        } else if (i < this.f10300s.length) {
            this.f10300s[i] = drawable;
            invalidate();
        }
    }

    public void setActiveMedia(int i) {
        this.f10299r = i;
        invalidate();
    }

    public void setIsHideMarkIcon(boolean z) {
        this.f10298q = !z;
        this.f10286e.invalidate();
    }

    /* renamed from: g */
    public LinkedList<ah> m14301g() {
        return this.f10296o;
    }

    /* renamed from: h */
    public LinkedList<ea> m14302h() {
        return this.f10297p;
    }

    /* renamed from: i */
    public boolean m14303i() {
        return this.f10303v && this.f10292k != null && this.f10292k.mo1284G();
    }

    /* renamed from: j */
    public boolean m14304j() {
        return this.f10292k == null || this.f10292k.mo1283F();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnPreDrawListener(this);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnPreDrawListener(this);
    }

    public boolean onPreDraw() {
        if (this.f10292k == null) {
            return true;
        }
        if (this.f10292k.mo1284G() && !this.f10292k.mo1283F()) {
            if (this.f10292k.mo1340p().f4334e && this.f10283b.m13808k() && this.f10284c.m13808k() && this.f10292k.getIntrinsicHeight() != getHeight()) {
                requestLayout();
                return false;
            }
            if (this.f10295n != this.f10282a.getAnnotations()) {
                this.f10295n = this.f10282a.getAnnotations();
                this.f10296o.clear();
                this.f10297p.clear();
                int i = 0;
                while (this.f10295n != null && i < this.f10295n.length) {
                    C0798a c0798a = this.f10295n[i];
                    ay a = this.f10282a.getDocument().mo1216a((C0897d) c0798a.m3726d(), (C0897d) c0798a.m3728e());
                    if (c0798a instanceof ah) {
                        if (this.f10292k.mo1332l().m5812a(a.mo1198g())) {
                            this.f10296o.add((ah) c0798a);
                        }
                    } else if ((c0798a instanceof ea) && this.f10292k.mo1332l().m5814b(a)) {
                        this.f10297p.add((ea) c0798a);
                    }
                    i++;
                }
            }
            gu guVar = this.f10286e;
            boolean z = (this.f10292k.mo1332l().m5817f() || this.f10292k.mo1330k()) ? false : true;
            guVar.setShowStatus(z);
        }
        if (getVisibility() != 0) {
            return true;
        }
        int i2 = getResources().getDisplayMetrics().widthPixels;
        int i3 = getResources().getDisplayMetrics().heightPixels;
        Rect rect = new Rect(0, 0, i2, i3);
        AnimUtils.m1937b(rect, null, (View) this);
        if (rect.intersect(0, 0, getWidth(), getHeight())) {
            this.f10292k.m6120a(rect);
            return true;
        }
        rect.inset(-i2, 0);
        if (rect.intersect(0, 0, getWidth(), getHeight())) {
            this.f10292k.m6120a(rect);
            return true;
        }
        rect.inset(i2, -i3);
        if (rect.intersect(0, 0, getWidth(), getHeight())) {
            this.f10292k.m6120a(rect);
            return true;
        }
        rect.setEmpty();
        this.f10292k.m6120a(rect);
        return true;
    }

    public void draw(Canvas canvas) {
        if (this.f10294m == null) {
            mo2515a(canvas, true);
        }
        m14281l();
        super.draw(canvas);
    }

    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0 && this.f10292k != null) {
            this.f10292k.mo1298a(false);
        }
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 0;
        if (this.f10292k != null) {
            int paddingLeft = getPaddingLeft() + getPaddingRight();
            int paddingBottom = getPaddingBottom() + getPaddingTop();
            if (this.f10292k.mo1284G()) {
                int resolveSize = resolveSize(paddingLeft + this.f10292k.getIntrinsicWidth(), i);
                this.f10305y = resolveSize;
                if (!this.f10292k.mo1340p().f4334e || (this.f10283b.m13808k() && this.f10284c.m13808k())) {
                    paddingLeft = resolveSize(this.f10292k.getIntrinsicHeight() + paddingBottom, i2);
                } else {
                    if (this.f10283b.getVisibility() != 0) {
                        paddingLeft = 0;
                    } else if (this.f10283b.m13808k()) {
                        paddingLeft = this.f10292k.getIntrinsicHeight();
                    } else {
                        this.f10283b.measure(MeasureSpec.makeMeasureSpec(resolveSize, 1073741824), MeasureSpec.makeMeasureSpec(0, 0));
                        if (this.f10283b.getCustomView() != null) {
                            paddingLeft = this.f10283b.getMeasuredHeight();
                        } else {
                            paddingLeft = Math.max(this.f10292k.getIntrinsicHeight(), this.f10283b.getMeasuredHeight());
                        }
                    }
                    if (this.f10284c.getVisibility() == 0) {
                        if (this.f10284c.m13808k()) {
                            i3 = this.f10292k.getIntrinsicHeight();
                        } else {
                            this.f10284c.measure(MeasureSpec.makeMeasureSpec(resolveSize, 1073741824), MeasureSpec.makeMeasureSpec(0, 0));
                            if (this.f10284c.getCustomView() != null) {
                                i3 = this.f10284c.getMeasuredHeight();
                            } else {
                                i3 = Math.max(this.f10292k.getIntrinsicHeight(), this.f10284c.getMeasuredHeight());
                            }
                        }
                    }
                    paddingLeft = resolveSize(Math.max(paddingLeft, i3) + paddingBottom, i2);
                }
                this.f10306z = paddingLeft;
                i3 = resolveSize;
            } else if (!this.f10292k.mo1340p().f4334e || this.f10305y <= 0 || this.f10306z <= 0) {
                i3 = resolveSize(paddingLeft + this.f10292k.getIntrinsicWidth(), i);
                paddingLeft = resolveSize(this.f10292k.getIntrinsicHeight() + paddingBottom, i2);
            } else {
                i3 = this.f10305y;
                paddingLeft = this.f10306z;
            }
            super.onMeasure(MeasureSpec.makeMeasureSpec(i3, 1073741824), MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824));
            return;
        }
        super.onMeasure(i, i2);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f10292k != null) {
            this.f10292k.setBounds(0, 0, i3 - i, i4 - i2);
        }
    }

    /* renamed from: a */
    protected void mo2515a(Canvas canvas, boolean z) {
        C0903n document = this.f10282a.getDocument();
        if (document != null && !document.mo1448b() && this.f10292k != null) {
            if (getGlobalVisibleRect(this.f10288g, this.f10287f)) {
                this.f10288g.offset(-this.f10287f.x, -this.f10287f.y);
                this.f10292k.m6120a(this.f10288g);
            }
            this.f10292k.setBounds(0, 0, getWidth(), getHeight());
            if (!(this.f10281B == null || (this.f10281B.hasAlpha() == this.f10292k.mo1342q().f4368p && this.f10281B.getWidth() == this.f10292k.getBounds().width() && this.f10281B.getHeight() == this.f10292k.getBounds().height()))) {
                this.f10281B.recycle();
                this.f10281B = null;
            }
            if (z && this.f10281B != null) {
                WebLog.init().w(f10279A != null);
                this.f10292k.m6117a(new Canvas(f10279A), getDrawingTime());
                if (this.f10292k.m6151i() != 1) {
                    canvas.drawBitmap(this.f10281B, null, this.f10292k.getBounds(), null);
                    return;
                }
                this.f10281B.recycle();
                this.f10281B = null;
                this.f10292k.setVisible(true, false);
            }
            this.f10292k.m6117a(canvas, getDrawingTime());
            if (this.f10292k.mo1284G()) {
                m14296b(canvas);
            }
        }
    }

    /* renamed from: k */
    private void m14280k() {
        as asVar = null;
        if (this.f10292k == null) {
            this.f10283b.setVisibility(4);
            this.f10284c.setVisibility(4);
        } else if (this.f10292k instanceof C0941i) {
            as c;
            C0941i c0941i = (C0941i) this.f10292k;
            Rect d = c0941i.mo1435d();
            Rect e = c0941i.mo1436e();
            if (c0941i.mo1299a()) {
                asVar = c0941i.mo1305b();
                c = c0941i.mo1434c();
            } else {
                c = null;
            }
            this.f10283b.m13803a(asVar);
            this.f10284c.m13803a(c);
            this.f10283b.setVisibility(0);
            this.f10284c.setVisibility(0);
            this.f10283b.setPadding(d.left, d.top, this.f10292k.getBounds().width() - d.right, this.f10292k.getBounds().height() - d.bottom);
            this.f10284c.setPadding(e.left, e.top, this.f10292k.getBounds().width() - e.right, this.f10292k.getBounds().height() - e.bottom);
        } else {
            this.f10283b.m13803a(this.f10292k);
            this.f10283b.setVisibility(0);
            this.f10284c.setVisibility(4);
            this.f10283b.setPadding(0, 0, 0, 0);
            this.f10284c.setPadding(0, 0, 0, 0);
        }
        this.f10293l = true;
    }

    /* renamed from: l */
    private void m14281l() {
        if (this.f10293l) {
            this.f10293l = false;
            post(new ha(this));
        }
    }

    /* renamed from: a */
    protected void mo2388a(gs gsVar) {
        m14281l();
    }

    /* renamed from: m */
    private void m14282m() {
        for (int i = 0; i < this.f10292k.mo1345s(); i++) {
            this.f10302u.m14264a(new pg(getContext(), this.f10291j, this.f10292k.mo1312d(i), this.f10292k.mo1325h(i)), null, null);
        }
    }

    /* renamed from: n */
    private void m14283n() {
        for (int i = 0; i < this.f10292k.mo1353w(); i++) {
            aj n = this.f10292k.mo1335n(i);
            fz nbVar = new nb(getContext(), this.f10291j, n, this.f10292k.mo1339p(i));
            ne mrVar = new mr(getContext(), n.mo1415a(), nbVar.getPresenter());
            nbVar.m14704a(mrVar);
            this.f10302u.m14264a(nbVar, mrVar, this.f10292k.mo1337o(i));
        }
    }

    /* renamed from: o */
    private void m14284o() {
        for (int i = 0; i < this.f10292k.mo1343r(); i++) {
            au c = this.f10292k.mo1308c(i);
            if (c.mo1395j()) {
                this.f10302u.m14264a(new ky(getContext(), this.f10291j, this.f10292k.mo1322g(i), c), null, null);
            }
        }
    }

    /* renamed from: p */
    private void m14285p() {
        for (int i = 0; i < this.f10292k.mo1354x(); i++) {
            ad q = this.f10292k.mo1341q(i);
            if (q.mo1395j()) {
                this.f10302u.m14264a(new kh(getContext(), this.f10291j, this.f10292k.mo1344r(i), q), null, null);
            }
        }
    }

    /* renamed from: q */
    private void m14286q() {
        for (int i = 0; i < this.f10292k.mo1351v(); i++) {
            ac k = this.f10292k.mo1329k(i);
            if (k.mo1395j()) {
                fz jyVar = new jy(getContext(), this.f10291j, this.f10292k.mo1333m(i), k);
                Object jwVar = new jw(getContext(), k);
                jyVar.setGalleryShowingPicListener(jwVar);
                this.f10302u.m14264a(jyVar, jwVar, this.f10292k.mo1331l(i));
            }
        }
    }

    /* renamed from: c */
    private void m14273c(Canvas canvas) {
        if (m14303i()) {
            Map highlights = this.f10282a.getHighlights();
            if (highlights != null) {
                bb m = this.f10292k.mo1334m();
                for (Entry entry : highlights.entrySet()) {
                    Drawable drawable = (Drawable) entry.getKey();
                    List<bb> list = (List) entry.getValue();
                    if (!(drawable == null || list == null)) {
                        for (bb b : list) {
                            bb b2 = b2.mo1197b(m);
                            if (!b2.m5817f()) {
                                Rect[] e = this.f10292k.mo1316e(b2);
                                for (Rect bounds : e) {
                                    drawable.setBounds(bounds);
                                    drawable.draw(canvas);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: d */
    private void m14275d(Canvas canvas) {
        if (this.f10291j != null && m14303i()) {
            bb activeText = this.f10282a.getActiveText();
            if (activeText != null && !activeText.m5817f()) {
                activeText = activeText.mo1197b(this.f10292k.mo1334m());
                if (!activeText.m5817f()) {
                    Rect[] e = this.f10292k.mo1316e(activeText);
                    Drawable selectionDrawable = this.f10282a.getSelectionDrawable();
                    for (Rect bounds : e) {
                        selectionDrawable.setBounds(bounds);
                        selectionDrawable.draw(canvas);
                    }
                }
            }
        }
    }

    /* renamed from: e */
    private void m14276e(Canvas canvas) {
        bb selection = this.f10282a.getSelection();
        if (selection != null && m14303i()) {
            selection = selection.mo1197b(this.f10292k.mo1334m());
            if (!selection.m5817f()) {
                Rect[] e = this.f10292k.mo1316e(selection);
                Drawable selectionDrawable = this.f10282a.getSelectionDrawable();
                for (Rect bounds : e) {
                    selectionDrawable.setBounds(bounds);
                    selectionDrawable.draw(canvas);
                }
            }
        }
    }

    /* renamed from: a */
    protected void m14291a(Canvas canvas) {
        if (m14303i()) {
            Iterator it = this.f10297p.iterator();
            while (it.hasNext()) {
                m14269a(canvas, (ea) it.next());
            }
            if (this.f10296o.size() > 0) {
                m14277f(canvas);
            }
        }
    }

    /* renamed from: f */
    private void m14277f(Canvas canvas) {
        if (this.f10298q) {
            Rect rect = (Rect) AnimUtils.f1198g.addAnimation();
            rect.set(0, 0, getWidth(), getHeight());
            rect.right -= AnimUtils.m1932b(getContext(), 15.0f);
            AnimUtils.m1911a(canvas, this.f10282a.mo2012a(DecorDrawableStyle.BOOK_MARK), rect, 53);
            AnimUtils.f1198g.clearAnimation(rect);
        }
    }

    /* renamed from: a */
    private void m14269a(Canvas canvas, ea eaVar) {
        int i = 255;
        int round = (this.f10292k.mo1342q().f4361i || this.f10292k.mo1342q().f4362j) ? Math.round(153.0f) : 255;
        ej ejVar = new ej();
        ejVar.m10559a(getTextUnderlineWidth());
        ejVar.m10560a(eb.m4386a().m4392d(eaVar.m4385n()));
        if (!this.f10292k.mo1340p().mo1274c()) {
            i = round;
        }
        ejVar.setAlpha(i);
        if (this.f10282a.getDocument().mo1228c() == WritingDirection.RIGHT_TO_LEFT) {
            ejVar.m10562b(3);
        } else if (this.f10282a.getDocument().mo1228c() == WritingDirection.LEFT_TO_RIGHT) {
            ejVar.m10562b(5);
        } else {
            ejVar.m10562b(80);
        }
        for (Rect rect : this.f10292k.mo1316e(this.f10282a.getDocument().mo1216a((C0897d) eaVar.m3726d(), (C0897d) eaVar.m3728e()))) {
            if (!rect.isEmpty()) {
                ejVar.setBounds(rect);
                ejVar.draw(canvas);
            }
        }
        Rect a = m14287a(eaVar);
        if (!a.isEmpty()) {
            Drawable drawable = getResources().getDrawable(eb.m4386a().m4390b(eb.m4386a().m4392d(eaVar.m4385n())));
            drawable.setBounds(a);
            drawable.draw(canvas);
        }
    }

    /* renamed from: b */
    protected void m14296b(Canvas canvas) {
        canvas.save();
        m14278g(canvas);
        m14279h(canvas);
        canvas.restore();
    }

    /* renamed from: g */
    private void m14278g(Canvas canvas) {
        for (int i = 0; i < this.f10292k.mo1349u(); i++) {
            Bitmap bitmap;
            com.duokan.reader.domain.document.ah f = this.f10292k.mo1319f(i);
            Rect j = this.f10292k.mo1328j(i);
            if (i != this.f10299r || f.mo1412c()[1] == null) {
                bitmap = f.mo1412c()[0];
            } else {
                bitmap = f.mo1412c()[1];
            }
            this.f10289h.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            this.f10290i.set(j.left, j.top, j.right, j.bottom);
            if (f.mo1414e() && this.f10292k.mo1342q().f4354b != null) {
                this.f10292k.mo1342q().f4354b.getBounds().set(this.f10290i);
                this.f10292k.mo1342q().f4354b.getBounds().inset(-21, -21);
                this.f10292k.mo1342q().f4354b.draw(canvas);
            }
            canvas.drawBitmap(bitmap, this.f10289h, this.f10290i, null);
        }
    }

    /* renamed from: h */
    private void m14279h(Canvas canvas) {
        canvas.save();
        for (int i = 0; i < this.f10300s.length; i++) {
            Drawable drawable = this.f10300s[i];
            if (drawable != null) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                Rect rect = new Rect(getPageDrawable().mo1328j(i));
                if (intrinsicWidth >= 0) {
                    rect.inset((rect.width() - intrinsicWidth) / 2, 0);
                }
                if (intrinsicHeight >= 0) {
                    rect.inset(0, (rect.height() - intrinsicHeight) / 2);
                }
                canvas.clipRect(rect);
                drawable.setBounds(rect);
                drawable.draw(canvas);
            }
        }
        canvas.restore();
    }

    private float getTextUnderlineWidth() {
        return ((float) Math.sqrt((double) this.f10282a.getDocument().mo1245k().f4335f)) * 0.618f;
    }

    /* renamed from: a */
    protected gt mo2387a(Context context) {
        gt gtVar = new gt(context);
        gtVar.setVisibility(4);
        return gtVar;
    }
}
