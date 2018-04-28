package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.ReaderEnv;

class wo implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ wd f11119a;

    wo(wd wdVar) {
        this.f11119a = wdVar;
    }

    public void onClick(View view) {
        view.setSelected(!view.isSelected());
        ReaderEnv.get().setKeepReading(view.isSelected());
    }
}
