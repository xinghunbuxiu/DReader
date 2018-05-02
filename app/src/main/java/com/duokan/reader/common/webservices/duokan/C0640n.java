package com.duokan.reader.common.webservices.duokan;

import com.duokan.reader.common.C0611i;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.p040a.C0624a;
import com.duokan.reader.domain.account.al;
import com.duokan.reader.domain.cloud.DkUserReadBookManager.ReadBookInfo;
import com.mipay.sdk.Mipay;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.common.webservices.duokan.n */
public class C0640n extends ac {
    public C0640n(WebSession webSession, al alVar) {
        super(webSession, alVar);
    }

    /* renamed from: a */
    public C0621a<String> m2915a(String str, String str2) {
        C0624a b;
        if (str.equals(HttpGet.METHOD_NAME)) {
            b = m562b(true, str2, new String[0]);
        } else {
            b = m555a(true, str2, new String[0]);
        }
        JSONObject a = m548a(mo376a(b), HTTP.UTF_8);
        C0621a<String> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        if (c0621a.b == 0) {
            c0621a.f2058a = a.toString();
            c0621a.c = a.getString("msg");
        }
        return c0621a;
    }

    /* renamed from: e */
    public C0621a<String[]> m2922e(String str) {
        JSONObject a = m548a(mo376a(m562b(true, C0641o.m2934i().m2987n() + "/store/v0/lib/id/" + str, new String[0])), HTTP.UTF_8);
        C0621a<String[]> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        if (c0621a.b != 0) {
            return c0621a;
        }
        c0621a.f2058a = new String[2];
        ((String[]) c0621a.f2058a)[0] = a.getString("source");
        ((String[]) c0621a.f2058a)[1] = a.getString("id");
        return c0621a;
    }

    /* renamed from: a */
    public C0621a<ReadBookInfo[]> m2914a(long j, int i) {
        ArrayList arrayList = new ArrayList();
        if (j != 0) {
            arrayList.add("timestamp");
            arrayList.add(String.valueOf(j));
        }
        arrayList.add("count");
        arrayList.add(String.valueOf(i));
        JSONObject a = m548a(mo376a(m555a(true, C0641o.m2934i().m2987n() + "/sync/readstat/books", (String[]) arrayList.toArray(new String[0]))), HTTP.UTF_8);
        C0621a<ReadBookInfo[]> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        if (c0621a.b == 0) {
            JSONArray jSONArray = a.getJSONArray("data");
            boolean optBoolean = a.optBoolean("more", false);
            c0621a.f2058a = m2908a(jSONArray);
            c0621a.c = String.valueOf(optBoolean);
        }
        return c0621a;
    }

