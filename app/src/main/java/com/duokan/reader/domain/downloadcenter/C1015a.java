package com.duokan.reader.domain.downloadcenter;

import com.duokan.reader.domain.bookshelf.is;
import com.duokan.reader.domain.micloud.bi;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.downloadcenter.a */
public class C1015a extends C1014m {
    /* renamed from: j */
    static final /* synthetic */ boolean f5037j = (!C1015a.class.desiredAssertionStatus());
    /* renamed from: a */
    public long f5038a = Long.MIN_VALUE;
    /* renamed from: b */
    public String f5039b = "";
    /* renamed from: c */
    public String f5040c = "";
    /* renamed from: d */
    public String f5041d = "";
    /* renamed from: e */
    public String f5042e = "";
    /* renamed from: f */
    public String f5043f = "";
    /* renamed from: g */
    public String f5044g = "";
    /* renamed from: h */
    public String f5045h = "";
    /* renamed from: i */
    public is f5046i = null;

    public C1015a(JSONObject jSONObject) {
        is isVar = null;
        super(jSONObject);
        this.f5038a = jSONObject.optLong("book_item_id", Long.MIN_VALUE);
        this.f5039b = jSONObject.optString("order_uuid");
        this.f5040c = jSONObject.optString("book_uuid");
        this.f5041d = jSONObject.optString("book_name");
        this.f5042e = jSONObject.optString("book_revision");
        this.f5043f = jSONObject.optString("author");
        this.f5044g = jSONObject.optString("summary");
        this.f5045h = jSONObject.optString("cover_uri");
        JSONObject optJSONObject = jSONObject.optJSONObject("cloud_private_book");
        if (optJSONObject != null) {
            isVar = new is(new bi(optJSONObject));
        }
        try {
            this.f5046i = isVar;
        } catch (JSONException e) {
        }
    }

    /* renamed from: a */
    public static C1015a m7815a(JSONObject jSONObject) {
        if (f5037j || jSONObject != null) {
            try {
                if (DownloadType.valueOf(jSONObject.getString("download_type")) != DownloadType.BOOK) {
                    return null;
                }
                return new C1015a(jSONObject);
            } catch (Exception e) {
                return null;
            }
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public DownloadType mo1474a() {
        return DownloadType.BOOK;
    }

    /* renamed from: b */
    public String mo1475b() {
        if (this.f5046i != null) {
            return this.f5046i.m4682b();
        }
        return this.f5041d;
    }

    /* renamed from: b */
    protected void mo1476b(JSONObject jSONObject) {
        super.mo1476b(jSONObject);
        try {
            jSONObject.put("book_item_id", this.f5038a);
            jSONObject.put("order_uuid", this.f5039b);
            jSONObject.put("book_uuid", this.f5040c);
            jSONObject.put("book_name", this.f5041d);
            jSONObject.put("book_revision", this.f5042e);
            jSONObject.put("author", this.f5043f);
            jSONObject.put("summary", this.f5044g);
            jSONObject.put("cover_uri", this.f5045h);
            if (this.f5046i == null) {
                jSONObject.put("cloud_private_book", null);
            } else {
                jSONObject.put("cloud_private_book", this.f5046i.m4680a().m8150a());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
