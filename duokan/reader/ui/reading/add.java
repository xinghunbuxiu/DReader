package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.UmengManager;

class add implements OnClickListener {
    final /* synthetic */ sh a;
    final /* synthetic */ adk b;
    final /* synthetic */ TranslationController c;

    add(TranslationController translationController, sh shVar, adk com_duokan_reader_ui_reading_adk) {
        this.c = translationController;
        this.a = shVar;
        this.b = com_duokan_reader_ui_reading_adk;
    }

    public void onClick(View view) {
        UmengManager.get().onEvent("V2_READING_POPMENU", "DictIciba");
        this.a.a(this.c.d);
        this.b.a();
    }
}
