package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.ReaderFeature;

class gx implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ gw f6534a;

    gx(gw gwVar) {
        this.f6534a = gwVar;
    }

    public void onClick(View view) {
        ((ReaderFeature) this.f6534a.f6530a.queryFeature(ReaderFeature.class)).navigate("duokan-reader://store", null, false, null);
    }
}
