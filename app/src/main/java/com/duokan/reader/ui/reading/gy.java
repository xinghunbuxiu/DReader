package com.duokan.reader.ui.reading;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Pair;

import com.duokan.reader.domain.document.a;
import com.duokan.reader.domain.document.ac;
import com.duokan.reader.domain.document.bb;
import com.duokan.reader.domain.document.n;

import java.util.Map;

public interface gy {
    int a(bb bbVar);

    Drawable a(DecorDrawableStyle decorDrawableStyle);

    Pair a(Point point, int i);

    ac a(int i);

    void a(PointF pointF, Runnable runnable, Runnable runnable2);

    void a(a aVar);

    void a(bb bbVar, DecorDrawableStyle decorDrawableStyle);

    void a(n nVar, a aVar);

    void a(Runnable runnable, Runnable runnable2);

    Pair b(Point point);

    bb b(int i, int i2);

    bb b(int i, int i2, int i3, int i4);

    void b(PointF pointF, Runnable runnable, Runnable runnable2);

    void b(bb bbVar, DecorDrawableStyle decorDrawableStyle);

    void b(Runnable runnable, Runnable runnable2);

    Rect[] b(bb bbVar);

    Rect c(bb bbVar);

    Pair c(Point point);

    boolean c(int i, int i2);

    void d(bb bbVar);

    boolean d(int i, int i2);

    bb getActiveText();

    com.duokan.reader.domain.bookshelf.a[] getAnnotations();

    n getDocument();

    Map getHighlights();

    bb getSelection();

    Drawable getSelectionDrawable();

    Rect getSelectionEndIndicatorBounds();

    Rect getSelectionStartIndicatorBounds();

    Rect getViewableBounds();

    boolean q();

    bb r();

    boolean s();

    void scrollBy(int i, int i2);

    void setActiveColorText(bb bbVar);

    void setAnnotations(com.duokan.reader.domain.bookshelf.a[] aVarArr);

    void setSelection(bb bbVar);

    void setSelectionDrawable(Drawable drawable);

    void setShowSelectionIndicators(boolean z);
}
