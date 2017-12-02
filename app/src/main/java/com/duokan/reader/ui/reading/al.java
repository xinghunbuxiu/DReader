package com.duokan.reader.ui.reading;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.duokan.b.g;
import com.duokan.b.i;
import com.duokan.core.app.y;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.general.hd;

import org.apache.http.HttpStatus;

public class al extends hd {
    private final sh a = ((sh) getContext().queryFeature(sh.class));
    private final View b = LayoutInflater.from(getContext()).inflate(g.reading__auto_pagedown_view, null);
    private final TextView c;
    private final DkLabelView d;
    private final DkLabelView e;
    private int f;

    public al(y yVar) {
        super(yVar);
        setContentView(this.b);
        this.b.setOnClickListener(new am(this));
        this.f = this.a.ae().T();
        this.c = (TextView) findViewById(f.reading__auto_pagedown_menu_view__speed);
        this.c.setText(String.format(getContext().getString(i.reading__auto_pagedown_menu_view__speed), new Object[]{Integer.valueOf(this.f)}));
        this.d = (DkLabelView) findViewById(f.reading__auto_pagedown_menu_view__accelerate);
        this.d.setOnClickListener(new an(this));
        this.e = (DkLabelView) findViewById(f.reading__auto_pagedown_menu_view__decelerate);
        this.e.setOnClickListener(new ao(this));
        findViewById(f.reading__auto_pagedown_menu_view__close).setOnClickListener(new ap(this));
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            a();
        }
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
        this.a.aF();
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        this.a.aG();
    }

    private void a() {
        if (this.f == HttpStatus.SC_OK) {
            this.e.setEnabled(false);
        } else {
            this.e.setEnabled(true);
        }
        if (this.f == 2000) {
            this.d.setEnabled(false);
        } else {
            this.d.setEnabled(true);
        }
        this.c.setText(String.format(getContext().getString(i.reading__auto_pagedown_menu_view__speed), new Object[]{Integer.valueOf(this.a.ae().T() / HttpStatus.SC_OK)}));
    }
}
