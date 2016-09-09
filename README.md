# GankIOForKotlin

## Kotlin
1. Kotlin内部类默认不会包含对外部类的引用,需要在类名前增加`inner`关键后才支持
2. 编译时出现了**Error:(9, 8) Unresolved reference: kotlinx**错误
    解决方案 http://stackoverflow.com/questions/34169562/unresolved-reference-kotlinx/34250825
3. Kotlin对所有引用的**layout**都可以简化`findViewById`
4. 不能使用`xxx.class`,要是`xxx::class.java`
5. Kotlin中去除了`static`关键字,可使用`companion object`代替<br>
    ``` kotlin
    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }
    ```
6. `xxx as View`表示将`xxx`强转为`View`
7. 生命参数关键字`var`、`val`。`var`是可变参数,`val`是不可变参数,类似**Java**中增加了`final`关键字
8. Kotlin中使用`object`关键字声明类时,表示此类为单例类,类中所有方法属性都为静态的 
9. `interface`与`Java`不同,可以带有默认实现
10. `var str: String? = null` **?**表示c允许为空
11. `str?.length()`等同于
    ``` java
    if (c != null) {
        c.length();
    }
    ```
12. 代码块支持返回值,例如`if`、`else`
    ``` kotlin
    val name = if (args.isNotEmpty()) args[0] else "World"
    ```

### Pattern Matching
TODO

## 吃水不忘挖井人
[android CoordinatorLayout使用](http://blog.csdn.net/xyz_lmn/article/details/48055919)
[使用Kotlin进行Android开发](http://ragnraok.github.io/using-kotlin-to-write-android-app.html)