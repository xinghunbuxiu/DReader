package com.duokan.reader.common.webservices.duokan;

import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.a.d;
import com.duokan.reader.domain.account.a;
import com.mipay.sdk.Mipay;

import org.json.JSONObject;

import java.util.ArrayList;

public class i extends ad {
    public i(r rVar, a aVar) {
        super((WebSession) rVar, aVar);
    }

    public b e(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("book_id");
        arrayList.add(str);
        JSONObject a = a(a(a(true, a() + "/discover/user/comment/get_book", (String[]) arrayList.toArray(new String[0]))));
        b bVar = new b();
        bVar.b = a.getInt(Mipay.KEY_RESULT);
        if (bVar.b == 0) {
            a = a.optJSONObject("data");
            g gVar = new g();
            if (a != null) {
                gVar.j.mUserId = a.optString("author");
                gVar.j.mNickName = a.optString("user_nick");
                gVar.j.mIconUrl = a.optString("user_icon");
                a(gVar.j, false);
                gVar.i = a.optString("title");
                gVar.l = a.optString("content");
                gVar.n = a.optInt("rate");
                gVar.a(a.optLong("create_time", System.currentTimeMillis() / 1000));
            }
            bVar.a = gVar;
        }
        return bVar;
    }

    public b f(String str) {
        JSONObject a = a(a(b(false, a() + "/store/v0/comment/book/" + str, "book_id", str, "start_index", "0", "count", "0")));
        b bVar = new b();
        bVar.b = a.optInt(Mipay.KEY_RESULT);
        if (bVar.b != 0) {
            bVar.a = Integer.valueOf(0);
        } else {
            bVar.a = Integer.valueOf(a.optInt("total"));
        }
        return bVar;
    }

    public b a(String str, int i, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("book_id");
        arrayList.add(str);
        arrayList.add("rate");
        arrayList.add(i + "");
        arrayList.add("title");
        arrayList.add(str2);
        arrayList.add("content");
        arrayList.add(str3);
        JSONObject a = a(a(a(true, a() + "/discover/user/comment/book/create", (String[]) arrayList.toArray(new String[0]))));
        b bVar = new b();
        bVar.b = a.getInt(Mipay.KEY_RESULT);
        bVar.c = a.optString("msg");
        if (bVar.b == 0 || bVar.b == 410013) {
            g gVar = new g();
            a(gVar.j, true);
            gVar.n = i;
            gVar.l = str3;
            gVar.a(System.currentTimeMillis() / 1000);
            bVar.a = gVar;
        }
        return bVar;
    }

    public d a(com.duokan.reader.common.webservices.duokan.a.a aVar) {
        aVar.a("accept", "application/json");
        return super.a(aVar);
    }

    private String a() {
        return p.i().n();
    }
}
