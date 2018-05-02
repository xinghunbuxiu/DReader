package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.core.ui.UTools;

class adt implements OnClickListener {
    final /* synthetic */ adm a;

    adt(adm com_duokan_reader_ui_reading_adm) {
        this.a = com_duokan_reader_ui_reading_adm;
    }

    public void onClick(View view) {
        if (this.a.e() && this.a.l == null) {
            this.a.l = new aem(this.a.getContext());
            this.a.showPopup(this.a.l);
            UTools.closeAnimation(this.a.l.getContentView(), null);
            this.a.f.setVisibility(4);
            UTools.showAnimation(this.a.f, null);
        }
    }
}
