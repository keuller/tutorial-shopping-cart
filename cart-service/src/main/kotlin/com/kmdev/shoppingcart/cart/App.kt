package com.kmdev.shoppingcart.cart

import com.kmdev.shoppingcart.cart.application.Router
import com.kmdev.shoppingcart.cart.common.Database
import org.http4k.cloudnative.health.Health
import org.http4k.server.Netty
import org.http4k.server.asServer
import org.slf4j.LoggerFactory

fun main() {
    val HTTP_PORT = System.getenv().getOrDefault("APP_PORT", "8080")
    val logger = LoggerFactory.getLogger("com.kmdev.shoppingcart.cart.Application")

    // health check endpoints (liveness & readiness)
    val app = Health(Router().routes())

    // creates app server based on routes
    val server = app.asServer(Netty(HTTP_PORT.toInt()))
    server.start()

    Database.init()

    // register runtime hook to stop server
    Runtime.getRuntime().addShutdownHook(Thread { server.stop() })

    logger.info("Cart service has been started at http://0.0.0.0:${server.port()}")
}
