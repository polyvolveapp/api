package polyvolve.prototype.app.data.repositories

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import polyvolve.prototype.app.data.models.admin.Admin
import java.util.*

@Repository
interface AdminRepository : CrudRepository<Admin, UUID> {
    fun findByMail(mail: String): Optional<Admin>
}