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
import com.duokan.core.app.AppContext;
import com.duokan.core.ui.dv;
import com.duokan.p023b.C0243e;
import com.duokan.reader.domain.bookshelf.C0798a;
import com.duokan.reader.domain.document.C0896a;
import com.duokan.reader.domain.document.C0903n;
import com.duokan.reader.domain.document.ac;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.bb;
import com.duokan.reader.ui.general.FlowPagesView;
import com.duokan.reader.ui.general.ej;
import com.duokan.reader.ui.general.ha;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpStatus;

public class fs extends FlowPagesView implements hd {
    /* renamed from: a */
    private final Rect f10173a;
    /* renamed from: b */
    private C0903n f10174b;
    /* renamed from: c */
    private bb f10175c;
    /* renamed from: d */
    private bb f10176d;
    /* renamed from: e */
    private C0798a[] f10177e;
    /* renamed from: f */
    private final Drawable[] f10178f;
    /* renamed from: g */
    private Drawable f10179g;
    /* renamed from: h */
    private boolean f10180h;
    /* renamed from: i */
    private boolean f10181i;
    /* renamed from: j */
    private Map<Drawable, List<bb>> f10182j;
    /* renamed from: k */
    private int f10183k;
    /* renamed from: l */
    private boolean f10184l;

    public fs(Context context) {
        this(context, null);
    }

    public fs(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10173a = new Rect();
        this.f10174b = null;
        this.f10175c = null;
        this.f10176d = null;
        this.f10177e = null;
        this.f10179g = null;
        this.f10180h = false;
        this.f10181i = true;
        this.f10183k = 0;
        this.f10184l = true;
        setAdapter(new fv(this));
        this.f10178f = new Drawable[DecorDrawableStyle.values().length];
        this.f10178f[DecorDrawableStyle.BOOK_MARK.ordinal()] = getResources().getDrawable(C0243e.reading__shared__bookmark_highlight);
        this.f10178f[DecorDrawableStyle.SELECTION_INDICATOR_START.ordinal()] = getResources().getDrawable(C0243e.reading__shared__selection_indicator_start);
        this.f10178f[DecorDrawableStyle.SELECTION_INDICATOR_END.ordinal()] = getResources().getDrawable(C0243e.reading__shared__selection_indicator_end);
        Drawable haVar = new ha();
        haVar.m10738a(Color.argb(64, HttpStatus.SC_NO_CONTENT, 51, 0));
        this.f10178f[DecorDrawableStyle.SELECTION_HIGHLIGHT_RECT.ordinal()] = haVar;
        ej ejVar = new ej();
        ejVar.m10560a(Color.argb(64, HttpStatus.SC_NO_CONTENT, 51, 0));
        this.f10178f[DecorDrawableStyle.SELECTION_HIGHLIGHT_LINE.ordinal()] = ejVar;
        this.f10178f[DecorDrawableStyle.MEDIA_PLAY.ordinal()] = context.getResources().getDrawable(C0243e.reading__shared__media_play);
        ha haVar2 = new ha();
        haVar2.m10738a(Color.argb(64, 51, 51, HttpStatus.SC_NO_CONTENT));
        this.f10178f[DecorDrawableStyle.AUDIO_TEXT_HIGHLIGHT.ordinal()] = haVar2;
        this.f10179g = haVar;
        setWillNotDraw(false);
    }

    /* renamed from: e */
    public void m14139e(boolean z) {
        if (this.f10184l != z) {
            this.f10184l = z;
            invalidate();
        }
    }

    public void draw(Canvas canvas) {
        if (this.f10184l) {
            super.draw(canvas);
            m14114a(canvas);
        }
    }

    public C0903n getDocument() {
        return this.f10174b;
    }

    /* renamed from: t */
    public boolean m14143t() {
        return this.f10180h;
    }

    public void setCouplePageMode(boolean z) {
        this.f10180h = z;
    }

