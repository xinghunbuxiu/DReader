package com.duokan.reader.ui.reading;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.duokan.b.d;
import com.duokan.b.f;
import com.duokan.b.g;
import com.duokan.b.i;
import com.duokan.core.ui.be;
import com.duokan.kernel.DkUtils;
import com.duokan.reader.domain.document.z;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.general.bo;

class yi extends bo {
    final /* synthetic */ yb a;

    private yi(yb ybVar) {
        this.a = ybVar;
    }

    public int c() {
        return this.a.i.size();
    }

    public Object d(int i) {
        return this.a.i.get(i);
    }

    public View d(int i, View view, ViewGroup viewGroup) {
        String chs2chtText;
        if (view == null) {
            view = LayoutInflater.from(this.a.getContext()).inflate(g.reading__search_result_item_view, viewGroup, false);
        }
        TextView textView = (TextView) view.findViewById(f.reading__search_result_item__snippet);
        z zVar = (z) this.a.i.get(i);
        String str = zVar.b;
        str = str.substring(0, zVar.c) + "<font color=\"#ed6c00\">" + str.substring(zVar.c, zVar.d) + "</font>" + str.substring(zVar.d);
        if (((sh) this.a.getContext().queryFeature(sh.class)).T()) {
            chs2chtText = DkUtils.chs2chtText(str);
        } else {
            chs2chtText = str;
        }
        textView.setText(Html.fromHtml(chs2chtText));
        textView.setTextColor(this.a.f);
        return view;
    }

    protected void b() {
    }

    protected void e(int i) {
        this.a.b();
        if (!this.a.l) {
            a(this.a.k);
        }
    }

    public View a(View view, ViewGroup viewGroup) {
        if (this.a.j == null) {
            return null;
        }
        View dkLabelView = new DkLabelView(this.a.getContext());
        dkLabelView.setText(this.a.getString(i.reading__search_text_view__nosearch_result));
        dkLabelView.setTextColor(this.a.f);
        dkLabelView.setGravity(17);
        dkLabelView.setTextSize(0, this.a.getResources().getDimension(d.general_font__shared__b));
        dkLabelView.setLayoutParams(new be(-2, -2));
        return dkLabelView;
    }
}
