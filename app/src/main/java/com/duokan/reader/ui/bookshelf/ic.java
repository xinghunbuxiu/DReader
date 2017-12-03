package com.duokan.reader.ui.bookshelf;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;
import com.duokan.core.ui.UTools;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.common.webservices.duokan.DkSignInReward;
import com.duokan.reader.common.webservices.duokan.DkStoreAdInfo;
import com.duokan.reader.domain.bookshelf.kp;
import com.duokan.reader.ui.general.BookCoverView;
import com.duokan.reader.ui.general.ep;
import com.duokan.reader.ui.general.hn;
import com.duokan.reader.ui.general.web.StorePageController;

import org.apache.http.HttpStatus;

import java.util.List;

public class ic extends ActivatedController {
    private final boolean[] a;
    private final int b;
    private final List c;
    private final boolean d;
    private final boolean e;
    private final boolean f;
    private final boolean g;
    private final LinearLayout h;
    private final LinearLayout i;
    private final ImageView j;
    private final ImageView k;
    private final ImageView l;
    private final LinearLayout m;
    private final TextView n;
    private final TextView o;
    private final int p;
    private final int q = kp.a().a(this.a, this.b);
    private final DkStoreAdInfo[] r;
    private final ReaderFeature s;

    public ic(IFeature featrue, boolean[] zArr, int i, List list, boolean z, boolean z2, boolean z3, boolean z4, int i2, DkStoreAdInfo[] dkStoreAdInfoArr) {
        super(featrue);
        this.a = zArr;
        this.b = i;
        this.c = list;
        this.d = z;
        this.e = z2;
        this.f = z3;
        this.g = z4;
        this.p = i2;
        this.r = dkStoreAdInfoArr;
        this.s = (ReaderFeature) getContext().queryFeature(ReaderFeature.class);
        View inflate = LayoutInflater.from(getContext()).inflate(h.bookshelf__sign_in_succeed_view, null);
        View epVar = new ep(getContext());
        epVar.setForeground(new hn((float) UTools.closeAnimation(getContext(), 3.0f), (float) UTools.closeAnimation(getContext(), 3.0f), -16777216));
        epVar.addView(inflate);
        inflate = new FrameLayout(getContext());
        inflate.addView(epVar, new LayoutParams(-2, -2, 17));
        inflate.setBackgroundColor(Color.argb(153, 0, 0, 0));
        inflate.setLayoutParams(new LayoutParams(-1, -1));
        setContentView(inflate);
        this.h = (LinearLayout) findViewById(g.bookshelf__sign_in_succeed_view__label_layout);
        this.i = (LinearLayout) findViewById(g.bookshelf__sign_in_succeed_view__hottest);
        this.j = (ImageView) findViewById(g.bookshelf__sign_in_succeed_view__label);
        this.k = (ImageView) findViewById(g.bookshelf__sign_in_succeed_view__count);
        this.l = (ImageView) findViewById(g.bookshelf__sign_in_succeed_view__resign_count);
        this.m = (LinearLayout) findViewById(g.bookshelf__sign_in_succeed_view__reward);
        this.n = (TextView) findViewById(g.bookshelf__sign_in_succeed_view__reward_text);
        this.o = (TextView) findViewById(g.bookshelf__sign_in_succeed_view__close);
        a();
    }

    private void a() {
        int rgb;
        int i;
        int rgb2;
        if (this.g) {
            rgb2 = Color.rgb(197, 233, 249);
            rgb = Color.rgb(35, 123, 186);
            i = rgb2;
        } else {
            rgb2 = Color.rgb(255, 226, 177);
            rgb = Color.rgb(216, 78, 67);
            i = rgb2;
        }
        this.h.setBackgroundColor(rgb);
        this.o.setTextColor(rgb);
        this.n.setTextColor(i);
        c();
        for (DkSignInReward dkSignInReward : this.c) {
            this.m.removeAllViews();
            this.m.addView(a(dkSignInReward, i));
        }
        if (this.r == null || this.r.length < 3) {
            this.i.setVisibility(8);
        } else {
            try {
                b();
            } catch (Throwable th) {
                this.i.setVisibility(8);
            }
        }
        Runnable idVar = new id(this);
        if (this.d) {
            this.n.setText(getString(j.bookshelf__sign_in_succeed_view__hint_lottery));
            this.o.setText(getString(j.bookshelf__sign_in_succeed_view__goto_lottery));
            idVar = new ie(this);
        } else if (this.f) {
            this.n.setText(getString(j.bookshelf__sign_in_succeed_view__hint_big_reward));
            if (this.e) {
                this.o.setText(getString(j.bookshelf__sign_in_succeed_view__check_reward));
                idVar = new if (this) ;
            } else {
                this.o.setText(getString(j.bookshelf__sign_in_succeed_view__close));
            }
        } else if (d()) {
            this.n.setText(String.format(getString(j.bookshelf__sign_in_succeed_view__hint_need_resign), new Object[]{Integer.valueOf(7 - this.q), Integer.valueOf(this.q)}));
            this.o.setText(getString(j.bookshelf__sign_in_succeed_view__goto_resign));
            idVar = new ig(this);
        } else {
            if (this.q == 0) {
                this.n.setText(String.format(getString(j.bookshelf__sign_in_succeed_view__hint), new Object[]{Integer.valueOf(7 - this.b)}));
            } else {
                this.n.setText(String.format(getString(j.bookshelf__sign_in_succeed_view__hint_resign), new Object[]{Integer.valueOf(this.b - this.q), Integer.valueOf(this.q)}));
            }
            this.o.setText(getString(j.bookshelf__sign_in_succeed_view__close));
        }
        this.o.setOnClickListener(new ih(this, idVar));
    }

