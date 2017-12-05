package com.duokan.reader.ui.general.web;

import com.duokan.c.j;
import com.duokan.core.sys.as;
import com.duokan.reader.ui.store.comment.f;

import org.json.JSONObject;

class fv implements as {
    final /* synthetic */ fu a;

    fv(fu fuVar) {
        this.a = fuVar;
    }

    public void a() {
        JSONObject jSONObject = new JSONObject(this.a.a);
        int optInt = jSONObject.optInt("score", -1);
        String optString = jSONObject.optString("title", null);
        String optString2 = jSONObject.optString("titlePlaceholder");
        String optString3 = jSONObject.optString("content", null);
        String optString4 = jSONObject.optString("contentPlaceholder");
        boolean optBoolean = jSONObject.optBoolean("showTitle", true);
        boolean optBoolean2 = jSONObject.optBoolean("showScore", true);
        String optString5 = jSONObject.optString("header", this.a.b.pageController.getContext().getResources().getString(j.store_comment__publish_comment_view__title));
        String optString6 = jSONObject.optString("cancel", this.a.b.pageController.getContext().getResources().getString(j.general__shared__cancel));
        String optString7 = jSONObject.optString("send", this.a.b.pageController.getContext().getResources().getString(j.general__shared__send));
        int optInt2 = jSONObject.optInt("wordCount", -1);
        String optString8 = jSONObject.optString("wordCountErrorMsg", this.a.b.pageController.getString(j.store_comment__publish_comment_view__content_too_long));
        boolean optBoolean3 = jSONObject.optBoolean("instantClose", true);
        if (this.a.b.pageController.mEditCommentDialog != null) {
            this.a.b.pageController.mEditCommentDialog.dismiss();
        }
        this.a.b.pageController.mEditCommentDialog = new f(this.a.b.pageController.getContext(), optInt, optString, optString2, optString3, optString4, optBoolean, optBoolean2, optString5, optString6, optString7, optInt2, optString8, optBoolean3, new fw(this), new fx(this));
        this.a.b.pageController.mEditCommentDialog.show();
    }
}
