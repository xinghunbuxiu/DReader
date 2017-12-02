package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.bookshelf.BookState;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.cloud.DkCloudComment;
import com.duokan.reader.domain.document.a;
import com.duokan.reader.domain.document.epub.s;
import com.duokan.reader.ui.general.au;

class mc implements OnClickListener {
    final /* synthetic */ DkCloudComment a;
    final /* synthetic */ lv b;

    mc(lv lvVar, DkCloudComment dkCloudComment) {
        this.b = lvVar;
        this.a = dkCloudComment;
    }

    public void onClick(View view) {
        a a = s.a(this.a.getStartPos().b(), this.a.getStartPos().c(), this.a.getStartPos().d());
        c b;
        if (this.b.a.d.isSerial()) {
            b = ai.a().b(this.b.a.d.getBookUuid());
            if (b == null || b.i() != BookState.NORMAL) {
                au.a(this.b.a.getContext(), this.b.a.d.getBookUuid(), a);
                return;
            } else {
                ((ReaderFeature) this.b.a.getContext().queryFeature(ReaderFeature.class)).openBook(b, a, null);
                return;
            }
        }
        b = ai.a().b(this.b.a.d.getBookUuid());
        if (b != null && b.i() == BookState.NORMAL) {
            ((ReaderFeature) this.b.a.getContext().queryFeature(ReaderFeature.class)).openBook(b, a, null);
        }
    }
}
