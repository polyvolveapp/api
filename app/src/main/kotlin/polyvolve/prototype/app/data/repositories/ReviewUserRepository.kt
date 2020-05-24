package polyvolve.prototype.app.data.repositories

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import polyvolve.prototype.app.data.models.user.User
import polyvolve.prototype.app.data.models.review.Review
import polyvolve.prototype.app.data.models.review.user.ReviewUser
import java.util.*

@Repository
interface ReviewUserRepository : CrudRepository<ReviewUser, UUID> {
    fun findAllByReview(review: Review): Iterable<ReviewUser>
    fun findAllByReviewedUser(user: User): Iterable<ReviewUser>
    fun findByReviewAndReviewedUser(review: Review, user: User): Optional<ReviewUser>
}