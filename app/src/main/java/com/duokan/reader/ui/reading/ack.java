package com.duokan.reader.ui.reading;

class ack implements Runnable {
    final /* synthetic */ acj a;

    ack(acj com_duokan_reader_ui_reading_acj) {
        this.a = com_duokan_reader_ui_reading_acj;
    }

    public void run() {
        if (!this.a.c.e.K()) {
            this.a.c.e().a(this.a.a);
            this.a.c.c(this.a.a.x, this.a.a.y, this.a.c.a, this.a.b);
            this.a.c.a(false);
        }
    }
}
