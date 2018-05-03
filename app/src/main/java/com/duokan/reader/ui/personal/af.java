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
import com.duokan.core.ui.AnimUtils;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.common.webservices.duokan.C0643q;
import com.duokan.reader.common.webservices.duokan.ad;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.ui.general.PageHeaderView;
import com.duokan.reader.ui.general.ap;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.hb;
import com.duokan.reader.ui.general.hp;
import com.duokan.reader.ui.general.ja;

public class af extends com.duokan.reader.ui.general.af {
    /* renamed from: a */
    private final int[] f8246a = new int[]{3703, 3704, 3705, 3706, 3707, 3708};
    /* renamed from: b */
    private final String[] f8247b = new String[]{getContext().getString(C0258j.personal__create_feedback_view__account), getContext().getString(C0258j.personal__create_feedback_view__purchase), getContext().getString(C0258j.personal__create_feedback_view__bug), getContext().getString(C0258j.personal__create_feedback_view__content), getContext().getString(C0258j.personal__create_feedback_view__need), getContext().getString(C0258j.personal__create_feedback_view__other)};
    /* renamed from: c */
    private final TextView f8248c;
    /* renamed from: d */
    private final TextView f8249d;
    /* renamed from: e */
    private final EditText f8250e;
    /* renamed from: f */
    private final hp f8251f;
    /* renamed from: g */
    private final ja f8252g;
    /* renamed from: h */
    private final ad f8253h;
    /* renamed from: i */
    private final C0672a f8254i;
    /* renamed from: j */
    private int f8255j = -1;
    /* renamed from: k */
    private String f8256k = "";

    public af(Context context, C0672a c0672a, ad adVar) {
        super(context);
        this.f8254i = c0672a;
        setContentView(C0256h.personal__feedback_create_view);
        PageHeaderView pageHeaderView = (PageHeaderView) findViewById(C0255g.personal__create_feedback_view__header);
        pageHeaderView.setLeftTitle(C0258j.personal__create_feedback_view__title);
        View findViewById = findViewById(C0255g.personal__create_feedback_view__container);
        if (ReaderEnv.get().forHd()) {
            pageHeaderView.setBackgroundDrawable(new hb(new ColorDrawable(Color.parseColor("#ffffff")), (float) AnimUtils.m1932b(getContext(), 6.0f), 3));
            findViewById.setBackgroundDrawable(new hb(new ColorDrawable(Color.parseColor("#efeff1")), (float) AnimUtils.m1932b(getContext(), 6.0f), 12));
        } else {
            pageHeaderView.setBackgroundColor(Color.parseColor("#ffffff"));
            findViewById.setBackgroundColor(Color.parseColor("#efeff1"));
        }
        pageHeaderView.setOnBackListener(new ag(this));
        TextView b = pageHeaderView.m10148b(getContext().getString(C0258j.general__shared__send));
        b.setTextColor(Color.parseColor("#f35d02"));
        b.setOnClickListener(new ah(this));
        this.f8248c = (TextView) findViewById(C0255g.personal__create_feedback_view__type);
        this.f8248c.setOnClickListener(new ai(this));
        this.f8249d = (TextView) findViewById(C0255g.personal__create_feedback_view__upload);
        this.f8249d.setOnClickListener(new aj(this));
        this.f8249d.setSelected(true);
        this.f8250e = (EditText) findViewById(C0255g.personal__create_feedback_view__content);
        this.f8251f = new hp(getContext());
        this.f8252g = new ja(getContext());
        this.f8252g.setCancelOnBack(false);
        this.f8252g.setCancelOnTouchOutside(false);
        this.f8253h = adVar;
        m11377a();
        setResizeForSoftInput(true);
    }

    /* renamed from: a */
    private void m11377a() {
        this.f8251f.m9765a(C0258j.personal__create_feedback_view__selector);
        for (String b : this.f8247b) {
            this.f8251f.m9770b(b);
        }
        this.f8251f.m9767a(new ak(this));
    }

    /* renamed from: b */
    private void m11380b() {
        if (TextUtils.isEmpty(this.f8256k)) {
            new al(this, C0643q.f2173a).open();
        } else {
            m11386e();
        }
    }

    /* renamed from: c */
    private String m11382c() {
        String string = getContext().getString(C0258j.personal__create_feedback_view__nickname);
        String i = C0709k.m3476a().m3514i();
        if (TextUtils.isEmpty(i) || i.length() < 5) {
            return ((Math.random() * 100000.0d) + "").substring(0, 10);
        }
        return string + i.substring(0, 5);
    }

    /* renamed from: d */
    private void m11383d() {
        if (this.f8255j == -1) {
            be.m10286a(getContext(), C0258j.personal__create_feedback_view__selector_hint, 0).show();
        } else if (TextUtils.isEmpty(this.f8250e.getText())) {
            be.m10286a(getContext(), C0258j.personal__create_feedback_view__empty_feed, 0).show();
        } else {
            if (!this.f8252g.isShowing()) {
                this.f8252g.m10843a(getContext().getString(C0258j.personal__create_feedback_view__post_thread));
                this.f8252g.show();
            }
            AnimUtils.m1909a(getContext());
            if (C0559f.m2476b().m2484c() && this.f8249d.isSelected()) {
                ap apVar = new ap(getContext());
                apVar.setOkLabelResid(C0258j.general__shared__ok);
                apVar.setCancelLabel(C0258j.general__shared__cancel);
                apVar.setCancelOnTouchOutside(false);
                apVar.setTitle(C0258j.bookshelf__book__download_dialog__title);
                apVar.setPrompt(C0258j.personal__create_feedback_view__no_wifi);
                apVar.open(new am(this));
                return;
            }
            m11380b();
        }
    }

    /* renamed from: e */
    private void m11386e() {
        new an(this, C0643q.f2173a).open();
    }

    /* renamed from: f */
    private String m11387f() {
        return String.format(getContext().getString(C0258j.personal__create_feedback_view__title_format), new Object[]{this.f8247b[this.f8255j], Build.MODEL, VERSION.RELEASE, ReaderEnv.get().getVersionName()});
    }
}
