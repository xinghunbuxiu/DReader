package com.duokan.reader.domain.document;

import android.text.TextUtils;

public abstract class l {
    public String a = "";

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return TextUtils.equals(this.a, ((l) obj).a);
    }
}
