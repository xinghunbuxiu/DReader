package com.duokan.reader.domain.cloud.push;

import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.diagnostic.a;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.cloud.push.MessageWakeupListener.MessageSubType;

class h implements ag {
    final /* synthetic */ g a;

    h(g gVar) {
        this.a = gVar;
    }

    public void a(long j, String str, String str2) {
        Object[] objArr = new Object[3];
        objArr[0] = b.a;
        objArr[1] = "onInit";
        objArr[2] = String.format("code: %d, id: %s, reason: %s", new Object[]{Long.valueOf(j), str, str2});
        a.c().c(LogLevel.EVENT, "push", String.format("class: %s, method: %s, message: %s", objArr));
        if (str == null) {
            str = "";
        }
        this.a.a.a(str, this.a.a.e.b(PersonalAccount.class), false, new i(this, str));
    }

    public void a(MessageSubType messageSubType, Object obj, boolean z) {
        MessageWakeupListener messageWakeupListener = (MessageWakeupListener) this.a.a.i.get(messageSubType);
        if (messageWakeupListener != null) {
            messageWakeupListener.a(messageSubType, obj, z);
        }
    }

    public void a(DkCloudPushMessage dkCloudPushMessage) {
        a c = a.c();
        LogLevel logLevel = LogLevel.EVENT;
        String str = "push";
        String str2 = "class: %s, method: %s, message: %s";
        Object[] objArr = new Object[3];
        objArr[0] = b.a;
        objArr[1] = "onReceiveMessage";
        objArr[2] = dkCloudPushMessage == null ? "null" : dkCloudPushMessage.getMessageContent();
        c.c(logLevel, str, String.format(str2, objArr));
        this.a.a.e();
        this.a.a.a(this.a.a.i(), this.a.a.e.b(PersonalAccount.class), t.b().e());
    }

    public void a(String str, String str2, boolean z) {
        a.c().c(LogLevel.EVENT, "push", String.format("class: %s, method: %s, message: %s", new Object[]{b.a, "onReceiveTopic", str2}));
        MessageSubType messageSubType = MessageSubType.FICTION_UPDATE;
        MessageWakeupListener messageWakeupListener = (MessageWakeupListener) this.a.a.i.get(messageSubType);
        if (messageWakeupListener != null) {
            messageWakeupListener.a(messageSubType, str2, z);
        }
    }
}
