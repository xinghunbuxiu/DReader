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
import com.duokan.reader.common.classc;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.h;
import com.duokan.reader.domain.cloud.DkCloudAnnotation;
import com.duokan.reader.domain.cloud.DkCloudNoteBookInfo;
import com.duokan.reader.domain.cloud.DkUserReadBookManager;
import com.duokan.reader.domain.cloud.DkUserReadBookManager.ReadBook;
import com.duokan.reader.domain.cloud.DkUserReadingNotesManager;
import com.duokan.reader.domain.cloud.eu;
import com.duokan.reader.domain.cloud.fl;
import com.duokan.reader.domain.cloud.o;
import com.duokan.reader.ui.account.ay;
import com.duokan.reader.ui.general.BookCoverView;
import com.duokan.reader.ui.general.DkBigFaceView;
import com.duokan.reader.ui.general.PageHeaderView;
import com.duokan.reader.ui.general.be;

public class hw extends my implements classc.IConnectChanged, h, eu, fl, o {
    private final ay a = new ay(this);
    private final mo c = new fa();
    private final LinearScrollView d;
    private final TextView e;
    private final TextView f;
    private final TextView g;
    private final TextView h;
    private final TextView i;
    private final View j;
    private final RelativeLayout k;
    private final View l;
    private final TextView m;
    private final ReadingStatisticsChartView n;
    private final View o;
    private final View p;
    private boolean q = false;

    public hw(IFeature featrue) {
        super(featrue, true);
        setContentView(com.duokan.c.h.personal__personal_info_view);
        a b = i.f().b(PersonalAccount.class);
        this.d = (LinearScrollView) findViewById(com.duokan.c.g.personal__personal_info_view__scroller);
        PageHeaderView pageHeaderView = (PageHeaderView) findViewById(com.duokan.c.g.personal__personal_info_view__header);
        pageHeaderView.setHasBackButton(true);
        pageHeaderView.setCenterTitle(j.personal__personal_info_view__my_experience);
        pageHeaderView.setBackgroundColor(0);
        pageHeaderView.setBottomLineColor(0);
        pageHeaderView.getCenterTitleView().setTextColor(0);
        findViewById(com.duokan.c.g.personal__personal_info_view__user).setOnClickListener(new hx(this));
        CharSequence c = ((PersonalAccount) i.f().b(PersonalAccount.class)).c();
        CharSequence a = b.f().a();
        ((DkBigFaceView) findViewById(com.duokan.c.g.personal__personal_info_view__avatar)).setMiAccount(b);
        TextView textView = (TextView) findViewById(com.duokan.c.g.personal__personal_info_view__mi_login_name);
        if (TextUtils.isEmpty(a) || c.equals(a)) {
            textView.setText(c);
        } else {
            textView.setText(a);
        }
        this.e = (TextView) findViewById(com.duokan.c.g.personal__personal_info_view__reading_percentage);
        this.f = (TextView) findViewById(com.duokan.c.g.personal__personal_info_view__reading_length);
        this.g = (TextView) findViewById(com.duokan.c.g.personal__personal_info_view__finish_count);
        this.h = (TextView) findViewById(com.duokan.c.g.personal__personal_info_view__read_count);
        this.i = (TextView) findViewById(com.duokan.c.g.personal__personal_info_view__notes_count);
        this.j = findViewById(com.duokan.c.g.personal__personal_info_view__read_books);
        this.k = (RelativeLayout) findViewById(com.duokan.c.g.personal__personal_info_view__read_books_info);
        this.l = findViewById(com.duokan.c.g.personal__personal_info_view__more_read);
        this.l.setOnClickListener(new hz(this));
        this.m = (TextView) findViewById(com.duokan.c.g.personal__personal_info_view__using_days);
        this.n = (ReadingStatisticsChartView) findViewById(com.duokan.c.g.personal__personal_info_view__chart);
        this.o = findViewById(com.duokan.c.g.personal__personal_info_view__line);
        this.p = findViewById(com.duokan.c.g.personal__personal_info_view__share);
        this.p.setOnClickListener(new ia(this));
        this.d.setOnScrollListener(new ib(this, pageHeaderView));
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
        i.f().a((h) this);
        f.b().a((classc.IConnectChanged) this);
        DkUserReadingNotesManager.a().a((fl) this);
        DkUserReadBookManager.a().a((eu) this);
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        i.f().b((h) this);
        f.b().b(this);
        DkUserReadingNotesManager.a().b((fl) this);
        DkUserReadBookManager.a().b((eu) this);
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (!this.c.a()) {
            requestDetach();
            be.a(getContext(), j.account__dk_relogin_view__why, 0).show();
        }
        if (z && !f.b().e()) {
            this.e.setText(j.personal__personal_info_view__network_problem);
        }
        a(false);
    }

