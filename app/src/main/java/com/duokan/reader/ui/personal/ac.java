package com.duokan.reader.ui.personal;

import com.duokan.core.app.AppContext;
import com.duokan.core.app.ActivatedController;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0245g;
import com.duokan.p023b.C0247i;
import com.duokan.reader.ui.general.HeaderView;

public class ac extends ActivatedController {
    /* renamed from: a */
    private final HeaderView f8243a = ((HeaderView) findViewById(C0244f.personal__cmread_settings_view__header));

    public ac(AppContext appContext) {
        super(appContext);
        setContentView(C0245g.personal__cmread_settings_view);
        this.f8243a.setLeftTitle(C0247i.personal__cmread_settings_view__title);
        findViewById(C0244f.personal__cmread_settings_view__bind).setOnClickListener(new ad(this));
        findViewById(C0244f.personal__cmread_settings_view__unbind).setOnClickListener(new ae(this));
    }
}
