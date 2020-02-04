package com.mixram.telegram.microservices.utilities.logging

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import kotlin.reflect.KClass
import kotlin.reflect.full.companionObject

/**
 * https://stackoverflow.com/questions/34416869/idiomatic-way-of-logging-in-kotlin#answer-34462577
 * @author mixram on 2020-02-04.
 * @since 0.0.1.0
 */

/**
 * Return logger for Java class, if companion object fix the name
 * @since 0.0.1.0
 */
fun <T : Any> logger(forClass: Class<T>): Logger = LogManager.getLogger(unwrapCompanionClass(forClass).name)

/**
 * Unwrap companion class to enclosing class given a Java Class.
 * @since 0.0.1.0
 */
fun <T : Any> unwrapCompanionClass(ofClass: Class<T>): Class<*> =
        ofClass.enclosingClass?.takeIf { ofClass.enclosingClass.kotlin.companionObject?.java == ofClass } ?: ofClass

/**
 * Unwrap companion class to enclosing class given a Kotlin Class.
 * @since 0.0.1.0
 */
fun <T : Any> unwrapCompanionClass(ofClass: KClass<T>): KClass<*> = unwrapCompanionClass(ofClass.java).kotlin

/**
 * Return logger for Kotlin class.
 * @since 0.0.1.0
 */
fun <T : Any> logger(forClass: KClass<T>): Logger = logger(forClass.java)

/**
 * Return logger from extended class (or the enclosing class).
 * @since 0.0.1.0
 */
fun <T : Any> T.logger(): Logger = logger(this.javaClass)

/**
 * Return a lazy logger property delegate for enclosing class.
 * @since 0.0.1.0
 */
fun <R : Any> R.lazyLogger(): Lazy<Logger> = lazy { logger(this.javaClass) }

/**
 * Return a logger property delegate for enclosing class.
 * @since 0.0.1.0
 */
fun <R : Any> R.injectLogger(): Lazy<Logger> = lazyOf(logger(this.javaClass))