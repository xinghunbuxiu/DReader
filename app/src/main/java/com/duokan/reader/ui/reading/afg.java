package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class afg implements OnClickListener {
    final /* synthetic */ afe a;

    private afg(afe com_duokan_reader_ui_reading_afe) {
        this.a = com_duokan_reader_ui_reading_afe;
    }

    public void onClick(View view) {
        this.a.b.dismiss();
        if (this.a.d != null && this.a.e != null) {
            this.a.e.c(this.a.d);
        }
    }
}
