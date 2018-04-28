package com.duokan.reader.ui.general;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0245g;
import com.duokan.p023b.C0247i;
import com.duokan.reader.ReaderEnv;

public class eu extends ActivatedController implements dl {
    /* renamed from: a */
    private final HeaderView f5766a = ((HeaderView) findViewById(C0244f.general__multiline_input_view__header));
    /* renamed from: b */
    private final DkLabelView f5767b;
    /* renamed from: c */
    private final View f5768c;
    /* renamed from: d */
    private final TextView f5769d;
    /* renamed from: e */
    private final EditText f5770e;
    /* renamed from: f */
    private final DkNumView f5771f;
    /* renamed from: g */
    private final fa f5772g;

    public eu(IFeature mFeature) {
        super(mFeature);
        setContentView(C0245g.general__multiline_input_view);
        this.f5766a.setHasBackButton(true);
        this.f5766a.setOnBackListener(new ev(this));
        this.f5767b = (DkLabelView) findViewById(C0244f.general__multiline_input_view__description);
        this.f5770e = (EditText) findViewById(C0244f.general__multiline_input_view__editor);
        this.f5771f = (DkNumView) findViewById(C0244f.general__multiline_input_view__remained_length);
        View findViewById = findViewById(C0244f.general__multiline_input_view__save);
        if (ReaderEnv.get().forHd()) {
            findViewById.setVisibility(0);
            this.f5768c = findViewById;
            this.f5769d = (DkLabelView) findViewById(C0244f.general__multiline_input_view__save_text);
        } else {
            findViewById.setVisibility(8);
            this.f5769d = this.f5766a.m10148b(getContext().getString(C0247i.general__shared__confirm));
            this.f5768c = this.f5769d;
        }
        this.f5772g = new fa(getContext(), new ew(this));
    }

    /* renamed from: a */
    public void m8849a(int i) {
        this.f5766a.setLeftTitle(i);
    }

    /* renamed from: b */
    public void m8852b(int i) {
        this.f5772g.m10632b(i);
    }

    /* renamed from: a */
    public void m8851a(String str) {
        this.f5772g.m10635c(str);
    }

    /* renamed from: a */
    public void m8850a(dn dnVar) {
        this.f5772g.m10629a(dnVar);
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            this.f5772g.m10626a();
            this.f5770e.postDelayed(new ex(this), 400);
        }
    }

    protected void onDeactive() {
        ReaderUi.m10161a(getContext(), this.f5770e);
        super.onDeactive();
    }

    protected boolean onBack() {
        this.f5770e.clearFocus();
        return super.onBack();
    }
}
