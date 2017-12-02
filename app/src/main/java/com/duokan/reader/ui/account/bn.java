package com.duokan.reader.ui.account;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;

import com.duokan.core.app.x;
import com.duokan.core.ui.dv;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.account.oauth.ThirdSina;
import com.duokan.reader.domain.account.oauth.TokenStore;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.general.af;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.hm;
import com.duokan.reader.ui.general.jq;
import com.duokan.reader.ui.s;

public abstract class bn extends af {
    protected ThirdSina a;
    protected View b;
    protected jq c;
    protected boolean d = false;
    private TokenStore e;
    private boolean f;
    private int g = 2;
    private String h = getContext().getString(j.share_cancel);
    private final ce i;
    private final String j;
    private final String k;

    protected abstract String a();

    protected abstract void a(View view);

    protected abstract void a(cd cdVar);

    protected abstract void a(String str);

    public bn(Activity activity, String str, String str2, ce ceVar) {
        super(activity);
        this.i = ceVar;
        this.j = str;
        this.k = str2;
        this.e = TokenStore.getInstance();
        this.a = new ThirdSina(activity);
        this.a.onActive();
        this.f = this.e.isBindAccessToken(activity, "sina");
        this.c = new jq(getActivity());
        this.c.setCancelOnBack(true);
        this.c.setCancelOnTouchOutside(false);
        this.c.a(getActivity().getString(j.general__shared__sending));
        setCancelOnTouchOutside(false);
        setResizeForSoftInput(true);
    }

    public void dismiss() {
        if (!this.d) {
            if (this.c != null && this.c.isShowing()) {
                this.c.dismiss();
            }
            if (this.a != null) {
                this.a.onDeactive();
            }
            if (this.i == null) {
                be.a(getContext(), this.h, 0).show();
            } else if (this.g == 0) {
                this.i.a(this.h);
            } else if (this.g == 1) {
                this.i.b(this.h);
            } else {
                this.i.c(this.h);
            }
            super.dismiss();
        }
    }

    protected void b() {
        View inflate = LayoutInflater.from(getContext()).inflate(h.account__third_share_view_v4, null);
        if (ReaderEnv.get().forHd()) {
            inflate.setBackgroundDrawable(new hm(new ColorDrawable(getContext().getResources().getColor(d.general__shared__fefaf8)), (float) dv.b(getContext(), 8.0f)));
        }
        setContentView(inflate);
        inflate.findViewById(g.account__third_share_view__btns).setPadding(dv.b(getContext(), 15.0f), (ReaderEnv.get().forHd() ? 0 : ((s) x.a(getContext()).queryFeature(s.class)).getTheme().getHeaderPaddingTop()) + dv.b(getContext(), 10.0f), dv.b(getContext(), 15.0f), dv.b(getContext(), 10.0f));
        ((DkLabelView) inflate.findViewById(g.account__third_share_view__third_name)).setText(getContext().getString(j.share_name_sina));
        inflate.findViewById(g.account__third_share_view__cancel).setOnClickListener(new bo(this));
        this.b = inflate.findViewById(g.account__third_share_view__send);
        a(inflate);
    }

    protected void c() {
        if (!i.a(getActivity())) {
            be.a(getContext(), j.report_no_network_error, 0).show();
        } else if (this.f) {
            String a = a();
            if (a.length() > 140) {
                a = a.substring(0, 136) + "...";
            }
            if (!TextUtils.isEmpty(this.j)) {
                a = a + " " + this.j;
            }
            a(new bp(this, a));
            this.b.setEnabled(false);
        } else {
            d();
        }
    }

    private void d() {
        this.a.oauth(new br(this));
    }
}
