package com.duokan.reader.ui.general;

import android.text.Editable;
import android.text.TextWatcher;

class fb implements TextWatcher {
    /* renamed from: a */
    final /* synthetic */ fa f7208a;

    fb(fa faVar) {
        this.f7208a = faVar;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        if (this.f7208a.f7203c > 0) {
            this.f7208a.m10618d();
        }
    }
}
