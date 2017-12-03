package com.duokan.reader.ui.reading;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import com.duokan.b.i;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;
import com.duokan.core.ui.dt;
import com.duokan.core.ui.et;
import com.duokan.reader.ui.general.PageHeaderView;
import com.duokan.reader.ui.reading.FixedPageClipView.ClipIndicator;

public class ip extends ActivatedController {
    private final dt a;
    private final et b;
    private final FixedPageClipView c;
    private ClipIndicator d = ClipIndicator.UNKNOW;

    public ip(IFeature featrue, sh shVar, is isVar) {
        super(featrue);
        View linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        View pageHeaderView = new PageHeaderView(getContext());
        pageHeaderView.setLeftTitle(i.reading__shared__clip_pages);
        linearLayout.addView(pageHeaderView, new LayoutParams(-1, -2));
        this.c = new FixedPageClipView(getContext(), shVar, new iq(this, isVar));
        linearLayout.addView(this.c, new LayoutParams(-1, -1));
        setContentView(linearLayout);
        this.b = new et();
        this.a = new dt();
        this.b.a(this.a);
        this.b.b(this.c);
        this.b.a(new ir(this));
    }
}
