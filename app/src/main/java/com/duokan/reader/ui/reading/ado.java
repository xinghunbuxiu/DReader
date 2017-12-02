package com.duokan.reader.ui.reading;

import com.duokan.core.sys.ag;

class ado implements Runnable {
    final /* synthetic */ ag a;
    final /* synthetic */ aej b;
    final /* synthetic */ adm c;

    ado(adm com_duokan_reader_ui_reading_adm, ag agVar, aej com_duokan_reader_ui_reading_aej) {
        this.c = com_duokan_reader_ui_reading_adm;
        this.a = agVar;
        this.b = com_duokan_reader_ui_reading_aej;
    }

    public void run() {
        this.a.a(this.b);
    }
}
