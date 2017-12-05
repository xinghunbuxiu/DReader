package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.account.i;

import org.json.JSONArray;

import java.util.List;
import java.util.concurrent.Callable;

class cs implements Callable {
    final /* synthetic */ PageController a;

    cs(PageController cgVar) {
        this.a = cgVar;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public String a() {
        JSONArray jSONArray = new JSONArray();
        List d = i.f().d();
        for (int i = 0; i < d.size(); i++) {
            jSONArray.put((String) d.get(i));
        }
        return jSONArray.toString();
    }
}
