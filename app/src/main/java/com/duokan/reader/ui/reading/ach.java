package com.duokan.reader.ui.reading;

import com.duokan.reader.ui.reading.TextSelectionAssistant.IndicatorStatus;

class ach implements Runnable {
    final /* synthetic */ acg a;

    ach(acg com_duokan_reader_ui_reading_acg) {
        this.a = com_duokan_reader_ui_reading_acg;
    }

    public void run() {
        if (!this.a.d.e.K()) {
            TextSelectionAssistant textSelectionAssistant = new TextSelectionAssistant(this.a.d.e, 1);
            textSelectionAssistant.a(this.a.a, this.a.b, IndicatorStatus.FOOTER_DRAGGED);
            this.a.d.g.add(textSelectionAssistant);
            this.a.d.c(this.a.b.x, this.a.b.y, this.a.d.a, this.a.c);
            this.a.d.a(false);
        }
    }
}
