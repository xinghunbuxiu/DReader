package com.duokan.reader.ui.reading;

import android.view.View;
import java.util.Comparator;

class sq implements Comparator<View> {
    /* renamed from: a */
    final /* synthetic */ si f10952a;

    sq(si siVar) {
        this.f10952a = siVar;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m14976a((View) obj, (View) obj2);
    }

    /* renamed from: a */
    public int m14976a(View view, View view2) {
        gx gxVar = (gx) view;
        gx gxVar2 = (gx) view2;
        if (gxVar.getPageDrawable().mo1332l().mo1188a(gxVar2.getPageDrawable().mo1332l())) {
            return -1;
        }
        if (gxVar.getPageDrawable().mo1332l().mo1190c(gxVar2.getPageDrawable().mo1332l())) {
            return 1;
        }
        return 0;
    }
}
