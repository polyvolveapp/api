package polyvolve.prototype.app.data.models.recentlyviewed

enum class RecentlyViewedType(val tableName: String) {
    TEAM("teams"),
    USER("users"),
    REVIEW_MASTER("review_masters"),
}