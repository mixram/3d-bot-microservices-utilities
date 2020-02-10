package com.mixram.telegram.microservices.utilities.databinding

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.PropertyAccessor
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.ObjectWriter
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.module.kotlin.registerKotlinModule

/**
 * File for static methods providing work with Json.
 * @author mixram on 2020-02-07.
 * @since 0.0.2.0
 */

private val OBJECT_MAPPER: ObjectMapper = CustomJsonMapper()
private val OBJECT_WRITER: ObjectWriter = OBJECT_MAPPER.writerWithDefaultPrettyPrinter()

/**
 * To convert object into string with "pretty"-json format (null object will be converted into "null" string).
 *
 * @param obj object.
 *
 * @return String or JsonException.
 *
 * @since 0.0.2.0
 */
fun toPrettyJson(obj: Any?): String {
    return try {
        OBJECT_WRITER.writeValueAsString(obj)
    } catch (e: Exception) {
        throw JsonException(e)
    }
}

/**
 * To convert object into string with json format (null object will be converted into "null" string).
 *
 * @param obj object.
 *
 * @return String or JsonException.
 *
 * @since 0.0.2.0
 */
fun toJson(obj: Any?): String {
    return try {
        OBJECT_MAPPER.writeValueAsString(obj)
    } catch (e: Exception) {
        throw JsonException(e)
    }
}

/**
 * To get object from Json.
 *
 * @param json json.
 * @param <T>  class.
 *
 * @return object.
 *
 * @since 0.0.2.0
 */
fun <T> fromJson(json: String?,
                 typeReference: TypeReference<T>): T {
    return try {
        OBJECT_MAPPER.readValue(json, typeReference)
    } catch (e: Exception) {
        throw JsonException(e)
    }
}

/**
 * To get object from Json.
 *
 * @param json json.
 * @param <T>  class.
 *
 * @return object.
 *
 * @since 0.0.2.0
 */
fun <T> fromJson(json: String?,
                 clazz: Class<T>): T {
    return try {
        OBJECT_MAPPER.readValue(json, clazz)
    } catch (e: Exception) {
        throw JsonException(e)
    }
}

/**
 * @since 0.0.2.0
 */
private class CustomJsonMapper : ObjectMapper() {
    init {
        registerKotlinModule()
        setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
//        setVisibility(PropertyAccessor.CREATOR, JsonAutoDetect.Visibility.ANY)
        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true)
        configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
        configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
        setSerializationInclusion(JsonInclude.Include.NON_NULL)
    }
}