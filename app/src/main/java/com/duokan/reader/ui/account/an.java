package com.duokan.reader.ui.account;

import android.text.TextUtils;

class an implements ae {
    /* renamed from: a */
    final /* synthetic */ ap f5795a;
    /* renamed from: b */
    final /* synthetic */ aq f5796b;
    /* renamed from: c */
    final /* synthetic */ cp f5797c;
    /* renamed from: d */
    final /* synthetic */ ShareEntranceController f5798d;

    an(ShareEntranceController shareEntranceController, ap apVar, aq aqVar, cp cpVar) {
        this.f5798d = shareEntranceController;
        this.f5795a = apVar;
        this.f5796b = aqVar;
        this.f5797c = cpVar;
    }

    public void onChoiced(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.equals("system")) {
                String str2 = "";
                if (this.f5795a.f5803d.length == 3) {
                    str2 = this.f5798d.m8817a(this.f5795a.f5803d);
                } else {
                    for (String str3 : this.f5795a.f5803d) {
                        str2 = str2 + str3;
                    }
                }
                this.f5798d.m8820a(str2);
                return;
            }
            this.f5798d.m8821a(str, this.f5795a, this.f5796b, this.f5797c);
        }
    }
}
