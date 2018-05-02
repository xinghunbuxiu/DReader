package com.duokan.reader.domain.bookshelf;

import android.annotation.SuppressLint;
import android.text.TextUtils;

import com.duokan.reader.common.cache.d;
import com.duokan.reader.common.cache.j;
import com.duokan.reader.domain.account.ab;

@SuppressLint({"UseSparseArrays"})
public class br extends d {
    private final ab a;

    public /* synthetic */ Object queryInfo() {
        return b();
    }

    public br(ab abVar) {
        super("CloudBookshelfCachePrefix_" + abVar.a, j.a, new bs(), 0);
        this.a = abVar;
    }

    public void a() {
        upgradeVersion(0);
    }

    public bt b() {
        bt btVar = (bt) super.queryInfo();
        if (TextUtils.isEmpty(btVar.a)) {
            btVar.a = this.a.a;
            updateInfo(btVar);
        }
        return btVar;
    }
}
