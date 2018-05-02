package com.duokan.reader.ui.reading;

class aaz implements Runnable {
    final /* synthetic */ aat a;

    aaz(aat com_duokan_reader_ui_reading_aat) {
        this.a = com_duokan_reader_ui_reading_aat;
    }

    public void run() {
        if (this.a.a.i != null) {
            this.a.a.i.run();
            this.a.a.i = null;
        }
    }
}
