package com.duokan.reader.ui.reading;

import com.duokan.reader.ui.reading.TextSelectionAssistant.IndicatorStatus;

class acm implements Runnable {
    final /* synthetic */ acl a;

    acm(acl com_duokan_reader_ui_reading_acl) {
        this.a = com_duokan_reader_ui_reading_acl;
    }

    public void run() {
        if (!this.a.d.e.K()) {
            TextSelectionAssistant textSelectionAssistant = new TextSelectionAssistant(this.a.d.e, -1);
            textSelectionAssistant.a(this.a.a, this.a.b, IndicatorStatus.HEADER_DRAGGED);
            this.a.d.g.add(textSelectionAssistant);
            this.a.d.c(this.a.a.x, this.a.a.y, this.a.d.a, this.a.c);
            this.a.d.a(false);
        }
    }
}
