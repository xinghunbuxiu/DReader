package com.duokan.reader.ui.reading;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;

class adf implements OnClickListener {
    final /* synthetic */ TranslationController a;

    adf(TranslationController translationController) {
        this.a = translationController;
    }

    public void onClick(View view) {
        if (this.a.e == null || this.a.e.a != 1) {
            return;
        }
        if (!TextUtils.isEmpty(this.a.e.b)) {
            this.a.b(this.a.e.b);
        } else if (!TextUtils.isEmpty(this.a.e.c)) {
            this.a.c(this.a.e.c);
        }
    }
}
