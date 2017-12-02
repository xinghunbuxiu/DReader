package com.duokan.reader.ui.reading;

import android.content.Context;
import android.widget.EditText;

import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.c.j;
import com.duokan.core.app.x;
import com.duokan.core.ui.BoxView;
import com.duokan.core.ui.dv;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.general.PinView;
import com.duokan.reader.ui.general.af;
import com.duokan.reader.ui.general.ap;
import com.duokan.reader.ui.s;

public class k {
    private Context a;
    private af b;
    private EditText c;
    private r d;

    public k(Context context, String str, String str2, boolean z, r rVar) {
        this.b = new l(this, context, str2);
        this.b.setContentView(h.reading__add_note_view);
        ((BoxView) this.b.getContentView()).setResizeLayoutForSoftInput(true);
        this.b.findViewById(g.reading__addnotedlg_view__btns).setPadding(dv.b(context, 15.0f), (ReaderEnv.get().forHd() ? 0 : ((s) x.a(context).queryFeature(s.class)).getTheme().getHeaderPaddingTop()) + dv.b(context, 10.0f), dv.b(context, 15.0f), dv.b(context, 10.0f));
        ((PinView) this.b.findViewById(g.reading__addnotedlg_view__sample)).setText(str);
        this.c = (EditText) this.b.findViewById(g.reading__addnotedlg_view__note);
        this.c.setText(str2);
        this.c.setSelection(str2.length());
        ((DkLabelView) this.b.findViewById(g.reading__addnotedlg_view__cancel)).setOnClickListener(new m(this));
        this.a = context;
        this.d = rVar;
        ((DkLabelView) this.b.findViewById(g.reading__addnotedlg_view__save)).setOnClickListener(new n(this));
        this.c.post(new o(this));
    }

    public void a() {
        this.b.open(new p(this));
    }

    public void b() {
        ap qVar = new q(this, this.a);
        qVar.setTitle(j.reading__add_note_view__alert_unsave_note);
        qVar.setOkLabel(j.reading__add_note_view__alert_yes);
        qVar.setCancelLabel(j.reading__add_note_view__alert_no);
        qVar.show();
    }
}
