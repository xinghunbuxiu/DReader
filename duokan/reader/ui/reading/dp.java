package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.core.app.IFeature;
import com.duokan.core.app.MyContextWrapper;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.common.webservices.duokan.CommentBook;
import com.duokan.reader.common.webservices.duokan.af;
import com.duokan.reader.domain.bookshelf.BookType;

class dp implements OnClickListener {
    final /* synthetic */ CommentBook a;
    final /* synthetic */ af b;
    final /* synthetic */ int c;
    final /* synthetic */ de d;

    dp(de deVar, CommentBook commentBook, af afVar, int i) {
        this.d = deVar;
        this.a = commentBook;
        this.b = afVar;
        this.c = i;
    }

    public void onClick(View view) {
        boolean z;
        ReaderFeature c = this.d.A;
        IFeature a = MyContextWrapper.getFeature(this.d.getContext());
        String bookUuid = this.a.getBookUuid();
        String title = this.a.getTitle();
        if (this.d.y.o() != BookType.SERIAL) {
            z = true;
        } else {
            z = false;
        }
        c.showBookHomePage(a, bookUuid, title, z, null);
        if (this.d.e.U() != PageAnimationMode.VSCROLL) {
            a.k().a("ending_page_recommendation_v3", "click", this.d.getLabelPrefix() + this.b.d + "_related_book_" + this.c, false);
        }
    }
}
