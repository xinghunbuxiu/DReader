package com.duokan.reader.ui.reading;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.View;

import com.duokan.core.app.e;
import com.duokan.core.app.y;
import com.duokan.reader.UmengManager;
import com.duokan.reader.domain.bookshelf.BookFormat;
import com.duokan.reader.domain.bookshelf.a;
import com.duokan.reader.domain.bookshelf.ef;
import com.duokan.reader.domain.bookshelf.eg;
import com.duokan.reader.domain.document.WritingDirection;
import com.duokan.reader.domain.document.bb;
import com.duokan.reader.ui.general.el;

import java.util.LinkedList;
import java.util.List;

public class TextSelectionController extends e {
    private int a;
    private final wl b;
    private boolean c = false;
    private boolean d = false;
    private final sh e;
    private final int f = 11;
    private final List g;
    private final acv h;
    private final x i;
    private acw j = null;
    private SelectionStyle k = SelectionStyle.UNKNOW;
    private ef l = ((ef) a.d(null));
    private Drawable m;
    private el n;
    private boolean o;

    public enum PointPosition {
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        CENTER
    }

    enum SelectionStyle {
        UNKNOW,
        DRAG_INDICATOR,
        RAPID_SLIDE,
        FAST_SELECTING
    }

    public TextSelectionController(y yVar, sh shVar, wl wlVar, acv com_duokan_reader_ui_reading_acv) {
        super(yVar);
        this.b = wlVar;
        this.e = shVar;
        this.h = com_duokan_reader_ui_reading_acv;
        this.g = new LinkedList();
        this.g.add(new TextSelectionAssistant(this.e, 0));
        this.b.a(new acr(this, getActivity(), shVar));
        this.i = new acf(this);
    }

    protected boolean onShowMenu() {
        if (d()) {
            i();
        }
        return super.onShowMenu();
    }

    protected boolean onBack() {
        if (!d()) {
            return false;
        }
        i();
        return true;
    }

