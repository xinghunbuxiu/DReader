package com.duokan.reader.ui.store;

import com.duokan.core.app.e;
import com.duokan.core.app.y;
import com.duokan.reader.common.webservices.duokan.DkStoreBookTocInfo;

public class g extends e {
    private final String a;
    private final DkStoreBookTocInfo[] b;
    private final h c = new h(getContext());

    public g(y yVar, String str, DkStoreBookTocInfo[] dkStoreBookTocInfoArr) {
        super(yVar);
        this.a = str;
        this.b = dkStoreBookTocInfoArr;
        this.c.setBookName(str);
        this.c.setBookToc(dkStoreBookTocInfoArr);
        setContentView(this.c);
    }
}
