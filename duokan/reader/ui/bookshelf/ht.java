package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.domain.bookshelf.kp;
import com.duokan.reader.domain.cloud.PersonalPrefs;

class ht implements OnClickListener {
    final /* synthetic */ hp a;

    ht(hp hpVar) {
        this.a = hpVar;
    }

    public void onClick(View view) {
        this.a.e.setSelected(!this.a.e.isSelected());
        PersonalPrefs.a().a(this.a.e.isSelected());
        kp.a().a(true);
    }
}
