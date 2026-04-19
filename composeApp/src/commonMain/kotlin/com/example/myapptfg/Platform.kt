package com.example.myapptfg

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform