package com.duokan.reader.ui.personal;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.duokan.core.ui.dv;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.webservices.duokan.C0643q;
import com.duokan.reader.ui.general.PageHeaderView;
import com.duokan.reader.ui.general.af;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.hb;
import com.duokan.reader.ui.general.ja;

class bn extends af {
    /* renamed from: a */
    final /* synthetic */ bh f8335a;
    /* renamed from: b */
    private final EditText f8336b;
    /* renamed from: c */
    private final ja f8337c;
    /* renamed from: d */
    private final String f8338d;

    public bn(bh bhVar, Context context, String str) {
        this.f8335a = bhVar;
        super(context);
        this.f8338d = str;
        setContentView(C0256h.personal__feedback_reply_view);
        PageHeaderView pageHeaderView = (PageHeaderView) findViewById(C0255g.personal__feedback_reply_view__header);
        pageHeaderView.setLeftTitle(C0258j.personal__feedback_thread_view__title);
        View findViewById = findViewById(C0255g.personal__feedback_reply_view__container);
        if (ReaderEnv.get().forHd()) {
            pageHeaderView.setBackgroundDrawable(new hb(new ColorDrawable(Color.parseColor("#ffffff")), (float) dv.m1932b(getContext(), 6.0f), 3));
            findViewById.setBackgroundDrawable(new hb(new ColorDrawable(Color.parseColor("#efeff1")), (float) dv.m1932b(getContext(), 6.0f), 12));
        } else {
            pageHeaderView.setBackgroundColor(Color.parseColor("#ffffff"));
            findViewById.setBackgroundColor(Color.parseColor("#efeff1"));
        }
        pageHeaderView.setOnBackListener(new bo(this, bhVar));
        TextView b = pageHeaderView.m10148b(getContext().getString(C0258j.general__shared__send));
        b.setTextColor(Color.parseColor("#f35d02"));
        b.setOnClickListener(new bp(this, bhVar));
        this.f8336b = (EditText) findViewById(C0255g.personal__feedback_reply_view__content);
        this.f8337c = new ja(getContext());
        this.f8337c.setCancelOnBack(false);
        this.f8337c.setCancelOnTouchOutside(false);
        setResizeForSoftInput(true);
    }

    /* renamed from: a */
    private void m11473a() {
        if (TextUtils.isEmpty(this.f8336b.getText())) {
            be.m10286a(getContext(), C0258j.personal__feedback_thread_view__empty_feed, 0).show();
            return;
        }
        if (!this.f8337c.isShowing()) {
            this.f8337c.m10843a(getContext().getString(C0258j.personal__create_feedback_view__post_thread));
            this.f8337c.show();
        }
        dv.m1909a(getContext());
        m11476b();
    }

    /* renamed from: b */
    private void m11476b() {
        new bq(this, C0643q.f2173a).open();
    }
}
