package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.duokan.core.ui.LinearScrollView;
import com.duokan.core.ui.dv;
import com.duokan.p024c.C0252d;
import com.duokan.p024c.C0253e;
import com.duokan.p024c.C0254f;
import com.duokan.reader.ui.general.DkLabelView;
import java.util.ArrayList;

public class gm extends LinearScrollView {
    /* renamed from: a */
    private String f6520a;
    /* renamed from: b */
    private gp f6521b;
    /* renamed from: c */
    private ArrayList<Pair<String, String>> f6522c = new ArrayList();

    public gm(Context context) {
        super(context);
        setThumbEnabled(false);
        setOrientation(0);
    }

    public void setPath(String str) {
        this.f6520a = str;
        m9741g();
        m9740f();
    }

    public void setPathGalleryListener(gp gpVar) {
        this.f6521b = gpVar;
    }

    /* renamed from: f */
    private void m9740f() {
        removeAllViews();
        int b = dv.m1932b(getContext(), 12.0f);
        int color = getResources().getColor(C0252d.general__shared__333333);
        for (int i = 0; i < this.f6522c.size(); i++) {
            Pair pair = (Pair) this.f6522c.get(i);
            View dkLabelView = new DkLabelView(getContext());
            dkLabelView.setText((CharSequence) pair.first);
            dkLabelView.setTag(pair.second);
            dkLabelView.setTextColor(color);
            dkLabelView.setGravity(17);
            dkLabelView.setTextSize(0, getResources().getDimension(C0253e.general_font__shared__b));
            dkLabelView.setPadding(b, b, 0, b);
            m9739a(dkLabelView);
            if (i != this.f6522c.size() - 1) {
                dkLabelView.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(C0254f.bookshelf__path_gallery_item_bg), null);
                dkLabelView.setCompoundDrawablePadding(b);
            }
            addView(dkLabelView, new LayoutParams(-2, -2));
        }
        dv.m1921a((View) this, new gn(this));
    }

    /* renamed from: g */
    private void m9741g() {
        if (!TextUtils.isEmpty(this.f6520a)) {
            this.f6522c.clear();
            int i = 0;
            while (true) {
                int indexOf = this.f6520a.indexOf("/", i);
                if (indexOf < 0) {
                    break;
                }
                if (i != indexOf) {
                    this.f6522c.add(new Pair(this.f6520a.substring(i, indexOf), this.f6520a.substring(0, indexOf)));
                } else {
                    this.f6522c.add(new Pair("/", "/"));
                }
                i = indexOf + 1;
            }
            if (i < this.f6520a.length()) {
                this.f6522c.add(new Pair(this.f6520a.substring(i), this.f6520a));
            }
        }
    }

    /* renamed from: a */
    private void m9739a(View view) {
        view.setOnClickListener(new go(this));
    }
}
