package com.ipManager.ipManager.commons.errorMessages

enum class ErrorMessages(val message:String) {
    NOT_FOUND_EXCEPTION("Beneficiary not found"),
    BAD_REQUEST_EXCEPTION("Some parameter is missing"),
    QUANTITY_EXCEEDS("Requested quantity exceeds available stock"),
    BASKETS_NOT_FOUND("No baskets founded")
}