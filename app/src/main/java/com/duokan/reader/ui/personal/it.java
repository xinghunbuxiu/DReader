package com.duokan.reader.ui.personal;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.duokan.c.j;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.Inavigate;
import com.duokan.core.ui.LinearScrollView;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.BookShelfType;
import com.duokan.reader.ReaderEnv.BookshelfItemStyle;
import com.duokan.reader.UmengManager;
import com.duokan.reader.common.h;
import com.duokan.reader.domain.account.AccountType;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.store.o;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.general.HeaderView;
import com.duokan.reader.ui.general.ReaderUi;

import java.io.File;

public class it extends my implements Inavigate, h, com.duokan.reader.domain.account.h {
    private final LinearScrollView a;
    private final View c;
    private final View d;
    private final View e;
    private final View f;
    private final View g;
    private final View h = findViewById(g.personal__personal_settings_view__anonymous_hint_root);

    public it(IFeature featrue) {
        super(featrue, true);
        setContentView(LayoutInflater.from(getContext()).inflate(com.duokan.c.h.personal__personal_settings_view__v4, null));
        this.h.findViewById(g.personal__personal_settings_view__login).setOnClickListener(new iu(this));
        this.a = (LinearScrollView) findViewById(g.personal__personal_settings_view__scrollerview);
        HeaderView headerView = (HeaderView) findViewById(g.personal__personal_settings_view__header);
        headerView.setLeftTitle(j.personal__personal_settings_view__title);
        headerView.setHasBackButton(true);
        Handler handler = new Handler(new jh(this));
        this.d = findViewById(g.personal__personal_settings_view__sync_reading_datas);
        this.d.setOnClickListener(new jj(this, handler));
        this.f = findViewById(g.personal__personal_settings_view__auto_upload);
        this.f.setOnClickListener(new jk(this));
        this.g = findViewById(g.personal__personal_settings_view__show_read_progress);
        this.g.setOnClickListener(new jl(this));
        this.c = findViewById(g.personal__personal_settings_view__user_settings);
        this.c.setOnClickListener(new jm(this));
        findViewById(g.personal__personal_settings_view__bookshelf_type).setOnClickListener(new jo(this));
        findViewById(g.personal__personal_settings_view__user_type).setOnClickListener(new jp(this));
        findViewById(g.personal__personal_settings_view__bind_accounts).setOnClickListener(new jq(this));
        this.e = findViewById(g.personal__personal_settings_view__message);
        this.e.setOnClickListener(new iw(this));
        findViewById(g.personal__personal_settings_view__pushes).setOnClickListener(new ix(this));
        findViewById(g.personal__personal_settings_view__subscription).setOnClickListener(new iz(this));
        findViewById(g.personal__personal_settings_view__auto_buy).setOnClickListener(new ja(this));
        DkLabelView dkLabelView = (DkLabelView) findViewById(g.personal__personal_settings_view__storage);
        if (((File[]) a.b(getContext()).toArray(new File[0])).length <= 1) {
            dkLabelView.setTextColor(getResources().getColor(d.general__shared__888888));
            dkLabelView.setEnabled(false);
        }
        dkLabelView.setOnClickListener(new jb(this));
        findViewById(g.personal__personal_settings_view__feedback).setOnClickListener(new jc(this));
        a(com.duokan.reader.common.d.a().b());
        findViewById(g.personal__personal_settings_view__app_store).setOnClickListener(new jd(this));
        findViewById(g.personal__personal_settings_view__about).setOnClickListener(new je(this));
        ((TextView) findViewById(g.personal__personal_settings_view__about_label)).setText(getString(j.general__shared__about) + getString(j.app__shared__family_name));
        findViewById(g.personal__personal_settings_view__language).setOnClickListener(new jf(this));
        findViewById(g.personal__personal_settings_view__diagnostics).setOnClickListener(new jg(this));
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - ReaderEnv.get().getLastDetectUpdateTime() >= 86400000) {
            ReaderEnv.get().setLastDetectUpdateTime(currentTimeMillis);
            UmengManager.get().detectUpdate(getContext(), new ji(this));
        }
        a();
    }

    public void c(com.duokan.reader.domain.account.a aVar) {
        a();
        this.a.scrollTo(0, 0);
    }

    public void a(com.duokan.reader.domain.account.a aVar) {
    }

    public void b(com.duokan.reader.domain.account.a aVar) {
        a();
    }

    public void d(com.duokan.reader.domain.account.a aVar) {
        a();
    }

    public void a(int i) {
        ReaderUi.c((ImageView) findViewById(g.personal__personal_settings_view__feedback_count), i);
    }

    public boolean navigateSmoothly(String str) {
        return a(str, null);
    }

    public boolean a(String str, Runnable runnable) {
        return navigate(str, null, true, runnable);
    }

    public boolean navigate(String str, Object obj, boolean z, Runnable runnable) {
        return false;
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            com.duokan.reader.common.d.a().a((h) this);
        }
        i.f().add((com.duokan.reader.domain.account.h) this);
        a();
    }

    protected void onDeactive() {
        super.onDeactive();
        i.f().remove((com.duokan.reader.domain.account.h) this);
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        com.duokan.reader.common.d.a().b((h) this);
    }

    private void a() {
        this.d.setSelected(PersonalPrefs.a().y());
        this.f.setSelected(ai.a().c().b(Boolean.valueOf(true)));
        this.g.setSelected(ReaderEnv.get().getBookshelfItemStyle() == BookshelfItemStyle.TRADITIONAL);
        TextView textView = (TextView) findViewById(g.personal__personal_settings_view__bookshelf_type_text);
        if (ReaderEnv.get().getBookShelfType() == BookShelfType.Simple) {
            textView.setText(j.personal__personal_settings_view__bookshelf_simple);
        } else {
            textView.setText(j.personal__personal_settings_view__bookshelf_tradition);
        }
        if (ReaderEnv.get().getVersionCode() < ReaderEnv.get().getNewVersion()) {
            findViewById(g.personal__personal_settings_view__has_new_version).setVisibility(0);
        } else {
            findViewById(g.personal__personal_settings_view__has_new_version).setVisibility(4);
        }
        findViewById(g.personal__personal_settings_view__pushes).setSelected(ReaderEnv.get().getReceivePushes());
        findViewById(g.personal__personal_settings_view__message).setSelected(ReaderEnv.get().getIsReceiveReplyMessage());
        findViewById(g.personal__personal_settings_view__subscription_switcher).setSelected(o.a().b());
        textView = (TextView) this.d.findViewById(g.personal__personal_settings_view__sync_reading_datas_primary_text);
        View findViewById = this.d.findViewById(g.personal__personal_settings_view__sync_reading_datas_switch);
        TextView textView2 = (TextView) this.f.findViewById(g.personal__personal_settings_view__auto_upload_primary_text);
        View findViewById2 = this.f.findViewById(g.personal__personal_settings_view__auto_upload_switch);
        TextView textView3 = (TextView) this.e.findViewById(g.personal__personal_settings_view__notification_primary_text);
        View findViewById3 = this.e.findViewById(g.personal__personal_settings_view__notification_switcher);
        if (i.f().a().equals(AccountType.ANONYMOUS)) {
            this.h.setVisibility(0);
            this.c.setVisibility(8);
            textView.setTextColor(getResources().getColor(d.general__shared__888888));
            findViewById.setVisibility(8);
            this.d.setEnabled(false);
            textView2.setTextColor(getResources().getColor(d.general__shared__888888));
            findViewById2.setVisibility(8);
            this.f.setEnabled(false);
            textView3.setTextColor(getResources().getColor(d.general__shared__888888));
            findViewById3.setVisibility(8);
            this.e.setEnabled(false);
            return;
        }
        this.h.setVisibility(8);
        this.c.setVisibility(0);
        textView.setTextColor(getResources().getColor(d.general__shared__333333));
        findViewById.setVisibility(0);
        this.d.setEnabled(true);
        textView2.setTextColor(getResources().getColor(d.general__shared__333333));
        findViewById2.setVisibility(0);
        this.f.setEnabled(true);
        textView3.setTextColor(getResources().getColor(d.general__shared__333333));
        findViewById3.setVisibility(0);
        this.e.setEnabled(true);
    }
}
