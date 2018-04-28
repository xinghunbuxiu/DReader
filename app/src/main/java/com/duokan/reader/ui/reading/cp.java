package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.ui.general.ReaderUi;

class cp implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ cm f9948a;

    cp(cm cmVar) {
        this.f9948a = cmVar;
    }

    public void onClick(View view) {
        if (!this.f9948a.f9941a.am()) {
            ReaderUi.m10153a(this.f9948a.getActivity(), 11);
            this.f9948a.f9945e = true;
        }
        if (this.f9948a.f9941a.mo2004U() != PageAnimationMode.VSCROLL) {
            this.f9948a.f9941a.mo2030a(PageAnimationMode.VSCROLL);
            this.f9948a.f9945e = true;
        }
        this.f9948a.requestDetach();
    }
}
