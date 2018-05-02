package com.duokan.reader.domain.cloud.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.UThread;
import com.duokan.core.sys.p025a.IPermissionsResultListener;
import com.duokan.core.sys.p025a.Permissions;
import com.duokan.reader.DkApp;
import com.duokan.reader.UmengManager;
import com.duokan.reader.common.C0611i;
import com.duokan.reader.common.webservices.duokan.DkCloudMessageInfo;
import com.duokan.reader.domain.cloud.push.MessageWakeupListener.MessageSubType;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushConfiguration;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.cloud.push.y */
public class C0880y implements IPermissionsResultListener, ae {
    /* renamed from: a */
    private static final String f4159a = C0880y.class.getName();
    /* renamed from: b */
    private static C0880y f4160b = null;
    /* renamed from: k */
    private static final String[] f4161k = new String[]{"subscribe_chapter_update", "subscribe_chapter_update_in"};
    /* renamed from: c */
    private final boolean f4162c;
    /* renamed from: d */
    private final String f4163d;
    /* renamed from: e */
    private final String f4164e;
    /* renamed from: f */
    private boolean f4165f = false;
    /* renamed from: g */
    private final Context f4166g;
    /* renamed from: h */
    private final Intent f4167h;
    /* renamed from: i */
    private final LinkedList<Runnable> f4168i = new LinkedList();
    /* renamed from: j */
    private af f4169j = null;

    private C0880y(Context context, boolean z, String str, String str2) {
        this.f4166g = context;
        this.f4162c = z;
        this.f4163d = str;
        this.f4164e = str2;
        Intent intent = new Intent(this.f4166g, DkApp.get().getReaderActivityClass());
        intent.addFlags(268468224);
        this.f4167h = intent;
        m5748d();
        if (!Permissions.getInstance().m834b()) {
            Permissions.getInstance().addPermissionsResultListener(this);
        }
    }

    /* renamed from: a */
    public static void m5743a(Context context, boolean z, String str, String str2) {
        f4160b = new C0880y(context, z, str, str2);
    }

    /* renamed from: a */
    public static C0880y m5742a() {
        return f4160b;
    }

    /* renamed from: a */
    protected void m5750a(af afVar) {
        this.f4169j = afVar;
        if (this.f4169j != null) {
            Iterator it = this.f4168i.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
            this.f4168i.clear();
        }
    }

    /* renamed from: a */
    public void m5752a(String str) {
        if (this.f4162c && this.f4165f) {
            MiPushClient.reportMessageClicked(this.f4166g, str);
        }
    }

    /* renamed from: b */
    public void m5754b(String str) {
        if (this.f4162c && this.f4165f) {
            MiPushClient.subscribe(this.f4166g, str, null);
        }
    }

    /* renamed from: c */
    public void m5756c(String str) {
        if (this.f4162c && this.f4165f) {
            MiPushClient.unsubscribe(this.f4166g, str, null);
        }
    }

    /* renamed from: b */
    public List<String> m5753b() {
        if (this.f4162c && this.f4165f) {
            return MiPushClient.getAllTopic(this.f4166g);
        }
        return new LinkedList();
    }

    /* renamed from: c */
    protected void m5755c() {
        if (this.f4166g.getSharedPreferences("push", 0).getBoolean("reportRegister", false)) {
            Intent intent = new Intent("com.xiaomi.xmsf.push.APP_REGISTERED");
            intent.setComponent(new ComponentName("com.xiaomi.xmsf", "com.xiaomi.xmsf.push.service.MiuiPushActivateService"));
            intent.putExtra("source_package", this.f4166g.getPackageName());
            intent.putExtra("app_id", this.f4163d);
            this.f4166g.startService(intent);
        }
    }

    /* renamed from: d */
    private void m5748d() {
        try {
            Field declaredField = MiPushClient.class.getDeclaredField("awakeService");
            declaredField.setAccessible(true);
            declaredField.set(null, Boolean.valueOf(false));
        } catch (Throwable th) {
        }
        PushConfiguration pushConfiguration = new PushConfiguration();
        pushConfiguration.setOpenHmsPush(true);
        MiPushClient.registerPush(this.f4166g, this.f4163d, this.f4164e, pushConfiguration);
    }

