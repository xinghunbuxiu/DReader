package com.duokan.reader.ui.general.web;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.duokan.reader.ui.general.ap;

class f extends ap {
    final /* synthetic */ String a;
    final /* synthetic */ e b;

    f(e eVar, Context context, String str) {
        this.b = eVar;
        this.a = str;
        super(context);
    }

    protected void onOk() {
        super.onOk();
        try {
            getActivity().startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel:" + this.a)));
        } catch (Exception e) {
        }
    }

    protected void onNo() {
        super.onNo();
    }
}
