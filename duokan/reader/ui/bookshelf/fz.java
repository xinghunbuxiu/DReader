package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.c.j;

class fz implements OnClickListener {
    final /* synthetic */ fy a;

    fz(fy fyVar) {
        this.a = fyVar;
    }

    public void onClick(View view) {
        if (this.a.d != this.a.j) {
            this.a.c();
            this.a.c.setText(this.a.getContext().getString(j.bookshelf__file_import_view__inverse));
            return;
        }
        this.a.d();
        this.a.c.setText(this.a.getContext().getString(j.bookshelf__file_import_view__all));
    }
}
