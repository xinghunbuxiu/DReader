package com.duokan.reader.ui.bookshelf;

import android.text.TextUtils;
import com.duokan.core.sys.af;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.domain.bookshelf.BookPackageType;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.store.C0466h;
import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.domain.store.DkStoreItem;
import com.duokan.reader.ui.general.be;

class cd implements C0466h {
    /* renamed from: a */
    final /* synthetic */ cc f6249a;

    cd(cc ccVar) {
        this.f6249a = ccVar;
    }

    public void onFetchBookDetailOk(DkStoreItem dkStoreItem) {
        C0800c a = ai.m3980a().m3875a(dkStoreItem);
        if (a == null) {
            return;
        }
        if (!a.aB() || a.m4247s() == BookPackageType.EPUB_OPF) {
            this.f6249a.f6247c.openBook(a);
        } else if (C0559f.m2476b().m2485d() && (dkStoreItem instanceof DkStoreBookDetail)) {
            DkStoreBookDetail dkStoreBookDetail = (DkStoreBookDetail) dkStoreItem;
            if (!TextUtils.isEmpty(dkStoreBookDetail.getTrialUri())) {
                a.m4198a(a.m4225f(), dkStoreBookDetail.getTrialUri(), dkStoreBookDetail.getRevision(), dkStoreBookDetail.getTrialMd5(), false, new af(Boolean.valueOf(true)));
            }
        }
    }

    public void onFetchBookDetailError(String str) {
        if (!TextUtils.isEmpty(str)) {
            be.m10287a(this.f6249a.f6248d.getContext(), (CharSequence) str, 0).show();
        }
    }
}
