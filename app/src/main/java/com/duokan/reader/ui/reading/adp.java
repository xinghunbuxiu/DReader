package com.duokan.reader.ui.reading;

import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.core.app.ActivatedController;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.UmengManager;
import com.duokan.reader.ui.general.web.StorePageController;

class adp implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ adx f9527a;
    /* renamed from: b */
    final /* synthetic */ TranslationController f9528b;

    adp(TranslationController translationController, adx adx) {
        this.f9528b = translationController;
        this.f9527a = adx;
    }

    public void onClick(View view) {
        UmengManager.get().onEvent("V2_READING_POPMENU", "DictWiki");
        ActivatedController storePageController = new StorePageController(this.f9528b.getContext());
        storePageController.loadUrl(String.format("http://zh.wikipedia.org/zh-cn/index.php?search=%s&fulltext=Search", new Object[]{Uri.encode(this.f9528b.f9170d.trim())}));
        ((ReaderFeature) this.f9528b.getContext().queryFeature(ReaderFeature.class)).pushPageSmoothly(storePageController, null);
        this.f9527a.mo2521a();
    }
}
