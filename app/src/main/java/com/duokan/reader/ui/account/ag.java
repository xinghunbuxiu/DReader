package com.duokan.reader.ui.account;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.duokan.core.ui.GridItemsView;
import com.duokan.core.ui.dv;
import com.duokan.p024c.C0252d;
import com.duokan.p024c.C0254f;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.reader.ui.general.hb;
import java.util.List;

public class ag extends FrameLayout {
    /* renamed from: a */
    private List<af> f5783a;
    /* renamed from: b */
    private aj f5784b;
    /* renamed from: c */
    private final GridItemsView f5785c = ((GridItemsView) findViewById(C0255g.account__share_choice_view__grid));

    public ag(Context context, ae aeVar) {
        super(context);
        View inflate = LayoutInflater.from(getContext()).inflate(C0256h.account__share_choice_view, this, false);
        inflate.setBackgroundDrawable(new hb(new ColorDrawable(getContext().getResources().getColor(C0252d.general__shared__dialog)), (float) dv.m1932b(getContext(), 6.0f)));
        addView(inflate);
        ((TextView) findViewById(C0255g.account__share_choice_view__title)).getPaint().setFakeBoldText(true);
        this.f5785c.setDesiredColumnWidth(dv.m1932b(getContext(), 80.0f));
        this.f5784b = new aj();
        this.f5785c.setAdapter(this.f5784b);
        this.f5785c.setThumbEnabled(true);
        this.f5785c.setMaxOverScrollHeight(dv.m1962g(getContext()));
        this.f5785c.setOnItemClickListener(new ah(this, aeVar));
        TextView textView = (TextView) findViewById(C0255g.account__share_choice_view__cancel);
        textView.getPaint().setFakeBoldText(true);
        textView.setBackgroundDrawable(new hb(getContext().getResources().getDrawable(C0254f.general__shared__dialog_button_background), (float) dv.m1932b(getContext(), 8.0f), 12));
        textView.setOnClickListener(new ai(this, aeVar));
    }

    public void setSharePlatforms(List<af> list) {
        this.f5783a = list;
        this.f5784b.mo1691d();
    }
}
