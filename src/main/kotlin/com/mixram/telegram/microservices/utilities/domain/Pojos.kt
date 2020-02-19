package com.mixram.telegram.microservices.utilities.domain

import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal

/**
 * Holder for data been parsed from HTML-page.
 *
 * @author mixram on 2020-02-04.
 * @since 0.0.1.0
 */
data class ParseData(@JsonProperty("title") private val pageTitle: String? = null,
                     @JsonProperty("name") private val productName: String? = null,
                     @JsonProperty("url") private val productUrl: String? = null,
                     @JsonProperty("commonUrl") private val commonUrl: String? = null,
                     @JsonProperty("shopUrl") private val shopUrl: String? = null,
                     @JsonProperty("oldPrice") private val productOldPrice: BigDecimal? = null,
                     @JsonProperty("salePrice") private val productSalePrice: BigDecimal? = null,
                     @JsonProperty("percent") private val productDiscountPercent: BigDecimal? = null,
                     @JsonProperty("type") private val type: PlasticType? = null,
                     @JsonProperty("inStock") private val isInStock: Boolean? = null)

/**
 * @since
 */
data class Data3DPlastic()