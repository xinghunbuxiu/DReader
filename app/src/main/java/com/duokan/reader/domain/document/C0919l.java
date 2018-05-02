package com.duokan.reader.domain.document;

import android.text.TextUtils;

/* renamed from: com.duokan.reader.domain.document.l */
public abstract class C0919l {
    /* renamed from: a */
    public String f4342a = "";

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
        return TextUtils.equals(this.f4342a, ((C0919l) obj).f4342a);
    }
}
