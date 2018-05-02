package com.duokan.reader.ui.personal;

import android.text.Editable;
import android.text.TextWatcher;

class ob implements TextWatcher {
    /* renamed from: a */
    final /* synthetic */ oa f9031a;

    ob(oa oaVar) {
        this.f9031a = oaVar;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.length() > 0) {
            this.f9031a.f8374h.setVisibility(0);
        } else {
            this.f9031a.f8374h.setVisibility(4);
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        String trim = editable.toString().trim();
        if (this.f9031a.f8376j != null) {
            this.f9031a.f8376j.mo1719a(trim);
        }
    }
}
