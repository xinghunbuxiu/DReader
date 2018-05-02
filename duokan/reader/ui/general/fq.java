package com.duokan.reader.ui.general;

import android.view.View;

import java.util.ArrayList;

class fq implements Runnable {
    static final /* synthetic */ boolean a = (!PagesController.class.desiredAssertionStatus());
    final /* synthetic */ fy b;
    final /* synthetic */ View c;
    final /* synthetic */ fy d;
    final /* synthetic */ ArrayList e;
    final /* synthetic */ Runnable f;
    final /* synthetic */ PagesController g;

    fq(PagesController pagesController, fy fyVar, View view, fy fyVar2, ArrayList arrayList, Runnable runnable) {
        this.g = pagesController;
        this.b = fyVar;
        this.c = view;
        this.d = fyVar2;
        this.e = arrayList;
        this.f = runnable;
    }

    public void run() {
        if (!a && this.b == null) {
            throw new AssertionError();
        } else if (a || this.c != null) {
            if (this.d != null) {
                this.g.activate(this.d);
            }
            for (int i = 0; i < this.e.size(); i++) {
                this.g.b((fy) this.e.get(i));
            }
            this.g.b(this.g.b.size());
            if (this.f != null) {
                this.f.run();
            }
        } else {
            throw new AssertionError();
        }
    }
}
