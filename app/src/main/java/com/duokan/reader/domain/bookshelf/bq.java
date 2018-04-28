package com.duokan.reader.domain.bookshelf;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.duokan.reader.common.cache.C0572d;
import com.duokan.reader.common.cache.C0577j;
import com.duokan.reader.domain.account.al;
import org.json.JSONObject;

@SuppressLint({"UseSparseArrays"})
public class bq extends C0572d<bs, bt, JSONObject> {
    /* renamed from: a */
    private final al f2853a;

    public /* synthetic */ Object queryInfo() {
        return m4054b();
    }

    public bq(al alVar) {
        super("CloudBookshelfCachePrefix_" + alVar.f2360a, C0577j.f1885a, new br(), 0);
        this.f2853a = alVar;
    }

    /* renamed from: a */
    public void m4053a() {
        upgradeVersion(0);
    }

    /* renamed from: b */
    public bs m4054b() {
        bs bsVar = (bs) super.queryInfo();
        if (TextUtils.isEmpty(bsVar.f2854a)) {
            bsVar.f2854a = this.f2853a.f2360a;
            updateInfo(bsVar);
        }
        return bsVar;
    }
}
