package com.duokan.reader.ui.store.comment;

import android.text.Editable;
import android.text.TextWatcher;

import com.duokan.c.j;

class i implements TextWatcher {
    final /* synthetic */ int a;
    final /* synthetic */ f b;

    i(f fVar, int i) {
        this.b = fVar;
        this.a = i;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        if (this.a > 0) {
            String obj = this.b.b.getText().toString();
            try {
                Object bytes = obj.getBytes("UTF-32");
                int length = (bytes.length / 4) - 1;
                this.b.d.setText(String.format(this.b.getContext().getString(j.store_comment__publish_comment_view__content_word_count_left), new Object[]{Integer.valueOf(Math.max(this.a - length, 0))}));
                if (length > this.a) {
                    Object obj2 = new byte[((this.a * 4) + 4)];
                    System.arraycopy(bytes, 0, obj2, 0, obj2.length);
                    bytes = new String(obj2, "UTF-32");
                    this.b.b.setText(bytes);
                    this.b.b.setSelection(bytes.length());
                }
            } catch (Throwable th) {
                this.b.d.setText(String.format(this.b.getContext().getString(j.store_comment__publish_comment_view__content_word_count_left), new Object[]{Integer.valueOf(Math.max(this.a - obj.length(), 0))}));
                if (obj.length() > this.a) {
                    this.b.b.setText(obj.substring(0, this.a));
                    this.b.b.setSelection(this.a);
                }
            }
        }
    }
}
