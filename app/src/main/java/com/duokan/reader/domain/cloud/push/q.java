package com.duokan.reader.domain.cloud.push;

import com.duokan.reader.domain.social.message.k;

import java.util.LinkedList;
import java.util.List;

public class q {
    public k a = null;
    public DkCloudPushMessage b = null;

    public long a() {
        if (this.b != null) {
            return this.b.getReceivedDate().getTime();
        }
        if (this.a != null) {
            return this.a.g * 1000;
        }
        return 0;
    }

    static List a(k[] kVarArr) {
        List linkedList = new LinkedList();
        for (k kVar : kVarArr) {
            q qVar = new q();
            qVar.a = kVar;
            linkedList.add(qVar);
        }
        return linkedList;
    }

    static List a(DkCloudPushMessage[] dkCloudPushMessageArr) {
        List linkedList = new LinkedList();
        for (DkCloudPushMessage dkCloudPushMessage : dkCloudPushMessageArr) {
            q qVar = new q();
            qVar.b = dkCloudPushMessage;
            linkedList.add(qVar);
        }
        return linkedList;
    }
}
