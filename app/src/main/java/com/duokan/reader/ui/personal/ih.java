package com.duokan.reader.ui.personal;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

import com.duokan.c.f;
import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.c.j;
import com.duokan.common.SysTools;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;
import com.duokan.reader.domain.account.oauth.ThirdWeiXin;
import com.duokan.reader.domain.cloud.DkCloudRedeemFund;
import com.duokan.reader.domain.cloud.fp;
import com.duokan.reader.ui.general.BookCoverView;
import com.duokan.reader.ui.general.DkBigFaceView;
import com.duokan.reader.ui.general.HeaderView;
import com.duokan.reader.ui.general.ReaderUi;
import com.duokan.reader.ui.general.deprecatedDkTextView;
import com.duokan.reader.ui.s;

do;

public class ih extends ActivatedController {
    private final DkCloudRedeemFund a;
    private final TextView b;

    public ih(IFeature featrue, DkCloudRedeemFund dkCloudRedeemFund) {
        LayoutParams layoutParams;
        super(featrue);
        this.a = dkCloudRedeemFund;
        setContentView(h.personal__redeem_info_view);
        ((HeaderView) findViewById(g.personal__redeem_info_view__header)).setLeftTitle(j.personal__personal_redeem_info_view__header);
        BookCoverView bookCoverView = (BookCoverView) findViewById(g.personal__redeem_info_view__book_cover);
        bookCoverView.setOnlineCoverUri(dkCloudRedeemFund.getBookCoverUrl());
        bookCoverView.setCoverBackgroundResource(f.general__book_cover_view__duokan_cover);
        bookCoverView.a();
        bookCoverView.setOnClickListener(new ii(this));
        ((TextView) findViewById(g.personal__redeem_info_view__title)).setText(getResources().getString(j.personal__personal_redeem_info_view__title, new Object[]{dkCloudRedeemFund.getTitle()}));
        TextView textView = (TextView) findViewById(g.personal__redeem_info_view__author);
        if (!TextUtils.isEmpty(dkCloudRedeemFund.getBookAuthor())) {
            textView.setText(getResources().getString(j.personal__personal_redeem_info_view__author, new Object[]{dkCloudRedeemFund.getBookAuthor()}));
        } else if (!TextUtils.isEmpty(dkCloudRedeemFund.getBookEditor())) {
            textView.setText(getResources().getString(j.personal__personal_redeem_info_view__editor, new Object[]{dkCloudRedeemFund.getBookEditor()}));
        }
        this.b = (TextView) findViewById(g.personal__redeem_info_view__msg);
        LayoutParams layoutParams2 = findViewById(g.personal__redeem_info_view__placeholder).getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams = new LayoutParams(-1, -2);
        } else {
            layoutParams = layoutParams2;
        }
        s sVar = (s) getContext().queryFeature(s.class);
        if (sVar != null) {
            layoutParams.height = sVar.getTheme().getPagePaddingBottom();
        } else {
            layoutParams.height = 0;
        }
        if (this.a.isUsed()) {
            findViewById(g.personal__redeem_info_view__unused).setVisibility(8);
            findViewById(g.personal__redeem_info_view__useded).setVisibility(0);
            findViewById(g.personal__redeem_info_view__arrow).setVisibility(0);
            if (TextUtils.isEmpty(this.a.getMessage())) {
                findViewById(g.personal__redeem_info_view__msg_root).setVisibility(8);
            } else {
                findViewById(g.personal__redeem_info_view__msg_root).setVisibility(0);
                ((deprecatedDkTextView) findViewById(g.personal__redeem_info_view__msg_content)).setText(this.a.getMessage());
                ((TextView) findViewById(g.personal__redeem_info_view__msg_from)).setText(getResources().getString(j.personal__personal_redeem_info_view__word_time, new Object[]{ReaderUi.a(getContext(), this.a.getWordUpdatedTime().getTime(), false)}));
            }
            ((DkBigFaceView) findViewById(g.personal__redeem_info_view__received_face)).setUser(this.a.getReceivedUser());
            textView = (TextView) findViewById(g.personal__redeem_info_view__received_name);
            String str = TextUtils.isEmpty(this.a.getReceivedUser().mNickName) ? this.a.getReceivedUser().mUserId : this.a.getReceivedUser().mNickName;
            textView.setText(getResources().getString(j.personal__personal_redeem_info_view__received_name, new Object[]{str}));
            ((TextView) findViewById(g.personal__redeem_info_view__received_time)).setText(ReaderUi.a(getContext(), this.a.getReceivedTime().getTime(), false));
            return;
        }
        findViewById(g.personal__redeem_info_view__unused).setVisibility(0);
        findViewById(g.personal__redeem_info_view__useded).setVisibility(8);
        findViewById(g.personal__redeem_info_view__arrow).setVisibility(8);
        if (!TextUtils.isEmpty(dkCloudRedeemFund.getMessage())) {
            this.b.setText(dkCloudRedeemFund.getMessage());
        }
        this.b.setOnClickListener(new ij(this));
        String format = String.format(getString(j.personal__personal_redeem_info_view__msg), new Object[]{this.a.getTitle(), this.a.getLinkUrl()});
        View findViewById = findViewById(g.personal__redeem_info_view__sms);
        boolean a = SysTools.isSupportTelephony(getContext());
        findViewById(g.personal__redeem_info_view__sms_icon).setEnabled(a);
        findViewById(g.personal__redeem_info_view__sms_text).setEnabled(a);
        findViewById.setEnabled(a);
        findViewById.setOnClickListener(new il(this, format));
        findViewById = findViewById(g.personal__redeem_info_view__wx);
        a = ThirdWeiXin.isSupportShareWeiXinFriends(getContext());
        findViewById(g.personal__redeem_info_view__wx_icon).setEnabled(a);
        findViewById(g.personal__redeem_info_view__wx_text).setEnabled(a);
        findViewById.setEnabled(a);
        findViewById.setOnClickListener(new im(this, format));
        findViewById(g.personal__redeem_info_view__more).setOnClickListener(new in(this, format));
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (!z) {
        }
    }

    private void a(String str, do doVar) {
        fp.a().a(this.a, str, new io(this, str, doVar));
    }
}
