package com.duokan.reader.common.cache;

public abstract class h {
    public abstract boolean equals(Object obj);

    public abstract int hashCode();

    protected h() {
    }

    public boolean isSuitable(Object obj) {
        return equals(obj);
    }
}