    /* renamed from: a */
    public void m5751a(MiPushMessage miPushMessage) {
        WebLog.init().c(LogLevel.EVENT, "push", String.format("class: %s, method: %s, message: %s", new Object[]{f4159a, "onReceiveMessage", miPushMessage.toString()}));
        if (C0880y.m5747b(miPushMessage)) {
            m5744a(miPushMessage.getMessageId(), miPushMessage.getTopic(), miPushMessage.getContent(), miPushMessage.isNotified());
        } else {
            m5745a(miPushMessage.getMessageId(), miPushMessage.getContent(), miPushMessage.isNotified());
        }
    }

    /* renamed from: a */
    public void m5749a(long j, String str, String str2) {
        Object[] objArr = new Object[3];
        objArr[0] = f4159a;
        objArr[1] = "onInited";
        objArr[2] = String.format("code: %d, id: %s, reason: %s", new Object[]{Long.valueOf(j), str, str2});
        WebLog.init().c(LogLevel.EVENT, "push", String.format("class: %s, method: %s, message: %s", objArr));
        this.f4165f = !TextUtils.isEmpty(str);
        if (!TextUtils.isEmpty(str)) {
            UmengManager.get().onEvent("MIPUSH_V1", "mi_push_success");
        }
        if (this.f4169j != null) {
            this.f4169j.mo1175a(j, str, str2);
        } else {
            this.f4168i.add(new C0881z(this, j, str, str2));
        }
        if (this.f4165f) {
            MiPushClient.setAcceptTime(this.f4166g, 6, 0, 23, 59, null);
            SharedPreferences sharedPreferences = this.f4166g.getSharedPreferences("push", 0);
            sharedPreferences.edit().putBoolean("reportRegister", true);
            sharedPreferences.edit().apply();
        }
    }

    /* renamed from: b */
    public static boolean m5747b(MiPushMessage miPushMessage) {
        Object topic = miPushMessage.getTopic();
        if (TextUtils.isEmpty(topic)) {
            return false;
        }
        for (String startsWith : f4161k) {
            if (topic.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private void m5745a(String str, String str2, boolean z) {
        DkCloudPushMessage dkCloudPushMessage = null;
        WebLog.init().c(LogLevel.EVENT, "push", String.format("class: %s, method: %s, message: %s", new Object[]{f4159a, "onReceiveMessage", str2}));
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if (jSONObject.has("message_type")) {
                MessageSubType value = MessageSubType.value(String.valueOf(jSONObject.getInt("message_type")));
                if (value != null) {
                    UThread.runOnThread(new aa(this, value, C0611i.m2786a(jSONObject, "action_params", null), z));
                } else {
                    dkCloudPushMessage = m5740a(str, z, jSONObject);
                }
            } else {
                dkCloudPushMessage = m5740a(str, z, jSONObject);
            }
        } catch (JSONException e) {
        }
        if (!z) {
            return;
        }
        if (dkCloudPushMessage != null) {
            Intent intent = new Intent(this.f4167h);
            intent.setAction("com.duokan.reader.actions.SHOW_PROMPT");
            intent.putExtra("push_message_target", dkCloudPushMessage.getCloudId());
            intent.putExtra("push_server_message_id", str);
            intent.putExtra("raw_push_message", str2);
            this.f4166g.startActivity(intent);
            return;
        }
        this.f4166g.startActivity(this.f4167h);
    }

    /* renamed from: a */
    private void m5744a(String str, String str2, String str3, boolean z) {
        WebLog.init().c(LogLevel.EVENT, "push", String.format("class: %s, method: %s, message: %s", new Object[]{f4159a, "onReceiveTopic", str3}));
        if (this.f4169j != null) {
            this.f4169j.mo1178a(str2, str3, z);
        } else {
            this.f4168i.add(new ac(this, str2, str3, z));
        }
        if (z) {
            Intent intent = new Intent(this.f4167h);
            intent.setAction("com.duokan.reader.actions.SHOW_BOOKSHELF");
            this.f4166g.startActivity(intent);
        }
    }

    /* renamed from: a */
    private DkCloudPushMessage m5740a(String str, boolean z, JSONObject jSONObject) {
        DkCloudPushMessage dkCloudPushMessage = null;
        DkCloudMessageInfo fromJson = DkCloudMessageInfo.fromJson(jSONObject);
        if (fromJson != null) {
            dkCloudPushMessage = (DkCloudPushMessage) C0872q.m5709b().m5711a(str, z, fromJson).first;
            if (this.f4169j != null) {
                this.f4169j.mo1176a(dkCloudPushMessage);
            } else {
                this.f4168i.add(new ad(this, dkCloudPushMessage));
            }
        }
        return dkCloudPushMessage;
    }

    public void onSuccess() {
        m5748d();
    }

    public void onFail() {
    }
}
