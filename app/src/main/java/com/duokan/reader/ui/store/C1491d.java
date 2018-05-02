package com.duokan.reader.ui.store;

import android.text.TextUtils;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.personal.az;

/* renamed from: com.duokan.reader.ui.store.d */
class C1491d implements C0666x {
    /* renamed from: a */
    final /* synthetic */ C1477c f11438a;

    C1491d(C1477c c1477c) {
        this.f11438a = c1477c;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        ((ReaderFeature) this.f11438a.f11387a.getContext().queryFeature(ReaderFeature.class)).pushPage(new az(this.f11438a.f11387a.getContext(), true));
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        if (!TextUtils.isEmpty(str)) {
            be.m10287a(this.f11438a.f11387a.getContext(), (CharSequence) str, 0).show();
        }
    }
}
