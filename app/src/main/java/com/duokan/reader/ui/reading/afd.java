package com.duokan.reader.ui.reading;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class afd implements OnTouchListener {
    final /* synthetic */ afc a;

    afd(afc com_duokan_reader_ui_reading_afc) {
        this.a = com_duokan_reader_ui_reading_afc;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 0) {
            return false;
        }
        this.a.dismiss();
        return true;
    }
}
