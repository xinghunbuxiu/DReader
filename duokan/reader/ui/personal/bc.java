package com.duokan.reader.ui.personal;

import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

import com.duokan.a.a;
import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.c.j;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;
import com.duokan.core.ui.LinearScrollView;
import com.duokan.reader.ui.general.PageHeaderView;
import com.duokan.reader.ui.ITheme;

public class bc extends ActivatedController {
    a a = null;

    public bc(IFeature featrue) {
        super(featrue);
        setContentView(h.personal__diagnostics_view);
        ((PageHeaderView) findViewById(g.personal__diagnostics_view__header)).setLeftTitle(j.personal__personal_settings_view__diagnostics);
        ITheme sVar = (ITheme) getContext().queryFeature(ITheme.class);
        int pagePaddingBottom = sVar != null ? sVar.getTheme().getPagePaddingBottom() : 0;
        LayoutParams layoutParams = findViewById(g.personal__diagnostics_view__placeholder).getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(-1, -2);
        }
        layoutParams.height = pagePaddingBottom;
        this.a = new bd(this, getContext(), (TextView) findViewById(g.personal__diagnostics_view__log), (LinearScrollView) findViewById(g.personal__diagnostics_view__scrollerview));
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            this.a.open();
        }
    }

    protected boolean onBack() {
        this.a.close();
        return super.onBack();
    }
}
