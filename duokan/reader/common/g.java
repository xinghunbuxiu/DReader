package com.duokan.reader.common;

import android.net.Uri;

import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.d;
import com.duokan.reader.common.webservices.duokan.a.c;
import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.domain.account.MiAccount;
import com.duokan.reader.domain.account.i;

import org.apache.http.client.methods.HttpGet;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

class g extends WebSession {
    final /* synthetic */ MiAccount a;
    final /* synthetic */ d b;
    private b c = null;

    g(d dVar, MiAccount miAccount) {
        this.b = dVar;
        this.a = miAccount;
    }

    protected void onSessionTry() {
        int i = 0;
        d dVar = new d(this);
        String O = p.i().O();
        ArrayList arrayList = new ArrayList();
        arrayList.add("ac");
        arrayList.add("replycount");
        arrayList.add("authtoken");
        arrayList.add(Uri.encode(this.a.o().b));
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        String str = O;
        for (int i2 = 0; i2 < strArr.length; i2 += 2) {
            str = str + "&" + strArr[i2] + "=" + strArr[i2 + 1];
        }
        JSONObject a = dVar.a(execute(new c().a(HttpGet.METHOD_NAME).b(str).a()));
        this.c = new b();
        this.c.b = a.getInt("status");
        if (this.c.b == 0) {
            JSONArray jSONArray = a.getJSONArray("count");
            int i3 = 0;
            while (i < jSONArray.length()) {
                i3 += Integer.valueOf(jSONArray.getJSONObject(i).getString("replies")).intValue();
                i++;
            }
            this.c.a = Integer.valueOf(i3);
        }
    }

    protected void onSessionSucceeded() {
        if (((MiAccount) i.f().b(MiAccount.class)).equals(this.a) && this.c.b != 1002 && this.c.b == 0) {
            this.b.a(((Integer) this.c.a).intValue());
        }
    }

    protected void onSessionFailed() {
    }
}
