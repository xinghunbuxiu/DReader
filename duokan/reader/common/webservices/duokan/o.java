package com.duokan.reader.common.webservices.duokan;

import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.cloud.DkUserReadBookManager.ReadBookInfo;
import com.mipay.sdk.Mipay;

import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

public class o extends ad {
    public o(WebSession webSession, ab abVar) {
        super(webSession, abVar);
    }

    public b e(String str) {
        JSONObject a = a(a(b(true, p.i().n() + "/store/v0/lib/id/" + str, new String[0])), HTTP.UTF_8);
        b bVar = new b();
        bVar.b = a.getInt(Mipay.KEY_RESULT);
        if (bVar.b != 0) {
            return bVar;
        }
        bVar.a = new String[2];
        ((String[]) bVar.a)[0] = a.getString("source");
        ((String[]) bVar.a)[1] = a.getString("id");
        return bVar;
    }

    public b a(long j, int i) {
        ArrayList arrayList = new ArrayList();
        if (j != 0) {
            arrayList.add("timestamp");
            arrayList.add(String.valueOf(j));
        }
        arrayList.add("count");
        arrayList.add(String.valueOf(i));
        JSONObject a = a(a(a(true, p.i().n() + "/sync/readstat/books", (String[]) arrayList.toArray(new String[0]))), HTTP.UTF_8);
        b bVar = new b();
        bVar.b = a.getInt(Mipay.KEY_RESULT);
        if (bVar.b == 0) {
            JSONArray jSONArray = a.getJSONArray("data");
            boolean optBoolean = a.optBoolean("more", false);
            bVar.a = a(jSONArray);
            bVar.c = String.valueOf(optBoolean);
        }
        return bVar;
    }

