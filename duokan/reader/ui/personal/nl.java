package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.ReaderFeature;

class nl implements OnClickListener {
    final /* synthetic */ ng a;

    nl(ng ngVar) {
        this.a = ngVar;
    }

    public void onClick(View view) {
        if (this.a.b()) {
            ((ReaderFeature) this.a.getContext().queryFeature(ReaderFeature.class)).navigate("duokan-reader://store", null, false, null);
        }
    }
}
