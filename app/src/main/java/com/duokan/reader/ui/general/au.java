package com.duokan.reader.ui.general;

import com.duokan.core.app.x;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.document.a;

public class au {
    public static void a(x xVar, String str) {
        a(xVar, str, null);
    }

    public static void a(x xVar, String str, a aVar) {
        ((ReaderFeature) xVar.queryFeature(ReaderFeature.class)).openBook(str, aVar);
    }
}
