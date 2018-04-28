package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.async.work.C0523c;
import com.duokan.reader.domain.micloud.C1068i;
import java.util.Iterator;
import java.util.LinkedList;

class iy implements Runnable {
    /* renamed from: a */
    final /* synthetic */ it f3373a;

    iy(it itVar) {
        this.f3373a = itVar;
    }

    public void run() {
        jp b = this.f3373a.f3365i;
        if (b != null) {
            C1068i c1068i;
            LinkedList linkedList = new LinkedList();
            Iterator it = b.f3405b.m8112a().m2368c().iterator();
            while (it.hasNext()) {
                c1068i = (C1068i) it.next();
                if (c1068i.m2300o()) {
                    linkedList.add(c1068i);
                }
            }
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                c1068i = (C1068i) it2.next();
                if (c1068i.m2300o()) {
                    b.f3405b.m8112a().m2360a((C0523c) c1068i, true);
                }
            }
        }
    }
}
