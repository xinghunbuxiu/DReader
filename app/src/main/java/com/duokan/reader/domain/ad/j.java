package com.duokan.reader.domain.ad;

import android.text.TextUtils;

import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.diagnostic.a;
import com.duokan.core.sys.t;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.d;
import com.mipay.sdk.Mipay;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class j extends WebSession {
    b a = new b();
    final /* synthetic */ g b;

    j(g gVar) {
        this.b = gVar;
    }

    protected void onSessionTry() {
        Map hashMap = new HashMap();
        hashMap.put("fictionId", this.b.f);
        JSONObject a = new d(this).a(execute(new q().a("http://api.ad.xiaomi.com/u/api").b(this.b.a).c("2.0").a(5).a(hashMap).a()));
        this.a.b = a.getInt(Mipay.KEY_CODE);
        if (this.a.b == 0) {
            JSONArray jSONArray = a.getJSONArray("adInfos");
            List arrayList = new ArrayList();
            Object obj = null;
            for (int i = 0; i < jSONArray.length(); i++) {
                e a2 = e.a(jSONArray.optJSONObject(i));
                if (a2 == null) {
                    obj = a2;
                } else {
                    e eVar;
                    switch (a2.g) {
                        case 4:
                            a2.w = a2.h == e.b ? this.b.l : this.b.i;
                            break;
                        case 6:
                            if (a2.v != null && !a2.v.isEmpty()) {
                                int f;
                                if (a2.h == e.b) {
                                    f = this.b.n;
                                } else {
                                    f = this.b.k;
                                }
                                a2.w = f;
                                break;
                            }
                            a2.w = this.b.o;
                            break;
                            break;
                        case 7:
                            a2.w = a2.h == e.b ? this.b.m : this.b.j;
                            break;
                        default:
                            eVar = a2;
                            continue;
                    }
                    if (a2.h != e.b) {
                        if (a2.h == e.a) {
                            arrayList.add(a2);
                        }
                        eVar = a2;
                    } else if (TextUtils.isEmpty(a2.r)) {
                        obj = null;
                    } else {
                        if (!TextUtils.isEmpty(a2.p) && this.b.r.a()) {
                            a2.p = this.b.r.a(a2.r);
                        }
                        if (x.a(this.b.e, a2.r)) {
                            eVar = a2;
                        } else {
                            arrayList.add(a2);
                            eVar = a2;
                        }
                    }
                }
            }
            if (arrayList.isEmpty() && obj != null) {
                arrayList.add(obj);
            }
            this.a.a = arrayList;
            return;
        }
        a.c().c(LogLevel.ERROR, "ads", String.format("fetching ads errorCode %d", new Object[]{Integer.valueOf(this.a.b)}));
    }

    protected boolean onSessionException(Exception exception, int i) {
        a.c().c(LogLevel.ERROR, "ads", "fetching ads exception");
        return super.onSessionException(exception, i);
    }

    protected void onSessionSucceeded() {
        t.a(new k(this));
    }

    protected void onSessionFailed() {
    }
}
