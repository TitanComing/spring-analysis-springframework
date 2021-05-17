package org.peng.context.base;

import org.peng.context.base.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Create by peng on 2021/5/17.
 */
//@Component说明该类交由Spring托管
@Component
public class Cinema {
    //@Autowired告诉Spring在初始化Cinema类时会从Application Context中找到类型为MovieService的Bean，并赋值给Cinema
    @Autowired
    private MovieService movieService;

    public void printMovieName(){
        System.out.println(movieService.getMovieName());
    }
}
