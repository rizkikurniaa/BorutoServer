package com.example

import io.ktor.http.HttpHeaders
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.defaultheaders.DefaultHeaders
import java.time.Duration

fun Application.configureDefaultHeader(){
    // Menginstal feature DefaultHeaders dari Ktor
    install(DefaultHeaders){
        // Menghitung durasi dalam detik
        val oneYearInSeconds = Duration.ofDays(365).seconds

        // Menggunakan fungsi header() dari DSL DefaultHeaders
        header(
            name = HttpHeaders.CacheControl,
            value = "public, max-age=$oneYearInSeconds, immutable"
        )
    }
}