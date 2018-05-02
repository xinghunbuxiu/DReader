package com.duokan.reader.ui.general.p053b;

import android.content.Context;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.duokan.reader.ui.general.C1342n;
import java.io.InputStream;

/* renamed from: com.duokan.reader.ui.general.b.d */
public class C1325d implements ModelLoaderFactory<C1342n, InputStream> {
    public ModelLoader<C1342n, InputStream> build(Context context, GenericLoaderFactory genericLoaderFactory) {
        return new C1322a(context);
    }

    public void teardown() {
    }
}
