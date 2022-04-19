package com.example.onlineMagazin.controller.feedback;

import com.example.onlineMagazin.controller.AbstractController;
import com.example.onlineMagazin.dto.feedback.FeedbackCreateDto;
import com.example.onlineMagazin.entity.feedback.Feedback;
import com.example.onlineMagazin.response.Response;
import com.example.onlineMagazin.service.feedback.FeedbackService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FeedbackController extends AbstractController<FeedbackService> {

    public FeedbackController(FeedbackService service) {
        super(service);
    }

    @RequestMapping(value = PATH + "/feedback/list", method = RequestMethod.GET)
    public ResponseEntity<List<Feedback>> getAll() {
        return service.getAll();
    }

    @RequestMapping(value = PATH + "/feedback/{id}", method = RequestMethod.GET)
    public ResponseEntity<Feedback> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @RequestMapping(value = PATH + "/feedback/delete/{id}", method = RequestMethod.GET)
    public ResponseEntity<Response> delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @RequestMapping(value = PATH + "/feedback/create", method = RequestMethod.POST)
    public ResponseEntity<Response> create(@RequestBody FeedbackCreateDto feedbackCreateDto) {
        return service.create(feedbackCreateDto);
    }
}
