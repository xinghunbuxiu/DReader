package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.c.j;
import com.duokan.reader.UmengManager;
import com.duokan.reader.ui.general.jf;

class hi implements OnClickListener {
    final /* synthetic */ hd a;
    final /* synthetic */ hh b;

    hi(hh hhVar, hd hdVar) {
        this.b = hhVar;
        this.a = hdVar;
    }

    public void onClick(View view) {
        UmengManager.get().onEvent("V2_SHELF_CREATEGROUP", "FromList");
        this.b.b.dismiss();
        new jf(this.b.getContext(), this.b.getContext().getString(j.bookshelf__general_shared__new_category_name), "", new hj(this)).show();
    }
}
