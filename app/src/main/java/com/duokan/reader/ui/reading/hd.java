package com.duokan.reader.ui.reading;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Pair;
import com.duokan.reader.domain.bookshelf.C0798a;
import com.duokan.reader.domain.document.C0896a;
import com.duokan.reader.domain.document.C0903n;
import com.duokan.reader.domain.document.ac;
import com.duokan.reader.domain.document.bb;
import java.util.List;
import java.util.Map;

public interface hd {
    /* renamed from: a */
    int mo2010a(bb bbVar);

    /* renamed from: a */
    Drawable mo2012a(DecorDrawableStyle decorDrawableStyle);

    /* renamed from: a */
    Pair<gx, Integer> mo2013a(Point point, int i);

    /* renamed from: a */
    ac mo2015a(int i);

    /* renamed from: a */
    void mo2018a(PointF pointF, Runnable runnable, Runnable runnable2);

    /* renamed from: a */
    void mo1984a(C0896a c0896a);

    /* renamed from: a */
    void mo2026a(bb bbVar, DecorDrawableStyle decorDrawableStyle);

    /* renamed from: a */
    void mo2028a(C0903n c0903n, C0896a c0896a);

    /* renamed from: a */
    void mo2035a(Runnable runnable, Runnable runnable2);

    /* renamed from: b */
    Pair<gx, Integer> mo2094b(Point point);

    /* renamed from: b */
    bb mo2096b(int i, int i2);

    /* renamed from: b */
    bb mo2097b(int i, int i2, int i3, int i4);

    /* renamed from: b */
    void mo2099b(PointF pointF, Runnable runnable, Runnable runnable2);

    /* renamed from: b */
    void mo2101b(bb bbVar, DecorDrawableStyle decorDrawableStyle);

    /* renamed from: b */
    void mo2104b(Runnable runnable, Runnable runnable2);

    /* renamed from: b */
    Rect[] mo2107b(bb bbVar);

    /* renamed from: c */
    Rect mo2124c(bb bbVar);

    /* renamed from: c */
    Pair<gx, Integer> mo2125c(Point point);

    /* renamed from: c */
    boolean mo2129c(int i, int i2);

    /* renamed from: d */
    void mo2131d(bb bbVar);

    /* renamed from: d */
    boolean mo2134d(int i, int i2);

    bb getActiveText();

    C0798a[] getAnnotations();

    C0903n getDocument();

    Map<Drawable, List<bb>> getHighlights();

    bb getSelection();

    Drawable getSelectionDrawable();

    Rect getSelectionEndIndicatorBounds();

    Rect getSelectionStartIndicatorBounds();

    Rect getViewableBounds();

    /* renamed from: q */
    boolean mo2169q();

    /* renamed from: r */
    bb mo2170r();

    /* renamed from: s */
    boolean mo2171s();

    void scrollBy(int i, int i2);

    void setActiveColorText(bb bbVar);

    void setAnnotations(C0798a[] c0798aArr);

    void setSelection(bb bbVar);

    void setSelectionDrawable(Drawable drawable);

    void setShowSelectionIndicators(boolean z);
}
