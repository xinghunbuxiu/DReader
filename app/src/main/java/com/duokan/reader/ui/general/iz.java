package com.duokan.reader.ui.general;

import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

class iz implements Runnable {
    final /* synthetic */ ViewGroup a;
    final /* synthetic */ int b;
    final /* synthetic */ iy c;

    iz(iy iyVar, ViewGroup viewGroup, int i) {
        this.c = iyVar;
        this.a = viewGroup;
        this.b = i;
    }

    public void run() {
        this.a.removeViewInLayout(this.c);
        LayoutParams layoutParams = this.c.getLayoutParams();
        if (layoutParams != null) {
            this.a.addView(this.c.b, this.b, layoutParams);
        } else {
            this.a.addView(this.c.b, this.b);
        }
    }
}