    public void a(a aVar) {
    }

    public void b(a aVar) {
    }

    public void c(a aVar) {
        requestDetach();
    }

    public void d(a aVar) {
    }

    public void onConnectivityChanged(classc.ConnectivityReceiver connectivity) {
        if (f.b().e()) {
            a(false);
        }
    }

    public void f() {
        b();
    }

    public void a(ReadBook[] readBookArr) {
        b();
        c(readBookArr);
    }

    public void b(ReadBook[] readBookArr) {
    }

    public void g() {
        c();
    }

    public void a(DkCloudNoteBookInfo dkCloudNoteBookInfo) {
        b();
    }

    public void a(String str, DkCloudAnnotation[] dkCloudAnnotationArr) {
        b();
    }

    private void a(boolean z) {
        if (z || !this.q) {
            this.q = true;
            this.c.a(getContext(), new ic(this));
        }
    }

    public void a() {
        b();
    }

    private void b() {
        this.h.setText(b.a(j.personal__personal_info_view__read_count, 16, "*", Long.valueOf(this.c.b())));
        this.g.setText(b.a(j.personal__personal_info_view__finish_count, 16, "*", Long.valueOf(this.c.d())));
        this.f.setText(a(this.c.c()));
        if (this.c.f() == 0.0d) {
            this.e.setText(getContext().getString(j.personal__experience_view__ranking_total_low));
        } else {
            this.e.setText(b.a(j.personal__readed_books_view__ranking_total, 16, b.a(this.c.f())));
        }
        this.i.setText(b.a(j.personal__personal_info_view__reading_notes_count, 16, "*", Long.valueOf(DkUserReadingNotesManager.a().b())));
        this.m.setText(b.a(j.personal__experience_view__using_days, 20, Long.valueOf(this.c.e())));
        this.n.setVisibility(0);
        this.n.a(this.c.h());
        this.o.setVisibility(0);
        this.p.setVisibility(0);
    }

    private CharSequence a(long j) {
        int i = (int) (((float) j) / 3600.0f);
        if (Math.round((float) ((j % 3600) / 60)) == 60) {
            i++;
        }
        return b.a(j.personal__personal_info_view__reading_length_hour, 16, "*", Integer.valueOf(i));
    }

    private void c() {
        DkUserReadBookManager.a().a(false, new id(this), 0, 5);
    }

    private void c(ReadBook[] readBookArr) {
        if (readBookArr.length == 0) {
            this.j.setVisibility(8);
        } else {
            this.j.setVisibility(0);
        }
        if (readBookArr.length < 4) {
            this.l.setVisibility(4);
        }
        Rect rect = new Rect();
        getDrawable(com.duokan.c.f.general__shared__book_category_book_shadow).getPadding(rect);
        int length = readBookArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            ReadBook readBook = readBookArr[i];
            if (i2 != 3) {
                View childAt = this.k.getChildAt(i2);
                childAt.setVisibility(0);
                BookCoverView bookCoverView = (BookCoverView) childAt.findViewById(com.duokan.c.g.personal__personal_info_book_view__cover);
                bookCoverView.setOnlineCoverUri(readBook.getCoverUri());
                bookCoverView.setCoverBackgroundResource(com.duokan.c.f.general__book_cover_view__duokan_cover);
                bookCoverView.setPadding(rect.left, rect.top, rect.right, rect.bottom);
                ((TextView) childAt.findViewById(com.duokan.c.g.personal__personal_info_book_view__title)).setText(readBook.getTitle());
                childAt.setOnClickListener(new ie(this, readBook));
                i2++;
                i++;
            } else {
                return;
            }
        }
    }

    private Bitmap d() {
        LinearLayout linearLayout = (LinearLayout) findViewById(com.duokan.c.g.personal__personal_info_view__share_content);
        linearLayout.measure(MeasureSpec.makeMeasureSpec(linearLayout.getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(0, 0));
        Bitmap b = com.duokan.reader.common.bitmap.a.b(linearLayout.getMeasuredWidth(), linearLayout.getMeasuredHeight(), Config.ARGB_8888);
        linearLayout.draw(new Canvas(b));
        return b;
    }
}
