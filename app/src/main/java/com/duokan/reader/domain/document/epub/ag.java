package com.duokan.reader.domain.document.epub;

import java.util.Arrays;

public class ag extends ap {
    public byte[][] b = new byte[0][];

    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        return Arrays.deepEquals(this.b, ((ag) obj).b);
    }
}
