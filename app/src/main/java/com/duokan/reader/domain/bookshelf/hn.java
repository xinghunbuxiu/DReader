package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0647u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

class hn extends WebSession {
    /* renamed from: a */
    final /* synthetic */ hc f3311a;

    hn(hc hcVar, C0657i c0657i) {
        this.f3311a = hcVar;
        super(c0657i);
    }

    protected void onSessionTry() {
        LinkedList linkedList = new LinkedList();
        for (C0800c c0800c : this.f3311a.m3934i()) {
            if (!(c0800c.mo1038k() || c0800c.m4233i() == BookState.CLOUD_ONLY || c0800c.m4243p() != BookLimitType.NONE || !c0800c.ak() || c0800c.m4171X())) {
                linkedList.add(c0800c);
            }
        }
        ArrayList arrayList = new ArrayList(linkedList.size());
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            arrayList.add(((C0800c) it.next()).m4156I());
        }
        if (!linkedList.isEmpty()) {
            String[] strArr = (String[]) new C0647u(this, null).m3037a((String[]) arrayList.toArray(new String[0])).f2058a;
            it = linkedList.iterator();
            int i = 0;
            while (it.hasNext()) {
                C0800c c0800c2 = (C0800c) it.next();
                int i2 = i + 1;
                String str = strArr[i];
                if (!TextUtils.equals(c0800c2.m4158K(), str)) {
                    c0800c2.m4230g(str);
                    c0800c2.aN();
                }
                i = i2;
            }
        }
    }

    protected void onSessionSucceeded() {
        this.f3311a.f2742f.setPrefLong(PrivatePref.BOOKSHELF, "last_revision_update_date", System.currentTimeMillis());
        this.f3311a.f2730A = null;
    }

    protected void onSessionFailed() {
        this.f3311a.f2730A = null;
    }
}
