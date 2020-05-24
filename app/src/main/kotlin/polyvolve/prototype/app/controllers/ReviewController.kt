package polyvolve.prototype.app.controllers

import org.springframework.http.MediaType
import org.springframework.validation.BindingResult
import org.springframework.validation.beanvalidation.SpringValidatorAdapter
import org.springframework.web.bind.annotation.*
import polyvolve.prototype.app.data.repositories.ReviewRepository
import polyvolve.prototype.app.services.AdminService
import polyvolve.prototype.app.services.DataHashService
import polyvolve.prototype.app.services.RecentlyViewedService
import polyvolve.prototype.app.services.ReviewService
import polyvolve.prototype.app.util.OkResponseEntity
import polyvolve.prototype.app.util.defaultOkResponse
import polyvolve.prototype.app.util.validateAndThrow
import java.util.*
import javax.validation.constraints.NotNull

/**
 * PathVariables are messed up. Also this is by no means secured.
 */
@RestController
@RequestMapping("/review")
class ReviewController(val reviewService: ReviewService,
                       val adminService: AdminService,
                       val dataHashService: DataHashService,
                       val recentlyViewedService: RecentlyViewedService,
                       val reviewRepository: ReviewRepository,
                       var validator: SpringValidatorAdapter) {
    @PostMapping("/get/{reviewId}", consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun getReview(@PathVariable reviewId: UUID): OkResponseEntity {
        val id = reviewService.getReview(reviewId)
                ?: throw IllegalArgumentException("Unknown reviewId $reviewId")

        return defaultOkResponse(id)
    }

    /**
     * This endpoint is called when the user visits the link for the ReviewMaster for the first time.
     */
    @PostMapping("/create", consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun createReview(@RequestBody body: CreateReviewForm, bindingResult: BindingResult): OkResponseEntity {
        validator.validateAndThrow(body, bindingResult)

        val id = reviewService.createReview(body.userId!!, body.reviewMasterId!!)

        return defaultOkResponse(id)
    }

    @GetMapping("/all/user/{userId}", consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun getAll(@PathVariable userId: String): OkResponseEntity {
        return defaultOkResponse(reviewService.getAllReviewsByUser(userId))
    }

    /**
     * This endpoint is called when the user visits the User review page for the first time.
     */
    @PostMapping("/user/create", consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun createReviewUser(@RequestBody body: CreateReviewUserForm, bindingResult: BindingResult): OkResponseEntity {
        validator.validateAndThrow(body, bindingResult)
        val id = reviewService.createReviewUser(body.reviewId!!, body.userId!!)

        return defaultOkResponse(id)
    }

    @GetMapping("/user/all/review/{reviewId}", consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllReviewUsers(@PathVariable reviewId: String): OkResponseEntity {
        return defaultOkResponse(reviewService.getAllReviewUsers(reviewId))
    }

    @GetMapping("/user/get/{reviewUserId}")
    fun getReviewUser(@PathVariable reviewUserId: UUID): OkResponseEntity {
        val user = reviewService.getReviewUser(reviewUserId)
                ?: throw IllegalArgumentException("ReviewUser with criterion $reviewUserId doesn't exist")

        return defaultOkResponse(user)
    }

    class CreateReviewForm {
        @field:NotNull
        var reviewMasterId: UUID? = null
        @field:NotNull
        var userId : UUID? = null
    }

    class CreateReviewUserForm {
        @field:NotNull
        var userId: UUID? = null
        @field:NotNull
        var reviewId: UUID? = null
    }
}