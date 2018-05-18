package com.duokan.reader.p031a.p032a.p033a;

import com.umeng.analytics.pro.C2295j;
import java.lang.reflect.Array;
import java.util.Arrays;
import org.apache.http.HttpStatus;


public class C0509a extends C0508c {
    
    short[][] f1716a;
    
    short[][] f1717b;
    
    short[][] f1718c;
    
    short[][] f1719d;
    
    short[][] f1720e;
    
    short[][] f1721f;
    
    public boolean f1722g = false;

    
    public int m2188a(byte[] bArr) {
        int i = 0;
        int[] iArr = new int[21];
        Arrays.fill(iArr, 0);
        short[][] sArr = (short[][]) Array.newInstance(Short.TYPE, new int[]{126, 191});
        this.f1716a = (short[][]) Array.newInstance(Short.TYPE, new int[]{94, 94});
        m2189a();
        m2190a(this.f1716a);
        iArr[0] = 0;
        this.f1717b = sArr;
        m2192b();
        m2196c(this.f1717b);
        iArr[1] = m2191b(bArr);
        iArr[2] = m2194c(bArr);
        iArr[3] = m2197d(bArr);
        this.f1718c = sArr;
        m2195c();
        m2190a(sArr);
        iArr[4] = m2199e(bArr);
        this.f1719d = sArr;
        m2200e();
        m2193b(sArr);
        iArr[5] = m2201f(bArr);
        this.f1719d = sArr;
        m2200e();
        m2193b(sArr);
        iArr[9] = m2202g(bArr);
        iArr[6] = m2203h(bArr);
        this.f1720e = sArr;
        m2198d();
        m2190a(sArr);
        iArr[12] = m2205j(bArr);
        iArr[13] = m2206k(bArr);
        iArr[15] = 0;
        iArr[14] = m2207l(bArr);
        iArr[19] = m2204i(bArr);
        this.f1721f = sArr;
        m2190a(sArr);
        iArr[16] = m2210o(bArr);
        this.f1721f = sArr;
        m2190a(sArr);
        iArr[17] = m2208m(bArr);
        iArr[18] = m2209n(bArr);
        iArr[11] = 0;
        iArr[10] = 0;
        iArr[20] = 0;
        int i2 = 20;
        for (int i3 = 0; i3 < 21; i3++) {
            if (iArr[i3] > i) {
                i = iArr[i3];
                i2 = i3;
            }
        }
        if (i <= 50) {
            return 20;
        }
        return i2;
    }

    
    int m2191b(byte[] bArr) {
        int i = 1;
        int i2 = 1;
        long j = 0;
        long j2 = 1;
        int length = bArr.length;
        int i3 = 0;
        while (i3 < length - 1) {
            int i4;
            if (bArr[i3] >= (byte) 0) {
                i4 = i3;
            } else {
                long j3;
                int i5;
                int i6 = i + 1;
                if ((byte) -95 <= bArr[i3] && bArr[i3] <= (byte) -9 && (byte) -95 <= bArr[i3 + 1] && bArr[i3 + 1] <= (byte) -2) {
                    i4 = i2 + 1;
                    j2 += 500;
                    i2 = (bArr[i3] + C2295j.f14325e) - 161;
                    i = (bArr[i3 + 1] + C2295j.f14325e) - 161;
                    if (this.f1716a[i2][i] != (short) 0) {
                        j3 = ((long) this.f1716a[i2][i]) + j;
                        i5 = i4;
                    } else if (15 > i2 || i2 >= 55) {
                        j3 = j;
                        i5 = i4;
                    } else {
                        j3 = 200 + j;
                        i5 = i4;
                    }
                } else if ((byte) -127 > bArr[i3] || bArr[i3] > (byte) -2 || ((Byte.MIN_VALUE > bArr[i3 + 1] || bArr[i3 + 1] > (byte) -2) && ((byte) 64 > bArr[i3 + 1] || bArr[i3 + 1] > (byte) 126))) {
                    r11 = j;
                    i5 = i2;
                    j3 = r11;
                } else {
                    int i7;
                    i4 = i2 + 1;
                    j3 = 500 + j2;
                    int i8 = (bArr[i3] + C2295j.f14325e) - 129;
                    if ((byte) 64 > bArr[i3 + 1] || bArr[i3 + 1] > (byte) 126) {
                        i7 = (bArr[i3 + 1] + C2295j.f14325e) - 64;
                    } else {
                        i7 = bArr[i3 + 1] - 64;
                    }
                    if (this.f1717b[i8][i7] != (short) 0) {
                        j2 = ((long) this.f1717b[i8][i7]) + j;
                        i5 = i4;
                        r11 = j2;
                        j2 = j3;
                        j3 = r11;
                    } else {
                        j2 = j3;
                        j3 = j;
                        i5 = i4;
                    }
                }
                i4 = i3 + 1;
                int i9 = i5;
                j = j3;
                i = i6;
                i2 = i9;
            }
            i3 = i4 + 1;
        }
        return ((int) (((((float) j) / ((float) j2)) * 50.0f) + ((((float) i2) / ((float) i)) * 50.0f))) - 1;
    }

    
    int m2194c(byte[] bArr) {
        int i = 1;
        int i2 = 1;
        long j = 0;
        long j2 = 1;
        int length = bArr.length;
        int i3 = 0;
        while (i3 < length - 1) {
            int i4;
            if (bArr[i3] >= (byte) 0) {
                i4 = i3;
            } else {
                long j3;
                int i5;
                int i6 = i + 1;
                if ((byte) -95 <= bArr[i3] && bArr[i3] <= (byte) -9 && i3 + 1 < length && (byte) -95 <= bArr[i3 + 1] && bArr[i3 + 1] <= (byte) -2) {
                    i4 = i2 + 1;
                    j2 += 500;
                    i2 = (bArr[i3] + C2295j.f14325e) - 161;
                    i = (bArr[i3 + 1] + C2295j.f14325e) - 161;
                    if (this.f1716a[i2][i] != (short) 0) {
                        j3 = ((long) this.f1716a[i2][i]) + j;
                        i5 = i4;
                    } else if (15 > i2 || i2 >= 55) {
                        j3 = j;
                        i5 = i4;
                    } else {
                        j3 = 200 + j;
                        i5 = i4;
                    }
                } else if ((byte) -127 <= bArr[i3] && bArr[i3] <= (byte) -2 && i3 + 1 < length && ((Byte.MIN_VALUE <= bArr[i3 + 1] && bArr[i3 + 1] <= (byte) -2) || ((byte) 64 <= bArr[i3 + 1] && bArr[i3 + 1] <= (byte) 126))) {
                    int i7;
                    i4 = i2 + 1;
                    j3 = 500 + j2;
                    int i8 = (bArr[i3] + C2295j.f14325e) - 129;
                    if ((byte) 64 > bArr[i3 + 1] || bArr[i3 + 1] > (byte) 126) {
                        i7 = (bArr[i3 + 1] + C2295j.f14325e) - 64;
                    } else {
                        i7 = bArr[i3 + 1] - 64;
                    }
                    if (this.f1717b[i8][i7] != (short) 0) {
                        j2 = ((long) this.f1717b[i8][i7]) + j;
                        i5 = i4;
                        r11 = j2;
                        j2 = j3;
                        j3 = r11;
                    } else {
                        j2 = j3;
                        j3 = j;
                        i5 = i4;
                    }
                } else if ((byte) -127 > bArr[i3] || bArr[i3] > (byte) -2 || i3 + 3 >= length || (byte) 48 > bArr[i3 + 1] || bArr[i3 + 1] > (byte) 57 || (byte) -127 > bArr[i3 + 2] || bArr[i3 + 2] > (byte) -2 || (byte) 48 > bArr[i3 + 3] || bArr[i3 + 3] > (byte) 57) {
                    r11 = j;
                    i5 = i2;
                    j3 = r11;
                } else {
                    r11 = j;
                    i5 = i2 + 1;
                    j3 = r11;
                }
                i4 = i3 + 1;
                int i9 = i5;
                j = j3;
                i = i6;
                i2 = i9;
            }
            i3 = i4 + 1;
        }
        return ((int) (((((float) j) / ((float) j2)) * 50.0f) + ((((float) i2) / ((float) i)) * 50.0f))) - 1;
    }

    
    int m2197d(byte[] bArr) {
        float f;
        int i = 0;
        int i2 = 1;
        long j = 0;
        long j2 = 1;
        int i3 = 0;
        int i4 = 0;
        int length = bArr.length;
        int i5 = length - 1;
        int i6 = 0;
        while (i6 < i5) {
            int i7;
            int i8;
            long j3;
            int i9;
            if (bArr[i6] == (byte) 126) {
                long j4;
                if (bArr[i6 + 1] == (byte) 123) {
                    int i10;
                    i7 = i3 + 1;
                    j4 = j2;
                    j2 = j;
                    i8 = i6 + 2;
                    long j5 = j4;
                    int i11 = i;
                    i = i2;
                    i2 = i11;
                    while (i8 < length - 1 && bArr[i8] != (byte) 10) {
                        if (bArr[i8] != (byte) 13) {
                            if (bArr[i8] == (byte) 126 && bArr[i8 + 1] == (byte) 125) {
                                i8++;
                                i10 = i7;
                                i7 = i;
                                i = i2;
                                j3 = j2;
                                j2 = j5;
                                i3 = i10;
                                i9 = i4 + 1;
                                break;
                            }
                            int i12;
                            if ((byte) 33 <= bArr[i8] && bArr[i8] <= (byte) 119 && (byte) 33 <= bArr[i8 + 1] && bArr[i8 + 1] <= (byte) 119) {
                                i2 += 2;
                                i12 = bArr[i8] - 33;
                                i6 = bArr[i8 + 1] - 33;
                                j5 += 500;
                                if (this.f1716a[i12][i6] != (short) 0) {
                                    j2 += (long) this.f1716a[i12][i6];
                                } else if (15 <= i12 && i12 < 55) {
                                    j2 += 200;
                                }
                            } else if ((byte) -95 <= bArr[i8] && bArr[i8] <= (byte) -9 && (byte) -95 <= bArr[i8 + 1] && bArr[i8 + 1] <= (byte) -9) {
                                i2 += 2;
                                i12 = (bArr[i8] + C2295j.f14325e) - 161;
                                i6 = (bArr[i8 + 1] + C2295j.f14325e) - 161;
                                j5 += 500;
                                if (this.f1716a[i12][i6] != (short) 0) {
                                    j2 += (long) this.f1716a[i12][i6];
                                } else if (15 <= i12 && i12 < 55) {
                                    j2 += 200;
                                }
                            }
                            i += 2;
                            i8 += 2;
                        } else {
                            i10 = i7;
                            i7 = i;
                            i = i2;
                            j3 = j2;
                            j2 = j5;
                            i3 = i10;
                            i9 = i4;
                            break;
                        }
                    }
                    i10 = i7;
                    i7 = i;
                    i = i2;
                    j3 = j2;
                    j2 = j5;
                    i3 = i10;
                    i9 = i4;
                } else if (bArr[i6 + 1] == (byte) 125) {
                    i9 = i4 + 1;
                    i7 = i2;
                    j4 = j;
                    i8 = i6 + 1;
                    j3 = j4;
                } else if (bArr[i6 + 1] == (byte) 126) {
                    i7 = i2;
                    j4 = j;
                    i8 = i6 + 1;
                    i9 = i4;
                    j3 = j4;
                }
                i6 = i8 + 1;
                j = j3;
                i4 = i9;
                i2 = i7;
            }
            i9 = i4;
            i7 = i2;
            j3 = j;
            i8 = i6;
            i6 = i8 + 1;
            j = j3;
            i4 = i9;
            i2 = i7;
        }
        if (i3 > 4) {
            f = 50.0f;
        } else if (i3 > 1) {
            f = 41.0f;
        } else if (i3 > 0) {
            f = 39.0f;
        } else {
            f = 0.0f;
        }
        return (int) (f + (50.0f * (((float) j) / ((float) j2))));
    }

    
    int m2199e(byte[] bArr) {
        int i = 1;
        int i2 = 1;
        long j = 0;
        long j2 = 1;
        int length = bArr.length;
        int i3 = 0;
        while (i3 < length - 1) {
            int i4;
            if (bArr[i3] >= (byte) 0) {
                i4 = i3;
            } else {
                int i5;
                long j3;
                int i6 = i + 1;
                long j4;
                if ((byte) -95 > bArr[i3] || bArr[i3] > (byte) -7 || (((byte) 64 > bArr[i3 + 1] || bArr[i3 + 1] > (byte) 126) && ((byte) -95 > bArr[i3 + 1] || bArr[i3 + 1] > (byte) -2))) {
                    j4 = j;
                    i5 = i2;
                    j3 = j4;
                } else {
                    int i7;
                    i4 = i2 + 1;
                    j3 = 500 + j2;
                    int i8 = (bArr[i3] + C2295j.f14325e) - 161;
                    if ((byte) 64 > bArr[i3 + 1] || bArr[i3 + 1] > (byte) 126) {
                        i7 = (bArr[i3 + 1] + C2295j.f14325e) - 97;
                    } else {
                        i7 = bArr[i3 + 1] - 64;
                    }
                    if (this.f1718c[i8][i7] != (short) 0) {
                        j2 = ((long) this.f1718c[i8][i7]) + j;
                        i5 = i4;
                        j4 = j2;
                        j2 = j3;
                        j3 = j4;
                    } else if (3 > i8 || i8 > 37) {
                        j2 = j3;
                        j3 = j;
                        i5 = i4;
                    } else {
                        j2 = 200 + j;
                        i5 = i4;
                        j4 = j2;
                        j2 = j3;
                        j3 = j4;
                    }
                }
                i4 = i3 + 1;
                int i9 = i5;
                j = j3;
                i = i6;
                i2 = i9;
            }
            i3 = i4 + 1;
        }
        return (int) (((((float) j) / ((float) j2)) * 50.0f) + ((((float) i2) / ((float) i)) * 50.0f));
    }

    
    int m2201f(byte[] bArr) {
        int i = 1;
        int i2 = 1;
        long j = 0;
        long j2 = 1;
        int length = bArr.length;
        int i3 = 0;
        while (i3 < length - 1) {
            long j3;
            if (bArr[i3] >= (byte) 0) {
                j3 = j2;
                j2 = j;
                j = j3;
            } else {
                i++;
                if (i3 + 3 < length && (byte) -114 == bArr[i3] && (byte) -95 <= bArr[i3 + 1] && bArr[i3 + 1] <= (byte) -80 && (byte) -95 <= bArr[i3 + 2] && bArr[i3 + 2] <= (byte) -2 && (byte) -95 <= bArr[i3 + 3] && bArr[i3 + 3] <= (byte) -2) {
                    i2++;
                    i3 += 3;
                    j3 = j2;
                    j2 = j;
                    j = j3;
                } else if ((byte) -95 > bArr[i3] || bArr[i3] > (byte) -2 || (byte) -95 > bArr[i3 + 1] || bArr[i3 + 1] > (byte) -2) {
                    j3 = j2;
                    j2 = j;
                    j = j3;
                } else {
                    i2++;
                    j2 += 500;
                    int i4 = (bArr[i3] + C2295j.f14325e) - 161;
                    int i5 = (bArr[i3 + 1] + C2295j.f14325e) - 161;
                    if (this.f1719d[i4][i5] != (short) 0) {
                        j += (long) this.f1719d[i4][i5];
                    } else if (35 <= i4 && i4 <= 92) {
                        j += 150;
                    }
                    i3++;
                    j3 = j2;
                    j2 = j;
                    j = j3;
                }
            }
            i3++;
            j3 = j;
            j = j2;
            j2 = j3;
        }
        return (int) (((((float) j) / ((float) j2)) * 50.0f) + ((((float) i2) / ((float) i)) * 50.0f));
    }

    
    int m2202g(byte[] bArr) {
        int i = 1;
        int i2 = 1;
        long j = 0;
        long j2 = 1;
        int length = bArr.length;
        int i3 = 0;
        while (i3 < length - 1) {
            if (bArr[i3] == (byte) 27 && i3 + 3 < length) {
                int i4;
                int i5;
                if (bArr[i3 + 1] == (byte) 36 && bArr[i3 + 2] == (byte) 41 && bArr[i3 + 3] == (byte) 65) {
                    i3 += 4;
                    while (bArr[i3] != (byte) 27) {
                        i++;
                        if ((byte) 33 <= bArr[i3] && bArr[i3] <= (byte) 119 && (byte) 33 <= bArr[i3 + 1] && bArr[i3 + 1] <= (byte) 119) {
                            i2++;
                            i4 = bArr[i3] - 33;
                            i5 = bArr[i3 + 1] - 33;
                            j2 += 500;
                            if (this.f1716a[i4][i5] != (short) 0) {
                                j += (long) this.f1716a[i4][i5];
                            } else if (15 <= i4 && i4 < 55) {
                                j += 200;
                            }
                            i3++;
                        }
                        i3++;
                    }
                } else if (i3 + 3 < length && bArr[i3 + 1] == (byte) 36 && bArr[i3 + 2] == (byte) 41 && bArr[i3 + 3] == (byte) 71) {
                    i3 += 4;
                    while (bArr[i3] != (byte) 27) {
                        i++;
                        if ((byte) 33 <= bArr[i3] && bArr[i3] <= (byte) 126 && (byte) 33 <= bArr[i3 + 1] && bArr[i3 + 1] <= (byte) 126) {
                            i2++;
                            j2 += 500;
                            i4 = bArr[i3] - 33;
                            i5 = bArr[i3 + 1] - 33;
                            if (this.f1719d[i4][i5] != (short) 0) {
                                j += (long) this.f1719d[i4][i5];
                            } else if (35 <= i4 && i4 <= 92) {
                                j += 150;
                            }
                            i3++;
                        }
                        i3++;
                    }
                }
                if (bArr[i3] == (byte) 27 && i3 + 2 < length && bArr[i3 + 1] == (byte) 40 && bArr[i3 + 2] == (byte) 66) {
                    i3 += 2;
                }
            }
            i3++;
        }
        return (int) (((((float) j) / ((float) j2)) * 50.0f) + ((((float) i2) / ((float) i)) * 50.0f));
    }

    
    int m2203h(byte[] bArr) {
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i3 < length) {
            if ((bArr[i3] & 127) == bArr[i3]) {
                i++;
            } else if ((byte) -64 <= bArr[i3] && bArr[i3] <= (byte) -33 && i3 + 1 < length && Byte.MIN_VALUE <= bArr[i3 + 1] && bArr[i3 + 1] <= (byte) -65) {
                i2 += 2;
                i3++;
            } else if ((byte) -32 <= bArr[i3] && bArr[i3] <= (byte) -17 && i3 + 2 < length && Byte.MIN_VALUE <= bArr[i3 + 1] && bArr[i3 + 1] <= (byte) -65 && Byte.MIN_VALUE <= bArr[i3 + 2] && bArr[i3 + 2] <= (byte) -65) {
                i2 += 3;
                i3 += 2;
            }
            i3++;
        }
        if (i == length) {
            return 0;
        }
        i = (int) ((((float) i2) / ((float) (length - i))) * 100.0f);
        if (i > 98) {
            return i;
        }
        if (i <= 95 || i2 <= 30) {
            return 0;
        }
        return i;
    }

    
    int m2204i(byte[] bArr) {
        int i = 75;
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (bArr[i2] < (byte) 0) {
                i -= 5;
            } else if (bArr[i2] == (byte) 27) {
                i -= 5;
            }
            if (i <= 0) {
                return 0;
            }
        }
        return i;
    }

    
    int m2205j(byte[] bArr) {
        int i = 1;
        int i2 = 1;
        long j = 0;
        long j2 = 1;
        int length = bArr.length;
        int i3 = 0;
        while (i3 < length - 1) {
            if (bArr[i3] < (byte) 0) {
                i++;
                if ((byte) -95 <= bArr[i3] && bArr[i3] <= (byte) -2 && (byte) -95 <= bArr[i3 + 1] && bArr[i3 + 1] <= (byte) -2) {
                    i2++;
                    j2 += 500;
                    int i4 = (bArr[i3] + C2295j.f14325e) - 161;
                    int i5 = (bArr[i3 + 1] + C2295j.f14325e) - 161;
                    if (this.f1720e[i4][i5] != (short) 0) {
                        j += (long) this.f1720e[i4][i5];
                    } else if (15 <= i4 && i4 < 55) {
                        j += 0;
                    }
                }
                i3++;
            }
            i3++;
        }
        return (int) (((((float) j) / ((float) j2)) * 50.0f) + ((((float) i2) / ((float) i)) * 50.0f));
    }

    
    int m2206k(byte[] bArr) {
        int i = 1;
        int i2 = 1;
        long j = 0;
        long j2 = 1;
        int length = bArr.length;
        int i3 = 0;
        while (i3 < length - 1) {
            if (bArr[i3] < (byte) 0) {
                i++;
                if ((byte) -127 <= bArr[i3] && bArr[i3] <= (byte) -2 && (((byte) 65 <= bArr[i3 + 1] && bArr[i3 + 1] <= (byte) 90) || (((byte) 97 <= bArr[i3 + 1] && bArr[i3 + 1] <= (byte) 122) || ((byte) -127 <= bArr[i3 + 1] && bArr[i3 + 1] <= (byte) -2)))) {
                    i2++;
                    j2 += 500;
                    if ((byte) -95 <= bArr[i3] && bArr[i3] <= (byte) -2 && (byte) -95 <= bArr[i3 + 1] && bArr[i3 + 1] <= (byte) -2) {
                        int i4 = (bArr[i3] + C2295j.f14325e) - 161;
                        int i5 = (bArr[i3 + 1] + C2295j.f14325e) - 161;
                        if (this.f1720e[i4][i5] != (short) 0) {
                            j += (long) this.f1720e[i4][i5];
                        }
                    }
                }
                i3++;
            }
            i3++;
        }
        return (int) (((((float) j) / ((float) j2)) * 50.0f) + ((((float) i2) / ((float) i)) * 50.0f));
    }

    
    int m2207l(byte[] bArr) {
        int i = 0;
        while (i < bArr.length) {
            if (i + 3 < bArr.length && bArr[i] == (byte) 27 && ((char) bArr[i + 1]) == '$' && ((char) bArr[i + 2]) == ')' && ((char) bArr[i + 3]) == 'C') {
                return 100;
            }
            i++;
        }
        return 0;
    }

    
    int m2208m(byte[] bArr) {
        int i = 1;
        int i2 = 1;
        long j = 0;
        long j2 = 1;
        int length = bArr.length;
        int i3 = 0;
        while (i3 < length - 1) {
            if (bArr[i3] < (byte) 0) {
                i++;
                if ((byte) -95 <= bArr[i3] && bArr[i3] <= (byte) -2 && (byte) -95 <= bArr[i3 + 1] && bArr[i3 + 1] <= (byte) -2) {
                    i2++;
                    j2 += 500;
                    int i4 = (bArr[i3] + C2295j.f14325e) - 161;
                    int i5 = (bArr[i3 + 1] + C2295j.f14325e) - 161;
                    if (this.f1721f[i4][i5] != (short) 0) {
                        j += (long) this.f1721f[i4][i5];
                    } else if (15 <= i4 && i4 < 55) {
                        j += 0;
                    }
                }
                i3++;
            }
            i3++;
        }
        return (int) (((((float) j) / ((float) j2)) * 50.0f) + ((((float) i2) / ((float) i)) * 50.0f));
    }

    
    int m2209n(byte[] bArr) {
        int i = 0;
        while (i < bArr.length) {
            if (i + 2 < bArr.length && bArr[i] == (byte) 27 && ((char) bArr[i + 1]) == '$' && ((char) bArr[i + 2]) == 'B') {
                return 100;
            }
            i++;
        }
        return 0;
    }

    
    int m2210o(byte[] bArr) {
        int i = 1;
        int i2 = 1;
        long j = 0;
        long j2 = 1;
        int length = bArr.length;
        int i3 = 0;
        while (i3 < length - 1) {
            int i4;
            if (bArr[i3] >= (byte) 0) {
                i4 = i3;
            } else {
                int i5 = i + 1;
                if (i3 + 1 < bArr.length && ((((byte) -127 <= bArr[i3] && bArr[i3] <= (byte) -97) || ((byte) -32 <= bArr[i3] && bArr[i3] <= (byte) -17)) && (((byte) 64 <= bArr[i3 + 1] && bArr[i3 + 1] <= (byte) 126) || (Byte.MIN_VALUE <= bArr[i3 + 1] && bArr[i3 + 1] <= (byte) -4)))) {
                    int i6;
                    i4 = i2 + 1;
                    long j3 = 500 + j2;
                    int i7 = bArr[i3] + C2295j.f14325e;
                    int i8 = bArr[i3 + 1] + C2295j.f14325e;
                    if (i8 < 159) {
                        i6 = 1;
                        if (i8 > 127) {
                            i8 -= 32;
                        } else {
                            i8 -= 25;
                        }
                    } else {
                        i6 = 0;
                        i8 -= 126;
                    }
                    if (i7 < C2295j.f14322b) {
                        i6 = ((i7 - 112) << 1) - i6;
                    } else {
                        i6 = ((i7 - 176) << 1) - i6;
                    }
                    i6 -= 32;
                    if (i6 >= this.f1721f.length || 32 >= this.f1721f[i6].length || this.f1721f[i6][32] == (short) 0) {
                        j2 = j;
                    } else {
                        j2 = ((long) this.f1721f[i6][32]) + j;
                    }
                    long j4 = j3;
                    i2 = i4;
                    i = i5;
                    i4 = i3 + 1;
                    j = j2;
                    j2 = j4;
                } else if ((byte) -95 > bArr[i3] || bArr[i3] <= (byte) -33) {
                    i = i5;
                    i4 = i3;
                } else {
                    i = i5;
                    i4 = i3;
                }
            }
            i3 = i4 + 1;
        }
        return ((int) (((((float) j) / ((float) j2)) * 50.0f) + ((((float) i2) / ((float) i)) * 50.0f))) - 1;
    }

    
    void m2189a() {
        for (int i = 0; i < 94; i++) {
            Arrays.fill(this.f1716a[i], (short) 0);
        }
    }

    
    void m2192b() {
        for (int i = 0; i < 126; i++) {
            Arrays.fill(this.f1717b[i], (short) 0);
        }
    }

    
    void m2195c() {
        for (int i = 0; i < 94; i++) {
            Arrays.fill(this.f1718c[i], (short) 0);
        }
    }

    
    void m2198d() {
        for (int i = 0; i < 94; i++) {
            Arrays.fill(this.f1720e[i], (short) 0);
        }
    }

    
    void m2200e() {
        for (int i = 0; i < 94; i++) {
            Arrays.fill(this.f1719d[i], (short) 0);
        }
    }

    
    void m2190a(short[][] sArr) {
        sArr[20][35] = (short) 599;
        sArr[49][26] = (short) 598;
        sArr[41][38] = (short) 597;
        sArr[17][26] = (short) 596;
        sArr[32][42] = (short) 595;
        sArr[39][42] = (short) 594;
        sArr[45][49] = (short) 593;
        sArr[51][57] = (short) 592;
        sArr[50][47] = (short) 591;
        sArr[42][90] = (short) 590;
        sArr[52][65] = (short) 589;
        sArr[53][47] = (short) 588;
        sArr[19][82] = (short) 587;
        sArr[31][19] = (short) 586;
        sArr[40][46] = (short) 585;
        sArr[24][89] = (short) 584;
        sArr[23][85] = (short) 583;
        sArr[20][28] = (short) 582;
        sArr[42][20] = (short) 581;
        sArr[34][38] = (short) 580;
        sArr[45][9] = (short) 579;
        sArr[54][50] = (short) 578;
        sArr[25][44] = (short) 577;
        sArr[35][66] = (short) 576;
        sArr[20][55] = (short) 575;
        sArr[18][85] = (short) 574;
        sArr[20][31] = (short) 573;
        sArr[49][17] = (short) 572;
        sArr[41][16] = (short) 571;
        sArr[35][73] = (short) 570;
        sArr[20][34] = (short) 569;
        sArr[29][44] = (short) 568;
        sArr[35][38] = (short) 567;
        sArr[49][9] = (short) 566;
        sArr[46][33] = (short) 565;
        sArr[49][51] = (short) 564;
        sArr[40][89] = (short) 563;
        sArr[26][64] = (short) 562;
        sArr[54][51] = (short) 561;
        sArr[54][36] = (short) 560;
        sArr[39][4] = (short) 559;
        sArr[53][13] = (short) 558;
        sArr[24][92] = (short) 557;
        sArr[27][49] = (short) 556;
        sArr[48][6] = (short) 555;
        sArr[21][51] = (short) 554;
        sArr[30][40] = (short) 553;
        sArr[42][92] = (short) 552;
        sArr[31][78] = (short) 551;
        sArr[25][82] = (short) 550;
        sArr[47][0] = (short) 549;
        sArr[34][19] = (short) 548;
        sArr[47][35] = (short) 547;
        sArr[21][63] = (short) 546;
        sArr[43][75] = (short) 545;
        sArr[21][87] = (short) 544;
        sArr[35][59] = (short) 543;
        sArr[25][34] = (short) 542;
        sArr[21][27] = (short) 541;
        sArr[39][26] = (short) 540;
        sArr[34][26] = (short) 539;
        sArr[39][52] = (short) 538;
        sArr[50][57] = (short) 537;
        sArr[37][79] = (short) 536;
        sArr[26][24] = (short) 535;
        sArr[22][1] = (short) 534;
        sArr[18][40] = (short) 533;
        sArr[41][33] = (short) 532;
        sArr[53][26] = (short) 531;
        sArr[54][86] = (short) 530;
        sArr[20][16] = (short) 529;
        sArr[46][74] = (short) 528;
        sArr[30][19] = (short) 527;
        sArr[45][35] = (short) 526;
        sArr[45][61] = (short) 525;
        sArr[30][9] = (short) 524;
        sArr[41][53] = (short) 523;
        sArr[41][13] = (short) 522;
        sArr[50][34] = (short) 521;
        sArr[53][86] = (short) 520;
        sArr[47][47] = (short) 519;
        sArr[22][28] = (short) 518;
        sArr[50][53] = (short) 517;
        sArr[39][70] = (short) 516;
        sArr[38][15] = (short) 515;
        sArr[42][88] = (short) 514;
        sArr[16][29] = (short) 513;
        sArr[27][90] = (short) 512;
        sArr[29][12] = (short) 511;
        sArr[44][22] = (short) 510;
        sArr[34][69] = (short) 509;
        sArr[24][10] = (short) 508;
        sArr[44][11] = (short) 507;
        sArr[39][92] = (short) 506;
        sArr[49][48] = (short) 505;
        sArr[31][46] = (short) 504;
        sArr[19][50] = (short) 503;
        sArr[21][14] = (short) 502;
        sArr[32][28] = (short) 501;
        sArr[18][3] = (short) 500;
        sArr[53][9] = (short) 499;
        sArr[34][80] = (short) 498;
        sArr[48][88] = (short) 497;
        sArr[46][53] = (short) 496;
        sArr[22][53] = (short) 495;
        sArr[28][10] = (short) 494;
        sArr[44][65] = (short) 493;
        sArr[20][10] = (short) 492;
        sArr[40][76] = (short) 491;
        sArr[47][8] = (short) 490;
        sArr[50][74] = (short) 489;
        sArr[23][62] = (short) 488;
        sArr[49][65] = (short) 487;
        sArr[28][87] = (short) 486;
        sArr[15][48] = (short) 485;
        sArr[22][7] = (short) 484;
        sArr[19][42] = (short) 483;
        sArr[41][20] = (short) 482;
        sArr[26][55] = (short) 481;
        sArr[21][93] = (short) 480;
        sArr[31][76] = (short) 479;
        sArr[34][31] = (short) 478;
        sArr[20][66] = (short) 477;
        sArr[51][33] = (short) 476;
        sArr[34][86] = (short) 475;
        sArr[37][67] = (short) 474;
        sArr[53][53] = (short) 473;
        sArr[40][88] = (short) 472;
        sArr[39][10] = (short) 471;
        sArr[24][3] = (short) 470;
        sArr[27][25] = (short) 469;
        sArr[26][15] = (short) 468;
        sArr[21][88] = (short) 467;
        sArr[52][62] = (short) 466;
        sArr[46][81] = (short) 465;
        sArr[38][72] = (short) 464;
        sArr[17][30] = (short) 463;
        sArr[52][92] = (short) 462;
        sArr[34][90] = (short) 461;
        sArr[21][7] = (short) 460;
        sArr[36][13] = (short) 459;
        sArr[45][41] = (short) 458;
        sArr[32][5] = (short) 457;
        sArr[26][89] = (short) 456;
        sArr[23][87] = (short) 455;
        sArr[20][39] = (short) 454;
        sArr[27][23] = (short) 453;
        sArr[25][59] = (short) 452;
        sArr[49][20] = (short) 451;
        sArr[54][77] = (short) 450;
        sArr[27][67] = (short) 449;
        sArr[47][33] = (short) 448;
        sArr[41][17] = (short) 447;
        sArr[19][81] = (short) 446;
        sArr[16][66] = (short) 445;
        sArr[45][26] = (short) 444;
        sArr[49][81] = (short) 443;
        sArr[53][55] = (short) 442;
        sArr[16][26] = (short) 441;
        sArr[54][62] = (short) 440;
        sArr[20][70] = (short) 439;
        sArr[42][35] = (short) 438;
        sArr[20][57] = (short) 437;
        sArr[34][36] = (short) 436;
        sArr[46][63] = (short) 435;
        sArr[19][45] = (short) 434;
        sArr[21][10] = (short) 433;
        sArr[52][93] = (short) 432;
        sArr[25][2] = (short) 431;
        sArr[30][57] = (short) 430;
        sArr[41][24] = (short) 429;
        sArr[28][43] = (short) 428;
        sArr[45][86] = (short) 427;
        sArr[51][56] = (short) 426;
        sArr[37][28] = (short) 425;
        sArr[52][69] = (short) 424;
        sArr[43][92] = (short) 423;
        sArr[41][31] = (short) 422;
        sArr[37][87] = (short) 421;
        sArr[47][36] = (short) 420;
        sArr[16][16] = (short) 419;
        sArr[40][56] = (short) 418;
        sArr[24][55] = (short) 417;
        sArr[17][1] = (short) 416;
        sArr[35][57] = (short) 415;
        sArr[27][50] = (short) 414;
        sArr[26][14] = (short) 413;
        sArr[50][40] = (short) 412;
        sArr[39][19] = (short) 411;
        sArr[19][89] = (short) 410;
        sArr[29][91] = (short) 409;
        sArr[17][89] = (short) 408;
        sArr[39][74] = (short) 407;
        sArr[46][39] = (short) 406;
        sArr[40][28] = (short) 405;
        sArr[45][68] = (short) 404;
        sArr[43][10] = (short) 403;
        sArr[42][13] = (short) 402;
        sArr[44][81] = (short) 401;
        sArr[41][47] = (short) 400;
        sArr[48][58] = (short) 399;
        sArr[43][68] = (short) 398;
        sArr[16][79] = (short) 397;
        sArr[19][5] = (short) 396;
        sArr[54][59] = (short) 395;
        sArr[17][36] = (short) 394;
        sArr[18][0] = (short) 393;
        sArr[41][5] = (short) 392;
        sArr[41][72] = (short) 391;
        sArr[16][39] = (short) 390;
        sArr[54][0] = (short) 389;
        sArr[51][16] = (short) 388;
        sArr[29][36] = (short) 387;
        sArr[47][5] = (short) 386;
        sArr[47][51] = (short) 385;
        sArr[44][7] = (short) 384;
        sArr[35][30] = (short) 383;
        sArr[26][9] = (short) 382;
        sArr[16][7] = (short) 381;
        sArr[32][1] = (short) 380;
        sArr[33][76] = (short) 379;
        sArr[34][91] = (short) 378;
        sArr[52][36] = (short) 377;
        sArr[26][77] = (short) 376;
        sArr[35][48] = (short) 375;
        sArr[40][80] = (short) 374;
        sArr[41][92] = (short) 373;
        sArr[27][93] = (short) 372;
        sArr[15][17] = (short) 371;
        sArr[16][76] = (short) 370;
        sArr[51][12] = (short) 369;
        sArr[18][20] = (short) 368;
        sArr[15][54] = (short) 367;
        sArr[50][5] = (short) 366;
        sArr[33][22] = (short) 365;
        sArr[37][57] = (short) 364;
        sArr[28][47] = (short) 363;
        sArr[42][31] = (short) 362;
        sArr[18][2] = (short) 361;
        sArr[43][64] = (short) 360;
        sArr[23][47] = (short) 359;
        sArr[28][79] = (short) 358;
        sArr[25][45] = (short) 357;
        sArr[23][91] = (short) 356;
        sArr[22][19] = (short) 355;
        sArr[25][46] = (short) 354;
        sArr[22][36] = (short) 353;
        sArr[54][85] = (short) 352;
        sArr[46][20] = (short) 351;
        sArr[27][37] = (short) 350;
        sArr[26][81] = (short) 349;
        sArr[42][29] = (short) 348;
        sArr[31][90] = (short) 347;
        sArr[41][59] = (short) 346;
        sArr[24][65] = (short) 345;
        sArr[44][84] = (short) 344;
        sArr[24][90] = (short) 343;
        sArr[38][54] = (short) 342;
        sArr[28][70] = (short) 341;
        sArr[27][15] = (short) 340;
        sArr[28][80] = (short) 339;
        sArr[29][8] = (short) 338;
        sArr[45][80] = (short) 337;
        sArr[53][37] = (short) 336;
        sArr[28][65] = (short) 335;
        sArr[23][86] = (short) 334;
        sArr[39][45] = (short) 333;
        sArr[53][32] = (short) 332;
        sArr[38][68] = (short) 331;
        sArr[45][78] = (short) 330;
        sArr[43][7] = (short) 329;
        sArr[46][82] = (short) 328;
        sArr[27][38] = (short) 327;
        sArr[16][62] = (short) 326;
        sArr[24][17] = (short) 325;
        sArr[22][70] = (short) 324;
        sArr[52][28] = (short) 323;
        sArr[23][40] = (short) 322;
        sArr[28][50] = (short) 321;
        sArr[42][91] = (short) 320;
        sArr[47][76] = (short) 319;
        sArr[15][42] = (short) 318;
        sArr[43][55] = (short) 317;
        sArr[29][84] = (short) 316;
        sArr[44][90] = (short) 315;
        sArr[53][16] = (short) 314;
        sArr[22][93] = (short) 313;
        sArr[34][10] = (short) 312;
        sArr[32][53] = (short) 311;
        sArr[43][65] = (short) 310;
        sArr[28][7] = (short) 309;
        sArr[35][46] = (short) 308;
        sArr[21][39] = (short) 307;
        sArr[44][18] = (short) 306;
        sArr[40][10] = (short) 305;
        sArr[54][53] = (short) 304;
        sArr[38][74] = (short) 303;
        sArr[28][26] = (short) 302;
        sArr[15][13] = (short) 301;
        sArr[39][34] = (short) 300;
        sArr[39][46] = (short) 299;
        sArr[42][66] = (short) 298;
        sArr[33][58] = (short) 297;
        sArr[15][56] = (short) 296;
        sArr[18][51] = (short) 295;
        sArr[49][68] = (short) 294;
        sArr[30][37] = (short) 293;
        sArr[51][84] = (short) 292;
        sArr[51][9] = (short) 291;
        sArr[40][70] = (short) 290;
        sArr[41][84] = (short) 289;
        sArr[28][64] = (short) 288;
        sArr[32][88] = (short) 287;
        sArr[24][5] = (short) 286;
        sArr[53][23] = (short) 285;
        sArr[42][27] = (short) 284;
        sArr[22][38] = (short) 283;
        sArr[32][86] = (short) 282;
        sArr[34][30] = (short) 281;
        sArr[38][63] = (short) 280;
        sArr[24][59] = (short) 279;
        sArr[22][81] = (short) 278;
        sArr[32][11] = (short) 277;
        sArr[51][21] = (short) 276;
        sArr[54][41] = (short) 275;
        sArr[21][50] = (short) 274;
        sArr[23][89] = (short) 273;
        sArr[19][87] = (short) 272;
        sArr[26][7] = (short) 271;
        sArr[30][75] = (short) 270;
        sArr[43][84] = (short) 269;
        sArr[51][25] = (short) 268;
        sArr[16][67] = (short) 267;
        sArr[32][9] = (short) 266;
        sArr[48][51] = (short) 265;
        sArr[39][7] = (short) 264;
        sArr[44][88] = (short) 263;
        sArr[52][24] = (short) 262;
        sArr[23][34] = (short) 261;
        sArr[32][75] = (short) 260;
        sArr[19][10] = (short) 259;
        sArr[28][91] = (short) 258;
        sArr[32][83] = (short) 257;
        sArr[25][75] = (short) 256;
        sArr[53][45] = (short) 255;
        sArr[29][85] = (short) 254;
        sArr[53][59] = (short) 253;
        sArr[16][2] = (short) 252;
        sArr[19][78] = (short) 251;
        sArr[15][75] = (short) 250;
        sArr[51][42] = (short) 249;
        sArr[45][67] = (short) 248;
        sArr[15][74] = (short) 247;
        sArr[25][81] = (short) 246;
        sArr[37][62] = (short) 245;
        sArr[16][55] = (short) 244;
        sArr[18][38] = (short) 243;
        sArr[23][23] = (short) 242;
        sArr[38][30] = (short) 241;
        sArr[17][28] = (short) 240;
        sArr[44][73] = (short) 239;
        sArr[23][78] = (short) 238;
        sArr[40][77] = (short) 237;
        sArr[38][87] = (short) 236;
        sArr[27][19] = (short) 235;
        sArr[38][82] = (short) 234;
        sArr[37][22] = (short) 233;
        sArr[41][30] = (short) 232;
        sArr[54][9] = (short) 231;
        sArr[32][30] = (short) 230;
        sArr[30][52] = (short) 229;
        sArr[40][84] = (short) 228;
        sArr[53][57] = (short) 227;
        sArr[27][27] = (short) 226;
        sArr[38][64] = (short) 225;
        sArr[18][43] = (short) 224;
        sArr[23][69] = (short) 223;
        sArr[28][12] = (short) 222;
        sArr[50][78] = (short) 221;
        sArr[50][1] = (short) 220;
        sArr[26][88] = (short) 219;
        sArr[36][40] = (short) 218;
        sArr[33][89] = (short) 217;
        sArr[41][28] = (short) 216;
        sArr[31][77] = (short) 215;
        sArr[46][1] = (short) 214;
        sArr[47][19] = (short) 213;
        sArr[35][55] = (short) 212;
        sArr[41][21] = (short) 211;
        sArr[27][10] = (short) 210;
        sArr[32][77] = (short) 209;
        sArr[26][37] = (short) 208;
        sArr[20][33] = (short) 207;
        sArr[41][52] = (short) 206;
        sArr[32][18] = (short) 205;
        sArr[38][13] = (short) 204;
        sArr[20][18] = (short) 203;
        sArr[20][24] = (short) 202;
        sArr[45][19] = (short) 201;
        sArr[18][53] = (short) 200;
    }

    
    void m2193b(short[][] sArr) {
        sArr[48][49] = (short) 599;
        sArr[35][65] = (short) 598;
        sArr[41][27] = (short) 597;
        sArr[35][0] = (short) 596;
        sArr[39][19] = (short) 595;
        sArr[35][42] = (short) 594;
        sArr[38][66] = (short) 593;
        sArr[35][8] = (short) 592;
        sArr[35][6] = (short) 591;
        sArr[35][66] = (short) 590;
        sArr[43][14] = (short) 589;
        sArr[69][80] = (short) 588;
        sArr[50][48] = (short) 587;
        sArr[36][71] = (short) 586;
        sArr[37][10] = (short) 585;
        sArr[60][52] = (short) 584;
        sArr[51][21] = (short) 583;
        sArr[40][2] = (short) 582;
        sArr[67][35] = (short) 581;
        sArr[38][78] = (short) 580;
        sArr[49][18] = (short) 579;
        sArr[35][23] = (short) 578;
        sArr[42][83] = (short) 577;
        sArr[79][47] = (short) 576;
        sArr[61][82] = (short) 575;
        sArr[38][7] = (short) 574;
        sArr[35][29] = (short) 573;
        sArr[37][77] = (short) 572;
        sArr[54][67] = (short) 571;
        sArr[38][80] = (short) 570;
        sArr[52][74] = (short) 569;
        sArr[36][37] = (short) 568;
        sArr[74][8] = (short) 567;
        sArr[41][83] = (short) 566;
        sArr[36][75] = (short) 565;
        sArr[49][63] = (short) 564;
        sArr[42][58] = (short) 563;
        sArr[56][33] = (short) 562;
        sArr[37][76] = (short) 561;
        sArr[62][39] = (short) 560;
        sArr[35][21] = (short) 559;
        sArr[70][19] = (short) 558;
        sArr[77][88] = (short) 557;
        sArr[51][14] = (short) 556;
        sArr[36][17] = (short) 555;
        sArr[44][51] = (short) 554;
        sArr[38][72] = (short) 553;
        sArr[74][90] = (short) 552;
        sArr[35][48] = (short) 551;
        sArr[35][69] = (short) 550;
        sArr[66][86] = (short) 549;
        sArr[57][20] = (short) 548;
        sArr[35][53] = (short) 547;
        sArr[36][87] = (short) 546;
        sArr[84][67] = (short) 545;
        sArr[70][56] = (short) 544;
        sArr[71][54] = (short) 543;
        sArr[60][70] = (short) 542;
        sArr[80][1] = (short) 541;
        sArr[39][59] = (short) 540;
        sArr[39][51] = (short) 539;
        sArr[35][44] = (short) 538;
        sArr[48][4] = (short) 537;
        sArr[55][24] = (short) 536;
        sArr[52][4] = (short) 535;
        sArr[54][26] = (short) 534;
        sArr[36][31] = (short) 533;
        sArr[37][22] = (short) 532;
        sArr[37][9] = (short) 531;
        sArr[46][0] = (short) 530;
        sArr[56][46] = (short) 529;
        sArr[47][93] = (short) 528;
        sArr[37][25] = (short) 527;
        sArr[39][8] = (short) 526;
        sArr[46][73] = (short) 525;
        sArr[38][48] = (short) 524;
        sArr[39][83] = (short) 523;
        sArr[60][92] = (short) 522;
        sArr[70][11] = (short) 521;
        sArr[63][84] = (short) 520;
        sArr[38][65] = (short) 519;
        sArr[45][45] = (short) 518;
        sArr[63][49] = (short) 517;
        sArr[63][50] = (short) 516;
        sArr[39][93] = (short) 515;
        sArr[68][20] = (short) 514;
        sArr[44][84] = (short) 513;
        sArr[66][34] = (short) 512;
        sArr[37][58] = (short) 511;
        sArr[39][0] = (short) 510;
        sArr[59][1] = (short) 509;
        sArr[47][8] = (short) 508;
        sArr[61][17] = (short) 507;
        sArr[53][87] = (short) 506;
        sArr[67][26] = (short) 505;
        sArr[43][46] = (short) 504;
        sArr[38][61] = (short) 503;
        sArr[45][9] = (short) 502;
        sArr[66][83] = (short) 501;
        sArr[43][88] = (short) 500;
        sArr[85][20] = (short) 499;
        sArr[57][36] = (short) 498;
        sArr[43][6] = (short) 497;
        sArr[86][77] = (short) 496;
        sArr[42][70] = (short) 495;
        sArr[49][78] = (short) 494;
        sArr[36][40] = (short) 493;
        sArr[42][71] = (short) 492;
        sArr[58][49] = (short) 491;
        sArr[35][20] = (short) 490;
        sArr[76][20] = (short) 489;
        sArr[39][25] = (short) 488;
        sArr[40][34] = (short) 487;
        sArr[39][76] = (short) 486;
        sArr[40][1] = (short) 485;
        sArr[59][0] = (short) 484;
        sArr[39][70] = (short) 483;
        sArr[46][14] = (short) 482;
        sArr[68][77] = (short) 481;
        sArr[38][55] = (short) 480;
        sArr[35][78] = (short) 479;
        sArr[84][44] = (short) 478;
        sArr[36][41] = (short) 477;
        sArr[37][62] = (short) 476;
        sArr[65][67] = (short) 475;
        sArr[69][66] = (short) 474;
        sArr[73][55] = (short) 473;
        sArr[71][49] = (short) 472;
        sArr[66][87] = (short) 471;
        sArr[38][33] = (short) 470;
        sArr[64][61] = (short) 469;
        sArr[35][7] = (short) 468;
        sArr[47][49] = (short) 467;
        sArr[56][14] = (short) 466;
        sArr[36][49] = (short) 465;
        sArr[50][81] = (short) 464;
        sArr[55][76] = (short) 463;
        sArr[35][19] = (short) 462;
        sArr[44][47] = (short) 461;
        sArr[35][15] = (short) 460;
        sArr[82][59] = (short) 459;
        sArr[35][43] = (short) 458;
        sArr[73][0] = (short) 457;
        sArr[57][83] = (short) 456;
        sArr[42][46] = (short) 455;
        sArr[36][0] = (short) 454;
        sArr[70][88] = (short) 453;
        sArr[42][22] = (short) 452;
        sArr[46][58] = (short) 451;
        sArr[36][34] = (short) 450;
        sArr[39][24] = (short) 449;
        sArr[35][55] = (short) 448;
        sArr[44][91] = (short) 447;
        sArr[37][51] = (short) 446;
        sArr[36][19] = (short) 445;
        sArr[69][90] = (short) 444;
        sArr[55][35] = (short) 443;
        sArr[35][54] = (short) 442;
        sArr[49][61] = (short) 441;
        sArr[36][67] = (short) 440;
        sArr[88][34] = (short) 439;
        sArr[35][17] = (short) 438;
        sArr[65][69] = (short) 437;
        sArr[74][89] = (short) 436;
        sArr[37][31] = (short) 435;
        sArr[43][48] = (short) 434;
        sArr[89][27] = (short) 433;
        sArr[42][79] = (short) 432;
        sArr[69][57] = (short) 431;
        sArr[36][13] = (short) 430;
        sArr[35][62] = (short) 429;
        sArr[65][47] = (short) 428;
        sArr[56][8] = (short) 427;
        sArr[38][79] = (short) 426;
        sArr[37][64] = (short) 425;
        sArr[64][64] = (short) 424;
        sArr[38][53] = (short) 423;
        sArr[38][31] = (short) 422;
        sArr[56][81] = (short) 421;
        sArr[36][22] = (short) 420;
        sArr[43][4] = (short) 419;
        sArr[36][90] = (short) 418;
        sArr[38][62] = (short) 417;
        sArr[66][85] = (short) 416;
        sArr[39][1] = (short) 415;
        sArr[59][40] = (short) 414;
        sArr[58][93] = (short) 413;
        sArr[44][43] = (short) 412;
        sArr[39][49] = (short) 411;
        sArr[64][2] = (short) 410;
        sArr[41][35] = (short) 409;
        sArr[60][22] = (short) 408;
        sArr[35][91] = (short) 407;
        sArr[78][1] = (short) 406;
        sArr[36][14] = (short) 405;
        sArr[82][29] = (short) 404;
        sArr[52][86] = (short) 403;
        sArr[40][16] = (short) 402;
        sArr[91][52] = (short) 401;
        sArr[50][75] = (short) 400;
        sArr[64][30] = (short) 399;
        sArr[90][78] = (short) 398;
        sArr[36][52] = (short) 397;
        sArr[55][87] = (short) 396;
        sArr[57][5] = (short) 395;
        sArr[57][31] = (short) 394;
        sArr[42][35] = (short) 393;
        sArr[69][50] = (short) 392;
        sArr[45][8] = (short) 391;
        sArr[50][87] = (short) 390;
        sArr[69][55] = (short) 389;
        sArr[92][3] = (short) 388;
        sArr[36][43] = (short) 387;
        sArr[64][10] = (short) 386;
        sArr[56][25] = (short) 385;
        sArr[60][68] = (short) 384;
        sArr[51][46] = (short) 383;
        sArr[50][0] = (short) 382;
        sArr[38][30] = (short) 381;
        sArr[50][85] = (short) 380;
        sArr[60][54] = (short) 379;
        sArr[73][6] = (short) 378;
        sArr[73][28] = (short) 377;
        sArr[56][19] = (short) 376;
        sArr[62][69] = (short) 375;
        sArr[81][66] = (short) 374;
        sArr[40][32] = (short) 373;
        sArr[76][31] = (short) 372;
        sArr[35][10] = (short) 371;
        sArr[41][37] = (short) 370;
        sArr[52][82] = (short) 369;
        sArr[91][72] = (short) 368;
        sArr[37][29] = (short) 367;
        sArr[56][30] = (short) 366;
        sArr[37][80] = (short) 365;
        sArr[81][56] = (short) 364;
        sArr[70][3] = (short) 363;
        sArr[76][15] = (short) 362;
        sArr[46][47] = (short) 361;
        sArr[35][88] = (short) 360;
        sArr[61][58] = (short) 359;
        sArr[37][37] = (short) 358;
        sArr[57][22] = (short) 357;
        sArr[41][23] = (short) 356;
        sArr[90][66] = (short) 355;
        sArr[39][60] = (short) 354;
        sArr[38][0] = (short) 353;
        sArr[37][87] = (short) 352;
        sArr[46][2] = (short) 351;
        sArr[38][56] = (short) 350;
        sArr[58][11] = (short) 349;
        sArr[48][10] = (short) 348;
        sArr[74][4] = (short) 347;
        sArr[40][42] = (short) 346;
        sArr[41][52] = (short) 345;
        sArr[61][92] = (short) 344;
        sArr[39][50] = (short) 343;
        sArr[47][88] = (short) 342;
        sArr[88][36] = (short) 341;
        sArr[45][73] = (short) 340;
        sArr[82][3] = (short) 339;
        sArr[61][36] = (short) 338;
        sArr[60][33] = (short) 337;
        sArr[38][27] = (short) 336;
        sArr[35][83] = (short) 335;
        sArr[65][24] = (short) 334;
        sArr[73][10] = (short) 333;
        sArr[41][13] = (short) 332;
        sArr[50][27] = (short) 331;
        sArr[59][50] = (short) 330;
        sArr[42][45] = (short) 329;
        sArr[55][19] = (short) 328;
        sArr[36][77] = (short) 327;
        sArr[69][31] = (short) 326;
        sArr[60][7] = (short) 325;
        sArr[40][88] = (short) 324;
        sArr[57][56] = (short) 323;
        sArr[50][50] = (short) 322;
        sArr[42][37] = (short) 321;
        sArr[38][82] = (short) 320;
        sArr[52][25] = (short) 319;
        sArr[42][67] = (short) 318;
        sArr[48][40] = (short) 317;
        sArr[45][81] = (short) 316;
        sArr[57][14] = (short) 315;
        sArr[42][13] = (short) 314;
        sArr[78][0] = (short) 313;
        sArr[35][51] = (short) 312;
        sArr[41][67] = (short) 311;
        sArr[64][23] = (short) 310;
        sArr[36][65] = (short) 309;
        sArr[48][50] = (short) 308;
        sArr[46][69] = (short) 307;
        sArr[47][89] = (short) 306;
        sArr[41][48] = (short) 305;
        sArr[60][56] = (short) 304;
        sArr[44][82] = (short) 303;
        sArr[47][35] = (short) 302;
        sArr[49][3] = (short) 301;
        sArr[49][69] = (short) 300;
        sArr[45][93] = (short) 299;
        sArr[60][34] = (short) 298;
        sArr[60][82] = (short) 297;
        sArr[61][61] = (short) 296;
        sArr[86][42] = (short) 295;
        sArr[89][60] = (short) 294;
        sArr[48][31] = (short) 293;
        sArr[35][75] = (short) 292;
        sArr[91][39] = (short) 291;
        sArr[53][19] = (short) 290;
        sArr[39][72] = (short) 289;
        sArr[69][59] = (short) 288;
        sArr[41][7] = (short) 287;
        sArr[54][13] = (short) 286;
        sArr[43][28] = (short) 285;
        sArr[36][6] = (short) 284;
        sArr[45][75] = (short) 283;
        sArr[36][61] = (short) 282;
        sArr[38][21] = (short) 281;
        sArr[45][14] = (short) 280;
        sArr[61][43] = (short) 279;
        sArr[36][63] = (short) 278;
        sArr[43][30] = (short) 277;
        sArr[46][51] = (short) 276;
        sArr[68][87] = (short) 275;
        sArr[39][26] = (short) 274;
        sArr[46][76] = (short) 273;
        sArr[36][15] = (short) 272;
        sArr[35][40] = (short) 271;
        sArr[79][60] = (short) 270;
        sArr[46][7] = (short) 269;
        sArr[65][72] = (short) 268;
        sArr[69][88] = (short) 267;
        sArr[47][18] = (short) 266;
        sArr[37][0] = (short) 265;
        sArr[37][49] = (short) 264;
        sArr[67][37] = (short) 263;
        sArr[36][91] = (short) 262;
        sArr[75][48] = (short) 261;
        sArr[75][63] = (short) 260;
        sArr[83][87] = (short) 259;
        sArr[37][44] = (short) 258;
        sArr[73][54] = (short) 257;
        sArr[51][61] = (short) 256;
        sArr[46][57] = (short) 255;
        sArr[55][21] = (short) 254;
        sArr[39][66] = (short) 253;
        sArr[47][11] = (short) 252;
        sArr[52][8] = (short) 251;
        sArr[82][81] = (short) 250;
        sArr[36][57] = (short) 249;
        sArr[38][54] = (short) 248;
        sArr[43][81] = (short) 247;
        sArr[37][42] = (short) 246;
        sArr[40][18] = (short) 245;
        sArr[80][90] = (short) 244;
        sArr[37][84] = (short) 243;
        sArr[57][15] = (short) 242;
        sArr[38][87] = (short) 241;
        sArr[37][32] = (short) 240;
        sArr[53][53] = (short) 239;
        sArr[89][29] = (short) 238;
        sArr[81][53] = (short) 237;
        sArr[75][3] = (short) 236;
        sArr[83][73] = (short) 235;
        sArr[66][13] = (short) 234;
        sArr[48][7] = (short) 233;
        sArr[46][35] = (short) 232;
        sArr[35][86] = (short) 231;
        sArr[37][20] = (short) 230;
        sArr[46][80] = (short) 229;
        sArr[38][24] = (short) 228;
        sArr[41][68] = (short) 227;
        sArr[42][21] = (short) 226;
        sArr[43][32] = (short) 225;
        sArr[38][20] = (short) 224;
        sArr[37][59] = (short) 223;
        sArr[41][77] = (short) 222;
        sArr[59][57] = (short) 221;
        sArr[68][59] = (short) 220;
        sArr[39][43] = (short) 219;
        sArr[54][39] = (short) 218;
        sArr[48][28] = (short) 217;
        sArr[54][28] = (short) 216;
        sArr[41][44] = (short) 215;
        sArr[51][64] = (short) 214;
        sArr[47][72] = (short) 213;
        sArr[62][67] = (short) 212;
        sArr[42][43] = (short) 211;
        sArr[61][38] = (short) 210;
        sArr[76][25] = (short) 209;
        sArr[48][91] = (short) 208;
        sArr[36][36] = (short) 207;
        sArr[80][32] = (short) 206;
        sArr[81][40] = (short) 205;
        sArr[37][5] = (short) 204;
        sArr[74][69] = (short) 203;
        sArr[36][82] = (short) 202;
        sArr[46][59] = (short) 201;
    }

    
    void m2196c(short[][] sArr) {
        sArr[52][132] = (short) 600;
        sArr[73][135] = (short) 599;
        sArr[49][123] = (short) 598;
        sArr[77][146] = (short) 597;
        sArr[81][123] = (short) 596;
        sArr[82][144] = (short) 595;
        sArr[51][179] = (short) 594;
        sArr[83][154] = (short) 593;
        sArr[71][139] = (short) 592;
        sArr[64][139] = (short) 591;
        sArr[85][144] = (short) 590;
        sArr[52][125] = (short) 589;
        sArr[88][25] = (short) 588;
        sArr[81][106] = (short) 587;
        sArr[81][148] = (short) 586;
        sArr[62][137] = (short) 585;
        sArr[94][0] = (short) 584;
        sArr[1][64] = (short) 583;
        sArr[67][163] = (short) 582;
        sArr[20][190] = (short) 581;
        sArr[57][131] = (short) 580;
        sArr[29][169] = (short) 579;
        sArr[72][143] = (short) 578;
        sArr[0][173] = (short) 577;
        sArr[11][23] = (short) 576;
        sArr[61][141] = (short) 575;
        sArr[60][123] = (short) 574;
        sArr[81][114] = (short) 573;
        sArr[82][131] = (short) 572;
        sArr[67][156] = (short) 571;
        sArr[71][167] = (short) 570;
        sArr[20][50] = (short) 569;
        sArr[77][132] = (short) 568;
        sArr[84][38] = (short) 567;
        sArr[26][29] = (short) 566;
        sArr[74][187] = (short) 565;
        sArr[62][116] = (short) 564;
        sArr[67][135] = (short) 563;
        sArr[5][86] = (short) 562;
        sArr[72][186] = (short) 561;
        sArr[75][161] = (short) 560;
        sArr[78][130] = (short) 559;
        sArr[94][30] = (short) 558;
        sArr[84][72] = (short) 557;
        sArr[1][67] = (short) 556;
        sArr[75][172] = (short) 555;
        sArr[74][185] = (short) 554;
        sArr[53][C2295j.f14322b] = (short) 553;
        sArr[123][14] = (short) 552;
        sArr[79][97] = (short) 551;
        sArr[85][110] = (short) 550;
        sArr[78][171] = (short) 549;
        sArr[52][131] = (short) 548;
        sArr[56][100] = (short) 547;
        sArr[50][182] = (short) 546;
        sArr[94][64] = (short) 545;
        sArr[106][74] = (short) 544;
        sArr[11][HttpStatus.SC_PROCESSING] = (short) 543;
        sArr[53][124] = (short) 542;
        sArr[24][3] = (short) 541;
        sArr[86][148] = (short) 540;
        sArr[53][184] = (short) 539;
        sArr[86][147] = (short) 538;
        sArr[96][161] = (short) 537;
        sArr[82][77] = (short) 536;
        sArr[59][146] = (short) 535;
        sArr[84][126] = (short) 534;
        sArr[79][132] = (short) 533;
        sArr[85][123] = (short) 532;
        sArr[71][HttpStatus.SC_SWITCHING_PROTOCOLS] = (short) 531;
        sArr[85][106] = (short) 530;
        sArr[6][184] = (short) 529;
        sArr[57][156] = (short) 528;
        sArr[75][104] = (short) 527;
        sArr[50][137] = (short) 526;
        sArr[79][133] = (short) 525;
        sArr[76][108] = (short) 524;
        sArr[57][142] = (short) 523;
        sArr[84][130] = (short) 522;
        sArr[52][128] = (short) 521;
        sArr[47][44] = (short) 520;
        sArr[52][152] = (short) 519;
        sArr[54][104] = (short) 518;
        sArr[30][47] = (short) 517;
        sArr[71][123] = (short) 516;
        sArr[52][107] = (short) 515;
        sArr[45][84] = (short) 514;
        sArr[107][118] = (short) 513;
        sArr[5][161] = (short) 512;
        sArr[48][126] = (short) 511;
        sArr[67][170] = (short) 510;
        sArr[43][6] = (short) 509;
        sArr[70][112] = (short) 508;
        sArr[86][174] = (short) 507;
        sArr[84][166] = (short) 506;
        sArr[79][130] = (short) 505;
        sArr[57][141] = (short) 504;
        sArr[81][178] = (short) 503;
        sArr[56][187] = (short) 502;
        sArr[81][162] = (short) 501;
        sArr[53][104] = (short) 500;
        sArr[123][35] = (short) 499;
        sArr[70][169] = (short) 498;
        sArr[69][164] = (short) 497;
        sArr[109][61] = (short) 496;
        sArr[73][130] = (short) 495;
        sArr[62][134] = (short) 494;
        sArr[54][125] = (short) 493;
        sArr[79][105] = (short) 492;
        sArr[70][165] = (short) 491;
        sArr[71][189] = (short) 490;
        sArr[23][147] = (short) 489;
        sArr[51][139] = (short) 488;
        sArr[47][137] = (short) 487;
        sArr[77][123] = (short) 486;
        sArr[86][183] = (short) 485;
        sArr[63][173] = (short) 484;
        sArr[79][144] = (short) 483;
        sArr[84][159] = (short) 482;
        sArr[60][91] = (short) 481;
        sArr[66][187] = (short) 480;
        sArr[73][114] = (short) 479;
        sArr[85][56] = (short) 478;
        sArr[71][149] = (short) 477;
        sArr[84][189] = (short) 476;
        sArr[104][31] = (short) 475;
        sArr[83][82] = (short) 474;
        sArr[68][35] = (short) 473;
        sArr[11][77] = (short) 472;
        sArr[15][155] = (short) 471;
        sArr[83][153] = (short) 470;
        sArr[71][1] = (short) 469;
        sArr[53][190] = (short) 468;
        sArr[50][135] = (short) 467;
        sArr[3][147] = (short) 466;
        sArr[48][136] = (short) 465;
        sArr[66][166] = (short) 464;
        sArr[55][159] = (short) 463;
        sArr[82][150] = (short) 462;
        sArr[58][178] = (short) 461;
        sArr[64][HttpStatus.SC_PROCESSING] = (short) 460;
        sArr[16][106] = (short) 459;
        sArr[68][110] = (short) 458;
        sArr[54][14] = (short) 457;
        sArr[60][140] = (short) 456;
        sArr[91][71] = (short) 455;
        sArr[54][150] = (short) 454;
        sArr[78][177] = (short) 453;
        sArr[78][117] = (short) 452;
        sArr[104][12] = (short) 451;
        sArr[73][150] = (short) 450;
        sArr[51][142] = (short) 449;
        sArr[81][145] = (short) 448;
        sArr[66][183] = (short) 447;
        sArr[51][178] = (short) 446;
        sArr[75][107] = (short) 445;
        sArr[65][119] = (short) 444;
        sArr[69][176] = (short) 443;
        sArr[59][122] = (short) 442;
        sArr[78][C2295j.f14322b] = (short) 441;
        sArr[85][183] = (short) 440;
        sArr[105][16] = (short) 439;
        sArr[73][110] = (short) 438;
        sArr[104][39] = (short) 437;
        sArr[119][16] = (short) 436;
        sArr[76][162] = (short) 435;
        sArr[67][152] = (short) 434;
        sArr[82][24] = (short) 433;
        sArr[73][121] = (short) 432;
        sArr[83][83] = (short) 431;
        sArr[82][145] = (short) 430;
        sArr[49][133] = (short) 429;
        sArr[94][13] = (short) 428;
        sArr[58][139] = (short) 427;
        sArr[74][189] = (short) 426;
        sArr[66][177] = (short) 425;
        sArr[85][184] = (short) 424;
        sArr[55][183] = (short) 423;
        sArr[71][107] = (short) 422;
        sArr[11][98] = (short) 421;
        sArr[72][153] = (short) 420;
        sArr[2][137] = (short) 419;
        sArr[59][147] = (short) 418;
        sArr[58][152] = (short) 417;
        sArr[55][144] = (short) 416;
        sArr[73][125] = (short) 415;
        sArr[52][154] = (short) 414;
        sArr[70][178] = (short) 413;
        sArr[79][148] = (short) 412;
        sArr[63][143] = (short) 411;
        sArr[50][140] = (short) 410;
        sArr[47][145] = (short) 409;
        sArr[48][123] = (short) 408;
        sArr[56][107] = (short) 407;
        sArr[84][83] = (short) 406;
        sArr[59][112] = (short) 405;
        sArr[124][72] = (short) 404;
        sArr[79][99] = (short) 403;
        sArr[3][37] = (short) 402;
        sArr[114][55] = (short) 401;
        sArr[85][152] = (short) 400;
        sArr[60][47] = (short) 399;
        sArr[65][96] = (short) 398;
        sArr[74][110] = (short) 397;
        sArr[86][182] = (short) 396;
        sArr[50][99] = (short) 395;
        sArr[67][186] = (short) 394;
        sArr[81][74] = (short) 393;
        sArr[80][37] = (short) 392;
        sArr[21][60] = (short) 391;
        sArr[110][12] = (short) 390;
        sArr[60][162] = (short) 389;
        sArr[29][115] = (short) 388;
        sArr[83][130] = (short) 387;
        sArr[52][136] = (short) 386;
        sArr[63][114] = (short) 385;
        sArr[49][127] = (short) 384;
        sArr[83][109] = (short) 383;
        sArr[66][128] = (short) 382;
        sArr[78][136] = (short) 381;
        sArr[81][180] = (short) 380;
        sArr[76][104] = (short) 379;
        sArr[56][156] = (short) 378;
        sArr[61][23] = (short) 377;
        sArr[4][30] = (short) 376;
        sArr[69][154] = (short) 375;
        sArr[100][37] = (short) 374;
        sArr[54][177] = (short) 373;
        sArr[23][119] = (short) 372;
        sArr[71][171] = (short) 371;
        sArr[84][146] = (short) 370;
        sArr[20][184] = (short) 369;
        sArr[86][76] = (short) 368;
        sArr[74][132] = (short) 367;
        sArr[47][97] = (short) 366;
        sArr[82][137] = (short) 365;
        sArr[94][56] = (short) 364;
        sArr[92][30] = (short) 363;
        sArr[19][117] = (short) 362;
        sArr[48][173] = (short) 361;
        sArr[2][136] = (short) 360;
        sArr[7][182] = (short) 359;
        sArr[74][188] = (short) 358;
        sArr[14][132] = (short) 357;
        sArr[62][172] = (short) 356;
        sArr[25][39] = (short) 355;
        sArr[85][129] = (short) 354;
        sArr[64][98] = (short) 353;
        sArr[67][127] = (short) 352;
        sArr[72][167] = (short) 351;
        sArr[57][143] = (short) 350;
        sArr[76][187] = (short) 349;
        sArr[83][181] = (short) 348;
        sArr[84][10] = (short) 347;
        sArr[55][166] = (short) 346;
        sArr[55][188] = (short) 345;
        sArr[13][151] = (short) 344;
        sArr[62][124] = (short) 343;
        sArr[53][136] = (short) 342;
        sArr[106][57] = (short) 341;
        sArr[47][166] = (short) 340;
        sArr[109][30] = (short) 339;
        sArr[78][114] = (short) 338;
        sArr[83][19] = (short) 337;
        sArr[56][162] = (short) 336;
        sArr[60][177] = (short) 335;
        sArr[88][9] = (short) 334;
        sArr[74][163] = (short) 333;
        sArr[52][156] = (short) 332;
        sArr[71][180] = (short) 331;
        sArr[60][57] = (short) 330;
        sArr[72][173] = (short) 329;
        sArr[82][91] = (short) 328;
        sArr[51][186] = (short) 327;
        sArr[75][86] = (short) 326;
        sArr[75][78] = (short) 325;
        sArr[76][170] = (short) 324;
        sArr[60][147] = (short) 323;
        sArr[82][75] = (short) 322;
        sArr[80][148] = (short) 321;
        sArr[86][150] = (short) 320;
        sArr[13][95] = (short) 319;
        sArr[0][11] = (short) 318;
        sArr[84][190] = (short) 317;
        sArr[76][166] = (short) 316;
        sArr[14][72] = (short) 315;
        sArr[67][144] = (short) 314;
        sArr[84][44] = (short) 313;
        sArr[72][125] = (short) 312;
        sArr[66][127] = (short) 311;
        sArr[60][25] = (short) 310;
        sArr[70][146] = (short) 309;
        sArr[79][135] = (short) 308;
        sArr[54][135] = (short) 307;
        sArr[60][104] = (short) 306;
        sArr[55][132] = (short) 305;
        sArr[94][2] = (short) 304;
        sArr[54][133] = (short) 303;
        sArr[56][190] = (short) 302;
        sArr[58][174] = (short) 301;
        sArr[80][144] = (short) 300;
        sArr[85][113] = (short) 299;
    }
}
