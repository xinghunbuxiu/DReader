package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseIntArray;

import com.duokan.core.diagnostic.a;
import com.duokan.core.sys.TaskHandler;
import com.duokan.core.ui.UTools;

import org.apache.http.HttpStatus;

import java.util.ArrayList;

public class FlowPagesView extends PagesView {
    private final ArrayList a = new ArrayList(3);
    private final SparseIntArray b = new SparseIntArray();
    private Drawable c = null;
    private Drawable d = null;
    private int e = -1;
    private int f = 1;
    private int g = 0;
    private int h = 0;
    private int i = 0;
    private int j = 0;
    private FlipEffect k = FlipEffect.SCROLL;
    private df l = null;

    public enum FlipEffect {
        NONE,
        SCROLL,
        OVERLAP,
        FADE_IN
    }

    protected /* synthetic */ gg d() {
        return c();
    }

    protected /* synthetic */ gj e() {
        return b();
    }

    public FlowPagesView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a.add(null);
        this.a.add(null);
        this.a.add(null);
        this.b.put(0, 0);
        this.b.put(-1, 1);
        this.b.put(1, 2);
        this.e = -1;
        this.f = 1;
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        getCellsView().a(displayMetrics.widthPixels / 2, displayMetrics.heightPixels / 2, displayMetrics.widthPixels / 2, displayMetrics.heightPixels * 2);
    }

    public final FlipEffect getFlipEffect() {
        return this.k;
    }

    public final void setFlipEffect(FlipEffect flipEffect) {
        this.k = flipEffect;
    }

    public final void setPageLeftShadow(int i) {
        setPageLeftShadow(getResources().getDrawable(i));
    }

    public final void setPageLeftShadow(Drawable drawable) {
        this.c = drawable;
        getCellsView().p();
    }

    public final void setPageRightShadow(int i) {
        setPageRightShadow(getResources().getDrawable(i));
    }

    public final void setPageRightShadow(Drawable drawable) {
        this.d = drawable;
        getCellsView().p();
    }

    protected void a(gh ghVar) {
        boolean z = true;
        setCurrentPageIndicator(ghVar);
        getProxyAdapter().b().d();
        getCellsView().q();
        int n = n(0);
        if (getCurrentPageIndicator() != null) {
            if (this.a.get(n) == null) {
                getCellsView().a(n, true);
                getCellsView().g(n);
                getCellsView().a(n, false);
            }
            a c = a.c();
            if (this.a.get(n) == null) {
                z = false;
            }
            c.b(z);
            setCurrentPagePresenter((gi) this.a.get(n));
            getCellsView().b(n, new Rect(0, 0, getWidth(), getHeight()), 51);
            return;
        }
        setCurrentPagePresenter(null);
    }

    protected void a(boolean z, Runnable runnable, Runnable runnable2) {
        df dfVar = (df) getCurrentPagePresenter();
        if (dfVar == null) {
            return;
        }
        if (dfVar.f() || dfVar.e()) {
            db dbVar = (db) getAdapter();
            if (dbVar != null && dbVar.b(dfVar)) {
                l();
                if (runnable2 != null) {
                    runnable2.run();
                }
            } else if (o()) {
                if (!z) {
                    if (n()) {
                        getCellsView().scrollBy(-this.i, 0);
                    } else {
                        getCellsView().scrollBy(this.i, 0);
                    }
                    TaskHandler.postTask(runnable);
                } else if (n()) {
                    getCellsView().b(-this.i, 0, HttpStatus.SC_MULTIPLE_CHOICES, runnable, runnable2);
                } else {
                    getCellsView().b(this.i, 0, HttpStatus.SC_MULTIPLE_CHOICES, runnable, runnable2);
                }
            } else if (z) {
                getCellsView().b(0, this.j / 2, HttpStatus.SC_MULTIPLE_CHOICES, runnable, runnable2);
            } else {
                getCellsView().scrollBy(0, this.j / 2);
                TaskHandler.postTask(runnable);
            }
        }
    }

    protected void b(boolean z, Runnable runnable, Runnable runnable2) {
        df dfVar = (df) getCurrentPagePresenter();
        if (dfVar == null) {
            return;
        }
        if (dfVar.f() || dfVar.e()) {
            db dbVar = (db) getAdapter();
            if (dbVar != null && dbVar.a(dfVar)) {
                k();
                if (runnable2 != null) {
                    runnable2.run();
                }
            } else if (o()) {
                if (!z) {
                    if (n()) {
                        getCellsView().scrollBy(this.i, 0);
                    } else {
                        getCellsView().scrollBy(-this.i, 0);
                    }
                    TaskHandler.postTask(runnable);
                } else if (n()) {
                    getCellsView().b(this.i, 0, HttpStatus.SC_MULTIPLE_CHOICES, runnable, runnable2);
                } else {
                    getCellsView().b(-this.i, 0, HttpStatus.SC_MULTIPLE_CHOICES, runnable, runnable2);
                }
            } else if (z) {
                getCellsView().b(0, (-this.j) / 2, HttpStatus.SC_MULTIPLE_CHOICES, runnable, runnable2);
            } else {
                getCellsView().scrollBy(0, (-this.j) / 2);
                TaskHandler.postTask(runnable);
            }
        }
    }

    protected void b(boolean z) {
    }

    protected void a() {
    }

    protected dg b() {
        return new dg();
    }

    protected dc c() {
        return new dc(this, getContext());
    }

    protected int getMinPageOffset() {
        return this.e;
    }

    protected int getMaxPageOffset() {
        return this.f;
    }

    protected int b_(int i) {
        return m(i);
    }

    protected int b(int i) {
        return n(i);
    }

    private void q() {
        Rect viewportBounds = getViewportBounds();
        int i;
        if (o()) {
            i = this.e;
            while (i <= this.f) {
                if (i < -1 || i > 1) {
                    int n = n(i);
                    getCellsView().b(n, 0, 0);
                    getCellsView().a(n, 1.0f);
                }
                i++;
            }
            if (this.k == FlipEffect.OVERLAP) {
                if (d(viewportBounds)) {
                    getCellsView().b(n(1), viewportBounds.left - f(1), 0);
                    getCellsView().b(n(0), 0, 0);
                    getCellsView().b(n(-1), 0, 0);
                    return;
                } else if (c(viewportBounds)) {
                    getCellsView().b(n(0), viewportBounds.left - f(0), 0);
                    getCellsView().b(n(1), 0, 0);
                    getCellsView().b(n(-1), 0, 0);
                    return;
                } else {
                    getCellsView().b(n(-1), 0, 0);
                    getCellsView().b(n(0), 0, 0);
                    getCellsView().b(n(1), 0, 0);
                    return;
                }
            } else if (this.k != FlipEffect.FADE_IN) {
                getCellsView().b(n(0), 0, 0);
                getCellsView().a(n(0), 1.0f);
                getCellsView().b(n(-1), 0, 0);
                getCellsView().a(n(-1), 1.0f);
                getCellsView().b(n(1), 0, 0);
                getCellsView().a(n(1), 1.0f);
                return;
            } else if (d(viewportBounds)) {
                i = viewportBounds.left - f(0);
                getCellsView().b(n(0), i, 0);
                getCellsView().a(n(0), 1.0f - (((float) Math.abs(i)) / ((float) this.i)));
                getCellsView().b(n(1), viewportBounds.left - f(1), 0);
                getCellsView().a(n(1), 1.0f);
                getCellsView().b(n(-1), 0, 0);
                getCellsView().a(n(-1), 1.0f);
                return;
            } else if (c(viewportBounds)) {
                getCellsView().b(n(0), viewportBounds.left - f(0), 0);
                getCellsView().a(n(0), 1.0f);
                i = viewportBounds.left - f(-1);
                getCellsView().b(n(-1), i, 0);
                getCellsView().a(n(-1), 1.0f - (((float) Math.abs(i)) / ((float) this.i)));
                getCellsView().b(n(1), 0, 0);
                getCellsView().a(n(1), 1.0f);
                return;
            } else {
                getCellsView().b(n(0), 0, 0);
                getCellsView().a(n(0), 1.0f);
                getCellsView().b(n(-1), 0, 0);
                getCellsView().a(n(-1), 1.0f);
                getCellsView().b(n(1), 0, 0);
                getCellsView().a(n(1), 1.0f);
                return;
            }
        }
        for (i = this.e; i <= this.f; i++) {
            int n2 = n(i);
            getCellsView().b(n2, 0, 0);
            getCellsView().a(n2, 1.0f);
        }
    }

    private boolean b(Rect rect) {
        df dfVar = (df) getCurrentPagePresenter();
        if (dfVar != null && dfVar.e()) {
            Rect rect2 = (Rect) UTools.g.getRect();
            int i = this.e;
            while (i <= this.f) {
                a(rect2, i);
                if (Rect.intersects(rect2, rect)) {
                    break;
                }
                i++;
            }
            UTools.g.getRect(rect2);
            if (i != 0) {
                int i2;
                if (i > 0 && !getAdapter().b(dfVar)) {
                    for (i2 = 0; i2 < Math.abs(i); i2++) {
                        r();
                    }
                } else if (i < 0 && !getAdapter().a(dfVar)) {
                    for (i2 = 0; i2 < Math.abs(i); i2++) {
                        s();
                    }
                }
            }
        }
        return false;
    }

    private void r() {
        boolean z = false;
        int n = n(this.e);
        for (int i = this.e; i < this.f; i++) {
            this.b.put(i, n(i + 1));
        }
        this.b.put(this.f, n);
        this.g = i(0);
        this.h = j(0);
        df dfVar = (df) this.a.get(n(0));
        a c = a.c();
        if (dfVar != null) {
            z = true;
        }
        c.b(z);
        setCurrentPageIndicator(dfVar.c());
        setCurrentPagePresenter(dfVar);
        getCellsView().o();
        getProxyAdapter().b().h(n, 1);
    }

    private void s() {
        boolean z = false;
        int n = n(this.f);
        for (int i = this.f; i > this.e; i--) {
            this.b.put(i, n(i - 1));
        }
        this.b.put(this.e, n);
        this.g = i(0);
        this.h = j(0);
        df dfVar = (df) this.a.get(n(0));
        a c = a.c();
        if (dfVar != null) {
            z = true;
        }
        c.b(z);
        setCurrentPageIndicator(dfVar.c());
        setCurrentPagePresenter(dfVar);
        getCellsView().o();
        getProxyAdapter().b().h(n, 1);
    }

    private boolean c(Rect rect) {
        boolean z = true;
        Rect rect2 = (Rect) UTools.g.getRect();
        rect2.set(f(0), h(0), e(0), g(0));
        if (o()) {
            if (n()) {
                if (rect.right <= rect2.right) {
                    z = false;
                }
            } else if (rect.left >= rect2.left) {
                z = false;
            }
        } else if (rect.top >= rect2.top) {
            z = false;
        }
        UTools.g.getRect(rect2);
        return z;
    }

    private boolean c(int i) {
        if (o()) {
            if (n()) {
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

    private boolean d(Rect rect) {
        boolean z = true;
        Rect rect2 = (Rect) UTools.g.getRect();
        rect2.set(f(0), h(0), e(0), g(0));
        if (o()) {
            if (n()) {
                if (rect.left >= rect2.left) {
                    z = false;
                }
            } else if (rect.right <= rect2.right) {
                z = false;
            }
        } else if (rect.bottom <= rect2.bottom) {
            z = false;
        }
        UTools.g.getRect(rect2);
        return z;
    }

    private boolean d(int i) {
        if (o()) {
            if (n()) {
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

    private void e(Rect rect) {
        if (getCurrentPagePresenter() != null && this.i >= 1 && this.j >= 1) {
            Rect rect2 = (Rect) UTools.g.getRect();
            g(rect2);
            if (rect2.isEmpty() || !Rect.intersects(rect2, rect)) {
                UTools.g.getRect(rect2);
            } else if (rect2.contains(rect)) {
                UTools.g.getRect(rect2);
            } else {
                while (true) {
                    int i;
                    Object obj;
                    a(rect2, this.e);
                    if (o()) {
                        if (n()) {
                            try {
                                if (rect.right > rect2.right) {
                                    i = 1;
                                } else {
                                    obj = null;
                                }
                            } catch (Throwable th) {
                                UTools.g.getRect(rect2);
                            }
                        } else {
                            obj = rect.left < rect2.left ? 1 : null;
                        }
                    } else if (rect.top < rect2.top) {
                        i = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        this.e--;
                        if (this.f <= 1 || Rect.intersects(a(rect2, this.f), rect)) {
                            this.a.add(null);
                            this.b.put(this.e, this.a.size() - 1);
                            getProxyAdapter().b().f(n(this.e), 1);
                        } else {
                            this.b.put(this.e, n(this.f));
                            this.b.delete(this.f);
                            this.f--;
                            getProxyAdapter().b().h(n(this.e), 1);
                        }
                    } else {
                        a(rect2, this.f);
                        if (o()) {
                            if (!n()) {
                                obj = rect.right > rect2.right ? 1 : null;
                            } else if (rect.left < rect2.left) {
                                i = 1;
                            } else {
                                obj = null;
                            }
                        } else if (rect.bottom > rect2.bottom) {
                            i = 1;
                        } else {
                            obj = null;
                        }
                        if (obj != null) {
                            this.f++;
                            if (this.e >= -1 || Rect.intersects(a(rect2, this.e), rect)) {
                                this.a.add(null);
                                this.b.put(this.f, this.a.size() - 1);
                                getProxyAdapter().b().f(n(this.f), 1);
                            } else {
                                this.b.put(this.f, n(this.e));
                                this.b.delete(this.e);
                                this.e++;
                                getProxyAdapter().b().h(n(this.f), 1);
                                getCellsView().o();
                            }
                        } else {
                            UTools.g.getRect(rect2);
                            return;
                        }
                    }
                }
            }
        }
    }

    private Rect f(Rect rect) {
        int i;
        Rect rect2 = (Rect) UTools.g.getRect();
        for (i = 0; i >= this.e; i--) {
            df dfVar = (df) this.a.get(n(i));
            if (dfVar != null) {
                rect.union(a(rect2, i));
                if (dfVar.e() && getProxyAdapter().b().a(dfVar)) {
                    break;
                }
            }
        }
        for (i = 0; i <= this.f; i++) {
            dfVar = (df) this.a.get(n(i));
            if (dfVar != null) {
                rect.union(a(rect2, i));
                if (dfVar.e() && getProxyAdapter().b().b(dfVar)) {
                    break;
                }
            }
        }
        UTools.g.getRect(rect2);
        if (o()) {
            rect.top = 0;
            rect.bottom = getContentHeight();
        } else {
            rect.left = 0;
            rect.right = getContentWidth();
        }
        return rect;
    }

    private Rect g(Rect rect) {
        Rect rect2 = (Rect) UTools.g.getRect();
        a(rect2, this.e);
        rect.set(rect2);
        a(rect2, this.f);
        rect.union(rect2);
        UTools.g.getRect(rect2);
        return rect;
    }

    private Rect a(Rect rect, int i) {
        rect.set(f(i), h(i), e(i), g(i));
        return rect;
    }

    private int e(int i) {
        return k(i) - getPageRightShadowWidth();
    }

    private int f(int i) {
        return i(i) + getPageLeftShadowWidth();
    }

    private int g(int i) {
        return l(i) - getPageBottomShadowHeight();
    }

    private int h(int i) {
        return j(i) + getPageTopShadowHeight();
    }

    private int getPageLeftShadowWidth() {
        if (p() || this.c == null) {
            return 0;
        }
        return this.c.getIntrinsicWidth();
    }

    private int getPageRightShadowWidth() {
        if (p() || this.d == null) {
            return 0;
        }
        return this.d.getIntrinsicWidth();
    }

    private int getPageTopShadowHeight() {
        return 0;
    }

    private int getPageBottomShadowHeight() {
        return 0;
    }

    private int i(int i) {
        return getCellsView().a(n(i));
    }

    private int j(int i) {
        return getCellsView().b(n(i));
    }

    private int k(int i) {
        return getCellsView().d(n(i));
    }

    private int l(int i) {
        return getCellsView().e(n(i));
    }

    private int m(int i) {
        return this.b.keyAt(this.b.indexOfValue(i));
    }

    private int n(int i) {
        a c = a.c();
        boolean z = i >= this.e && i <= this.f;
        c.b(z);
        return this.b.get(i);
    }
}
