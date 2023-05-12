package kodlamaio.hrmsProject.api.controllers;

import kodlamaio.hrmsProject.business.services.validations.hrmsEmployeeConfirms.HrmsEmployeeConfirmService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hrmsEmployeeConfirms")
public class HrmsEmployeeConfirmsController {
    private final HrmsEmployeeConfirmService hrmsEmployeeConfirmService;

    public HrmsEmployeeConfirmsController(HrmsEmployeeConfirmService hrmsEmployeeConfirmService) {
        this.hrmsEmployeeConfirmService = hrmsEmployeeConfirmService;
    }

    @PostMapping("/confirmCompany")
    public void confirmCompany(@RequestParam int hrmsEmployeeId, @RequestParam int companyId){
        hrmsEmployeeConfirmService.confirmCompany(hrmsEmployeeId, companyId);
    }
}
