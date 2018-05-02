package com.duokan.reader.ui.account;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;

import com.duokan.c.j;
import com.duokan.reader.ui.general.be;

class cu implements cy {
    final /* synthetic */ String a;
    final /* synthetic */ ch b;

    cu(ch chVar, String str) {
        this.b = chVar;
        this.a = str;
    }

    public void a(Bitmap bitmap, boolean z) {
        this.b.g.update(this.a, bitmap, this.b.e.b, new cv(this, bitmap, z));
    }

    public void a(String str) {
        CharSequence string;
        this.b.l.dismiss();
        Context activity = this.b.getActivity();
        if (TextUtils.isEmpty(str)) {
            string = this.b.getActivity().getString(j.sina_send_failed);
        }
        be.a(activity, string, 1).show();
        this.b.i.setEnabled(true);
    }
}
