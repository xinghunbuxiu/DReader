package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;
import com.duokan.reader.common.C0516a;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.bookshelf.x */
class C0838x extends C0516a {
    /* renamed from: b */
    final /* synthetic */ C0800c f3584b;
    /* renamed from: c */
    private long f3585c = 0;
    /* renamed from: d */
    private String f3586d = "";
    /* renamed from: e */
    private String f3587e = "";

    public C0838x(C0800c c0800c, String str) {
        this.f3584b = c0800c;
        super(str);
    }

    /* renamed from: b */
    protected void mo1137b() {
        if (!TextUtils.isEmpty(this.a)) {
            try {
                JSONObject jSONObject = new JSONObject(this.a);
                this.f3585c = jSONObject.optLong("local_reading_info_version", 0);
                this.f3586d = jSONObject.optString("local_reading_info_revision", this.f3584b.f2921r);
                this.f3587e = jSONObject.optString("local_annotation_change_id", "0");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
