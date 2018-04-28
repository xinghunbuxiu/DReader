package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.core.app.AppContext;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.micloud.C1068i;
import com.duokan.reader.ui.bookshelf.BookActionAssistant;
import com.duokan.reader.ui.bookshelf.BookActionAssistant.BookAction;
import com.duokan.reader.ui.bookshelf.BookActionView;

class ar implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ CloudItemStatus f8281a;
    /* renamed from: b */
    final /* synthetic */ CustomCloudItem f8282b;
    /* renamed from: c */
    final /* synthetic */ BookActionView f8283c;
    /* renamed from: d */
    final /* synthetic */ ao f8284d;

    ar(ao aoVar, CloudItemStatus cloudItemStatus, CustomCloudItem customCloudItem, BookActionView bookActionView) {
        this.f8284d = aoVar;
        this.f8281a = cloudItemStatus;
        this.f8282b = customCloudItem;
        this.f8283c = bookActionView;
    }

    public void onClick(View view) {
        if (this.f8281a == CloudItemStatus.CLOUD_DOWNLOADING) {
            C0800c b = this.f8282b.m11340b();
            if (b != null) {
                if (b.aa()) {
                    this.f8283c.setAction(BookAction.CONNECTING);
                }
                ((ReaderFeature) AppContext.getAppContext(this.f8284d.f8270a).queryFeature(ReaderFeature.class)).openBook(b);
            }
        } else if (this.f8281a == CloudItemStatus.LOCAL_UPLOADING) {
            C1068i c1068i = (C1068i) this.f8282b.m11337a();
            if (c1068i != null) {
                this.f8284d.m11402a(DkApp.get().getTopActivity(), c1068i, BookActionAssistant.m9056a(this.f8284d.f8270a, c1068i).f6093a);
            }
        } else if (this.f8281a == CloudItemStatus.CLOUD_DOWNLOADED) {
            this.f8284d.f8272d.mo1898a(this.f8282b);
        } else if (this.f8281a == CloudItemStatus.CLOUD_ONLY || this.f8281a == CloudItemStatus.CLOUD_BOOKSHELF) {
            this.f8283c.setAction(BookAction.CONNECTING);
            this.f8282b.m11339a(true);
            this.f8284d.f8272d.mo1899a(this.f8282b, new as(this));
        }
    }
}
