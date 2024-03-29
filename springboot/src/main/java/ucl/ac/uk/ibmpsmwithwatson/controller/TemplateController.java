package ucl.ac.uk.ibmpsmwithwatson.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ucl.ac.uk.ibmpsmwithwatson.pojo.dto.TemplateQueryDTO;
import ucl.ac.uk.ibmpsmwithwatson.util.Page;
import ucl.ac.uk.ibmpsmwithwatson.pojo.po.Template;
import ucl.ac.uk.ibmpsmwithwatson.service.TemplateService;
import ucl.ac.uk.ibmpsmwithwatson.util.Result;

@Api(tags = "Healthcare Template")
@RestController
@RequestMapping("/templates")
public class TemplateController {

    @Autowired
    TemplateService templateService;

    @GetMapping("/number/{doctorId}")
    public Result<?> getNumberOfTemplatesByDoctorId(@PathVariable String doctorId) {
        return Result.success(templateService.getNumberOfTemplatesByDoctorId(doctorId));
    }

    @PostMapping("/get")
    public Result<?> getTemplates(@RequestBody TemplateQueryDTO dto) {
        Page page = templateService.getTemplates(dto);
        return Result.success(page);
    }

    @PostMapping
    public Result<?> insertTemplate(@RequestBody Template template) {
        templateService.insertTemplate(template);
        return Result.success();
    }

    @PutMapping
    public Result<?> updateTemplate(@RequestBody Template template) {
        templateService.updateTemplate(template);
        return Result.success();
    }

    @DeleteMapping("/{templateId}")
    public Result<?> deleteTemplate(@PathVariable String templateId) {
        templateService.deleteTemplate(templateId);
        return Result.success();
    }
}
