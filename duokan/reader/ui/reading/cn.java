package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.ui.general.ReaderUi;

class cn implements OnClickListener {
    final /* synthetic */ ck a;

    cn(ck ckVar) {
        this.a = ckVar;
    }

    public void onClick(View view) {
        if (!this.a.a.am()) {
            ReaderUi.a(this.a.getActivity(), 11);
            this.a.e = true;
        }
        if (this.a.a.U() != PageAnimationMode.VSCROLL) {
            this.a.a.a(PageAnimationMode.VSCROLL);
            this.a.e = true;
        }
        this.a.requestDetach();
    }
}
