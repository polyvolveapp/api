package polyvolve.prototype.app.data.repositories

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import polyvolve.prototype.app.data.models.schema.ReviewSchema
import java.util.*

@Repository
interface ReviewSchemaRepository : CrudRepository<ReviewSchema, UUID> {
}