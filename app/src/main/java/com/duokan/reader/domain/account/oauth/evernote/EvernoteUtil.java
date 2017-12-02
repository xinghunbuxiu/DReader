package com.duokan.reader.domain.account.oauth.evernote;

import com.evernote.edam.type.Resource;

import java.io.InputStream;
import java.security.MessageDigest;

public class EvernoteUtil {
    private static final String EDAM_HASH_ALGORITHM = "MD5";
    public static final String NOTE_PREFIX = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><!DOCTYPE en-note SYSTEM \"http://xml.evernote.com/pub/enml2.dtd\"><en-note>";
    public static final String NOTE_SUFFIX = "</en-note>";

    final class EvernoteUtilException extends RuntimeException {
        public EvernoteUtilException(String str, Throwable th) {
            super(str, th);
        }
    }

    public static String createEnMediaTag(Resource resource) {
        return "<en-media hash=\"" + bytesToHex(resource.getData().getBodyHash()) + "\" type=\"" + resource.getMime() + "\"/>";
    }

    public static byte[] hash(byte[] bArr) {
        try {
            return MessageDigest.getInstance(EDAM_HASH_ALGORITHM).digest(bArr);
        } catch (Throwable e) {
            throw new EvernoteUtilException("MD5 not supported", e);
        }
    }

    public static byte[] hash(InputStream inputStream) {
        try {
            MessageDigest instance = MessageDigest.getInstance(EDAM_HASH_ALGORITHM);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return instance.digest();
                }
                instance.update(bArr, 0, read);
            }
        } catch (Throwable e) {
            throw new EvernoteUtilException("MD5 not supported", e);
        }
    }

    public static String bytesToHex(byte[] bArr) {
        return bytesToHex(bArr, false);
    }

    public static String bytesToHex(byte[] bArr, boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bArr) {
            int i = b & 255;
            if (i < 16) {
                stringBuilder.append('0');
            }
            stringBuilder.append(Integer.toHexString(i));
            if (z) {
                stringBuilder.append(' ');
            }
        }
        return stringBuilder.toString();
    }

    public static byte[] hexToBytes(String str) {
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) Integer.parseInt(str.substring(i2, i2 + 2), 16);
        }
        return bArr;
    }
}
