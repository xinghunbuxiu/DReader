package com.duokan.reader.ui.general;

import android.view.View;
import java.util.ArrayList;

class fk implements Runnable {
    /* renamed from: a */
    static final /* synthetic */ boolean f7231a = (!PagesController.class.desiredAssertionStatus());
    /* renamed from: b */
    final /* synthetic */ fs f7232b;
    /* renamed from: c */
    final /* synthetic */ View f7233c;
    /* renamed from: d */
    final /* synthetic */ fs f7234d;
    /* renamed from: e */
    final /* synthetic */ ArrayList f7235e;
    /* renamed from: f */
    final /* synthetic */ Runnable f7236f;
    /* renamed from: g */
    final /* synthetic */ PagesController f7237g;

    fk(PagesController pagesController, fs fsVar, View view, fs fsVar2, ArrayList arrayList, Runnable runnable) {
        this.f7237g = pagesController;
        this.f7232b = fsVar;
        this.f7233c = view;
        this.f7234d = fsVar2;
        this.f7235e = arrayList;
        this.f7236f = runnable;
    }

    public void run() {
        if (!f7231a && this.f7232b == null) {
            throw new AssertionError();
        } else if (f7231a || this.f7233c != null) {
            if (this.f7234d != null) {
                this.f7237g.activate(this.f7234d);
            }
            for (int i = 0; i < this.f7235e.size(); i++) {
                this.f7237g.m9224b((fs) this.f7235e.get(i));
            }
            this.f7237g.mo1972b(this.f7237g.f6184b.size());
            if (this.f7236f != null) {
                this.f7236f.run();
            }
        } else {
            throw new AssertionError();
        }
    }
}
