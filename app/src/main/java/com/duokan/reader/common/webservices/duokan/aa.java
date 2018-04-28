package com.duokan.reader.common.webservices.duokan;

import com.duokan.reader.common.webservices.duokan.DkSyncService.NoteType;

/* synthetic */ class aa {
    /* renamed from: a */
    static final /* synthetic */ int[] f2099a = new int[NoteType.values().length];

    static {
        try {
            f2099a[NoteType.LOCAL_NOTE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f2099a[NoteType.DUOKAN_FICTION_NOTE.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f2099a[NoteType.DUOKAN_BOOK_NOTE.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}
