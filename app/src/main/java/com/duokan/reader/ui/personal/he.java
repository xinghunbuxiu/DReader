package com.duokan.reader.ui.personal;

import android.text.TextUtils;

import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.u;
import com.duokan.reader.ui.general.be;

class he implements u {
    final /* synthetic */ hd a;

    he(hd hdVar) {
        this.a = hdVar;
    }

    public void onQueryAccountOk(a aVar) {
    }

    public void onQueryAccountError(a aVar, String str) {
        if (!TextUtils.isEmpty(str)) {
            be.a(this.a.a.getContext(), (CharSequence) str, 0).show();
        }
    }
}
