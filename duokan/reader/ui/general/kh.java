package com.duokan.reader.ui.general;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

class kh extends ap {
    final /* synthetic */ String a;
    final /* synthetic */ kg b;

    kh(kg kgVar, Context context, String str) {
        this.b = kgVar;
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
