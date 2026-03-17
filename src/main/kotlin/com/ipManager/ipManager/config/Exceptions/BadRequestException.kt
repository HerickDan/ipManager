package com.ipManager.ipManager.config.Exceptions

import com.ipManager.ipManager.commons.errorMessages.ErrorMessages

class BadRequestException (val error: ErrorMessages) : RuntimeException(error.message)