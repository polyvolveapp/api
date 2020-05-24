package polyvolve.prototype.app.data.repositories

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import polyvolve.prototype.app.data.models.admin.Admin
import polyvolve.prototype.app.data.models.admin.MarkedUser
import java.util.*

@Repository
interface MarkedUserRepository : CrudRepository<MarkedUser, UUID> {
    fun findAllByAdmin(admin: Admin): Iterable<MarkedUser>
}