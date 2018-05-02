package com.duokan.reader.ui.store.comment;

import android.text.Editable;
import android.text.TextWatcher;
import com.duokan.p024c.C0258j;

/* renamed from: com.duokan.reader.ui.store.comment.m */
class C1489m implements TextWatcher {
    /* renamed from: a */
    final /* synthetic */ int f11432a;
    /* renamed from: b */
    final /* synthetic */ C1486j f11433b;

    C1489m(C1486j c1486j, int i) {
        this.f11433b = c1486j;
        this.f11432a = i;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        if (this.f11432a > 0) {
            String obj = this.f11433b.f11421b.getText().toString();
            try {
                Object bytes = obj.getBytes("UTF-32");
                int length = (bytes.length / 4) - 1;
                this.f11433b.f11423d.setText(String.format(this.f11433b.getContext().getString(C0258j.store_comment__publish_comment_view__content_word_count_left), new Object[]{Integer.valueOf(Math.max(this.f11432a - length, 0))}));
                if (length > this.f11432a) {
                    Object obj2 = new byte[((this.f11432a * 4) + 4)];
                    System.arraycopy(bytes, 0, obj2, 0, obj2.length);
                    bytes = new String(obj2, "UTF-32");
                    this.f11433b.f11421b.setText(bytes);
                    this.f11433b.f11421b.setSelection(bytes.length());
                }
            } catch (Throwable th) {
                this.f11433b.f11423d.setText(String.format(this.f11433b.getContext().getString(C0258j.store_comment__publish_comment_view__content_word_count_left), new Object[]{Integer.valueOf(Math.max(this.f11432a - obj.length(), 0))}));
                if (obj.length() > this.f11432a) {
                    this.f11433b.f11421b.setText(obj.substring(0, this.f11432a));
                    this.f11433b.f11421b.setSelection(this.f11432a);
                }
            }
        }
    }
}
