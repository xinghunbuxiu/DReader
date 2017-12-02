package com.duokan.reader.ui.a;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.duokan.c.j;
import com.duokan.core.ui.dv;
import com.duokan.reader.domain.store.DkStoreAbsBook;
import com.duokan.reader.ui.general.bz;

class l implements OnClickListener {
    final /* synthetic */ TextView a;
    final /* synthetic */ int b;
    final /* synthetic */ DkStoreAbsBook c;
    final /* synthetic */ a d;

    l(a aVar, TextView textView, int i, DkStoreAbsBook dkStoreAbsBook) {
        this.d = aVar;
        this.a = textView;
        this.b = i;
        this.c = dkStoreAbsBook;
    }

    public void onClick(View view) {
        bz bzVar = new bz(this.d.getContext());
        if (!TextUtils.equals(this.a.getText(), "")) {
            bzVar.a(this.a.getText());
        } else if (this.b < this.d.f.size()) {
            bzVar.a(String.format(this.d.getString(j.discovery__edit_feed_item_view__desc_default), new Object[]{((DkStoreAbsBook) this.d.f.get(this.b)).getTitle()}));
        }
        bzVar.getDecorView().setPadding(0, dv.b(this.d.getContext(), 50.0f), 0, 0);
        bzVar.setGravity(119);
        bzVar.a(new m(this, bzVar));
    }
}
