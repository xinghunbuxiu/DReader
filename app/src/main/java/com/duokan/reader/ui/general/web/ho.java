package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.reader.domain.store.DkStoreBookDetail;
import org.json.JSONObject;

class ho implements as {
    /* renamed from: a */
    final /* synthetic */ JSONObject f7938a;
    /* renamed from: b */
    final /* synthetic */ String f7939b;
    /* renamed from: c */
    final /* synthetic */ String f7940c;
    /* renamed from: d */
    final /* synthetic */ String f7941d;
    /* renamed from: e */
    final /* synthetic */ String f7942e;
    /* renamed from: f */
    final /* synthetic */ hn f7943f;

    ho(hn hnVar, JSONObject jSONObject, String str, String str2, String str3, String str4) {
        this.f7943f = hnVar;
        this.f7938a = jSONObject;
        this.f7939b = str;
        this.f7940c = str2;
        this.f7941d = str3;
        this.f7942e = str4;
    }

    /* renamed from: a */
    public void mo1831a() {
        DkStoreBookDetail dkStoreBookDetail;
        if (this.f7938a.has("detail")) {
            dkStoreBookDetail = new DkStoreBookDetail(this.f7938a.getJSONObject("detail"));
        } else {
            dkStoreBookDetail = null;
        }
        if (dkStoreBookDetail != null) {
            this.f7943f.f7937b.f7581b.downloadLinearBook(this.f7939b, this.f7940c, this.f7941d, dkStoreBookDetail, this.f7942e);
        } else {
            this.f7943f.f7937b.f7581b.queryBookDetail(this.f7941d, new hp(this), true);
        }
    }
}