    private void b() {
        for (int i = 0; i < 3; i++) {
            int rgb;
            DkStoreAdInfo dkStoreAdInfo = this.r[i];
            LinearLayout linearLayout = (LinearLayout) this.i.getChildAt(i);
            TextView textView = (TextView) linearLayout.findViewById(g.bookshelf__sign_in_succeed_view__ad_item_name);
            textView.setText(dkStoreAdInfo.mAdName);
            if (i == 1) {
                rgb = Color.rgb(34, HttpStatus.SC_OK, 109);
            } else if (i == 2) {
                rgb = Color.rgb(58, 184, 230);
            } else {
                rgb = Color.rgb(251, 78, 83);
            }
            if (i != 0) {
                textView.setTextColor(rgb);
            }
            ((TextView) linearLayout.findViewById(g.bookshelf__sign_in_succeed_view__ad_item_type)).setText(dkStoreAdInfo.mAdType);
            BookCoverView bookCoverView = (BookCoverView) linearLayout.findViewById(g.bookshelf__sign_in_succeed_view__ad_item_cover);
            bookCoverView.setOnlineCoverUri(dkStoreAdInfo.mCoverUri);
            bookCoverView.setCoverBackgroundResource(f.general__book_cover_view__duokan_cover);
            bookCoverView.a();
            linearLayout.setOnClickListener(new ii(this, i));
        }
    }

    private ActivatedController a(DkStoreAdInfo dkStoreAdInfo) {
        ActivatedController storePageController = new StorePageController(getContext());
        storePageController.loadUrl(p.i().z() + "/hs/market/channel/" + dkStoreAdInfo.mReferenceId + "?_t=app.checkout");
        return storePageController;
    }

    private View a(DkSignInReward dkSignInReward, int i) {
        View textView = new TextView(getContext());
        textView.setTextSize(12.0f);
        if (this.g) {
            textView.setBackgroundResource(f.bookshelf__sign_in_succeed_view__resign_reward_background);
        } else {
            textView.setBackgroundResource(f.bookshelf__sign_in_succeed_view__reward_background);
        }
        textView.setGravity(17);
        textView.setTextColor(i);
        textView.setText(String.format(getString(j.bookshelf__sign_in_succeed_view__reward), new Object[]{dkSignInReward.mValue, dkSignInReward.mName}));
        return textView;
    }

    private void c() {
        if (this.g) {
            this.j.setImageResource(f.bookshelf__sign_in_succeed_view__resign_label);
            this.k.setVisibility(4);
            this.l.setVisibility(0);
            switch (this.p) {
                case 2:
                    this.l.setImageResource(f.bookshelf__sign_in_succeed_view__resign_count_2);
                    return;
                case 3:
                    this.l.setImageResource(f.bookshelf__sign_in_succeed_view__resign_count_3);
                    return;
                case 4:
                    this.l.setImageResource(f.bookshelf__sign_in_succeed_view__resign_count_4);
                    return;
                case 5:
                    this.l.setImageResource(f.bookshelf__sign_in_succeed_view__resign_count_5);
                    return;
                case 6:
                    this.l.setImageResource(f.bookshelf__sign_in_succeed_view__resign_count_6);
                    return;
                default:
                    this.l.setImageResource(f.bookshelf__sign_in_succeed_view__resign_count_1);
                    return;
            }
        } else if (this.f) {
            this.k.setVisibility(4);
            this.l.setVisibility(4);
            this.j.setImageResource(f.bookshelf__sign_in_succeed_view__reward_label);
        } else {
            this.k.setVisibility(0);
            this.l.setVisibility(4);
            switch (e()) {
                case 2:
                    this.k.setImageResource(f.bookshelf__sign_in_succeed_view__count_2);
                    return;
                case 3:
                    this.k.setImageResource(f.bookshelf__sign_in_succeed_view__count_3);
                    return;
                case 4:
                    this.k.setImageResource(f.bookshelf__sign_in_succeed_view__count_4);
                    return;
                case 5:
                    this.k.setImageResource(f.bookshelf__sign_in_succeed_view__count_5);
                    return;
                case 6:
                    this.k.setImageResource(f.bookshelf__sign_in_succeed_view__count_6);
                    return;
                case 7:
                    this.k.setImageResource(f.bookshelf__sign_in_succeed_view__count_7);
                    return;
                default:
                    this.k.setVisibility(4);
                    this.j.setImageResource(f.bookshelf__sign_in_succeed_view__today);
                    return;
            }
        }
    }

    private boolean d() {
        if (!this.a[this.b - 1] || this.d || this.q == 0 || this.b != 7) {
            return false;
        }
        return true;
    }

    private int e() {
        int i = this.b - 2;
        int i2 = 1;
        while (i >= 0) {
            if (!this.a[i]) {
                return 1;
            }
            i--;
            i2++;
        }
        return i2;
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            kp.a().e();
        }
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        kp.a().g();
    }
}
