package com.duokan.reader.ui.general.web;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;

import com.duokan.c.f;
import com.duokan.core.sys.as;
import com.duokan.reader.DkApp;

import org.json.JSONObject;

class jw implements as {
    final /* synthetic */ String a;
    final /* synthetic */ cg b;

    jw(cg cgVar, String str) {
        this.b = cgVar;
        this.a = str;
    }

    public void a() {
        Intent intent = null;
        JSONObject jSONObject = new JSONObject(this.a);
        CharSequence optString = jSONObject.optString("title");
        CharSequence optString2 = jSONObject.optString("content");
        Object optString3 = jSONObject.optString("url");
        int optInt = jSONObject.optInt("id", 23);
        Builder builder = new Builder(this.b.b.getContext());
        builder.setSmallIcon(f.mipush_small_notification);
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
            intent = new Intent(this.b.b.getContext(), DkApp.get().getReaderActivityClass());
            intent.setAction("android.intent.action.VIEW");
            intent.setFlags(268468224);
        }
        builder.setContentIntent(PendingIntent.getActivity(this.b.b.getContext(), 0, intent, 268435456));
        ((NotificationManager) this.b.b.getContext().getSystemService("notification")).notify(getClass().getName(), optInt, builder.build());
    }
}
