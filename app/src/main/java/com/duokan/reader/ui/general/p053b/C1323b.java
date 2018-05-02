package com.duokan.reader.ui.general.p053b;

import com.bumptech.glide.load.data.HttpUrlFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.duokan.reader.ui.general.C1342n;

/* renamed from: com.duokan.reader.ui.general.b.b */
class C1323b extends HttpUrlFetcher {
    /* renamed from: a */
    final /* synthetic */ C1342n f6950a;
    /* renamed from: b */
    final /* synthetic */ C1322a f6951b;

    C1323b(C1322a c1322a, GlideUrl glideUrl, C1342n c1342n) {
        this.f6951b = c1322a;
        this.f6950a = c1342n;
        super(glideUrl);
    }

    public String getId() {
        return this.f6950a.m10939a();
    }
}
