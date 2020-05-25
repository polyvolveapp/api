package polyvolve.prototype.api.config

import org.springframework.boot.web.server.ConfigurableWebServerFactory
import org.springframework.boot.web.server.WebServerFactoryCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.DriverManagerDataSource
import javax.sql.DataSource

@Configuration
class ServerConfig : WebServerFactoryCustomizer<ConfigurableWebServerFactory> {
    override fun customize(factory: ConfigurableWebServerFactory) {
        val port = System.getenv()["PORT"]?.toInt() ?: 8080

        factory.setPort(port)
    }

    @Bean
    fun dataSource(): DataSource {
        val dataSource = DriverManagerDataSource()

        val herokuDatabaseUrl = System.getenv()["DATABASE_URL"]
        if (herokuDatabaseUrl != null) {
            dataSource.url = herokuDatabaseUrl
        } else {
            dataSource.url = "jdbc:postgresql://localhost:5432/polyvolve?ssl=false"
            dataSource.username = "poly"
            dataSource.password = "vITM9ZxUaaMfI7hmJ6Ki"
        }

        return dataSource
    }
}