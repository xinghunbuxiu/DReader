package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseIntArray;
import com.duokan.core.diagnostic.C0328a;
import com.duokan.core.sys.UThread;
import com.duokan.core.ui.dv;
import java.util.ArrayList;
import org.apache.http.HttpStatus;

public class FlowPagesView extends PagesView {
    /* renamed from: a */
    private final ArrayList<df> f6848a = new ArrayList(3);
    /* renamed from: b */
    private final SparseIntArray f6849b = new SparseIntArray();
    /* renamed from: c */
    private Drawable f6850c = null;
    /* renamed from: d */
    private Drawable f6851d = null;
    /* renamed from: e */
    private int f6852e = -1;
    /* renamed from: f */
    private int f6853f = 1;
    /* renamed from: g */
    private int f6854g = 0;
    /* renamed from: h */
    private int f6855h = 0;
    /* renamed from: i */
    private int f6856i = 0;
    /* renamed from: j */
    private int f6857j = 0;
    /* renamed from: k */
    private FlipEffect f6858k = FlipEffect.SCROLL;
    /* renamed from: l */
    private df f6859l = null;

    public enum FlipEffect {
        NONE,
        SCROLL,
        OVERLAP,
        FADE_IN
    }

    /* renamed from: d */
    protected /* synthetic */ ga mo1740d() {
        return m10131c();
    }

    /* renamed from: e */
    protected /* synthetic */ gd mo1741e() {
        return m10128b();
    }

