package com.duokan.reader.ui.reading;

import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.core.app.e;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.UmengManager;
import com.duokan.reader.ui.general.web.StorePageController;

class ada implements OnClickListener {
    final /* synthetic */ adk a;
    final /* synthetic */ TranslationController b;

    ada(TranslationController translationController, adk com_duokan_reader_ui_reading_adk) {
        this.b = translationController;
        this.a = com_duokan_reader_ui_reading_adk;
    }

    public void onClick(View view) {
        UmengManager.get().onEvent("V2_READING_POPMENU", "DictBaidu");
        e storePageController = new StorePageController(this.b.getContext());
        storePageController.loadUrl(String.format("http://baike.baidu.com/search/word?word=%s&pic=1&enc=utf8", new Object[]{Uri.encode(this.b.d.trim())}));
        ((ReaderFeature) this.b.getContext().queryFeature(ReaderFeature.class)).pushPageSmoothly(storePageController, null);
        this.a.a();
    }
}
