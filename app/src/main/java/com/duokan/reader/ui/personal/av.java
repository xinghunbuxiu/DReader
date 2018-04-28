package com.duokan.reader.ui.personal;

import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.ui.LinearScrollView;
import com.duokan.p022a.C0236a;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ui.C0435s;
import com.duokan.reader.ui.general.PageHeaderView;

public class av extends ActivatedController {
    /* renamed from: a */
    C0236a f8286a = null;

    public av(IFeature mFeature) {
        super(mFeature);
        setContentView(C0256h.personal__diagnostics_view);
        ((PageHeaderView) findViewById(C0255g.personal__diagnostics_view__header)).setLeftTitle(C0258j.personal__personal_settings_view__diagnostics);
        C0435s c0435s = (C0435s) getContext().queryFeature(C0435s.class);
        int pagePaddingBottom = c0435s != null ? c0435s.getTheme().getPagePaddingBottom() : 0;
        LayoutParams layoutParams = findViewById(C0255g.personal__diagnostics_view__placeholder).getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(-1, -2);
        }
        layoutParams.height = pagePaddingBottom;
        this.f8286a = new aw(this, getContext(), (TextView) findViewById(C0255g.personal__diagnostics_view__log), (LinearScrollView) findViewById(C0255g.personal__diagnostics_view__scrollerview));
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            this.f8286a.open();
        }
    }

    protected boolean onBack() {
        this.f8286a.close();
        return super.onBack();
    }
}
