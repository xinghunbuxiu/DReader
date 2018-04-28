package com.duokan.reader.ui.general.web;

import android.text.TextUtils;
import com.duokan.core.sys.as;
import org.json.JSONObject;

class dt implements as {
    /* renamed from: a */
    final /* synthetic */ String f7745a;
    /* renamed from: b */
    final /* synthetic */ ci f7746b;

    dt(ci ciVar, String str) {
        this.f7746b = ciVar;
        this.f7745a = str;
    }

    /* renamed from: a */
    public void mo1831a() {
        String string = new JSONObject(this.f7745a).getString("params");
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
                    this.f7746b.m11014d(this.f7745a);
                    return;
                case 1:
                    this.f7746b.m11010b(this.f7745a);
                    return;
                case 2:
                    this.f7746b.m11007a(this.f7745a);
                    return;
                default:
                    this.f7746b.m11012c(this.f7745a);
                    return;
            }
        }
    }
}
