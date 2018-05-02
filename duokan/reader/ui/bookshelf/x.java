package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import android.view.View;

class x extends gs {
    final /* synthetic */ View a;
    final /* synthetic */ g b;

    x(g gVar, Context context, View view) {
        this.b = gVar;
        this.a = view;
        super(context);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        f(getVerticalThumbMarginLeft(), this.a.getHeight() + getVerticalThumbMarginTop(), getVerticalThumbMarginRight(), getVerticalThumbMarginBottom());
    }
}
