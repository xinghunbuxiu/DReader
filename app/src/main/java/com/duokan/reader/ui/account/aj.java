package com.duokan.reader.ui.account;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.duokan.core.ui.aw;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;

class aj extends aw {
    /* renamed from: a */
    final /* synthetic */ ag f5790a;

    private aj(ag agVar) {
        this.f5790a = agVar;
    }

    /* renamed from: d */
    public /* synthetic */ Object mo509d(int i) {
        return m8864a(i);
    }

    /* renamed from: c */
    public int mo506c() {
        return this.f5790a.f5783a == null ? 0 : this.f5790a.f5783a.size();
    }

    /* renamed from: a */
    public af m8864a(int i) {
        return this.f5790a.f5783a == null ? null : (af) this.f5790a.f5783a.get(i);
    }

    /* renamed from: d */
    public View mo508d(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f5790a.getContext()).inflate(C0256h.account__share_choice_item_view, viewGroup, false);
        }
        ImageView imageView = (ImageView) view.findViewById(C0255g.account__share_choice_item_view__icon);
        TextView textView = (TextView) view.findViewById(C0255g.account__share_choice_item_view__text);
        af a = m8864a(i);
        imageView.setImageResource(a.f5781c);
        textView.setText(a.f5779a);
        imageView.setContentDescription(a.f5779a);
        return view;
    }
}
