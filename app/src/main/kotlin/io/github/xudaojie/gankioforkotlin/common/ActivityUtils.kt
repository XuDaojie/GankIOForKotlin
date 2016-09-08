/*
 * Copyright 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.xudaojie.gankioforkotlin.common

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

/**
 * This provides methods to help Activities load their UI.
 */
object ActivityUtils {

    /**
     * The `fragment` is added to the container view with id `frameId`. The operation is
     * performed by the `fragmentManager`.

     */
    fun addFragmentToActivity(fragmentManager: FragmentManager,
                              fragment: Fragment, frameId: Int) {
        val transaction = fragmentManager.beginTransaction()
        transaction.add(frameId, fragment)
        transaction.commit()
    }

    fun addFragmentToActivity(fragmentManager: FragmentManager,
                              fragment: Fragment, frameId: Int, tag: String) {
        val transaction = fragmentManager.beginTransaction()
        transaction.add(frameId, fragment, tag)
        transaction.commit()
    }

    /**
     * 将当前Fragment隐藏，显示传入的fragment
     * @param fragmentManager
     * *
     * @param fragment
     */
    fun showFragmentToActivity(fragmentManager: FragmentManager,
                               fragment: Fragment) {
        val transaction = fragmentManager.beginTransaction()
        transaction.show(fragment)
        transaction.commit()
    }

    /**
     * 添加传入的Fragment，并将当前Fragment隐藏，显示传入的fragment，
     * @param fragmentManager
     * *
     * @param fragment
     * *
     * @param hideFragmentArray 需要隐藏的fragment
     */
    fun showFragmentToActivity(fragmentManager: FragmentManager,
                               fragment: Fragment,
                               vararg hideFragmentArray: Fragment) {

        val transaction = fragmentManager.beginTransaction()
        if (hideFragmentArray.size > 0) {
            for (hideFragment in hideFragmentArray) {
                if (hideFragment != null) {
                    transaction.hide(hideFragment)
                }
            }
        }
        transaction.show(fragment)
        transaction.commit()
    }

    /**
     * 添加传入的Fragment，并将当前Fragment隐藏，显示传入的fragment，
     * @param fragmentManager
     * *
     * @param fragment
     * *
     * @param frameId
     * *
     * @param tag
     * *
     * @param hideFragmentArray 需要隐藏的fragment
     */
    fun showFragmentToActivity(fragmentManager: FragmentManager,
                               fragment: Fragment, frameId: Int, tag: String,
                               vararg hideFragmentArray: Fragment) {

        val transaction = fragmentManager.beginTransaction()
        if (hideFragmentArray.size > 0) {
            for (hideFragment in hideFragmentArray) {
                if (hideFragment != null) {
                    transaction.hide(hideFragment)
                }
            }
        }
        if (!fragment.isAdded) {
            transaction.add(frameId, fragment, tag)
        }
        transaction.show(fragment)

        transaction.commit()
    }

}
