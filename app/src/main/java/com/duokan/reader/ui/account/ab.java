package com.duokan.reader.ui.account;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.duokan.p024c.C0251c;
import com.duokan.p024c.C0254f;
import com.duokan.reader.domain.account.oauth.ThirdWeiXin;
import com.duokan.reader.ui.general.ak;
import java.util.LinkedList;
import java.util.List;

public class ab extends ak {
    /* renamed from: a */
    private final ae f5774a;
    /* renamed from: b */
    private List<af> f5775b = new LinkedList();
    /* renamed from: c */
    private String f5776c;

    public ab(Context context, boolean z, ae aeVar) {
        super(context);
        this.f5774a = aeVar;
        String[] stringArray = getContext().getResources().getStringArray(C0251c.share_title_array);
        this.f5775b.add(new af(this, stringArray[0], "weibo", C0254f.general__shared__sina_icon));
        if (ThirdWeiXin.isWeiXinInstalled(getContext())) {
            this.f5775b.add(new af(this, stringArray[2], "weixin_friend", C0254f.general__shared__weichat_icon));
            if (ThirdWeiXin.isSupportShareWeiXinFriends(getContext())) {
                this.f5775b.add(new af(this, stringArray[3], "weixin_timeline", C0254f.general__shared__penyouquan_icon));
            }
        }
        if (z) {
            this.f5775b.add(new af(this, stringArray[4], "system", C0254f.general__shared__other_icon));
        }
        View agVar = new ag(getContext(), new ac(this));
        setOnDismissListener(new ad(this));
        agVar.setSharePlatforms(this.f5775b);
        ViewGroup viewGroup = (ViewGroup) getContentView();
        viewGroup.removeAllViews();
        viewGroup.addView(agVar);
    }
}
