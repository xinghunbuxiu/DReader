package com.duokan.reader.ui.a;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;

class p implements TextWatcher {
    final /* synthetic */ n a;

    p(n nVar) {
        this.a = nVar;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        if (!TextUtils.isEmpty(editable.toString())) {
            this.a.a.a(true);
        }
    }
}
