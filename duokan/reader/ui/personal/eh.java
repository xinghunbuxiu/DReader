package com.duokan.reader.ui.personal;

import com.duokan.reader.domain.bookshelf.BookState;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.is;
import com.duokan.reader.domain.bookshelf.iy;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import com.duokan.reader.ui.general.cm;

class eh implements cm {
    final /* synthetic */ CustomCloudItem a;
    final /* synthetic */ iy b;
    final /* synthetic */ is c;
    final /* synthetic */ ds d;

    eh(ds dsVar, CustomCloudItem customCloudItem, iy iyVar, is isVar) {
        this.d = dsVar;
        this.a = customCloudItem;
        this.b = iyVar;
        this.c = isVar;
    }

    public void onChoice(boolean z, FlowChargingTransferChoice flowChargingTransferChoice) {
        if (z) {
            c b = this.a.b();
            if (b == null) {
                b = ai.a().a(this.b, flowChargingTransferChoice.wifiOnly());
                if (b != null) {
                    this.c.a(b);
                    return;
                } else {
                    this.c.a("");
                    return;
                }
            } else if (b.i() == BookState.CLOUD_ONLY) {
                ai.a().a(b, this.b, flowChargingTransferChoice.wifiOnly());
                this.c.a(b);
                return;
            } else {
                this.c.a("");
                return;
            }
        }
        this.c.a("");
    }
}
