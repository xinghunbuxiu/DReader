package com.duokan.reader.ui.general;

import com.duokan.core.app.MyContextWrapper;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.document.Document_a;

public class au {
    public static void a(MyContextWrapper mContext, String str) {
        a(mContext, str, null);
    }

    public static void a(MyContextWrapper mContext, String str, Document_a aVar) {
        ((ReaderFeature) mContext.queryFeature(ReaderFeature.class)).openBook(str, aVar);
    }
}
