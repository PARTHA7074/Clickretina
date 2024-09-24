package com.partha.clickretina.pojoClasses

import com.google.gson.annotations.SerializedName

data class ContentResponse(

	@field:SerializedName("description")
	val description: String? = "Lorpum ipsum dolor sit amet, consectetur adipiscing elit. Donec faucibus, sapien vel lacinia interdum, metus nunc interdum metus, eu eleifend mauris orci in enim. Sed eget mi sem.",

	@field:SerializedName("titles")
	val titles: List<String?>? = null
)
