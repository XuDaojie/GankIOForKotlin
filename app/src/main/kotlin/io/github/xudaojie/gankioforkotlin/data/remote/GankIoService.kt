package io.github.xudaojie.gankioforkotlin.data.remote

import io.github.xudaojie.gankioforkotlin.bean.DayData
import io.github.xudaojie.gankioforkotlin.bean.GankData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by xdj on 16/9/6.
 */
interface GankIoService {

    /**
     * 分类数据: http://gank.io/api/data/数据类型/请求个数/第几页
     * @param group 数据类型： 福利 | Android | iOS | 休息视频 | 拓展资源 | 前端 | all
     * @param count 请求个数： 数字，大于0
     * @param limit 第几页：数字，大于0
     */
    @GET("/api/data/{group}/{count}/{limit}")
    fun data(@Path("group") group: String,
             @Path("count") count: Int, @Path("limit") limit: Int): Call<GankData>

    /**
     * 分类数据: http://gank.io/api/data/数据类型/请求个数/第几页
     * @param group 数据类型：福利 | Android | iOS | 休息视频 | 拓展资源 | 前端
     * @param count 个数： 数字，大于0
     */
    @GET("/api/data/{group}/{count}/{limit}")
    fun randomData(@Path("group") group: String, @Path("count") count: Int): Call<GankData>

    /**
     * 每日数据： http://gank.io/api/day/年/月/日
     */
    @GET("/api/day/{date}")
    fun day(@Path("date", encoded = true) date: String): Call<DayData>
}
