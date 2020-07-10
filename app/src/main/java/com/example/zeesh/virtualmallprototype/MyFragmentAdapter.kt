package com.example.zeesh.virtualmallprototype

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by zeesh on 5/12/2018.
 */
class MyFragmentAdapter(val dataset: MutableList<Fragment>, fm: FragmentManager): FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment = dataset[position]

    override fun getCount(): Int = dataset.size

    override fun getPageTitle(position: Int): CharSequence {
        var title = ""
        when(position){
            0-> title = "Brands"
            1-> title = "Cart"
            2-> title = "Bucket"
        }
//        return super.getPageTitle(position)

        return title
    }




}