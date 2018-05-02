package com.duokan.reader.ui.reading;

import android.text.Editable;
import android.text.TextWatcher;

class yc implements TextWatcher {
    final /* synthetic */ yb a;

    yc(yb ybVar) {
        this.a = ybVar;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.a.b(charSequence.toString());
        this.a.e.setAdapter(new yi(this.a, null));
        this.a.e.a();
        this.a.c();
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
    }
}
