package com.duokan.reader.ui.personal;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.p024c.C0258j;
import org.apache.http.protocol.HTTP;

class ja implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ String f8758a;
    /* renamed from: b */
    final /* synthetic */ iu f8759b;

    ja(iu iuVar, String str) {
        this.f8759b = iuVar;
        this.f8758a = str;
    }

    public void onClick(View view) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(HTTP.PLAIN_TEXT_TYPE);
        intent.putExtra("android.intent.extra.TEXT", this.f8758a);
        intent.setFlags(268435456);
        this.f8759b.getContext().startActivity(Intent.createChooser(intent, this.f8759b.getContext().getString(C0258j.personal__personal_redeem_info_view__more_send_title)));
    }
}
