package com.duokan.reader.ui.reading;

import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.core.app.ActivatedController;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.UmengManager;
import com.duokan.reader.ui.general.web.StorePageController;

class adc implements OnClickListener {
    final /* synthetic */ adk a;
    final /* synthetic */ TranslationController b;

    adc(TranslationController translationController, adk com_duokan_reader_ui_reading_adk) {
        this.b = translationController;
        this.a = com_duokan_reader_ui_reading_adk;
    }

    public void onClick(View view) {
        UmengManager.get().onEvent("V2_READING_POPMENU", "DictWiki");
        ActivatedController storePageController = new StorePageController(this.b.getContext());
        storePageController.loadUrl(String.format("http://zh.wikipedia.org/zh-cn/index.php?search=%s&fulltext=Search", new Object[]{Uri.encode(this.b.d.trim())}));
        ((ReaderFeature) this.b.getContext().queryFeature(ReaderFeature.class)).pushPageSmoothly(storePageController, null);
        this.a.a();
    }
}
