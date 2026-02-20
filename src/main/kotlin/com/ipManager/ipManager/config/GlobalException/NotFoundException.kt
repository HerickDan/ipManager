package com.ipManager.ipManager.config.GlobalException

import com.ipManager.ipManager.commons.errorMessages.ErrorMessages

class NotFoundException(message: ErrorMessages) : RuntimeException(message.name)