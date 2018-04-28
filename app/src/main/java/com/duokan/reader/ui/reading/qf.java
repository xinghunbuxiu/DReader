package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.p023b.C0247i;
import com.duokan.reader.ReaderFeature;

class qf implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ qb f10852a;

    qf(qb qbVar) {
        this.f10852a = qbVar;
    }

    public void onClick(View view) {
        boolean aK = this.f10852a.f10845a.aK();
        this.f10852a.f10845a.mo2144g(!aK);
        ((ReaderFeature) this.f10852a.getContext().queryFeature(ReaderFeature.class)).prompt(this.f10852a.getString(aK ? C0247i.reading__shared__eyes_saving_off : C0247i.reading__shared__eyes_saving_on));
        this.f10852a.m14924a();
    }
}
