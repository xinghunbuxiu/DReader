package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ui.general.ReaderUi;

class co implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ cm f9947a;

    co(cm cmVar) {
        this.f9947a = cmVar;
    }

    public void onClick(View view) {
        if (!ReaderEnv.get().forHd() && this.f9947a.f9941a.am()) {
            ReaderUi.m10153a(this.f9947a.getActivity(), 1);
            this.f9947a.f9945e = true;
        }
        if (this.f9947a.f9941a.mo2004U() != PageAnimationMode.VSCROLL) {
            this.f9947a.f9941a.mo2030a(PageAnimationMode.VSCROLL);
            this.f9947a.f9945e = true;
        }
        this.f9947a.requestDetach();
    }
}
