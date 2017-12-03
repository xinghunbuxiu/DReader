package com.duokan.reader.ui.personal;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.duokan.core.ui.UTools;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.webservices.duokan.ae;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.ui.general.PageHeaderView;
import com.duokan.reader.ui.general.af;
import com.duokan.reader.ui.general.ap;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.hm;
import com.duokan.reader.ui.general.ia;
import com.duokan.reader.ui.general.jq;

public class am extends af {
    private final int[] a = new int[]{3703, 3704, 3705, 3706, 3707, 3708};
    private final String[] b = new String[]{getContext().getString(j.personal__create_feedback_view__account), getContext().getString(j.personal__create_feedback_view__purchase), getContext().getString(j.personal__create_feedback_view__bug), getContext().getString(j.personal__create_feedback_view__content), getContext().getString(j.personal__create_feedback_view__need), getContext().getString(j.personal__create_feedback_view__other)};
    private final TextView c;
    private final TextView d;
    private final EditText e;
    private final ia f;
    private final jq g;
    private final ae h;
    private final a i;
    private int j = -1;
    private String k = "";

    public am(Context context, a aVar, ae aeVar) {
        super(context);
        this.i = aVar;
        setContentView(h.personal__feedback_create_view);
        PageHeaderView pageHeaderView = (PageHeaderView) findViewById(g.personal__create_feedback_view__header);
        pageHeaderView.setLeftTitle(j.personal__create_feedback_view__title);
        View findViewById = findViewById(g.personal__create_feedback_view__container);
        if (ReaderEnv.get().forHd()) {
            pageHeaderView.setBackgroundDrawable(new hm(new ColorDrawable(Color.parseColor("#ffffff")), (float) UTools.closeAnimation(getContext(), 6.0f), 3));
            findViewById.setBackgroundDrawable(new hm(new ColorDrawable(Color.parseColor("#efeff1")), (float) UTools.closeAnimation(getContext(), 6.0f), 12));
        } else {
            pageHeaderView.setBackgroundColor(Color.parseColor("#ffffff"));
            findViewById.setBackgroundColor(Color.parseColor("#efeff1"));
        }
        pageHeaderView.setOnBackListener(new an(this));
        TextView b = pageHeaderView.b(getContext().getString(j.general__shared__send));
        b.setTextColor(Color.parseColor("#f35d02"));
        b.setOnClickListener(new ao(this));
        this.c = (TextView) findViewById(g.personal__create_feedback_view__type);
        this.c.setOnClickListener(new ap(this));
        this.d = (TextView) findViewById(g.personal__create_feedback_view__upload);
        this.d.setOnClickListener(new aq(this));
        this.d.setSelected(true);
        this.e = (EditText) findViewById(g.personal__create_feedback_view__content);
        this.f = new ia(getContext());
        this.g = new jq(getContext());
        this.g.setCancelOnBack(false);
        this.g.setCancelOnTouchOutside(false);
        this.h = aeVar;
        a();
        setResizeForSoftInput(true);
    }

    private void a() {
        this.f.a(j.personal__create_feedback_view__selector);
        for (String b : this.b) {
            this.f.b(b);
        }
        this.f.a(new ar(this));
    }

    private void b() {
        if (TextUtils.isEmpty(this.k)) {
            new as(this).open();
        } else {
            e();
        }
    }

    private String c() {
        String string = getContext().getString(j.personal__create_feedback_view__nickname);
        String i = i.f().i();
        if (TextUtils.isEmpty(i) || i.length() < 5) {
            return ((Math.random() * 100000.0d) + "").substring(0, 10);
        }
        return string + i.substring(0, 5);
    }

    private void d() {
        if (this.j == -1) {
            be.a(getContext(), j.personal__create_feedback_view__selector_hint, 0).show();
        } else if (TextUtils.isEmpty(this.e.getText())) {
            be.a(getContext(), j.personal__create_feedback_view__empty_feed, 0).show();
        } else {
            if (!this.g.isShowing()) {
                this.g.a(getContext().getString(j.personal__create_feedback_view__post_thread));
                this.g.show();
            }
            UTools.hideSoftInputFromWindow(getContext());
            if (f.b().c() && this.d.isSelected()) {
                ap apVar = new ap(getContext());
                apVar.setOkLabel(j.general__shared__ok);
                apVar.setCancelLabel(j.general__shared__cancel);
                apVar.setCancelOnTouchOutside(false);
                apVar.setTitle(j.bookshelf__book__download_dialog__title);
                apVar.setPrompt(j.personal__create_feedback_view__no_wifi);
                apVar.open(new at(this));
                return;
            }
            b();
        }
    }

    private void e() {
        new au(this).open();
    }

    private String f() {
        return String.format(getContext().getString(j.personal__create_feedback_view__title_format), new Object[]{this.b[this.j], Build.MODEL, VERSION.RELEASE, ReaderEnv.get().getVersionName()});
    }
}
