package com.duokan.reader.ui.reading;

class adv implements Runnable {
    final /* synthetic */ adm a;

    adv(adm com_duokan_reader_ui_reading_adm) {
        this.a = com_duokan_reader_ui_reading_adm;
    }

    public void run() {
        this.a.dismissPopup(this.a.l);
        this.a.l = null;
    }
}
