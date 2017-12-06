package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;

import com.duokan.core.app.MyContextWrapper;
import com.duokan.core.ui.UTools;
import com.duokan.reader.domain.bookshelf.a;
import com.duokan.reader.domain.document.Document_a;
import com.duokan.reader.domain.document.ac;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.bb;
import com.duokan.reader.domain.document.n;
import com.duokan.reader.ui.general.FlowPagesView;
import com.duokan.reader.ui.general.el;
import com.duokan.reader.ui.general.hl;

import org.apache.http.HttpStatus;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class fo extends FlowPagesView implements gy {
    private final Rect a;
    private n b;
    private bb c;
    private bb d;
    private a[] e;
    private final Drawable[] f;
    private Drawable g;
    private boolean h;
    private boolean i;
    private Map j;
    private int k;
    private boolean l;

    public fo(Context context) {
        this(context, null);
    }

    public fo(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new Rect();
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.g = null;
        this.h = false;
        this.i = true;
        this.k = 0;
        this.l = true;
        setAdapter(new fq(this));
        this.f = new Drawable[DecorDrawableStyle.values().length];
        this.f[DecorDrawableStyle.BOOK_MARK.ordinal()] = getResources().getDrawable(e.reading__shared__bookmark_highlight);
        this.f[DecorDrawableStyle.SELECTION_INDICATOR_START.ordinal()] = getResources().getDrawable(e.reading__shared__selection_indicator_start);
        this.f[DecorDrawableStyle.SELECTION_INDICATOR_END.ordinal()] = getResources().getDrawable(e.reading__shared__selection_indicator_end);
        Drawable hlVar = new hl();
        hlVar.a(Color.argb(64, HttpStatus.SC_NO_CONTENT, 51, 0));
        this.f[DecorDrawableStyle.SELECTION_HIGHLIGHT_RECT.ordinal()] = hlVar;
        el elVar = new el();
        elVar.a(Color.argb(64, HttpStatus.SC_NO_CONTENT, 51, 0));
        this.f[DecorDrawableStyle.SELECTION_HIGHLIGHT_LINE.ordinal()] = elVar;
        this.f[DecorDrawableStyle.MEDIA_PLAY.ordinal()] = context.getResources().getDrawable(e.reading__shared__media_play);
        hl hlVar2 = new hl();
        hlVar2.a(Color.argb(64, 51, 51, HttpStatus.SC_NO_CONTENT));
        this.f[DecorDrawableStyle.AUDIO_TEXT_HIGHLIGHT.ordinal()] = hlVar2;
        this.g = hlVar;
        setWillNotDraw(false);
    }

    public void e(boolean z) {
        if (this.l != z) {
            this.l = z;
            invalidate();
        }
    }

    public void draw(Canvas canvas) {
        if (this.l) {
            super.draw(canvas);
        }
    }

    public n getDocument() {
        return this.b;
    }

    public boolean t() {
        return this.h;
    }

    public void setCouplePageMode(boolean z) {
        this.h = z;
    }

    public bb getSelection() {
        return this.c;
    }

    public Rect getSelectionStartIndicatorBounds() {
        View[] pageViews = getPageViews();
        for (View view : pageViews) {
            View view2 = (gs) view2;
            if (view2.i()) {
                Rect selectionStartIndicatorBounds = view2.getSelectionStartIndicatorBounds();
                if (!selectionStartIndicatorBounds.isEmpty()) {
                    UTools.closeAnimation(selectionStartIndicatorBounds, view2, (View) this);
                    return selectionStartIndicatorBounds;
                }
            }
        }
        return new Rect();
    }

    public Rect getSelectionEndIndicatorBounds() {
        View[] pageViews = getPageViews();
        for (View view : pageViews) {
            View view2 = (gs) view2;
            if (view2.i()) {
                Rect selectionEndIndicatorBounds = view2.getSelectionEndIndicatorBounds();
                if (!selectionEndIndicatorBounds.isEmpty()) {
                    UTools.closeAnimation(selectionEndIndicatorBounds, view2, (View) this);
                    return selectionEndIndicatorBounds;
                }
            }
        }
        return new Rect();
    }

    public void setSelection(bb bbVar) {
        this.c = bbVar;
        c(false);
    }

    public bb getActiveText() {
        return this.d;
    }

    public void setActiveColorText(bb bbVar) {
        this.d = bbVar;
        c(false);
    }

    public final void a(n nVar, Document_a aVar) {
        this.b = nVar;
        if (this.b != null) {
            this.c = this.b.s();
            a(aVar);
            return;
        }
        View[] pageViews = getPageViews();
        for (View view : pageViews) {
            ((gs) view).setPage(null);
        }
        setCurrentPageIndicator(null);
        setCurrentPagePresenter(null);
        getProxyAdapter().b().d();
    }

    public void setAnnotations(a[] aVarArr) {
        this.e = aVarArr;
        c(false);
    }

    public a[] getAnnotations() {
        return this.e;
    }

    public void a(Document_a aVar) {
        b(b(aVar));
    }

    public boolean q() {
        return getCellsView().getScrollState() != ScrollState.IDLE;
    }

    public Rect getViewableBounds() {
        this.a.set(0, 0, getWidth(), getHeight());
        if (this.b != null) {
            Rect a = this.b.k().a();
            Rect rect = this.a;
            rect.left += a.left;
            rect = this.a;
            rect.top += a.top;
            rect = this.a;
            rect.right -= a.right;
            rect = this.a;
            rect.bottom -= a.bottom;
        }
        return this.a;
    }

    public bb b(int i, int i2) {
        View view = (gs) a(i, i2);
        if (view == null) {
            return this.b.s();
        }
        Point point = new Point(i, i2);
        UTools.getTouchPoint(point, (View) this, view);
        return view.i() ? view.getPageDrawable().b(point) : this.b.s();
    }

    public bb b(int i, int i2, int i3, int i4) {
        View[] a = a(Math.min(i, i3), Math.min(i2, i4), Math.max(i, i3), Math.max(i2, i4));
        bb s = this.b.s();
        for (View view : a) {
            View view2 = (gs) view2;
            if (!view2.i()) {
                break;
            }
            Point point = new Point(i, i2);
            Point point2 = new Point(i3, i4);
            UTools.getTouchPoint(point, (View) this, view2);
            UTools.getTouchPoint(point2, (View) this, view2);
            s = s.a(view2.getPageDrawable().a(point, point2));
        }
        return s;
    }

    public bb r() {
        Rect viewableBounds = getViewableBounds();
        return b(viewableBounds.left, viewableBounds.top, viewableBounds.right, viewableBounds.bottom);
    }

    public Pair b(Point point) {
        View view = (gs) a(point.x, point.y);
        if (view == null) {
            return null;
        }
        Point point2 = new Point(point);
        UTools.getTouchPoint(point2, (View) this, view);
        int d = view.i() ? view.getPageDrawable().d(point2) : -1;
        return d < 0 ? null : new Pair(view, Integer.valueOf(d));
    }

    public Pair a(Point point, int i) {
        View view = (gs) a(point.x, point.y);
        if (view == null) {
            return null;
        }
        Point point2 = new Point(point);
        UTools.getTouchPoint(point2, (View) this, view);
        int a = view.i() ? view.getPageDrawable().a(point2, i) : -1;
        return a < 0 ? null : new Pair(view, Integer.valueOf(a));
    }

    public Pair c(Point point) {
        View view = (gs) a(point.x, point.y);
        if (view == null) {
            return null;
        }
        Point point2 = new Point(point);
        UTools.getTouchPoint(point2, (View) this, view);
        int g = view.i() ? view.getPageDrawable().g(point2) : -1;
        return g < 0 ? null : new Pair(view, Integer.valueOf(g));
    }

    public int a(bb bbVar) {
        if (getCurrentPagePresenter() == null) {
            return -1;
        }
        gs gsVar = (gs) getCurrentPagePresenter().d();
        return gsVar.i() ? gsVar.getPageDrawable().a(bbVar) : -1;
    }

    public ac a(int i) {
        if (getCurrentPagePresenter() == null) {
            return null;
        }
        gs gsVar = (gs) getCurrentPagePresenter().d();
        return gsVar.i() ? gsVar.getPageDrawable().k(i) : null;
    }

    public Rect[] b(bb bbVar) {
        View[] pageViews = getPageViews();
        LinkedList linkedList = new LinkedList();
        for (View view : pageViews) {
            View view2 = (gs) view2;
            if (view2.i()) {
                Rect[] e = view2.getPageDrawable().e(bbVar);
                UTools.addAnimation(e, view2, (View) this);
                linkedList.addAll(Arrays.asList(e));
            }
        }
        return (Rect[]) linkedList.toArray(new Rect[0]);
    }

    public Rect c(bb bbVar) {
        Rect rect = new Rect();
        for (Rect union : b(bbVar)) {
            rect.union(union);
        }
        return rect;
    }

    public Drawable a(DecorDrawableStyle decorDrawableStyle) {
        return this.f[decorDrawableStyle.ordinal()];
    }

    public Drawable getSelectionDrawable() {
        return this.g == null ? a(DecorDrawableStyle.SELECTION_HIGHLIGHT_RECT) : this.g;
    }

    public void setSelectionDrawable(Drawable drawable) {
        this.g = drawable;
    }

    public void setShowSelectionIndicators(boolean z) {
        this.i = z;
    }

    public boolean s() {
        return this.i;
    }

    public boolean c(int i, int i2) {
        boolean z = true;
        int b = UTools.getMinimumHeight(getContext(), 50.0f);
        if (p()) {
            boolean z2;
            if (i2 < b) {
                z2 = true;
            } else {
                z2 = false;
            }
            return z2;
        } else if ((i > b && i < getWidth() - b) || getCurrentPagePresenter() == null) {
            return false;
        } else {
            gs gsVar = (gs) getCurrentPagePresenter().d();
            if (!gsVar.i()) {
                return false;
            }
            bb m = gsVar.getPageDrawable().m();
            if (m == null || m.f()) {
                return false;
            }
            Rect[] b2 = b(m);
            if (b2 == null || b2.length < 1) {
                return false;
            }
            PageLayout pageLayout = getPageLayout();
            Rect rect = b2[0];
            if (pageLayout == PageLayout.LEFT_TO_RIGHT) {
                if (b2 == null || b2.length <= 0) {
                    return false;
                }
                if (i >= rect.left + (rect.height() / 2) || i2 >= rect.bottom + (rect.height() / 2)) {
                    z = false;
                }
                return z;
            } else if (pageLayout != PageLayout.RIGHT_TO_LEFT) {
                return false;
            } else {
                if (i <= rect.right - (rect.width() / 2) || i2 >= rect.top - (rect.width() / 2)) {
                    z = false;
                }
                return z;
            }
        }
    }

    public boolean d(int i, int i2) {
        boolean z = true;
        int b = UTools.getMinimumHeight(getContext(), 50.0f);
        if (p()) {
            boolean z2;
            if (i2 > getHeight() - b) {
                z2 = true;
            } else {
                z2 = false;
            }
            return z2;
        } else if ((i > b && i < getWidth() - b) || getCurrentPagePresenter() == null) {
            return false;
        } else {
            gs gsVar = (gs) getCurrentPagePresenter().d();
            if (!gsVar.i()) {
                return false;
            }
            bb m = gsVar.getPageDrawable().m();
            if (m == null || m.f()) {
                return false;
            }
            PageLayout pageLayout = getPageLayout();
            Rect[] b2 = b(m);
            if (b2 == null || b2.length < 1) {
                return false;
            }
            Rect rect = b2[b2.length - 1];
            if (pageLayout == PageLayout.LEFT_TO_RIGHT) {
                if (b2 == null || b2.length <= 0) {
                    return false;
                }
                if (i <= rect.right - (rect.height() / 2) || i2 <= rect.top - (rect.height() / 2)) {
                    z = false;
                }
                return z;
            } else if (pageLayout != PageLayout.RIGHT_TO_LEFT) {
                return false;
            } else {
                if (i >= rect.left + (rect.width() / 2) || i2 <= rect.bottom + (rect.width() / 2)) {
                    z = false;
                }
                return z;
            }
        }
    }

    public void d(bb bbVar) {
        boolean z = false;
        if (bbVar != null && !bbVar.f()) {
            if (o()) {
                gn gnVar = (gn) getCurrentPagePresenter();
                if (gnVar == null) {
                    a(bbVar.g());
                    gnVar = (gn) getCurrentPagePresenter();
                }
                Document_a g = gnVar.g();
                if (!g.a(bbVar.h()) && !g.h().equals(bbVar.h())) {
                    View[] pageViews = getPageViews();
                    int length = pageViews.length;
                    int i = 0;
                    boolean z2 = false;
                    while (i < length) {
                        boolean a;
                        ak l = ((gs) pageViews[i]).getPageDrawable().l();
                        if (l.a(bbVar.h()) || l.h().equals(bbVar.h())) {
                            z = l.c(g);
                            a = l.a(g);
                        } else {
                            a = z;
                            z = z2;
                        }
                        i++;
                        z2 = z;
                        z = a;
                    }
                    if (z2) {
                        b(null, null);
                        return;
                    } else if (z) {
                        a(null, null);
                        return;
                    } else {
                        a(bbVar.g());
                        return;
                    }
                }
                return;
            }
            Rect[] b = b(bbVar);
            if (b.length > 0) {
                Rect rect = new Rect();
                for (Rect union : b) {
                    rect.union(union);
                }
                a(a(rect), getViewableBounds(), HttpStatus.SC_OK, null, null);
                return;
            }
            a(bbVar.g());
            a(new fp(this, bbVar));
        }
    }

    public void a(bb bbVar, DecorDrawableStyle decorDrawableStyle) {
        if (bbVar != null && !bbVar.f()) {
            if (this.j == null) {
                this.j = new HashMap();
            }
            Drawable a = a(decorDrawableStyle);
            List list = null;
            if (this.j.containsKey(a)) {
                list = (List) this.j.get(a);
            }
            if (list == null) {
                list = new LinkedList();
            }
            list.add(bbVar);
            this.j.put(a, list);
            c(false);
        }
    }

    public void b(bb bbVar, DecorDrawableStyle decorDrawableStyle) {
        if (this.j != null && bbVar != null) {
            Drawable a = a(decorDrawableStyle);
            if (a != null && this.j.containsKey(a)) {
                List<bb> list = (List) this.j.get(a);
                if (list != null) {
                    for (bb bbVar2 : list) {
                        if (bbVar2 == bbVar) {
                            list.remove(bbVar2);
                            c(false);
                            return;
                        }
                    }
                }
            }
        }
    }

    public Map getHighlights() {
        return this.j;
    }

    protected void b(boolean z) {
        int i = 0;
        if (getCurrentPagePresenter() != null) {
            View[] pageViews;
            gs gsVar;
            if (this.b.j()) {
                if (z) {
                    ((sh) MyContextWrapper.getFeature(getContext()).queryFeature(sh.class)).aM();
                }
                pageViews = getPageViews();
                while (i < pageViews.length) {
                    gsVar = (gs) pageViews[i];
                    as pageDrawable = gsVar.getPageDrawable();
                    gsVar.e();
                    if (pageDrawable != null) {
                        this.b.d(pageDrawable.l());
                    }
                    i++;
                }
                getProxyAdapter().b().d();
            } else if (((gs) getCurrentPagePresenter().d()).getPageDrawable().q() != this.b.l()) {
                if (z) {
                    ((sh) MyContextWrapper.getFeature(getContext()).queryFeature(sh.class)).aM();
                }
                pageViews = getPageViews();
                while (i < pageViews.length) {
                    gsVar = (gs) pageViews[i];
                    if (gsVar.getPageDrawable() != null) {
                        gsVar.setRenderParams(this.b.l());
                    }
                    i++;
                }
            } else {
                pageViews = getPageViews();
                while (i < pageViews.length) {
                    as pageDrawable2 = ((gs) pageViews[i]).getPageDrawable();
                    if (pageDrawable2 != null) {
                        pageDrawable2.invalidateSelf();
                    }
                    i++;
                }
            }
        }
    }

    protected void a() {
        View[] pageViews = getPageViews();
        for (View view : pageViews) {
            gs gsVar = (gs) view;
            as pageDrawable = gsVar.getPageDrawable();
            gsVar.e();
            if (pageDrawable != null) {
                this.b.d(pageDrawable.l());
            }
        }
        getProxyAdapter().b().d();
    }

    public void setPagesExtraColor(int i) {
        this.k = i;
        View[] pageViews = getPageViews();
        for (View view : pageViews) {
            ((gs) view).setStatusColor(this.k);
        }
    }

    protected fs b(Document_a aVar) {
        return new fs(this, aVar);
    }
}
