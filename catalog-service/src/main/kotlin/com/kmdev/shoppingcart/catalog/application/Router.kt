package com.kmdev.shoppingcart.catalog.application

import org.http4k.core.*
import org.http4k.core.Method.GET
import org.http4k.core.Method.POST
import org.http4k.lens.string
import org.http4k.routing.*

class Router {
    private val defaultResponse = Body.string(ContentType.TEXT_PLAIN).toLens()

    // static assets HTML, CSS, images, etc
    private val assetsHandler = static(ResourceLoader.Directory("assets"))

    // template handler
    private fun index(): HttpHandler {
        return {
            defaultResponse("Catalog service works!", Response(Status.OK))
        }
    }

    // creates application routes
    fun routes(): RoutingHttpHandler = routes(
        "/" bind GET to index(),
        "/assets" bind GET to assetsHandler
    )

}