    protected boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 24 || i == 25) {
            i();
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void a() {
        this.m = this.e.getSelectionDrawable();
        this.o = this.e.s();
    }

    private void b() {
        int i = 255;
        int round = (this.e.getDocument().l().i || this.e.getDocument().l().j) ? Math.round(153.0f) : 255;
        a();
        this.n = (el) this.e.a(DecorDrawableStyle.SELECTION_HIGHLIGHT_LINE);
        this.n.a(((float) Math.sqrt((double) this.e.getDocument().k().f)) * 0.618f);
        this.n.a(eg.a().b());
        el elVar = this.n;
        if (!this.e.g()) {
            i = round;
        }
        elVar.setAlpha(i);
        if (this.k == SelectionStyle.RAPID_SLIDE) {
            if (this.e.getDocument().c() == WritingDirection.RIGHT_TO_LEFT) {
                this.n.b(3);
            } else if (this.e.getDocument().c() == WritingDirection.LEFT_TO_RIGHT) {
                this.n.b(5);
            } else {
                this.n.b(80);
            }
            this.e.setSelectionDrawable(this.n);
            this.e.setShowSelectionIndicators(false);
            return;
        }
        this.e.setSelectionDrawable(this.e.a(DecorDrawableStyle.SELECTION_HIGHLIGHT_RECT));
        this.e.setShowSelectionIndicators(true);
    }

    private void c() {
        this.e.setSelectionDrawable(this.m);
        this.e.setShowSelectionIndicators(this.o);
    }

    private boolean d() {
        return e().d();
    }

    private TextSelectionAssistant e() {
        return (TextSelectionAssistant) this.g.get(this.g.size() - 1);
    }

    private String f() {
        return this.e.getDocument().b(h());
    }

    private boolean g() {
        return this.k != SelectionStyle.UNKNOW;
    }

    private void a(SelectionStyle selectionStyle, View view) {
        if (this.k != selectionStyle) {
            this.k = selectionStyle;
            if (selectionStyle == SelectionStyle.FAST_SELECTING || selectionStyle == SelectionStyle.RAPID_SLIDE) {
                Point b = e().b();
                b(b.x, b.y, 0, view);
                UmengManager.get().onEvent("V2_READING_FASTDIGEST");
            }
            b();
        }
    }

    private bb h() {
        bb a = ((TextSelectionAssistant) this.g.get(0)).a();
        for (int i = 1; i < this.g.size(); i++) {
            a = a.a(((TextSelectionAssistant) this.g.get(i)).a());
        }
        return a;
    }

    private boolean a(int i, int i2, int i3, View view) {
        if (l()) {
            return false;
        }
        boolean a = e().a(i, i2, i3, view);
        if (!a) {
            return false;
        }
        if (a && this.e.a(h()) >= 0) {
            this.d = true;
        }
        m().a(this.d);
        c(i, i2, i3, view);
        return a;
    }

    private boolean b(int i, int i2, int i3, View view) {
        if (l()) {
            this.a = i3;
            return false;
        }
        boolean a = e().a(i, i2, i3, view);
        c(i, i2, i3, view);
        return a;
    }

    private void a(Point point, Rect rect, View view) {
        TextSelectionAssistant e = e();
        if (!l() && !e.c() && !this.d) {
            Point point2 = new Point(1, 1);
            Point point3 = new Point(rect.width() - 1, rect.height() - 1);
            DocPageLayout M = this.e.M();
            if (this.e.c(point.x, point.y)) {
                if (M == DocPageLayout.LEFT_TO_RIGHT) {
                    b(point, point2, point3, view);
                } else if (M == DocPageLayout.RIGHT_TO_LEFT) {
                    point2.set(rect.width(), 0);
                    point3.set(0, rect.height());
                    b(point, point2, point3, view);
                } else if (M == DocPageLayout.TOP_TO_BOTTOM) {
                    b(point, point2, point3, view);
                }
            } else if (!this.e.d(point.x, point.y)) {
            } else {
                if (M == DocPageLayout.LEFT_TO_RIGHT) {
                    a(point, point2, point3, view);
                } else if (M == DocPageLayout.RIGHT_TO_LEFT) {
                    point2.set(rect.width(), 0);
                    point3.set(0, rect.height());
                    a(point, point2, point3, view);
                } else if (M == DocPageLayout.TOP_TO_BOTTOM) {
                    a(point, point2, point3, view);
                }
            }
        }
    }

    private void c(int i, int i2, int i3, View view) {
        this.e.setSelection(h());
        TextSelectionAssistant e = e();
        e.e();
        if (!m().b()) {
            this.e.aU();
            this.b.addView(m());
            this.e.a(0, 128);
        }
        if (i3 == 1) {
            switch (acq.a[this.k.ordinal()]) {
                case 1:
                    a(SelectionStyle.DRAG_INDICATOR, view);
                    m().a(e.g());
                    return;
                case 2:
                    this.i.b();
                    i();
                    return;
                case 3:
                    if (e.c()) {
                        i();
                        return;
                    }
                    a(SelectionStyle.DRAG_INDICATOR, view);
                    m().a(e.g());
                    return;
                case 4:
                    if (e.c()) {
                        i();
                        return;
                    } else {
                        m().a(e.g());
                        return;
                    }
                default:
                    return;
            }
        } else if (this.k == SelectionStyle.DRAG_INDICATOR && e.c()) {
            m().a();
        } else {
            m().a(this.b.getPagesFrameView(), e.f(), new Point(i, i2));
        }
    }

    private void i() {
        this.g.clear();
        a(false);
        this.d = false;
        this.e.setSelection(null);
        this.k = SelectionStyle.UNKNOW;
        this.g.add(new TextSelectionAssistant(this.e, 0));
        if (this.j != null) {
            this.b.removeView(this.j);
        }
        c();
        this.e.aV();
        this.e.a(128, 0);
    }

    private boolean j() {
        boolean z = false;
        if (this.e.G().q() == BookFormat.PDF) {
            return true;
        }
        int i = 0;
        for (TextSelectionAssistant h : this.g) {
            int i2;
            if (h.h() > 0) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i = i2;
        }
        if (i < 5) {
            z = true;
        }
        return z;
    }

    private boolean k() {
        boolean z = false;
        if (this.e.G().q() == BookFormat.PDF) {
            return true;
        }
        int i = 0;
        for (TextSelectionAssistant h : this.g) {
            int i2;
            if (h.h() < 0) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i = i2;
        }
        if (i < 5) {
            z = true;
        }
        return z;
    }

    private void a(Point point, Point point2, Point point3, View view) {
        if (j()) {
            a(true);
            this.a = 2;
            TextSelectionAssistant e = e();
            if (e.h() >= 0) {
                e.a(point3);
                this.e.setSelection(h());
                e.e();
                this.e.b(new acg(this, point2, point, view), new aci(this, point, view));
                return;
            }
            this.g.remove(this.g.size() - 1);
            this.e.b(new acj(this, point, view), null);
        }
    }

    private void b(Point point, Point point2, Point point3, View view) {
        if (k()) {
            a(true);
            this.a = 2;
            TextSelectionAssistant e = e();
            if (e.h() <= 0) {
                e.a(point2);
                this.e.setSelection(h());
                e.e();
                this.e.a(new acl(this, point, point3, view), new acn(this, point, view));
                return;
            }
            this.g.remove(this.g.size() - 1);
            this.e.a(new aco(this, point, view), null);
        }
    }

    private boolean l() {
        return this.c || this.e.q();
    }

    private void a(boolean z) {
        this.c = z;
    }

    private acw m() {
        if (this.j == null) {
            this.j = new acw(getContext(), this.i);
        }
        return this.j;
    }
}
