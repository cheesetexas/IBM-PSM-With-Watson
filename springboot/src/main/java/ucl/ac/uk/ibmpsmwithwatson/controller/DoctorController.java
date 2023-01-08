package ucl.ac.uk.ibmpsmwithwatson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ucl.ac.uk.ibmpsmwithwatson.entity.Page;
import ucl.ac.uk.ibmpsmwithwatson.service.DoctorService;
import ucl.ac.uk.ibmpsmwithwatson.util.Result;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @GetMapping("/patients")
    public Result<?> getPatientsList(@RequestParam(defaultValue = "") String givenName,
                                     @RequestParam(defaultValue = "") String familyName,
                                     @RequestParam(defaultValue = "0") Integer pageNum,
                                     @RequestParam(defaultValue = "10") Integer pageSize) {
        Page patients = doctorService.getPatients(givenName, familyName, pageNum, pageSize);
        return Result.success(patients);
    }
}
