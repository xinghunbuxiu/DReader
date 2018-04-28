package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.AppContext;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.common.webservices.duokan.CommentBook;
import com.duokan.reader.common.webservices.duokan.af;
import com.duokan.reader.domain.bookshelf.BookType;
import com.duokan.reader.domain.statistics.C1163a;

class dt implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ CommentBook f10044a;
    /* renamed from: b */
    final /* synthetic */ af f10045b;
    /* renamed from: c */
    final /* synthetic */ int f10046c;
    /* renamed from: d */
    final /* synthetic */ dg f10047d;

    dt(dg dgVar, CommentBook commentBook, af afVar, int i) {
        this.f10047d = dgVar;
        this.f10044a = commentBook;
        this.f10045b = afVar;
        this.f10046c = i;
    }

    public void onClick(View view) {
        boolean z;
        ReaderFeature c = this.f10047d.f9993B;
        IFeature a = AppContext.getAppContext(this.f10047d.getContext());
        String bookUuid = this.f10044a.getBookUuid();
        String title = this.f10044a.getTitle();
        if (this.f10047d.f10025z.m4242o() != BookType.SERIAL) {
            z = true;
        } else {
            z = false;
        }
        c.showBookHomePage(a, bookUuid, title, z, null);
        if (this.f10047d.f10005f.mo2004U() != PageAnimationMode.VSCROLL) {
            C1163a.m8627k().m8648a("ending_page_recommendation_v3", "click", this.f10047d.getLabelPrefix() + this.f10045b.f2105d + "_related_book_" + this.f10046c, false);
        }
    }
}
