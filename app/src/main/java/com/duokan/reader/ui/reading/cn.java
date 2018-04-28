package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ui.general.ReaderUi;

class cn implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ cm f9946a;

    cn(cm cmVar) {
        this.f9946a = cmVar;
    }

    public void onClick(View view) {
        if (!ReaderEnv.get().forHd() && this.f9946a.f9941a.am()) {
            ReaderUi.m10153a(this.f9946a.getActivity(), 1);
            this.f9946a.f9945e = true;
        }
        if (this.f9946a.f9941a.mo2004U() != PageAnimationMode.HSCROLL) {
            this.f9946a.f9941a.mo2030a(PageAnimationMode.HSCROLL);
            this.f9946a.f9945e = true;
        }
        this.f9946a.requestDetach();
    }
}
