package com.duokan.reader.ui.reading;

import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.duokan.core.ui.aw;
import com.duokan.p024c.C0254f;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.reader.domain.bookshelf.C0798a;
import com.duokan.reader.domain.bookshelf.ea;
import com.duokan.reader.domain.bookshelf.eb;
import com.duokan.reader.domain.document.C0901g;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.general.DkLabelView.ContentMode;
import com.duokan.reader.ui.general.DkTextView;
import com.duokan.reader.ui.general.ReaderUi;
import com.duokan.reader.ui.general.iw;
import java.util.List;

abstract class oi extends aw {
    /* renamed from: a */
    protected List<? extends C0798a> f10737a;
    /* renamed from: c */
    protected List<C0901g> f10738c;
    /* renamed from: d */
    final /* synthetic */ nu f10739d;

    private oi(nu nuVar) {
        this.f10739d = nuVar;
        this.f10737a = null;
        this.f10738c = null;
    }

    /* renamed from: a */
    public void m14812a(List<? extends C0798a> list, List<C0901g> list2) {
        this.f10737a = list;
        this.f10738c = list2;
        mo1691d();
    }

    /* renamed from: c */
    public int mo506c() {
        return this.f10737a == null ? 0 : this.f10737a.size();
    }

    /* renamed from: d */
    public Object mo509d(int i) {
        return this.f10737a == null ? null : (C0798a) this.f10737a.get(i);
    }

    /* renamed from: d */
    public View mo508d(int i, View view, ViewGroup viewGroup) {
        View view2;
        if (view != null && view.getId() == C0255g.reading__comment_item_view__root && view.getTag() == null) {
            view2 = view;
        } else {
            view2 = LayoutInflater.from(this.f10739d.getContext()).inflate(C0256h.reading__comment_item_view, viewGroup, false);
        }
        C0798a c0798a = (C0798a) mo509d(i);
        TextView textView = (TextView) view2.findViewById(C0255g.reading__comment_item_view__add_time);
        textView.setText(ReaderUi.m10158a(this.f10739d.getContext(), c0798a.m3730g()));
        textView.setTextColor(this.f10739d.f10721w);
        DkLabelView dkLabelView = (DkLabelView) view2.findViewById(C0255g.reading__comment_item_view__page_num);
        if (this.f10739d.f10700b.mo1995L() > 0) {
            dkLabelView.setContentMode(ContentMode.NUM);
            dkLabelView.setTextColor(this.f10739d.f10721w);
            dkLabelView.setText(String.valueOf(this.f10739d.f10700b.mo2093b(c0798a.m3726d())));
        }
        DkTextView dkTextView = (DkTextView) view2.findViewById(C0255g.reading__comment_item_view__sample);
        dkTextView.setText(c0798a.m3729f());
        dkTextView.setTextColor(this.f10739d.f10719u);
        dkTextView.setChsToChtChars(this.f10739d.f10700b.mo2003T());
        if (this.f10738c.get(i) != null && ((i == 0 || this.f10738c.get(i) != this.f10738c.get(i - 1)) && !TextUtils.isEmpty(((C0901g) this.f10738c.get(i)).mo1202e()))) {
            View inflate = View.inflate(this.f10739d.getContext(), C0256h.reading__comment_splitter_view, null);
            dkTextView = (DkTextView) inflate.findViewById(C0255g.reading__comment_splitter_view__chapter_name);
            dkTextView.setChsToChtChars(this.f10739d.f10700b.mo2003T());
            dkTextView.setText(((C0901g) this.f10738c.get(i)).mo1202e());
            dkTextView.setTextColor(this.f10739d.f10718t);
            View findViewById = inflate.findViewById(C0255g.reading__comment_splitter_view__chapter_split);
            findViewById.setVisibility(i == 0 ? 8 : 0);
            findViewById.setBackgroundColor(this.f10739d.f10720v);
            ((ViewGroup) view2).addView(inflate, 0, new LayoutParams(-1, -2));
            view2.setTag(inflate);
        }
        ImageView imageView = (ImageView) view2.findViewById(C0255g.reading__comment_item_view__color);
        View findViewById2 = view2.findViewById(C0255g.reading__comment_item_view__note);
        DkTextView dkTextView2 = (DkTextView) view2.findViewById(C0255g.reading__comment_item_view__note_mark);
        ImageView imageView2 = (ImageView) view2.findViewById(C0255g.reading__comment_item_view__vert_divider);
        DkTextView dkTextView3 = (DkTextView) view2.findViewById(C0255g.reading__comment_item_view__note_text);
        if (c0798a instanceof ea) {
            ea eaVar = (ea) c0798a;
            imageView.setImageDrawable(new ok(this.f10739d, eb.m4386a().m4392d(eaVar.m4385n())));
            if (TextUtils.isEmpty(eaVar.m4384m())) {
                findViewById2.setVisibility(8);
            } else {
                findViewById2.setVisibility(0);
                dkTextView2.setTextColor(this.f10739d.f10721w);
                imageView2.setImageDrawable(new iw(this.f10739d.f10720v));
                dkTextView3.setText(eaVar.m4384m());
                dkTextView3.setTextColor(this.f10739d.f10721w);
            }
        } else {
            imageView.setImageResource(C0254f.reading__toc_item_view__mark_icon);
            imageView.setColorFilter(Color.argb((int) Math.round(25.5d), Color.red(this.f10739d.f10719u), Color.green(this.f10739d.f10719u), Color.blue(this.f10739d.f10719u)), Mode.SRC_IN);
            findViewById2.setVisibility(8);
        }
        return view2;
    }
}
