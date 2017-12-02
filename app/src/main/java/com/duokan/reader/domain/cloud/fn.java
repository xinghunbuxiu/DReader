package com.duokan.reader.domain.cloud;

import android.text.TextUtils;

import com.duokan.reader.common.cache.j;
import com.duokan.reader.common.cache.k;
import com.duokan.reader.domain.account.ab;

class fn extends k {
    private final ab a;

    public /* synthetic */ Object queryInfo() {
        return a();
    }

    public fn(ab abVar) {
        super("UserReadingNotesCachePrefix_" + abVar.a, j.a, new fk(), 0);
        this.a = abVar;
    }

    public DkUserReadingNotesCacheInfo a() {
        DkUserReadingNotesCacheInfo dkUserReadingNotesCacheInfo = (DkUserReadingNotesCacheInfo) super.queryInfo();
        if (TextUtils.isEmpty(dkUserReadingNotesCacheInfo.mAccountUuid)) {
            dkUserReadingNotesCacheInfo.mAccountUuid = this.a.a;
            dkUserReadingNotesCacheInfo.mAccountName = this.a.c;
            updateInfo(dkUserReadingNotesCacheInfo);
        }
        return dkUserReadingNotesCacheInfo;
    }

    public void b() {
        upgradeVersion(3, new fo(this));
    }
}
