package ucl.ac.uk.ibmpsmwithwatson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ucl.ac.uk.ibmpsmwithwatson.pojo.dto.TemplateQueryDTO;
import ucl.ac.uk.ibmpsmwithwatson.pojo.vo.Page;
import ucl.ac.uk.ibmpsmwithwatson.pojo.po.Template;
import ucl.ac.uk.ibmpsmwithwatson.service.TemplateService;
import ucl.ac.uk.ibmpsmwithwatson.pojo.vo.Result;

@RestController
@RequestMapping("/templates")
public class TemplateController {

    @Autowired
    TemplateService templateService;

    @PostMapping("/get")
    public Result<?> getTemplates(@RequestBody TemplateQueryDTO dto) {
        Page page = templateService.getTemplates(dto);
        return Result.success(page);
    }

    @PostMapping
    public Result<?> insert(@RequestBody Template template) {
        templateService.insert(template);
        return Result.success();
    }

    @PutMapping
    public Result<?> update(@RequestBody Template template) {
        templateService.update(template);
        return Result.success();
    }

    @DeleteMapping("/{templateId}")
    public Result<?> delete(@PathVariable String templateId) {
        templateService.delete(templateId);
        return Result.success();
    }
}
