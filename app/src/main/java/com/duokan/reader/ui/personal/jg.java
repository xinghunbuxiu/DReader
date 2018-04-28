package com.duokan.reader.ui.personal;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ab;
import com.duokan.core.io.FileUtil;
import com.duokan.core.ui.LinearScrollView;
import com.duokan.p024c.C0252d;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.BookShelfType;
import com.duokan.reader.ReaderEnv.BookshelfItemStyle;
import com.duokan.reader.UmengManager;
import com.duokan.reader.common.C0590d;
import com.duokan.reader.common.C0610h;
import com.duokan.reader.domain.account.AccountType;
import com.duokan.reader.domain.account.C0586j;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.store.C1189o;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.general.HeaderView;
import com.duokan.reader.ui.general.ReaderUi;
import java.io.File;

public class jg extends nm implements ab, C0610h, C0586j {
    /* renamed from: a */
    private final LinearScrollView f8771a;
    /* renamed from: c */
    private final View f8772c;
    /* renamed from: d */
    private final View f8773d;
    /* renamed from: e */
    private final View f8774e;
    /* renamed from: f */
    private final View f8775f;
    /* renamed from: g */
    private final View f8776g;
    /* renamed from: h */
    private final View f8777h;
    /* renamed from: i */
    private final View f8778i = findViewById(C0255g.personal__personal_settings_view__anonymous_hint_root);

