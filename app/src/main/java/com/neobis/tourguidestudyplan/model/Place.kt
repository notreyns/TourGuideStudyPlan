package com.neobis.tourguidestudyplan.model


data class Place(
    var name: String,
    var shortDescription: String,
    var address: String,
    var schedule: String,
    var imageResource: Int,

    var phone: String
)
