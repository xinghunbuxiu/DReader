package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.core.app.x;
import com.duokan.reader.ReaderFeature;

class o implements OnClickListener {
    final /* synthetic */ g a;

    o(g gVar) {
        this.a = gVar;
    }

    public void onClick(View view) {
        ((ReaderFeature) x.a(this.a.getContext()).queryFeature(ReaderFeature.class)).navigate("duokan-reader://store", null, false, null);
    }
}
