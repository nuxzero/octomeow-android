package me.cafecode.repository.model

import com.google.gson.annotations.SerializedName

data class License(

        @field:SerializedName("html_url")
        val htmlUrl: String? = null,

        @field:SerializedName("name")
        val name: String? = null,

        @field:SerializedName("spdx_id")
        val spdxId: String? = null,

        @field:SerializedName("key")
        val key: String? = null,

        @field:SerializedName("url")
        val url: String? = null
)
