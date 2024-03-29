package ucl.ac.uk.ibmpsmwithwatson.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ucl.ac.uk.ibmpsmwithwatson.service.SpeechToTextService;
import ucl.ac.uk.ibmpsmwithwatson.util.Result;

@Api(tags = "IBM Speech to Text")
@RestController
@RequestMapping("/stt")
public class SpeechToTextController {

    @Autowired
    SpeechToTextService speechToTextService;

    @PostMapping("/transcript")
    public Result<?> getTranscriptByWavFile(MultipartFile file) {
        try {
            return Result.success(speechToTextService.getTranscriptByWavFile(file));
        } catch (Exception e) {
            return Result.error("10003", e.getMessage());
        }
    }
}
