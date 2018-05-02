package com.duokan.reader.ui.store;

import android.view.LayoutInflater;
import android.view.View;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;

/* renamed from: com.duokan.reader.ui.store.a */
public class C1475a extends ActivatedController {
    public C1475a(IFeature mFeature) {
        super(mFeature);
        View inflate = LayoutInflater.from(getContext()).inflate(C0256h.general__app_store_guide_view, null, false);
        setContentView(inflate);
        inflate.findViewById(C0255g.general__app_store_guide_view__positive).setOnClickListener(new C1476b(this));
        inflate.findViewById(C0255g.general__app_store_guide_view__negative).setOnClickListener(new C1477c(this));
        inflate.findViewById(C0255g.general__app_store_guide_view__cancel).setOnClickListener(new C1492e(this));
    }
}
