package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.account.UserAccount;
import com.duokan.reader.domain.account.i;

import org.json.JSONObject;

import java.util.concurrent.Callable;

class dc implements Callable {
    final /* synthetic */ PageController a;

    dc(PageController cgVar) {
        this.a = cgVar;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public String a() {
        UserAccount c = i.f().c();
        if (c == null || c.i()) {
            return new JSONObject().toString();
        }
        JSONObject a = c.s().a();
        a.remove("user_id");
        return a.toString();
    }
}
