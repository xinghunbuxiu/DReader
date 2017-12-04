package com.duokan.reader.ui.reading;

import android.widget.TextView;

import com.duokan.b.f;
import com.duokan.b.i;
import com.duokan.common.tools;
import com.duokan.core.app.IFeature;
import com.duokan.reader.DkPublic;
import com.duokan.reader.domain.b.a;
import com.duokan.reader.domain.b.q;
import com.duokan.reader.domain.downloadcenter.DownloadCenterTask;
import com.duokan.reader.domain.downloadcenter.k;
import com.duokan.reader.ui.general.FileTransferPrompter;
import com.duokan.reader.ui.general.hd;

public abstract class ek extends hd implements a, k {
    private final TextView a = ((TextView) findViewById(f.reading__custom_font_list_view__download_all));
    private final TextView b;

    protected abstract int c();

    public ek(IFeature featrue) {
        super(featrue);
        setContentView(c());
        this.a.setOnClickListener(new el(this));
        this.b = (TextView) findViewById(f.reading__custom_font_list_view__dk_font_pacakge_description);
    }

    protected void b() {
        q c = b.b().c();
        if (c.e) {
            float max = Math.max(0.0f, Math.min(((float) c.d) / ((float) c.b), 1.0f));
            this.a.setText(String.format("%.1f％", new Object[]{Float.valueOf(max * 100.0f)}));
        } else if (c.c == c.a) {
            this.a.setText("100％");
            findViewById(f.reading__custom_font_list_view__dk_font_pacakge_panel).setVisibility(8);
        } else {
            this.a.setText(getString(i.reading__custom_font_list_view__download_all) + DkPublic.formatBytes(c.b - c.d));
        }
        this.b.setText(formatString(i.reading__custom_font_list_view__dk_font_package_description_with_progress, "" + c.c, "" + c.a));
    }

    private void d() {
        b.b().f();
    }

    private void e() {
        q c = b.b().c();
        FileTransferPrompter.a(getContext(), c.b - c.d, getContext().getResources().getString(i.reading__custom_font__download_title), getContext().getString(i.reading__custom_font__download_prompt_at_data_plan, new Object[]{tools.getByteSize(c.b - c.d)}), new em(this));
    }

    public void a(DownloadCenterTask downloadCenterTask) {
        b();
    }

    public void b(DownloadCenterTask downloadCenterTask) {
        b();
    }

    public void a() {
    }

    protected void onActive(boolean z) {
        if (z) {
            b.b().a((a) this);
        }
        com.duokan.reader.domain.downloadcenter.b.n().a((k) this);
    }

    protected void onDeactive() {
        com.duokan.reader.domain.downloadcenter.b.n().b((k) this);
    }

    protected void onDetachFromStub() {
        b.b().b((a) this);
    }
}
