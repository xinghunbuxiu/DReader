package com.duokan.reader.ui.personal;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.c.j;

import org.apache.http.protocol.HTTP;

class in implements OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ ih b;

    in(ih ihVar, String str) {
        this.b = ihVar;
        this.a = str;
    }

    public void onClick(View view) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(HTTP.PLAIN_TEXT_TYPE);
        intent.putExtra("android.intent.extra.TEXT", this.a);
        intent.setFlags(268435456);
        this.b.getContext().startActivity(Intent.createChooser(intent, this.b.getContext().getString(j.personal__personal_redeem_info_view__more_send_title)));
    }
}
