package com.duokan.reader.ui.personal;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.DkPublic;

class jr implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ jg f8790a;

    jr(jg jgVar) {
        this.f8790a = jgVar;
    }

    public void onClick(View view) {
        String str;
        if (DkPublic.isMiui()) {
            str = "http://app.xiaomi.com/comments?id=" + this.f8790a.getContext().getPackageName() + "&back=true";
        } else {
            str = "market://details?id=" + this.f8790a.getContext().getPackageName();
        }
        try {
            this.f8790a.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
