package com.duokan.reader.ui.bookshelf;

import com.duokan.p024c.C0258j;

class fx implements fi {
    /* renamed from: a */
    final /* synthetic */ fo f6472a;

    fx(fo foVar) {
        this.f6472a = foVar;
    }

    /* renamed from: a */
    public void mo1700a(boolean z, boolean z2) {
        if (z2) {
            this.f6472a.f6459b.setText(C0258j.bookshelf__shared__select_all);
            this.f6472a.f6459b.setEnabled(false);
            this.f6472a.f6459b.setSelected(true);
            return;
        }
        if (z) {
            this.f6472a.f6459b.setText(C0258j.bookshelf__shared__unselect_all);
        } else {
            this.f6472a.f6459b.setText(C0258j.bookshelf__shared__select_all);
        }
        this.f6472a.f6459b.setEnabled(true);
        this.f6472a.f6459b.setSelected(false);
    }
}
