package org.seckill.util;

import org.springframework.util.DigestUtils;

public class MD5Util {

    private final static String stat = "123DFs4dd/%#DFA23)4d@3#%fk2sl3SD";

    public static String getMdStr(long skillId) {
        String base = skillId + "/" + stat;
        return DigestUtils.md5DigestAsHex(base.getBytes());
    }

}
