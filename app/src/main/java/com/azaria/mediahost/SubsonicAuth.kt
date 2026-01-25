package com.azaria.mediahost

import java.security.MessageDigest

object SubsonicAuth {
    fun getAuthParams(user: String, pass: String): Map<String, String> {
        val salt = (1..10).map { (('a'..'z') + ('0'..'9')).random() }.joinToString("")
        val token = md5(pass + salt)

        return mapOf(
            "u" to user,
            "t" to token,
            "s" to salt,
            "v" to "1.16.1", // API version
            "c" to "myMediaApp", // Client name
            "f" to "json"    // Force JSON response
        )
    }

    private fun md5(input: String): String {
        val md = MessageDigest.getInstance("MD5")
        return md.digest(input.toByteArray()).joinToString("") { "%02x".format(it) }
    }
}