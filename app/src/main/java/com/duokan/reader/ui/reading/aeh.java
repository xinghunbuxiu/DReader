package com.duokan.reader.ui.reading;

import android.view.MotionEvent;
import android.view.View;

import com.duokan.core.ui.ct;
import com.duokan.core.ui.er;
import com.duokan.core.ui.es;

class aeh extends er {
    final /* synthetic */ adm a;
    private final ct c;

    private aeh(adm com_duokan_reader_ui_reading_adm) {
        this.a = com_duokan_reader_ui_reading_adm;
        this.c = new ct();
    }

    protected void a(View view, boolean z) {
        this.c.b(view, z);
    }

    protected void a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        if (this.a.e()) {
            this.c.b(view, motionEvent, z, new aei(this));
        } else {
            b(false);
        }
    }
}
