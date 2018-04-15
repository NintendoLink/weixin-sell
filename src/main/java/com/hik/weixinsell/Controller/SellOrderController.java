package com.hik.weixinsell.Controller;

import com.hik.weixinsell.DTO.OrderDTO;
import com.hik.weixinsell.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping(value = "/sell/order")
public class SellOrderController {
    @Autowired
    private OrderServiceImpl orderService;
    @GetMapping(value = "/list")
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1") Integer page,
                             @RequestParam(value = "size",defaultValue = "10") Integer size,
                             Map<String,Object> map){
        PageRequest pageRequest=new PageRequest(page-1,size);
        Page<OrderDTO> orderDTOPage=orderService.findList(pageRequest);

        map.put("/orderDTOPAge",orderDTOPage);
        return new ModelAndView("order/list",map);
    }
}
