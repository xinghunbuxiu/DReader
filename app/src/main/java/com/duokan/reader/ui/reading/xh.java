package com.duokan.reader.ui.reading;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;

import com.duokan.core.app.IFeature;
import com.duokan.reader.domain.bookshelf.jn;
import com.duokan.reader.domain.bookshelf.jo;
import com.duokan.reader.domain.store.DkStoreBookDetail;

public class xh extends ei {
    private final jn h;
    private final jo i;
    private final TextView j = ((TextView) findViewById(g.reading__repair_cert_view__reason));

    public xh(IFeature featrue, wl wlVar, DkStoreBookDetail dkStoreBookDetail, String str, jn jnVar, jo joVar) {
        super(featrue, wlVar);
        this.h = jnVar;
        this.i = joVar;
        this.e.addView(LayoutInflater.from(getContext()).inflate(h.reading__repair_cert_view, null), new LayoutParams(-1, -1));
        TextView textView = (TextView) findViewById(g.reading__repair_cert_view__retry);
        textView.setOnClickListener(new xi(this));
        findViewById(g.reading__repair_cert_view__back).setOnClickListener(new xj(this));
        this.j.setTextColor(this.a.R());
        if (TextUtils.isEmpty(str)) {
            this.j.setText(j.reading__repair_cert_view__default_reason);
            textView.setText(j.general__shared__repair);
            return;
        }
        this.j.setText(str);
        textView.setText(j.general__shared__retry);
    }

    protected boolean onBack() {
        this.i.b(this.h);
        return super.onBack();
    }
}
