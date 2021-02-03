package me.cocoding.openapi.service.user;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@SQLDelete(sql = "UPDATE users SET deleted_at=CURRENT_TIMESTAMP WHERE `user_id`=?")
@Where(clause = "deleted_at IS NULL")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String email;
    private String stdNum;

    private String clientId;
    private String clientSecret;
}
