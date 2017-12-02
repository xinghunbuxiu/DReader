package com.duokan.reader.ui.reading;

import java.util.Map;

class aac implements Runnable {
    final /* synthetic */ Map a;
    final /* synthetic */ aab b;

    aac(aab com_duokan_reader_ui_reading_aab, Map map) {
        this.b = com_duokan_reader_ui_reading_aab;
        this.a = map;
    }

    public void run() {
        this.b.e.i_();
        this.b.e.c.b(new aad(this));
    }
}
