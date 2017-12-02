package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.account.ab;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class cq extends ap {
    final /* synthetic */ List a;
    final /* synthetic */ ab b;
    final /* synthetic */ bt c;
    final /* synthetic */ cp d;
    private final cs e = new cs();
    private final cs f = new cs();
    private ArrayList g = new ArrayList();

    cq(cp cpVar, List list, ab abVar, bt btVar) {
        this.d = cpVar;
        this.a = list;
        this.b = abVar;
        this.c = btVar;
    }

    protected void onSessionOpen() {
        super.onSessionOpen();
        if (!this.d.c.e) {
            this.d.c.e = true;
            this.d.c.f = System.currentTimeMillis();
        }
    }

    protected void onSessionTry() {
        bu buVar;
        this.e.a(this.a);
        br brVar = new br(this.b);
        brVar.a();
        brVar.b();
        this.f.a(brVar);
        if (this.d.a.a()) {
            Collection arrayList = new ArrayList();
            for (int size = this.f.a.size() - 1; size >= 0; size--) {
                buVar = (bu) this.f.a.get(size);
                if (!buVar.g) {
                    arrayList.add(buVar);
                    this.f.b(buVar);
                }
            }
            brVar.deleteItems(arrayList);
            brVar.clearInfo();
        }
        Iterator it = this.e.a.iterator();
        while (it.hasNext()) {
            buVar = (bu) it.next();
            bu a = this.f.a(buVar.a, buVar.b);
            if (buVar.c()) {
                if (a == null) {
                    this.g.add(buVar);
                } else if (a.c()) {
                    brVar.deleteItem(a);
                    this.f.b(a);
                } else if (!a.g) {
                    brVar.deleteItem(a);
                    this.f.b(a);
                    this.g.add(buVar);
                } else if (a.i >= buVar.e) {
                    a.d = buVar.d;
                    a.h = 1;
                    brVar.updateItem(a);
                } else {
                    brVar.deleteItem(a);
                    this.f.b(a);
                    this.g.add(buVar);
                }
            } else if (a == null) {
                brVar.insertItem(buVar);
                this.f.a(buVar);
                this.g.add(buVar);
            } else if (a.c()) {
                if (a.i >= buVar.e) {
                    a.d = buVar.d;
                    brVar.updateItem(a);
                } else {
                    brVar.deleteItem(a);
                    this.f.b(a);
                    brVar.insertItem(buVar);
                    this.f.a(buVar);
                    this.g.add(buVar);
                }
            } else if (!a.g) {
                brVar.deleteItem(a);
                this.f.b(a);
                brVar.insertItem(buVar);
                this.f.a(buVar);
                this.g.add(buVar);
            } else if (a.i >= buVar.e) {
                a.d = buVar.d;
                a.h = 2;
                brVar.updateItem(a);
            } else {
                brVar.deleteItem(a);
                this.f.b(a);
                brVar.insertItem(buVar);
                this.f.a(buVar);
                this.g.add(buVar);
            }
        }
        brVar.updateInfo(this.c);
    }

    protected void onSessionSucceeded() {
        if (this.b.a(this.d.c.c)) {
            this.d.c.a(this.f);
            this.d.b.a(this.g);
            return;
        }
        this.d.b.a("");
    }

    protected void onSessionFailed() {
        this.d.b.a("");
    }
}
