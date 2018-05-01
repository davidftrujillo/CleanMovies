package com.dft3dev.data.exceptions

/**
 * Created by david on 1/5/18.
 */
class NotAvailableOperationException(private val operation: String? = null): Exception() {

    override val message: String?
        get() = "Operation $operation is not available"
}