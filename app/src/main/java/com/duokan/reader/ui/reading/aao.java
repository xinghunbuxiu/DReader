package com.duokan.reader.ui.reading;

import com.duokan.core.app.x;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.statistics.dailystats.a;

class aao implements Runnable {
    final /* synthetic */ aaj a;

    aao(aaj com_duokan_reader_ui_reading_aaj) {
        this.a = com_duokan_reader_ui_reading_aaj;
    }

    public void run() {
        if (this.a.d.f.k()) {
            this.a.d.H();
        } else if (!this.a.d.f.U()) {
            a.d().c(this.a.d.f.H(), this.a.d.f.G().c);
            ((ReaderFeature) x.a(this.a.d.getContext()).queryFeature(ReaderFeature.class)).downloadBooks(this.a.d.f);
        }
    }
}
