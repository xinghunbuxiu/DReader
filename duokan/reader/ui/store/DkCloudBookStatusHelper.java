package com.duokan.reader.ui.store;

import android.text.TextUtils;
import android.util.Pair;

import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.bookshelf.BookState;
import com.duokan.reader.domain.bookshelf.BookType;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.cloud.DkUserPurchasedBooksManager;

public abstract class DkCloudBookStatusHelper {
    static final /* synthetic */ boolean a = (!DkCloudBookStatusHelper.class.desiredAssertionStatus());

    public enum StoreBookStatus {
        NORMAL,
        TRADING,
        ORDER,
        DOWNLOAD,
        DOWNLOADING,
        UPDATE
    }

    public static Pair a(String str) {
        if (a || !TextUtils.isEmpty(str)) {
            StoreBookStatus storeBookStatus = StoreBookStatus.NORMAL;
            if (i.f().a(PersonalAccount.class) && DkUserPurchasedBooksManager.a().a(str) != null) {
                storeBookStatus = StoreBookStatus.ORDER;
            }
            if (o.a().a(str)) {
                return new Pair(StoreBookStatus.TRADING, null);
            }
            c b = ai.a().b(str);
            if (b != null) {
                if (b.o() == BookType.NORMAL || b.i() == BookState.UPDATING) {
                    if (b.i() == BookState.CLOUD_ONLY) {
                        return new Pair(StoreBookStatus.ORDER, b);
                    }
                    if (b.V()) {
                        return new Pair(StoreBookStatus.DOWNLOADING, b);
                    }
                    if (b.au()) {
                        return new Pair(StoreBookStatus.UPDATE, b);
                    }
                    return new Pair(StoreBookStatus.DOWNLOAD, b);
                } else if (b.o() == BookType.TRIAL && storeBookStatus == StoreBookStatus.ORDER) {
                    return new Pair(StoreBookStatus.UPDATE, b);
                } else {
                    if (b.Q() && storeBookStatus == StoreBookStatus.ORDER) {
                        return new Pair(StoreBookStatus.UPDATE, b);
                    }
                }
            }
            return new Pair(storeBookStatus, b);
        }
        throw new AssertionError();
    }

    public static StoreBookStatus b(String str) {
        return (StoreBookStatus) a(str).first;
    }
}