    public jg(IFeature mFeature) {
        super(mFeature, true);
        setContentView(LayoutInflater.from(getContext()).inflate(C0256h.personal__personal_settings_view__v4, null));
        this.f8778i.findViewById(C0255g.personal__personal_settings_view__login).setOnClickListener(new jh(this));
        this.f8771a = (LinearScrollView) findViewById(C0255g.personal__personal_settings_view__scrollerview);
        HeaderView headerView = (HeaderView) findViewById(C0255g.personal__personal_settings_view__header);
        headerView.setLeftTitle(C0258j.personal__personal_settings_view__title);
        headerView.setHasBackButton(true);
        Handler handler = new Handler(new ju(this));
        this.f8773d = findViewById(C0255g.personal__personal_settings_view__sync_reading_datas);
        this.f8773d.setOnClickListener(new jx(this, handler));
        this.f8775f = findViewById(C0255g.personal__personal_settings_view__auto_upload);
        this.f8775f.setOnClickListener(new jy(this));
        this.f8776g = findViewById(C0255g.personal__personal_settings_view__show_read_progress);
        this.f8776g.setOnClickListener(new jz(this));
        this.f8777h = findViewById(C0255g.personal__personal_settings_view__show_sign_in);
        this.f8777h.setOnClickListener(new ka(this));
        this.f8772c = findViewById(C0255g.personal__personal_settings_view__user_settings);
        this.f8772c.setOnClickListener(new kb(this));
        findViewById(C0255g.personal__personal_settings_view__bookshelf_type).setOnClickListener(new kd(this));
        findViewById(C0255g.personal__personal_settings_view__user_type).setOnClickListener(new ke(this));
        findViewById(C0255g.personal__personal_settings_view__bind_accounts).setOnClickListener(new jj(this));
        this.f8774e = findViewById(C0255g.personal__personal_settings_view__message);
        this.f8774e.setOnClickListener(new jk(this));
        findViewById(C0255g.personal__personal_settings_view__pushes).setOnClickListener(new jl(this));
        findViewById(C0255g.personal__personal_settings_view__subscription).setOnClickListener(new jn(this));
        findViewById(C0255g.personal__personal_settings_view__auto_buy).setOnClickListener(new jo(this));
        DkLabelView dkLabelView = (DkLabelView) findViewById(C0255g.personal__personal_settings_view__storage);
        if (((File[]) FileUtil.m782b(getContext()).toArray(new File[0])).length <= 1) {
            dkLabelView.setTextColor(getResources().getColor(C0252d.general__shared__888888));
            dkLabelView.setEnabled(false);
        }
        dkLabelView.setOnClickListener(new jp(this));
        findViewById(C0255g.personal__personal_settings_view__feedback).setOnClickListener(new jq(this));
        mo1595a(C0590d.m2643a().m2654b());
        findViewById(C0255g.personal__personal_settings_view__app_store).setOnClickListener(new jr(this));
        findViewById(C0255g.personal__personal_settings_view__about).setOnClickListener(new js(this));
        ((TextView) findViewById(C0255g.personal__personal_settings_view__about_label)).setText(getString(C0258j.general__shared__about) + getString(C0258j.app__shared__family_name));
        findViewById(C0255g.personal__personal_settings_view__language).setOnClickListener(new jt(this));
        findViewById(C0255g.personal__personal_settings_view__diagnostics).setOnClickListener(new jv(this));
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - ReaderEnv.get().getLastDetectUpdateTime() >= 86400000) {
            ReaderEnv.get().setLastDetectUpdateTime(currentTimeMillis);
            UmengManager.get().detectUpdate(getContext(), new jw(this));
        }
        m12047a();
    }

    public void onAccountLogoff(C0672a c0672a) {
        m12047a();
        this.f8771a.scrollTo(0, 0);
    }

    public void onAccountLoginedTopHalf(C0672a c0672a) {
    }

    public void onAccountLoginedBottomHalf(C0672a c0672a) {
        m12047a();
    }

    public void onAccountDetailChanged(C0672a c0672a) {
        m12047a();
    }

    /* renamed from: a */
    public void mo1595a(int i) {
        ReaderUi.m10167c((ImageView) findViewById(C0255g.personal__personal_settings_view__feedback_count), i);
    }

    public boolean navigateSmoothly(String str) {
        return m12050a(str, null);
    }

    /* renamed from: a */
    public boolean m12050a(String str, Runnable runnable) {
        return navigate(str, null, true, runnable);
    }

    public boolean navigate(String str, Object obj, boolean z, Runnable runnable) {
        return false;
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            C0590d.m2643a().m2652a((C0610h) this);
        }
        C0709k.m3476a().m3494a((C0586j) this);
        m12047a();
    }

    protected void onDeactive() {
        super.onDeactive();
        C0709k.m3476a().m3505b((C0586j) this);
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        C0590d.m2643a().m2655b((C0610h) this);
    }

    /* renamed from: a */
    private void m12047a() {
        this.f8773d.setSelected(PersonalPrefs.m5175a().m5250z());
        this.f8775f.setSelected(ai.m3980a().mo971c().m862b(Boolean.valueOf(true)));
        this.f8776g.setSelected(ReaderEnv.get().getBookshelfItemStyle() == BookshelfItemStyle.TRADITIONAL);
        this.f8777h.setSelected(PersonalPrefs.m5175a().m5234j());
        TextView textView = (TextView) findViewById(C0255g.personal__personal_settings_view__bookshelf_type_text);
        if (ReaderEnv.get().getBookShelfType() == BookShelfType.Simple) {
            textView.setText(C0258j.personal__personal_settings_view__bookshelf_simple);
        } else {
            textView.setText(C0258j.personal__personal_settings_view__bookshelf_tradition);
        }
        if (ReaderEnv.get().getVersionCode() < ReaderEnv.get().getNewVersion()) {
            findViewById(C0255g.personal__personal_settings_view__has_new_version).setVisibility(0);
        } else {
            findViewById(C0255g.personal__personal_settings_view__has_new_version).setVisibility(4);
        }
        findViewById(C0255g.personal__personal_settings_view__pushes).setSelected(ReaderEnv.get().getReceivePushes());
        findViewById(C0255g.personal__personal_settings_view__message).setSelected(ReaderEnv.get().getIsReceiveReplyMessage());
        findViewById(C0255g.personal__personal_settings_view__subscription_switcher).setSelected(C1189o.m8727a().m8738b());
        textView = (TextView) this.f8773d.findViewById(C0255g.f413x7b75b135);
        View findViewById = this.f8773d.findViewById(C0255g.personal__personal_settings_view__sync_reading_datas_switch);
        TextView textView2 = (TextView) this.f8775f.findViewById(C0255g.personal__personal_settings_view__auto_upload_primary_text);
        View findViewById2 = this.f8775f.findViewById(C0255g.personal__personal_settings_view__auto_upload_switch);
        TextView textView3 = (TextView) this.f8774e.findViewById(C0255g.personal__personal_settings_view__notification_primary_text);
        View findViewById3 = this.f8774e.findViewById(C0255g.personal__personal_settings_view__notification_switcher);
        if (C0709k.m3476a().m3501b().equals(AccountType.ANONYMOUS)) {
            this.f8778i.setVisibility(0);
            this.f8772c.setVisibility(8);
            textView.setTextColor(getResources().getColor(C0252d.general__shared__888888));
            findViewById.setVisibility(8);
            this.f8773d.setEnabled(false);
            textView2.setTextColor(getResources().getColor(C0252d.general__shared__888888));
            findViewById2.setVisibility(8);
            this.f8775f.setEnabled(false);
            textView3.setTextColor(getResources().getColor(C0252d.general__shared__888888));
            findViewById3.setVisibility(8);
            this.f8774e.setEnabled(false);
            return;
        }
        this.f8778i.setVisibility(8);
        this.f8772c.setVisibility(0);
        textView.setTextColor(getResources().getColor(C0252d.general__shared__333333));
        findViewById.setVisibility(0);
        this.f8773d.setEnabled(true);
        textView2.setTextColor(getResources().getColor(C0252d.general__shared__333333));
        findViewById2.setVisibility(0);
        this.f8775f.setEnabled(true);
        textView3.setTextColor(getResources().getColor(C0252d.general__shared__333333));
        findViewById3.setVisibility(0);
        this.f8774e.setEnabled(true);
    }
}
