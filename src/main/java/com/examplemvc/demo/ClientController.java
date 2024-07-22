package com.examplemvc.demo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientController {

    @Autowired
    private ClientService ClientService;

    // используется для вывода списка клиентов
    @RequestMapping("/")
    public ModelAndView client_list() {
        List<client> list_client = ClientService.listAll();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("list_client", list_client);
        return mav;
    }

    // создание нового клиента (используется на сайте) -> регистрация
    @RequestMapping("/new")
    public String newClient(Map<String, Object> model) {
        client client = new client();
        model.put("client", client);
        ClientService.save(client);
        return "new_client";
    }

    // изменения данных о клиенте (update в БД)
    @RequestMapping("/edit")
    public ModelAndView editClientForm(@RequestParam int id_client) {
        ModelAndView mav = new ModelAndView("edit_client");
        client client = ClientService.get(id_client);
        mav.addObject("client", client);
        return mav;
    }

    // удаление клиента
    @RequestMapping("/delete")
    public String deleteClientForm(@RequestParam int id_client) {
        ClientService.delete(id_client);
        return "redirect:/";       
    }
    // поиск клиента по какому - нибудь признаку
    @RequestMapping("/search")
    public ModelAndView search(@RequestParam String keyword) {
        List<client> result = ClientService.search(keyword);
        ModelAndView mav = new ModelAndView("search");
        mav.addObject("result", result);
        return mav;    
    }
 
}
