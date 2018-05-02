package com.duokan.reader.ui.personal;

import android.text.Editable;
import android.text.TextWatcher;

class nn implements TextWatcher {
    final /* synthetic */ nm a;

    nn(nm nmVar) {
        this.a = nmVar;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.length() > 0) {
            this.a.g.setVisibility(0);
        } else {
            this.a.g.setVisibility(4);
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        String trim = editable.toString().trim();
        if (this.a.i != null) {
            this.a.i.a(trim);
        }
    }
}
