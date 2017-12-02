package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.FrameLayout;

class ads extends FrameLayout {
    final /* synthetic */ adm a;

    ads(adm com_duokan_reader_ui_reading_adm, Context context) {
        this.a = com_duokan_reader_ui_reading_adm;
        super(context);
    }

    protected void onDraw(Canvas canvas) {
        this.a.a(canvas);
    }
}
