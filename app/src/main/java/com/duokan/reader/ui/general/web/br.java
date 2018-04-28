package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.payment.C1090d;
import org.json.JSONObject;

class br implements Runnable {
    /* renamed from: a */
    final /* synthetic */ JSONObject f7641a;
    /* renamed from: b */
    final /* synthetic */ String f7642b;
    /* renamed from: c */
    final /* synthetic */ C1090d f7643c;
    /* renamed from: d */
    final /* synthetic */ String f7644d;
    /* renamed from: e */
    final /* synthetic */ StorePageController f7645e;

    br(StorePageController storePageController, JSONObject jSONObject, String str, C1090d c1090d, String str2) {
        this.f7645e = storePageController;
        this.f7641a = jSONObject;
        this.f7642b = str;
        this.f7643c = c1090d;
        this.f7644d = str2;
    }

    public void run() {
        C0709k.m3476a().m3497a(PersonalAccount.class, new bs(this));
    }
}
