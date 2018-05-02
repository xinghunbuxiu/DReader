package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;

import com.duokan.reader.common.cache.d;
import com.duokan.reader.common.cache.j;
import com.duokan.reader.domain.account.ab;

public class dd extends d {
    private final ab a;

    public /* synthetic */ Object queryInfo() {
        return b();
    }

    public dd(ab abVar) {
        super("CloudReadingHistoryCachePrefix_" + abVar.a, j.a, new de(), 0);
        this.a = abVar;
    }

    public void a() {
        upgradeVersion(0);
    }

    public df b() {
        df dfVar = (df) super.queryInfo();
        if (TextUtils.isEmpty(dfVar.a)) {
            dfVar.a = this.a.a;
            updateInfo(dfVar);
        }
        return dfVar;
    }
}
