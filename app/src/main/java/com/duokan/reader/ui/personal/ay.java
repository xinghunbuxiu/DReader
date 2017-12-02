package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.core.app.x;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.micloud.i;
import com.duokan.reader.ui.bookshelf.BookActionAssistant;
import com.duokan.reader.ui.bookshelf.BookActionAssistant.BookAction;
import com.duokan.reader.ui.bookshelf.BookActionView;

class ay implements OnClickListener {
    final /* synthetic */ CloudItemStatus a;
    final /* synthetic */ CustomCloudItem b;
    final /* synthetic */ BookActionView c;
    final /* synthetic */ av d;

    ay(av avVar, CloudItemStatus cloudItemStatus, CustomCloudItem customCloudItem, BookActionView bookActionView) {
        this.d = avVar;
        this.a = cloudItemStatus;
        this.b = customCloudItem;
        this.c = bookActionView;
    }

    public void onClick(View view) {
        if (this.a == CloudItemStatus.CLOUD_DOWNLOADING) {
            c b = this.b.b();
            if (b != null) {
                if (b.Y()) {
                    this.c.setAction(BookAction.CONNECTING);
                }
                ((ReaderFeature) x.a(this.d.a).queryFeature(ReaderFeature.class)).openBook(b);
            }
        } else if (this.a == CloudItemStatus.LOCAL_UPLOADING) {
            i iVar = (i) this.b.a();
            if (iVar != null) {
                this.d.a(DkApp.get().getTopActivity(), iVar, BookActionAssistant.a(this.d.a, iVar).a);
            }
        } else if (this.a == CloudItemStatus.CLOUD_DOWNLOADED) {
            this.d.d.a(this.b);
        } else if (this.a == CloudItemStatus.CLOUD_ONLY || this.a == CloudItemStatus.CLOUD_BOOKSHELF) {
            this.c.setAction(BookAction.CONNECTING);
            this.b.a(true);
            this.d.d.a(this.b, new az(this));
        }
    }
}
