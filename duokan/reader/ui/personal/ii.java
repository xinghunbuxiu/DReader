package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.core.app.MyContextWrapper;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.ui.store.bv;

class ii implements OnClickListener {
    final /* synthetic */ ih a;

    ii(ih ihVar) {
        this.a = ihVar;
    }

    public void onClick(View view) {
        ((ReaderFeature) this.a.getContext().queryFeature(ReaderFeature.class)).pushPageSmoothly(bv.a(MyContextWrapper.getFeature(this.a.getContext()), String.valueOf(0), 1, this.a.a.getBookUuid(), "redeem_" + this.a.a.getBookUuid()), null);
    }
}
