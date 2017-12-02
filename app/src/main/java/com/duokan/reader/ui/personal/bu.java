package com.duokan.reader.ui.personal;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.c.j;
import com.duokan.core.ui.dv;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ui.general.PageHeaderView;
import com.duokan.reader.ui.general.af;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.hm;
import com.duokan.reader.ui.general.jq;

class bu extends af {
    final /* synthetic */ bo a;
    private final EditText b;
    private final jq c;
    private final String d;

    public bu(bo boVar, Context context, String str) {
        this.a = boVar;
        super(context);
        this.d = str;
        setContentView(h.personal__feedback_reply_view);
        PageHeaderView pageHeaderView = (PageHeaderView) findViewById(g.personal__feedback_reply_view__header);
        pageHeaderView.setLeftTitle(j.personal__feedback_thread_view__title);
        View findViewById = findViewById(g.personal__feedback_reply_view__container);
        if (ReaderEnv.get().forHd()) {
            pageHeaderView.setBackgroundDrawable(new hm(new ColorDrawable(Color.parseColor("#ffffff")), (float) dv.b(getContext(), 6.0f), 3));
            findViewById.setBackgroundDrawable(new hm(new ColorDrawable(Color.parseColor("#efeff1")), (float) dv.b(getContext(), 6.0f), 12));
        } else {
            pageHeaderView.setBackgroundColor(Color.parseColor("#ffffff"));
            findViewById.setBackgroundColor(Color.parseColor("#efeff1"));
        }
        pageHeaderView.setOnBackListener(new bv(this, boVar));
        TextView b = pageHeaderView.b(getContext().getString(j.general__shared__send));
        b.setTextColor(Color.parseColor("#f35d02"));
        b.setOnClickListener(new bw(this, boVar));
        this.b = (EditText) findViewById(g.personal__feedback_reply_view__content);
        this.c = new jq(getContext());
        this.c.setCancelOnBack(false);
        this.c.setCancelOnTouchOutside(false);
        setResizeForSoftInput(true);
    }

    private void a() {
        if (TextUtils.isEmpty(this.b.getText())) {
            be.a(getContext(), j.personal__feedback_thread_view__empty_feed, 0).show();
            return;
        }
        if (!this.c.isShowing()) {
            this.c.a(getContext().getString(j.personal__create_feedback_view__post_thread));
            this.c.show();
        }
        dv.a(getContext());
        b();
    }

    private void b() {
        new bx(this).open();
    }
}
