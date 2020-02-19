package com.mixram.telegram.microservices.utilities.domain

import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal

/**
 * Holder for data been parsed from HTML-page.
 *
 * @author mixram on 2020-02-04.
 * @since 0.0.1.0
 */
data class ParseData(@JsonProperty("title") val pageTitle: String? = null,
                     @JsonProperty("name") val productName: String? = null,
                     @JsonProperty("url") val productUrl: String? = null,
                     @JsonProperty("commonUrl") val commonUrl: String? = null,
                     @JsonProperty("shopUrl") val shopUrl: String? = null,
                     @JsonProperty("oldPrice") val productOldPrice: BigDecimal? = null,
                     @JsonProperty("salePrice") val productSalePrice: BigDecimal? = null,
                     @JsonProperty("percent") val productDiscountPercent: BigDecimal? = null,
                     @JsonProperty("type") val type: PlasticType? = null,
                     @JsonProperty("inStock") val isInStock: Boolean? = null)

/**
 * @since 0.0.3.0
 */
data class Data3DPlastic(var shop: Shop3D,
                         val data: List<ParseData>,
                         val brokenUrls: List<ParseData>)