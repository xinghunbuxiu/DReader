package com.duokan.reader.ui.reading;

class acp implements Runnable {
    final /* synthetic */ aco a;

    acp(aco com_duokan_reader_ui_reading_aco) {
        this.a = com_duokan_reader_ui_reading_aco;
    }

    public void run() {
        if (!this.a.c.e.K()) {
            this.a.c.e().a(this.a.a);
            this.a.c.c(this.a.a.x, this.a.a.y, this.a.c.a, this.a.b);
            this.a.c.a(false);
        }
    }
}
