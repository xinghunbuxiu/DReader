package com.duokan.kernel.filterlib;

import com.duokan.kernel.DkNative;

public class DkfLib extends DkNative {
    public static native byte[] base64Decode(byte[] bArr);

    public static native byte[] base64Encode(byte[] bArr);

    public static native byte[] md5Encode(byte[] bArr);
}
