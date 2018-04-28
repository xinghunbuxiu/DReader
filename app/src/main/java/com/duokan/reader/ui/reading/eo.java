package com.duokan.reader.ui.reading;

import android.widget.TextView;
import com.duokan.common.C0267i;
import com.duokan.core.app.IFeature;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0247i;
import com.duokan.reader.DkPublic;
import com.duokan.reader.domain.downloadcenter.C0780k;
import com.duokan.reader.domain.downloadcenter.C1016b;
import com.duokan.reader.domain.downloadcenter.DownloadCenterTask;
import com.duokan.reader.domain.p044b.C0779a;
import com.duokan.reader.domain.p044b.C0781b;
import com.duokan.reader.domain.p044b.C0796q;
import com.duokan.reader.ui.general.FileTransferPrompter;
import com.duokan.reader.ui.general.gs;

public abstract class eo extends gs implements C0779a, C0780k {
    /* renamed from: a */
    private final TextView f10094a = ((TextView) findViewById(C0244f.reading__custom_font_list_view__download_all));
    /* renamed from: b */
    private final TextView f10095b;

    /* renamed from: c */
    protected abstract int mo2313c();

    public eo(IFeature mFeature) {
        super(mFeature);
        setContentView(mo2313c());
        this.f10094a.setOnClickListener(new ep(this));
        this.f10095b = (TextView) findViewById(C0244f.reading__custom_font_list_view__dk_font_pacakge_description);
    }

    /* renamed from: b */
    protected void mo2312b() {
        C0796q c = C0781b.m3667b().m3690c();
        if (c.f2665e) {
            float max = Math.max(0.0f, Math.min(((float) c.f2664d) / ((float) c.f2662b), 1.0f));
            this.f10094a.setText(String.format("%.1f％", new Object[]{Float.valueOf(max * 100.0f)}));
        } else if (c.f2663c == c.f2661a) {
            this.f10094a.setText("100％");
            findViewById(C0244f.reading__custom_font_list_view__dk_font_pacakge_panel).setVisibility(8);
        } else {
            this.f10094a.setText(getString(C0247i.reading__custom_font_list_view__download_all) + DkPublic.formatBytes(c.f2662b - c.f2664d));
        }
        this.f10095b.setText(formatString(C0247i.f398xbea8875a, "" + c.f2663c, "" + c.f2661a));
    }

    /* renamed from: d */
    private void m14009d() {
        C0781b.m3667b().m3693f();
    }

    /* renamed from: e */
    private void m14010e() {
        C0796q c = C0781b.m3667b().m3690c();
        FileTransferPrompter.m9977a(getContext(), c.f2662b - c.f2664d, getContext().getResources().getString(C0247i.reading__custom_font__download_title), getContext().getString(C0247i.reading__custom_font__download_prompt_at_data_plan, new Object[]{C0267i.m599a(c.f2662b - c.f2664d)}), new eq(this));
    }

    public void onTaskRunning(DownloadCenterTask downloadCenterTask) {
        mo2312b();
    }

    public void onTaskStatusChanged(DownloadCenterTask downloadCenterTask) {
        mo2312b();
    }

    /* renamed from: a */
    public void mo2311a() {
    }

    protected void onActive(boolean z) {
        if (z) {
            C0781b.m3667b().m3686a((C0779a) this);
        }
        C1016b.m7857p().m7872a((C0780k) this);
    }

    protected void onDeactive() {
        C1016b.m7857p().m7880b((C0780k) this);
    }

    protected void onDetachFromStub() {
        C0781b.m3667b().m3689b((C0779a) this);
    }
}