    public bb getSelection() {
        return this.f10175c;
    }

    public Rect getSelectionStartIndicatorBounds() {
        View[] pageViews = getPageViews();
        for (View view : pageViews) {
            View view2 = (gx) view2;
            if (view2.m14303i()) {
                Rect selectionStartIndicatorBounds = view2.getSelectionStartIndicatorBounds();
                if (!selectionStartIndicatorBounds.isEmpty()) {
                    dv.m1937b(selectionStartIndicatorBounds, view2, (View) this);
                    return selectionStartIndicatorBounds;
                }
            }
        }
        return new Rect();
    }

    public Rect getSelectionEndIndicatorBounds() {
        View[] pageViews = getPageViews();
        for (View view : pageViews) {
            View view2 = (gx) view2;
            if (view2.m14303i()) {
                Rect selectionEndIndicatorBounds = view2.getSelectionEndIndicatorBounds();
                if (!selectionEndIndicatorBounds.isEmpty()) {
                    dv.m1937b(selectionEndIndicatorBounds, view2, (View) this);
                    return selectionEndIndicatorBounds;
                }
            }
        }
        return new Rect();
    }

    public void setSelection(bb bbVar) {
        this.f10175c = bbVar;
        m10013c(false);
        invalidate();
    }

    public bb getActiveText() {
        return this.f10176d;
    }

    public void setActiveColorText(bb bbVar) {
        this.f10176d = bbVar;
        m10013c(false);
    }

    /* renamed from: a */
    public final void mo2028a(C0903n c0903n, C0896a c0896a) {
        this.f10174b = c0903n;
        if (this.f10174b != null) {
            this.f10175c = this.f10174b.mo1250s();
            mo1984a(c0896a);
            return;
        }
        View[] pageViews = getPageViews();
        for (View view : pageViews) {
            ((gx) view).setPage(null);
        }
        setCurrentPageIndicator(null);
        setCurrentPagePresenter(null);
        getProxyAdapter().mo1765b().mo1691d();
    }

    public void setAnnotations(C0798a[] c0798aArr) {
        this.f10177e = c0798aArr;
        m10013c(false);
    }

    public C0798a[] getAnnotations() {
        return this.f10177e;
    }

    /* renamed from: a */
    public void mo1984a(C0896a c0896a) {
        m10006b(mo2517b(c0896a));
    }

    /* renamed from: q */
    public boolean mo2169q() {
        return getCellsView().getScrollState() != ScrollState.IDLE;
    }

    public Rect getViewableBounds() {
        this.f10173a.set(0, 0, getWidth(), getHeight());
        if (this.f10174b != null) {
            Rect a = this.f10174b.mo1245k().m6083a();
            Rect rect = this.f10173a;
            rect.left += a.left;
            rect = this.f10173a;
            rect.top += a.top;
            rect = this.f10173a;
            rect.right -= a.right;
            rect = this.f10173a;
            rect.bottom -= a.bottom;
        }
        return this.f10173a;
    }

    /* renamed from: b */
    public bb mo2096b(int i, int i2) {
        View view = (gx) m9987a(i, i2);
        if (view == null) {
            return this.f10174b.mo1250s();
        }
        Point point = new Point(i, i2);
        dv.m1897a(point, (View) this, view);
        return view.m14303i() ? view.getPageDrawable().mo1302b(point) : this.f10174b.mo1250s();
    }

    /* renamed from: b */
    public bb mo2097b(int i, int i2, int i3, int i4) {
        View[] a = m10002a(Math.min(i, i3), Math.min(i2, i4), Math.max(i, i3), Math.max(i2, i4));
        bb s = this.f10174b.mo1250s();
        for (View view : a) {
            View view2 = (gx) view2;
            if (!view2.m14303i()) {
                break;
            }
            Point point = new Point(i, i2);
            Point point2 = new Point(i3, i4);
            dv.m1897a(point, (View) this, view2);
            dv.m1897a(point2, (View) this, view2);
            s = s.mo1196a(view2.getPageDrawable().mo1293a(point, point2));
        }
        return s;
    }

