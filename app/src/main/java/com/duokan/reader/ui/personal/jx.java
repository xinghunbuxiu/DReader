package com.duokan.reader.ui.personal;

import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.cloud.DkCloudStoreBook;
import com.duokan.reader.ui.bookshelf.BookActionAssistant.BookAction;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import com.duokan.reader.ui.general.cm;
import com.duokan.reader.ui.store.o;

final class jx implements cm {
    final /* synthetic */ PurchasedBookItemView a;
    final /* synthetic */ DkCloudStoreBook b;
    final /* synthetic */ c c;

    jx(PurchasedBookItemView purchasedBookItemView, DkCloudStoreBook dkCloudStoreBook, c cVar) {
        this.a = purchasedBookItemView;
        this.b = dkCloudStoreBook;
        this.c = cVar;
    }

    public void onChoice(boolean z, FlowChargingTransferChoice flowChargingTransferChoice) {
        if (z) {
            if (this.a.e == this.b) {
                this.a.d.setEnabled(false);
                this.a.d.setAction(BookAction.CONNECTING);
            }
            o.a().b(this.c.H());
            o.a().a(this.c, new jy(this), flowChargingTransferChoice);
        }
    }
}
