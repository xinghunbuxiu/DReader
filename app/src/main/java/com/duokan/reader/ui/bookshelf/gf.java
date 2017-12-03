package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;

import com.duokan.c.d;
import com.duokan.c.e;
import com.duokan.c.f;
import com.duokan.core.ui.LinearScrollView;
import com.duokan.core.ui.UTools;
import com.duokan.reader.ui.general.DkLabelView;

import java.util.ArrayList;

public class gf extends LinearScrollView {
    private String a;
    private gi b;
    private ArrayList c = new ArrayList();

    public gf(Context context) {
        super(context);
        setThumbEnabled(false);
        setOrientation(0);
    }

    public void setPath(String str) {
        this.a = str;
        g();
        f();
    }

    public void setPathGalleryListener(gi giVar) {
        this.b = giVar;
    }

    private void f() {
        removeAllViews();
        int b = UTools.closeAnimation(getContext(), 12.0f);
        int color = getResources().getColor(d.general__shared__333333);
        for (int i = 0; i < this.c.size(); i++) {
            Pair pair = (Pair) this.c.get(i);
            View dkLabelView = new DkLabelView(getContext());
            dkLabelView.setText((CharSequence) pair.first);
            dkLabelView.setTag(pair.second);
            dkLabelView.setTextColor(color);
            dkLabelView.setGravity(17);
            dkLabelView.setTextSize(0, getResources().getDimension(e.general_font__shared__b));
            dkLabelView.setPadding(b, b, 0, b);
            a(dkLabelView);
            if (i != this.c.size() - 1) {
                dkLabelView.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(f.bookshelf__path_gallery_item_bg), null);
                dkLabelView.setCompoundDrawablePadding(b);
            }
            addView(dkLabelView, new LayoutParams(-2, -2));
        }
        UTools.addAnimation((View) this, new gg(this));
    }

    private void g() {
        if (!TextUtils.isEmpty(this.a)) {
            this.c.clear();
            int i = 0;
            while (true) {
                int indexOf = this.a.indexOf("/", i);
                if (indexOf < 0) {
                    break;
                }
                if (i != indexOf) {
                    this.c.add(new Pair(this.a.substring(i, indexOf), this.a.substring(0, indexOf)));
                } else {
                    this.c.add(new Pair("/", "/"));
                }
                i = indexOf + 1;
            }
            if (i < this.a.length()) {
                this.c.add(new Pair(this.a.substring(i), this.a));
            }
        }
    }

    private void a(View view) {
        view.setOnClickListener(new gh(this));
    }
}
