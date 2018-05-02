package com.duokan.reader.ui.store;

import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.reader.common.webservices.duokan.DkStoreBookTocInfo;

/* renamed from: com.duokan.reader.ui.store.g */
public class C1494g extends ActivatedController {
    /* renamed from: a */
    private final String f11440a;
    /* renamed from: b */
    private final DkStoreBookTocInfo[] f11441b;
    /* renamed from: c */
    private final C1495h f11442c = new C1495h(getContext());

    public C1494g(IFeature mFeature, String str, DkStoreBookTocInfo[] dkStoreBookTocInfoArr) {
        super(mFeature);
        this.f11440a = str;
        this.f11441b = dkStoreBookTocInfoArr;
        this.f11442c.setBookName(str);
        this.f11442c.setBookToc(dkStoreBookTocInfoArr);
        setContentView(this.f11442c);
    }
}
