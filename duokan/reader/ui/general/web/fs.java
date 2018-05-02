package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.reader.ui.store.comment.j;

import org.json.JSONObject;

class fs implements as {
    final /* synthetic */ fr a;

    fs(fr frVar) {
        this.a = frVar;
    }

    public void a() {
        JSONObject jSONObject = new JSONObject(this.a.a);
        String string = jSONObject.getString("msgid");
        jSONObject = jSONObject.getJSONObject("params");
        new j(this.a.b.pageController.getContext(), jSONObject.optInt("score", -1), jSONObject.optString("title", null), jSONObject.optString("titlePlaceholder"), jSONObject.optString("content", null), jSONObject.optString("contentPlaceholder"), jSONObject.optBoolean("showTitle", true), jSONObject.optBoolean("showScore", true), jSONObject.optString("header", this.a.b.pageController.getContext().getResources().getString(com.duokan.c.j.store_comment__publish_comment_view__title)), jSONObject.optString("cancel", this.a.b.pageController.getContext().getResources().getString(com.duokan.c.j.general__shared__cancel)), jSONObject.optString("send", this.a.b.pageController.getContext().getResources().getString(com.duokan.c.j.general__shared__send)), jSONObject.optInt("wordCount", -1), jSONObject.optString("wordCountErrorMsg", this.a.b.pageController.getString(com.duokan.c.j.store_comment__publish_comment_view__content_too_long)), new ft(this, string)).show();
    }
}
