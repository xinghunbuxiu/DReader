package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.account.oauth.ThirdOAuth.QueryAccountListener;
import com.duokan.reader.domain.account.oauth.ThirdYinxiang;
import com.duokan.reader.domain.bookshelf.a;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.ef;
import com.duokan.reader.domain.document.g;
import com.duokan.reader.domain.document.n;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class rs implements QueryAccountListener {
    final /* synthetic */ c a;
    final /* synthetic */ n b;
    final /* synthetic */ ThirdYinxiang c;
    final /* synthetic */ qh d;

    rs(qh qhVar, c cVar, n nVar, ThirdYinxiang thirdYinxiang) {
        this.d = qhVar;
        this.a = cVar;
        this.b = nVar;
        this.c = thirdYinxiang;
    }

    public void onQueryAccountOk(String... strArr) {
        Comparator rtVar = new rt(this);
        a[] aq = this.a.aq();
        HashMap hashMap = new HashMap();
        List linkedList = new LinkedList();
        for (Object obj : aq) {
            if (obj instanceof ef) {
                linkedList.add(obj);
            }
        }
        Collections.sort(linkedList, rtVar);
        String H = this.a.H();
        if (linkedList.size() > 0) {
            g gVar = null;
            int i = 0;
            while (i < linkedList.size()) {
                g gVar2;
                a aVar = (a) linkedList.get(i);
                g b = this.b.h().b(aVar.d());
                if (b == null) {
                    gVar2 = gVar;
                } else if (b != gVar) {
                    hashMap.put(aVar, b);
                    gVar2 = b;
                } else {
                    gVar2 = gVar;
                }
                i++;
                gVar = gVar2;
            }
            this.c.output(H, this.c.makeTitle(this.a.aw(), this.a.B()), this.c.makeContent(this.a, hashMap, linkedList), false, new ru(this));
            return;
        }
        this.c.delete(H, new rv(this));
    }

    public void onQueryAccountError() {
    }
}
