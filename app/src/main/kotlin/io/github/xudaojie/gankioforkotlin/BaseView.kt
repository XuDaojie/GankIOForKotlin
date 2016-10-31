package io.github.xudaojie.gankioforkotlin

/**
 * Created by xdj on 2016/10/31.
 */
// in 符号，表示 T 只能为方法参数、被操作，不能为返回值
interface BaseView<in T> {
    fun setPresenter(presenter: T)
}