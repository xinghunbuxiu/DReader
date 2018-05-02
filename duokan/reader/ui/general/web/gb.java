package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.ag;

import org.json.JSONObject;

class gb implements ag {
    final /* synthetic */ fz a;

    gb(fz fzVar) {
        this.a = fzVar;
    }

    public void a(JSONObject jSONObject) {
        this.a.b.pageController.triggerEventOnCurrentUrl("feedCommit", jSONObject);
        this.a.b.pageController.mEditFeedController = null;
    }
}
