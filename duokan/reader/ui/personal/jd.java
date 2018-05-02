package com.duokan.reader.ui.personal;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.DkPublic;

class jd implements OnClickListener {
    final /* synthetic */ it a;

    jd(it itVar) {
        this.a = itVar;
    }

    public void onClick(View view) {
        String str;
        if (DkPublic.isMiui()) {
            str = "http://app.xiaomi.com/comments?id=" + this.a.getContext().getPackageName() + "&back=true";
        } else {
            str = "market://details?id=" + this.a.getContext().getPackageName();
        }
        try {
            this.a.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
