package com.duokan.reader.domain.ad;

import android.text.TextUtils;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.UThread;
import com.duokan.reader.common.webservices.C0237c;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.WebSession;
import com.mipay.sdk.Mipay;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.ad.l */
class C0755l extends WebSession {
    /* renamed from: a */
    C0621a<List<C0748e>> f2568a = new C0621a();
    /* renamed from: b */
    final /* synthetic */ C0750g f2569b;

    C0755l(C0750g c0750g) {
        this.f2569b = c0750g;
    }

    protected void onSessionTry() {
        Map hashMap = new HashMap();
        hashMap.put("fictionId", this.f2569b.f2547f);
        JSONObject a = new C0237c(this).m547a(execute(new C0760q().m3602a("http://api.ad.xiaomi.com/u/api").m3604b(this.f2569b.f2545c).m3605c("2.0").m3601a(5).m3603a(hashMap).m3600a()));
        this.f2568a.b = a.getInt(Mipay.KEY_CODE);
        if (this.f2568a.b == 0) {
            JSONArray jSONArray = a.getJSONArray("adInfos");
            List arrayList = new ArrayList();
            Object obj = null;
            for (int i = 0; i < jSONArray.length(); i++) {
                obj = C0748e.m3556a(jSONArray.optJSONObject(i));
                if (obj != null && obj.f2522g == 20) {
                    if (obj.f2523h == C0748e.f2517b) {
                        if (TextUtils.isEmpty(obj.f2533r)) {
                            obj = null;
                        } else {
                            if (!TextUtils.isEmpty(obj.f2531p) && this.f2569b.f2559r.m3553a()) {
                                obj.f2531p = this.f2569b.f2559r.m3552a(obj.f2533r);
                            }
                            if (!C0767x.m3611a(this.f2569b.f2546e, obj.f2533r)) {
                                arrayList.add(obj);
                            }
                        }
                    } else if (obj.f2523h == C0748e.f2516a) {
                        arrayList.add(obj);
                    }
                }
            }
            if (arrayList.isEmpty() && obj != null) {
                arrayList.add(obj);
            }
            this.f2568a.f2058a = arrayList;
            return;
        }
        WebLog.init().c(LogLevel.ERROR, "ads", String.format("fetching ads errorCode %d", new Object[]{Integer.valueOf(this.f2568a.b)}));
    }

    protected boolean onSessionException(Exception exception, int i) {
        WebLog.init().c(LogLevel.ERROR, "ads", "fetching ads exception");
        return super.onSessionException(exception, i);
    }

    protected void onSessionSucceeded() {
        UThread.runOnThread(new C0756m(this));
    }

    protected void onSessionFailed() {
    }
}
