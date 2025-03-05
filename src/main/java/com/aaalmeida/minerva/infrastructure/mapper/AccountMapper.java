package com.aaalmeida.minerva.infrastructure.mapper;

import com.aaalmeida.minerva.domain.model.Account;
import com.aaalmeida.minerva.infrastructure.entity.AccountEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountEntity toEntity(Account account);
    Account toDomain(AccountEntity accountEntity);
}
