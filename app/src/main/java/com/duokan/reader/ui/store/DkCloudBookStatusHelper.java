package com.duokan.reader.ui.store;

import android.text.TextUtils;
import android.util.Pair;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.bookshelf.BookState;
import com.duokan.reader.domain.bookshelf.BookType;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.cloud.DkUserPurchasedBooksManager;

public abstract class DkCloudBookStatusHelper {
    /* renamed from: a */
    static final /* synthetic */ boolean f11291a = (!DkCloudBookStatusHelper.class.desiredAssertionStatus());

    public enum StoreBookStatus {
        NORMAL,
        TRADING,
        ORDER,
        DOWNLOAD,
        DOWNLOADING,
        UPDATE
    }

    /* renamed from: a */
    public static Pair<StoreBookStatus, C0800c> m15237a(String str) {
        if (f11291a || !TextUtils.isEmpty(str)) {
            StoreBookStatus storeBookStatus = StoreBookStatus.NORMAL;
            if (C0709k.m3476a().m3500a(PersonalAccount.class) && DkUserPurchasedBooksManager.m5029a().m5052a(str) != null) {
                storeBookStatus = StoreBookStatus.ORDER;
            }
            if (C1502o.m15410a().m15434a(str)) {
                return new Pair(StoreBookStatus.TRADING, null);
            }
            C0800c b = ai.m3980a().m3906b(str);
            if (b != null) {
                if (b.m4242o() == BookType.NORMAL || b.m4233i() == BookState.UPDATING) {
                    if (b.m4233i() == BookState.CLOUD_ONLY) {
                        return new Pair(StoreBookStatus.ORDER, b);
                    }
                    if (b.m4171X()) {
                        return new Pair(StoreBookStatus.DOWNLOADING, b);
                    }
                    if (b.aw()) {
                        return new Pair(StoreBookStatus.UPDATE, b);
                    }
                    return new Pair(StoreBookStatus.DOWNLOAD, b);
                } else if (b.m4242o() == BookType.TRIAL && storeBookStatus == StoreBookStatus.ORDER) {
                    return new Pair(StoreBookStatus.UPDATE, b);
                } else {
                    if (b.m4166S() && storeBookStatus == StoreBookStatus.ORDER) {
                        return new Pair(StoreBookStatus.UPDATE, b);
                    }
                }
            }
            return new Pair(storeBookStatus, b);
        }
        throw new AssertionError();
    }

    /* renamed from: b */
    public static StoreBookStatus m15238b(String str) {
        return (StoreBookStatus) m15237a(str).first;
    }
}
