package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.animation.Animation;

import java.util.ArrayList;

class cg extends cl {
    final /* synthetic */ ArrayList a;
    final /* synthetic */ bz b;

    cg(bz bzVar, ArrayList arrayList) {
        this.b = bzVar;
        this.a = arrayList;
        super(bzVar);
    }

    public void onAnimationEnd(Animation animation) {
        super.onAnimationEnd(animation);
        for (int i = 0; i < this.a.size(); i++) {
            ((View) this.a.get(i)).clearAnimation();
        }
    }
}
