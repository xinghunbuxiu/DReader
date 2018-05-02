package com.duokan.reader.common;

import android.net.Uri;
import com.duokan.reader.common.webservices.C0237c;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.common.webservices.duokan.p040a.C0626c;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.MiAccount;
import com.wali.live.sdk.manager.IMiLiveSdk.ICallback;
import java.util.ArrayList;
import org.apache.http.client.methods.HttpGet;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.common.g */
class C0609g extends WebSession {
    /* renamed from: a */
    final /* synthetic */ MiAccount f2032a;
    /* renamed from: b */
    final /* synthetic */ C0590d f2033b;
    /* renamed from: c */
    private C0621a<Integer> f2034c = null;

    C0609g(C0590d c0590d, MiAccount miAccount) {
        this.f2033b = c0590d;
        this.f2032a = miAccount;
    }

    protected void onSessionTry() {
        int i = 0;
        C0237c c0237c = new C0237c(this);
        String M = C0641o.m2934i().m2949M();
        ArrayList arrayList = new ArrayList();
        arrayList.add("ac");
        arrayList.add("replycount");
        arrayList.add("authtoken");
        arrayList.add(Uri.encode(this.f2032a.mo848r().f2402b));
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        String str = M;
        for (int i2 = 0; i2 < strArr.length; i2 += 2) {
            str = str + "&" + strArr[i2] + "=" + strArr[i2 + 1];
        }
        JSONObject a = c0237c.m547a(execute(new C0626c().m2853a(HttpGet.METHOD_NAME).m2856b(str).m2851a()));
        this.f2034c = new C0621a();
        this.f2034c.b = a.getInt("status");
        if (this.f2034c.b == 0) {
            JSONArray jSONArray = a.getJSONArray("count");
            int i3 = 0;
            while (i < jSONArray.length()) {
                i3 += Integer.valueOf(jSONArray.getJSONObject(i).getString("replies")).intValue();
                i++;
            }
            this.f2034c.f2058a = Integer.valueOf(i3);
        }
    }

    protected void onSessionSucceeded() {
        if (((MiAccount) C0709k.m3476a().m3502b(MiAccount.class)).equals(this.f2032a) && this.f2034c.b != ICallback.LOGIN_OAUTH_AIDL && this.f2034c.b == 0) {
            this.f2033b.m2644a(((Integer) this.f2034c.f2058a).intValue());
        }
    }

    protected void onSessionFailed() {
    }
}
