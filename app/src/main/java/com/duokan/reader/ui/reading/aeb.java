package com.duokan.reader.ui.reading;

import com.duokan.core.diagnostic.LogLevel;

class aeb implements Runnable {
    final /* synthetic */ aea a;

    aeb(aea com_duokan_reader_ui_reading_aea) {
        this.a = com_duokan_reader_ui_reading_aea;
    }

    public void run() {
        if (!this.a.e) {
            a.c().c(LogLevel.WARNING, "tts", "Task takes too long.");
        }
    }
}
