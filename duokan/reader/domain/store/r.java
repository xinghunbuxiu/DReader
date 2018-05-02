package com.duokan.reader.domain.store;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.duokan.b.g;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.general.DkListView;
import com.duokan.reader.ui.general.ak;

public class r extends ak {
    private TextView a = ((TextView) findViewById(f.store__price_changed_view__title1));
    private View b = findViewById(f.store__price_changed_view__continue_purchase);
    private TextView c;
    private DkLabelView d = ((DkLabelView) findViewById(f.store__price_changed_view__price));
    private DkListView e;
    private TextView f;

    public r(Context context) {
        super(context);
        setExtraContentResource(g.store__price_changed_view);
        this.b.setOnClickListener(new s(this));
        this.c = (TextView) findViewById(f.store__price_changed_view__cancel_purchase);
        this.c.setOnClickListener(new t(this));
        this.e = (DkListView) findViewById(f.store__price_changed_view__list);
        this.f = (TextView) findViewById(f.store__price_changed_view__single_message);
        this.f.setVisibility(8);
    }

    public void cancel() {
        super.cancel();
        onCancel();
    }

    public void a() {
    }

    public void onCancel() {
    }

    public void setTitle(int i) {
        this.a.setText(i);
    }

    public void a(int i) {
        a(getContext().getString(i));
    }

    public void a(String str) {
        this.c.setText(str);
    }

    public void b(String str) {
        this.f.setText(str);
        this.f.setVisibility(0);
    }
}
