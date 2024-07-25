package com.css101.pokedex.utils

fun calculateSpanCount(recyclerViewWidthPx: Int, itemWidthPx: Int): Int {
    return recyclerViewWidthPx / itemWidthPx
}