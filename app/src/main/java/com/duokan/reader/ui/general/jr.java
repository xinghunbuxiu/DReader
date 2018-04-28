package com.duokan.reader.ui.general;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

class jr extends ap {
    /* renamed from: a */
    final /* synthetic */ String f7455a;
    /* renamed from: b */
    final /* synthetic */ jq f7456b;

    jr(jq jqVar, Context context, String str) {
        this.f7456b = jqVar;
        this.f7455a = str;
        super(context);
    }

    protected void onOk() {
        super.onOk();
        try {
            getActivity().startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel:" + this.f7455a)));
        } catch (Exception e) {
        }
    }

    protected void onNo() {
        super.onNo();
    }
}
