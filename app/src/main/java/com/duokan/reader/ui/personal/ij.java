package com.duokan.reader.ui.personal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.duokan.core.app.IFeature;
import com.duokan.core.ui.LinearScrollView;
import com.duokan.p024c.C0254f;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.common.C0543b;
import com.duokan.reader.common.bitmap.C0544a;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.common.p037c.C0562i;
import com.duokan.reader.domain.account.C0586j;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.cloud.C0854n;
import com.duokan.reader.domain.cloud.DkCloudAnnotation;
import com.duokan.reader.domain.cloud.DkCloudNoteBookInfo;
import com.duokan.reader.domain.cloud.DkUserReadBookManager;
import com.duokan.reader.domain.cloud.DkUserReadBookManager.ReadBook;
import com.duokan.reader.domain.cloud.DkUserReadingNotesManager;
import com.duokan.reader.domain.cloud.ed;
import com.duokan.reader.domain.cloud.et;
import com.duokan.reader.ui.account.ak;
import com.duokan.reader.ui.general.BookCoverView;
import com.duokan.reader.ui.general.DkBigFaceView;
import com.duokan.reader.ui.general.PageHeaderView;
import com.duokan.reader.ui.general.be;

public class ij extends nm implements C0562i, C0586j, ed, et, C0854n {
    /* renamed from: a */
    private final ak f8718a = new ak(this);
    /* renamed from: c */
    private final nc f8719c = new fo();
    /* renamed from: d */
    private final LinearScrollView f8720d;
    /* renamed from: e */
    private final TextView f8721e;
    /* renamed from: f */
    private final TextView f8722f;
    /* renamed from: g */
    private final TextView f8723g;
    /* renamed from: h */
    private final TextView f8724h;
    /* renamed from: i */
    private final TextView f8725i;
    /* renamed from: j */
    private final View f8726j;
    /* renamed from: k */
    private final RelativeLayout f8727k;
    /* renamed from: l */
    private final View f8728l;
    /* renamed from: m */
    private final TextView f8729m;
    /* renamed from: n */
    private final ReadingStatisticsChartView f8730n;
    /* renamed from: o */
    private final View f8731o;
    /* renamed from: p */
    private final View f8732p;
    /* renamed from: q */
    private boolean f8733q = false;

    public ij(IFeature mFeature) {
        super(mFeature, true);
        setContentView(C0256h.personal__personal_info_view);
        C0672a b = C0709k.m3476a().m3502b(PersonalAccount.class);
        this.f8720d = (LinearScrollView) findViewById(C0255g.personal__personal_info_view__scroller);
        PageHeaderView pageHeaderView = (PageHeaderView) findViewById(C0255g.personal__personal_info_view__header);
        pageHeaderView.setHasBackButton(true);
        pageHeaderView.setCenterTitle(C0258j.personal__personal_info_view__my_experience);
        pageHeaderView.setBackgroundColor(0);
        pageHeaderView.setBottomLineColor(0);
        pageHeaderView.getCenterTitleView().setTextColor(0);
        findViewById(C0255g.personal__personal_info_view__user).setOnClickListener(new ik(this));
        CharSequence c = ((PersonalAccount) C0709k.m3476a().m3502b(PersonalAccount.class)).mo833c();
        CharSequence a = b.mo836f().mo871a();
        ((DkBigFaceView) findViewById(C0255g.personal__personal_info_view__avatar)).setMiAccount(b);
        TextView textView = (TextView) findViewById(C0255g.personal__personal_info_view__mi_login_name);
        if (TextUtils.isEmpty(a) || c.equals(a)) {
            textView.setText(c);
        } else {
            textView.setText(a);
        }
        this.f8721e = (TextView) findViewById(C0255g.personal__personal_info_view__reading_percentage);
        this.f8722f = (TextView) findViewById(C0255g.personal__personal_info_view__reading_length);
        this.f8723g = (TextView) findViewById(C0255g.personal__personal_info_view__finish_count);
        this.f8724h = (TextView) findViewById(C0255g.personal__personal_info_view__read_count);
        this.f8725i = (TextView) findViewById(C0255g.personal__personal_info_view__notes_count);
        this.f8726j = findViewById(C0255g.personal__personal_info_view__read_books);
        this.f8727k = (RelativeLayout) findViewById(C0255g.personal__personal_info_view__read_books_info);
        this.f8728l = findViewById(C0255g.personal__personal_info_view__more_read);
        this.f8728l.setOnClickListener(new im(this));
        this.f8729m = (TextView) findViewById(C0255g.personal__personal_info_view__using_days);
        this.f8730n = (ReadingStatisticsChartView) findViewById(C0255g.personal__personal_info_view__chart);
        this.f8731o = findViewById(C0255g.personal__personal_info_view__line);
        this.f8732p = findViewById(C0255g.personal__personal_info_view__share);
        this.f8732p.setOnClickListener(new in(this));
        this.f8720d.setOnScrollListener(new io(this, pageHeaderView));
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
        C0709k.m3476a().m3494a((C0586j) this);
        C0559f.m2476b().m2480a((C0562i) this);
        DkUserReadingNotesManager.m5136a().m5152a((et) this);
        DkUserReadBookManager.m5115a().m5129a((ed) this);
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        C0709k.m3476a().m3505b((C0586j) this);
        C0559f.m2476b().m2482b((C0562i) this);
        DkUserReadingNotesManager.m5136a().m5157b((et) this);
        DkUserReadBookManager.m5115a().m5132b((ed) this);
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (!this.f8719c.mo1905a()) {
            requestDetach();
            be.m10286a(getContext(), C0258j.account__dk_relogin_view__why, 0).show();
        }
        if (z && !C0559f.m2476b().m2486e()) {
            this.f8721e.setText(C0258j.personal__personal_info_view__network_problem);
        }
        m11999a(false);
    }

