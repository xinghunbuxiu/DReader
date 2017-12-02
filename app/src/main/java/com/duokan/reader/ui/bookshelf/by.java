package com.duokan.reader.ui.bookshelf;

import android.text.TextUtils;

import com.duokan.core.sys.af;
import com.duokan.reader.common.c.f;
import com.duokan.reader.domain.bookshelf.BookPackageType;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.domain.store.DkStoreItem;
import com.duokan.reader.domain.store.h;
import com.duokan.reader.ui.general.be;

class by implements h {
    final /* synthetic */ bx a;

    by(bx bxVar) {
        this.a = bxVar;
    }

    public void onFetchBookDetailOk(DkStoreItem dkStoreItem) {
        c a = ai.a().a(dkStoreItem);
        if (a == null) {
            return;
        }
        if (!a.az() || a.s() == BookPackageType.EPUB_OPF) {
            this.a.c.openBook(a);
        } else if (f.b().d() && (dkStoreItem instanceof DkStoreBookDetail)) {
            DkStoreBookDetail dkStoreBookDetail = (DkStoreBookDetail) dkStoreItem;
            if (!TextUtils.isEmpty(dkStoreBookDetail.getTrialUri())) {
                a.a(a.f(), dkStoreBookDetail.getTrialUri(), dkStoreBookDetail.getRevision(), dkStoreBookDetail.getTrialMd5(), false, new af(Boolean.valueOf(true)));
            }
        }
    }

    public void onFetchBookDetailError(String str) {
        if (!TextUtils.isEmpty(str)) {
            be.a(this.a.d.getContext(), (CharSequence) str, 0).show();
        }
    }
}
