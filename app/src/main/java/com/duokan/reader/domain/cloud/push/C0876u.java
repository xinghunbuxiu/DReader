package com.duokan.reader.domain.cloud.push;

import com.duokan.reader.domain.social.message.C1151k;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.duokan.reader.domain.cloud.push.u */
public class C0876u {
    /* renamed from: a */
    public C1151k f4157a = null;
    /* renamed from: b */
    public DkCloudPushMessage f4158b = null;

    /* renamed from: a */
    public long m5733a() {
        if (this.f4158b != null) {
            return this.f4158b.getReceivedDate().getTime();
        }
        if (this.f4157a != null) {
            return this.f4157a.f5560g * 1000;
        }
        return 0;
    }

    /* renamed from: a */
    static List<C0876u> m5732a(C1151k[] c1151kArr) {
        List linkedList = new LinkedList();
        for (C1151k c1151k : c1151kArr) {
            C0876u c0876u = new C0876u();
            c0876u.f4157a = c1151k;
            linkedList.add(c0876u);
        }
        return linkedList;
    }

    /* renamed from: a */
    static List<C0876u> m5731a(DkCloudPushMessage[] dkCloudPushMessageArr) {
        List linkedList = new LinkedList();
        for (DkCloudPushMessage dkCloudPushMessage : dkCloudPushMessageArr) {
            C0876u c0876u = new C0876u();
            c0876u.f4158b = dkCloudPushMessage;
            linkedList.add(c0876u);
        }
        return linkedList;
    }
}
