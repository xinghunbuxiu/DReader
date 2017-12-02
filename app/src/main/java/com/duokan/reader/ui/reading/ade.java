package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.plugins.dict.DictDownloadController;

class ade implements OnClickListener {
    final /* synthetic */ adk a;
    final /* synthetic */ TranslationController b;

    ade(TranslationController translationController, adk com_duokan_reader_ui_reading_adk) {
        this.b = translationController;
        this.a = com_duokan_reader_ui_reading_adk;
    }

    public void onClick(View view) {
        ((ReaderFeature) this.b.getContext().queryFeature(ReaderFeature.class)).pushHalfPageSmoothly(new DictDownloadController(this.b.getContext()), null);
        this.a.a();
    }
}
