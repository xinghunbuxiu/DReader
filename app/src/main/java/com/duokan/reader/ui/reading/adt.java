package com.duokan.reader.ui.reading;

import com.duokan.p024c.C0258j;

class adt implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ady f9535a;
    /* renamed from: b */
    final /* synthetic */ TranslationController f9536b;

    adt(TranslationController translationController, ady ady) {
        this.f9536b = translationController;
        this.f9535a = ady;
    }

    public void run() {
        if (this.f9535a != null && !this.f9536b.f9175i) {
            this.f9535a.mo2219a();
            this.f9536b.f9172f.setText(C0258j.reading__translation_view__loading);
            this.f9536b.f9172f.setVisibility(0);
            this.f9536b.f9172f.setCompoundDrawables(null, null, null, null);
            this.f9536b.f9175i = true;
        }
    }
}
