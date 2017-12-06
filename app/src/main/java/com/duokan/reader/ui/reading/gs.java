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

import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.ui.Scrollable.OverScrollMode;
import com.duokan.core.ui.UTools;
import com.duokan.core.ui.ZoomView;
import com.duokan.core.ui.et;
import com.duokan.reader.domain.bookshelf.a;
import com.duokan.reader.domain.bookshelf.ah;
import com.duokan.reader.domain.bookshelf.ef;
import com.duokan.reader.domain.bookshelf.eg;
import com.duokan.reader.domain.document.WritingDirection;
import com.duokan.reader.domain.document.ac;
import com.duokan.reader.domain.document.ad;
import com.duokan.reader.domain.document.aj;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.au;
import com.duokan.reader.domain.document.ay;
import com.duokan.reader.domain.document.ba;
import com.duokan.reader.domain.document.bb;
import com.duokan.reader.domain.document.d;
import com.duokan.reader.domain.document.i;
import com.duokan.reader.domain.document.m;
import com.duokan.reader.domain.document.n;
import com.duokan.reader.ui.general.el;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class gs extends FrameLayout implements OnPreDrawListener {
    private static Bitmap A = null;
    static final /* synthetic */ boolean x;
    private Bitmap B = null;
    protected final sh a = ((sh) x.a(getContext()).queryFeature(sh.class));
    protected final go b;
    protected final go c;
    protected final gw d = new gw();
    protected final gp e;
    protected final Point f = new Point();
    protected final Rect g = new Rect();
    protected final Rect h = new Rect();
    protected final Rect i = new Rect();
    protected gn j = null;
    protected as k = null;
    protected boolean l = true;
    protected ZoomView m = null;
    protected a[] n = null;
    protected final LinkedList o = new LinkedList();
    protected final LinkedList p = new LinkedList();
    protected boolean q = true;
    protected int r = -1;
    protected Drawable[] s = new Drawable[0];
    protected pc t = null;
    protected final gk u;
    protected boolean v = false;
    protected as w = null;
    private int y = -1;
    private int z = -1;

    static {
        boolean z;
        if (gs.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        x = z;
    }

    public gs(Context context, gy gyVar) {
        super(context);
        this.b = a(context);
        this.c = a(context);
        this.e = new gt(this, context, this.a);
        this.u = new gk(getContext());
        addView(this.b, new LayoutParams(-1, -1));
        addView(this.c, new LayoutParams(-1, -1));
        addView(this.e, new LayoutParams(-1, -1));
        addView(this.u, new LayoutParams(-1, -1));
        setWillNotDraw(false);
        setWillNotCacheDrawing(false);
        setDrawingCacheEnabled(false);
        setAnimationCacheEnabled(false);
        setAlwaysDrawnWithCacheEnabled(false);
    }

    public gn getPage() {
        return this.j;
    }

    public void setPage(gn gnVar) {
        boolean z = true;
        this.j = gnVar;
        this.v = false;
        this.q = true;
        this.r = -1;
        this.s = new Drawable[0];
        this.n = null;
        this.o.clear();
        this.p.clear();
        as h = gnVar == null ? null : gnVar.h();
        if (this.k != null) {
            this.k.H();
            this.k.setCallback(null);
        }
        if (this.w != null) {
            this.w.H();
            this.w.setCallback(null);
            this.w = null;
        }
        this.k = h;
        if (this.k != null) {
            this.k.setCallback(this.d);
            this.k.setBounds(0, 0, getWidth(), getHeight());
            this.k.a(getResources().getDisplayMetrics().widthPixels);
            this.k.b(getResources().getDisplayMetrics().heightPixels);
            this.k.setVisible(this.B == null, false);
            if (this.k.p().e) {
                z = false;
            }
            setClipChildren(z);
        } else if (this.B != null) {
            this.B.recycle();
            this.B = null;
        }
        if (this.m != null) {
            this.m.b(0.0f, 0.0f, 1.0f);
            ((ImageView) this.m.getChildAt(0)).setImageDrawable(new gx());
        }
        l();
        if (this.t != null) {
            this.e.removeViewInLayout(this.t);
            this.t = null;
        }
        if (this.u != null) {
            this.u.a();
        }
        invalidate();
    }

    public et getZoomDetector() {
        if (this.m == null) {
            return null;
        }
        return this.m.getScrollDetector();
    }

    public void setZoomEnabled(boolean z) {
        if (z && this.m == null) {
            this.m = new gu(this, getContext());
            this.m.setRotateEnabled(false);
            this.m.setHorizontalOverScrollMode(OverScrollMode.NEVER);
            this.m.setVerticalOverScrollMode(OverScrollMode.NEVER);
            addView(this.m, 0, new LayoutParams(-1, -1));
            View imageView = new ImageView(getContext());
            this.m.addView(imageView);
            imageView.setImageDrawable(new gx());
            invalidate();
        } else if (!z && this.m != null) {
            removeView(this.m);
            this.m = null;
            invalidate();
            if (this.k != null) {
                this.k.setCallback(this.d);
            }
        }
    }

    public void setStatusColor(int i) {
        this.e.setStatusColor(i);
    }

    public void setShowStatus(boolean z) {
        this.e.setShowStatus(z);
    }

    public void setRenderParams(m mVar) {
        if (this.k != null) {
            this.k.a(mVar);
            if (this.w != null) {
                m a = mVar.a();
                a.h = " ";
                a.c = mVar.g;
                this.w.a(a);
            }
            if (this.b != null) {
                this.b.k();
            }
            if (this.c != null) {
                this.c.k();
            }
        }
    }

    public boolean a() {
        return false;
    }

    public void b() {
    }

    public void c() {
        if (this.b != null) {
            this.b.d();
        }
        if (this.c != null) {
            this.c.d();
        }
    }

    public void d() {
        if (this.b != null) {
            this.b.e();
        }
        if (this.c != null) {
            this.c.e();
        }
    }

    public final void e() {
        if (this.B == null && this.k != null && !this.k.p().c() && this.k.G() && this.k.i() == 1) {
            if (this.k instanceof i) {
                ba baVar = (ba) ((i) this.k).c();
                if (((ba) ((i) this.k).b()).a() && baVar.a()) {
                    return;
                }
            } else if (((ba) this.k).a()) {
                return;
            }
            if (getWidth() >= 1 && getHeight() >= 1 && getGlobalVisibleRect(this.g, this.f)) {
                if (A == null) {
                    A = c.a(1, 1, Config.ARGB_8888);
                }
                if (A != null) {
                    this.B = c.a(getWidth(), getHeight(), this.k.q().p ? Config.ARGB_8888 : Config.RGB_565);
                    if (this.B != null) {
                        this.B.eraseColor(0);
                        a(new Canvas(this.B), false);
                    }
                }
            }
        }
    }

    public final as getPageDrawable() {
        return this.k;
    }

    public Rect getSelectionStartIndicatorBounds() {
        if (!x && !i()) {
            throw new AssertionError();
        } else if (this.a.getSelection() == null || this.a.getSelection().f()) {
            return new Rect();
        } else {
            if (!this.k.l().a(this.a.getSelection().g())) {
                return new Rect();
            }
            Point f = this.k.f(this.a.getSelection());
            int intrinsicWidth = this.a.a(DecorDrawableStyle.SELECTION_INDICATOR_START).getIntrinsicWidth() * 2;
            return new Rect(f.x - (intrinsicWidth / 2), f.y - this.a.a(DecorDrawableStyle.SELECTION_INDICATOR_START).getIntrinsicHeight(), (intrinsicWidth / 2) + f.x, f.y);
        }
    }

    public Rect getSelectionEndIndicatorBounds() {
        if (!x && !i()) {
            throw new AssertionError();
        } else if (this.a.getSelection() == null || this.a.getSelection().f()) {
            return new Rect();
        } else {
            if (!this.k.l().a(this.a.getSelection().h()) && !this.k.l().h().equals(this.a.getSelection().h())) {
                return new Rect();
            }
            Point g = this.k.g(this.a.getSelection());
            int intrinsicWidth = this.a.a(DecorDrawableStyle.SELECTION_INDICATOR_END).getIntrinsicWidth() * 2;
            return new Rect(g.x - (intrinsicWidth / 2), g.y, (intrinsicWidth / 2) + g.x, g.y + this.a.a(DecorDrawableStyle.SELECTION_INDICATOR_END).getIntrinsicHeight());
        }
    }

    public Rect a(ef efVar) {
        if (TextUtils.isEmpty(efVar.m())) {
            return new Rect();
        }
        if (!i()) {
            return new Rect();
        }
        bb a = this.a.getDocument().a((d) efVar.d(), (d) efVar.e());
        if (this.a.getDocument().k().e && !this.k.l().a(a.h())) {
            return new Rect();
        }
        Drawable drawable = getResources().getDrawable(e.reading__shared__note_icon_orange);
        Rect[] e = this.k.e(a);
        if (e.length < 1) {
            return new Rect();
        }
        Rect rect = new Rect();
        if (this.a.getDocument().c() == WritingDirection.LEFT_TO_RIGHT) {
            rect.left = e[e.length - 1].right - (drawable.getIntrinsicWidth() / 2);
            rect.top = e[e.length - 1].bottom;
        } else if (this.a.getDocument().c() == WritingDirection.RIGHT_TO_LEFT) {
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

    protected void f() {
        if (this.k.G()) {
            this.s = new Drawable[getPageDrawable().u()];
            for (int i = 0; i < this.s.length; i++) {
                this.s[i] = null;
                if (getPageDrawable().f(i).e()) {
                    this.s[i] = this.a.a(DecorDrawableStyle.MEDIA_PLAY);
                }
            }
            if (this.k.y() > 0) {
                this.t = new pc(getContext(), this);
                this.e.addView(this.t, new LayoutParams(-1, -1));
            }
            n();
            o();
            m();
            p();
            q();
            bringChildToFront(this.u);
        }
        this.v = true;
        a(this.j);
        this.e.invalidate();
        invalidate();
    }

    public Drawable a(int i) {
        if (!x && i >= this.s.length) {
            throw new AssertionError();
        } else if (i >= this.s.length) {
            return null;
        } else {
            return this.s[i];
        }
    }

    public void a(int i, Drawable drawable) {
        if (!x && i >= this.s.length) {
            throw new AssertionError();
        } else if (i < this.s.length) {
            this.s[i] = drawable;
            invalidate();
        }
    }

    public void setActiveMedia(int i) {
        this.r = i;
        invalidate();
    }

    public void setIsHideMarkIcon(boolean z) {
        this.q = !z;
        this.e.invalidate();
    }

    public LinkedList g() {
        return this.o;
    }

    public LinkedList h() {
        return this.p;
    }

    public boolean i() {
        return this.v && this.k != null && this.k.G();
    }

    public boolean j() {
        return this.k == null || this.k.F();
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
        if (this.k == null) {
            return true;
        }
        if (this.k.G() && !this.k.F()) {
            if (!this.k.p().e || this.b.getVisibility() == 0 || this.c.getVisibility() == 0 || this.k.getIntrinsicHeight() == getHeight()) {
                if (this.n != this.a.getAnnotations()) {
                    this.n = this.a.getAnnotations();
                    this.o.clear();
                    this.p.clear();
                    int i = 0;
                    while (this.n != null && i < this.n.length) {
                        a aVar = this.n[i];
                        ay a = this.a.getDocument().a((d) aVar.d(), (d) aVar.e());
                        if (aVar instanceof ah) {
                            if (this.k.l().a(a.g())) {
                                this.o.add((ah) aVar);
                            }
                        } else if ((aVar instanceof ef) && this.k.l().b(a)) {
                            this.p.add((ef) aVar);
                        }
                        i++;
                    }
                }
                gp gpVar = this.e;
                boolean z = (this.k.l().f() || this.k.k()) ? false : true;
                gpVar.setShowStatus(z);
            } else {
                requestLayout();
                return false;
            }
        }
        if (getVisibility() != 0) {
            return true;
        }
        int i2 = getResources().getDisplayMetrics().widthPixels;
        int i3 = getResources().getDisplayMetrics().heightPixels;
        Rect rect = new Rect(0, 0, i2, i3);
        UTools.closeAnimation(rect, null, (View) this);
        if (rect.intersect(0, 0, getWidth(), getHeight())) {
            this.k.a(rect);
            return true;
        }
        rect.inset(-i2, 0);
        if (rect.intersect(0, 0, getWidth(), getHeight())) {
            this.k.a(rect);
            return true;
        }
        rect.inset(i2, -i3);
        if (rect.intersect(0, 0, getWidth(), getHeight())) {
            this.k.a(rect);
            return true;
        }
        rect.setEmpty();
        this.k.a(rect);
        return true;
    }

    public void draw(Canvas canvas) {
        if (this.m == null) {
            a(canvas, true);
        }
        l();
        super.draw(canvas);
    }

    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0 && this.k != null) {
            this.k.a(false);
        }
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 0;
        if (this.k != null) {
            int paddingLeft = getPaddingLeft() + getPaddingRight();
            int paddingBottom = getPaddingBottom() + getPaddingTop();
            if (this.k.G()) {
                int resolveSize = resolveSize(paddingLeft + this.k.getIntrinsicWidth(), i);
                this.y = resolveSize;
                if (this.k.p().e && (this.b.getVisibility() == 0 || this.c.getVisibility() == 0)) {
                    if (this.b.getVisibility() == 0) {
                        this.b.measure(MeasureSpec.makeMeasureSpec(resolveSize, 1073741824), MeasureSpec.makeMeasureSpec(0, 0));
                        paddingLeft = this.b.getCustomView() != null ? this.b.getMeasuredHeight() : Math.max(this.k.getIntrinsicHeight(), this.b.getMeasuredHeight());
                    } else {
                        paddingLeft = 0;
                    }
                    if (this.c.getVisibility() == 0) {
                        this.c.measure(MeasureSpec.makeMeasureSpec(resolveSize, 1073741824), MeasureSpec.makeMeasureSpec(0, 0));
                        if (this.c.getCustomView() != null) {
                            i3 = this.c.getMeasuredHeight();
                        } else {
                            i3 = Math.max(this.k.getIntrinsicHeight(), this.c.getMeasuredHeight());
                        }
                    }
                    paddingLeft = resolveSize(Math.max(paddingLeft, i3) + paddingBottom, i2);
                } else {
                    paddingLeft = resolveSize(this.k.getIntrinsicHeight() + paddingBottom, i2);
                }
                this.z = paddingLeft;
                i3 = resolveSize;
            } else if (!this.k.p().e || this.y <= 0 || this.z <= 0) {
                i3 = resolveSize(paddingLeft + this.k.getIntrinsicWidth(), i);
                paddingLeft = resolveSize(this.k.getIntrinsicHeight() + paddingBottom, i2);
            } else {
                i3 = this.y;
                paddingLeft = this.z;
            }
            super.onMeasure(MeasureSpec.makeMeasureSpec(i3, 1073741824), MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824));
            return;
        }
        super.onMeasure(i, i2);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.k != null) {
            this.k.setBounds(0, 0, i3 - i, i4 - i2);
        }
    }

    protected void a(Canvas canvas, boolean z) {
        n document = this.a.getDocument();
        if (document != null && !document.b() && this.k != null) {
            if (getGlobalVisibleRect(this.g, this.f)) {
                this.g.offset(-this.f.x, -this.f.y);
                this.k.a(this.g);
            }
            this.k.setBounds(0, 0, getWidth(), getHeight());
            if (!(this.B == null || (this.B.hasAlpha() == this.k.q().p && this.B.getWidth() == this.k.getBounds().width() && this.B.getHeight() == this.k.getBounds().height()))) {
                this.B.recycle();
                this.B = null;
            }
            if (z && this.B != null) {
                WebLog.c().b(A != null);
                this.k.a(new Canvas(A), getDrawingTime());
                if (this.k.i() != 1) {
                    canvas.drawBitmap(this.B, null, this.k.getBounds(), null);
                    return;
                }
                this.B.recycle();
                this.B = null;
                this.k.setVisible(true, false);
            }
            this.k.a(canvas, getDrawingTime());
            if (this.k.G()) {
                b(canvas);
            }
        }
    }

    private void k() {
        as asVar = null;
        if (this.k == null) {
            this.b.setVisibility(4);
            this.c.setVisibility(4);
        } else if (this.k instanceof i) {
            as c;
            i iVar = (i) this.k;
            Rect d = iVar.d();
            Rect e = iVar.e();
            if (iVar.a()) {
                asVar = iVar.b();
                c = iVar.c();
            } else {
                c = null;
            }
            this.b.a(asVar);
            this.c.a(c);
            this.b.setVisibility(0);
            this.c.setVisibility(0);
            this.b.setPadding(d.left, d.top, this.k.getBounds().width() - d.right, this.k.getBounds().height() - d.bottom);
            this.c.setPadding(e.left, e.top, this.k.getBounds().width() - e.right, this.k.getBounds().height() - e.bottom);
        } else {
            this.b.a(this.k);
            this.b.setVisibility(0);
            this.c.setVisibility(4);
            this.b.setPadding(0, 0, 0, 0);
            this.c.setPadding(0, 0, 0, 0);
        }
        this.l = true;
    }

    private void l() {
        if (this.l) {
            this.l = false;
            post(new gv(this));
        }
    }

    protected void a(gn gnVar) {
        l();
    }

    private void m() {
        for (int i = 0; i < this.k.s(); i++) {
            this.u.a(new ow(getContext(), this.j, this.k.d(i), this.k.h(i)), null, null);
        }
    }

    private void n() {
        for (int i = 0; i < this.k.w(); i++) {
            aj n = this.k.n(i);
            fu mrVar = new mr(getContext(), this.j, n, this.k.p(i));
            mu mhVar = new mh(getContext(), n.a(), mrVar.getPresenter());
            mrVar.a(mhVar);
            this.u.a(mrVar, mhVar, this.k.o(i));
        }
    }

    private void o() {
        for (int i = 0; i < this.k.r(); i++) {
            au c = this.k.c(i);
            if (c.j()) {
                this.u.a(new ko(getContext(), this.j, this.k.g(i), c), null, null);
            }
        }
    }

    private void p() {
        for (int i = 0; i < this.k.x(); i++) {
            ad q = this.k.q(i);
            if (q.j()) {
                this.u.a(new jx(getContext(), this.j, this.k.r(i), q), null, null);
            }
        }
    }

    private void q() {
        for (int i = 0; i < this.k.v(); i++) {
            ac k = this.k.k(i);
            if (k.j()) {
                fu joVar = new jo(getContext(), this.j, this.k.m(i), k);
                Object jmVar = new jm(getContext(), k);
                joVar.setGalleryShowingPicListener(jmVar);
                this.u.a(joVar, jmVar, this.k.l(i));
            }
        }
    }

    private void c(Canvas canvas) {
        if (i()) {
            Map highlights = this.a.getHighlights();
            if (highlights != null) {
                bb m = this.k.m();
                for (Entry entry : highlights.entrySet()) {
                    Drawable drawable = (Drawable) entry.getKey();
                    List<bb> list = (List) entry.getValue();
                    if (!(drawable == null || list == null)) {
                        for (bb b : list) {
                            bb b2 = b2.b(m);
                            if (!b2.f()) {
                                Rect[] e = this.k.e(b2);
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

    private void d(Canvas canvas) {
        if (this.j != null && i()) {
            bb activeText = this.a.getActiveText();
            if (activeText != null && !activeText.f()) {
                activeText = activeText.b(this.k.m());
                if (!activeText.f()) {
                    Rect[] e = this.k.e(activeText);
                    Drawable selectionDrawable = this.a.getSelectionDrawable();
                    for (Rect bounds : e) {
                        selectionDrawable.setBounds(bounds);
                        selectionDrawable.draw(canvas);
                    }
                }
            }
        }
    }

    private void e(Canvas canvas) {
        bb selection = this.a.getSelection();
        if (selection != null && i()) {
            selection = selection.b(this.k.m());
            if (!selection.f()) {
                Rect[] e = this.k.e(selection);
                Drawable selectionDrawable = this.a.getSelectionDrawable();
                for (Rect bounds : e) {
                    selectionDrawable.setBounds(bounds);
                    selectionDrawable.draw(canvas);
                }
            }
        }
    }

    protected void a(Canvas canvas) {
        if (i()) {
            Iterator it = this.p.iterator();
            while (it.hasNext()) {
                a(canvas, (ef) it.next());
            }
            if (this.o.size() > 0) {
                f(canvas);
            }
        }
    }

    private void f(Canvas canvas) {
        if (this.q) {
            Rect rect = (Rect) UTools.g.getRect();
            rect.set(0, 0, getWidth(), getHeight());
            rect.right -= UTools.getMinimumHeight(getContext(), 15.0f);
            UTools.addAnimation(canvas, this.a.a(DecorDrawableStyle.BOOK_MARK), rect, 53);
            UTools.g.getRect(rect);
        }
    }

    private void a(Canvas canvas, ef efVar) {
        int i = 255;
        int round = (this.k.q().i || this.k.q().j) ? Math.round(153.0f) : 255;
        el elVar = new el();
        elVar.a(getTextUnderlineWidth());
        elVar.a(eg.a().d(efVar.n()));
        if (!this.k.p().c()) {
            i = round;
        }
        elVar.setAlpha(i);
        if (this.a.getDocument().c() == WritingDirection.RIGHT_TO_LEFT) {
            elVar.b(3);
        } else if (this.a.getDocument().c() == WritingDirection.LEFT_TO_RIGHT) {
            elVar.b(5);
        } else {
            elVar.b(80);
        }
        for (Rect rect : this.k.e(this.a.getDocument().a((d) efVar.d(), (d) efVar.e()))) {
            if (!rect.isEmpty()) {
                elVar.setBounds(rect);
                elVar.draw(canvas);
            }
        }
        Rect a = a(efVar);
        if (!a.isEmpty()) {
            Drawable drawable = getResources().getDrawable(eg.a().b(eg.a().d(efVar.n())));
            drawable.setBounds(a);
            drawable.draw(canvas);
        }
    }

    protected void b(Canvas canvas) {
        canvas.save();
        g(canvas);
        h(canvas);
        canvas.restore();
    }

    private void g(Canvas canvas) {
        for (int i = 0; i < this.k.u(); i++) {
            Bitmap bitmap;
            com.duokan.reader.domain.document.ah f = this.k.f(i);
            Rect j = this.k.j(i);
            if (i != this.r || f.c()[1] == null) {
                bitmap = f.c()[0];
            } else {
                bitmap = f.c()[1];
            }
            this.h.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            this.i.set(j.left, j.top, j.right, j.bottom);
            if (f.e() && this.k.q().b != null) {
                this.k.q().b.getBounds().set(this.i);
                this.k.q().b.getBounds().inset(-21, -21);
                this.k.q().b.draw(canvas);
            }
            canvas.drawBitmap(bitmap, this.h, this.i, null);
        }
    }

    private void h(Canvas canvas) {
        canvas.save();
        for (int i = 0; i < this.s.length; i++) {
            Drawable drawable = this.s[i];
            if (drawable != null) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                Rect rect = new Rect(getPageDrawable().j(i));
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
        return ((float) Math.sqrt((double) this.a.getDocument().k().f)) * 0.618f;
    }

    protected go a(Context context) {
        go goVar = new go(context);
        goVar.setVisibility(4);
        return goVar;
    }
}
