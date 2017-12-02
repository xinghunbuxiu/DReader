package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.domain.statistics.a;

class di implements OnClickListener {
    final /* synthetic */ de a;

    di(de deVar) {
        this.a = deVar;
    }

    public void onClick(View view) {
        this.a.E.run();
        a.k().a("tip", "click", "reading_comment_page_tip_list_entrance_arrow", false);
    }
}
