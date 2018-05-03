package com.duokan.reader.ui.bookshelf;

import android.content.res.Configuration;
import android.graphics.Color;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.AppContext;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.ui.LinearScrollView;
import com.duokan.core.ui.AnimUtils;
import com.duokan.p024c.C0254f;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.DkPublic;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.common.webservices.duokan.DkSignInReward;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.al;
import com.duokan.reader.domain.bookshelf.lb;
import com.duokan.reader.domain.bookshelf.ln;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.ui.general.PageHeaderView;
import com.duokan.reader.ui.general.web.StorePageController;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ie extends ActivatedController implements ln {
    /* renamed from: a */
    private final C0709k f6589a = C0709k.m3476a();
    /* renamed from: b */
    private final lb f6590b = lb.m4896a();
    /* renamed from: c */
    private final View f6591c;
    /* renamed from: d */
    private final TextView f6592d;
    /* renamed from: e */
    private final TextView f6593e;
    /* renamed from: f */
    private final TextView f6594f;
    /* renamed from: g */
    private final TextView f6595g;
    /* renamed from: h */
    private final TextView f6596h;
    /* renamed from: i */
    private final TextView f6597i;
    /* renamed from: j */
    private final LinearLayout f6598j;
    /* renamed from: k */
    private final ReaderFeature f6599k = ((ReaderFeature) getContext().queryFeature(ReaderFeature.class));
    /* renamed from: l */
    private final LinkedList<WebSession> f6600l = new LinkedList();
    /* renamed from: m */
    private final StorePageController f6601m;
    /* renamed from: n */
    private final View f6602n;
    /* renamed from: o */
    private final TextView f6603o;
    /* renamed from: p */
    private final ViewGroup f6604p;
    /* renamed from: q */
    private boolean[] f6605q = PersonalPrefs.m5175a().m5235k();
    /* renamed from: r */
    private int f6606r = PersonalPrefs.m5175a().m5236l();
    /* renamed from: s */
    private boolean f6607s = PersonalPrefs.m5175a().m5238n();

    public ie(IFeature mFeature) {
        super(mFeature);
        setContentView((View) (LinearScrollView) LayoutInflater.from(getContext()).inflate(C0256h.bookshelf__sign_in_status_view, null));
        PageHeaderView pageHeaderView = (PageHeaderView) findViewById(C0255g.bookshelf__sign_in_status_view__header);
        pageHeaderView.setBackgroundColor(0);
        pageHeaderView.setTitleTextColor(-1);
        pageHeaderView.setBottomLineColor(0);
        pageHeaderView.setBackDrawable(getDrawable(C0254f.general__shared__back_light));
        pageHeaderView.setCenterTitle(C0258j.bookshelf__sign_in_status_view__title);
        this.f6591c = findViewById(C0255g.bookshelf__sign_in_status_view__info_layout);
        this.f6592d = (TextView) findViewById(C0255g.bookshelf__sign_in_status_view__head);
        this.f6593e = (TextView) findViewById(C0255g.bookshelf__sign_in_status_view__day);
        this.f6594f = (TextView) findViewById(C0255g.bookshelf__sign_in_status_view__tail);
        this.f6595g = (TextView) findViewById(C0255g.bookshelf__sign_in_status_view__cash);
        this.f6596h = (TextView) findViewById(C0255g.bookshelf__sign_in_status_view__coupon);
        this.f6597i = (TextView) findViewById(C0255g.bookshelf__sign_in_status_view__reward);
        this.f6598j = (LinearLayout) findViewById(C0255g.bookshelf__sign_in_status_view__sign_in_area);
        this.f6604p = (ViewGroup) findViewById(C0255g.bookshelf__sign_in_status_view__task_container);
        this.f6602n = findViewById(C0255g.bookshelf__sign_in_status_view__empty_container);
        this.f6603o = (TextView) findViewById(C0255g.bookshelf__sign_in_status_view__empty_des);
        this.f6601m = new SignInStatusController$1(this, getContext());
        this.f6601m.setHasTitle(false);
        addSubController(this.f6601m);
        activate(this.f6601m);
        this.f6604p.addView(this.f6601m.getContentView());
        if (DkPublic.isMiui()) {
            this.f6601m.loadUrl(C0641o.m2934i().m2953a(null));
        } else {
            this.f6601m.loadUrl(C0641o.m2934i().m2957a(false, null));
        }
        m9835b();
    }

    /* renamed from: a */
    private void m9833a(String str) {
        if (str.equals("done")) {
            this.f6604p.setVisibility(8);
            this.f6602n.setVisibility(0);
            this.f6603o.setText(C0258j.bookshelf__sign_in_status_view__task_done);
        } else if (str.equals("empty")) {
            this.f6604p.setVisibility(8);
            this.f6602n.setVisibility(0);
            this.f6603o.setText(C0258j.bookshelf__sign_in_status_view__task_empty);
        } else {
            this.f6604p.setVisibility(0);
            this.f6602n.setVisibility(8);
        }
    }

    /* renamed from: b */
    private void m9835b() {
        m9836c();
        m9839d();
        m9841e();
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            lb.m4896a().m4926f();
        }
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
        lb.m4896a().m4917a((ln) this);
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        lb.m4896a().m4921b((ln) this);
        lb.m4896a().m4919a(true);
    }

    protected void onActivityConfigurationChanged(Configuration configuration) {
        super.onActivityConfigurationChanged(configuration);
        this.f6601m.refresh();
    }

    /* renamed from: c */
    private void m9836c() {
        int a = lb.m4896a().m4914a(this.f6605q, this.f6606r);
        boolean z = this.f6605q[this.f6606r - 1];
        if (a > 0 || this.f6606r == 1) {
            this.f6592d.setText(C0258j.bookshelf__sign_in_status_view__head_text);
        } else {
            this.f6592d.setText(C0258j.bookshelf__sign_in_status_view__head_serial_text);
        }
        this.f6593e.setText(String.valueOf(z ? this.f6606r - a : (this.f6606r - a) - 1));
        if (z) {
            if (this.f6606r != 7) {
                if (a > 0) {
                    this.f6594f.setText(String.format(getString(C0258j.bookshelf__sign_in_status_view__tail_resign), new Object[]{Integer.valueOf(a)}));
                } else {
                    this.f6594f.setText(String.format(getString(C0258j.bookshelf__sign_in_status_view__tail), new Object[]{Integer.valueOf(7 - this.f6606r)}));
                }
            } else if (a > 0) {
                this.f6594f.setText(String.format(getString(C0258j.bookshelf__sign_in_status_view__tail_reward_resign), new Object[]{Integer.valueOf(a)}));
            } else {
                this.f6594f.setText(String.format(getString(C0258j.bookshelf__sign_in_status_view__tail_reward), new Object[]{Integer.valueOf(7 - this.f6606r)}));
            }
        } else if (a > 0) {
            this.f6594f.setText(C0258j.bookshelf__sign_in_status_view__tail_normal);
        } else {
            this.f6594f.setText(String.format(getString(C0258j.bookshelf__sign_in_status_view__tail), new Object[]{Integer.valueOf((7 - this.f6606r) + 1)}));
        }
    }

    /* renamed from: a */
    private View m9830a(int i, boolean z, int i2) {
        View imageView;
        if (z || i2 >= i + 1 || i == 6) {
            imageView = new ImageView(getContext());
            imageView.setScaleType(ScaleType.CENTER);
            if (z) {
                if (i == 6 && this.f6607s) {
                    imageView.setImageResource(C0254f.bookshelf__sign_in_status_view__lottery);
                    imageView.setOnClickListener(new iw(this));
                    return imageView;
                } else if (i != 6 || lb.m4896a().m4914a(this.f6605q, i2) <= 0) {
                    imageView.setImageResource(C0254f.bookshelf__sign_in_status_view__signed);
                    imageView.setOnClickListener(new iy(this));
                    return imageView;
                } else {
                    imageView.setImageResource(C0254f.bookshelf__sign_in_status_view__lottery);
                    imageView.setOnClickListener(new ix(this));
                    return imageView;
                }
            } else if (i2 > i + 1) {
                imageView.setImageResource(C0254f.bookshelf__sign_in_status_view__resign);
                imageView.setOnClickListener(new iz(this));
                return imageView;
            } else if (i == 6) {
                imageView.setImageResource(C0254f.bookshelf__sign_in_status_view__lottery);
                if (i2 != i + 1) {
                    imageView.setOnClickListener(new ja(this));
                    return imageView;
                } else if (this.f6590b.m4914a(this.f6605q, i2) == 0) {
                    imageView.setOnClickListener(new jb(this));
                    return imageView;
                } else {
                    imageView.setOnClickListener(new jc(this));
                    return imageView;
                }
            } else {
                imageView.setImageResource(C0254f.bookshelf__sign_in_status_view__need_sign_in);
                imageView.setOnClickListener(new ig(this));
                return imageView;
            }
        }
        imageView = new TextView(getContext());
        imageView.setTextSize(12.0f);
        imageView.setGravity(17);
        imageView.setTextColor(Color.parseColor("#999999"));
        imageView.setText(String.format(getString(C0258j.bookshelf__sign_in_view__daily_name), new Object[]{Integer.valueOf(i + 1)}));
        imageView.setOnClickListener(new ir(this));
        return imageView;
    }

    /* renamed from: a */
    public void m9849a() {
        lb.m4896a().m4916a(new al(this.f6589a.m3502b(PersonalAccount.class)));
        ActivatedController storePageController = new StorePageController(AppContext.getAppContext(getContext()));
        storePageController.loadUrl(C0641o.m2934i().m2946J());
        this.f6599k.showPopup(storePageController);
    }

    /* renamed from: d */
    private void m9839d() {
        int i = 0;
        this.f6598j.removeAllViews();
        LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        while (i < this.f6605q.length) {
            this.f6598j.addView(m9830a(i, this.f6605q[i], this.f6606r), layoutParams);
            i++;
        }
    }

    /* renamed from: a */
    public void mo1703a(boolean z) {
        m9835b();
    }

    /* renamed from: a */
    public void mo1704a(boolean[] zArr, int i, List<DkSignInReward> list, boolean z, boolean z2, boolean z3) {
        m9853b(zArr, i, list, z, z2, z3);
    }

    /* renamed from: b */
    public void mo1706b(String str) {
        View inflate = LayoutInflater.from(getContext()).inflate(C0256h.bookshelf__sign_in_detail_view, null);
        inflate.getBackground().setAlpha(180);
        ActivatedController c0303e = new ActivatedController(AppContext.getAppContext(getContext()));
        c0303e.setContentView(inflate);
        inflate.setOnClickListener(new ih(this, c0303e));
        ((ImageView) inflate.findViewById(C0255g.bookshelf__sign_in_detail_view__main)).setImageURI(Uri.fromFile(new File(str)));
        lb.m4896a().m4926f();
        this.f6599k.showPopup(c0303e);
        AnimUtils.showAnimation(c0303e.getContentView(), null);
    }

    /* renamed from: e */
    private void m9841e() {
        Iterator it = this.f6600l.iterator();
        while (it.hasNext()) {
            ((WebSession) it.next()).close();
        }
        m9847h();
        m9845g();
        m9843f();
        this.f6595g.setOnClickListener(new ij(this));
        this.f6596h.setOnClickListener(new ik(this));
        this.f6597i.setOnClickListener(new il(this));
    }

    /* renamed from: f */
    private void m9843f() {
        if (C0709k.m3476a().m3500a(PersonalAccount.class)) {
            new im(this).open();
        } else {
            this.f6597i.setText(String.valueOf(0));
        }
    }

    /* renamed from: g */
    private void m9845g() {
        if (C0709k.m3476a().m3500a(PersonalAccount.class)) {
            new in(this).open();
        } else {
            this.f6595g.setText(String.valueOf(0));
        }
    }

    /* renamed from: h */
    private void m9847h() {
        if (C0709k.m3476a().m3500a(PersonalAccount.class)) {
            new io(this).open();
        } else {
            this.f6596h.setText(String.valueOf(0));
        }
    }

    /* renamed from: b */
    public void m9853b(boolean[] zArr, int i, List<DkSignInReward> list, boolean z, boolean z2, boolean z3) {
        ActivatedController jeVar = new je(this, getContext());
        int parseColor = Color.parseColor("#1a1a1a");
        int parseColor2 = Color.parseColor("#666666");
        int parseColor3 = Color.parseColor("#b3666666");
        int parseColor4 = Color.parseColor("#ff6600");
        StringBuilder stringBuilder = new StringBuilder();
        if (z2) {
            jeVar.m9856a(getString(C0258j.bookshelf__sign_in_status_view__lottery), parseColor);
            StringBuilder stringBuilder2 = new StringBuilder();
            if (list != null) {
                for (DkSignInReward dkSignInReward : list) {
                    if (dkSignInReward.mType == 0) {
                        stringBuilder2.append(String.format(getString(C0258j.bookshelf__sign_in_status_view__reward), new Object[]{dkSignInReward.mValue, dkSignInReward.mName}));
                        stringBuilder2.append(" ");
                    } else {
                        stringBuilder.append(String.format(getString(C0258j.bookshelf__sign_in_status_view__reward), new Object[]{dkSignInReward.mValue, dkSignInReward.mName}));
                        stringBuilder.append(" ");
                    }
                }
            }
            if (stringBuilder2.length() > 0) {
                jeVar.m9860b(getString(C0258j.bookshelf__sign_in_status_view__sign_in_prize), parseColor2, stringBuilder2.toString().trim(), parseColor4);
            }
            if (stringBuilder.length() > 0) {
                jeVar.m9860b(getString(C0258j.bookshelf__sign_in_status_view__lottery_prize), parseColor2, stringBuilder.toString().trim(), parseColor4);
            }
        } else {
            String string;
            if (z3) {
                string = getString(C0258j.bookshelf__sign_in_status_view__resign_succeed);
            } else {
                string = getString(C0258j.bookshelf__sign_in_status_view__sign_in_succeed);
            }
            if (list != null) {
                for (DkSignInReward dkSignInReward2 : list) {
                    stringBuilder.append(String.format(getString(C0258j.bookshelf__sign_in_status_view__reward), new Object[]{dkSignInReward2.mValue, dkSignInReward2.mName}));
                    stringBuilder.append(" ");
                }
            }
            if (stringBuilder.length() > 0) {
                jeVar.m9857a(string + "，", parseColor, stringBuilder.toString().trim(), parseColor4);
            } else {
                jeVar.m9856a(string, parseColor);
            }
        }
        int a = lb.m4896a().m4914a(zArr, i);
        if (z2) {
            jeVar.m9861c(getString(C0258j.bookshelf__sign_in_status_view__hint_big_reward), parseColor3);
        } else if (z) {
            jeVar.m9859b(getString(C0258j.bookshelf__sign_in_status_view__hint_lottery), parseColor2);
            jeVar.m9858a(getString(C0258j.bookshelf__sign_in_status_view__goto_lottery), new ip(this, jeVar));
        } else if (a > 0) {
            if (i != 7) {
                jeVar.m9859b(String.format(getString(C0258j.bookshelf__sign_in_status_view__hint_resign), new Object[]{Integer.valueOf(i - a), Integer.valueOf(a)}), parseColor2);
                jeVar.m9858a(getString(C0258j.bookshelf__sign_in_status_view__goto_resign), new it(this, jeVar));
            } else if (zArr[i - 1]) {
                jeVar.m9859b(String.format(getString(C0258j.bookshelf__sign_in_status_view__hint_need_resign), new Object[]{Integer.valueOf(7 - a), Integer.valueOf(a)}), parseColor2);
                jeVar.m9858a(getString(C0258j.bookshelf__sign_in_status_view__goto_resign), new iq(this, jeVar));
            } else {
                jeVar.m9859b(String.format(getString(C0258j.bookshelf__sign_in_status_view__hint_need_sign), new Object[]{Integer.valueOf((7 - a) - 1)}), parseColor2);
                jeVar.m9858a(getString(C0258j.bookshelf__sign_in_status_view__goto_sign), new is(this, jeVar));
            }
        } else if (zArr[i - 1]) {
            jeVar.m9859b(String.format(getString(C0258j.bookshelf__sign_in_status_view__hint), new Object[]{Integer.valueOf(7 - i)}), parseColor2);
        } else {
            jeVar.m9859b(String.format(getString(C0258j.bookshelf__sign_in_status_view__hint), new Object[]{Integer.valueOf((7 - i) + 1)}), parseColor2);
            if (i != 7) {
                jeVar.m9858a(getString(C0258j.bookshelf__sign_in_status_view__goto_sign), new iu(this, jeVar));
            } else {
                jeVar.m9858a(getString(C0258j.bookshelf__sign_in_status_view__goto_sign_and_lottery), new iv(this, jeVar));
            }
        }
        this.f6599k.showPopup(jeVar);
        this.f6605q = zArr;
        this.f6606r = i;
        this.f6607s = z;
        m9835b();
    }
}
