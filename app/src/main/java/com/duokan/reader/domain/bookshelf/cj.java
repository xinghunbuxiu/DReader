package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.domain.account.al;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

class cj extends WebSession {
    /* renamed from: a */
    final /* synthetic */ al f2960a;
    /* renamed from: b */
    final /* synthetic */ boolean f2961b;
    /* renamed from: c */
    final /* synthetic */ ArrayList f2962c;
    /* renamed from: d */
    final /* synthetic */ bu f2963d;
    /* renamed from: e */
    private final cp f2964e = new cp();

    cj(bu buVar, C0657i c0657i, al alVar, boolean z, ArrayList arrayList) {
        this.f2963d = buVar;
        this.f2960a = alVar;
        this.f2961b = z;
        this.f2962c = arrayList;
        super(c0657i);
    }

    protected void onSessionTry() {
        bq bqVar = new bq(this.f2960a);
        bqVar.m4053a();
        if (this.f2961b) {
            this.f2964e.m4278a(bqVar);
            Collection arrayList = new ArrayList(this.f2962c.size());
            Iterator it = this.f2962c.iterator();
            while (it.hasNext()) {
                bt btVar = (bt) it.next();
                int i = btVar.f2857a;
                String str = btVar.f2858b;
                if (btVar.f2864h == 1) {
                    arrayList.add(this.f2963d.m4076a(this.f2964e, i, str, btVar.f2859c, btVar.f2865i));
                } else if (btVar.f2864h == 2) {
                    arrayList.add(this.f2963d.m4094b(this.f2964e, i, str, btVar.f2859c, btVar.f2865i));
                } else if (btVar.f2864h == 3) {
                    arrayList.add(this.f2963d.m4075a(this.f2964e, i, str, btVar.f2865i));
                }
            }
            bqVar.updateItems(arrayList);
            return;
        }
        bqVar.updateItems(this.f2962c);
    }

    protected void onSessionSucceeded() {
        if (this.f2960a.m3365a(this.f2963d.f2868c) && this.f2961b) {
            this.f2963d.m4088a(this.f2964e);
        }
    }

    protected void onSessionFailed() {
    }
}
