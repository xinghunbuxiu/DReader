package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.domain.bookshelf.an;

class aq implements OnClickListener {
    final /* synthetic */ ai a;

    aq(ai aiVar) {
        this.a = aiVar;
    }

    public void onClick(View view) {
        if (this.a.b(this.a.h())) {
            this.a.a.b(this.a.h().d());
        } else {
            this.a.a.a((an[]) this.a.b.a(this.a.h()).toArray(new an[0]));
        }
    }
}
