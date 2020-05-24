package polyvolve.prototype.app.data.repositories

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import polyvolve.prototype.app.data.models.review.user.ReviewUser
import polyvolve.prototype.app.data.models.review.value.ReviewCriterionValueObject
import polyvolve.prototype.app.data.models.schema.ReviewCriterion
import java.util.*

@Repository
interface ReviewCriterionValueRepository : CrudRepository<ReviewCriterionValueObject, UUID> {
    fun findByReviewUserAndCriterion(reviewUser: ReviewUser, criterion: ReviewCriterion): Optional<ReviewCriterionValueObject>
    fun findByReviewUser(reviewUser: ReviewUser): Iterable<ReviewCriterionValueObject>
}