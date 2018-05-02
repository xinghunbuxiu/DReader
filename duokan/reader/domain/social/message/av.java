package com.duokan.reader.domain.social.message;

import android.text.TextUtils;

import com.duokan.reader.common.cache.j;
import com.duokan.reader.common.cache.k;
import com.duokan.reader.domain.account.ab;

class av extends k {
    private ab a;

    public /* synthetic */ Object queryInfo() {
        return b();
    }

    public av(String str, ab abVar, int i) {
        super(str + "_" + abVar.a, j.a, new at(), new au(), i);
        this.a = abVar;
    }

    public void a() {
        upgradeVersion(2);
    }

    public DkMessagesInfo b() {
        DkMessagesInfo dkMessagesInfo = (DkMessagesInfo) super.queryInfo();
        if (TextUtils.isEmpty(dkMessagesInfo.mAccountUuid)) {
            dkMessagesInfo.mAccountUuid = this.a.a;
            dkMessagesInfo.mAccountName = this.a.c;
            dkMessagesInfo.mReadThreshold = "";
            dkMessagesInfo.mUnreadThreshold = "";
            dkMessagesInfo.mUnreadMessageIds = new String[0];
            updateInfo(dkMessagesInfo);
        }
        return dkMessagesInfo;
    }
}
