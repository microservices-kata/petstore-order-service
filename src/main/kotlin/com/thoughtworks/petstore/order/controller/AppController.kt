package com.thoughtworks.petstore.order.controller

import com.google.common.collect.ImmutableMap
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping(value = "/app")
class AppController {

    @Value("\${app.lang}")
    var lang: String = ""

    @ApiOperation(value = "Show programing language")
    @RequestMapping(value = "/lang", method = arrayOf(RequestMethod.GET))
    @ResponseBody
    fun getLanguage(): Map<String, String> {
        return ImmutableMap.of("language", lang)
    }

}