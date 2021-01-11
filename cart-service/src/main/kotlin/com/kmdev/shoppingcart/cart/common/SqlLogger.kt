package com.kmdev.shoppingcart.cart.common

import org.jdbi.v3.core.statement.SqlLogger
import org.jdbi.v3.core.statement.StatementContext
import org.slf4j.LoggerFactory

class SqlLogger : SqlLogger {
    private val logger = LoggerFactory.getLogger(javaClass)

    override fun logBeforeExecution(context: StatementContext) {
        logger.debug(context.renderedSql)
    }
}
