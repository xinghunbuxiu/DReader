package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ui.store.comment.C1486j;
import org.json.JSONObject;

class gc implements as {
    /* renamed from: a */
    final /* synthetic */ gb f7878a;

    gc(gb gbVar) {
        this.f7878a = gbVar;
    }

    /* renamed from: a */
    public void mo1831a() {
        JSONObject jSONObject = new JSONObject(this.f7878a.f7876a);
        String string = jSONObject.getString("msgid");
        jSONObject = jSONObject.getJSONObject("params");
        new C1486j(this.f7878a.f7877b.f7581b.getContext(), jSONObject.optInt("score", -1), jSONObject.optString("title", null), jSONObject.optString("titlePlaceholder"), jSONObject.optString("content", null), jSONObject.optString("contentPlaceholder"), jSONObject.optBoolean("showTitle", true), jSONObject.optBoolean("showScore", true), jSONObject.optString("header", this.f7878a.f7877b.f7581b.getContext().getResources().getString(C0258j.store_comment__publish_comment_view__title)), jSONObject.optString("cancel", this.f7878a.f7877b.f7581b.getContext().getResources().getString(C0258j.general__shared__cancel)), jSONObject.optString("send", this.f7878a.f7877b.f7581b.getContext().getResources().getString(C0258j.general__shared__send)), jSONObject.optInt("wordCount", -1), jSONObject.optString("wordCountErrorMsg", this.f7878a.f7877b.f7581b.getString(C0258j.store_comment__publish_comment_view__content_too_long)), new gd(this, string)).show();
    }
}
