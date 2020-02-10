package com.mixram.telegram.microservices.utilities.databinding

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.type.TypeReference
import com.mixram.telegram.microservices.utilities.meta.ANSI_GREEN
import com.mixram.telegram.microservices.utilities.meta.ANSI_RESET
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import java.math.BigDecimal

/**
 * @author mixram on 2020-02-10.
 * @since 0.0.2.0
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class JsonUtilTests {

    // <editor-fold defaultstate="collapsed" desc="***API elements***">

    private val testPojo: JsonTest = JsonTest("test1", "test2", BigDecimal.TEN)


    private data class JsonTest(@JsonProperty("changedName") private val realName: String?,
                                private val realNameWithoutChange: String?,
                                @JsonProperty("salePrice") private val productSalePrice: BigDecimal?)

    // </editor-fold>

    @Nested
    inner class ToJsonTest {

        @Test
        fun `convert POJO into pretty-json string`() {
            val expected: String = """{
  "changedName" : "test1",
  "realNameWithoutChange" : "test2",
  "salePrice" : 10
}"""
            val actual: String = toPrettyJson(testPojo)

            assertThat(actual).isEqualTo(expected)

            println("$ANSI_GREEN OK $ANSI_RESET --- ${object : Any() {}.javaClass.enclosingMethod.name}")
        }

        @Test
        fun `convert POJO into json string`() {
            val expected: String = """{"changedName":"test1","realNameWithoutChange":"test2","salePrice":10}"""
            val actual: String = toJson(testPojo)

            assertThat(actual).isEqualTo(expected)

            println("$ANSI_GREEN OK $ANSI_RESET --- ${object : Any() {}.javaClass.enclosingMethod.name}")
        }
    }

    @Nested
    inner class FromJsonTest {

        @Test
        fun `create POJO from json string with Class`() {
            val expected: JsonTest = testPojo
            val actual: JsonTest = fromJson("""{"changedName":"test1","realNameWithoutChange":"test2","salePrice":10}""", JsonTest::class.java)

            assertThat(actual).isEqualTo(expected)

            println("$ANSI_GREEN OK $ANSI_RESET --- ${object : Any() {}.javaClass.enclosingMethod.name}")
        }

        @Test
        fun `create POJO from json string with TypeReference`() {
            val expected: JsonTest = testPojo
            val actual: JsonTest = fromJson("""{"changedName":"test1","realNameWithoutChange":"test2","salePrice":10}""",
                    object : TypeReference<JsonTest>() {})

            assertThat(actual).isEqualTo(expected)

            println("$ANSI_GREEN OK $ANSI_RESET --- ${object : Any() {}.javaClass.enclosingMethod.name}")
        }
    }
}