package com.duokan.reader.ui.general;

import com.duokan.core.app.AppContext;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.document.C0896a;

public class au {
    /* renamed from: a */
    public static void m10239a(AppContext appContext, String str) {
        m10240a(appContext, str, null);
    }

    /* renamed from: a */
    public static void m10240a(AppContext appContext, String str, C0896a c0896a) {
        ((ReaderFeature) appContext.queryFeature(ReaderFeature.class)).openBook(str, c0896a);
    }
}
