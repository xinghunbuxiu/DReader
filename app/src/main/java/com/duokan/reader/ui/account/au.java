package com.duokan.reader.ui.account;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.duokan.c.d;
import com.duokan.c.f;
import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.core.ui.GridItemsView;
import com.duokan.core.ui.UTools;
import com.duokan.reader.ui.general.hm;

import java.util.List;

public class au extends FrameLayout {
    private List a;
    private ax b;
    private final GridItemsView c = ((GridItemsView) findViewById(g.account__share_choice_view__grid));

    public au(Context context, as asVar) {
        super(context);
        View inflate = LayoutInflater.from(getContext()).inflate(h.account__share_choice_view, this, false);
        inflate.setBackgroundDrawable(new hm(new ColorDrawable(getContext().getResources().getColor(d.general__shared__dialog)), (float) UTools.closeAnimation(getContext(), 6.0f)));
        addView(inflate);
        ((TextView) findViewById(g.account__share_choice_view__title)).getPaint().setFakeBoldText(true);
        this.c.setDesiredColumnWidth(UTools.closeAnimation(getContext(), 80.0f));
        this.b = new ax();
        this.c.setAdapter(this.b);
        this.c.setThumbEnabled(true);
        this.c.setMaxOverScrollHeight(UTools.g(getContext()));
        this.c.setOnItemClickListener(new av(this, asVar));
        TextView textView = (TextView) findViewById(g.account__share_choice_view__cancel);
        textView.getPaint().setFakeBoldText(true);
        textView.setBackgroundDrawable(new hm(getContext().getResources().getDrawable(f.general__shared__dialog_button_background), (float) UTools.closeAnimation(getContext(), 8.0f), 12));
        textView.setOnClickListener(new aw(this, asVar));
    }

    public void setSharePlatforms(List list) {
        this.a = list;
        this.b.d();
    }
}
