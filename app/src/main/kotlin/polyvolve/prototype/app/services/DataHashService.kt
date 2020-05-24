package polyvolve.prototype.app.services

import org.springframework.stereotype.Service
import polyvolve.prototype.app.data.models.DataHash
import polyvolve.prototype.app.data.models.review.master.ReviewMaster
import polyvolve.prototype.app.data.models.user.User
import polyvolve.prototype.app.data.repositories.DataHashRepository
import java.util.*

@Service
class DataHashService(private var dataHashRepository: DataHashRepository) {
    fun createDataHash(reviewMaster: ReviewMaster, user: User): DataHash {
        val dataHash = DataHash(reviewMaster, user)

        return dataHashRepository.save(dataHash)
    }

    fun getDataHash(dataHashId: UUID): DataHash? = dataHashRepository.findById(dataHashId).orElse(null)
}