package com.github.computerhuis.dco.web.postal;

import com.github.computerhuis.dco.repository.PostalRepository;
import com.github.computerhuis.dco.repository.model.Equipment;
import com.github.computerhuis.dco.repository.model.Postal;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Data
@Component
public class PostalListBean {

    private final PostalRepository postalRepository;

    private List<Postal> list;
    private Equipment selected;

    @PostConstruct
    public void init() {
        list = postalRepository.findAll();
    }

}
