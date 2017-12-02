package com.duokan.reader.ui.reading;

import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;

import com.duokan.c.f;
import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.c.j;
import com.duokan.common.i;
import com.duokan.core.app.e;
import com.duokan.core.app.y;
import com.duokan.core.ui.t;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.document.au;
import com.duokan.reader.ui.general.BubbleFloatingView;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.general.jh;

import org.apache.http.HttpStatus;

public class yk extends e {
    private final t a = new t(getContext());
    private final c b;
    private final au c;
    private final yn d;

    public yk(y yVar, c cVar, au auVar, yn ynVar) {
        super(yVar);
        setContentView(new BubbleFloatingView(getContext(), null));
        b();
        this.a.setContentView(a());
        this.b = cVar;
        this.c = auVar;
        this.d = ynVar;
    }

    public void a(Rect rect) {
        this.a.show();
        a().a(new Rect[]{rect}, true, (int) HttpStatus.SC_MULTIPLE_CHOICES);
    }

    private BubbleFloatingView a() {
        return (BubbleFloatingView) getContentView();
    }

    private void b() {
        BubbleFloatingView a = a();
        View jhVar = new jh(getContext(), null);
        jhVar.setScrollRightResource(f.general__shared__arrow_right_13dip_ffffff);
        jhVar.a(i.a(getContext(), 10.0f), i.a(getContext(), 10.0f), i.a(getContext(), 10.0f), i.a(getContext(), 10.0f));
        jhVar.setScrollLeftResource(f.general__shared__arrow_left_13dip_ffffff);
        jhVar.setBackgroundResource(f.reading__annotation_operator_view__bg2);
        View inflate = LayoutInflater.from(getContext()).inflate(h.reading__menu_button_view, null);
        DkLabelView dkLabelView = (DkLabelView) inflate.findViewById(g.reading__menu_button_view__button);
        dkLabelView.setText(j.reading__textinteract_view___share);
        dkLabelView.setOnClickListener(new yl(this));
        jhVar.a(inflate);
        a.a(jhVar, null);
        a.setBackgroundColor(0);
        a.a(0, i.a(getContext(), 8.0f), 0, i.a(getContext(), 8.0f));
        a.setUpArrow(f.reading__annotation_operator_view__up_arrow2);
        a.setDownArrow(f.reading__annotation_operator_view__down_arrow2);
        a.setOnClickListener(new ym(this));
    }
}
