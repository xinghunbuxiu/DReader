package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.b.i;
import com.duokan.reader.ReaderFeature;

class pv implements OnClickListener {
    final /* synthetic */ pr a;

    pv(pr prVar) {
        this.a = prVar;
    }

    public void onClick(View view) {
        boolean aK = this.a.a.aK();
        this.a.a.g(!aK);
        ((ReaderFeature) this.a.getContext().queryFeature(ReaderFeature.class)).prompt(this.a.getString(aK ? i.reading__shared__eyes_saving_off : i.reading__shared__eyes_saving_on));
        this.a.a();
    }
}
