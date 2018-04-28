package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;
import com.duokan.reader.common.cache.C0572d;
import com.duokan.reader.common.cache.C0577j;
import com.duokan.reader.domain.account.al;
import org.json.JSONObject;

public class da extends C0572d<dc, dd, JSONObject> {
    /* renamed from: a */
    private final al f2999a;

    public /* synthetic */ Object queryInfo() {
        return m4296b();
    }

    public da(al alVar) {
        super("CloudReadingHistoryCachePrefix_" + alVar.f2360a, C0577j.f1885a, new db(), 0);
        this.f2999a = alVar;
    }

    /* renamed from: a */
    public void m4295a() {
        upgradeVersion(0);
    }

    /* renamed from: b */
    public dc m4296b() {
        dc dcVar = (dc) super.queryInfo();
        if (TextUtils.isEmpty(dcVar.f3000a)) {
            dcVar.f3000a = this.f2999a.f2360a;
            updateInfo(dcVar);
        }
        return dcVar;
    }
}
