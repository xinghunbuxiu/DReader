package com.duokan.reader.ui.account;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import com.duokan.common.C0267i;
import com.duokan.core.app.AppContext;
import com.duokan.core.ui.AnimUtils;
import com.duokan.p024c.C0252d;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.account.oauth.ThirdSina;
import com.duokan.reader.domain.account.oauth.TokenStore;
import com.duokan.reader.ui.C0435s;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.general.af;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.hb;
import com.duokan.reader.ui.general.ja;

public abstract class bd extends af {
    /* renamed from: a */
    private TokenStore f5820a;
    /* renamed from: b */
    private boolean f5821b;
    /* renamed from: c */
    protected ThirdSina f5822c;
    /* renamed from: d */
    protected View f5823d;
    /* renamed from: e */
    protected ja f5824e;
    /* renamed from: f */
    protected boolean f5825f = false;
    /* renamed from: g */
    protected EditText f5826g;
    /* renamed from: h */
    protected final String f5827h;
    /* renamed from: i */
    private int f5828i = 2;
    /* renamed from: j */
    private String f5829j = getContext().getString(C0258j.share_cancel);
    /* renamed from: k */
    private final bu f5830k;
    /* renamed from: l */
    private final String f5831l;

    /* renamed from: a */
    protected abstract void mo1574a(View view);

    /* renamed from: a */
    protected abstract void mo1575a(bt btVar);

    /* renamed from: a */
    protected abstract void mo1576a(String str);

    public bd(Activity activity, String str, String str2, bu buVar) {
        super(activity);
        this.f5830k = buVar;
        this.f5831l = str;
        this.f5827h = str2;
        this.f5820a = TokenStore.getInstance();
        this.f5822c = new ThirdSina(activity);
        this.f5822c.onActive();
        this.f5821b = this.f5820a.isBindAccessToken(activity, "weibo");
        this.f5824e = new ja(getActivity());
        this.f5824e.setCancelOnBack(true);
        this.f5824e.setCancelOnTouchOutside(false);
        this.f5824e.m10843a(getActivity().getString(C0258j.general__shared__sending));
        setCancelOnTouchOutside(false);
        setResizeForSoftInput(true);
    }

    public void show() {
        super.show();
        AnimUtils.m1915a(this.f5826g);
    }

    public void dismiss() {
        if (!this.f5825f) {
            if (this.f5824e != null && this.f5824e.isShowing()) {
                this.f5824e.dismiss();
            }
            if (this.f5822c != null) {
                this.f5822c.onDeactive();
            }
            if (this.f5830k == null) {
                be.m10287a(getContext(), this.f5829j, 0).show();
            } else if (this.f5828i == 0) {
                this.f5830k.mo1844a(this.f5829j);
            } else if (this.f5828i == 1) {
                this.f5830k.mo1845b(this.f5829j);
            } else {
                this.f5830k.mo1846c(this.f5829j);
            }
            super.dismiss();
        }
    }

    /* renamed from: b */
    protected void m8908b() {
        View inflate = LayoutInflater.from(getContext()).inflate(C0256h.account__third_share_view_v4, null);
        if (ReaderEnv.get().forHd()) {
            inflate.setBackgroundDrawable(new hb(new ColorDrawable(getContext().getResources().getColor(C0252d.general__shared__fefaf8)), (float) AnimUtils.m1932b(getContext(), 8.0f)));
        }
        setContentView(inflate);
        inflate.findViewById(C0255g.account__third_share_view__btns).setPadding(AnimUtils.m1932b(getContext(), 15.0f), (ReaderEnv.get().forHd() ? 0 : ((C0435s) AppContext.getAppContext(getContext()).queryFeature(C0435s.class)).getTheme().getHeaderPaddingTop()) + AnimUtils.m1932b(getContext(), 10.0f), AnimUtils.m1932b(getContext(), 15.0f), AnimUtils.m1932b(getContext(), 10.0f));
        ((DkLabelView) inflate.findViewById(C0255g.account__third_share_view__third_name)).setText(getContext().getString(C0258j.share_name_sina));
        inflate.findViewById(C0255g.account__third_share_view__cancel).setOnClickListener(new be(this));
        this.f5823d = inflate.findViewById(C0255g.account__third_share_view__send);
        mo1574a(inflate);
    }

    /* renamed from: c */
    protected void m8909c() {
        if (!C0267i.m604a(getActivity())) {
            be.m10286a(getContext(), C0258j.report_no_network_error, 0).show();
        } else if (this.f5821b) {
            String a = mo1581a();
            if (a.length() > 140) {
                a = a.substring(0, 136) + "...";
            }
            if (!TextUtils.isEmpty(this.f5831l)) {
                a = a + " " + this.f5831l;
            }
            mo1575a(new bf(this, a));
            this.f5823d.setEnabled(false);
        } else {
            m8903d();
        }
    }

    /* renamed from: a */
    protected String mo1581a() {
        if (this.f5826g != null) {
            return this.f5826g.getText().toString();
        }
        return "";
    }

    /* renamed from: d */
    private void m8903d() {
        this.f5822c.oauth(new bh(this));
    }
}
