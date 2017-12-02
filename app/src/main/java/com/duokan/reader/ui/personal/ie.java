package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.c.j;
import com.duokan.reader.domain.cloud.DkUserReadBookManager.ReadBook;
import com.duokan.reader.ui.general.jq;

class ie implements OnClickListener {
    final /* synthetic */ ReadBook a;
    final /* synthetic */ hw b;

    ie(hw hwVar, ReadBook readBook) {
        this.b = hwVar;
        this.a = readBook;
    }

    public void onClick(View view) {
        new if(this, jq.a(this.b.getContext(), "", this.b.getString(j.personal__readed_books_view__opening), true, true)).open();
    }
}
