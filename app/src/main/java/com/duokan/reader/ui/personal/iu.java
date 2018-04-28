package com.duokan.reader.ui.personal;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.duokan.common.C0268j;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.p024c.C0254f;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.account.oauth.ThirdWeiXin;
import com.duokan.reader.domain.cloud.DkCloudRedeemFund;
import com.duokan.reader.domain.cloud.ex;
import com.duokan.reader.ui.C0435s;
import com.duokan.reader.ui.general.BookCoverView;
import com.duokan.reader.ui.general.C1329do;
import com.duokan.reader.ui.general.DkBigFaceView;
import com.duokan.reader.ui.general.HeaderView;
import com.duokan.reader.ui.general.ReaderUi;
import com.duokan.reader.ui.general.deprecatedDkTextView;

public class iu extends ActivatedController {
    /* renamed from: a */
    private final DkCloudRedeemFund f8748a;
    /* renamed from: b */
    private final TextView f8749b;

    public iu(IFeature mFeature, DkCloudRedeemFund dkCloudRedeemFund) {
        LayoutParams layoutParams;
        super(mFeature);
        this.f8748a = dkCloudRedeemFund;
        setContentView(C0256h.personal__redeem_info_view);
        ((HeaderView) findViewById(C0255g.personal__redeem_info_view__header)).setLeftTitle(C0258j.personal__personal_redeem_info_view__header);
        BookCoverView bookCoverView = (BookCoverView) findViewById(C0255g.personal__redeem_info_view__book_cover);
        bookCoverView.setOnlineCoverUri(dkCloudRedeemFund.getBookCoverUrl());
        bookCoverView.setCoverBackgroundResource(C0254f.general__book_cover_view__duokan_cover);
        bookCoverView.m9919a();
        bookCoverView.setOnClickListener(new iv(this));
        ((TextView) findViewById(C0255g.personal__redeem_info_view__title)).setText(getResources().getString(C0258j.personal__personal_redeem_info_view__title, new Object[]{dkCloudRedeemFund.getTitle()}));
        TextView textView = (TextView) findViewById(C0255g.personal__redeem_info_view__author);
        if (!TextUtils.isEmpty(dkCloudRedeemFund.getBookAuthor())) {
            textView.setText(getResources().getString(C0258j.personal__personal_redeem_info_view__author, new Object[]{dkCloudRedeemFund.getBookAuthor()}));
        } else if (!TextUtils.isEmpty(dkCloudRedeemFund.getBookEditor())) {
            textView.setText(getResources().getString(C0258j.personal__personal_redeem_info_view__editor, new Object[]{dkCloudRedeemFund.getBookEditor()}));
        }
        this.f8749b = (TextView) findViewById(C0255g.personal__redeem_info_view__msg);
        LayoutParams layoutParams2 = findViewById(C0255g.personal__redeem_info_view__placeholder).getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams = new LayoutParams(-1, -2);
        } else {
            layoutParams = layoutParams2;
        }
        C0435s c0435s = (C0435s) getContext().queryFeature(C0435s.class);
        if (c0435s != null) {
            layoutParams.height = c0435s.getTheme().getPagePaddingBottom();
        } else {
            layoutParams.height = 0;
        }
        if (this.f8748a.isUsed()) {
            findViewById(C0255g.personal__redeem_info_view__unused).setVisibility(8);
            findViewById(C0255g.personal__redeem_info_view__useded).setVisibility(0);
            findViewById(C0255g.personal__redeem_info_view__arrow).setVisibility(0);
            if (TextUtils.isEmpty(this.f8748a.getMessage())) {
                findViewById(C0255g.personal__redeem_info_view__msg_root).setVisibility(8);
            } else {
                findViewById(C0255g.personal__redeem_info_view__msg_root).setVisibility(0);
                ((deprecatedDkTextView) findViewById(C0255g.personal__redeem_info_view__msg_content)).setText(this.f8748a.getMessage());
                ((TextView) findViewById(C0255g.personal__redeem_info_view__msg_from)).setText(getResources().getString(C0258j.personal__personal_redeem_info_view__word_time, new Object[]{ReaderUi.m10159a(getContext(), this.f8748a.getWordUpdatedTime().getTime(), false)}));
            }
            ((DkBigFaceView) findViewById(C0255g.personal__redeem_info_view__received_face)).setUser(this.f8748a.getReceivedUser());
            textView = (TextView) findViewById(C0255g.personal__redeem_info_view__received_name);
            String str = TextUtils.isEmpty(this.f8748a.getReceivedUser().mNickName) ? this.f8748a.getReceivedUser().mUserId : this.f8748a.getReceivedUser().mNickName;
            textView.setText(getResources().getString(C0258j.personal__personal_redeem_info_view__received_name, new Object[]{str}));
            ((TextView) findViewById(C0255g.personal__redeem_info_view__received_time)).setText(ReaderUi.m10159a(getContext(), this.f8748a.getReceivedTime().getTime(), false));
            return;
        }
        findViewById(C0255g.personal__redeem_info_view__unused).setVisibility(0);
        findViewById(C0255g.personal__redeem_info_view__useded).setVisibility(8);
        findViewById(C0255g.personal__redeem_info_view__arrow).setVisibility(8);
        if (!TextUtils.isEmpty(dkCloudRedeemFund.getMessage())) {
            this.f8749b.setText(dkCloudRedeemFund.getMessage());
        }
        this.f8749b.setOnClickListener(new iw(this));
        String format = String.format(getString(C0258j.personal__personal_redeem_info_view__msg), new Object[]{this.f8748a.getTitle(), this.f8748a.getLinkUrl()});
        View findViewById = findViewById(C0255g.personal__redeem_info_view__sms);
        boolean a = C0268j.m614a(getContext());
        findViewById(C0255g.personal__redeem_info_view__sms_icon).setEnabled(a);
        findViewById(C0255g.personal__redeem_info_view__sms_text).setEnabled(a);
        findViewById.setEnabled(a);
        findViewById.setOnClickListener(new iy(this, format));
        findViewById = findViewById(C0255g.personal__redeem_info_view__wx);
        a = ThirdWeiXin.isSupportShareWeiXinFriends(getContext());
        findViewById(C0255g.personal__redeem_info_view__wx_icon).setEnabled(a);
        findViewById(C0255g.personal__redeem_info_view__wx_text).setEnabled(a);
        findViewById.setEnabled(a);
        findViewById.setOnClickListener(new iz(this, format));
        findViewById(C0255g.personal__redeem_info_view__more).setOnClickListener(new ja(this, format));
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (!z) {
        }
    }

    /* renamed from: a */
    private void m12025a(String str, C1329do c1329do) {
        ex.m5516a().m5521a(this.f8748a, str, new jb(this, str, c1329do));
    }
}
