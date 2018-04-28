package com.duokan.reader.ui.general;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.domain.bookshelf.BookState;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ai;

class hi implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ hh f7335a;

    hi(hh hhVar) {
        this.f7335a = hhVar;
    }

    public void onClick(View view) {
        if (this.f7335a.f7334d) {
            this.f7335a.m10742a();
            return;
        }
        C0800c b = ai.m3980a().m3906b(this.f7335a.f7332b);
        if (b == null || b.m4233i() == BookState.CLOUD_ONLY) {
            this.f7335a.m10744b();
        } else if (!b.m4171X()) {
            this.f7335a.m10747c();
        } else if (b.aa()) {
            this.f7335a.m10744b();
        }
    }
}
