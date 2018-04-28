package com.duokan.reader.ui.reading;

import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.core.app.ActivatedController;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.UmengManager;
import com.duokan.reader.ui.general.web.StorePageController;

class adn implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ adx f9524a;
    /* renamed from: b */
    final /* synthetic */ TranslationController f9525b;

    adn(TranslationController translationController, adx adx) {
        this.f9525b = translationController;
        this.f9524a = adx;
    }

    public void onClick(View view) {
        UmengManager.get().onEvent("V2_READING_POPMENU", "DictBaidu");
        ActivatedController storePageController = new StorePageController(this.f9525b.getContext());
        storePageController.loadUrl(String.format("http://baike.baidu.com/search/word?word=%s&pic=1&enc=utf8", new Object[]{Uri.encode(this.f9525b.f9170d.trim())}));
        ((ReaderFeature) this.f9525b.getContext().queryFeature(ReaderFeature.class)).pushPageSmoothly(storePageController, null);
        this.f9524a.mo2521a();
    }
}
