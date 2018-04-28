package com.duokan.reader.ui.reading;

import com.duokan.reader.ui.reading.TextSelectionAssistant.IndicatorStatus;

class acu implements Runnable {
    /* renamed from: a */
    final /* synthetic */ act f9485a;

    acu(act act) {
        this.f9485a = act;
    }

    public void run() {
        if (!this.f9485a.f9484d.f9156e.mo1994K()) {
            TextSelectionAssistant textSelectionAssistant = new TextSelectionAssistant(this.f9485a.f9484d.f9156e, 1);
            textSelectionAssistant.m12539a(this.f9485a.f9481a, this.f9485a.f9482b, IndicatorStatus.FOOTER_DRAGGED);
            this.f9485a.f9484d.f9158g.add(textSelectionAssistant);
            this.f9485a.f9484d.m12567c(this.f9485a.f9482b.x, this.f9485a.f9482b.y, this.f9485a.f9484d.f9152a, this.f9485a.f9483c);
            this.f9485a.f9484d.m12558a(false);
        }
    }
}
