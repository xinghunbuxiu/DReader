package com.duokan.reader.ui.general.web;

import android.text.TextUtils;

import com.duokan.core.sys.as;

import org.json.JSONObject;

class dn implements as {
    final /* synthetic */ String a;
    final /* synthetic */ cg b;

    dn(cg cgVar, String str) {
        this.b = cgVar;
        this.a = str;
    }

    public void a() {
        String string = new JSONObject(this.a).getString("params");
        if (!TextUtils.isEmpty(string)) {
            Object obj = -1;
            switch (string.hashCode()) {
                case -86921496:
                    if (string.equals("MI_LOCAL")) {
                        obj = 3;
                        break;
                    }
                    break;
                case 2460:
                    if (string.equals("MI")) {
                        obj = 2;
                        break;
                    }
                    break;
                case 588970091:
                    if (string.equals("WX_LOGIN")) {
                        obj = null;
                        break;
                    }
                    break;
                case 1810534962:
                    if (string.equals("MI_SYSTEM")) {
                        obj = 1;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case null:
                    this.b.d(this.a);
                    return;
                case 1:
                    this.b.b(this.a);
                    return;
                case 2:
                    this.b.a(this.a);
                    return;
                default:
                    this.b.c(this.a);
                    return;
            }
        }
    }
}
