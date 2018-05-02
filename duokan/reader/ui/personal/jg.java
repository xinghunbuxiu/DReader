package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.ReaderFeature;

class jg implements OnClickListener {
    final /* synthetic */ it a;

    jg(it itVar) {
        this.a = itVar;
    }

    public void onClick(View view) {
        ((ReaderFeature) this.a.getContext().queryFeature(ReaderFeature.class)).pushHalfPageSmoothly(new bc(this.a.getContext()), null);
    }
}
