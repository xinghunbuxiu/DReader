package com.duokan.reader.ui.reading;

import android.text.TextUtils;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.document.C0896a;
import com.duokan.reader.domain.document.C0901g;
import com.duokan.reader.domain.document.C0911h;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.ui.general.ap;

class qu implements Runnable {
    /* renamed from: a */
    static final /* synthetic */ boolean f10874a = (!qr.class.desiredAssertionStatus());
    /* renamed from: b */
    final /* synthetic */ C0800c f10875b;
    /* renamed from: c */
    final /* synthetic */ qt f10876c;

    qu(qt qtVar, C0800c c0800c) {
        this.f10876c = qtVar;
        this.f10875b = c0800c;
    }

    public void run() {
        if (!this.f10876c.f10873a.f9293q) {
            ak Z = this.f10876c.f10873a.f9279c.mo2009Z();
            ak c = this.f10876c.f10873a.f9284h.mo1230c(this.f10875b.m4152E().f3445a);
            if (this.f10876c.f10873a.f9284h.mo1233d((C0896a) Z) && this.f10876c.f10873a.f9284h.mo1233d((C0896a) c)) {
                Z.mo1192e();
                c.mo1192e();
                if (!Z.equals(c)) {
                    ap apVar = new ap(this.f10876c.f10873a.getContext());
                    apVar.setTitle(C0258j.reading__shared__sync_down_reading_progress_title);
                    apVar.setCancelLabel(C0258j.general__shared__cancel);
                    apVar.setOkLabelResid(C0258j.reading__shared__sync_down_reading_progress_ok);
                    apVar.setCancelOnTouchOutside(false);
                    String str = "";
                    if (this.f10876c.f10873a.f9273M != null && this.f10876c.f10873a.f9279c.mo2106b(2)) {
                        if (((long) this.f10876c.f10873a.f9273M.mo2293d()) != ((long) this.f10876c.f10873a.f9284h.mo1247m().mo1253a(c.mo1198g()))) {
                            apVar.setPrompt(String.format(this.f10876c.f10873a.getString(C0258j.reading__shared__sync_down_reading_progress_prompt1), new Object[]{Integer.valueOf(((int) r4) + 1)}));
                        } else {
                            return;
                        }
                    } else if (this.f10876c.f10873a.f9284h.mo1234e() < 0) {
                        C0911h h = this.f10876c.f10873a.f9284h.mo1240h();
                        if (h != null) {
                            C0901g b = h.mo1267b((C0896a) c);
                            if (!f10874a && b == null) {
                                throw new AssertionError();
                            } else if (b != null) {
                                str = b.mo1202e();
                                str = String.format(this.f10876c.f10873a.getString(C0258j.reading__shared__sync_down_reading_progress_prompt2), new Object[]{str});
                            }
                        }
                        if (TextUtils.isEmpty(str)) {
                            str = String.format(this.f10876c.f10873a.getString(C0258j.reading__shared__sync_down_reading_progress_prompt3), new Object[]{Float.valueOf(this.f10876c.f10873a.mo2233a(c))});
                        }
                        apVar.setPrompt(str);
                    } else {
                        if (this.f10876c.f10873a.f9284h.mo1223b(Z) != this.f10876c.f10873a.f9284h.mo1223b(this.f10876c.f10873a.f9284h.mo1235e(c))) {
                            apVar.setPrompt(String.format(this.f10876c.f10873a.getString(C0258j.reading__shared__sync_down_reading_progress_prompt1), new Object[]{Integer.valueOf(((int) r4) + 1)}));
                        } else {
                            return;
                        }
                    }
                    apVar.open(new qv(this, c));
                }
            }
        }
    }
}
