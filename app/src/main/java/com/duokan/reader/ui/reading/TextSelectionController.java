package com.duokan.reader.ui.reading;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.View;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.reader.UmengManager;
import com.duokan.reader.domain.bookshelf.BookFormat;
import com.duokan.reader.domain.bookshelf.C0798a;
import com.duokan.reader.domain.bookshelf.ea;
import com.duokan.reader.domain.bookshelf.eb;
import com.duokan.reader.domain.document.WritingDirection;
import com.duokan.reader.domain.document.bb;
import com.duokan.reader.ui.general.ej;
import java.util.LinkedList;
import java.util.List;

public class TextSelectionController extends ActivatedController {
    /* renamed from: a */
    private int f9152a;
    /* renamed from: b */
    private final wy f9153b;
    /* renamed from: c */
    private boolean f9154c = false;
    /* renamed from: d */
    private boolean f9155d = false;
    /* renamed from: e */
    private final su f9156e;
    /* renamed from: f */
    private final int f9157f = 11;
    /* renamed from: g */
    private final List<TextSelectionAssistant> f9158g;
    /* renamed from: h */
    private final adi f9159h;
    /* renamed from: i */
    private final C1447x f9160i;
    /* renamed from: j */
    private adj f9161j = null;
    /* renamed from: k */
    private SelectionStyle f9162k = SelectionStyle.UNKNOW;
    /* renamed from: l */
    private ea f9163l = ((ea) C0798a.m3713d(null));
    /* renamed from: m */
    private Drawable f9164m;
    /* renamed from: n */
    private ej f9165n;
    /* renamed from: o */
    private boolean f9166o;

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

    public TextSelectionController(IFeature mFeature, su suVar, wy wyVar, adi adi) {
        super(mFeature);
        this.f9153b = wyVar;
        this.f9156e = suVar;
        this.f9159h = adi;
        this.f9158g = new LinkedList();
        this.f9158g.add(new TextSelectionAssistant(this.f9156e, 0));
        this.f9153b.m13649a(new ade(this, getActivity(), suVar));
        this.f9160i = new acs(this);
    }

    protected boolean onShowMenu() {
        if (m12570d()) {
            m12580i();
        }
        return super.onShowMenu();
    }

    protected boolean onBack() {
        if (!m12570d()) {
            return false;
        }
        m12580i();
        return true;
    }

