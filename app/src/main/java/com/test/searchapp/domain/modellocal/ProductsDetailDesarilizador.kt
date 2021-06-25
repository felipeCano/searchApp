package com.test.searchapp.domain.modellocal

import com.google.gson.*
import java.lang.reflect.Type
import java.io.IOException
import com.google.gson.JsonElement

class ProductsDetailDesarilizador : JsonDeserializer<DetailProductModel>,
    JsonSerializer<DetailProductModel> {

    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): DetailProductModel? {
        val productsTSoluciona = DetailProductModel()
        try {
            val rootObject = json!!.asJsonObject

            val gsonBuilder = GsonBuilder().serializeNulls()
            val gson = gsonBuilder.create()

            val pickers = gson.fromJson(json.asJsonObject.get("pickers"), Array<ProductModel>::class.java)

            val shortDescription = ShortDescription("")
            shortDescription.content = rootObject.get("short_description").asJsonObject.get("content").asString

            productsTSoluciona.id = rootObject.get("id").asString
            productsTSoluciona.name = rootObject.get("name").asString
            //productsTSoluciona.pickers = pickers

        } catch (e: IOException) {
            e.printStackTrace()
        }
        return productsTSoluciona
    }
    override fun serialize(
        src: DetailProductModel?,
        typeOfSrc: Type?,
        context: JsonSerializationContext?
    ): JsonElement {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}