    private ReadBookInfo[] a(JSONArray jSONArray) {
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

    public b f(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("book_id");
        arrayList.add(str);
        JSONObject a = a(a(a(true, p.i().n() + "/sync/readstat/remove_book", (String[]) arrayList.toArray(new String[0]))), HTTP.UTF_8);
        b bVar = new b();
        bVar.b = a.getInt(Mipay.KEY_RESULT);
        return bVar;
    }

    public b g(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("source_id");
        arrayList.add(new y(str).a());
        JSONObject a = a(a(b(true, p.i().n() + "/store/v0/lib/exchange_id", (String[]) arrayList.toArray(new String[0]))), HTTP.UTF_8);
        b bVar = new b();
        bVar.b = a.getInt(Mipay.KEY_RESULT);
        if (bVar.b == 0) {
            bVar.a = a.getString("id");
        }
        return bVar;
    }

    public b a(int i, int i2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("start");
        arrayList.add(String.valueOf(i));
        arrayList.add("count");
        arrayList.add(String.valueOf(i2));
        arrayList.add("type");
        arrayList.add(String.valueOf(0));
        JSONObject a = a(a(a(true, p.i().n() + "/discover/user/fav/list_favs", (String[]) arrayList.toArray(new String[0]))), HTTP.UTF_8);
        b bVar = new b();
        bVar.b = a.getInt(Mipay.KEY_RESULT);
        if (bVar.b != 0) {
            return bVar;
        }
        int i3 = a.getInt("total");
        JSONArray jSONArray = new JSONArray();
        if (!(i3 == 0 || i2 == 0)) {
            jSONArray = a.getJSONArray("data");
        }
        bVar.a = b(jSONArray);
        bVar.c = String.valueOf(i3);
        return bVar;
    }

    private DkStoreBookInfo[] b(JSONArray jSONArray) {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                DkStoreBookInfo dkStoreBookInfo = new DkStoreBookInfo();
                dkStoreBookInfo.mBookUuid = String.valueOf(jSONObject.getLong("id"));
                dkStoreBookInfo.mSource = jSONObject.getInt("source");
                dkStoreBookInfo.mSourceId = i.b(jSONObject, "source_id");
                dkStoreBookInfo.mTitle = i.b(jSONObject, "title");
                dkStoreBookInfo.mSummary = i.b(jSONObject, "intro");
                dkStoreBookInfo.mCoverUri = i.b(jSONObject, "cover");
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

    public b a(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("preference");
        arrayList.add(String.valueOf(i));
        JSONObject a = a(a(a(true, p.i().n() + "/discover/user/preference/sync", (String[]) arrayList.toArray(new String[0]))), HTTP.UTF_8);
        b bVar = new b();
        bVar.b = a.getInt(Mipay.KEY_RESULT);
        if (bVar.b == 0) {
            bVar.a = Integer.valueOf(a.getInt("preference"));
        }
        return bVar;
    }

    public b b(int i, int i2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("preference");
        arrayList.add(String.valueOf(i));
        arrayList.add("old_preference");
        arrayList.add(String.valueOf(i2));
        JSONObject a = a(a(a(true, p.i().n() + "/discover/user/preference/update", (String[]) arrayList.toArray(new String[0]))), HTTP.UTF_8);
        b bVar = new b();
        bVar.b = a.getInt(Mipay.KEY_RESULT);
        return bVar;
    }

    public b b(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("type");
        arrayList.add(String.valueOf(i));
        arrayList.add("sandbox");
        arrayList.add(String.valueOf(p.i().k() ? 0 : 1));
        JSONObject a = a(a(a(true, p.i().n() + "/store/v0/award/list", (String[]) arrayList.toArray(new String[0]))), HTTP.UTF_8);
        b bVar = new b();
        bVar.b = a.getInt(Mipay.KEY_RESULT);
        if (bVar.b != 0) {
            return bVar;
        }
        bVar.a = Integer.valueOf(0);
        JSONArray optJSONArray = a.optJSONArray("data");
        if (optJSONArray == null) {
            return bVar;
        }
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            a = optJSONArray.getJSONObject(i2);
            int optInt = a.optInt("type", -1);
            if (a.optInt("expire_time") == 0) {
                optInt = a.optInt("total");
            } else if (((long) a.optInt("expire_time")) >= System.currentTimeMillis() / 1000 && optInt == i && this.f.a.equals(a.optString("user_id"))) {
                optInt = Math.max(0, a.optInt("total") - a.optInt("used"));
            } else {
                optInt = 0;
            }
            bVar.a = Integer.valueOf(((Integer) bVar.a).intValue() + optInt);
        }
        return bVar;
    }

    public b a() {
        JSONObject a = a(a(a(true, p.i().n() + "/checkin/v0/award_record", (String[]) new ArrayList().toArray(new String[0]))), HTTP.UTF_8);
        b bVar = new b();
        bVar.b = a.getInt(Mipay.KEY_RESULT);
        if (bVar.b == 0) {
            bVar.a = Integer.valueOf(a.optInt("total"));
        }
        return bVar;
    }

    public b b() {
        int i = 0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("coupon_type");
        arrayList.add("0");
        arrayList.add("status");
        arrayList.add("0");
        JSONObject a = a(a(a(true, p.i().n() + "/store/v0/coupon/list", (String[]) arrayList.toArray(new String[0]))), HTTP.UTF_8);
        b bVar = new b();
        bVar.b = a.getInt(Mipay.KEY_RESULT);
        if (bVar.b != 0) {
            return bVar;
        }
        bVar.a = Integer.valueOf(0);
        JSONArray optJSONArray = a.optJSONArray("items");
        if (optJSONArray == null) {
            return bVar;
        }
        while (i < optJSONArray.length()) {
            a = optJSONArray.getJSONObject(i);
            if (((long) a.optInt("expire_time")) >= System.currentTimeMillis() / 1000 && ((long) a.optInt("start_time")) <= System.currentTimeMillis() / 1000 && this.f.a.equals(String.valueOf(a.optInt("user_id")))) {
                bVar.a = Integer.valueOf(((Integer) bVar.a).intValue() + 1);
            }
            i++;
        }
        return bVar;
    }

    public b h(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("user_channel");
        arrayList.add(str);
        JSONObject a = a(a(a(true, p.i().n() + "/discover/user/channel/sync", (String[]) arrayList.toArray(new String[0]))), HTTP.UTF_8);
        b bVar = new b();
        bVar.b = a.getInt(Mipay.KEY_RESULT);
        if (bVar.b == 0) {
            bVar.a = a.getString("user_channel");
        }
        return bVar;
    }

    public b i(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("user_channel");
        arrayList.add(str);
        JSONObject a = a(a(a(true, p.i().n() + "/discover/user/channel/update", (String[]) arrayList.toArray(new String[0]))), HTTP.UTF_8);
        b bVar = new b();
        bVar.b = a.getInt(Mipay.KEY_RESULT);
        return bVar;
    }

    public b c() {
        JSONObject a = a(a(a(true, p.i().n() + "/rock/user/preference/getAllSortStackTraces", new String[0])), HTTP.UTF_8);
        b bVar = new b();
        bVar.b = a.getInt(Mipay.KEY_RESULT);
        if (bVar.b == 0) {
            bVar.a = a.optString("user_preference");
        }
        return bVar;
    }

    public b d() {
        JSONObject a = a(a(a(true, p.i().n() + "/discover/user/gender/sync", new String[0])), HTTP.UTF_8);
        b bVar = new b();
        bVar.b = a.getInt(Mipay.KEY_RESULT);
        if (bVar.b == 0) {
            bVar.a = Integer.valueOf(a.optInt("gender"));
        }
        return bVar;
    }

    public b c(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("gender");
        arrayList.add(String.valueOf(i));
        JSONObject a = a(a(a(true, p.i().n() + "/discover/user/gender/update", (String[]) arrayList.toArray(new String[0]))), HTTP.UTF_8);
        b bVar = new b();
        bVar.b = a.getInt(Mipay.KEY_RESULT);
        return bVar;
    }
}
