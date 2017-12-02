package com.duokan.reader.ui.store;

import android.text.TextUtils;

import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.u;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.personal.bg;

class d implements u {
    final /* synthetic */ c a;

    d(c cVar) {
        this.a = cVar;
    }

    public void onQueryAccountOk(a aVar) {
        ((ReaderFeature) this.a.a.getContext().queryFeature(ReaderFeature.class)).pushPage(new bg(this.a.a.getContext(), true));
    }

    public void onQueryAccountError(a aVar, String str) {
        if (!TextUtils.isEmpty(str)) {
            be.a(this.a.a.getContext(), (CharSequence) str, 0).show();
        }
    }
}
