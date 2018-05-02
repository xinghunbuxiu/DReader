package com.duokan.reader.ui.bookshelf;

import com.duokan.c.j;

class fq implements fb {
    final /* synthetic */ fh a;

    fq(fh fhVar) {
        this.a = fhVar;
    }

    public void a(boolean z, boolean z2) {
        if (z2) {
            this.a.b.setText(j.bookshelf__shared__select_all);
            this.a.b.setEnabled(false);
            this.a.b.setSelected(true);
            return;
        }
        if (z) {
            this.a.b.setText(j.bookshelf__shared__unselect_all);
        } else {
            this.a.b.setText(j.bookshelf__shared__select_all);
        }
        this.a.b.setEnabled(true);
        this.a.b.setSelected(false);
    }
}
