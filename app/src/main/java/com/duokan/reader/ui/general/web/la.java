package com.duokan.reader.ui.general.web;

import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.ui.general.be;

class la implements C0666x {
    /* renamed from: a */
    final /* synthetic */ TtsWebController f8130a;

    la(TtsWebController ttsWebController) {
        this.f8130a = ttsWebController;
    }

    public void onQueryAccountOk(C0672a c0672a) {
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        be.m10286a(this.f8130a.getContext(), C0258j.reading__tts_web_view__purchase_no_login, 0).show();
    }
}
