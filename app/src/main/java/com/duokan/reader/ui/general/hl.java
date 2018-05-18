package com.duokan.reader.ui.general;

import android.text.TextUtils;
import com.duokan.core.ui.BaseDialog;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.C0613k;
import com.duokan.reader.domain.cloud.DkCloudPurchasedBook;
import com.duokan.reader.domain.store.C0466h;
import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.domain.store.DkStoreItem;
import com.duokan.reader.ui.bookshelf.be;

class hl implements C0466h {
    /* renamed from: a */
    final /* synthetic */ C0613k f7340a;
    /* renamed from: b */
    final /* synthetic */ BaseDialog f7341b;
    /* renamed from: c */
    final /* synthetic */ DkCloudPurchasedBook f7342c;
    /* renamed from: d */
    final /* synthetic */ hh f7343d;

    hl(hh hhVar, C0613k c0613k, BaseDialog dialog, DkCloudPurchasedBook dkCloudPurchasedBook) {
        this.f7343d = hhVar;
        this.f7340a = c0613k;
        this.f7341b = dialog;
        this.f7342c = dkCloudPurchasedBook;
    }

    public void onFetchBookDetailOk(DkStoreItem dkStoreItem) {
        if (!((Boolean) this.f7340a.m2795a()).booleanValue()) {
            this.f7341b.dismiss();
            DkStoreBookDetail dkStoreBookDetail = (DkStoreBookDetail) dkStoreItem;
            be.m9188a(DkApp.get().getTopActivity(), dkStoreBookDetail.getEpubSize(), new hm(this, dkStoreBookDetail));
        }
    }

    public void onFetchBookDetailError(String str) {
        if (!((Boolean) this.f7340a.m2795a()).booleanValue()) {
            this.f7341b.dismiss();
            if (!TextUtils.isEmpty(str)) {
                be.m10287a(DkApp.get().getTopActivity(), (CharSequence) str, 1).show();
            }
        }
    }
}
