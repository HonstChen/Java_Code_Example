package com.ithema.Time;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Set;

public class ZoneIDDemo1 {
    public static void main(String[] args) {
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        System.out.println(zoneIds);
        System.out.println(zoneIds.size());
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);
        ZoneId.of("shanghai");

    }
}
