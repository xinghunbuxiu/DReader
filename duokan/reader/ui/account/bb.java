package com.duokan.reader.ui.account;

import android.text.TextUtils;

class bb implements as {
    final /* synthetic */ bd a;
    final /* synthetic */ be b;
    final /* synthetic */ cz c;
    final /* synthetic */ ShareEntranceController d;

    bb(ShareEntranceController shareEntranceController, bd bdVar, be beVar, cz czVar) {
        this.d = shareEntranceController;
        this.a = bdVar;
        this.b = beVar;
        this.c = czVar;
    }

    public void onChoiced(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.equals("system")) {
                String str2 = "";
                if (this.a.d.length == 3) {
                    str2 = this.d.a(this.a.d);
                } else {
                    for (String str3 : this.a.d) {
                        str2 = str2 + str3;
                    }
                }
                this.d.a(str2);
                return;
            }
            this.d.a(str, this.a, this.b, this.c);
        }
    }
}
