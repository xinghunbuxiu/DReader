package com.duokan.reader.ui.store.comment;

import android.text.Editable;
import android.text.TextWatcher;
import com.duokan.p024c.C0258j;

/* renamed from: com.duokan.reader.ui.store.comment.i */
class C1485i implements TextWatcher {
    /* renamed from: a */
    final /* synthetic */ int f11418a;
    /* renamed from: b */
    final /* synthetic */ C1482f f11419b;

    C1485i(C1482f c1482f, int i) {
        this.f11419b = c1482f;
        this.f11418a = i;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        if (this.f11418a > 0) {
            String obj = this.f11419b.f11405b.getText().toString();
            try {
                Object bytes = obj.getBytes("UTF-32");
                int length = (bytes.length / 4) - 1;
                this.f11419b.f11407d.setText(String.format(this.f11419b.getContext().getString(C0258j.store_comment__publish_comment_view__content_word_count_left), new Object[]{Integer.valueOf(Math.max(this.f11418a - length, 0))}));
                if (length > this.f11418a) {
                    Object obj2 = new byte[((this.f11418a * 4) + 4)];
                    System.arraycopy(bytes, 0, obj2, 0, obj2.length);
                    bytes = new String(obj2, "UTF-32");
                    this.f11419b.f11405b.setText(bytes);
                    this.f11419b.f11405b.setSelection(bytes.length());
                }
            } catch (Throwable th) {
                this.f11419b.f11407d.setText(String.format(this.f11419b.getContext().getString(C0258j.store_comment__publish_comment_view__content_word_count_left), new Object[]{Integer.valueOf(Math.max(this.f11418a - obj.length(), 0))}));
                if (obj.length() > this.f11418a) {
                    this.f11419b.f11405b.setText(obj.substring(0, this.f11418a));
                    this.f11419b.f11405b.setSelection(this.f11418a);
                }
            }
        }
    }
}
