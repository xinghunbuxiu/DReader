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

class dr implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ CommentBook f10039a;
    /* renamed from: b */
    final /* synthetic */ af f10040b;
    /* renamed from: c */
    final /* synthetic */ int f10041c;
    /* renamed from: d */
    final /* synthetic */ dg f10042d;

    dr(dg dgVar, CommentBook commentBook, af afVar, int i) {
        this.f10042d = dgVar;
        this.f10039a = commentBook;
        this.f10040b = afVar;
        this.f10041c = i;
    }

    public void onClick(View view) {
        boolean z;
        ReaderFeature c = this.f10042d.f9993B;
        IFeature a = AppContext.getAppContext(this.f10042d.getContext());
        String bookUuid = this.f10039a.getBookUuid();
        String title = this.f10039a.getTitle();
        if (this.f10042d.f10025z.m4242o() != BookType.SERIAL) {
            z = true;
        } else {
            z = false;
        }
        c.showBookHomePage(a, bookUuid, title, z, null);
        if (this.f10042d.f10005f.mo2004U() != PageAnimationMode.VSCROLL) {
            C1163a.m8627k().m8648a("ending_page_recommendation_v3", "click", this.f10042d.getLabelPrefix() + this.f10040b.f2105d + "_related_book_" + this.f10041c, false);
        }
    }
}