    /* renamed from: a */
    private ReadBookInfo[] m2908a(JSONArray jSONArray) {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                ReadBookInfo readBookInfo = new ReadBookInfo();
                readBookInfo.mBookUuid = jSONObject.optString("id");
                Calendar instance = Calendar.getInstance();
                instance.setTime(new Date(jSONObject.getLong("read_time") * 1000));
                readBookInfo.mReadTime = instance;
                readBookInfo.mCoverUri = jSONObject.optString("cover");
                readBookInfo.mTitle = jSONObject.optString("title");
                JSONArray optJSONArray = jSONObject.optJSONArray("role");
                LinkedList linkedList2 = new LinkedList();
                if (optJSONArray != null) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        linkedList2.add(optJSONArray.getJSONArray(i2).optString(1));
                    }
                }
                readBookInfo.mAuthors = (String[]) linkedList2.toArray(new String[0]);
                readBookInfo.mComment = jSONObject.optString("content");
                readBookInfo.mRate = jSONObject.optInt("rate", 0);
                linkedList.add(readBookInfo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return (ReadBookInfo[]) linkedList.toArray(new ReadBookInfo[0]);
    }

    /* renamed from: f */
    public C0621a<Void> m2923f(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("book_id");
        arrayList.add(str);
        JSONObject a = m548a(mo376a(m555a(true, C0641o.m2934i().m2987n() + "/sync/readstat/remove_book", (String[]) arrayList.toArray(new String[0]))), HTTP.UTF_8);
        C0621a<Void> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        return c0621a;
    }

    /* renamed from: g */
    public C0621a<String> m2924g(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("source_id");
        arrayList.add(new C0650x(str).m3046a());
        JSONObject a = m548a(mo376a(m562b(true, C0641o.m2934i().m2987n() + "/store/v0/lib/exchange_id", (String[]) arrayList.toArray(new String[0]))), HTTP.UTF_8);
        C0621a<String> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        if (c0621a.b == 0) {
            c0621a.f2058a = a.getString("id");
        }
        return c0621a;
    }

    /* renamed from: a */
    public C0621a<DkStoreBookInfo[]> m2912a(int i, int i2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("start");
        arrayList.add(String.valueOf(i));
        arrayList.add("count");
        arrayList.add(String.valueOf(i2));
        arrayList.add("type");
        arrayList.add(String.valueOf(0));
        JSONObject a = m548a(mo376a(m555a(true, C0641o.m2934i().m2987n() + "/discover/user/fav/list_favs", (String[]) arrayList.toArray(new String[0]))), HTTP.UTF_8);
        C0621a<DkStoreBookInfo[]> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        if (c0621a.b != 0) {
            return c0621a;
        }
        int i3 = a.getInt("total");
        JSONArray jSONArray = new JSONArray();
        if (!(i3 == 0 || i2 == 0)) {
            jSONArray = a.getJSONArray("data");
        }
        c0621a.f2058a = m2909b(jSONArray);
        c0621a.c = String.valueOf(i3);
        return c0621a;
    }

    /* renamed from: b */
    private DkStoreBookInfo[] m2909b(JSONArray jSONArray) {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                DkStoreBookInfo dkStoreBookInfo = new DkStoreBookInfo();
                dkStoreBookInfo.mBookUuid = String.valueOf(jSONObject.getLong("id"));
                dkStoreBookInfo.mSource = jSONObject.getInt("source");
                dkStoreBookInfo.mSourceId = C0611i.m2793b(jSONObject, "source_id");
                dkStoreBookInfo.mTitle = C0611i.m2793b(jSONObject, "title");
                dkStoreBookInfo.mSummary = C0611i.m2793b(jSONObject, "intro");
                dkStoreBookInfo.mCoverUri = C0611i.m2793b(jSONObject, "cover");
                dkStoreBookInfo.mScoreCount = jSONObject.getInt("rate_count");
                dkStoreBookInfo.mTime = jSONObject.getLong("fav_time");
                JSONArray optJSONArray = jSONObject.optJSONArray("role");
                LinkedList linkedList2 = new LinkedList();
                if (optJSONArray != null) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        linkedList2.add(optJSONArray.getJSONArray(i2).getString(1));
                    }
                }
                dkStoreBookInfo.mAuthors = (String[]) linkedList2.toArray(new String[0]);
                linkedList.add(dkStoreBookInfo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return (DkStoreBookInfo[]) linkedList.toArray(new DkStoreBookInfo[0]);
    }

    /* renamed from: a */
    public C0621a<Integer> m2911a(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("preference");
        arrayList.add(String.valueOf(i));
        JSONObject a = m548a(mo376a(m555a(true, C0641o.m2934i().m2987n() + "/discover/user/preference/sync", (String[]) arrayList.toArray(new String[0]))), HTTP.UTF_8);
        C0621a<Integer> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        if (c0621a.b == 0) {
            c0621a.f2058a = Integer.valueOf(a.getInt("preference"));
        }
        return c0621a;
    }

    /* renamed from: b */
    public C0621a<Void> m2918b(int i, int i2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("preference");
        arrayList.add(String.valueOf(i));
        arrayList.add("old_preference");
        arrayList.add(String.valueOf(i2));
        JSONObject a = m548a(mo376a(m555a(true, C0641o.m2934i().m2987n() + "/discover/user/preference/update", (String[]) arrayList.toArray(new String[0]))), HTTP.UTF_8);
        C0621a<Void> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        return c0621a;
    }

    /* renamed from: b */
    public C0621a<Integer> m2917b(int i) {
        return m2913a(i, new ArrayList());
    }

    /* renamed from: a */
    public C0621a<Integer> m2913a(int i, List<Integer> list) {
        int i2 = 0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("sandbox");
        arrayList.add(String.valueOf(C0641o.m2934i().m2984k() ? 0 : 1));
        if (i >= 0) {
            arrayList.add("type");
            arrayList.add(String.valueOf(i));
        }
        arrayList.add("reduced");
        arrayList.add(String.valueOf(true));
        JSONObject a = m548a(mo376a(m555a(true, C0641o.m2934i().m2987n() + "/store/v0/award/list", (String[]) arrayList.toArray(new String[0]))), HTTP.UTF_8);
        C0621a<Integer> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        if (c0621a.b != 0) {
            return c0621a;
        }
        c0621a.f2058a = Integer.valueOf(0);
        JSONArray optJSONArray = a.optJSONArray("data");
        if (optJSONArray == null) {
            return c0621a;
        }
        while (i2 < optJSONArray.length()) {
            JSONObject jSONObject = optJSONArray.getJSONObject(i2);
            if (!list.contains(Integer.valueOf(jSONObject.optInt("type", -1)))) {
                c0621a.f2058a = Integer.valueOf(((Integer) c0621a.f2058a).intValue() + jSONObject.optInt("total"));
            }
            i2++;
        }
        return c0621a;
    }

    /* renamed from: a */
    public C0621a<Integer> m2910a() {
        JSONObject a = m548a(mo376a(m555a(true, C0641o.m2934i().m2987n() + "/checkin/v0/award_record", (String[]) new ArrayList().toArray(new String[0]))), HTTP.UTF_8);
        C0621a<Integer> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        if (c0621a.b == 0) {
            c0621a.f2058a = Integer.valueOf(a.optInt("total"));
        }
        return c0621a;
    }

    /* renamed from: b */
    public C0621a<Integer> m2916b() {
        int i = 0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("coupon_type");
        arrayList.add("0");
        arrayList.add("status");
        arrayList.add("0");
        JSONObject a = m548a(mo376a(m555a(true, C0641o.m2934i().m2987n() + "/store/v0/coupon/list", (String[]) arrayList.toArray(new String[0]))), HTTP.UTF_8);
        C0621a<Integer> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        if (c0621a.b != 0) {
            return c0621a;
        }
        c0621a.f2058a = Integer.valueOf(0);
        JSONArray optJSONArray = a.optJSONArray("items");
        if (optJSONArray == null) {
            return c0621a;
        }
        while (i < optJSONArray.length()) {
            a = optJSONArray.getJSONObject(i);
            if (((long) a.optInt("expire_time")) >= System.currentTimeMillis() / 1000 && ((long) a.optInt("start_time")) <= System.currentTimeMillis() / 1000 && this.f.f2360a.equals(String.valueOf(a.optInt("user_id")))) {
                c0621a.f2058a = Integer.valueOf(((Integer) c0621a.f2058a).intValue() + 1);
            }
            i++;
        }
        return c0621a;
    }

    /* renamed from: h */
    public C0621a<String> m2925h(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("user_channel");
        arrayList.add(str);
        JSONObject a = m548a(mo376a(m555a(true, C0641o.m2934i().m2987n() + "/discover/user/channel/sync", (String[]) arrayList.toArray(new String[0]))), HTTP.UTF_8);
        C0621a<String> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        if (c0621a.b == 0) {
            c0621a.f2058a = a.getString("user_channel");
        }
        return c0621a;
    }

    /* renamed from: i */
    public C0621a<Void> m2926i(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("user_channel");
        arrayList.add(str);
        JSONObject a = m548a(mo376a(m555a(true, C0641o.m2934i().m2987n() + "/discover/user/channel/update", (String[]) arrayList.toArray(new String[0]))), HTTP.UTF_8);
        C0621a<Void> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        return c0621a;
    }

    /* renamed from: c */
    public C0621a<String> m2919c() {
        JSONObject a = m548a(mo376a(m555a(true, C0641o.m2934i().m2987n() + "/rock/user/preference/get", new String[0])), HTTP.UTF_8);
        C0621a<String> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        if (c0621a.b == 0) {
            c0621a.f2058a = a.optString("user_preference");
        }
        return c0621a;
    }

    /* renamed from: d */
    public C0621a<Integer> m2921d() {
        JSONObject a = m548a(mo376a(m555a(true, C0641o.m2934i().m2987n() + "/discover/user/gender/sync", new String[0])), HTTP.UTF_8);
        C0621a<Integer> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        if (c0621a.b == 0) {
            c0621a.f2058a = Integer.valueOf(a.optInt("gender"));
        }
        return c0621a;
    }

    /* renamed from: c */
    public C0621a<Void> m2920c(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("gender");
        arrayList.add(String.valueOf(i));
        JSONObject a = m548a(mo376a(m555a(true, C0641o.m2934i().m2987n() + "/discover/user/gender/update", (String[]) arrayList.toArray(new String[0]))), HTTP.UTF_8);
        C0621a<Void> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        return c0621a;
    }
}
