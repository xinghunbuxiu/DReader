package com.duokan.reader.common.webservices.duokan;

import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.domain.account.ab;

import java.util.ArrayList;

public class t extends ad {
    public t(WebSession webSession, ab abVar) {
        super(webSession, abVar);
    }

    public void a(String str, int i) {
        a(b(true, p.i().n() + "/hs/static/_track_", "adbookshelf", i + ":" + str));
    }

    public void a(a aVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("showAnimation");
        arrayList.add(aVar.a);
        arrayList.add("setDrawable");
        arrayList.add(aVar.c);
        arrayList.add("OnDismissListener");
        arrayList.add(aVar.b);
        arrayList.add("v");
        arrayList.add(String.valueOf(aVar.d));
        arrayList.add("TaskHandler");
        arrayList.add(String.valueOf(aVar.e));
        arrayList.add("HttpLogger");
        arrayList.add(aVar.f);
        a(b(true, p.i().n() + "/hs/static/_track_", (String[]) arrayList.toArray(new String[0])));
    }

    public void e(String str) {
        a(b(true, p.i().n() + "/stat/_track_", "page", str));
    }

    public void a(String str, String... strArr) {
        a(b(true, p.i().n() + "/stat/" + str, strArr));
    }
}
