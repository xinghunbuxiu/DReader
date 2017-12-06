package com.duokan.reader.ui.bookshelf;

import android.graphics.Color;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.duokan.c.f;
import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.c.j;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.MyContextWrapper;
import com.duokan.core.ui.UTools;
import com.duokan.reader.common.webservices.duokan.DkStoreAdInfo;
import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.bookshelf.kp;
import com.duokan.reader.domain.bookshelf.la;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.ui.general.web.StorePageController;

import org.apache.http.HttpStatus;

import java.io.File;
import java.util.List;

public class hp extends gx implements la {
    private final i a = i.f();
    private final View b;
    private final TextView c;
    private final LinearLayout d;
    private final LinearLayout e;

    public hp(IFeature featrue) {
        super(featrue);
        a(LayoutInflater.from(getContext()).inflate(h.bookshelf__sign_in_view, null, false));
        this.b = findViewById(g.bookshelf__sign_in_view__sign);
        this.c = (TextView) findViewById(g.bookshelf__sign_in_view__signing);
        this.d = (LinearLayout) findViewById(g.bookshelf__sign_in_view__weekly_signs);
        this.e = (LinearLayout) findViewById(g.bookshelf__sign_in_view__switcher);
        findViewById(g.bookshelf__sign_in_view__tip).setOnClickListener(new hq(this));
        this.e.setSelected(PersonalPrefs.a().j());
        this.e.setOnClickListener(new ht(this));
        a(true, false);
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
        kp.a().a((la) this);
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        kp.a().b((la) this);
    }

    public void a(boolean z, boolean z2) {
        a(PersonalPrefs.a().k(), PersonalPrefs.a().l(), PersonalPrefs.a().n(), z, z2);
    }

    public void a(boolean[] zArr, int i, List list, boolean z, boolean z2, boolean z3, boolean z4, int i2, DkStoreAdInfo[] dkStoreAdInfoArr) {
        b(zArr, i, list, z, z2, z3, z4, i2, dkStoreAdInfoArr);
    }

    public void c() {
    }

    public void b(String str) {
        View inflate = LayoutInflater.from(getContext()).inflate(h.bookshelf__sign_in_detail_view, null);
        inflate.getBackground().setAlpha(180);
        ActivatedController activatedControllerVar = new ActivatedController(MyContextWrapper.getFeature(getContext()));
        activatedControllerVar.setContentView(inflate);
        inflate.setOnClickListener(new hu(this, activatedControllerVar));
        ((ImageView) inflate.findViewById(g.bookshelf__sign_in_detail_view__main)).setImageURI(Uri.fromFile(new File(str)));
        kp.a().e();
        showPopup(activatedControllerVar);
        UTools.closeAnimation(activatedControllerVar.getContentView(), null);
    }

    public void d() {
        kp.a().a(true, true);
    }

    private void a(boolean[] zArr, int i, boolean z, boolean z2, boolean z3) {
        int a = kp.a().a(zArr, i);
        this.d.removeAllViews();
        for (int i2 = 0; i2 < zArr.length; i2++) {
            LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
            layoutParams.setMargins(UTools.getMinimumHeight(getContext(), 2.0f), 0, UTools.getMinimumHeight(getContext(), 2.0f), 0);
            this.d.addView(a(i2, zArr[i2], i), layoutParams);
        }
        if (!this.a.a(PersonalAccount.class)) {
            this.b.setVisibility(0);
            this.c.setVisibility(8);
            ((TextView) this.b).setText(getResources().getString(j.personal__account_summary_view__login));
            this.b.setOnClickListener(new hw(this));
        } else if (!zArr[i - 1]) {
            this.b.setVisibility(0);
            this.c.setVisibility(8);
            ((TextView) this.b).setText(getResources().getString(j.bookshelf__sign_in_view__sign));
            this.b.setOnClickListener(new hx(this));
        } else if (a > 0) {
            this.c.setText(String.format(getResources().getString(j.bookshelf__sign_in_view__forget_sign), new Object[]{Integer.valueOf(a)}));
            this.c.setBackgroundDrawable(getResources().getDrawable(f.bookshelf__sign_in_view__resign_background));
            this.c.setTextColor(Color.rgb(124, 144, 171));
            this.b.setVisibility(8);
            this.c.setVisibility(0);
            this.c.setOnClickListener(new hy(this));
        } else if (i == 7 && z) {
            this.b.setVisibility(0);
            this.c.setVisibility(8);
            ((TextView) this.b).setText(getResources().getString(j.bookshelf__sign_in_view__sign_big_reward));
            this.b.setOnClickListener(new hz(this));
        } else {
            this.c.setText(j.bookshelf__sign_in_view__signed);
            this.c.setBackgroundDrawable(getResources().getDrawable(f.bookshelf__sign_in_view__signed_background));
            this.c.setTextColor(Color.rgb(HttpStatus.SC_CREATED, HttpStatus.SC_CREATED, HttpStatus.SC_CREATED));
            this.b.setVisibility(8);
            this.c.setVisibility(0);
            this.c.setOnClickListener(null);
            if (z3) {
                dismissAllPopups();
                requestBack();
            }
        }
    }

    private void g() {
        i.f().a(new ia(this));
    }

    private void h() {
        kp.a().a(new ab(this.a.b(PersonalAccount.class)));
        ActivatedController storePageController = new StorePageController(MyContextWrapper.getFeature(getContext()));
        storePageController.loadUrl(p.i().K());
        showPopup(storePageController);
    }

    private View a(int i, boolean z, int i2) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(h.bookshelf__sign_in_view__daily_item, null);
        ((TextView) linearLayout.findViewById(g.bookshelf__sign_in_view__daily_name)).setText(String.format(getResources().getString(j.bookshelf__sign_in_view__daily_name), new Object[]{Integer.valueOf(i + 1)}));
        linearLayout.setOnClickListener(new ib(this));
        if (z) {
            ((ImageView) linearLayout.findViewById(g.bookshelf__sign_in_view__daily_pic)).setImageResource(f.bookshelf__sign_in_view__sign);
        } else if (!z && i2 > i + 1) {
            ((ImageView) linearLayout.findViewById(g.bookshelf__sign_in_view__daily_pic)).setImageResource(f.bookshelf__sign_in_view__resign);
            linearLayout.setBackgroundDrawable(getResources().getDrawable(f.bookshelf__sign_in_view__item_background_resign));
            linearLayout.setOnClickListener(new hr(this));
        } else if (i == 6) {
            ((ImageView) linearLayout.findViewById(g.bookshelf__sign_in_view__daily_pic)).setImageResource(f.bookshelf__sign_in_view__big_reward);
            linearLayout.setBackgroundDrawable(getResources().getDrawable(f.bookshelf__sign_in_view__item_background_big_reward));
        }
        return linearLayout;
    }

    private void b(boolean[] zArr, int i, List list, boolean z, boolean z2, boolean z3, boolean z4, int i2, DkStoreAdInfo[] dkStoreAdInfoArr) {
        ActivatedController icVar = new ic(MyContextWrapper.getFeature(getContext()), zArr, i, list, z, z2, z3, z4, i2, dkStoreAdInfoArr);
        showPopup(icVar);
        UTools.closeAnimation(icVar.getContentView(), new hs(this));
    }
}
