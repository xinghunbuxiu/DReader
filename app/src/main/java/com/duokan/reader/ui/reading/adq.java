package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.UmengManager;

class adq implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ su f9529a;
    /* renamed from: b */
    final /* synthetic */ adx f9530b;
    /* renamed from: c */
    final /* synthetic */ TranslationController f9531c;

    adq(TranslationController translationController, su suVar, adx adx) {
        this.f9531c = translationController;
        this.f9529a = suVar;
        this.f9530b = adx;
    }

    public void onClick(View view) {
        UmengManager.get().onEvent("V2_READING_POPMENU", "DictIciba");
        this.f9529a.mo2036a(this.f9531c.f9170d);
        this.f9530b.mo2521a();
    }
}
