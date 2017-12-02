package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;

import com.duokan.reader.common.a;

import org.json.JSONObject;

class x extends a {
    final /* synthetic */ c b;
    private long c = 0;
    private String d = "";
    private String e = "";

    public x(c cVar, String str) {
        this.b = cVar;
        super(str);
    }

    protected void b() {
        if (!TextUtils.isEmpty(this.a)) {
            try {
                JSONObject jSONObject = new JSONObject(this.a);
                this.c = jSONObject.optLong("local_reading_info_version", 0);
                this.d = jSONObject.optString("local_reading_info_revision", this.b.r);
                this.e = jSONObject.optString("local_annotation_change_id", "0");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
