package com.duokan.reader.ui.reading.a;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;

import com.duokan.core.ui.er;
import com.duokan.core.ui.OnTouchChangeListener;
import com.duokan.reader.domain.bookshelf.a;

public interface aq extends OnTouchChangeListener {
    void a(er erVar, View view, a aVar, Point point);

    void a(er erVar, View view, a aVar, Rect rect);
}
