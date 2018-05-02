package com.duokan.reader.common.webservices.duokan;

import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.d;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

class q extends WebSession {
    final /* synthetic */ p a;

    q(p pVar) {
        this.a = pVar;
    }

    protected void onSessionTry() {
        if (System.currentTimeMillis() - this.a.d.getLastGetCDNIpTime() >= TimeUnit.DAYS.toMillis(1)) {
            this.a.d.setLastGetCDNIpTime(System.currentTimeMillis());
            JSONObject b = new d(this).b("http://resolver.gslb.mi-idc.com/gslb/gslb/getbucket.asp?ver=3.0&list=file.market.xiaomi.com");
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
                this.a.d.setMarketCDNIpOnWifi(hashSet);
                this.a.d.setMarketCDNIpOnWap(hashSet2);
            }
        }
    }

    protected void onSessionSucceeded() {
    }

    protected void onSessionFailed() {
    }
}
