package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.payment.d;

import org.json.JSONObject;

class bs implements Runnable {
    final /* synthetic */ JSONObject a;
    final /* synthetic */ String b;
    final /* synthetic */ d c;
    final /* synthetic */ String d;
    final /* synthetic */ StorePageController e;

    bs(StorePageController storePageController, JSONObject jSONObject, String str, d dVar, String str2) {
        this.e = storePageController;
        this.a = jSONObject;
        this.b = str;
        this.c = dVar;
        this.d = str2;
    }

    public void run() {
        i.f().a(PersonalAccount.class, new bt(this));
    }
}
