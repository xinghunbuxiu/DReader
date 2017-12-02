package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.ReaderFeature;

class jc implements OnClickListener {
    final /* synthetic */ it a;

    jc(it itVar) {
        this.a = itVar;
    }

    public void onClick(View view) {
        ((ReaderFeature) this.a.getContext().queryFeature(ReaderFeature.class)).pushHalfPageSmoothly(new bg(this.a.getContext(), false), null);
    }
}
