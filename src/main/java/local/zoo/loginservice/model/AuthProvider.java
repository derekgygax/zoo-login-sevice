package local.zoo.loginservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.Instant;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "auth_provider")
public class AuthProvider {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "zoo_user_id", referencedColumnName = "id", nullable = false)
    private ZooUser zooUser;

    @ManyToOne
    // can NOT delete an authType if being used in a provider
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "auth_type_id", referencedColumnName = "id", nullable = false)
    private AuthType authType;

    @Column(name = "provider_id", nullable = false)
    private String providerId;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE")
    // Use Instant for UTC timestamps
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    // Use Instant for UTC timestamps
    private Instant updatedAt;

    public AuthProvider() {
    }

    public AuthProvider(ZooUser zooUser, AuthType authType, String providerId) {
        this.zooUser = zooUser;
        this.authType = authType;
        this.providerId = providerId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ZooUser getUser() {
        return zooUser;
    }

    public void setUser(ZooUser zooUser) {
        this.zooUser = zooUser;
    }

    public AuthType getAuthType() {
        return authType;
    }

    public void setAuthType(AuthType authType) {
        this.authType = authType;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "AuthProvider [id=" + id + ", zooUser=" + zooUser + ", authType=" + authType + ", providerId="
                + providerId
                + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
    }

}
