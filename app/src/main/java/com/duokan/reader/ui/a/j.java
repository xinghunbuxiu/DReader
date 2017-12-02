package com.duokan.reader.ui.a;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.domain.store.DkStoreAbsBook;
import com.duokan.reader.ui.general.ap;

class j implements OnClickListener {
    final /* synthetic */ DkStoreAbsBook a;
    final /* synthetic */ View b;
    final /* synthetic */ a c;

    j(a aVar, DkStoreAbsBook dkStoreAbsBook, View view) {
        this.c = aVar;
        this.a = dkStoreAbsBook;
        this.b = view;
    }

    public void onClick(View view) {
        ap apVar = new ap(this.c.getContext());
        apVar.setPrompt(com.duokan.c.j.discovery__edit_feed_view__remove_this_book);
        apVar.setCancelLabel(com.duokan.c.j.general__shared__cancel);
        apVar.setOkLabel(com.duokan.c.j.general__shared__remove);
        apVar.open(new k(this));
    }
}
