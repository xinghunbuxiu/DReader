package com.duokan.reader.common.webservices.duokan;

import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.p040a.C0624a;
import com.duokan.reader.common.webservices.duokan.p040a.C0627d;
import com.duokan.reader.domain.account.C0672a;
import com.mipay.sdk.Mipay;
import java.util.ArrayList;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.common.webservices.duokan.i */
public class C0635i extends ac {
    public C0635i(WebSession webSession, C0672a c0672a) {
        super(webSession, c0672a);
    }

    /* renamed from: e */
    public C0621a<C0623g> m2874e(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("book_id");
        arrayList.add(str);
        JSONObject a = m547a(mo376a(m555a(true, m2871a() + "/discover/user/comment/get_book", (String[]) arrayList.toArray(new String[0]))));
        C0621a<C0623g> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        if (c0621a.b == 0) {
            a = a.optJSONObject("data");
            C0623g c0623g = new C0623g();
            if (a != null) {
                c0623g.f2065j.mUserId = a.optString("author");
                c0623g.f2065j.mNickName = a.optString("user_nick");
                c0623g.f2065j.mIconUrl = a.optString("user_icon");
                m561a(c0623g.f2065j, false);
                c0623g.f2064i = a.optString("title");
                c0623g.f2067l = a.optString("content");
                c0623g.f2069n = a.optInt("rate");
                c0623g.m2818a(a.optLong("create_time", System.currentTimeMillis() / 1000));
            }
            c0621a.f2058a = c0623g;
        }
        return c0621a;
    }

    /* renamed from: f */
    public C0621a<Integer> m2875f(String str) {
        JSONObject a = m547a(mo376a(m562b(false, m2871a() + "/store/v0/comment/book/" + str, "book_id", str, "start_index", "0", "count", "0")));
        C0621a<Integer> c0621a = new C0621a();
        c0621a.b = a.optInt(Mipay.KEY_RESULT);
        if (c0621a.b != 0) {
            c0621a.f2058a = Integer.valueOf(0);
        } else {
            c0621a.f2058a = Integer.valueOf(a.optInt("total"));
        }
        return c0621a;
    }

    /* renamed from: a */
    public C0621a<C0623g> m2872a(String str, int i, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("book_id");
        arrayList.add(str);
        arrayList.add("rate");
        arrayList.add(i + "");
        arrayList.add("title");
        arrayList.add(str2);
        arrayList.add("content");
        arrayList.add(str3);
        JSONObject a = m547a(mo376a(m555a(true, m2871a() + "/discover/user/comment/book/create", (String[]) arrayList.toArray(new String[0]))));
        C0621a<C0623g> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        c0621a.c = a.optString("msg");
        if (c0621a.b == 0 || c0621a.b == 410013) {
            C0623g c0623g = new C0623g();
            m561a(c0623g.f2065j, true);
            c0623g.f2069n = i;
            c0623g.f2067l = str3;
            c0623g.m2818a(System.currentTimeMillis() / 1000);
            c0621a.f2058a = c0623g;
        }
        return c0621a;
    }

    /* renamed from: a */
    public C0627d mo376a(C0624a c0624a) {
        c0624a.m2835a("accept", "application/json");
        return super.mo376a(c0624a);
    }

    /* renamed from: a */
    private String m2871a() {
        return C0641o.m2934i().m2987n();
    }
}
