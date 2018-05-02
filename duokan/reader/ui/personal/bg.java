package com.duokan.reader.ui.personal;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.duokan.c.h;
import com.duokan.c.j;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;
import com.duokan.reader.common.webservices.duokan.DkFeedbackThreadInfo;
import com.duokan.reader.common.webservices.duokan.ae;
import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.ui.general.ja;
import com.duokan.reader.ui.general.web.StorePageController;

public class bg extends ActivatedController implements ae {
    private final boolean a;
    private final View b;
    private final ja c = new ja(getContext());
    private final bj d = new bj(getContext());

    public bg(IFeature featrue, boolean z) {
        super(featrue);
        this.a = z;
        View frameLayout = new FrameLayout(getContext());
        this.b = LayoutInflater.from(getContext()).inflate(h.personal__feedback_view_create, frameLayout, false);
        this.b.setOnClickListener(new bh(this));
        ActivatedController storePageController = new StorePageController(getContext());
        storePageController.setHasTitle(false);
        storePageController.loadUrl(p.i().N());
        this.c.a(storePageController, getString(j.personal__feedback_view__common));
        this.c.a(this.d, getString(j.personal__feedback_view__my));
        frameLayout.addView(this.c.getContentView());
        frameLayout.addView(this.b);
        setContentView(frameLayout);
        addSubController(this.c);
        activate(this.c);
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z && this.a) {
            this.b.performClick();
        }
    }

    protected boolean onRequestDetach(ActivatedController activatedControllerVar) {
        requestDetach();
        return true;
    }

    public void a(DkFeedbackThreadInfo dkFeedbackThreadInfo) {
        this.d.a(dkFeedbackThreadInfo);
        this.c.a(1);
    }

    public void a(int i) {
        this.d.a(i);
        this.c.a(1);
    }
}
