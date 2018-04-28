package com.duokan.reader.ui.personal;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.common.webservices.duokan.DkFeedbackThreadInfo;
import com.duokan.reader.common.webservices.duokan.ad;
import com.duokan.reader.ui.general.ik;
import com.duokan.reader.ui.general.web.StorePageController;

public class az extends ActivatedController implements ad {
    /* renamed from: a */
    private final boolean f8298a;
    /* renamed from: b */
    private final View f8299b;
    /* renamed from: c */
    private final ik f8300c = new ik(getContext());
    /* renamed from: d */
    private final bc f8301d = new bc(getContext());

    public az(IFeature mFeature, boolean z) {
        super(mFeature);
        this.f8298a = z;
        View frameLayout = new FrameLayout(getContext());
        this.f8299b = LayoutInflater.from(getContext()).inflate(C0256h.personal__feedback_view_create, frameLayout, false);
        this.f8299b.setOnClickListener(new ba(this));
        ActivatedController storePageController = new StorePageController(getContext());
        storePageController.setHasTitle(false);
        storePageController.loadUrl(C0641o.m2934i().m2948L());
        this.f8300c.m10793a(storePageController, getString(C0258j.personal__feedback_view__common));
        this.f8300c.m10793a(this.f8301d, getString(C0258j.personal__feedback_view__my));
        frameLayout.addView(this.f8300c.getContentView());
        frameLayout.addView(this.f8299b);
        setContentView(frameLayout);
        addSubController(this.f8300c);
        activate(this.f8300c);
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z && this.f8298a) {
            this.f8299b.performClick();
        }
    }

    protected boolean onRequestDetach(ActivatedController c0303e) {
        requestDetach();
        return true;
    }

    /* renamed from: a */
    public void mo1870a(DkFeedbackThreadInfo dkFeedbackThreadInfo) {
        this.f8301d.mo1870a(dkFeedbackThreadInfo);
        this.f8300c.m10792a(1);
    }

    /* renamed from: a */
    public void mo1869a(int i) {
        this.f8301d.mo1869a(i);
        this.f8300c.m10792a(1);
    }
}
