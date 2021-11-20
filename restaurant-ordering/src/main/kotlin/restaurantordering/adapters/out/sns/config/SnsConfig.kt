package restaurantordering.adapters.out.sns.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider
import software.amazon.awssdk.awscore.client.builder.AwsClientBuilder
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.sns.SnsClient

@Configuration
class SnsConfig(
    val newOrderEventProperties: NewOrderEventProperties
) {

    @Bean
    fun snsClient(): SnsClient {
        return SnsClient.builder()
            .credentialsProvider(
                StaticCredentialsProvider.create(
                    AwsBasicCredentials.create(
                        newOrderEventProperties.accessKey,
                        newOrderEventProperties.secretKey
                    )
                )
            )
            .region(Region.of(newOrderEventProperties.region))
            .build()
    }
}


@ConstructorBinding
@ConfigurationProperties(prefix = "aws.sns.new-order")
data class NewOrderEventProperties(
    val endpoint: String,
    val region: String,
    val accessKey: String,
    val secretKey: String,
    val topic: String
)

@Configuration
@EnableConfigurationProperties(NewOrderEventProperties::class)
class SNSAutoConfiguration