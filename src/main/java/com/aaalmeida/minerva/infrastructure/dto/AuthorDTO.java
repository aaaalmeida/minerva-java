package com.aaalmeida.minerva.infrastructure.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.Set;
import java.util.UUID;

public record AuthorDTO(
        UUID uuid,

        /**
         * Only letters, space and apostrophe
         */
        @NotBlank
        @Pattern(regexp = "^[A-Za-zÀ-ÖØ-öø-ÿ' ]+$", message = "Invalid name.")
        String name,

        @Nullable
        @Pattern(regexp = "^[A-Za-zÀ-ÖØ-öø-ÿ' ]+$", message = "Invalid middle name.")
        String middleName,

        @NotBlank
        @Pattern(regexp = "^[A-Za-zÀ-ÖØ-öø-ÿ' ]+$", message = "Invalid last name.")
        String lastName,

        @Email
        String email,

        /**
         * Must be:
         * At least 12 characters
         * At least one lowercase letter
         * At least one uppercase letter
         * At least one number
         * At least one character from this list: !@#$%¨&*=+\-_()'"\/|?
         * Cannot contain spaces
         */
        @NotBlank
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%¨&*=+\\-_()'\"\\\\/|?])[A-Za-z\\d!@#$%¨&*=+\\-_()'\"\\\\/|?]{12,}$",
                message = "Invalid password")
        String password,

        /**
         * protocol http:// or https:// is optional
         * subdomain www is optional
         * domain must contain between 1 and 256 letters or numbers
         * path is optional
         */
        @Nullable
        @Pattern(regexp = "^(https?://)?(www\\.)?[a-zA-Z0-9]{1,256}(\\.[a-zA-Z]{2,})(/.*)?$",
                message = "Invalid URL")
        String url,

        @Nullable
        @Pattern(regexp = "^((\\+55\\s?)|(55\\s?)?)?\\(?\\d{2}\\)?[\\s-]?\\d{4,5}[\\s-]?\\d{4}$",
                message = "Invalid phone. Ex: +55 (11) 91234-5678 ou 11912345678")
        String phone,
        Set<FollowDTO> follows
) {
}
