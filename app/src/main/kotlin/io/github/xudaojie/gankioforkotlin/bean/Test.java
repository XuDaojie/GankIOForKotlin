package io.github.xudaojie.gankioforkotlin.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by xdj on 16/9/9.
 */

public class Test {
    @SerializedName(value = "name", alternate = {"2", "1"})
    private String name;
}
