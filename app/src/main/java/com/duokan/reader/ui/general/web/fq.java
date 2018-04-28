package com.duokan.reader.ui.general.web;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.TextView;
import com.duokan.p024c.C0252d;

class fq implements TextWatcher {
    /* renamed from: a */
    final /* synthetic */ TextView f7853a;
    /* renamed from: b */
    final /* synthetic */ fp f7854b;

    fq(fp fpVar, TextView textView) {
        this.f7854b = fpVar;
        this.f7853a = textView;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (TextUtils.isEmpty(charSequence)) {
            this.f7853a.setTextColor(this.f7854b.f7852g.f7845b.f7581b.getResources().getColor(C0252d.general__shared__publish_button_cancel));
            this.f7853a.setEnabled(false);
            return;
        }
        this.f7853a.setTextColor(this.f7854b.f7852g.f7845b.f7581b.getResources().getColor(C0252d.general__shared__publish_button_confirm));
        this.f7853a.setEnabled(true);
    }

    public void afterTextChanged(Editable editable) {
    }
}
