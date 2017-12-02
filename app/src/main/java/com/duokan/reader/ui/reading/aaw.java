package com.duokan.reader.ui.reading;

class aaw implements Runnable {
    final /* synthetic */ CurlDirection a;
    final /* synthetic */ aat b;

    aaw(aat com_duokan_reader_ui_reading_aat, CurlDirection curlDirection) {
        this.b = com_duokan_reader_ui_reading_aat;
        this.a = curlDirection;
    }

    public void run() {
        if (this.a == CurlDirection.PAGE_DOWN) {
            this.b.a.a.u();
        } else {
            this.b.a.a.t();
        }
    }
}
