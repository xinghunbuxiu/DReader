package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;
import android.util.Pair;

import com.duokan.reader.domain.store.DkStoreCategory;
import com.duokan.reader.domain.store.DkStoreFictionCategory;
import com.duokan.reader.domain.store.DkStoreFictionDetail;

import org.json.JSONArray;
import org.json.JSONObject;

public class ko {
    public float a = -1.0f;
    public boolean b = false;
    public int c = -1;
    public long d = 0;
    public String e = "";
    public String f = "";
    public String g = "";
    public String h = "";
    public String i = "";
    public boolean j = false;
    public String k = "";
    public int l = 2;
    public boolean m = true;
    public Pair n = null;

    public ko(DkStoreFictionDetail dkStoreFictionDetail) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        for (DkStoreFictionCategory dkStoreFictionCategory : dkStoreFictionDetail.getCategories()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(",");
                stringBuilder2.append(",");
            }
            stringBuilder.append(dkStoreFictionCategory.getLabel());
            stringBuilder2.append(dkStoreFictionCategory.getCategoryId());
            for (DkStoreCategory dkStoreCategory : dkStoreFictionCategory.getChildBookCategories()) {
                stringBuilder.append("-");
                stringBuilder2.append("-");
                stringBuilder.append(dkStoreCategory.getLabel());
                stringBuilder2.append(dkStoreCategory.getCategoryId());
            }
        }
        this.d = dkStoreFictionDetail.getFiction().getUpdateDate().getTime();
        this.a = dkStoreFictionDetail.getFiction().getSpecialPrice();
        this.b = dkStoreFictionDetail.getFiction().getHasAds();
        this.c = dkStoreFictionDetail.getFiction().getAdTime();
        this.e = dkStoreFictionDetail.getCopyright();
        this.i = dkStoreFictionDetail.getCopyrightId();
        this.g = stringBuilder.toString();
        this.h = stringBuilder2.toString();
        this.j = dkStoreFictionDetail.getFiction().isFinish();
        this.k = dkStoreFictionDetail.getFeeDescription();
        this.l = dkStoreFictionDetail.getFeeMode();
        this.m = dkStoreFictionDetail.allowFreeRead();
    }

    public ko(String str) {
        int i = -1;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.a = (float) jSONObject.optDouble("entire_price", -1.0d);
                this.b = jSONObject.optBoolean("has_ads", false);
                String str2 = "ad_time";
                if (this.b) {
                    i = 5;
                }
                this.c = jSONObject.optInt(str2, i);
                this.d = jSONObject.optLong("update_time", 0);
                this.e = jSONObject.optString("publisher", "");
                this.f = jSONObject.optString("tag", "");
                this.g = i.b(jSONObject, "category");
                this.h = i.b(jSONObject, "category_id");
                this.i = i.b(jSONObject, "publisher_id");
                this.j = jSONObject.optBoolean("isFinished", false);
                this.k = jSONObject.optString("fee_desc", "");
                this.l = jSONObject.optInt("fee_mode", 2);
                this.m = jSONObject.optBoolean("allow_free_read", true);
                if (jSONObject.has("auto_pay")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("auto_pay");
                    this.n = new Pair(jSONArray.getString(0), Boolean.valueOf(jSONArray.getBoolean(1)));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("entire_price", (double) this.a);
            jSONObject.put("has_ads", this.b);
            jSONObject.put("ad_time", this.c);
            jSONObject.put("update_time", this.d);
            jSONObject.put("publisher", this.e);
            jSONObject.put("tag", this.f);
            jSONObject.put("publisher_id", this.i);
            jSONObject.put("category", this.g);
            jSONObject.put("category_id", this.h);
            jSONObject.put("isFinished", this.j);
            jSONObject.put("fee_desc", this.k);
            jSONObject.put("fee_mode", this.l);
            jSONObject.put("allow_free_read", this.m);
            if (this.n != null) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(this.n.first);
                jSONArray.put(this.n.second);
                jSONObject.put("auto_pay", jSONArray);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
