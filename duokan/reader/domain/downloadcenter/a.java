package com.duokan.reader.domain.downloadcenter;

import com.duokan.reader.domain.bookshelf.iy;
import com.duokan.reader.domain.micloud.bi;

import org.json.JSONException;
import org.json.JSONObject;

public class a extends m {
    static final /* synthetic */ boolean j = (!a.class.desiredAssertionStatus());
    public long a = Long.MIN_VALUE;
    public String b = "";
    public String c = "";
    public String d = "";
    public String e = "";
    public String f = "";
    public String g = "";
    public String h = "";
    public iy i = null;

    public a(JSONObject jSONObject) {
        iy iyVar = null;
        super(jSONObject);
        this.a = jSONObject.optLong("book_item_id", Long.MIN_VALUE);
        this.b = jSONObject.optString("order_uuid");
        this.c = jSONObject.optString("book_uuid");
        this.d = jSONObject.optString("book_name");
        this.e = jSONObject.optString("book_revision");
        this.f = jSONObject.optString("author");
        this.g = jSONObject.optString("summary");
        this.h = jSONObject.optString("cover_uri");
        JSONObject optJSONObject = jSONObject.optJSONObject("cloud_private_book");
        if (optJSONObject != null) {
            iyVar = new iy(new bi(optJSONObject));
        }
        try {
            this.i = iyVar;
        } catch (JSONException e) {
        }
    }

    public static a a(JSONObject jSONObject) {
        if (j || jSONObject != null) {
            try {
                if (DownloadType.valueOf(jSONObject.getString("download_type")) != DownloadType.BOOK) {
                    return null;
                }
                return new a(jSONObject);
            } catch (Exception e) {
                return null;
            }
        }
        throw new AssertionError();
    }

    public DownloadType a() {
        return DownloadType.BOOK;
    }

    public String b() {
        if (this.i != null) {
            return this.i.b();
        }
        return this.d;
    }

    protected void b(JSONObject jSONObject) {
        super.b(jSONObject);
        try {
            jSONObject.put("book_item_id", this.a);
            jSONObject.put("order_uuid", this.b);
            jSONObject.put("book_uuid", this.c);
            jSONObject.put("book_name", this.d);
            jSONObject.put("book_revision", this.e);
            jSONObject.put("author", this.f);
            jSONObject.put("summary", this.g);
            jSONObject.put("cover_uri", this.h);
            if (this.i == null) {
                jSONObject.put("cloud_private_book", null);
            } else {
                jSONObject.put("cloud_private_book", this.i.a().a());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
