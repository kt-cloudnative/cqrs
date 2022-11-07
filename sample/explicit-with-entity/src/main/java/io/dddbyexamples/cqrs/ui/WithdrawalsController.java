package io.dddbyexamples.cqrs.ui;

import java.util.List;
import java.util.UUID;

import javax.websocket.server.PathParam;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.dddbyexamples.cqrs.model.Withdrawal;
import io.dddbyexamples.cqrs.persistence.WithdrawalRepository;
import io.dddbyexamples.cqrs.service.WithdrawalService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/withdrawals")
@RequiredArgsConstructor
class WithdrawalsController {

    private final WithdrawalRepository withdrawalRepository;
    private final WithdrawalService withdrawalService;

    @PostMapping
    ResponseEntity<?> withdraw(@RequestBody WithdrawalCommand withdrawalCommand) {
        withdrawalService.withdraw(withdrawalCommand.getCard(), withdrawalCommand.getAmount());
        return ResponseEntity.ok().build();
    }

    @GetMapping
    ResponseEntity<List<Withdrawal>> withdrawals(@PathParam("cardId") String cardId) {
        return ResponseEntity.ok().body(withdrawalRepository.findByCardId(UUID.fromString(cardId)));
    }
}

