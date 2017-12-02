package com.duokan.reader.ui.general;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.domain.bookshelf.BookState;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.c;

class ht implements OnClickListener {
    final /* synthetic */ hs a;

    ht(hs hsVar) {
        this.a = hsVar;
    }

    public void onClick(View view) {
        if (this.a.d) {
            this.a.a();
            return;
        }
        c b = ai.a().b(this.a.b);
        if (b == null || b.i() == BookState.CLOUD_ONLY) {
            this.a.b();
        } else if (!b.V()) {
            this.a.c();
        } else if (b.Y()) {
            this.a.b();
        }
    }
}
