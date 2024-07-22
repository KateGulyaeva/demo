package com.examplemvc.demo;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public abstract class AbstractEmailContext {
    private String from;
    private String to;
    private String subject;
    private String email;
    private String attachment;
    private String fromDisplayName;
    private String emailLanguage;
    private String displayName;
    private String templateLocation; // шаблон в html
    private Map <String, Object> context; 

}
