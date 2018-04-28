package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ui.store.comment.C1482f;
import org.json.JSONObject;

class gf implements as {
    /* renamed from: a */
    final /* synthetic */ ge f7884a;

    gf(ge geVar) {
        this.f7884a = geVar;
    }

    /* renamed from: a */
    public void mo1831a() {
        JSONObject jSONObject = new JSONObject(this.f7884a.f7882a);
        int optInt = jSONObject.optInt("score", -1);
        String optString = jSONObject.optString("title", null);
        String optString2 = jSONObject.optString("titlePlaceholder");
        String optString3 = jSONObject.optString("content", null);
        String optString4 = jSONObject.optString("contentPlaceholder");
        boolean optBoolean = jSONObject.optBoolean("showTitle", true);
        boolean optBoolean2 = jSONObject.optBoolean("showScore", true);
        String optString5 = jSONObject.optString("header", this.f7884a.f7883b.f7581b.getContext().getResources().getString(C0258j.store_comment__publish_comment_view__title));
        String optString6 = jSONObject.optString("cancel", this.f7884a.f7883b.f7581b.getContext().getResources().getString(C0258j.general__shared__cancel));
        String optString7 = jSONObject.optString("send", this.f7884a.f7883b.f7581b.getContext().getResources().getString(C0258j.general__shared__send));
        int optInt2 = jSONObject.optInt("wordCount", -1);
        String optString8 = jSONObject.optString("wordCountErrorMsg", this.f7884a.f7883b.f7581b.getString(C0258j.store_comment__publish_comment_view__content_too_long));
        boolean optBoolean3 = jSONObject.optBoolean("instantClose", true);
        if (this.f7884a.f7883b.f7581b.mEditCommentDialog != null) {
            this.f7884a.f7883b.f7581b.mEditCommentDialog.dismiss();
        }
        this.f7884a.f7883b.f7581b.mEditCommentDialog = new C1482f(this.f7884a.f7883b.f7581b.getContext(), optInt, optString, optString2, optString3, optString4, optBoolean, optBoolean2, optString5, optString6, optString7, optInt2, optString8, optBoolean3, new gg(this), new gh(this));
        this.f7884a.f7883b.f7581b.mEditCommentDialog.show();
    }
}