    /* renamed from: r */
    public bb mo2170r() {
        Rect viewableBounds = getViewableBounds();
        return mo2097b(viewableBounds.left, viewableBounds.top, viewableBounds.right, viewableBounds.bottom);
    }

    /* renamed from: b */
    public Pair<gx, Integer> mo2094b(Point point) {
        View view = (gx) m9987a(point.x, point.y);
        if (view == null) {
            return null;
        }
        Point point2 = new Point(point);
        dv.m1897a(point2, (View) this, view);
        int d = view.m14303i() ? view.getPageDrawable().mo1310d(point2) : -1;
        return d < 0 ? null : new Pair(view, Integer.valueOf(d));
    }

    /* renamed from: a */
    public Pair<gx, Integer> mo2013a(Point point, int i) {
        View view = (gx) m9987a(point.x, point.y);
        if (view == null) {
            return null;
        }
        Point point2 = new Point(point);
        dv.m1897a(point2, (View) this, view);
        int a = view.m14303i() ? view.getPageDrawable().mo1289a(point2, i) : -1;
        return a < 0 ? null : new Pair(view, Integer.valueOf(a));
    }

    /* renamed from: c */
    public Pair<gx, Integer> mo2125c(Point point) {
        View view = (gx) m9987a(point.x, point.y);
        if (view == null) {
            return null;
        }
        Point point2 = new Point(point);
        dv.m1897a(point2, (View) this, view);
        int g = view.m14303i() ? view.getPageDrawable().mo1320g(point2) : -1;
        return g < 0 ? null : new Pair(view, Integer.valueOf(g));
    }

    /* renamed from: a */
    public int mo2010a(bb bbVar) {
        if (getCurrentPagePresenter() == null) {
            return -1;
        }
        gx gxVar = (gx) getCurrentPagePresenter().mo2328d();
        return gxVar.m14303i() ? gxVar.getPageDrawable().mo1290a(bbVar) : -1;
    }

    /* renamed from: a */
    public ac mo2015a(int i) {
        if (getCurrentPagePresenter() == null) {
            return null;
        }
        gx gxVar = (gx) getCurrentPagePresenter().mo2328d();
        return gxVar.m14303i() ? gxVar.getPageDrawable().mo1329k(i) : null;
    }

    /* renamed from: b */
    public Rect[] mo2107b(bb bbVar) {
        View[] pageViews = getPageViews();
        LinkedList linkedList = new LinkedList();
        for (View view : pageViews) {
            View view2 = (gx) view2;
            if (view2.m14303i()) {
                Rect[] e = view2.getPageDrawable().mo1316e(bbVar);
                dv.m1926a(e, view2, (View) this);
                linkedList.addAll(Arrays.asList(e));
            }
        }
        return (Rect[]) linkedList.toArray(new Rect[0]);
    }

    /* renamed from: c */
    public Rect mo2124c(bb bbVar) {
        Rect rect = new Rect();
        for (Rect union : mo2107b(bbVar)) {
            rect.union(union);
        }
        return rect;
    }

    /* renamed from: a */
    public Drawable mo2012a(DecorDrawableStyle decorDrawableStyle) {
        return this.f10178f[decorDrawableStyle.ordinal()];
    }

    public Drawable getSelectionDrawable() {
        return this.f10179g == null ? mo2012a(DecorDrawableStyle.SELECTION_HIGHLIGHT_RECT) : this.f10179g;
    }

    public void setSelectionDrawable(Drawable drawable) {
        this.f10179g = drawable;
        invalidate();
    }

    public void setShowSelectionIndicators(boolean z) {
        this.f10181i = z;
        invalidate();
    }

    /* renamed from: s */
    public boolean mo2171s() {
        return this.f10181i;
    }

