package com.mixram.telegram.microservices.utilities.domain

/**
 * All plastics, that is using in the application.
 * @author mixram on 2020-02-04.
 * @since 0.0.1.0
 */
enum class PlasticType(val publicName: String) {
    /**
     * CoPET(PET-G).
     */
    COPET("COPET"),
    /**
     * Eco CoPET(PET-G).
     */
    ECO_COPET("E_CPT"),
    /**
     * ABS.
     */
    ABS("ABS"),
    /**
     * ABS+.
     */
    ABS_PLUS("ABS+"),
    /**
     * ABS ECO.
     */
    ABS_ECO("ABS-E"),
    /**
     * ABS FLEX.
     */
    ABS_FLEX("ABS-F"),
    /**
     * ABS PRO.
     */
    ABS_PRO("ABS-P"),
    /**
     * MBS.
     */
    MBS("MBS"),
    /**
     * ABS X.
     */
    ABS_X("ABS-X"),
    /**
     * ABS Premium.
     */
    ABS_P("ABS_P"),
    /**
     * ABS engineering.
     */
    ABS_E("ABS-E"),
    /**
     * PLA.
     */
    PLA("PLA"),
    /**
     * PLA PLUS.
     */
    PLA_PLUS("PLA+"),
    /**
     * APLA.
     */
    APLA("APLA"),
    /**
     * FLEX.
     */
    FLEX("FLEX"),
    /**
     * SAN.
     */
    SAN("SAN"),
    /**
     * PC.
     */
    PC("PC"),
    /**
     * PC+ABS.
     */
    PC_ABS("PC+A"),
    /**
     * HIPS.
     */
    HIPS("HIPS"),
    /**
     * Nylon.
     */
    NYLON("NYLON"),
    /**
     * ELASTAN.
     */
    ELASTAN("ELAST"),
    /**
     * PET.
     */
    PET("PET"),
    /**
     * PETG.
     */
    PETG("PETG"),
    /**
     * PA.
     */
    PA("PA"),
    /**
     * PA+.
     */
    PA_PLUS("PA+"),
    /**
     * PBT.
     */
    PBT("PBT"),
    /**
     * ASA.
     */
    ASA("ASA"),
    /**
     * PLA CCF.
     */
    PLA_CCF("PLA-F"),
    /**
     * PLA-CCU.
     */
    PLA_CCU("PLA-U"),
    /**
     * PLA-СG+.
     */
    PLA_CG_PLUS("PLA-G"),
    /**
     * Substandard.
     */
    SUBSTANDARD("SALE"),
    /**
     * Composite.
     */
    COMPO("COMP"),
    /**
     * Other.
     */
    OTHER("OTHER"),
    /**
     * ReZin.
     */
    REZIN("REZIN")
}
