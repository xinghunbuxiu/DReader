package com.duokan.reader.domain.cloud.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.diagnostic.a;
import com.duokan.core.sys.t;
import com.duokan.reader.DkApp;
import com.duokan.reader.UmengManager;
import com.duokan.reader.common.webservices.duokan.DkCloudMessageInfo;
import com.duokan.reader.domain.cloud.push.MessageWakeupListener.MessageSubType;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.MiPushMessage;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class z implements af {
    private static final String a = z.class.getName();
    private static z b = null;
    private static final String[] k = new String[]{"subscribe_chapter_update", "subscribe_chapter_update_in"};
    private final boolean c;
    private final String d;
    private final String e;
    private boolean f = false;
    private final Context g;
    private final Intent h;
    private final LinkedList i = new LinkedList();
    private ag j = null;

    private z(Context context, boolean z, String str, String str2) {
        this.g = context;
        this.c = z;
        this.d = str;
        this.e = str2;
        Intent intent = new Intent(this.g, DkApp.get().getReaderActivityClass());
        intent.addFlags(268468224);
        this.h = intent;
        d();
    }

    public static void a(Context context, boolean z, String str, String str2) {
        b = new z(context, z, str, str2);
    }

    public static z a() {
        return b;
    }

    protected void a(ag agVar) {
        this.j = agVar;
        if (this.j != null) {
            Iterator it = this.i.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
            this.i.clear();
        }
    }

    public void a(String str) {
        if (this.c && this.f) {
            MiPushClient.reportMessageClicked(this.g, str);
        }
    }

    public void b(String str) {
        if (this.c && this.f) {
            MiPushClient.subscribe(this.g, str, null);
        }
    }

    public void c(String str) {
        if (this.c && this.f) {
            MiPushClient.unsubscribe(this.g, str, null);
        }
    }

    public List b() {
        if (this.c && this.f) {
            return MiPushClient.getAllTopic(this.g);
        }
        return new LinkedList();
    }

    protected void c() {
        if (this.g.getSharedPreferences("push", 0).getBoolean("reportRegister", false)) {
            Intent intent = new Intent("com.xiaomi.xmsf.push.APP_REGISTERED");
            intent.setComponent(new ComponentName("com.xiaomi.xmsf", "com.xiaomi.xmsf.push.service.MiuiPushActivateService"));
            intent.putExtra("source_package", this.g.getPackageName());
            intent.putExtra("app_id", this.d);
            this.g.startService(intent);
        }
    }

    private boolean d() {
        e();
        return true;
    }

    private void e() {
        try {
            Field declaredField = MiPushClient.class.getDeclaredField("awakeService");
            declaredField.setAccessible(true);
            declaredField.set(null, Boolean.valueOf(false));
        } catch (Throwable th) {
        }
        MiPushClient.registerPush(this.g, this.d, this.e);
    }

    public void a(MiPushMessage miPushMessage) {
        a.c().c(LogLevel.EVENT, "push", String.format("class: %s, method: %s, message: %s", new Object[]{a, "onReceiveMessage", miPushMessage.toString()}));
        if (b(miPushMessage)) {
            a(miPushMessage.getMessageId(), miPushMessage.getTopic(), miPushMessage.getContent(), miPushMessage.isNotified());
        } else {
            a(miPushMessage.getMessageId(), miPushMessage.getContent(), miPushMessage.isNotified());
        }
    }

    public void a(long j, String str, String str2) {
        Object[] objArr = new Object[3];
        objArr[0] = a;
        objArr[1] = "onInited";
        objArr[2] = String.format("code: %d, id: %s, reason: %s", new Object[]{Long.valueOf(j), str, str2});
        a.c().c(LogLevel.EVENT, "push", String.format("class: %s, method: %s, message: %s", objArr));
        this.f = !TextUtils.isEmpty(str);
        if (!TextUtils.isEmpty(str)) {
            UmengManager.get().onEvent("MIPUSH_V1", "mi_push_success");
        }
        if (this.j != null) {
            this.j.a(j, str, str2);
        } else {
            this.i.add(new aa(this, j, str, str2));
        }
        if (this.f) {
            Object d = d(((TelephonyManager) this.g.getSystemService("phone")).getDeviceId());
            if (!TextUtils.isEmpty(d)) {
                MiPushClient.setAlias(this.g, d, null);
            }
            MiPushClient.setAcceptTime(this.g, 6, 0, 23, 59, null);
            SharedPreferences sharedPreferences = this.g.getSharedPreferences("push", 0);
            sharedPreferences.edit().putBoolean("reportRegister", true);
            sharedPreferences.edit().apply();
        }
    }

    public static boolean b(MiPushMessage miPushMessage) {
        Object topic = miPushMessage.getTopic();
        if (TextUtils.isEmpty(topic)) {
            return false;
        }
        for (String startsWith : k) {
            if (topic.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    private void a(String str, String str2, boolean z) {
        DkCloudPushMessage dkCloudPushMessage = null;
        a.c().c(LogLevel.EVENT, "push", String.format("class: %s, method: %s, message: %s", new Object[]{a, "onReceiveMessage", str2}));
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if (jSONObject.has("message_type")) {
                MessageSubType value = MessageSubType.value(String.valueOf(jSONObject.getInt("message_type")));
                if (value != null) {
                    t.a(new ab(this, value, i.a(jSONObject, "action_params", null), z));
                } else {
                    dkCloudPushMessage = a(str, z, jSONObject);
                }
            } else {
                dkCloudPushMessage = a(str, z, jSONObject);
            }
        } catch (JSONException e) {
        }
        if (!z) {
            return;
        }
        if (dkCloudPushMessage != null) {
            Intent intent = new Intent(this.h);
            intent.setAction("com.duokan.reader.actions.SHOW_PROMPT");
            intent.putExtra("push_message_target", dkCloudPushMessage.getCloudId());
            intent.putExtra("push_server_message_id", str);
            intent.putExtra("raw_push_message", str2);
            this.g.startActivity(intent);
            return;
        }
        this.g.startActivity(this.h);
    }

    private void a(String str, String str2, String str3, boolean z) {
        a.c().c(LogLevel.EVENT, "push", String.format("class: %s, method: %s, message: %s", new Object[]{a, "onReceiveTopic", str3}));
        if (this.j != null) {
            this.j.a(str2, str3, z);
        } else {
            this.i.add(new ad(this, str2, str3, z));
        }
        if (z) {
            Intent intent = new Intent(this.h);
            intent.setAction("com.duokan.reader.actions.SHOW_BOOKSHELF");
            this.g.startActivity(intent);
        }
    }

    public String d(String str) {
        try {
            InputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes("utf-8"));
            MessageDigest instance = MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[1024];
            while (true) {
                int read = byteArrayInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                instance.update(bArr, 0, read);
            }
            byte[] digest = instance.digest();
            StringBuilder stringBuilder = new StringBuilder(digest.length * 2);
            for (int i = 0; i < digest.length; i++) {
                stringBuilder.append(String.format("%02x", new Object[]{Byte.valueOf(digest[i])}));
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private DkCloudPushMessage a(String str, boolean z, JSONObject jSONObject) {
        DkCloudPushMessage dkCloudPushMessage = null;
        DkCloudMessageInfo fromJson = DkCloudMessageInfo.fromJson(jSONObject);
        if (fromJson != null) {
            dkCloudPushMessage = (DkCloudPushMessage) t.b().a(str, z, fromJson).first;
            if (this.j != null) {
                this.j.a(dkCloudPushMessage);
            } else {
                this.i.add(new ae(this, dkCloudPushMessage));
            }
        }
        return dkCloudPushMessage;
    }
}
