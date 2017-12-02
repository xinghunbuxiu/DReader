package com.duokan.reader.ui.reading;

import android.text.TextUtils;

import com.duokan.c.j;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.document.a;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.g;
import com.duokan.reader.domain.document.h;
import com.duokan.reader.ui.general.ap;

class qk implements Runnable {
    static final /* synthetic */ boolean a = (!qh.class.desiredAssertionStatus());
    final /* synthetic */ c b;
    final /* synthetic */ qj c;

    qk(qj qjVar, c cVar) {
        this.c = qjVar;
        this.b = cVar;
    }

    public void run() {
        if (!this.c.a.q) {
            ak Z = this.c.a.c.Z();
            ak c = this.c.a.h.c(this.b.D().a);
            if (this.c.a.h.d((a) Z) && this.c.a.h.d((a) c)) {
                Z.e();
                c.e();
                if (!Z.equals(c)) {
                    ap apVar = new ap(this.c.a.getContext());
                    apVar.setTitle(j.reading__shared__sync_down_reading_progress_title);
                    apVar.setCancelLabel(j.general__shared__cancel);
                    apVar.setOkLabel(j.reading__shared__sync_down_reading_progress_ok);
                    apVar.setCancelOnTouchOutside(false);
                    String str = "";
                    if (this.c.a.M != null && this.c.a.c.b(2)) {
                        if (((long) this.c.a.M.d()) != ((long) this.c.a.h.m().a(c.g()))) {
                            apVar.setPrompt(String.format(this.c.a.getString(j.reading__shared__sync_down_reading_progress_prompt1), new Object[]{Integer.valueOf(((int) r4) + 1)}));
                        } else {
                            return;
                        }
                    } else if (this.c.a.h.e() < 0) {
                        h h = this.c.a.h.h();
                        if (h != null) {
                            g b = h.b((a) c);
                            if (!a && b == null) {
                                throw new AssertionError();
                            } else if (b != null) {
                                str = b.e();
                                str = String.format(this.c.a.getString(j.reading__shared__sync_down_reading_progress_prompt2), new Object[]{str});
                            }
                        }
                        if (TextUtils.isEmpty(str)) {
                            str = String.format(this.c.a.getString(j.reading__shared__sync_down_reading_progress_prompt3), new Object[]{Float.valueOf(this.c.a.a(c))});
                        }
                        apVar.setPrompt(str);
                    } else {
                        if (this.c.a.h.b(Z) != this.c.a.h.b(this.c.a.h.e(c))) {
                            apVar.setPrompt(String.format(this.c.a.getString(j.reading__shared__sync_down_reading_progress_prompt1), new Object[]{Integer.valueOf(((int) r4) + 1)}));
                        } else {
                            return;
                        }
                    }
                    apVar.open(new ql(this, c));
                }
            }
        }
    }
}
