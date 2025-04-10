package com.aaalmeida.minerva.infrastructure.entity;

import com.aaalmeida.minerva.domain.model.Follow;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Node("AUTHOR")
public class AuthorEntity {
    @Id
    private UUID uuid;

    /**
     * Only letters, space and apostrophe
     */
//    @NotEmpty(message = "Name is required")
//    @Pattern(regexp = "([a-zA-Z]|[à-ü]|[À-Ü])+([a-zA-Z]|[à-ü]|[À-Ü]| |')*")
    private String name;

//    @Pattern(regexp = "([a-zA-Z]|[à-ü]|[À-Ü])+([a-zA-Z]|[à-ü]|[À-Ü]| |')*")
    private String middleName;

//    @NotEmpty(message = "Last name is required")
//    @Pattern(regexp = "([a-zA-Z]|[à-ü]|[À-Ü])+([a-zA-Z]|[à-ü]|[À-Ü]| |')*")
    private String lastName;

//    @Email(message = "Must be a valid email")
    private String email;

    /**
     * Must be:
     * At least 12 characters
     * At least one lowercase letter
     * At least one uppercase letter
     * At least one number
     * At least one character from this list: !@#$%¨&*=+\-_()'"\/|?
     * Cannot contain spaces
     */
//    @Pattern(regexp = "^(?=.*[a-z].*)(?=.*[A-Z].*)(?=.*\\d.*)(?=.*[!@#$%¨&*=+\\-_()'\"\\\\\\/|?].*)[^ ]{12,}$")
    private String password;

    /**
     * protocol http:// or https:// is optional
     * subdomain www is optional
     * domain must contain between 1 and 256 letters or numbers
     * path is optional
     */
//    @Pattern(regexp = "^((https:\\/\\/)|(http:\\/\\/))?(www\\.)?[\\w]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&//=]*)$")
    private String url;

    /**
     * Between 9 and 12 numbers
     */
//    @Pattern(regexp = "^(\\d{1,3})?(\\d){9}$")
    private String phone;

//    @NotNull
    private Boolean isRegistered;

    @Relationship(type = "FOLLOW")
    private List<Follow> follows;

    @Relationship(type = "FOLLOWED_BY")
    private List<Follow> followedBy;
}
