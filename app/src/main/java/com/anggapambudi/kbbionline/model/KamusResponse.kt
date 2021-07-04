package com.anggapambudi.kbbionline.model

import com.google.gson.annotations.SerializedName

data class KamusResponse(

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("status")
	val status: Boolean? = null
)

data class Data(

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("resultLists")
	val resultLists: ArrayList<ResultListsItem>
)

data class ResultListsItem(

	@field:SerializedName("kata")
	val kata: String? = null,

	@field:SerializedName("arti")
	val arti: List<String?>? = null
)
