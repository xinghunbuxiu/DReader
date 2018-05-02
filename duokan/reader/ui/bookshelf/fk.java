package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.c.j;

class fk implements OnClickListener {
    final /* synthetic */ fh a;

    fk(fh fhVar) {
        this.a = fhVar;
    }

    public void onClick(View view) {
        this.a.a.setSelectBrowserFiles(this.a.b.getText().toString().equals(this.a.getContext().getString(j.bookshelf__shared__select_all)));
    }
}
