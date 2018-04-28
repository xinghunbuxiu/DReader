package com.duokan.reader.ui.reading;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.duokan.core.app.IFeature;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0245g;
import com.duokan.p023b.C0247i;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.general.gs;
import org.apache.http.HttpStatus;

public class al extends gs {
    /* renamed from: a */
    private final su f9772a = ((su) getContext().queryFeature(su.class));
    /* renamed from: b */
    private final View f9773b = LayoutInflater.from(getContext()).inflate(C0245g.reading__auto_pagedown_view, null);
    /* renamed from: c */
    private final TextView f9774c;
    /* renamed from: d */
    private final DkLabelView f9775d;
    /* renamed from: e */
    private final DkLabelView f9776e;
    /* renamed from: f */
    private int f9777f;

    public al(IFeature mFeature) {
        super(mFeature);
        setContentView(this.f9773b);
        this.f9773b.setOnClickListener(new am(this));
        this.f9777f = this.f9772a.ae().m12458S();
        this.f9774c = (TextView) findViewById(C0244f.reading__auto_pagedown_menu_view__speed);
        this.f9774c.setText(String.format(getContext().getString(C0247i.reading__auto_pagedown_menu_view__speed), new Object[]{Integer.valueOf(this.f9777f)}));
        this.f9775d = (DkLabelView) findViewById(C0244f.reading__auto_pagedown_menu_view__accelerate);
        this.f9775d.setOnClickListener(new an(this));
        this.f9776e = (DkLabelView) findViewById(C0244f.reading__auto_pagedown_menu_view__decelerate);
        this.f9776e.setOnClickListener(new ao(this));
        findViewById(C0244f.reading__auto_pagedown_menu_view__close).setOnClickListener(new ap(this));
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            m13727a();
        }
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
        this.f9772a.aF();
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        this.f9772a.aG();
    }

    /* renamed from: a */
    private void m13727a() {
        if (this.f9777f == HttpStatus.SC_OK) {
            this.f9776e.setEnabled(false);
        } else {
            this.f9776e.setEnabled(true);
        }
        if (this.f9777f == 2000) {
            this.f9775d.setEnabled(false);
        } else {
            this.f9775d.setEnabled(true);
        }
        this.f9774c.setText(String.format(getContext().getString(C0247i.reading__auto_pagedown_menu_view__speed), new Object[]{Integer.valueOf(this.f9772a.ae().m12458S() / HttpStatus.SC_OK)}));
    }
}
