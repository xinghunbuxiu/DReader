package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.c.j;
import com.duokan.reader.domain.cloud.DkUserReadBookManager.ReadBook;
import com.duokan.reader.ui.general.expandable.ViewMode;
import com.duokan.reader.ui.general.jq;

class ht implements OnClickListener {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ ReadBook c;
    final /* synthetic */ hs d;

    ht(hs hsVar, int i, int i2, ReadBook readBook) {
        this.d = hsVar;
        this.a = i;
        this.b = i2;
        this.c = readBook;
    }

    public void onClick(View view) {
        if (this.d.a.s.f() == ViewMode.Edit) {
            this.d.a.b(this.a, this.b);
        } else {
            new hu(this, jq.a(this.d.a.getContext(), "", this.d.a.a.getString(j.personal__readed_books_view__opening), true, true)).open();
        }
    }
}
