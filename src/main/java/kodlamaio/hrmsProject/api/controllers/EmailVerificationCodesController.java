package kodlamaio.hrmsProject.api.controllers;

import kodlamaio.hrmsProject.business.validations.emailVerifications.EmailVerificationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/emailVerificationCodes")
public class EmailVerificationCodesController {
    private final EmailVerificationService emailVerificationService;

    public EmailVerificationCodesController(EmailVerificationService emailVerificationService) {
        this.emailVerificationService = emailVerificationService;
    }

    @PostMapping("/verifyEmail/{id}/{code}")
    public void verifyEmail(@PathVariable int id, @PathVariable String code){
        emailVerificationService.verifyEmail(id, code);
    }
}
