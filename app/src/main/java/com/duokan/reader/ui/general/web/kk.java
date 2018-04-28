package com.duokan.reader.ui.general.web;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import com.duokan.core.sys.as;
import com.duokan.p024c.C0254f;
import com.duokan.reader.DkApp;
import org.json.JSONObject;

class kk implements as {
    /* renamed from: a */
    final /* synthetic */ String f8102a;
    /* renamed from: b */
    final /* synthetic */ ci f8103b;

    kk(ci ciVar, String str) {
        this.f8103b = ciVar;
        this.f8102a = str;
    }

    /* renamed from: a */
    public void mo1831a() {
        Intent intent = null;
        JSONObject jSONObject = new JSONObject(this.f8102a);
        CharSequence optString = jSONObject.optString("title");
        CharSequence optString2 = jSONObject.optString("content");
        Object optString3 = jSONObject.optString("url");
        int optInt = jSONObject.optInt("id", 23);
        Builder builder = new Builder(this.f8103b.f7581b.getContext());
        builder.setSmallIcon(C0254f.mipush_small_notification);
        builder.setContentTitle(optString);
        builder.setTicker(optString);
        builder.setContentText(optString2);
        builder.setDefaults(-1);
        builder.setAutoCancel(true);
        if (!TextUtils.isEmpty(optString3)) {
            try {
                intent = Intent.parseUri(optString3, 0);
            } catch (Throwable th) {
            }
        }
        if (intent == null) {
            intent = new Intent(this.f8103b.f7581b.getContext(), DkApp.get().getReaderActivityClass());
            intent.setAction("android.intent.action.VIEW");
            intent.setFlags(268468224);
        }
        builder.setContentIntent(PendingIntent.getActivity(this.f8103b.f7581b.getContext(), 0, intent, 268435456));
        ((NotificationManager) this.f8103b.f7581b.getContext().getSystemService("notification")).notify(getClass().getName(), optInt, builder.build());
    }
}
