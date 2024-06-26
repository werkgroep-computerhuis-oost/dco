package com.github.computerhuis.dco.web.postal;

import com.github.computerhuis.dco.repository.PostalRepository;
import com.github.computerhuis.dco.repository.model.Postal;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Data
@ViewScoped
@Component
public class PostalCrudBean {

    private final PostalRepository postalRepository;

    private Postal postal;
    private String code;

    @PostConstruct
    public void init() {
        postal = new Postal();
    }

    public void fetch() {
        postal = postalRepository.findById(code).orElse(new Postal());
    }
}

