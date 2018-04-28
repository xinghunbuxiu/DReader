package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.animation.Animation;
import java.util.ArrayList;

class cl extends cq {
    /* renamed from: a */
    final /* synthetic */ ArrayList f6278a;
    /* renamed from: b */
    final /* synthetic */ ce f6279b;

    cl(ce ceVar, ArrayList arrayList) {
        this.f6279b = ceVar;
        this.f6278a = arrayList;
        super(ceVar);
    }

    public void onAnimationEnd(Animation animation) {
        super.onAnimationEnd(animation);
        for (int i = 0; i < this.f6278a.size(); i++) {
            ((View) this.f6278a.get(i)).clearAnimation();
        }
    }
}
