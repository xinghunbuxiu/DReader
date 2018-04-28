package com.duokan.reader.domain.social.message;

import android.text.TextUtils;
import com.duokan.reader.common.cache.C0449k;
import com.duokan.reader.common.cache.C0577j;
import com.duokan.reader.domain.account.al;
import org.json.JSONObject;

class aq extends C0449k<DkMessagesInfo, C1151k, JSONObject> {
    /* renamed from: a */
    private al f5528a = al.f2359g;

    public /* synthetic */ Object queryInfo() {
        return m8530b();
    }

    public aq(String str, al alVar, int i) {
        super(str + "_" + alVar.f2360a, C0577j.f1885a, new ao(), new ap(), i);
        this.f5528a = alVar;
    }

    /* renamed from: a */
    public void m8529a() {
        upgradeVersion(2);
    }

    /* renamed from: b */
    public DkMessagesInfo m8530b() {
        DkMessagesInfo dkMessagesInfo = (DkMessagesInfo) super.queryInfo();
        if (TextUtils.isEmpty(dkMessagesInfo.mAccountUuid)) {
            dkMessagesInfo.mAccountUuid = this.f5528a.f2360a;
            dkMessagesInfo.mAccountName = this.f5528a.f2362c;
            dkMessagesInfo.mReadThreshold = "";
            dkMessagesInfo.mUnreadThreshold = "";
            dkMessagesInfo.mUnreadMessageIds = new String[0];
            updateInfo(dkMessagesInfo);
        }
        return dkMessagesInfo;
    }
}
