package com.duokan.reader.ui.general;

import android.text.Editable;
import android.text.TextWatcher;

class fd implements TextWatcher {
    final /* synthetic */ fc a;

    fd(fc fcVar) {
        this.a = fcVar;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        if (this.a.c > 0) {
            this.a.d();
        }
    }
}
