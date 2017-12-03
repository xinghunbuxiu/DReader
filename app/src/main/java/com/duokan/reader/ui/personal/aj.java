package com.duokan.reader.ui.personal;

import com.duokan.b.f;
import com.duokan.b.g;
import com.duokan.b.i;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.MyContextWrapper;
import com.duokan.reader.ui.general.HeaderView;

public class aj extends ActivatedController {
    private final HeaderView a = ((HeaderView) findViewById(f.personal__cmread_settings_view__header));

    public aj(MyContextWrapper mContext) {
        super(mContext);
        setContentView(g.personal__cmread_settings_view);
        this.a.setLeftTitle(i.personal__cmread_settings_view__title);
        findViewById(f.personal__cmread_settings_view__bind).setOnClickListener(new ak(this));
        findViewById(f.personal__cmread_settings_view__unbind).setOnClickListener(new al(this));
    }
}
