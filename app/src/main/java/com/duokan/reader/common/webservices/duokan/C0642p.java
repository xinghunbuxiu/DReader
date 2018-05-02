package com.duokan.reader.common.webservices.duokan;

import com.duokan.reader.common.webservices.C0237c;
import com.duokan.reader.common.webservices.WebSession;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.common.webservices.duokan.p */
class C0642p extends WebSession {
    /* renamed from: a */
    final /* synthetic */ C0641o f2172a;

    C0642p(C0641o c0641o) {
        this.f2172a = c0641o;
    }

    protected void onSessionTry() {
        if (System.currentTimeMillis() - this.f2172a.f2149d.getLastGetCDNIpTime() >= TimeUnit.DAYS.toMillis(1)) {
            this.f2172a.f2149d.setLastGetCDNIpTime(System.currentTimeMillis());
            JSONObject b = new C0237c(this).m551b("http://resolver.gslb.mi-idc.com/gslb/gslb/getbucket.asp?ver=3.0&list=file.market.xiaomi.com");
            if (b.optString("S").equals("Ok")) {
                JSONArray optJSONArray;
                int i;
                JSONObject optJSONObject = b.optJSONObject("R");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("wifi");
                Set hashSet = new HashSet();
                Iterator keys = optJSONObject2.keys();
                while (keys.hasNext()) {
                    optJSONArray = optJSONObject2.optJSONArray((String) keys.next());
                    if (optJSONArray != null) {
                        for (i = 0; i < optJSONArray.length(); i++) {
                            hashSet.add(optJSONArray.getString(i));
                        }
                    }
                }
                optJSONObject = optJSONObject.optJSONObject("wap");
                Set hashSet2 = new HashSet();
                keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    optJSONArray = optJSONObject.optJSONArray((String) keys.next());
                    if (optJSONArray != null) {
                        for (i = 0; i < optJSONArray.length(); i++) {
                            hashSet2.add(optJSONArray.getString(i));
                        }
                    }
                }
                this.f2172a.f2149d.setMarketCDNIpOnWifi(hashSet);
                this.f2172a.f2149d.setMarketCDNIpOnWap(hashSet2);
            }
        }
    }

    protected void onSessionSucceeded() {
    }

    protected void onSessionFailed() {
    }
}
