package com.duokan.reader.ui.reading;

import android.content.Context;
import android.widget.EditText;
import com.duokan.core.app.AppContext;
import com.duokan.core.ui.BoxView;
import com.duokan.core.ui.AnimUtils;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ui.C0435s;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.general.PinView;
import com.duokan.reader.ui.general.af;
import com.duokan.reader.ui.general.ap;

/* renamed from: com.duokan.reader.ui.reading.k */
public class C1460k {
    /* renamed from: a */
    private Context f10483a;
    /* renamed from: b */
    private af f10484b;
    /* renamed from: c */
    private EditText f10485c;
    /* renamed from: d */
    private C1467r f10486d;

    public C1460k(Context context, String str, String str2, boolean z, C1467r c1467r) {
        this.f10484b = new C1461l(this, context, str2);
        this.f10484b.setContentView(C0256h.reading__add_note_view);
        ((BoxView) this.f10484b.getContentView()).setResizeLayoutForSoftInput(true);
        this.f10484b.findViewById(C0255g.reading__addnotedlg_view__btns).setPadding(AnimUtils.m1932b(context, 15.0f), (ReaderEnv.get().forHd() ? 0 : ((C0435s) AppContext.getAppContext(context).queryFeature(C0435s.class)).getTheme().getHeaderPaddingTop()) + AnimUtils.m1932b(context, 10.0f), AnimUtils.m1932b(context, 15.0f), AnimUtils.m1932b(context, 10.0f));
        ((PinView) this.f10484b.findViewById(C0255g.reading__addnotedlg_view__sample)).setText(str);
        this.f10485c = (EditText) this.f10484b.findViewById(C0255g.reading__addnotedlg_view__note);
        this.f10485c.setText(str2);
        this.f10485c.setSelection(str2.length());
        ((DkLabelView) this.f10484b.findViewById(C0255g.reading__addnotedlg_view__cancel)).setOnClickListener(new C1462m(this));
        this.f10483a = context;
        this.f10486d = c1467r;
        ((DkLabelView) this.f10484b.findViewById(C0255g.reading__addnotedlg_view__save)).setOnClickListener(new C1463n(this));
        this.f10485c.post(new C1464o(this));
    }

    /* renamed from: a */
    public void m14530a() {
        this.f10484b.open(new C1465p(this));
    }

    /* renamed from: b */
    public void m14531b() {
        ap c1466q = new C1466q(this, this.f10483a);
        c1466q.setTitle(C0258j.reading__add_note_view__alert_unsave_note);
        c1466q.setOkLabelResid(C0258j.reading__add_note_view__alert_yes);
        c1466q.setCancelLabel(C0258j.reading__add_note_view__alert_no);
        c1466q.show();
    }
}
