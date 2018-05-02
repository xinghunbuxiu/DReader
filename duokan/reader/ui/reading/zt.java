package com.duokan.reader.ui.reading;

import com.duokan.core.sys.ah;
import com.duokan.reader.domain.bookshelf.ej;

class zt implements Runnable {
    final /* synthetic */ aaq a;
    final /* synthetic */ ej b;
    final /* synthetic */ zo c;

    zt(zo zoVar, aaq com_duokan_reader_ui_reading_aaq, ej ejVar) {
        this.c = zoVar;
        this.a = com_duokan_reader_ui_reading_aaq;
        this.b = ejVar;
    }

    public void run() {
        ah.future(new zu(this));
    }
}
