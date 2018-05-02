package com.duokan.reader.ui.reading;

import com.duokan.c.j;

class adg implements Runnable {
    final /* synthetic */ adl a;
    final /* synthetic */ TranslationController b;

    adg(TranslationController translationController, adl com_duokan_reader_ui_reading_adl) {
        this.b = translationController;
        this.a = com_duokan_reader_ui_reading_adl;
    }

    public void run() {
        if (this.a != null && !this.b.i) {
            this.a.a();
            this.b.f.setText(j.reading__translation_view__loading);
            this.b.f.setVisibility(0);
            this.b.f.setCompoundDrawables(null, null, null, null);
            this.b.i = true;
        }
    }
}
