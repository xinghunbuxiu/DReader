package com.duokan.reader.ui.general.web;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.duokan.reader.ui.general.ap;

/* renamed from: com.duokan.reader.ui.general.web.f */
class C1358f extends ap {
    /* renamed from: a */
    final /* synthetic */ String f7816a;
    /* renamed from: b */
    final /* synthetic */ C1357e f7817b;

    C1358f(C1357e c1357e, Context context, String str) {
        this.f7817b = c1357e;
        this.f7816a = str;
        super(context);
    }

    protected void onOk() {
        super.onOk();
        try {
            getActivity().startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel:" + this.f7816a)));
        } catch (Exception e) {
        }
    }

    protected void onNo() {
        super.onNo();
    }
}
