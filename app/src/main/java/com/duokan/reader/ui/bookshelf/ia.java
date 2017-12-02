package com.duokan.reader.ui.bookshelf;

import android.text.TextUtils;

import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.u;
import com.duokan.reader.ui.general.be;

class ia implements u {
    final /* synthetic */ hp a;

    ia(hp hpVar) {
        this.a = hpVar;
    }

    public void onQueryAccountOk(a aVar) {
    }

    public void onQueryAccountError(a aVar, String str) {
        if (!TextUtils.isEmpty(str)) {
            be.a(this.a.getContext(), (CharSequence) str, 0).show();
        }
    }
}
