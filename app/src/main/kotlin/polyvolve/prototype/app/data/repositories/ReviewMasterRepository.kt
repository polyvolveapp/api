package polyvolve.prototype.app.data.repositories

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import polyvolve.prototype.app.data.models.review.master.ReviewMaster
import java.util.*

@Repository
interface ReviewMasterRepository : CrudRepository<ReviewMaster, UUID> {
    fun findAllByIteration(iteration: Int): Iterable<ReviewMaster>
}