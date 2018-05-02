package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.c.d;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderFeature;

class z implements OnClickListener {
    final /* synthetic */ w a;

    z(w wVar) {
        this.a = wVar;
    }

    public void onClick(View view) {
        this.a.e.setBackgroundColor(this.a.getResources().getColor(d.general__shared__cccccc));
        this.a.e.setClickable(false);
        ReaderEnv.get().setBookShelfType(this.a.f);
        ((ReaderFeature) this.a.getContext().queryFeature(ReaderFeature.class)).navigate("duokan-reader://bookshelf", null, false, null);
    }
}
