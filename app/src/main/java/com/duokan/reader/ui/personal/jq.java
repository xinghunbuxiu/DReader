package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.ReaderFeature;
import com.duokan.reader.ui.account.z;

class jq implements OnClickListener {
    final /* synthetic */ it a;

    jq(it itVar) {
        this.a = itVar;
    }

    public void onClick(View view) {
        ((ReaderFeature) this.a.getContext().queryFeature(ReaderFeature.class)).pushHalfPageSmoothly(new z(this.a.getContext()), null);
    }
}
