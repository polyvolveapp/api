package polyvolve.prototype.app.data.models.user

import com.fasterxml.jackson.annotation.JsonProperty

enum class Sex {
    @JsonProperty("male")
    MALE,
    @JsonProperty("female")
    FEMALE;
}