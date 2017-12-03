package com.duokan.reader.ui.reading;

import android.content.Context;
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
import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.bb;
import com.duokan.reader.domain.document.n;
import com.duokan.reader.ui.general.FixedPagesView;
import com.duokan.reader.ui.general.el;
import com.duokan.reader.ui.general.hl;

import org.apache.http.HttpStatus;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class fi extends FixedPagesView implements gy {
    private final Rect b;
    private n c;
    private bb d;
    private bb e;
    private a[] f;
    private final Drawable[] g;
    private Drawable h;
    private boolean i;
    private Map j;

    public fi(Context context) {
        this(context, null);
    }

    public fi(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new Rect();
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.h = null;
        this.i = true;
        setAdapter(new fk());
        this.g = new Drawable[DecorDrawableStyle.values().length];
        this.g[DecorDrawableStyle.BOOK_MARK.ordinal()] = getResources().getDrawable(e.reading__shared__bookmark_highlight);
        this.g[DecorDrawableStyle.SELECTION_INDICATOR_START.ordinal()] = getResources().getDrawable(e.reading__shared__selection_indicator_start);
        this.g[DecorDrawableStyle.SELECTION_INDICATOR_END.ordinal()] = getResources().getDrawable(e.reading__shared__selection_indicator_end);
        Drawable hlVar = new hl();
        hlVar.a(Color.argb(64, HttpStatus.SC_NO_CONTENT, 51, 0));
        this.g[DecorDrawableStyle.SELECTION_HIGHLIGHT_RECT.ordinal()] = hlVar;
        el elVar = new el();
        elVar.a(Color.argb(64, HttpStatus.SC_NO_CONTENT, 51, 0));
        this.g[DecorDrawableStyle.SELECTION_HIGHLIGHT_LINE.ordinal()] = elVar;
        this.g[DecorDrawableStyle.MEDIA_PLAY.ordinal()] = context.getResources().getDrawable(e.reading__shared__media_play);
        hl hlVar2 = new hl();
        hlVar2.a(Color.argb(64, 51, 51, HttpStatus.SC_NO_CONTENT));
        this.g[DecorDrawableStyle.AUDIO_TEXT_HIGHLIGHT.ordinal()] = hlVar2;
        this.h = hlVar;
    }

    public n getDocument() {
        return this.c;
    }

    public void setCouplePageMode(boolean z) {
    }

    public bb getSelection() {
        return this.d;
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
        this.d = bbVar;
        c(false);
    }

    public bb getActiveText() {
        return this.e;
    }

    public void setActiveColorText(bb bbVar) {
        this.e = bbVar;
        c(false);
    }

    public final void a(n nVar, Document_a aVar) {
        this.c = nVar;
        if (this.c != null) {
            this.d = this.c.s();
            a(aVar);
            return;
        }
        View[] pageViews = getPageViews();
        for (View view : pageViews) {
            ((gs) view).setPage(null);
        }
        setCurrentPageIndicator(null);
        setCurrentPagePresenter(null);
        getProxyAdapter().a().d();
    }

    public void setAnnotations(a[] aVarArr) {
        this.f = aVarArr;
        c(false);
    }

    public a[] getAnnotations() {
        return this.f;
    }

    public final void a(Document_a aVar) {
        b(b(aVar));
    }

    public boolean q() {
        return getCellsView().getScrollState() != ScrollState.IDLE;
    }

    public Rect getViewableBounds() {
        this.b.set(0, 0, getWidth(), getHeight());
        if (this.c != null) {
            Rect a = this.c.k().a();
            Rect rect = this.b;
            rect.left += a.left;
            rect = this.b;
            rect.top += a.top;
            rect = this.b;
            rect.right -= a.right;
            rect = this.b;
            rect.bottom -= a.bottom;
        }
        return this.b;
    }

    public bb b(int i, int i2) {
        View view = (gs) a(i, i2);
        if (view == null) {
            return this.c.s();
        }
        Point point = new Point(i, i2);
        UTools.getTouchPoint(point, (View) this, view);
        return view.i() ? view.getPageDrawable().b(point) : this.c.s();
    }

    public bb b(int i, int i2, int i3, int i4) {
        View[] a = a(Math.min(i, i3), Math.min(i2, i4), Math.max(i, i3), Math.max(i2, i4));
        bb s = this.c.s();
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
        return null;
    }

    public Pair a(Point point, int i) {
        return null;
    }

    public Pair c(Point point) {
        return null;
    }

    public int a(bb bbVar) {
        return -1;
    }

    public ac a(int i) {
        return null;
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
        return this.g[decorDrawableStyle.ordinal()];
    }

    public Drawable getSelectionDrawable() {
        return this.h == null ? a(DecorDrawableStyle.SELECTION_HIGHLIGHT_RECT) : this.h;
    }

    public void setSelectionDrawable(Drawable drawable) {
        this.h = drawable;
    }

    public void setShowSelectionIndicators(boolean z) {
        this.i = z;
    }

    public boolean s() {
        return this.i;
    }

    public boolean c(int i, int i2) {
        return i2 < UTools.closeAnimation(getContext(), 50.0f);
    }

    public boolean d(int i, int i2) {
        return i2 > getHeight() - UTools.closeAnimation(getContext(), 50.0f);
    }

    public void d(bb bbVar) {
        if (bbVar != null && !bbVar.f()) {
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
            a(new fj(this, bbVar));
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
            as pageDrawable;
            if (this.c.j()) {
                if (z) {
                    ((sh) MyContextWrapper.getFeature(getContext()).queryFeature(sh.class)).aM();
                }
                pageViews = getPageViews();
                while (i < pageViews.length) {
                    pageDrawable = ((gs) pageViews[i]).getPageDrawable();
                    if (pageDrawable != null) {
                        this.c.d(pageDrawable.l());
                        pageDrawable.H();
                    }
                    i++;
                }
                getProxyAdapter().a().d();
            } else if (((gs) getCurrentPagePresenter().d()).getPageDrawable().q() != this.c.l()) {
                if (z) {
                    ((sh) MyContextWrapper.getFeature(getContext()).queryFeature(sh.class)).aM();
                }
                pageViews = getPageViews();
                while (i < pageViews.length) {
                    gs gsVar = (gs) pageViews[i];
                    as pageDrawable2 = gsVar.getPageDrawable();
                    gsVar.setRenderParams(this.c.l());
                    if (pageDrawable2 != null) {
                        pageDrawable2.invalidateSelf();
                    }
                    i++;
                }
            } else {
                pageViews = getPageViews();
                while (i < pageViews.length) {
                    pageDrawable = ((gs) pageViews[i]).getPageDrawable();
                    if (pageDrawable != null) {
                        pageDrawable.invalidateSelf();
                    }
                    i++;
                }
            }
        }
    }

    protected fm b(Document_a aVar) {
        return new fm(this, aVar);
    }

    protected as a(fm fmVar) {
        return this.c.a(fmVar.b());
    }
}
