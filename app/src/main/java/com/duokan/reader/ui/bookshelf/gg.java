package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.p024c.C0258j;

class gg implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ gf f6512a;

    gg(gf gfVar) {
        this.f6512a = gfVar;
    }

    public void onClick(View view) {
        if (this.f6512a.f6505d != this.f6512a.f6511j) {
            this.f6512a.m9719c();
            this.f6512a.f6504c.setText(this.f6512a.getContext().getString(C0258j.bookshelf__file_import_view__inverse));
            return;
        }
        this.f6512a.m9722d();
        this.f6512a.f6504c.setText(this.f6512a.getContext().getString(C0258j.bookshelf__file_import_view__all));
    }
}
