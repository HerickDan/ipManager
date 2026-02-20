package com.ipManager.ipManager.config.GlobalException

import com.ipManager.ipManager.commons.errorMessages.ErrorMessages

class NotFoundException(val error: ErrorMessages) : RuntimeException(error.message)