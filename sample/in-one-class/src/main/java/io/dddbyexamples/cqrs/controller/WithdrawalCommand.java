package io.dddbyexamples.cqrs.controller;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WithdrawalCommand {
    private UUID cardId;
    private long amount;

}
