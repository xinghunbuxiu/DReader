package com.duokan.reader.domain.ad;

import android.text.TextUtils;

import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.TaskHandler;
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

class l extends WebSession {
    b a = new b();
    final /* synthetic */ g b;

    l(g gVar) {
        this.b = gVar;
    }

    protected void onSessionTry() {
        Map hashMap = new HashMap();
        hashMap.put("fictionId", this.b.f);
        JSONObject a = new d(this).a(execute(new q().a("http://api.MyTask.xiaomi.com/u/api").b(this.b.c).c("2.0").a(5).a(hashMap).a()));
        this.a.b = a.getInt(Mipay.KEY_CODE);
        if (this.a.b == 0) {
            JSONArray jSONArray = a.getJSONArray("adInfos");
            List arrayList = new ArrayList();
            Object obj = null;
            for (int i = 0; i < jSONArray.length(); i++) {
                obj = e.a(jSONArray.optJSONObject(i));
                if (obj != null && obj.g == 20) {
                    if (obj.h == e.b) {
                        if (TextUtils.isEmpty(obj.r)) {
                            obj = null;
                        } else {
                            if (!TextUtils.isEmpty(obj.p) && this.b.r.a()) {
                                obj.p = this.b.r.a(obj.r);
                            }
                            if (!x.a(this.b.e, obj.r)) {
                                arrayList.add(obj);
                            }
                        }
                    } else if (obj.h == e.a) {
                        arrayList.add(obj);
                    }
                }
            }
            if (arrayList.isEmpty() && obj != null) {
                arrayList.add(obj);
            }
            this.a.a = arrayList;
            return;
        }
        a.c().c(LogLevel.ERROR, "ads", String.format("fetching ads errorCode %getTriangleEdge", new Object[]{Integer.valueOf(this.a.b)}));
    }

    protected boolean onSessionException(Exception exception, int i) {
        a.c().c(LogLevel.ERROR, "ads", "fetching ads exception");
        return super.onSessionException(exception, i);
    }

    protected void onSessionSucceeded() {
        TaskHandler.postTask(new m(this));
    }

    protected void onSessionFailed() {
    }
}
