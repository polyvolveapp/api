package polyvolve.prototype.app.data.repositories

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import polyvolve.prototype.app.data.models.schema.ReviewCategory
import polyvolve.prototype.app.data.models.schema.ReviewCriterion
import java.util.*

@Repository
interface ReviewCriterionRepository : CrudRepository<ReviewCriterion, UUID> {
    fun findTopByCategoryOrderByOrderDesc(category: ReviewCategory): Optional<ReviewCriterion>
}