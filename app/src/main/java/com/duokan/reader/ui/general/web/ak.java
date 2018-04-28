package com.duokan.reader.ui.general.web;

import android.text.TextUtils;
import com.duokan.reader.common.C0619r;

class ak implements C0619r {
    /* renamed from: a */
    final /* synthetic */ aj f7579a;

    ak(aj ajVar) {
        this.f7579a = ajVar;
    }

    /* renamed from: a */
    public void mo1619a(String str) {
        this.f7579a.f7578a.mLocalSearchLoadTime = 0;
        if (!TextUtils.equals(this.f7579a.f7578a.mOpenFrom, "bookshelf")) {
            this.f7579a.f7578a.mHitWord = str;
        }
        this.f7579a.f7578a.mEditText.setText(str);
        this.f7579a.f7578a.mEditText.setSelection(str.length());
    }
}
