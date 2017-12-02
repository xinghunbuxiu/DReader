package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;

import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.common.webservices.duokan.c;
import com.duokan.reader.common.webservices.duokan.v;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

class ht extends c {
    final /* synthetic */ hi a;

    ht(hi hiVar) {
        this.a = hiVar;
    }

    protected void onSessionTry() {
        LinkedList linkedList = new LinkedList();
        for (c cVar : this.a.i()) {
            if (!(cVar.k() || cVar.i() == BookState.CLOUD_ONLY || cVar.p() != BookLimitType.NONE || !cVar.ai() || cVar.V())) {
                linkedList.add(cVar);
            }
        }
        ArrayList arrayList = new ArrayList(linkedList.size());
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            arrayList.add(((c) it.next()).H());
        }
        if (!linkedList.isEmpty()) {
            String[] strArr = (String[]) new v(this, null).a((String[]) arrayList.toArray(new String[0])).a;
            it = linkedList.iterator();
            int i = 0;
            while (it.hasNext()) {
                c cVar2 = (c) it.next();
                int i2 = i + 1;
                String str = strArr[i];
                if (!TextUtils.equals(cVar2.J(), str)) {
                    cVar2.g(str);
                    cVar2.aL();
                }
                i = i2;
            }
        }
    }

    protected void onSessionSucceeded() {
        this.a.f.setPrefLong(PrivatePref.BOOKSHELF, "last_revision_update_date", System.currentTimeMillis());
        this.a.A = null;
    }

    protected void onSessionFailed() {
        this.a.A = null;
    }
}
