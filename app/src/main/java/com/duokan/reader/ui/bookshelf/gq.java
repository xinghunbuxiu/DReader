package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.ReaderFeature;

class gq implements OnClickListener {
    final /* synthetic */ gp a;

    gq(gp gpVar) {
        this.a = gpVar;
    }

    public void onClick(View view) {
        ((ReaderFeature) this.a.a.queryFeature(ReaderFeature.class)).navigate("duokan-reader://store", null, false, null);
    }
}
