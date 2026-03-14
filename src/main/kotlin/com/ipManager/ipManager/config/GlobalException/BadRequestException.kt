package com.ipManager.ipManager.config.GlobalException

import com.ipManager.ipManager.commons.errorMessages.ErrorMessages

class BadRequestException (val error: ErrorMessages) : RuntimeException(error.message)