    protected boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 24 || i == 25) {
            m12580i();
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* renamed from: a */
    private void m12549a() {
        this.f9164m = this.f9156e.getSelectionDrawable();
        this.f9166o = this.f9156e.mo2171s();
    }

    /* renamed from: b */
    private void m12561b() {
        int i = 255;
        int round = (this.f9156e.getDocument().mo1246l().f4361i || this.f9156e.getDocument().mo1246l().f4362j) ? Math.round(153.0f) : 255;
        m12549a();
        this.f9165n = (ej) this.f9156e.mo2012a(DecorDrawableStyle.SELECTION_HIGHLIGHT_LINE);
        this.f9165n.m10559a(((float) Math.sqrt((double) this.f9156e.getDocument().mo1245k().f4335f)) * 0.618f);
        this.f9165n.m10560a(eb.m4386a().m4389b());
        ej ejVar = this.f9165n;
        if (!this.f9156e.mo2145g()) {
            i = round;
        }
        ejVar.setAlpha(i);
        if (this.f9162k == SelectionStyle.RAPID_SLIDE) {
            if (this.f9156e.getDocument().mo1228c() == WritingDirection.RIGHT_TO_LEFT) {
                this.f9165n.m10562b(3);
            } else if (this.f9156e.getDocument().mo1228c() == WritingDirection.LEFT_TO_RIGHT) {
                this.f9165n.m10562b(5);
            } else {
                this.f9165n.m10562b(80);
            }
            this.f9156e.setSelectionDrawable(this.f9165n);
            this.f9156e.setShowSelectionIndicators(false);
            return;
        }
        this.f9156e.setSelectionDrawable(this.f9156e.mo2012a(DecorDrawableStyle.SELECTION_HIGHLIGHT_RECT));
        this.f9156e.setShowSelectionIndicators(true);
    }

    /* renamed from: c */
    private void m12566c() {
        this.f9156e.setSelectionDrawable(this.f9164m);
        this.f9156e.setShowSelectionIndicators(this.f9166o);
    }

    /* renamed from: d */
    private boolean m12570d() {
        return m12571e().m12543d();
    }

    /* renamed from: e */
    private TextSelectionAssistant m12571e() {
        return (TextSelectionAssistant) this.f9158g.get(this.f9158g.size() - 1);
    }

    /* renamed from: f */
    private String m12574f() {
        return this.f9156e.getDocument().m5916b(m12578h());
    }

    /* renamed from: g */
    private boolean m12576g() {
        return this.f9162k != SelectionStyle.UNKNOW;
    }

    /* renamed from: a */
    private void m12552a(SelectionStyle selectionStyle, View view) {
        if (this.f9162k != selectionStyle) {
            this.f9162k = selectionStyle;
            if (selectionStyle == SelectionStyle.FAST_SELECTING || selectionStyle == SelectionStyle.RAPID_SLIDE) {
                Point b = m12571e().m12541b();
                m12563b(b.x, b.y, 0, view);
                UmengManager.get().onEvent("V2_READING_FASTDIGEST");
            }
            m12561b();
        }
    }

    /* renamed from: h */
    private bb m12578h() {
        bb a = ((TextSelectionAssistant) this.f9158g.get(0)).m12537a();
        for (int i = 1; i < this.f9158g.size(); i++) {
            a = a.mo1196a(((TextSelectionAssistant) this.f9158g.get(i)).m12537a());
        }
        return a;
    }

    /* renamed from: a */
    private boolean m12559a(int i, int i2, int i3, View view) {
        if (m12585l()) {
            return false;
        }
        boolean a = m12571e().m12540a(i, i2, i3, view);
        if (!a) {
            return false;
        }
        if (a && this.f9156e.mo2010a(m12578h()) >= 0) {
            this.f9155d = true;
        }
        m12587m().m13363a(this.f9155d);
        m12567c(i, i2, i3, view);
        return a;
    }

    /* renamed from: b */
    private boolean m12563b(int i, int i2, int i3, View view) {
        if (m12585l()) {
            this.f9152a = i3;
            return false;
        }
        boolean a = m12571e().m12540a(i, i2, i3, view);
        m12567c(i, i2, i3, view);
        return a;
    }

    /* renamed from: a */
    private void m12551a(Point point, Rect rect, View view) {
        TextSelectionAssistant e = m12571e();
        if (!m12585l() && !e.m12542c() && !this.f9155d) {
            Point point2 = new Point(1, 1);
            Point point3 = new Point(rect.width() - 1, rect.height() - 1);
            DocPageLayout M = this.f9156e.mo1996M();
            if (this.f9156e.mo2129c(point.x, point.y)) {
                if (M == DocPageLayout.LEFT_TO_RIGHT) {
                    m12562b(point, point2, point3, view);
                } else if (M == DocPageLayout.RIGHT_TO_LEFT) {
                    point2.set(rect.width(), 0);
                    point3.set(0, rect.height());
                    m12562b(point, point2, point3, view);
                } else if (M == DocPageLayout.TOP_TO_BOTTOM) {
                    m12562b(point, point2, point3, view);
                }
            } else if (!this.f9156e.mo2134d(point.x, point.y)) {
            } else {
                if (M == DocPageLayout.LEFT_TO_RIGHT) {
                    m12550a(point, point2, point3, view);
                } else if (M == DocPageLayout.RIGHT_TO_LEFT) {
                    point2.set(rect.width(), 0);
                    point3.set(0, rect.height());
                    m12550a(point, point2, point3, view);
                } else if (M == DocPageLayout.TOP_TO_BOTTOM) {
                    m12550a(point, point2, point3, view);
                }
            }
        }
    }

    /* renamed from: c */
    private void m12567c(int i, int i2, int i3, View view) {
        this.f9156e.setSelection(m12578h());
        TextSelectionAssistant e = m12571e();
        e.m12544e();
        if (!m12587m().m13365b()) {
            this.f9156e.aU();
            this.f9153b.addView(m12587m());
            this.f9156e.mo2040a(0, 128);
        }
        if (i3 == 1) {
            switch (add.f9506a[this.f9162k.ordinal()]) {
                case 1:
                    m12552a(SelectionStyle.DRAG_INDICATOR, view);
                    m12587m().m13364a(e.m12546g());
                    return;
                case 2:
                    this.f9160i.mo2202b();
                    m12580i();
                    return;
                case 3:
                    if (e.m12542c()) {
                        m12580i();
                        return;
                    }
                    m12552a(SelectionStyle.DRAG_INDICATOR, view);
                    m12587m().m13364a(e.m12546g());
                    return;
                case 4:
                    if (e.m12542c()) {
                        m12580i();
                        return;
                    } else {
                        m12587m().m13364a(e.m12546g());
                        return;
                    }
                default:
                    return;
            }
        } else if (this.f9162k == SelectionStyle.DRAG_INDICATOR && e.m12542c()) {
            m12587m().m13361a();
        } else {
            m12587m().m13362a(this.f9153b.getPagesFrameView(), e.m12545f(), new Point(i, i2));
        }
    }

    /* renamed from: i */
    private void m12580i() {
        this.f9158g.clear();
        m12558a(false);
        this.f9155d = false;
        this.f9156e.setSelection(null);
        this.f9162k = SelectionStyle.UNKNOW;
        this.f9158g.add(new TextSelectionAssistant(this.f9156e, 0));
        if (this.f9161j != null) {
            this.f9153b.removeView(this.f9161j);
        }
        m12566c();
        this.f9156e.aV();
        this.f9156e.mo2040a(128, 0);
    }

    /* renamed from: j */
    private boolean m12581j() {
        boolean z = false;
        if (this.f9156e.mo1992G().mo1039q() == BookFormat.PDF) {
            return true;
        }
        int i = 0;
        for (TextSelectionAssistant h : this.f9158g) {
            int i2;
            if (h.m12547h() > 0) {
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

    /* renamed from: k */
    private boolean m12583k() {
        boolean z = false;
        if (this.f9156e.mo1992G().mo1039q() == BookFormat.PDF) {
            return true;
        }
        int i = 0;
        for (TextSelectionAssistant h : this.f9158g) {
            int i2;
            if (h.m12547h() < 0) {
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

    /* renamed from: a */
    private void m12550a(Point point, Point point2, Point point3, View view) {
        if (m12581j()) {
            m12558a(true);
            this.f9152a = 2;
            TextSelectionAssistant e = m12571e();
            if (e.m12547h() >= 0) {
                e.m12538a(point3);
                this.f9156e.setSelection(m12578h());
                e.m12544e();
                this.f9156e.mo2104b(new act(this, point2, point, view), new acv(this, point, view));
                return;
            }
            this.f9158g.remove(this.f9158g.size() - 1);
            this.f9156e.mo2104b(new acw(this, point, view), null);
        }
    }

    /* renamed from: b */
    private void m12562b(Point point, Point point2, Point point3, View view) {
        if (m12583k()) {
            m12558a(true);
            this.f9152a = 2;
            TextSelectionAssistant e = m12571e();
            if (e.m12547h() <= 0) {
                e.m12538a(point2);
                this.f9156e.setSelection(m12578h());
                e.m12544e();
                this.f9156e.mo2035a(new acy(this, point, point3, view), new ada(this, point, view));
                return;
            }
            this.f9158g.remove(this.f9158g.size() - 1);
            this.f9156e.mo2035a(new adb(this, point, view), null);
        }
    }

    /* renamed from: l */
    private boolean m12585l() {
        return this.f9154c || this.f9156e.mo2169q();
    }

    /* renamed from: a */
    private void m12558a(boolean z) {
        this.f9154c = z;
    }

    /* renamed from: m */
    private adj m12587m() {
        if (this.f9161j == null) {
            this.f9161j = new adj(getContext(), this.f9160i);
        }
        return this.f9161j;
    }
}
