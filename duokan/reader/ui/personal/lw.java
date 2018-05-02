package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.ui.account.t;

class lw implements OnClickListener {
    final /* synthetic */ lv a;

    lw(lv lvVar) {
        this.a = lvVar;
    }

    public void onClick(View view) {
        if (this.a.a.f != null && this.a.e.size() > 0) {
            this.a.a.a.showPopup(new t(this.a.a.getContext(), this.a.e, this.a.a.e != null ? this.a.a.e.getBookUuid() : this.a.a.d.getBookUuid(), this.a.a.e != null ? this.a.a.e.getTitle() : this.a.a.d.getTitle(), this.a.a.e != null ? this.a.a.e.getAuthorLine() : null));
        }
    }
}
