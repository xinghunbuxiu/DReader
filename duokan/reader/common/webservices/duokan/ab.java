package com.duokan.reader.common.webservices.duokan;

import com.duokan.reader.common.webservices.duokan.DkSyncService.NoteType;

/* synthetic */ class ab {
    static final /* synthetic */ int[] a = new int[NoteType.values().length];

    static {
        try {
            a[NoteType.LOCAL_NOTE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[NoteType.DUOKAN_FICTION_NOTE.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            a[NoteType.DUOKAN_BOOK_NOTE.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}
