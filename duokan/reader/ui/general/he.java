package com.duokan.reader.ui.general;

import android.content.Context;

import com.duokan.core.ui.cv;

class he extends cv {
    final /* synthetic */ hd a;

    he(hd hdVar, Context context, boolean z) {
        this.a = hdVar;
        super(context, z);
    }

    protected boolean onBack() {
        if (this.a.isActive()) {
            getActivity().onBackPressed();
        }
        return true;
    }
}
