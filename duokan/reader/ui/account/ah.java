package com.duokan.reader.ui.account;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.c.g;

class ah implements OnClickListener {
    final /* synthetic */ z a;

    private ah(z zVar) {
        this.a = zVar;
    }

    public void onClick(View view) {
        int id = view.getId();
        String str = "";
        if (id == g.account_sina_ll) {
            str = "sina";
        } else if (id == g.account_yingxiang_ll) {
            str = "yinxiang";
        }
        if (TextUtils.equals("yinxiang", str)) {
            if (this.a.a.isBindAccessToken(this.a.getContext(), "yinxiang")) {
                this.a.a("yinxiang");
            } else if (this.a.a.isBindAccessToken(this.a.getContext(), "evernote")) {
                this.a.a("evernote");
            } else {
                this.a.b("yinxiang");
            }
        } else if (this.a.a.isBindAccessToken(this.a.getContext(), str)) {
            this.a.a(str);
        } else {
            this.a.b(str);
        }
    }
}
