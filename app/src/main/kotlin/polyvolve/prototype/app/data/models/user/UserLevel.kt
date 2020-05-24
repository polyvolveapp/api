package polyvolve.prototype.app.data.models.user

import com.fasterxml.jackson.annotation.JsonProperty

enum class UserLevel {
    @JsonProperty("lowly")
    LOWLY_LEADER,
    @JsonProperty("none")
    EMPLOYEE
}