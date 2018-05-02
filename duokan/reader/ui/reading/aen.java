package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class aen implements OnClickListener {
    final /* synthetic */ aem a;

    aen(aem com_duokan_reader_ui_reading_aem) {
        this.a = com_duokan_reader_ui_reading_aem;
    }

    public void onClick(View view) {
        this.a.requestDetach();
    }
}
