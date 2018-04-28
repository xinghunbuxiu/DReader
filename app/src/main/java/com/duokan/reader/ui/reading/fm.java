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
import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.bb;
import com.duokan.reader.ui.general.FixedPagesView;
import com.duokan.reader.ui.general.ej;
import com.duokan.reader.ui.general.ha;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpStatus;

public class fm extends FixedPagesView implements hd {
    /* renamed from: b */
    private final Rect f10153b;
    /* renamed from: c */
    private C0903n f10154c;
    /* renamed from: d */
    private bb f10155d;
    /* renamed from: e */
    private bb f10156e;
    /* renamed from: f */
    private C0798a[] f10157f;
    /* renamed from: g */
    private final Drawable[] f10158g;
    /* renamed from: h */
    private Drawable f10159h;
    /* renamed from: i */
    private boolean f10160i;
    /* renamed from: j */
    private Map<Drawable, List<bb>> f10161j;

    public fm(Context context) {
        this(context, null);
    }

    public fm(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10153b = new Rect();
        this.f10154c = null;
        this.f10155d = null;
        this.f10156e = null;
        this.f10157f = null;
        this.f10159h = null;
        this.f10160i = true;
        setAdapter(new fo());
        this.f10158g = new Drawable[DecorDrawableStyle.values().length];
        this.f10158g[DecorDrawableStyle.BOOK_MARK.ordinal()] = getResources().getDrawable(C0243e.reading__shared__bookmark_highlight);
        this.f10158g[DecorDrawableStyle.SELECTION_INDICATOR_START.ordinal()] = getResources().getDrawable(C0243e.reading__shared__selection_indicator_start);
        this.f10158g[DecorDrawableStyle.SELECTION_INDICATOR_END.ordinal()] = getResources().getDrawable(C0243e.reading__shared__selection_indicator_end);
        Drawable haVar = new ha();
        haVar.m10738a(Color.argb(64, HttpStatus.SC_NO_CONTENT, 51, 0));
        this.f10158g[DecorDrawableStyle.SELECTION_HIGHLIGHT_RECT.ordinal()] = haVar;
        ej ejVar = new ej();
        ejVar.m10560a(Color.argb(64, HttpStatus.SC_NO_CONTENT, 51, 0));
        this.f10158g[DecorDrawableStyle.SELECTION_HIGHLIGHT_LINE.ordinal()] = ejVar;
        this.f10158g[DecorDrawableStyle.MEDIA_PLAY.ordinal()] = context.getResources().getDrawable(C0243e.reading__shared__media_play);
        ha haVar2 = new ha();
        haVar2.m10738a(Color.argb(64, 51, 51, HttpStatus.SC_NO_CONTENT));
        this.f10158g[DecorDrawableStyle.AUDIO_TEXT_HIGHLIGHT.ordinal()] = haVar2;
        this.f10159h = haVar;
        setWillNotDraw(false);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        m14063a(canvas);
    }

    public C0903n getDocument() {
        return this.f10154c;
    }

    public void setCouplePageMode(boolean z) {
    }

    public bb getSelection() {
        return this.f10155d;
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
        this.f10155d = bbVar;
        m10013c(false);
        invalidate();
    }

    public bb getActiveText() {
        return this.f10156e;
    }

    public void setActiveColorText(bb bbVar) {
        this.f10156e = bbVar;
        m10013c(false);
    }

    /* renamed from: a */
    public final void mo2028a(C0903n c0903n, C0896a c0896a) {
        this.f10154c = c0903n;
        if (this.f10154c != null) {
            this.f10155d = this.f10154c.mo1250s();
            mo1984a(c0896a);
            return;
        }
        View[] pageViews = getPageViews();
        for (View view : pageViews) {
            ((gx) view).setPage(null);
        }
        setCurrentPageIndicator(null);
        setCurrentPagePresenter(null);
        getProxyAdapter().m10415a().mo1691d();
    }

    public void setAnnotations(C0798a[] c0798aArr) {
        this.f10157f = c0798aArr;
        m10013c(false);
    }

    public C0798a[] getAnnotations() {
        return this.f10157f;
    }

    /* renamed from: a */
    public final void mo1984a(C0896a c0896a) {
        m10006b(m14076b(c0896a));
    }

    /* renamed from: q */
    public boolean mo2169q() {
        return getCellsView().getScrollState() != ScrollState.IDLE;
    }

    public Rect getViewableBounds() {
        this.f10153b.set(0, 0, getWidth(), getHeight());
        if (this.f10154c != null) {
            Rect a = this.f10154c.mo1245k().m6083a();
            Rect rect = this.f10153b;
            rect.left += a.left;
            rect = this.f10153b;
            rect.top += a.top;
            rect = this.f10153b;
            rect.right -= a.right;
            rect = this.f10153b;
            rect.bottom -= a.bottom;
        }
        return this.f10153b;
    }

    /* renamed from: b */
    public bb mo2096b(int i, int i2) {
        View view = (gx) m9987a(i, i2);
        if (view == null) {
            return this.f10154c.mo1250s();
        }
        Point point = new Point(i, i2);
        dv.m1897a(point, (View) this, view);
        return view.m14303i() ? view.getPageDrawable().mo1302b(point) : this.f10154c.mo1250s();
    }

