package com.duokan.reader.ui.account;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.core.ui.aw;

class ax extends aw {
    final /* synthetic */ au a;

    private ax(au auVar) {
        this.a = auVar;
    }

    public /* synthetic */ Object d(int i) {
        return a(i);
    }

    public int c() {
        return this.a.a == null ? 0 : this.a.a.size();
    }

    public at a(int i) {
        return this.a.a == null ? null : (at) this.a.a.get(i);
    }

    public View d(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.a.getContext()).inflate(h.account__share_choice_item_view, viewGroup, false);
        }
        ImageView imageView = (ImageView) view.findViewById(g.account__share_choice_item_view__icon);
        TextView textView = (TextView) view.findViewById(g.account__share_choice_item_view__text);
        at a = a(i);
        imageView.setImageResource(a.c);
        textView.setText(a.a);
        return view;
    }
}
