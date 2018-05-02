package com.duokan.reader.ui;

import android.content.Context;
import android.widget.FrameLayout;

import com.duokan.reader.ui.general.ReaderUi;

class m extends FrameLayout {
    final /* synthetic */ i a;
    final /* synthetic */ l b;

    m(l lVar, Context context, i iVar) {
        this.b = lVar;
        this.a = iVar;
        super(context);
    }

    protected void onMeasure(int i, int i2) {
        int a = ReaderUi.a(getContext(), getResources().getDisplayMetrics().widthPixels, this.b.d);
        if (getPaddingLeft() != a) {
            setPadding(a, 0, 0, 0);
        }
        super.onMeasure(i, i2);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 && this.b.a.l() == this.b) {
            this.b.a.h(this.b.b());
        }
    }
}
