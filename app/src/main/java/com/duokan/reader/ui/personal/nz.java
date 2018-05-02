package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.ReaderFeature;

class nz implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ nu f9028a;

    nz(nu nuVar) {
        this.f9028a = nuVar;
    }

    public void onClick(View view) {
        if (this.f9028a.m12369b()) {
            ((ReaderFeature) this.f9028a.getContext().queryFeature(ReaderFeature.class)).navigate("duokan-reader://store", null, false, null);
        }
    }
}
