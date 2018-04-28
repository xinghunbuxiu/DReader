package com.duokan.reader.ui.reading;

import com.duokan.reader.ui.reading.TextSelectionAssistant.IndicatorStatus;

class acz implements Runnable {
    /* renamed from: a */
    final /* synthetic */ acy f9497a;

    acz(acy acy) {
        this.f9497a = acy;
    }

    public void run() {
        if (!this.f9497a.f9496d.f9156e.mo1994K()) {
            TextSelectionAssistant textSelectionAssistant = new TextSelectionAssistant(this.f9497a.f9496d.f9156e, -1);
            textSelectionAssistant.m12539a(this.f9497a.f9493a, this.f9497a.f9494b, IndicatorStatus.HEADER_DRAGGED);
            this.f9497a.f9496d.f9158g.add(textSelectionAssistant);
            this.f9497a.f9496d.m12567c(this.f9497a.f9493a.x, this.f9497a.f9493a.y, this.f9497a.f9496d.f9152a, this.f9497a.f9495c);
            this.f9497a.f9496d.m12558a(false);
        }
    }
}
