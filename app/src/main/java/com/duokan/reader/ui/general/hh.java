package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Point;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

import com.duokan.reader.ReaderEnv;

class hh extends FrameLayout {
    final /* synthetic */ hd a;
    final /* synthetic */ int b;
    final /* synthetic */ hg c;

    hh(hg hgVar, Context context, hd hdVar, int i) {
        this.c = hgVar;
        this.a = hdVar;
        this.b = i;
        super(context);
    }

    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        if (ReaderEnv.get().forHd() && this.b == 17) {
            Point a = ReaderUi.a(this.c.getActivity());
            super.measureChildWithMargins(view, MeasureSpec.makeMeasureSpec(a.x, 1073741824), i2, MeasureSpec.makeMeasureSpec(a.y, 1073741824), i4);
            return;
        }
        super.measureChildWithMargins(view, i, i2, i3, i4);
    }
}
