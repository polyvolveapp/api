package polyvolve.prototype.app.controllers

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.security.core.Authentication
import org.springframework.validation.beanvalidation.SpringValidatorAdapter
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import polyvolve.prototype.app.services.AdminService
import polyvolve.prototype.app.util.OkResponseEntity
import polyvolve.prototype.app.util.defaultOkResponse
import polyvolve.prototype.app.util.exceptions.AuthException

@RestController
@RequestMapping("/admin")
class AdminController(val adminService: AdminService,
                      var validator: SpringValidatorAdapter) {
    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @PostMapping("/own")
    fun getOwn(principal: Authentication?): OkResponseEntity {
        if (principal == null) throw AuthException("Not logged in.")

        val admin = adminService.getAdmin(principal.name)
                ?: throw AuthException("Unknown user.")

        return defaultOkResponse(admin)
    }
}