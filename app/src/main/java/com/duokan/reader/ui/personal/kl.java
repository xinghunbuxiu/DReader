package com.duokan.reader.ui.personal;

import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.cloud.DkCloudStoreBook;
import com.duokan.reader.ui.bookshelf.BookActionAssistant.BookAction;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import com.duokan.reader.ui.general.cm;
import com.duokan.reader.ui.store.C1502o;

final class kl implements cm {
    /* renamed from: a */
    final /* synthetic */ PurchasedBookItemView f8816a;
    /* renamed from: b */
    final /* synthetic */ DkCloudStoreBook f8817b;
    /* renamed from: c */
    final /* synthetic */ C0800c f8818c;

    kl(PurchasedBookItemView purchasedBookItemView, DkCloudStoreBook dkCloudStoreBook, C0800c c0800c) {
        this.f8816a = purchasedBookItemView;
        this.f8817b = dkCloudStoreBook;
        this.f8818c = c0800c;
    }

    public void onChoice(boolean z, FlowChargingTransferChoice flowChargingTransferChoice) {
        if (z) {
            if (this.f8816a.f8227e == this.f8817b) {
                this.f8816a.f8226d.setEnabled(false);
                this.f8816a.f8226d.setAction(BookAction.CONNECTING);
            }
            C1502o.m15410a().m15435b(this.f8818c.getId());
            C1502o.m15410a().m15429a(this.f8818c, new km(this), flowChargingTransferChoice);
        }
    }
}
