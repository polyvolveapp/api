package polyvolve.prototype.app.controllers

import org.springframework.security.core.Authentication
import org.springframework.validation.beanvalidation.SpringValidatorAdapter
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import polyvolve.prototype.app.services.AdminService
import polyvolve.prototype.app.services.RecentlyViewedService
import polyvolve.prototype.app.util.OkResponseEntity
import polyvolve.prototype.app.util.defaultOkResponse
import polyvolve.prototype.app.util.exceptions.AuthException
import java.util.*

@RestController
@RequestMapping("/recentlyviewed")
class RecentlyViewedController(val recentlyViewedService: RecentlyViewedService,
                               val adminService: AdminService,
                               var validator: SpringValidatorAdapter) {
    @GetMapping("/all")
    fun getAllRecentlyViewedItems(principal: Authentication?): OkResponseEntity {
        if (principal == null) throw AuthException("Not logged in.")

        val admin = adminService.getAdmin(principal.name)
                ?: throw AuthException("Unknown user.")

        return defaultOkResponse(recentlyViewedService.getRecentForAdminWithNames(admin))
    }

    @GetMapping("/get/{recentlyViewedItemId}")
    fun getRecentlyViewedItem(@PathVariable recentlyViewedItemId: UUID): OkResponseEntity {
        val recentlyViewedItem = recentlyViewedService.get(recentlyViewedItemId)
                ?: throw IllegalArgumentException("RecentlyViewed item with criterion $recentlyViewedItemId doesn't exist")

        return defaultOkResponse(recentlyViewedItem)
    }
}