package com.luosnn.tv;

import cn.bmob.v3.BmobObject;

/**
 * Created by 罗什什 on 2017/11/29.
 */

public class Bug extends BmobObject {
    String string;
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
