package com.duokan.reader.ui.store;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;
import com.duokan.reader.common.webservices.duokan.DkStoreBookTocInfo;

public class g extends ActivatedController {
    private final String a;
    private final DkStoreBookTocInfo[] b;
    private final h c = new h(getContext());

    public g(IFeature featrue, String str, DkStoreBookTocInfo[] dkStoreBookTocInfoArr) {
        super(featrue);
        this.a = str;
        this.b = dkStoreBookTocInfoArr;
        this.c.setBookName(str);
        this.c.setBookToc(dkStoreBookTocInfoArr);
        setContentView(this.c);
    }
}
