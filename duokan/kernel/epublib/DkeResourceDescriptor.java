package com.duokan.kernel.epublib;

public class DkeResourceDescriptor {
    public final boolean hasDrm;
    public final String lowQualityMd5;
    public final long lowQualitySize;
    public final String lowQualityUri;
    public final String packUri;
    public final String resourceMd5;
    public final long resourceSize;
    public final int resourceType;
    public final String resourceUri;

    public DkeResourceDescriptor(String str, int i, String str2, String str3, long j, String str4, String str5, long j2, boolean z) {
        this.packUri = str;
        this.resourceType = i;
        this.resourceUri = str2;
        this.resourceMd5 = str3;
        this.resourceSize = j;
        this.lowQualityUri = str4;
        this.lowQualityMd5 = str5;
        this.lowQualitySize = j2;
        this.hasDrm = z;
    }
}
