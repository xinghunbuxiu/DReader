package com.duokan.reader.ui.general;

import android.view.LayoutInflater;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.p023b.C0245g;
import java.util.ArrayList;

public class ik extends ActivatedController {
    /* renamed from: a */
    private final hu f7383a = new il(this, getContext());
    /* renamed from: b */
    private final ArrayList<ActivatedController> f7384b = new ArrayList();
    /* renamed from: c */
    private int f7385c = -1;

    public ik(IFeature mFeature) {
        super(mFeature);
        LayoutInflater.from(getContext()).inflate(C0245g.surfing__surfing_base_view__back, this.f7383a.getLeftLayout(), true).setOnClickListener(new im(this));
        this.f7383a.setOnCurrentPageChangedListener(new in(this));
        setContentView(this.f7383a);
    }

    /* renamed from: a */
    protected boolean m10794a() {
        return true;
    }

    /* renamed from: a */
    public void m10793a(ActivatedController c0303e, String str) {
        this.f7384b.add(c0303e);
        addSubController(c0303e);
        this.f7383a.m10760a(str, c0303e.getContentView());
    }

    /* renamed from: a */
    public void m10792a(int i) {
        this.f7385c = Math.min(i, this.f7384b.size() - 1);
        if (this.f7385c >= 0) {
            this.f7383a.m10761a(this.f7385c);
            activate((ActivatedController) this.f7384b.get(this.f7385c));
        }
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z && this.f7385c < 0 && this.f7384b.size() > 0) {
            m10792a(0);
        }
    }
}
