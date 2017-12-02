package com.duokan.reader.ui.store;

import com.duokan.reader.domain.cloud.push.DkCloudPushMessage.ActionType;

/* synthetic */ class bp {
    static final /* synthetic */ int[] a = new int[ActionType.values().length];

    static {
        try {
            a[ActionType.BOOK_DETAIL.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[ActionType.BOOK_TOPIC.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            a[ActionType.FICTION_DETAIL.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            a[ActionType.FICTION_TOPIC.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
    }
}
