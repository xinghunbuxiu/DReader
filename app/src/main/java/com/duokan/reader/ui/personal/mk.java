package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.ui.account.C1256h;

class mk implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ mj f8952a;

    mk(mj mjVar) {
        this.f8952a = mjVar;
    }

    public void onClick(View view) {
        if (this.f8952a.f8951a.f8944f != null && this.f8952a.e.size() > 0) {
            this.f8952a.f8951a.f8939a.showPopup(new C1256h(this.f8952a.f8951a.getContext(), this.f8952a.e, this.f8952a.f8951a.f8943e != null ? this.f8952a.f8951a.f8943e.getBookUuid() : this.f8952a.f8951a.f8942d.getBookUuid(), this.f8952a.f8951a.f8943e != null ? this.f8952a.f8951a.f8943e.getTitle() : this.f8952a.f8951a.f8942d.getTitle(), this.f8952a.f8951a.f8943e != null ? this.f8952a.f8951a.f8943e.getAuthorLine() : null));
        }
    }
}
