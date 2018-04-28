package com.duokan.reader.ui.reading;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;

class ads implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ TranslationController f9534a;

    ads(TranslationController translationController) {
        this.f9534a = translationController;
    }

    public void onClick(View view) {
        if (this.f9534a.f9171e == null || this.f9534a.f9171e.f5420a != 1) {
            return;
        }
        if (!TextUtils.isEmpty(this.f9534a.f9171e.f5421b)) {
            this.f9534a.m12596b(this.f9534a.f9171e.f5421b);
        } else if (!TextUtils.isEmpty(this.f9534a.f9171e.f5422c)) {
            this.f9534a.m12598c(this.f9534a.f9171e.f5422c);
        }
    }
}
