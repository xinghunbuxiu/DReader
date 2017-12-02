package com.duokan.reader.ui.bookshelf;

import android.text.TextUtils;

import com.duokan.c.j;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.u;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.ui.general.be;

import java.util.LinkedList;

class ax implements u {
    final /* synthetic */ LinkedList a;
    final /* synthetic */ ai b;

    ax(ai aiVar, LinkedList linkedList) {
        this.b = aiVar;
        this.a = linkedList;
    }

    public void onQueryAccountOk(a aVar) {
        this.b.a.b((c[]) this.a.toArray(new c[0]));
    }

    public void onQueryAccountError(a aVar, String str) {
        String string = this.b.getString(j.bookshelf__general_shared__upload_need_account);
        if (TextUtils.isEmpty(str)) {
            Object obj = string;
        }
        be.a(this.b.getContext(), r4, 0).show();
    }
}
