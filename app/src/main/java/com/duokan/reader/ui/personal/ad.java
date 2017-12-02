package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.BookshelfItemStyle;

class ad implements OnClickListener {
    final /* synthetic */ aa a;

    ad(aa aaVar) {
        this.a = aaVar;
    }

    public void onClick(View view) {
        ReaderEnv.get().setBookshelfItemStyle(ReaderEnv.get().getBookshelfItemStyle() == BookshelfItemStyle.SIMPLE ? BookshelfItemStyle.TRADITIONAL : BookshelfItemStyle.SIMPLE);
        this.a.e.setSelected(ReaderEnv.get().getBookshelfItemStyle() != BookshelfItemStyle.SIMPLE);
    }
}
