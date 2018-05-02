package com.duokan.reader.ui.p049a;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;

/* renamed from: com.duokan.reader.ui.a.p */
class C1230p implements TextWatcher {
    /* renamed from: a */
    final /* synthetic */ C1228n f5731a;

    C1230p(C1228n c1228n) {
        this.f5731a = c1228n;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        if (!TextUtils.isEmpty(editable.toString())) {
            this.f5731a.f5726a.m9960a(true);
        }
    }
}
