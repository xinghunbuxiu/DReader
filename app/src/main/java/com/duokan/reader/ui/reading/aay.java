package com.duokan.reader.ui.reading;

class aay implements Runnable {
    final /* synthetic */ aat a;

    aay(aat com_duokan_reader_ui_reading_aat) {
        this.a = com_duokan_reader_ui_reading_aat;
    }

    public void run() {
        if (this.a.a.j != null) {
            this.a.a.j.run();
            this.a.a.j = null;
        }
    }
}
