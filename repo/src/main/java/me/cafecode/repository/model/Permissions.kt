package me.cafecode.repository.model

import com.google.gson.annotations.SerializedName
import org.parceler.Parcel

@Parcel
data class Permissions(

    @field:SerializedName("pull")
    val pull: Boolean? = null,

    @field:SerializedName("admin")
    val admin: Boolean? = null,

    @field:SerializedName("push")
    val push: Boolean? = null
) : GitHubObject()
