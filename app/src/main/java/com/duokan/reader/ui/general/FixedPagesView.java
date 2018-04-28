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
    /* renamed from: a */
    static final /* synthetic */ boolean f6836a = (!FixedPagesView.class.desiredAssertionStatus());
    /* renamed from: b */
    private final int f6837b;
    /* renamed from: c */
    private PageScaleType f6838c = PageScaleType.MATCH_WIDTH;
    /* renamed from: d */
    private boolean f6839d = false;
    /* renamed from: e */
    private int f6840e = 0;
    /* renamed from: f */
    private int f6841f = 0;
    /* renamed from: g */
    private int f6842g = 0;
    /* renamed from: h */
    private int f6843h = 0;
    /* renamed from: i */
    private cu[] f6844i = new cu[0];
    /* renamed from: j */
    private RectF[] f6845j = new RectF[0];
    /* renamed from: k */
    private int f6846k = -1;
    /* renamed from: l */
    private final Point f6847l = new Point();

    public enum PageScaleType {
        MATCH_WIDTH,
        MATCH_INSIDE
    }

    /* renamed from: d */
    protected /* synthetic */ ga mo1740d() {
        return m10070c();
    }

    /* renamed from: e */
    protected /* synthetic */ gd mo1741e() {
        return m10067b();
    }

    public FixedPagesView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f6837b = dv.m1932b(getContext(), 5.0f);
        this.f6842g = displayMetrics.widthPixels;
        this.f6843h = displayMetrics.heightPixels;
        setPageLayout(PageLayout.TOP_TO_BOTTOM);
        getCellsView().m1111a(displayMetrics.widthPixels / 2, displayMetrics.heightPixels / 2, displayMetrics.widthPixels / 2, displayMetrics.heightPixels);
        setZoomEnabled(true);
    }

    public final PageScaleType getPageScaleType() {
        return this.f6838c;
    }

    public final void setPageScaleType(PageScaleType pageScaleType) {
        Rect rect = null;
        if (this.f6838c != pageScaleType) {
            gb c;
            cu cuVar = (cu) getCurrentPagePresenter();
            if (cuVar != null) {
                c = cuVar.mo2327c();
                rect = cuVar.mo1762a();
            } else {
                c = null;
            }
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            this.f6838c = pageScaleType;
            if (this.f6838c == PageScaleType.MATCH_INSIDE) {
                setPageLayout(PageLayout.LEFT_TO_RIGHT);
                getCellsView().m1111a(displayMetrics.widthPixels, 0, displayMetrics.widthPixels, 0);
            } else {
                setPageLayout(PageLayout.TOP_TO_BOTTOM);
                getCellsView().m1111a(0, displayMetrics.heightPixels, 0, displayMetrics.heightPixels);
            }
            getCellsView().mo1757p();
            getCellsView().scrollBy(0, 0);
            if (cuVar != null) {
                m10006b(c);
                ((cu) getCurrentPagePresenter()).mo1763a(rect);
            }
        }
    }

    public final RectF[] getContentMargins() {
        return this.f6845j;
    }

    public final void setContentMargins(RectF[] rectFArr) {
        this.f6845j = rectFArr;
        if (this.f6839d) {
            getCellsView().mo1757p();
            getCellsView().scrollBy(0, 0);
        }
    }

    public final boolean getClipToContent() {
        return this.f6839d;
    }

    public final void setClipToContent(boolean z) {
        this.f6839d = z;
        getCellsView().mo1757p();
        getCellsView().scrollBy(0, 0);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        gb gbVar;
        Rect rect = null;
        cu cuVar = (cu) getCurrentPagePresenter();
        if (!z || cuVar == null) {
            gbVar = null;
        } else {
            gbVar = getCurrentPageIndicator();
            rect = cuVar.mo1762a();
        }
        super.onLayout(z, i, i2, i3, i4);
        if (z && cuVar != null) {
            m10006b(gbVar);
            getCurrentPagePresenter().mo1763a(rect);
        }
    }

    /* renamed from: a */
    protected void mo1736a(boolean z) {
        super.mo1736a(z);
        int[] visibleItemIndices = getCellsView().getVisibleItemIndices();
        if (visibleItemIndices.length >= 1) {
            int i = visibleItemIndices[(visibleItemIndices.length - 1) / 2];
            if (i >= 0 && i < this.f6844i.length && this.f6844i[i] != null) {
                setCurrentPageIndicator(this.f6844i[i].mo2327c());
                setCurrentPagePresenter(this.f6844i[i]);
            }
        }
    }

    /* renamed from: a */
    protected void mo1735a(gb gbVar) {
        setCurrentPageIndicator(gbVar);
        getProxyAdapter().m10415a().mo1691d();
        getCellsView().mo1758q();
        int a = getProxyAdapter().m10415a().mo2318a(gbVar);
        getCellsView().m1148i(a);
        if (getCurrentPageIndicator() != null) {
            if (this.f6844i[a] == null) {
                getCellsView().m1119a(a, true);
                getCellsView().m1141g(a);
                getCellsView().m1119a(a, false);
            }
            if (f6836a || this.f6844i[a] != null) {
                setCurrentPagePresenter(this.f6844i[a]);
                return;
            }
            throw new AssertionError();
        }
        setCurrentPagePresenter(null);
    }

    /* renamed from: a */
    protected void mo1737a(boolean z, Runnable runnable, Runnable runnable2) {
        if (getPageLayout() == PageLayout.TOP_TO_BOTTOM) {
            getCellsView().m1125b(0, getCellsView().getViewportBounds().height(), HttpStatus.SC_MULTIPLE_CHOICES, runnable, runnable2);
        } else if (getPageLayout() == PageLayout.LEFT_TO_RIGHT) {
            getCellsView().m1125b(getCellsView().getViewportBounds().width(), 0, HttpStatus.SC_MULTIPLE_CHOICES, runnable, runnable2);
        } else if (!f6836a) {
            throw new AssertionError();
        }
    }

    /* renamed from: b */
    protected void mo1739b(boolean z, Runnable runnable, Runnable runnable2) {
        if (getPageLayout() == PageLayout.TOP_TO_BOTTOM) {
            getCellsView().m1125b(0, -getCellsView().getViewportBounds().height(), HttpStatus.SC_MULTIPLE_CHOICES, runnable, runnable2);
        } else if (getPageLayout() == PageLayout.LEFT_TO_RIGHT) {
            getCellsView().m1125b(-getCellsView().getViewportBounds().width(), 0, HttpStatus.SC_MULTIPLE_CHOICES, runnable, runnable2);
        } else if (!f6836a) {
            throw new AssertionError();
        }
    }

    /* renamed from: b */
    protected void mo1738b(boolean z) {
    }

    /* renamed from: a */
    protected void mo1734a() {
    }

    /* renamed from: b */
    protected cv m10067b() {
        return new cv(this);
    }

    /* renamed from: c */
    protected cs m10070c() {
        return new cs(this, getContext());
    }

    protected cv getProxyAdapter() {
        return (cv) super.getProxyAdapter();
    }

    /* renamed from: a */
    private boolean mo2015a(int i) {
        if (i - 1 < 0) {
            return false;
        }
        Rect viewportBounds = getViewportBounds();
        if (viewportBounds.left < m10034a(i, viewportBounds.width(), viewportBounds.height()).left) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    private boolean m10043b(int i) {
        if (i + 1 >= getPageCount()) {
            return false;
        }
        Rect viewportBounds = getViewportBounds();
        if (viewportBounds.left > m10034a(i, viewportBounds.width(), viewportBounds.height()).right - viewportBounds.width()) {
            return true;
        }
        return false;
    }

    private int getCurrPageIndex() {
        if (getCurrentPageIndicator() == null || getProxyAdapter().m10415a() == null) {
            return -1;
        }
        return getProxyAdapter().m10415a().mo2318a(getCurrentPageIndicator());
    }

    /* renamed from: a */
    private Rect m10034a(int i, int i2, int i3) {
        Rect rect = new Rect(m10048c(i));
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

    /* renamed from: a */
    private RectF m10036a(int i, float f, float f2) {
        RectF rectF = new RectF(m10048c(i));
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

    /* renamed from: c */
    private Rect m10048c(int i) {
        return getCellsView().m1144h(i);
    }

    /* renamed from: b */
    private int m10040b(int i, float f, float f2) {
        return (int) ((((float) i) * f) * f2);
    }

    /* renamed from: c */
    private int m10045c(int i, float f, float f2) {
        return (int) ((((float) i) * f) * f2);
    }

    /* renamed from: a */
    private float m10029a(int i, int i2, int i3, int i4, PageScaleType pageScaleType) {
        switch (cq.f7042a[pageScaleType.ordinal()]) {
            case 1:
                return m10030a(i, i3, pageScaleType);
            default:
                return Math.min(m10030a(i, i3, pageScaleType), m10030a(i2, i4, pageScaleType));
        }
    }

    /* renamed from: a */
    private float m10030a(int i, int i2, PageScaleType pageScaleType) {
        return i2 == Integer.MAX_VALUE ? 1.0f : ((float) i2) / ((float) i);
    }
}
