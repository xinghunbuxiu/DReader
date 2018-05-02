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

/* renamed from: com.duokan.reader.domain.ad.j */
class C0753j extends WebSession {
    /* renamed from: a */
    C0621a<List<C0748e>> f2565a = new C0621a();
    /* renamed from: b */
    final /* synthetic */ C0750g f2566b;

    C0753j(C0750g c0750g) {
        this.f2566b = c0750g;
    }

    protected void onSessionTry() {
        Map hashMap = new HashMap();
        hashMap.put("fictionId", this.f2566b.f2547f);
        JSONObject a = new C0237c(this).m547a(execute(new C0760q().m3602a("http://api.ad.xiaomi.com/u/api").m3604b(this.f2566b.f2543a).m3605c("2.0").m3601a(5).m3603a(hashMap).m3600a()));
        this.f2565a.b = a.getInt(Mipay.KEY_CODE);
        if (this.f2565a.b == 0) {
            JSONArray jSONArray = a.getJSONArray("adInfos");
            List arrayList = new ArrayList();
            Object obj = null;
            for (int i = 0; i < jSONArray.length(); i++) {
                C0748e a2 = C0748e.m3556a(jSONArray.optJSONObject(i));
                if (a2 == null) {
                    obj = a2;
                } else {
                    C0748e obj2;
                    switch (a2.f2522g) {
                        case 4:
                            a2.f2539x = a2.f2523h == C0748e.f2517b ? this.f2566b.f2553l : this.f2566b.f2550i;
                            break;
                        case 6:
                            if (a2.f2538w != null && !a2.f2538w.isEmpty()) {
                                int f;
                                if (a2.f2523h == C0748e.f2517b) {
                                    f = this.f2566b.f2555n;
                                } else {
                                    f = this.f2566b.f2552k;
                                }
                                a2.f2539x = f;
                                break;
                            }
                            a2.f2539x = this.f2566b.f2556o;
                            break;
                            break;
                        case 7:
                            a2.f2539x = a2.f2523h == C0748e.f2517b ? this.f2566b.f2554m : this.f2566b.f2551j;
                            break;
                        default:
                            obj2 = a2;
                            continue;
                    }
                    if (a2.f2523h != C0748e.f2517b) {
                        if (a2.f2523h == C0748e.f2516a) {
                            arrayList.add(a2);
                        }
                        obj2 = a2;
                    } else if (TextUtils.isEmpty(a2.f2533r)) {
                        obj2 = null;
                    } else {
                        if (!TextUtils.isEmpty(a2.f2531p) && this.f2566b.f2559r.m3553a()) {
                            a2.f2531p = this.f2566b.f2559r.m3552a(a2.f2533r);
                        }
                        if (C0767x.m3611a(this.f2566b.f2546e, a2.f2533r)) {
                            obj2 = a2;
                        } else {
                            arrayList.add(a2);
                            obj2 = a2;
                        }
                    }
                }
            }
            if (arrayList.isEmpty() && obj2 != null) {
                arrayList.add(obj2);
            }
            this.f2565a.f2058a = arrayList;
            return;
        }
        WebLog.init().c(LogLevel.ERROR, "ads", String.format("fetching ads errorCode %d", new Object[]{Integer.valueOf(this.f2565a.b)}));
    }

    protected boolean onSessionException(Exception exception, int i) {
        WebLog.init().c(LogLevel.ERROR, "ads", "fetching ads exception");
        return super.onSessionException(exception, i);
    }

    protected void onSessionSucceeded() {
        UThread.runOnThread(new C0754k(this));
    }

    protected void onSessionFailed() {
    }
}
