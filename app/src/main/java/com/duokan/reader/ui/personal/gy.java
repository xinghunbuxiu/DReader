package com.duokan.reader.ui.personal;

import com.duokan.reader.domain.account.AccountType;

/* synthetic */ class gy {
    static final /* synthetic */ int[] a = new int[AccountType.values().length];

    static {
        try {
            a[AccountType.XIAO_MI.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[AccountType.XIAOMI_GUEST.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            a[AccountType.ANONYMOUS.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            a[AccountType.NONE.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
    }
}
