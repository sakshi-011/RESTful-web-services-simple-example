package com.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;

@RestController
public class UserInfoRepository {

    private MappingJacksonValue addMapping(Object userInfo, String filterList){
        MappingJacksonValue mapping = new MappingJacksonValue(userInfo);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(filterList.split(","));
        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfoFilter",filter);
        mapping.setFilters(filters);
        return mapping;
    }

    @GetMapping("/filtered/user")
    public MappingJacksonValue getUserInfo() {
        UserInfo userInfo = new UserInfo(1,"Venus", 32, 34567,"abcd12");
        String filterList = "name,age";
        return addMapping(userInfo, filterList);
    }

    @GetMapping("/filtered/users")
    public MappingJacksonValue getAllUserInfo() {
        List<UserInfo> usersInfo = Arrays.asList(new UserInfo(1, "Venus", 32, 34567, "abcd12"),
                new UserInfo(2,"Steffi",45,98756,"zyx98"));
        String filterList = "id,name,age";
        return addMapping(usersInfo,filterList);
    }

}
