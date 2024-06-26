package com.github.computerhuis.dco.web.postal;

import com.github.computerhuis.dco.repository.PostalRepository;
import com.github.computerhuis.dco.repository.model.Postal;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/api/postcode")
@RestController
class PostalRestController {

    private final PostalRepository postalRepository;

    @GetMapping
    Map<String, List<Postal>> get() {
        val result = new HashMap<String, List<Postal>>();
        val data = postalRepository.findByPoboxFalse();
        result.put("data", data);

        return result;
    }
}
