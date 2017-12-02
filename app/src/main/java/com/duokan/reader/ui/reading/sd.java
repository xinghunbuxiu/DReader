package com.duokan.reader.ui.reading;

import android.view.View;

import java.util.Comparator;

class sd implements Comparator {
    final /* synthetic */ rx a;

    sd(rx rxVar) {
        this.a = rxVar;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((View) obj, (View) obj2);
    }

    public int a(View view, View view2) {
        gs gsVar = (gs) view;
        gs gsVar2 = (gs) view2;
        if (gsVar.getPageDrawable().l().a(gsVar2.getPageDrawable().l())) {
            return -1;
        }
        if (gsVar.getPageDrawable().l().c(gsVar2.getPageDrawable().l())) {
            return 1;
        }
        return 0;
    }
}
