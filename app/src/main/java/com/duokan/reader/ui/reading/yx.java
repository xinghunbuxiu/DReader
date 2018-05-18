package com.duokan.reader.ui.reading;

import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import com.duokan.common.CommonUtils;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.ui.C0394t;
import com.duokan.p024c.C0254f;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.document.au;
import com.duokan.reader.ui.general.BubbleFloatingView;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.general.ir;
import org.apache.http.HttpStatus;

public class yx extends ActivatedController {
    /* renamed from: a */
    private final C0394t f11254a = new C0394t(getContext());
    /* renamed from: b */
    private final C0800c f11255b;
    /* renamed from: c */
    private final au f11256c;
    /* renamed from: d */
    private final za f11257d;

    public yx(IFeature mFeature, C0800c c0800c, au auVar, za zaVar) {
        super(mFeature);
        setContentView(new BubbleFloatingView(getContext(), null));
        m15223b();
        this.f11254a.setContentView(m15221a());
        this.f11255b = c0800c;
        this.f11256c = auVar;
        this.f11257d = zaVar;
    }

    /* renamed from: a */
    public void m15226a(Rect rect) {
        this.f11254a.show();
        m15221a().m9926a(new Rect[]{rect}, true, (int) HttpStatus.SC_MULTIPLE_CHOICES);
    }

    /* renamed from: a */
    private BubbleFloatingView m15221a() {
        return (BubbleFloatingView) getContentView();
    }

    /* renamed from: b */
    private void m15223b() {
        BubbleFloatingView a = m15221a();
        View irVar = new ir(getContext(), null);
        irVar.setScrollRightResource(C0254f.general__shared__arrow_right_13dip_ffffff);
        irVar.m10808a(CommonUtils.dip2px(getContext(), 10.0f), CommonUtils.dip2px(getContext(), 10.0f), CommonUtils.dip2px(getContext(), 10.0f), CommonUtils.dip2px(getContext(), 10.0f));
        irVar.setScrollLeftResource(C0254f.general__shared__arrow_left_13dip_ffffff);
        irVar.setBackgroundResource(C0254f.reading__annotation_operator_view__bg2);
        View inflate = LayoutInflater.from(getContext()).inflate(C0256h.reading__menu_button_view, null);
        DkLabelView dkLabelView = (DkLabelView) inflate.findViewById(C0255g.reading__menu_button_view__button);
        dkLabelView.setText(C0258j.reading__textinteract_view___share);
        dkLabelView.setOnClickListener(new yy(this));
        irVar.m10809a(inflate);
        a.m9925a(irVar, null);
        a.setBackgroundColor(0);
        a.m9924a(0, CommonUtils.dip2px(getContext(), 8.0f), 0, CommonUtils.dip2px(getContext(), 8.0f));
        a.setUpArrow(C0254f.reading__annotation_operator_view__up_arrow2);
        a.setDownArrow(C0254f.reading__annotation_operator_view__down_arrow2);
        a.setOnClickListener(new yz(this));
    }
}
