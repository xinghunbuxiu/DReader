package com.duokan.reader.ui.bookshelf;

import android.graphics.Rect;

import com.duokan.reader.domain.bookshelf.aa;
import com.duokan.reader.domain.bookshelf.an;

public interface eq {
    Rect a(int i);

    void a(int i, int i2);

    void a(int i, int i2, int i3, Runnable runnable, Runnable runnable2);

    void a(Rect rect);

    void a(aa aaVar, an anVar);

    void a(an anVar, int i);

    void a(an anVar, an anVar2, int i);

    void a(an anVar, boolean z);

    boolean a(int i, cz czVar);

    cz b(int i);

    an c(int i);

    boolean c_();

    boolean d_();

    int getContentScrollY();

    cz getDraggingItemView();

    int getItemCount();

    int[] getVisibleItemIndices();
}
