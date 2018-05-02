package com.duokan.reader.ui.account;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.core.app.MyContextWrapper;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.ui.personal.aj;

class ad implements OnClickListener {
    final /* synthetic */ z a;

    ad(z zVar) {
        this.a = zVar;
    }

    public void onClick(View view) {
        ((ReaderFeature) MyContextWrapper.getFeature(this.a.getContext()).queryFeature(ReaderFeature.class)).pushHalfPage(new aj(this.a.getContext()));
    }
}
