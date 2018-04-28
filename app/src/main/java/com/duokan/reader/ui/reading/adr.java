package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.plugins.dict.DictDownloadController;

class adr implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ adx f9532a;
    /* renamed from: b */
    final /* synthetic */ TranslationController f9533b;

    adr(TranslationController translationController, adx adx) {
        this.f9533b = translationController;
        this.f9532a = adx;
    }

    public void onClick(View view) {
        ((ReaderFeature) this.f9533b.getContext().queryFeature(ReaderFeature.class)).pushHalfPageSmoothly(new DictDownloadController(this.f9533b.getContext()), null);
        this.f9532a.mo2521a();
    }
}
