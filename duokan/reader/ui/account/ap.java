package com.duokan.reader.ui.account;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.duokan.c.f;
import com.duokan.reader.domain.account.oauth.ThirdWeiXin;
import com.duokan.reader.ui.general.ak;

import java.util.LinkedList;
import java.util.List;

public class ap extends ak {
    private final as a;
    private List b = new LinkedList();
    private String c;

    public ap(Context context, boolean z, as asVar) {
        super(context);
        this.a = asVar;
        String[] stringArray = getContext().getResources().getStringArray(c.share_title_array);
        this.b.add(new at(this, stringArray[0], "sina", f.general__shared__sina_icon));
        if (ThirdWeiXin.isWeiXinInstalled(getContext())) {
            this.b.add(new at(this, stringArray[2], "wenxin_friend", f.general__shared__weichat_icon));
            if (ThirdWeiXin.isSupportShareWeiXinFriends(getContext())) {
                this.b.add(new at(this, stringArray[3], "wenxin_friends", f.general__shared__penyouquan_icon));
            }
        }
        if (z) {
            this.b.add(new at(this, stringArray[4], "system", f.general__shared__other_icon));
        }
        View auVar = new au(getContext(), new aq(this));
        setOnDismissListener(new ar(this));
        auVar.setSharePlatforms(this.b);
        ViewGroup viewGroup = (ViewGroup) getContentView();
        viewGroup.removeAllViews();
        viewGroup.addView(auVar);
    }
}
