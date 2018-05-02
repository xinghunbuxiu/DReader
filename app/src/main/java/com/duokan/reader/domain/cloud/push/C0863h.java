package com.duokan.reader.domain.cloud.push;

import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.cloud.push.MessageWakeupListener.MessageSubType;

/* renamed from: com.duokan.reader.domain.cloud.push.h */
class C0863h implements af {
    /* renamed from: a */
    final /* synthetic */ C0862g f4123a;

    C0863h(C0862g c0862g) {
        this.f4123a = c0862g;
    }

    /* renamed from: a */
    public void mo1175a(long j, String str, String str2) {
        Object[] objArr = new Object[3];
        objArr[0] = C0857b.f4100a;
        objArr[1] = "onInit";
        objArr[2] = String.format("code: %d, id: %s, reason: %s", new Object[]{Long.valueOf(j), str, str2});
        WebLog.init().c(LogLevel.EVENT, "push", String.format("class: %s, method: %s, message: %s", objArr));
        if (str == null) {
            str = "";
        }
        this.f4123a.f4122a.m5658a(str, this.f4123a.f4122a.f4104e.m3502b(PersonalAccount.class), false, new C0864i(this, str));
    }

    /* renamed from: a */
    public void mo1177a(MessageSubType messageSubType, Object obj, boolean z) {
        MessageWakeupListener messageWakeupListener = (MessageWakeupListener) this.f4123a.f4122a.f4108i.get(messageSubType);
        if (messageWakeupListener != null) {
            messageWakeupListener.mo785a(messageSubType, obj, z);
        }
    }

    /* renamed from: a */
    public void mo1176a(DkCloudPushMessage dkCloudPushMessage) {
        WebLog c = WebLog.init();
        LogLevel logLevel = LogLevel.EVENT;
        String str = "push";
        String str2 = "class: %s, method: %s, message: %s";
        Object[] objArr = new Object[3];
        objArr[0] = C0857b.f4100a;
        objArr[1] = "onReceiveMessage";
        objArr[2] = dkCloudPushMessage == null ? "null" : dkCloudPushMessage.getMessageContent();
        c.c(logLevel, str, String.format(str2, objArr));
        this.f4123a.f4122a.m5665e();
        this.f4123a.f4122a.m5659a(this.f4123a.f4122a.m5674i(), this.f4123a.f4122a.f4104e.m3502b(PersonalAccount.class), C0872q.m5709b().m5719e());
    }

    /* renamed from: a */
    public void mo1178a(String str, String str2, boolean z) {
        WebLog.init().c(LogLevel.EVENT, "push", String.format("class: %s, method: %s, message: %s", new Object[]{C0857b.f4100a, "onReceiveTopic", str2}));
        MessageSubType messageSubType = MessageSubType.FICTION_UPDATE;
        MessageWakeupListener messageWakeupListener = (MessageWakeupListener) this.f4123a.f4122a.f4108i.get(messageSubType);
        if (messageWakeupListener != null) {
            messageWakeupListener.mo785a(messageSubType, str2, z);
        }
    }
}
