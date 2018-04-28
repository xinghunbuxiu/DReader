package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;
import android.util.Pair;
import com.duokan.reader.common.C0611i;
import com.duokan.reader.domain.store.DkStoreCategory;
import com.duokan.reader.domain.store.DkStoreFictionCategory;
import com.duokan.reader.domain.store.DkStoreFictionDetail;
import org.json.JSONArray;
import org.json.JSONObject;

public class la {
    /* renamed from: a */
    public float f3507a = -1.0f;
    /* renamed from: b */
    public boolean f3508b = false;
    /* renamed from: c */
    public int f3509c = -1;
    /* renamed from: d */
    public long f3510d = 0;
    /* renamed from: e */
    public String f3511e = "";
    /* renamed from: f */
    public String f3512f = "";
    /* renamed from: g */
    public String f3513g = "";
    /* renamed from: h */
    public String f3514h = "";
    /* renamed from: i */
    public String f3515i = "";
    /* renamed from: j */
    public boolean f3516j = false;
    /* renamed from: k */
    public String f3517k = "";
    /* renamed from: l */
    public int f3518l = 2;
    /* renamed from: m */
    public boolean f3519m = true;
    /* renamed from: n */
    public Pair<String, Boolean> f3520n = null;

    public la(DkStoreFictionDetail dkStoreFictionDetail) {
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
        this.f3510d = dkStoreFictionDetail.getFiction().getUpdateDate().getTime();
        this.f3507a = dkStoreFictionDetail.getFiction().getSpecialPrice();
        this.f3508b = dkStoreFictionDetail.getFiction().getHasAds();
        this.f3509c = dkStoreFictionDetail.getFiction().getAdTime();
        this.f3511e = dkStoreFictionDetail.getCopyright();
        this.f3515i = dkStoreFictionDetail.getCopyrightId();
        this.f3513g = stringBuilder.toString();
        this.f3514h = stringBuilder2.toString();
        this.f3516j = dkStoreFictionDetail.getFiction().isFinish();
        this.f3517k = dkStoreFictionDetail.getFeeDescription();
        this.f3518l = dkStoreFictionDetail.getFeeMode();
        this.f3519m = dkStoreFictionDetail.allowFreeRead();
    }

    public la(String str) {
        int i = -1;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f3507a = (float) jSONObject.optDouble("entire_price", -1.0d);
                this.f3508b = jSONObject.optBoolean("has_ads", false);
                String str2 = "ad_time";
                if (this.f3508b) {
                    i = 5;
                }
                this.f3509c = jSONObject.optInt(str2, i);
                this.f3510d = jSONObject.optLong("update_time", 0);
                this.f3511e = jSONObject.optString("publisher", "");
                this.f3512f = jSONObject.optString("tag", "");
                this.f3513g = C0611i.m2793b(jSONObject, "category");
                this.f3514h = C0611i.m2793b(jSONObject, "category_id");
                this.f3515i = C0611i.m2793b(jSONObject, "publisher_id");
                this.f3516j = jSONObject.optBoolean("isFinished", false);
                this.f3517k = jSONObject.optString("fee_desc", "");
                this.f3518l = jSONObject.optInt("fee_mode", 2);
                this.f3519m = jSONObject.optBoolean("allow_free_read", true);
                if (jSONObject.has("auto_pay")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("auto_pay");
                    this.f3520n = new Pair(jSONArray.getString(0), Boolean.valueOf(jSONArray.getBoolean(1)));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("entire_price", (double) this.f3507a);
            jSONObject.put("has_ads", this.f3508b);
            jSONObject.put("ad_time", this.f3509c);
            jSONObject.put("update_time", this.f3510d);
            jSONObject.put("publisher", this.f3511e);
            jSONObject.put("tag", this.f3512f);
            jSONObject.put("publisher_id", this.f3515i);
            jSONObject.put("category", this.f3513g);
            jSONObject.put("category_id", this.f3514h);
            jSONObject.put("isFinished", this.f3516j);
            jSONObject.put("fee_desc", this.f3517k);
            jSONObject.put("fee_mode", this.f3518l);
            jSONObject.put("allow_free_read", this.f3519m);
            if (this.f3520n != null) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(this.f3520n.first);
                jSONArray.put(this.f3520n.second);
                jSONObject.put("auto_pay", jSONArray);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
