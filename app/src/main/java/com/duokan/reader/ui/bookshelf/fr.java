package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.p024c.C0258j;

class fr implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ fo f6466a;

    fr(fo foVar) {
        this.f6466a = foVar;
    }

    public void onClick(View view) {
        this.f6466a.f6458a.setSelectBrowserFiles(this.f6466a.f6459b.getText().toString().equals(this.f6466a.getContext().getString(C0258j.bookshelf__shared__select_all)));
    }
}
