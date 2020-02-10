package com.mixram.telegram.microservices.utilities.databinding

/**
 * File to hold databinding exceptions.
 * @author mixram on 2020-02-07.
 * @since 0.0.2.0
 */

/**
 * @since 0.0.2.0
 */
class JsonException : RuntimeException {

    constructor() : super()
    constructor(message: String?) : super(message)
    constructor(message: String?, cause: Throwable?) : super(message, cause)
    constructor(cause: Throwable?) : super(cause)
    constructor(message: String?, cause: Throwable?, enableSuppression: Boolean, writableStackTrace: Boolean) :
            super(message, cause, enableSuppression, writableStackTrace)
}

/**
 * @since 0.0.2.0
 */
class XmlException : RuntimeException {

    constructor() : super()
    constructor(message: String?) : super(message)
    constructor(message: String?, cause: Throwable?) : super(message, cause)
    constructor(cause: Throwable?) : super(cause)
    constructor(message: String?, cause: Throwable?, enableSuppression: Boolean, writableStackTrace: Boolean) :
            super(message, cause, enableSuppression, writableStackTrace)
}