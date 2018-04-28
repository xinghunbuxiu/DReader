package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.bookshelf.BookState;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.cloud.DkCloudComment;
import com.duokan.reader.domain.document.C0896a;
import com.duokan.reader.domain.document.epub.C0952s;
import com.duokan.reader.ui.general.au;

class mq implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ DkCloudComment f8959a;
    /* renamed from: b */
    final /* synthetic */ mj f8960b;

    mq(mj mjVar, DkCloudComment dkCloudComment) {
        this.f8960b = mjVar;
        this.f8959a = dkCloudComment;
    }

    public void onClick(View view) {
        C0896a a = C0952s.m6987a(this.f8959a.getStartPos().m5591b(), this.f8959a.getStartPos().m5593c(), this.f8959a.getStartPos().m5594d());
        C0800c b;
        if (this.f8960b.f8951a.f8942d.isSerial()) {
            b = ai.m3980a().m3906b(this.f8960b.f8951a.f8942d.getBookUuid());
            if (b == null || b.m4233i() != BookState.NORMAL) {
                au.m10240a(this.f8960b.f8951a.getContext(), this.f8960b.f8951a.f8942d.getBookUuid(), a);
                return;
            } else {
                ((ReaderFeature) this.f8960b.f8951a.getContext().queryFeature(ReaderFeature.class)).openBook(b, a, null);
                return;
            }
        }
        b = ai.m3980a().m3906b(this.f8960b.f8951a.f8942d.getBookUuid());
        if (b != null && b.m4233i() == BookState.NORMAL) {
            ((ReaderFeature) this.f8960b.f8951a.getContext().queryFeature(ReaderFeature.class)).openBook(b, a, null);
        }
    }
}
