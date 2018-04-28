package com.duokan.reader.ui.personal;

import com.duokan.reader.domain.account.AccountType;

/* synthetic */ class hl {
    /* renamed from: a */
    static final /* synthetic */ int[] f8660a = new int[AccountType.values().length];

    static {
        try {
            f8660a[AccountType.XIAO_MI.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f8660a[AccountType.XIAOMI_GUEST.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f8660a[AccountType.ANONYMOUS.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f8660a[AccountType.NONE.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
    }
}
