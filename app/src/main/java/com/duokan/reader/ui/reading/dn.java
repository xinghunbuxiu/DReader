package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.domain.statistics.C1163a;

class dn implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ dg f10032a;

    dn(dg dgVar) {
        this.f10032a = dgVar;
    }

    public void onClick(View view) {
        this.f10032a.f9997F.run();
        C1163a.m8627k().m8648a("tip", "click", "reading_comment_page_tip_list_entrance_button", false);
    }
}
