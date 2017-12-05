package com.duokan.reader.ui.general.web;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.TextView;

import com.duokan.c.d;

class fg implements TextWatcher {
    final /* synthetic */ TextView a;
    final /* synthetic */ ff b;

    fg(ff ffVar, TextView textView) {
        this.b = ffVar;
        this.a = textView;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (TextUtils.isEmpty(charSequence)) {
            this.a.setTextColor(this.b.g.b.pageController.getResources().getColor(d.general__shared__publish_button_cancel));
            this.a.setEnabled(false);
            return;
        }
        this.a.setTextColor(this.b.g.b.pageController.getResources().getColor(d.general__shared__publish_button_confirm));
        this.a.setEnabled(true);
    }

    public void afterTextChanged(Editable editable) {
    }
}
