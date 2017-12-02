package com.duokan.reader.ui.reading;

import com.duokan.core.sys.ag;

class adu implements ag {
    final /* synthetic */ adm a;

    adu(adm com_duokan_reader_ui_reading_adm) {
        this.a = com_duokan_reader_ui_reading_adm;
    }

    public void a(aej com_duokan_reader_ui_reading_aej) {
        if (this.a.j == com_duokan_reader_ui_reading_aej) {
            this.a.j = null;
            this.a.c.setVisibility(4);
            if (this.a.q != null) {
                this.a.q.d();
            }
        }
    }
}
