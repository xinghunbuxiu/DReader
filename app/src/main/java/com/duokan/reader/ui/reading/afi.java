package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class afi implements OnClickListener {
    final /* synthetic */ afh a;

    afi(afh com_duokan_reader_ui_reading_afh) {
        this.a = com_duokan_reader_ui_reading_afh;
    }

    public void onClick(View view) {
        this.a.u();
        if (this.a.n().isPlaying()) {
            this.a.n().pause();
            this.a.b.b();
            this.a.s = true;
            this.a.o();
        } else if (this.a.r) {
            this.a.n().start();
            this.a.b.c();
            this.a.s = false;
            this.a.o();
        } else {
            this.a.t();
        }
    }
}
