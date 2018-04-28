package com.duokan.reader.ui.reading;

import android.text.Editable;
import android.text.TextWatcher;

class yp implements TextWatcher {
    /* renamed from: a */
    final /* synthetic */ yo f11213a;

    yp(yo yoVar) {
        this.f11213a = yoVar;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f11213a.m15174b(charSequence.toString());
        this.f11213a.f11205e.setAdapter(new yv(this.f11213a, null));
        this.f11213a.f11205e.m9954a();
        this.f11213a.m15185c();
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
    }
}