    /* renamed from: c */
    public boolean mo2129c(int i, int i2) {
        boolean z = true;
        int b = dv.m1932b(getContext(), 50.0f);
        if (m10028p()) {
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
            gx gxVar = (gx) getCurrentPagePresenter().mo2328d();
            if (!gxVar.m14303i()) {
                return false;
            }
            bb m = gxVar.getPageDrawable().mo1334m();
            if (m == null || m.m5817f()) {
                return false;
            }
            Rect[] b2 = mo2107b(m);
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

    /* renamed from: d */
    public boolean mo2134d(int i, int i2) {
        boolean z = true;
        int b = dv.m1932b(getContext(), 50.0f);
        if (m10028p()) {
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
            gx gxVar = (gx) getCurrentPagePresenter().mo2328d();
            if (!gxVar.m14303i()) {
                return false;
            }
            bb m = gxVar.getPageDrawable().mo1334m();
            if (m == null || m.m5817f()) {
                return false;
            }
            PageLayout pageLayout = getPageLayout();
            Rect[] b2 = mo2107b(m);
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

    /* renamed from: d */
    public void mo2131d(bb bbVar) {
        int i = 0;
        if (bbVar != null && !bbVar.m5817f()) {
            int i2;
            if (m10027o()) {
                gs gsVar = (gs) getCurrentPagePresenter();
                if (gsVar == null) {
                    mo1984a(bbVar.mo1198g());
                    gsVar = (gs) getCurrentPagePresenter();
                }
                ak g = gsVar.mo2331g();
                if (!g.m5812a(bbVar.mo1199h()) && !g.mo1199h().equals(bbVar.mo1199h())) {
                    View[] pageViews = getPageViews();
                    List arrayList = new ArrayList();
                    for (View view : pageViews) {
                        arrayList.add(((gx) view).getPageDrawable().mo1332l());
                    }
                    Collections.sort(arrayList, new ft(this));
                    i2 = -1;
                    int i3 = -1;
                    while (i < arrayList.size()) {
                        int i4;
                        ak akVar = (ak) arrayList.get(i);
                        if (akVar.equals(g)) {
                            i3 = i;
                        }
                        if (akVar.m5812a(bbVar.mo1199h()) || akVar.mo1199h().equals(bbVar.mo1199h())) {
                            i4 = i;
                        } else {
                            i4 = i2;
                        }
                        i++;
                        i2 = i4;
                    }
                    if (i2 == -1 || i3 == -1) {
                        mo1984a(bbVar.mo1198g());
                        return;
                    } else if (i2 - i3 == 1) {
                        m10008b(null, null);
                        return;
                    } else if (i2 - i3 == -1) {
                        m9999a(null, null);
                        return;
                    } else {
                        mo1984a(bbVar.mo1198g());
                        return;
                    }
                }
                return;
            }
            Rect[] b = mo2107b(bbVar);
            if (b.length > 0) {
                Rect rect = new Rect();
                i2 = b.length;
                while (i < i2) {
                    rect.union(b[i]);
                    i++;
                }
                m9992a(m9986a(rect), getViewableBounds(), (int) HttpStatus.SC_OK, null, null);
                return;
            }
            mo1984a(bbVar.mo1198g());
            m9998a(new fu(this, bbVar));
        }
    }

    /* renamed from: a */
    public void mo2026a(bb bbVar, DecorDrawableStyle decorDrawableStyle) {
        if (bbVar != null && !bbVar.m5817f()) {
            if (this.f10182j == null) {
                this.f10182j = new HashMap();
            }
            Drawable a = mo2012a(decorDrawableStyle);
            List list = null;
            if (this.f10182j.containsKey(a)) {
                list = (List) this.f10182j.get(a);
            }
            if (list == null) {
                list = new LinkedList();
            }
            list.add(bbVar);
            this.f10182j.put(a, list);
            m10013c(false);
        }
    }

    /* renamed from: b */
    public void mo2101b(bb bbVar, DecorDrawableStyle decorDrawableStyle) {
        if (this.f10182j != null && bbVar != null) {
            Drawable a = mo2012a(decorDrawableStyle);
            if (a != null && this.f10182j.containsKey(a)) {
                List<bb> list = (List) this.f10182j.get(a);
                if (list != null) {
                    for (bb bbVar2 : list) {
                        if (bbVar2 == bbVar) {
                            list.remove(bbVar2);
                            m10013c(false);
                            return;
                        }
                    }
                }
            }
        }
    }

    public Map<Drawable, List<bb>> getHighlights() {
        return this.f10182j;
    }

    /* renamed from: b */
    protected void mo1738b(boolean z) {
        int i = 0;
        if (getCurrentPagePresenter() != null) {
            View[] pageViews;
            gx gxVar;
            if (this.f10174b.mo1244j()) {
                if (z) {
                    ((su) AppContext.getAppContext(getContext()).queryFeature(su.class)).aM();
                }
                pageViews = getPageViews();
                while (i < pageViews.length) {
                    gxVar = (gx) pageViews[i];
                    as pageDrawable = gxVar.getPageDrawable();
                    gxVar.m14299e();
                    if (pageDrawable != null) {
                        this.f10174b.mo1233d(pageDrawable.mo1332l());
                    }
                    i++;
                }
                getProxyAdapter().mo1765b().mo1691d();
            } else if (((gx) getCurrentPagePresenter().mo2328d()).getPageDrawable().mo1342q() != this.f10174b.mo1246l()) {
                if (z) {
                    ((su) AppContext.getAppContext(getContext()).queryFeature(su.class)).aM();
                }
                pageViews = getPageViews();
                while (i < pageViews.length) {
                    gxVar = (gx) pageViews[i];
                    if (gxVar.getPageDrawable() != null) {
                        gxVar.setRenderParams(this.f10174b.mo1246l());
                    }
                    i++;
                }
            } else {
                pageViews = getPageViews();
                while (i < pageViews.length) {
                    as pageDrawable2 = ((gx) pageViews[i]).getPageDrawable();
                    if (pageDrawable2 != null) {
                        pageDrawable2.invalidateSelf();
                    }
                    i++;
                }
            }
        }
    }

    /* renamed from: a */
    protected void mo1734a() {
        View[] pageViews = getPageViews();
        for (View view : pageViews) {
            gx gxVar = (gx) view;
            as pageDrawable = gxVar.getPageDrawable();
            gxVar.m14299e();
            if (pageDrawable != null) {
                this.f10174b.mo1233d(pageDrawable.mo1332l());
            }
        }
        getProxyAdapter().mo1765b().mo1691d();
    }

    public void setPagesExtraColor(int i) {
        this.f10183k = i;
        View[] pageViews = getPageViews();
        for (View view : pageViews) {
            ((gx) view).setStatusColor(this.f10183k);
        }
    }

    /* renamed from: a */
    private void m14114a(Canvas canvas) {
        if (mo2171s()) {
            Rect selectionStartIndicatorBounds = getSelectionStartIndicatorBounds();
            Rect selectionEndIndicatorBounds = getSelectionEndIndicatorBounds();
            if (!selectionStartIndicatorBounds.isEmpty()) {
                dv.m1911a(canvas, mo2012a(DecorDrawableStyle.SELECTION_INDICATOR_START), selectionStartIndicatorBounds, 17);
            }
            if (!selectionEndIndicatorBounds.isEmpty()) {
                dv.m1911a(canvas, mo2012a(DecorDrawableStyle.SELECTION_INDICATOR_END), selectionEndIndicatorBounds, 17);
            }
        }
    }

    /* renamed from: b */
    protected fx mo2517b(C0896a c0896a) {
        return new fx(this, c0896a);
    }
}
