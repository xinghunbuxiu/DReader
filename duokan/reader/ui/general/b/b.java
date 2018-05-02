package com.duokan.reader.ui.general.b;

import com.bumptech.glide.load.data.HttpUrlFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.duokan.reader.ui.general.n;

class b extends HttpUrlFetcher {
    final /* synthetic */ n a;
    final /* synthetic */ a b;

    b(a aVar, GlideUrl glideUrl, n nVar) {
        this.b = aVar;
        this.a = nVar;
        super(glideUrl);
    }

    public String getId() {
        return this.a.a();
    }
}
