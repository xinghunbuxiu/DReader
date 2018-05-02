package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ui.general.ReaderUi;

class cl implements OnClickListener {
    final /* synthetic */ ck a;

    cl(ck ckVar) {
        this.a = ckVar;
    }

    public void onClick(View view) {
        if (!ReaderEnv.get().forHd() && this.a.a.am()) {
            ReaderUi.a(this.a.getActivity(), 1);
            this.a.e = true;
        }
        if (this.a.a.U() != PageAnimationMode.HSCROLL) {
            this.a.a.a(PageAnimationMode.HSCROLL);
            this.a.e = true;
        }
        this.a.requestDetach();
    }
}
