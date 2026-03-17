package com.ipManager.ipManager.config.Exceptions

import com.ipManager.ipManager.commons.errorMessages.ErrorMessages

class ConflictException(val error: ErrorMessages) : RuntimeException(error.message)