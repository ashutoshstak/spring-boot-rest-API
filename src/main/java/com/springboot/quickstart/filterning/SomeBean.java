package com.springboot.quickstart.filterning;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RestController;


@Getter
@JsonFilter("SomeFilter")
public class SomeBean {
    private  String field1;
    private  String field2;
    private  String field3;

    public SomeBean(String field1, String field2, String field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }
}
