package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.account.oauth.ThirdOAuth.QueryAccountListener;
import com.duokan.reader.domain.account.oauth.ThirdYinxiang;
import com.duokan.reader.domain.bookshelf.C0798a;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ea;
import com.duokan.reader.domain.document.C0901g;
import com.duokan.reader.domain.document.C0903n;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class sd implements QueryAccountListener {
    /* renamed from: a */
    final /* synthetic */ C0800c f10932a;
    /* renamed from: b */
    final /* synthetic */ C0903n f10933b;
    /* renamed from: c */
    final /* synthetic */ ThirdYinxiang f10934c;
    /* renamed from: d */
    final /* synthetic */ qr f10935d;

    sd(qr qrVar, C0800c c0800c, C0903n c0903n, ThirdYinxiang thirdYinxiang) {
        this.f10935d = qrVar;
        this.f10932a = c0800c;
        this.f10933b = c0903n;
        this.f10934c = thirdYinxiang;
    }

    public void onQueryAccountOk(String... strArr) {
        Comparator seVar = new se(this);
        C0798a[] as = this.f10932a.as();
        HashMap hashMap = new HashMap();
        List linkedList = new LinkedList();
        for (Object obj : as) {
            if (obj instanceof ea) {
                linkedList.add(obj);
            }
        }
        Collections.sort(linkedList, seVar);
        String I = this.f10932a.getId();
        if (linkedList.size() > 0) {
            C0901g c0901g = null;
            int i = 0;
            while (i < linkedList.size()) {
                C0901g c0901g2;
                C0798a c0798a = (C0798a) linkedList.get(i);
                C0901g b = this.f10933b.mo1240h().mo1267b(c0798a.m3726d());
                if (b == null) {
                    c0901g2 = c0901g;
                } else if (b != c0901g) {
                    hashMap.put(c0798a, b);
                    c0901g2 = b;
                } else {
                    c0901g2 = c0901g;
                }
                i++;
                c0901g = c0901g2;
            }
            this.f10934c.output(I, this.f10934c.makeTitle(this.f10932a.ay(), this.f10932a.m4150C()), this.f10934c.makeContent(this.f10932a, hashMap, linkedList), false, new sf(this));
            return;
        }
        this.f10934c.delete(I, new sg(this));
    }

    public void onQueryAccountError() {
    }
}