    public FlowPagesView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6848a.add(null);
        this.f6848a.add(null);
        this.f6848a.add(null);
        this.f6849b.put(0, 0);
        this.f6849b.put(-1, 1);
        this.f6849b.put(1, 2);
        this.f6852e = -1;
        this.f6853f = 1;
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        getCellsView().m1111a(displayMetrics.widthPixels / 2, displayMetrics.heightPixels / 2, displayMetrics.widthPixels / 2, displayMetrics.heightPixels * 2);
    }

    public final FlipEffect getFlipEffect() {
        return this.f6858k;
    }

    public final void setFlipEffect(FlipEffect flipEffect) {
        this.f6858k = flipEffect;
    }

    public final void setPageLeftShadow(int i) {
        setPageLeftShadow(getResources().getDrawable(i));
    }

    public final void setPageLeftShadow(Drawable drawable) {
        this.f6850c = drawable;
        getCellsView().mo1757p();
    }

    public final void setPageRightShadow(int i) {
        setPageRightShadow(getResources().getDrawable(i));
    }

    public final void setPageRightShadow(Drawable drawable) {
        this.f6851d = drawable;
        getCellsView().mo1757p();
    }

    /* renamed from: a */
    protected void mo1735a(gb gbVar) {
        boolean z = true;
        setCurrentPageIndicator(gbVar);
        getProxyAdapter().mo1765b().mo1691d();
        getCellsView().mo1758q();
        int n = m10117n(0);
        if (getCurrentPageIndicator() != null) {
            if (this.f6848a.get(n) == null) {
                getCellsView().m1119a(n, true);
                getCellsView().m1141g(n);
                getCellsView().m1119a(n, false);
            }
            C0328a c = C0328a.m757c();
            if (this.f6848a.get(n) == null) {
                z = false;
            }
            c.m764b(z);
            setCurrentPagePresenter((gc) this.f6848a.get(n));
            getCellsView().m1126b(n, new Rect(0, 0, getWidth(), getHeight()), 51);
            return;
        }
        setCurrentPagePresenter(null);
    }

    /* renamed from: a */
    protected void mo1737a(boolean z, Runnable runnable, Runnable runnable2) {
        df dfVar = (df) getCurrentPagePresenter();
        if (dfVar == null) {
            return;
        }
        if (dfVar.mo2330f() || dfVar.mo2329e()) {
            db dbVar = (db) getAdapter();
            if (dbVar != null && dbVar.mo2322b(dfVar)) {
                m10024l();
                if (runnable2 != null) {
                    runnable2.run();
                }
            } else if (m10027o()) {
                if (!z) {
                    if (m10026n()) {
                        getCellsView().scrollBy(-this.f6856i, 0);
                    } else {
                        getCellsView().scrollBy(this.f6856i, 0);
                    }
                    UThread.runOnThread(runnable);
                } else if (m10026n()) {
                    getCellsView().m1125b(-this.f6856i, 0, HttpStatus.SC_MULTIPLE_CHOICES, runnable, runnable2);
                } else {
                    getCellsView().m1125b(this.f6856i, 0, HttpStatus.SC_MULTIPLE_CHOICES, runnable, runnable2);
                }
            } else if (z) {
                getCellsView().m1125b(0, this.f6857j / 2, HttpStatus.SC_MULTIPLE_CHOICES, runnable, runnable2);
            } else {
                getCellsView().scrollBy(0, this.f6857j / 2);
                UThread.runOnThread(runnable);
            }
        }
    }

    /* renamed from: b */
    protected void mo1739b(boolean z, Runnable runnable, Runnable runnable2) {
        df dfVar = (df) getCurrentPagePresenter();
        if (dfVar == null) {
            return;
        }
        if (dfVar.mo2330f() || dfVar.mo2329e()) {
            db dbVar = (db) getAdapter();
            if (dbVar != null && dbVar.mo2320a(dfVar)) {
                m10023k();
                if (runnable2 != null) {
                    runnable2.run();
                }
            } else if (m10027o()) {
                if (!z) {
                    if (m10026n()) {
                        getCellsView().scrollBy(this.f6856i, 0);
                    } else {
                        getCellsView().scrollBy(-this.f6856i, 0);
                    }
                    UThread.runOnThread(runnable);
                } else if (m10026n()) {
                    getCellsView().m1125b(this.f6856i, 0, HttpStatus.SC_MULTIPLE_CHOICES, runnable, runnable2);
                } else {
                    getCellsView().m1125b(-this.f6856i, 0, HttpStatus.SC_MULTIPLE_CHOICES, runnable, runnable2);
                }
            } else if (z) {
                getCellsView().m1125b(0, (-this.f6857j) / 2, HttpStatus.SC_MULTIPLE_CHOICES, runnable, runnable2);
            } else {
                getCellsView().scrollBy(0, (-this.f6857j) / 2);
                UThread.runOnThread(runnable);
            }
        }
    }

    /* renamed from: b */
    protected void mo1738b(boolean z) {
    }

    /* renamed from: a */
    protected void mo1734a() {
    }

    /* renamed from: b */
    protected dg m10128b() {
        return new dg();
    }

    /* renamed from: c */
    protected dc m10131c() {
        return new dc(this, getContext());
    }

    protected int getMinPageOffset() {
        return this.f6852e;
    }

    protected int getMaxPageOffset() {
        return this.f6853f;
    }

    protected int b_(int i) {
        return m10115m(i);
    }

    /* renamed from: b */
    protected int m10127b(int i) {
        return m10117n(i);
    }

    /* renamed from: q */
    private void mo2169q() {
        Rect viewportBounds = getViewportBounds();
        int i;
        if (m10027o()) {
            i = this.f6852e;
            while (i <= this.f6853f) {
                if (i < -1 || i > 1) {
                    int n = m10117n(i);
                    getCellsView().m1123b(n, 0, 0);
                    getCellsView().m1109a(n, 1.0f);
                }
                i++;
            }
            if (this.f6858k == FlipEffect.OVERLAP) {
                if (m10090d(viewportBounds)) {
                    getCellsView().m1123b(m10117n(1), viewportBounds.left - m10097f(1), 0);
                    getCellsView().m1123b(m10117n(0), 0, 0);
                    getCellsView().m1123b(m10117n(-1), 0, 0);
                    return;
                } else if (m10085c(viewportBounds)) {
                    getCellsView().m1123b(m10117n(0), viewportBounds.left - m10097f(0), 0);
                    getCellsView().m1123b(m10117n(1), 0, 0);
                    getCellsView().m1123b(m10117n(-1), 0, 0);
                    return;
                } else {
                    getCellsView().m1123b(m10117n(-1), 0, 0);
                    getCellsView().m1123b(m10117n(0), 0, 0);
                    getCellsView().m1123b(m10117n(1), 0, 0);
                    return;
                }
            } else if (this.f6858k != FlipEffect.FADE_IN) {
                getCellsView().m1123b(m10117n(0), 0, 0);
                getCellsView().m1109a(m10117n(0), 1.0f);
                getCellsView().m1123b(m10117n(-1), 0, 0);
                getCellsView().m1109a(m10117n(-1), 1.0f);
                getCellsView().m1123b(m10117n(1), 0, 0);
                getCellsView().m1109a(m10117n(1), 1.0f);
                return;
            } else if (m10090d(viewportBounds)) {
                i = viewportBounds.left - m10097f(0);
                getCellsView().m1123b(m10117n(0), i, 0);
                getCellsView().m1109a(m10117n(0), 1.0f - (((float) Math.abs(i)) / ((float) this.f6856i)));
                getCellsView().m1123b(m10117n(1), viewportBounds.left - m10097f(1), 0);
                getCellsView().m1109a(m10117n(1), 1.0f);
                getCellsView().m1123b(m10117n(-1), 0, 0);
                getCellsView().m1109a(m10117n(-1), 1.0f);
                return;
            } else if (m10085c(viewportBounds)) {
                getCellsView().m1123b(m10117n(0), viewportBounds.left - m10097f(0), 0);
                getCellsView().m1109a(m10117n(0), 1.0f);
                i = viewportBounds.left - m10097f(-1);
                getCellsView().m1123b(m10117n(-1), i, 0);
                getCellsView().m1109a(m10117n(-1), 1.0f - (((float) Math.abs(i)) / ((float) this.f6856i)));
                getCellsView().m1123b(m10117n(1), 0, 0);
                getCellsView().m1109a(m10117n(1), 1.0f);
                return;
            } else {
                getCellsView().m1123b(m10117n(0), 0, 0);
                getCellsView().m1109a(m10117n(0), 1.0f);
                getCellsView().m1123b(m10117n(-1), 0, 0);
                getCellsView().m1109a(m10117n(-1), 1.0f);
                getCellsView().m1123b(m10117n(1), 0, 0);
                getCellsView().m1109a(m10117n(1), 1.0f);
                return;
            }
        }
        for (i = this.f6852e; i <= this.f6853f; i++) {
            int n2 = m10117n(i);
            getCellsView().m1123b(n2, 0, 0);
            getCellsView().m1109a(n2, 1.0f);
        }
    }

    /* renamed from: b */
    private boolean m10081b(Rect rect) {
        df dfVar = (df) getCurrentPagePresenter();
        if (dfVar != null && dfVar.mo2329e()) {
            Rect rect2 = (Rect) dv.f1198g.addAnimation();
            int i = this.f6852e;
            while (i <= this.f6853f) {
                m10074a(rect2, i);
                if (Rect.intersects(rect2, rect)) {
                    break;
                }
                i++;
            }
            dv.f1198g.clearAnimation(rect2);
            if (i != 0) {
                int i2;
                if (i > 0 && !getAdapter().mo2322b(dfVar)) {
                    for (i2 = 0; i2 < Math.abs(i); i2++) {
                        mo2170r();
                    }
                } else if (i < 0 && !getAdapter().mo2320a(dfVar)) {
                    for (i2 = 0; i2 < Math.abs(i); i2++) {
                        mo2171s();
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: r */
    private void mo2170r() {
        boolean z = false;
        int n = m10117n(this.f6852e);
        for (int i = this.f6852e; i < this.f6853f; i++) {
            this.f6849b.put(i, m10117n(i + 1));
        }
        this.f6849b.put(this.f6853f, n);
        this.f6854g = m10107i(0);
        this.f6855h = m10109j(0);
        df dfVar = (df) this.f6848a.get(m10117n(0));
        C0328a c = C0328a.m757c();
        if (dfVar != null) {
            z = true;
        }
        c.m764b(z);
        setCurrentPageIndicator(dfVar.mo2327c());
        setCurrentPagePresenter(dfVar);
        getCellsView().mo1756o();
        getProxyAdapter().mo1765b().mo2519h(n, 1);
    }

    /* renamed from: s */
    private void mo2171s() {
        boolean z = false;
        int n = m10117n(this.f6853f);
        for (int i = this.f6853f; i > this.f6852e; i--) {
            this.f6849b.put(i, m10117n(i - 1));
        }
        this.f6849b.put(this.f6852e, n);
        this.f6854g = m10107i(0);
        this.f6855h = m10109j(0);
        df dfVar = (df) this.f6848a.get(m10117n(0));
        C0328a c = C0328a.m757c();
        if (dfVar != null) {
            z = true;
        }
        c.m764b(z);
        setCurrentPageIndicator(dfVar.mo2327c());
        setCurrentPagePresenter(dfVar);
        getCellsView().mo1756o();
        getProxyAdapter().mo1765b().mo2519h(n, 1);
    }

    /* renamed from: c */
    private boolean m10085c(Rect rect) {
        boolean z = true;
        Rect rect2 = (Rect) dv.f1198g.addAnimation();
        rect2.set(m10097f(0), m10105h(0), m10092e(0), m10101g(0));
        if (m10027o()) {
            if (m10026n()) {
                if (rect.right <= rect2.right) {
                    z = false;
                }
            } else if (rect.left >= rect2.left) {
                z = false;
            }
        } else if (rect.top >= rect2.top) {
            z = false;
        }
        dv.f1198g.clearAnimation(rect2);
        return z;
    }

    /* renamed from: c */
    private boolean m10084c(int i) {
        if (m10027o()) {
            if (m10026n()) {
                if (i <= 0) {
                    return false;
                }
                return true;
            } else if (i < 0) {
                return true;
            } else {
                return false;
            }
        } else if (i >= 0) {
            return false;
        } else {
            return true;
        }
    }

    /* renamed from: d */
    private boolean m10090d(Rect rect) {
        boolean z = true;
        Rect rect2 = (Rect) dv.f1198g.addAnimation();
        rect2.set(m10097f(0), m10105h(0), m10092e(0), m10101g(0));
        if (m10027o()) {
            if (m10026n()) {
                if (rect.left >= rect2.left) {
                    z = false;
                }
            } else if (rect.right <= rect2.right) {
                z = false;
            }
        } else if (rect.bottom <= rect2.bottom) {
            z = false;
        }
        dv.f1198g.clearAnimation(rect2);
        return z;
    }

    /* renamed from: d */
    private boolean m10089d(int i) {
        if (m10027o()) {
            if (m10026n()) {
                if (i >= 0) {
                    return false;
                }
                return true;
            } else if (i > 0) {
                return true;
            } else {
                return false;
            }
        } else if (i <= 0) {
            return false;
        } else {
            return true;
        }
    }

    /* renamed from: e */
    private void m10095e(Rect rect) {
        if (getCurrentPagePresenter() != null && this.f6856i >= 1 && this.f6857j >= 1) {
            Rect rect2 = (Rect) dv.f1198g.addAnimation();
            m10103g(rect2);
            if (rect2.isEmpty() || !Rect.intersects(rect2, rect)) {
                dv.f1198g.clearAnimation(rect2);
            } else if (rect2.contains(rect)) {
                dv.f1198g.clearAnimation(rect2);
            } else {
                while (true) {
                    int i;
                    Object i2;
                    m10074a(rect2, this.f6852e);
                    if (m10027o()) {
                        if (m10026n()) {
                            try {
                                if (rect.right > rect2.right) {
                                    i2 = 1;
                                } else {
                                    i2 = null;
                                }
                            } catch (Throwable th) {
                                dv.f1198g.clearAnimation(rect2);
                            }
                        } else {
                            i2 = rect.left < rect2.left ? 1 : null;
                        }
                    } else if (rect.top < rect2.top) {
                        i2 = 1;
                    } else {
                        i2 = null;
                    }
                    if (i2 != null) {
                        this.f6852e--;
                        if (this.f6853f <= 1 || Rect.intersects(m10074a(rect2, this.f6853f), rect)) {
                            this.f6848a.add(null);
                            this.f6849b.put(this.f6852e, this.f6848a.size() - 1);
                            getProxyAdapter().mo1765b().m1397f(m10117n(this.f6852e), 1);
                        } else {
                            this.f6849b.put(this.f6852e, m10117n(this.f6853f));
                            this.f6849b.delete(this.f6853f);
                            this.f6853f--;
                            getProxyAdapter().mo1765b().mo2519h(m10117n(this.f6852e), 1);
                        }
                    } else {
                        m10074a(rect2, this.f6853f);
                        if (m10027o()) {
                            if (!m10026n()) {
                                i2 = rect.right > rect2.right ? 1 : null;
                            } else if (rect.left < rect2.left) {
                                i2 = 1;
                            } else {
                                i2 = null;
                            }
                        } else if (rect.bottom > rect2.bottom) {
                            i2 = 1;
                        } else {
                            i2 = null;
                        }
                        if (i2 != null) {
                            this.f6853f++;
                            if (this.f6852e >= -1 || Rect.intersects(m10074a(rect2, this.f6852e), rect)) {
                                this.f6848a.add(null);
                                this.f6849b.put(this.f6853f, this.f6848a.size() - 1);
                                getProxyAdapter().mo1765b().m1397f(m10117n(this.f6853f), 1);
                            } else {
                                this.f6849b.put(this.f6853f, m10117n(this.f6852e));
                                this.f6849b.delete(this.f6852e);
                                this.f6852e++;
                                getProxyAdapter().mo1765b().mo2519h(m10117n(this.f6853f), 1);
                                getCellsView().mo1756o();
                            }
                        } else {
                            dv.f1198g.clearAnimation(rect2);
                            return;
                        }
                    }
                }
            }
        }
    }

    /* renamed from: f */
    private Rect m10099f(Rect rect) {
        int i;
        Rect rect2 = (Rect) dv.f1198g.addAnimation();
        for (i = 0; i >= this.f6852e; i--) {
            df dfVar = (df) this.f6848a.get(m10117n(i));
            if (dfVar != null) {
                rect.union(m10074a(rect2, i));
                if (dfVar.mo2329e() && getProxyAdapter().mo1765b().mo2320a(dfVar)) {
                    break;
                }
            }
        }
        for (i = 0; i <= this.f6853f; i++) {
            dfVar = (df) this.f6848a.get(m10117n(i));
            if (dfVar != null) {
                rect.union(m10074a(rect2, i));
                if (dfVar.mo2329e() && getProxyAdapter().mo1765b().mo2322b(dfVar)) {
                    break;
                }
            }
        }
        dv.f1198g.clearAnimation(rect2);
        if (m10027o()) {
            rect.top = 0;
            rect.bottom = getContentHeight();
        } else {
            rect.left = 0;
            rect.right = getContentWidth();
        }
        return rect;
    }

    /* renamed from: g */
    private Rect m10103g(Rect rect) {
        Rect rect2 = (Rect) dv.f1198g.addAnimation();
        m10074a(rect2, this.f6852e);
        rect.set(rect2);
        m10074a(rect2, this.f6853f);
        rect.union(rect2);
        dv.f1198g.clearAnimation(rect2);
        return rect;
    }

    /* renamed from: a */
    private Rect m10074a(Rect rect, int i) {
        rect.set(m10097f(i), m10105h(i), m10092e(i), m10101g(i));
        return rect;
    }

    /* renamed from: e */
    private int m10092e(int i) {
        return m10111k(i) - getPageRightShadowWidth();
    }

    /* renamed from: f */
    private int m10097f(int i) {
        return m10107i(i) + getPageLeftShadowWidth();
    }

    /* renamed from: g */
    private int m10101g(int i) {
        return m10113l(i) - getPageBottomShadowHeight();
    }

    /* renamed from: h */
    private int m10105h(int i) {
        return m10109j(i) + getPageTopShadowHeight();
    }

    private int getPageLeftShadowWidth() {
        if (m10028p() || this.f6850c == null) {
            return 0;
        }
        return this.f6850c.getIntrinsicWidth();
    }

    private int getPageRightShadowWidth() {
        if (m10028p() || this.f6851d == null) {
            return 0;
        }
        return this.f6851d.getIntrinsicWidth();
    }

    private int getPageTopShadowHeight() {
        return 0;
    }

    private int getPageBottomShadowHeight() {
        return 0;
    }

    /* renamed from: i */
    private int m10107i(int i) {
        return getCellsView().mo445a(m10117n(i));
    }

    /* renamed from: j */
    private int m10109j(int i) {
        return getCellsView().mo451b(m10117n(i));
    }

    /* renamed from: k */
    private int m10111k(int i) {
        return getCellsView().mo453d(m10117n(i));
    }

    /* renamed from: l */
    private int m10113l(int i) {
        return getCellsView().mo454e(m10117n(i));
    }

    /* renamed from: m */
    private int m10115m(int i) {
        return this.f6849b.keyAt(this.f6849b.indexOfValue(i));
    }

    /* renamed from: n */
    private int m10117n(int i) {
        C0328a c = C0328a.m757c();
        boolean z = i >= this.f6852e && i <= this.f6853f;
        c.m764b(z);
        return this.f6849b.get(i);
    }
}
