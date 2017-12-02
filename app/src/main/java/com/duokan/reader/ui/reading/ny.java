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

import com.duokan.c.f;
import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.core.ui.aw;
import com.duokan.reader.domain.bookshelf.a;
import com.duokan.reader.domain.bookshelf.ef;
import com.duokan.reader.domain.bookshelf.eg;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.general.DkLabelView.ContentMode;
import com.duokan.reader.ui.general.DkTextView;
import com.duokan.reader.ui.general.ReaderUi;
import com.duokan.reader.ui.general.jm;

import java.util.List;

abstract class ny extends aw {
    protected List a;
    protected List c;
    final /* synthetic */ nk d;

    private ny(nk nkVar) {
        this.d = nkVar;
        this.a = null;
        this.c = null;
    }

    public void a(List list, List list2) {
        this.a = list;
        this.c = list2;
        d();
    }

    public int c() {
        return this.a == null ? 0 : this.a.size();
    }

    public Object d(int i) {
        return this.a == null ? null : (a) this.a.get(i);
    }

    public View d(int i, View view, ViewGroup viewGroup) {
        View view2;
        if (view != null && view.getId() == g.reading__comment_item_view__root && view.getTag() == null) {
            view2 = view;
        } else {
            view2 = LayoutInflater.from(this.d.getContext()).inflate(h.reading__comment_item_view, viewGroup, false);
        }
        a aVar = (a) d(i);
        TextView textView = (TextView) view2.findViewById(g.reading__comment_item_view__add_time);
        textView.setText(ReaderUi.a(this.d.getContext(), aVar.g()));
        textView.setTextColor(this.d.w);
        DkLabelView dkLabelView = (DkLabelView) view2.findViewById(g.reading__comment_item_view__page_num);
        if (this.d.b.L() > 0) {
            dkLabelView.setContentMode(ContentMode.NUM);
            dkLabelView.setTextColor(this.d.w);
            dkLabelView.setText(String.valueOf(this.d.b.b(aVar.d())));
        }
        DkTextView dkTextView = (DkTextView) view2.findViewById(g.reading__comment_item_view__sample);
        dkTextView.setText(aVar.f());
        dkTextView.setTextColor(this.d.u);
        dkTextView.setChsToChtChars(this.d.b.T());
        if (this.c.get(i) != null && ((i == 0 || this.c.get(i) != this.c.get(i - 1)) && !TextUtils.isEmpty(((com.duokan.reader.domain.document.g) this.c.get(i)).e()))) {
            View inflate = View.inflate(this.d.getContext(), h.reading__comment_splitter_view, null);
            dkTextView = (DkTextView) inflate.findViewById(g.reading__comment_splitter_view__chapter_name);
            dkTextView.setChsToChtChars(this.d.b.T());
            dkTextView.setText(((com.duokan.reader.domain.document.g) this.c.get(i)).e());
            dkTextView.setTextColor(this.d.t);
            View findViewById = inflate.findViewById(g.reading__comment_splitter_view__chapter_split);
            findViewById.setVisibility(i == 0 ? 8 : 0);
            findViewById.setBackgroundColor(this.d.v);
            ((ViewGroup) view2).addView(inflate, 0, new LayoutParams(-1, -2));
            view2.setTag(inflate);
        }
        ImageView imageView = (ImageView) view2.findViewById(g.reading__comment_item_view__color);
        View findViewById2 = view2.findViewById(g.reading__comment_item_view__note);
        DkTextView dkTextView2 = (DkTextView) view2.findViewById(g.reading__comment_item_view__note_mark);
        ImageView imageView2 = (ImageView) view2.findViewById(g.reading__comment_item_view__vert_divider);
        DkTextView dkTextView3 = (DkTextView) view2.findViewById(g.reading__comment_item_view__note_text);
        if (aVar instanceof ef) {
            ef efVar = (ef) aVar;
            imageView.setImageDrawable(new oa(this.d, eg.a().d(efVar.n())));
            if (TextUtils.isEmpty(efVar.m())) {
                findViewById2.setVisibility(8);
            } else {
                findViewById2.setVisibility(0);
                dkTextView2.setTextColor(this.d.w);
                imageView2.setImageDrawable(new jm(this.d.v));
                dkTextView3.setText(efVar.m());
                dkTextView3.setTextColor(this.d.w);
            }
        } else {
            imageView.setImageResource(f.reading__toc_item_view__mark_icon);
            imageView.setColorFilter(Color.argb((int) Math.round(25.5d), Color.red(this.d.u), Color.green(this.d.u), Color.blue(this.d.u)), Mode.SRC_IN);
            findViewById2.setVisibility(8);
        }
        return view2;
    }
}
