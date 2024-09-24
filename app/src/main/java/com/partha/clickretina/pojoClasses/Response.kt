package com.partha.clickretina.pojoClasses

import com.google.gson.annotations.SerializedName

data class Response(

	@field:SerializedName("choices")
	val choices: List<ChoicesItem?>? = null,
)

data class ChoicesItem(

	@field:SerializedName("finish_reason")
	val finishReason: String? = null,

	@field:SerializedName("index")
	val index: Int? = null,

	@field:SerializedName("message")
	val message: Message? = null,

	@field:SerializedName("logprobs")
	val logprobs: Any? = null
)

data class Message(

	@field:SerializedName("role")
	val role: String? = null,

	@field:SerializedName("refusal")
	val refusal: Any? = null,

	@field:SerializedName("content")
	val content: String? = null
)
