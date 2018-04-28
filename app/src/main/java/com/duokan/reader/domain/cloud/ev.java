package com.duokan.reader.domain.cloud;

import android.text.TextUtils;
import com.duokan.reader.common.cache.C0449k;
import com.duokan.reader.common.cache.C0577j;
import com.duokan.reader.domain.account.al;
import org.json.JSONObject;

class ev extends C0449k<DkUserReadingNotesCacheInfo, DkCloudNoteBookInfo, JSONObject> {
    /* renamed from: a */
    private final al f3953a;

    public /* synthetic */ Object queryInfo() {
        return m5512a();
    }

    public ev(al alVar) {
        super("UserReadingNotesCachePrefix_" + alVar.f2360a, C0577j.f1885a, new es(), 0);
        this.f3953a = alVar;
    }

    /* renamed from: a */
    public DkUserReadingNotesCacheInfo m5512a() {
        DkUserReadingNotesCacheInfo dkUserReadingNotesCacheInfo = (DkUserReadingNotesCacheInfo) super.queryInfo();
        if (TextUtils.isEmpty(dkUserReadingNotesCacheInfo.mAccountUuid)) {
            dkUserReadingNotesCacheInfo.mAccountUuid = this.f3953a.f2360a;
            dkUserReadingNotesCacheInfo.mAccountName = this.f3953a.f2362c;
            updateInfo(dkUserReadingNotesCacheInfo);
        }
        return dkUserReadingNotesCacheInfo;
    }

    /* renamed from: b */
    public void m5513b() {
        upgradeVersion(3, new ew(this));
    }
}
