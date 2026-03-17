package com.ipManager.ipManager.config.Exceptions

import com.ipManager.ipManager.commons.errorMessages.ErrorMessages

class NotFoundException(val error: ErrorMessages) : RuntimeException(error.message)