    public void onAccountLoginedTopHalf(C0672a c0672a) {
    }

    public void onAccountLoginedBottomHalf(C0672a c0672a) {
    }

    public void onAccountLogoff(C0672a c0672a) {
        requestDetach();
    }

    public void onAccountDetailChanged(C0672a c0672a) {
    }

    /* renamed from: a */
    public void mo949a(C0559f c0559f) {
        if (C0559f.m2476b().m2486e()) {
            m11999a(false);
        }
    }

    /* renamed from: f */
    public void mo967f() {
        m12002b();
    }

    /* renamed from: a */
    public void mo1916a(ReadBook[] readBookArr) {
        m12002b();
        m12005c(readBookArr);
    }

    /* renamed from: b */
    public void mo1918b(ReadBook[] readBookArr) {
    }

    /* renamed from: g */
    public void mo1920g() {
        m12004c();
    }

    /* renamed from: a */
    public void mo958a(DkCloudNoteBookInfo dkCloudNoteBookInfo) {
        m12002b();
    }

    /* renamed from: a */
    public void mo959a(String str, DkCloudAnnotation[] dkCloudAnnotationArr) {
        m12002b();
    }

    /* renamed from: a */
    private void m11999a(boolean z) {
        if (z || !this.f8733q) {
            this.f8733q = true;
            this.f8719c.mo1904a(getContext(), new ip(this));
        }
    }

    /* renamed from: a */
    public void mo1913a() {
        m12002b();
    }

    /* renamed from: b */
    private void m12002b() {
        this.f8724h.setText(C0543b.m2416a(C0258j.personal__personal_info_view__read_count, 16, "*", Long.valueOf(this.f8719c.mo1906b())));
        this.f8723g.setText(C0543b.m2416a(C0258j.personal__personal_info_view__finish_count, 16, "*", Long.valueOf(this.f8719c.mo1908d())));
        this.f8722f.setText(m11998a(this.f8719c.mo1907c()));
        if (this.f8719c.mo1910f() == 0.0d) {
            this.f8721e.setText(getContext().getString(C0258j.personal__experience_view__ranking_total_low));
        } else {
            this.f8721e.setText(C0543b.m2417a(C0258j.personal__readed_books_view__ranking_total, 16, C0543b.m2420a(this.f8719c.mo1910f())));
        }
        this.f8725i.setText(C0543b.m2416a(C0258j.personal__personal_info_view__reading_notes_count, 16, "*", Long.valueOf(DkUserReadingNotesManager.m5136a().m5156b())));
        this.f8729m.setText(C0543b.m2417a(C0258j.personal__experience_view__using_days, 20, Long.valueOf(this.f8719c.mo1909e())));
        this.f8730n.setVisibility(0);
        this.f8730n.m11372a(this.f8719c.mo1912h());
        this.f8731o.setVisibility(0);
        this.f8732p.setVisibility(0);
    }

    /* renamed from: a */
    private CharSequence m11998a(long j) {
        int i = (int) (((float) j) / 3600.0f);
        if (Math.round((float) ((j % 3600) / 60)) == 60) {
            i++;
        }
        return C0543b.m2416a(C0258j.personal__personal_info_view__reading_length_hour, 16, "*", Integer.valueOf(i));
    }

    /* renamed from: c */
    private void m12004c() {
        DkUserReadBookManager.m5115a().m5131a(false, new iq(this), 0, 5);
    }

    /* renamed from: c */
    private void m12005c(ReadBook[] readBookArr) {
        if (readBookArr.length == 0) {
            this.f8726j.setVisibility(8);
        } else {
            this.f8726j.setVisibility(0);
        }
        if (readBookArr.length < 4) {
            this.f8728l.setVisibility(4);
        }
        Rect rect = new Rect();
        getDrawable(C0254f.general__shared__book_category_book_shadow).getPadding(rect);
        int length = readBookArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            ReadBook readBook = readBookArr[i];
            if (i2 != 3) {
                View childAt = this.f8727k.getChildAt(i2);
                childAt.setVisibility(0);
                BookCoverView bookCoverView = (BookCoverView) childAt.findViewById(C0255g.personal__personal_info_book_view__cover);
                bookCoverView.setOnlineCoverUri(readBook.getCoverUri());
                bookCoverView.setCoverBackgroundResource(C0254f.general__book_cover_view__duokan_cover);
                bookCoverView.setPadding(rect.left, rect.top, rect.right, rect.bottom);
                ((TextView) childAt.findViewById(C0255g.personal__personal_info_book_view__title)).setText(readBook.getTitle());
                childAt.setOnClickListener(new ir(this, readBook));
                i2++;
                i++;
            } else {
                return;
            }
        }
    }

    /* renamed from: d */
    private Bitmap m12006d() {
        LinearLayout linearLayout = (LinearLayout) findViewById(C0255g.personal__personal_info_view__share_content);
        linearLayout.measure(MeasureSpec.makeMeasureSpec(linearLayout.getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(0, 0));
        Bitmap b = C0544a.m2444b(linearLayout.getMeasuredWidth(), linearLayout.getMeasuredHeight(), Config.ARGB_8888);
        linearLayout.draw(new Canvas(b));
        return b;
    }
}
