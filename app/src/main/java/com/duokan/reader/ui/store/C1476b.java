package com.duokan.reader.ui.store;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.DkPublic;

/* renamed from: com.duokan.reader.ui.store.b */
class C1476b implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C1475a f11342a;

    C1476b(C1475a c1475a) {
        this.f11342a = c1475a;
    }

    public void onClick(View view) {
        String str;
        this.f11342a.requestDetach();
        if (DkPublic.isMiui()) {
            str = "http://app.xiaomi.com/comments?id=" + this.f11342a.getContext().getPackageName() + "&back=true";
        } else {
            str = "market://details?id=" + this.f11342a.getContext().getPackageName();
        }
        try {
            this.f11342a.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