    /* renamed from: b */
    public bb mo2097b(int i, int i2, int i3, int i4) {
        View[] a = m10002a(Math.min(i, i3), Math.min(i2, i4), Math.max(i, i3), Math.max(i2, i4));
        bb s = this.f10154c.mo1250s();
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
        return null;
    }

    /* renamed from: a */
    public Pair<gx, Integer> mo2013a(Point point, int i) {
        return null;
    }

    /* renamed from: c */
    public Pair<gx, Integer> mo2125c(Point point) {
        return null;
    }

    /* renamed from: a */
    public int mo2010a(bb bbVar) {
        return -1;
    }

    /* renamed from: a */
    public ac mo2015a(int i) {
        return null;
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
        return this.f10158g[decorDrawableStyle.ordinal()];
    }

    public Drawable getSelectionDrawable() {
        return this.f10159h == null ? mo2012a(DecorDrawableStyle.SELECTION_HIGHLIGHT_RECT) : this.f10159h;
    }

    public void setSelectionDrawable(Drawable drawable) {
        this.f10159h = drawable;
        invalidate();
    }

    public void setShowSelectionIndicators(boolean z) {
        this.f10160i = z;
        invalidate();
    }

    /* renamed from: s */
    public boolean mo2171s() {
        return this.f10160i;
    }

    /* renamed from: c */
    public boolean mo2129c(int i, int i2) {
        return i2 < dv.m1932b(getContext(), 50.0f);
    }

    /* renamed from: d */
    public boolean mo2134d(int i, int i2) {
        return i2 > getHeight() - dv.m1932b(getContext(), 50.0f);
    }

    /* renamed from: d */
    public void mo2131d(bb bbVar) {
        if (bbVar != null && !bbVar.m5817f()) {
            Rect[] b = mo2107b(bbVar);
            if (b.length > 0) {
                Rect rect = new Rect();
                for (Rect union : b) {
                    rect.union(union);
                }
                m9992a(m9986a(rect), getViewableBounds(), (int) HttpStatus.SC_OK, null, null);
                return;
            }
            mo1984a(bbVar.mo1198g());
            m9998a(new fn(this, bbVar));
        }
    }

    /* renamed from: a */
    public void mo2026a(bb bbVar, DecorDrawableStyle decorDrawableStyle) {
        if (bbVar != null && !bbVar.m5817f()) {
            if (this.f10161j == null) {
                this.f10161j = new HashMap();
            }
            Drawable a = mo2012a(decorDrawableStyle);
            List list = null;
            if (this.f10161j.containsKey(a)) {
                list = (List) this.f10161j.get(a);
            }
            if (list == null) {
                list = new LinkedList();
            }
            list.add(bbVar);
            this.f10161j.put(a, list);
            m10013c(false);
        }
    }

    /* renamed from: b */
    public void mo2101b(bb bbVar, DecorDrawableStyle decorDrawableStyle) {
        if (this.f10161j != null && bbVar != null) {
            Drawable a = mo2012a(decorDrawableStyle);
            if (a != null && this.f10161j.containsKey(a)) {
                List<bb> list = (List) this.f10161j.get(a);
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

    public Map<Drawable, List<bb>> getHighlights() {
        return this.f10161j;
    }

    /* renamed from: b */
    protected void mo1738b(boolean z) {
        int i = 0;
        if (getCurrentPagePresenter() != null) {
            View[] pageViews;
            as pageDrawable;
            if (this.f10154c.mo1244j()) {
                if (z) {
                    ((su) AppContext.getAppContext(getContext()).queryFeature(su.class)).aM();
                }
                pageViews = getPageViews();
                while (i < pageViews.length) {
                    pageDrawable = ((gx) pageViews[i]).getPageDrawable();
                    if (pageDrawable != null) {
                        this.f10154c.mo1233d(pageDrawable.mo1332l());
                        pageDrawable.mo1285H();
                    }
                    i++;
                }
                getProxyAdapter().m10415a().mo1691d();
            } else if (((gx) getCurrentPagePresenter().mo2328d()).getPageDrawable().mo1342q() != this.f10154c.mo1246l()) {
                if (z) {
                    ((su) AppContext.getAppContext(getContext()).queryFeature(su.class)).aM();
                }
                pageViews = getPageViews();
                while (i < pageViews.length) {
                    gx gxVar = (gx) pageViews[i];
                    as pageDrawable2 = gxVar.getPageDrawable();
                    gxVar.setRenderParams(this.f10154c.mo1246l());
                    if (pageDrawable2 != null) {
                        pageDrawable2.invalidateSelf();
                    }
                    i++;
                }
            } else {
                pageViews = getPageViews();
                while (i < pageViews.length) {
                    pageDrawable = ((gx) pageViews[i]).getPageDrawable();
                    if (pageDrawable != null) {
                        pageDrawable.invalidateSelf();
                    }
                    i++;
                }
            }
        }
    }

    /* renamed from: a */
    private void m14063a(Canvas canvas) {
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
    protected fq m14076b(C0896a c0896a) {
        return new fq(this, c0896a);
    }

    /* renamed from: a */
    protected as m14069a(fq fqVar) {
        return this.f10154c.m5898a(fqVar.m14101b());
    }
}
