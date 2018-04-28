package com.duokan.reader.ui.bookshelf;

import android.text.TextUtils;
import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.ui.general.be;

class id implements C0666x {
    /* renamed from: a */
    final /* synthetic */ SignInBookshelfView f6588a;

    id(SignInBookshelfView signInBookshelfView) {
        this.f6588a = signInBookshelfView;
    }

    public void onQueryAccountOk(C0672a c0672a) {
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        if (!TextUtils.isEmpty(str)) {
            be.m10287a(this.f6588a.getContext(), (CharSequence) str, 0).show();
        }
    }
}
