package com.finalcad.recyclerviewheaderplayground.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

private val THE_LIST =
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla vitae elit venenatis, vehicula nisl in, mattis libero. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam non lorem venenatis, vehicula quam eget, consequat turpis. Sed nec efficitur nisi. Sed vitae mattis risus. Morbi lacinia rutrum elit vitae ornare. Fusce bibendum, dolor eu ullamcorper convallis, massa nisi consequat mauris, eu dictum libero magna et tortor. In at euismod erat. Pellentesque condimentum cursus sapien, sed molestie metus tincidunt vel. Sed aliquam elit vel euismod sodales. Integer quis lectus in dui dignissim blandit. Proin eget lacus risus. Etiam ultrices imperdiet hendrerit. In at risus pretium sapien luctus lobortis vitae nec nibh.".split(
        " "
    )

class ListViewModel : ViewModel() {

    private val _items = MutableLiveData<List<String>>().apply { value = emptyList() }
    val items: LiveData<List<String>>
        get() = _items

    private val _header = MutableLiveData<String>().apply { value = "I'm the header !!" }
    val header: LiveData<String>
        get() = _header

    init {
        _items.value = THE_LIST
    }

    fun filterOriginal() {
        _items.value = THE_LIST.filterIndexed { index, _ -> index % 2 == 0 }
    }

    fun startOriginal() {
        _items.value = THE_LIST.subList(0, 10)
    }

    fun original() {
        _items.value = THE_LIST
    }

    fun empty() {
        _items.value = emptyList()
    }
}