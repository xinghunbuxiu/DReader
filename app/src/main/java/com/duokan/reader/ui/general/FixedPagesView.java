package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;

import com.duokan.core.ui.dv;
import com.duokan.reader.ui.general.PagesView.PageLayout;

import org.apache.http.HttpStatus;

public class FixedPagesView extends PagesView {
    static final /* synthetic */ boolean a = (!FixedPagesView.class.desiredAssertionStatus());
    private final int b;
    private PageScaleType c = PageScaleType.MATCH_WIDTH;
    private boolean d = false;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private cu[] i = new cu[0];
    private RectF[] j = new RectF[0];
    private int k = -1;
    private final Point l = new Point();

    public enum PageScaleType {
        MATCH_WIDTH,
        MATCH_INSIDE
    }

    protected /* synthetic */ gg d() {
        return c();
    }

    protected /* synthetic */ gj e() {
        return b();
    }

    public FixedPagesView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.b = dv.b(getContext(), 5.0f);
        this.g = displayMetrics.widthPixels;
        this.h = displayMetrics.heightPixels;
        setPageLayout(PageLayout.TOP_TO_BOTTOM);
        getCellsView().a(displayMetrics.widthPixels / 2, displayMetrics.heightPixels / 2, displayMetrics.widthPixels / 2, displayMetrics.heightPixels);
        setZoomEnabled(true);
    }

    public final PageScaleType getPageScaleType() {
        return this.c;
    }

    public final void setPageScaleType(PageScaleType pageScaleType) {
        Rect rect = null;
        if (this.c != pageScaleType) {
            gh c;
            cu cuVar = (cu) getCurrentPagePresenter();
            if (cuVar != null) {
                c = cuVar.c();
                rect = cuVar.a();
            } else {
                c = null;
            }
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            this.c = pageScaleType;
            if (this.c == PageScaleType.MATCH_INSIDE) {
                setPageLayout(PageLayout.LEFT_TO_RIGHT);
                getCellsView().a(displayMetrics.widthPixels, 0, displayMetrics.widthPixels, 0);
            } else {
                setPageLayout(PageLayout.TOP_TO_BOTTOM);
                getCellsView().a(0, displayMetrics.heightPixels, 0, displayMetrics.heightPixels);
            }
            getCellsView().p();
            getCellsView().scrollBy(0, 0);
            if (cuVar != null) {
                b(c);
                ((cu) getCurrentPagePresenter()).a(rect);
            }
        }
    }

    public final RectF[] getContentMargins() {
        return this.j;
    }

    public final void setContentMargins(RectF[] rectFArr) {
        this.j = rectFArr;
        if (this.d) {
            getCellsView().p();
            getCellsView().scrollBy(0, 0);
        }
    }

    public final boolean getClipToContent() {
        return this.d;
    }

    public final void setClipToContent(boolean z) {
        this.d = z;
        getCellsView().p();
        getCellsView().scrollBy(0, 0);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        gh ghVar;
        Rect rect = null;
        cu cuVar = (cu) getCurrentPagePresenter();
        if (!z || cuVar == null) {
            ghVar = null;
        } else {
            ghVar = getCurrentPageIndicator();
            rect = cuVar.a();
        }
        super.onLayout(z, i, i2, i3, i4);
        if (z && cuVar != null) {
            b(ghVar);
            getCurrentPagePresenter().a(rect);
        }
    }

    protected void a(boolean z) {
        super.a(z);
        int[] visibleItemIndices = getCellsView().getVisibleItemIndices();
        if (visibleItemIndices.length >= 1) {
            int i = visibleItemIndices[(visibleItemIndices.length - 1) / 2];
            if (i >= 0 && i < this.i.length && this.i[i] != null) {
                setCurrentPageIndicator(this.i[i].c());
                setCurrentPagePresenter(this.i[i]);
            }
        }
    }

    protected void a(gh ghVar) {
        setCurrentPageIndicator(ghVar);
        getProxyAdapter().a().d();
        getCellsView().q();
        int a = getProxyAdapter().a().a(ghVar);
        getCellsView().i(a);
        if (getCurrentPageIndicator() != null) {
            if (this.i[a] == null) {
                getCellsView().a(a, true);
                getCellsView().g(a);
                getCellsView().a(a, false);
            }
            if (a || this.i[a] != null) {
                setCurrentPagePresenter(this.i[a]);
                return;
            }
            throw new AssertionError();
        }
        setCurrentPagePresenter(null);
    }

    protected void a(boolean z, Runnable runnable, Runnable runnable2) {
        if (getPageLayout() == PageLayout.TOP_TO_BOTTOM) {
            getCellsView().b(0, getCellsView().getViewportBounds().height(), HttpStatus.SC_MULTIPLE_CHOICES, runnable, runnable2);
        } else if (getPageLayout() == PageLayout.LEFT_TO_RIGHT) {
            getCellsView().b(getCellsView().getViewportBounds().width(), 0, HttpStatus.SC_MULTIPLE_CHOICES, runnable, runnable2);
        } else if (!a) {
            throw new AssertionError();
        }
    }

    protected void b(boolean z, Runnable runnable, Runnable runnable2) {
        if (getPageLayout() == PageLayout.TOP_TO_BOTTOM) {
            getCellsView().b(0, -getCellsView().getViewportBounds().height(), HttpStatus.SC_MULTIPLE_CHOICES, runnable, runnable2);
        } else if (getPageLayout() == PageLayout.LEFT_TO_RIGHT) {
            getCellsView().b(-getCellsView().getViewportBounds().width(), 0, HttpStatus.SC_MULTIPLE_CHOICES, runnable, runnable2);
        } else if (!a) {
            throw new AssertionError();
        }
    }

    protected void b(boolean z) {
    }

    protected void a() {
    }

    protected cv b() {
        return new cv(this);
    }

    protected cs c() {
        return new cs(this, getContext());
    }

    protected cv getProxyAdapter() {
        return (cv) super.getProxyAdapter();
    }

    private boolean a(int i) {
        if (i - 1 < 0) {
            return false;
        }
        Rect viewportBounds = getViewportBounds();
        if (viewportBounds.left < a(i, viewportBounds.width(), viewportBounds.height()).left) {
            return true;
        }
        return false;
    }

    private boolean b(int i) {
        if (i + 1 >= getPageCount()) {
            return false;
        }
        Rect viewportBounds = getViewportBounds();
        if (viewportBounds.left > a(i, viewportBounds.width(), viewportBounds.height()).right - viewportBounds.width()) {
            return true;
        }
        return false;
    }

    private int getCurrPageIndex() {
        if (getCurrentPageIndicator() == null || getProxyAdapter().a() == null) {
            return -1;
        }
        return getProxyAdapter().a().a(getCurrentPageIndicator());
    }

    private Rect a(int i, int i2, int i3) {
        Rect rect = new Rect(c(i));
        if (rect.width() < i2) {
            rect.left -= (i2 - rect.width()) / 2;
            rect.right = rect.left + i2;
        }
        if (rect.height() < i3) {
            rect.top -= (i3 - rect.height()) / 2;
            rect.bottom = rect.top + i3;
        }
        return rect;
    }

    private RectF a(int i, float f, float f2) {
        RectF rectF = new RectF(c(i));
        if (Float.compare(rectF.width(), f) < 0) {
            rectF.inset((-(f - rectF.width())) / 2.0f, 0.0f);
        }
        if (Float.compare(rectF.height(), f2) < 0) {
            rectF.inset(0.0f, (-(f2 - rectF.height())) / 2.0f);
        }
        return rectF;
    }

    private int getPageCount() {
        return getCellsView().getItemCount();
    }

    private Rect c(int i) {
        return getCellsView().h(i);
    }

    private int b(int i, float f, float f2) {
        return (int) ((((float) i) * f) * f2);
    }

    private int c(int i, float f, float f2) {
        return (int) ((((float) i) * f) * f2);
    }

    private float a(int i, int i2, int i3, int i4, PageScaleType pageScaleType) {
        switch (cq.a[pageScaleType.ordinal()]) {
            case 1:
                return a(i, i3, pageScaleType);
            default:
                return Math.min(a(i, i3, pageScaleType), a(i2, i4, pageScaleType));
        }
    }

    private float a(int i, int i2, PageScaleType pageScaleType) {
        return i2 == Integer.MAX_VALUE ? 1.0f : ((float) i2) / ((float) i);
    }
}
