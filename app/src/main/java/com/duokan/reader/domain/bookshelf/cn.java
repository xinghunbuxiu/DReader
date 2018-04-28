package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.domain.account.al;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class cn extends WebSession {
    /* renamed from: a */
    final /* synthetic */ List f2972a;
    /* renamed from: b */
    final /* synthetic */ al f2973b;
    /* renamed from: c */
    final /* synthetic */ bs f2974c;
    /* renamed from: d */
    final /* synthetic */ cm f2975d;
    /* renamed from: e */
    private final cp f2976e = new cp();
    /* renamed from: f */
    private final cp f2977f = new cp();
    /* renamed from: g */
    private ArrayList<bt> f2978g = new ArrayList();

    cn(cm cmVar, C0657i c0657i, List list, al alVar, bs bsVar) {
        this.f2975d = cmVar;
        this.f2972a = list;
        this.f2973b = alVar;
        this.f2974c = bsVar;
        super(c0657i);
    }

    protected void onSessionOpen() {
        super.onSessionOpen();
        if (!this.f2975d.f2971c.f2870e) {
            this.f2975d.f2971c.f2870e = true;
            this.f2975d.f2971c.f2871f = System.currentTimeMillis();
        }
    }

    protected void onSessionTry() {
        bt btVar;
        this.f2976e.m4280a(this.f2972a);
        bq bqVar = new bq(this.f2973b);
        bqVar.m4053a();
        bqVar.m4054b();
        this.f2977f.m4278a(bqVar);
        if (this.f2975d.f2969a.m4062a()) {
            Collection arrayList = new ArrayList();
            for (int size = this.f2977f.f2980a.size() - 1; size >= 0; size--) {
                btVar = (bt) this.f2977f.f2980a.get(size);
                if (!btVar.f2863g) {
                    arrayList.add(btVar);
                    this.f2977f.m4281b(btVar);
                }
            }
            bqVar.deleteItems(arrayList);
            bqVar.clearInfo();
        }
        Iterator it = this.f2976e.f2980a.iterator();
        while (it.hasNext()) {
            btVar = (bt) it.next();
            bt a = this.f2977f.m4277a(btVar.f2857a, btVar.f2858b);
            if (btVar.m4070c()) {
                if (a == null) {
                    this.f2978g.add(btVar);
                } else if (a.m4070c()) {
                    bqVar.deleteItem(a);
                    this.f2977f.m4281b(a);
                } else if (!a.f2863g) {
                    bqVar.deleteItem(a);
                    this.f2977f.m4281b(a);
                    this.f2978g.add(btVar);
                } else if (a.f2865i >= btVar.f2861e) {
                    a.f2860d = btVar.f2860d;
                    a.f2864h = 1;
                    bqVar.updateItem(a);
                } else {
                    bqVar.deleteItem(a);
                    this.f2977f.m4281b(a);
                    this.f2978g.add(btVar);
                }
            } else if (a == null) {
                bqVar.insertItem(btVar);
                this.f2977f.m4279a(btVar);
                this.f2978g.add(btVar);
            } else if (a.m4070c()) {
                if (a.f2865i >= btVar.f2861e) {
                    a.f2860d = btVar.f2860d;
                    bqVar.updateItem(a);
                } else {
                    bqVar.deleteItem(a);
                    this.f2977f.m4281b(a);
                    bqVar.insertItem(btVar);
                    this.f2977f.m4279a(btVar);
                    this.f2978g.add(btVar);
                }
            } else if (!a.f2863g) {
                bqVar.deleteItem(a);
                this.f2977f.m4281b(a);
                bqVar.insertItem(btVar);
                this.f2977f.m4279a(btVar);
                this.f2978g.add(btVar);
            } else if (a.f2865i >= btVar.f2861e) {
                a.f2860d = btVar.f2860d;
                a.f2864h = 2;
                bqVar.updateItem(a);
            } else {
                bqVar.deleteItem(a);
                this.f2977f.m4281b(a);
                bqVar.insertItem(btVar);
                this.f2977f.m4279a(btVar);
                this.f2978g.add(btVar);
            }
        }
        bqVar.updateInfo(this.f2974c);
    }

    protected void onSessionSucceeded() {
        if (this.f2973b.m3365a(this.f2975d.f2971c.f2868c)) {
            this.f2975d.f2971c.m4088a(this.f2977f);
            this.f2975d.f2970b.mo987a(this.f2978g);
            return;
        }
        this.f2975d.f2970b.mo986a("");
    }

    protected void onSessionFailed() {
        this.f2975d.f2970b.mo986a("");
    }
}
